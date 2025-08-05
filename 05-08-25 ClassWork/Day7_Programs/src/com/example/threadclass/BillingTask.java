package com.example.threadclass;


//OrderTask (Handles Synchronous Order Placement)
class OrderTask extends Thread {
 private final String userName;

 public OrderTask(String userName) {
     this.userName = userName;
 }

 @Override
 public void run() {
     System.out.println(userName + " is placing an order...");
     try {
         Thread.sleep(1000); // Simulate time to place order
     } catch (InterruptedException e) {
         System.out.println(userName + " was interrupted during order.");
     }
     System.out.println(userName + " completed order.");
 }
}

//BillingTask (Handles Asynchronous Billing + Notification)
public class BillingTask extends Thread {
 String userName;
 Object bill;

 public BillingTask(String userName, Object bill) {
     this.userName = userName;
     this.bill = bill;
 }

 @Override
 public void run() {
     synchronized (bill) {
         System.out.println("Billing started for " + userName);
         try {
             Thread.sleep(2000); // Simulate billing delay
         } catch (InterruptedException e) {
             System.out.println("Billing interrupted for " + userName);
         }
         System.out.println("Billing completed for " + userName);
         bill.notify(); // Notify corresponding notifier
     }
 }

 // Notifier for billing completion
 static class BillingNotifier extends Thread {
     BillingTask billingTask;

     public BillingNotifier(BillingTask billingTask) {
         this.billingTask = billingTask;
     }

     @Override
     public void run() {
         synchronized (billingTask.bill) {
             try {
                 billingTask.bill.wait(); // Wait until billing is done
             } catch (InterruptedException e) {
                 System.out.println("Notifier interrupted for " + billingTask.userName);
             }
             System.out.println("Notification: Billing done for " + billingTask.userName);
         }
     }
 }


 public static void main(String[] args) {
     System.out.println(" Synchronous Order Placement ");

     try {
         // Create order tasks
         OrderTask userA = new OrderTask("Rushitha");
         OrderTask userB = new OrderTask("Sri");
         OrderTask userC = new OrderTask("Divya");

         // Synchronous: Place orders in sequence using join()
         userA.start();
         userA.join();

         userB.start();
         userB.join();

         userC.start();
         userC.join();
     } catch (InterruptedException e) {
         System.out.println("Order sequence interrupted.");
     }

     System.out.println("\n Asynchronous Billing with Wait/Notify \n");

     // Create lock objects for each user
     Object billA = new Object();
     Object billB = new Object();
     Object billC = new Object();

     // Create billing tasks
     BillingTask billingA = new BillingTask("Rushitha", billA);
     BillingTask billingB = new BillingTask("Sri", billB);
     BillingTask billingC = new BillingTask("Divya", billC);

     // Create notifier threads
     BillingNotifier notifierA = new BillingNotifier(billingA);
     BillingNotifier notifierB = new BillingNotifier(billingB);
     BillingNotifier notifierC = new BillingNotifier(billingC);

     // Start all notifier threads first (they will wait)
     notifierA.start();
     notifierB.start();
     notifierC.start();

     // Start billing threads (they will notify)
     billingA.start();
     billingB.start();
     billingC.start();
 }
}











package com.example.threadclass;

class BillingSystem {

    private boolean isBilled = false;

    public synchronized void billUser(String user) {
        System.out.println("Billing started for " + user);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isBilled = true;
        System.out.println("Billing is completed for " + user);
        notify(); 
    }

    public synchronized void waitForBilling(String user) {
        while (!isBilled) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isBilled = false;
        System.out.println("Notification sent: Billing done for " + user);
    }
}

public class UserThread extends Thread {
    private String username;
    private BillingSystem billingSystem;

    public UserThread(String username, BillingSystem billingSystem) {
        super();
        this.username = username;
        this.billingSystem = billingSystem;
    }

    @Override
    public void run() {
        System.out.println(username + " is placing the order...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(username + " has placed the order");

        Thread billingThread = new Thread(() -> billingSystem.billUser(username));
        billingThread.start();

        billingSystem.waitForBilling(username);

        try {
            billingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BillingSystem billingSystem = new BillingSystem();

        System.out.println("Synchronous order ");

        UserThread userA = new UserThread("User-A", billingSystem);
        UserThread userB = new UserThread("User-B", billingSystem);
        UserThread userC = new UserThread("User-C", billingSystem);

        try {
            userA.start();
            userA.join();

            userB.start();
            userB.join();

            userC.start();
            userC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All users have completed their order and billings");
    }
}
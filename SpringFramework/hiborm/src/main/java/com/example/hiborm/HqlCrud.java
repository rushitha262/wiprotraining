package com.example.hiborm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.hiborm.model.Employee;
import com.example.hiborm.util.HibernateUtil;

public class HqlCrud {
		public static void main(String[] args)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			  Transaction tx;
			  
			  
			  //inserting the data
			  
			  tx=session.beginTransaction();
			  Employee emp= new Employee("gogineni","sri@gmail.com");
			  session.persist(emp);
			  tx.commit();
			  System.out.println("Inserted: " + emp);
			  
			  //reading the data
			  
			  tx = session.beginTransaction();
		      List<Employee> empList = session.createQuery("FROM Employee", Employee.class).getResultList();
		      empList.forEach(System.out::println);
		      tx.commit();
		      
//		      //update the data
		      
//		        tx = session.beginTransaction();
//		        session.createQuery("UPDATE Employee e SET e.email = :email WHERE e.id = :id")
//		                .setParameter("email", "srigogineni@outlook.com")
//		                .setParameter("id", emp.getId())
//		                .executeUpdate();
//		        tx.commit();
//		        System.out.println("Updated employee with ID " + emp.getId());

		        //deleting the data
		      
		        tx = session.beginTransaction();
		        session.createQuery("DELETE FROM Employee e WHERE e.id = :id")
		                .setParameter("id", emp.getId())
		                .executeUpdate();
		        tx.commit();
		        System.out.println("Deleted employee with ID " + emp.getId());

		        session.close();
		        HibernateUtil.close();



		}
}

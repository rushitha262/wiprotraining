package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Course;
import com.example.entity.Student;

import com.example.util.HibernateUtil;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// to obtain/get the session from sessionfactory (It can be multiple session based on multiple services or work)
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// To create a  transaction ( Transient + Persistent) -- Transient when you do not to reflect and save in backend  but persistent to save into a backend
	   Transaction tx = session.beginTransaction();
	   Student student =  new Student("gogineni");
	   Course c1 = new Course("jsp"); 
	   Course c2 = new Course("servlet");
	 
	   
	    
	   
	   }
}
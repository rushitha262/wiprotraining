package com.wipro;

import java.util.Scanner;

//concrete class
public class HelloWorld {
	//Entry point of java program
	//static is keyword which can be called by the compiler without any object
	//void: this method does not return the value
	//main: the name of methods recognized by the jvm as an entry point
	//String[]: String is a class and [] means an array so its an array of strings that can recieve
	public static void main(String[] args) {
	//is used to print output to the console the followed by a new line character
		//System is a class,out is a reference variable,println is method of PrintStream class
		//another reference variable of a system class is in and err
		System.out.println("Hello Java World");
		//to take input
		Scanner sc=new Scanner(System.in);
		//
		String var=sc.next();
		//to print errors
		System.err.print("Error in your program");
	}
}

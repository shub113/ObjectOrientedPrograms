package com.bridgeit.ObjectOrientedPrograms.programs;

import java.util.Scanner;

public class Patients
{
	int pid;
	String pname;
	int age;
	String mobile;

	//getter and setter methods
	public int getPid() 
	{
		return pid;
	}
	public void setPid(int pid) 
	{
		this.pid = pid;
	}

	public String getPname() 
	{
		return pname;
	}
	public void setPname(String pname) 
	{
		this.pname = pname;
	}

	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}
	//toString method
	public String toString() 
	{
		return "Patients [pid=" + pid + ", pname=" + pname + ", age=" + age + ", mobile=" + mobile + "]";
	}

	//method to add patients information
	public void addPatient()
	{
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter Your Details ...");

		System.out.println("Enter Name: ");
		this.pname=scan.next();
		System.out.println();

		System.out.println("Enter Id: ");
		this.pid=scan.nextInt();
		System.out.println();

		System.out.println("Enter Age: ");
		this.age=scan.nextInt();
		System.out.println();

		System.out.println("Enter Mobile Number: ");
		this.mobile=scan.next();
		System.out.println();
	}
}
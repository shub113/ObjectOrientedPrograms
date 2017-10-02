package com.bridgeit.ObjectOrientedPrograms.programs;

import java.util.Scanner;

public class Doctor 
{
	int did;
	String dname;
	String avail;
	String spec;

	
	//getter and setter methods
	public int getDid() 
	{
		return did;
	}
	public void setDid(int did) 
	{
		this.did = did;
	}
	public String getDname() 
	{
		return dname;
	}
	public void setDname(String dname) 
	{
		this.dname = dname;
	}
	public String getAvail() 
	{
		return avail;
	}
	public void setAvail(String avail) 
	{
		this.avail = avail;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) 
	{
		this.spec = spec;
	}
	//toString method
	public String toString() 
	{
		return "Doctor [did=" + did + ", dname=" + dname + ", avail=" + avail + ", spec=" + spec + "]";
	}
	//to add doctor details
	public void addDoctor()
	{
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter Your Details ...");

		System.out.println("Enter Name: ");
		this.dname=scan.next();
		System.out.println();

		System.out.println("Enter Id: ");
		this.did=scan.nextInt();
		System.out.println();

		System.out.println("Enter Specialization: ");
		this.spec=scan.next();
		System.out.println();

		System.out.println("Enter Availability (1:AM   2:PM  3:Both) :");
		this.avail=scan.next();
		System.out.println();
	}
}

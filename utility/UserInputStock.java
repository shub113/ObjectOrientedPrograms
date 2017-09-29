package com.bridgeit.ObjectOrientedPrograms.utility;



public class UserInputStock {
	private int num;
	private String name;
	private int share;
	private double price;
	private int totShare;
	private double totPrice;
	
	//set
	UserInputStock(String name,int share,double price){
		this.name= name;
		this.share= share;
		this.price= price;
		//this.totShare=totShare;
		//this.totPrice=totPrice;
	}
	public void set(int num){
		this.num=num;
	}
	
	//get
	public int getNum(){
		return num;
	}
	public String getName(){
		return name;
	}
	public int getShare(){
		return share;
	}
	public double getPrice(){
		return price;
	}
	public double getTotalPrice(){
		return totPrice;
	}
	public int getTotalShare(){
		return totShare;
	}
}

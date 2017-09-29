package com.bridgeit.ObjectOrientedPrograms.utility;


import java.util.ArrayList;
import java.util.Scanner;

public class StockLogic{
	Scanner scan= new Scanner(System.in);
	private int totShare;
	private double totPrice;
	
	public int stockNumber(){
		System.out.println("Enter number of Stocks");
		return scan.nextInt();
	}
	public void printMessage(){
		System.out.println("Enter Stock name/share/price");
	}
	public void input(int num){
		for(int i=1;i<=num;i++){
			UserInputStock ui= new UserInputStock(scan.next(),scan.nextInt(),scan.nextDouble());
			System.out.println("total value of stock = "+(ui.getShare()*ui.getPrice()));
			totShare +=ui.getShare();
			totPrice +=(ui.getShare()*ui.getPrice());
		}
		System.out.println("Total number of shares="+totShare);
		System.out.println("Total Stock Price = "+totPrice);
	}
	
}

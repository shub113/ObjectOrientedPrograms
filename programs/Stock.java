package com.bridgeit.ObjectOrientedPrograms.programs;

import com.bridgeit.ObjectOrientedPrograms.utility.StockLogic;

public class Stock {
	public static void main(String[]args){
		StockLogic stock= new StockLogic();
		
		int num=stock.stockNumber();
		
		stock.printMessage();
		stock.input(num);
	}
}

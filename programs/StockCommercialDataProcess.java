package com.bridgeit.ObjectOrientedPrograms.programs;

import java.util.Scanner;

import com.bridgeit.ObjectOrientedPrograms.utility.Utility;

/**
 * @author bridgeit
 *		File--- Stock.json
 */
public class StockCommercialDataProcess {
	
	public static void main(String []args) {
		
		Scanner scanner=new Scanner(System.in);
		try {
				System.out.println("You want a create account press \"y\" if you already have a account press \"n\": " );
				String accountChoice=scanner.next().toLowerCase();
				
				if(accountChoice.equals("y")) {
					System.out.println("Enter your name: ");
					String name=scanner.next();
					
					System.out.println("Add balance to your account : ");
					double balance=scanner.nextDouble();
					Utility.createAccount(name,balance);
					Utility.userAccount(0);
				}
				else{
						Utility.userAccount(0);
			    	}
				
				System.out.println("You want know the total account balance in your account press \"y\" if you don't want press  \"n\":  " );
				String balanceChoice=scanner.next().toLowerCase();
				if(balanceChoice.equals("y")){
					Utility.valueOf();
				}
				System.out.println("User Details is: ");
				Utility.printReport();
				
				
		} catch(Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
package com.bridgeit.ObjectOrientedPrograms.programs;
import java.io.File;
import java.util.Scanner;

import com.bridgeit.ObjectOrientedPrograms.utility.Utility;

/**
 * @author bridgeit
 *File--- Address.json
 */
public class AddressBook {
	
	public static void main(String [] args) {
		
	  	File file=new File("/home/bridgeit/Address.json");
		Scanner	scanner=new Scanner(System.in);

	  	boolean check=true;
	  	try {
			do {
				System.out.println(" 1.Add \n 2. edit \n 3.delete \n 4.sort \n 5.Person Details");
				System.out.println("Enter your choice: ");
				int choice=scanner.nextInt();
				
				switch(choice) {
								case 1 : Utility.addPerson(file);
										 break;
								case 2 : Utility.editPerson(file);
										 break;
								case 3 : Utility.deletePerson(file);
										 break;
								case 4 : Utility.sortDetails(file);
										 break;
								case 5 : Utility.personDetails(file);
								         break;			 
								default: System.out.println("Wrong choice: ");
								
				}
				System.out.println();
				System.out.println("You want continue again press \"Y\" else press \"N\"");
				String innerChoice=scanner.next().toLowerCase();
				if(innerChoice.equals("y")){
					check=true;
				} else {
					check=false;
				}
		} while(check);
	  	} catch(Exception ex) {
	  		System.out.println(ex);
	  		ex.printStackTrace();
	  	} finally {
	  		scanner.close();
	  	}
			
	}
}

package com.bridgeit.ObjectOrientedPrograms.programs;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.bridgeit.ObjectOrientedPrograms.utility.Regex;
import com.bridgeit.ObjectOrientedPrograms.utility.UserInputRegex;

/**
 * @author bridgeit
 *          reading text6
 *          output in text7
 */
public class RegularExpression {
	public static void main(String[]args) throws IOException{
		UserInputRegex ui = new UserInputRegex();
		Regex reg= new Regex();
		
		System.out.println("Enter ur first name");
		ui.setFname(reg.stringInput());
		
		System.out.println("Enter your Last Name");
		ui.setLname(reg.stringInput());
		
		System.out.println("Enter your phone Number");
		ui.setPhoneNum(reg.stringInput());
		
		String text= reg.readFile();
		
		text= reg.convertString(text, ui.getFname());
		text= reg.convertString(text, ui.getFname(), ui.getLname());
		text= reg.convertString(text, ui.getPhoneNum(), 1);
		ui.setDate();
		text= reg.convertString(text, ui.getDate(), 1.0);
		
		System.out.println(text);
		
		reg.writeFile(text);
	}
}

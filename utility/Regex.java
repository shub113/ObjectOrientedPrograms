package com.bridgeit.ObjectOrientedPrograms.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Scanner;

public class Regex {
	BufferedWriter bw;
	BufferedReader br;
	Scanner scan;
	//constructor to initialize buffer reader
		public Regex(){
			scan= new Scanner(System.in);
		}
	//file input
	public String readFile() throws IOException{
		br = new BufferedReader(new FileReader("/home/bridgeit/text6.txt"));
		String s;
		String text="";
		while((s=br.readLine())!= null){
			text+=s;
		}
		return text;
	}
	public void writeFile(String text) throws IOException{
		bw = new BufferedWriter(new FileWriter("/home/bridgeit/text7.txt"));
		bw.write(text);
		bw.flush();
		bw.close();
	}
	//string input
	public String stringInput(){
		String s1= scan.next();
		return s1;
	}
	public long longInput(){
		long l=scan.nextLong();
		return l;
	}
	//convert first name
	public String convertString(String text,String fname){
		Pattern p= Pattern.compile("<<name>>");
		Matcher m= p.matcher(text);
		text= m.replaceAll(fname);
		return text;
	}
	//overRidding above method for last name
	public String convertString(String text,String fname,String lname){
		Pattern p= Pattern.compile("<<full name>>");
		Matcher m= p.matcher(text);
		text= m.replaceAll(fname+" "+lname);
		return text;
	}
	//overRidding above method for phone number
	public String convertString(String text,String num, int a){
		Pattern p= Pattern.compile("xxxxxxxxxx");
		Matcher m= p.matcher(text);
		text= m.replaceAll(num);
		return text;
	}
	//overRidding above method for date
	public String convertString(String text,String date, double a){
		Pattern p= Pattern.compile("01/01/2016");
		Matcher m= p.matcher(text);
		text= m.replaceAll(date);
		return text;
	}
}

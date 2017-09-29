package com.bridgeit.ObjectOrientedPrograms.programs;

import org.json.simple.parser.ParseException;

import com.bridgeit.ObjectOrientedPrograms.utility.JsonReadWrite;

public class JSONExample {
	public static void main(String[]args) throws ParseException, Exception{
		JsonReadWrite json= new JsonReadWrite();
		json.ReadJFile("txt");
	}
}

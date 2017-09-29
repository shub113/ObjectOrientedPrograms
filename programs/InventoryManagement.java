package com.bridgeit.ObjectOrientedPrograms.programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * @author bridgeit
 * file used is txt.json
 */
public class InventoryManagement {
	public static void main(String[]args) throws IOException, ParseException{
		Scanner scan= new Scanner(System.in);

		JSONObject jobj2= new JSONObject();
		
		JSONArray jarr1= new JSONArray();
		JSONArray jarr2= new JSONArray();
		JSONArray jarr3= new JSONArray();
		
		jobj2.put("Rice", jarr1);
		jobj2.put("Wheat", jarr2);
		jobj2.put("Pulses", jarr3);
		//input for rice
		System.out.println("Enter number of input for rice");
		int rice= scan.nextInt();
		for(int i=0;i<rice;i++){
			JSONObject jobj3= new JSONObject();
			System.out.println("Enter rice"+(i+1)+" name");
			jobj3.put("name",scan.next());
			System.out.println("Enter  Weight");
			jobj3.put("weight", scan.nextInt());
			System.out.println("Enter price");
			jobj3.put("price", scan.nextInt());
			jarr1.add(jobj3);
		}
		//input for wheat
		System.out.println("Enter number of input for wheat");
		int wheat= scan.nextInt();
		for(int i=0;i<wheat;i++){
			JSONObject jobj3= new JSONObject();
			System.out.println("Enter wheat"+(i+1)+" name");
			jobj3.put("name",scan.next());
			System.out.println("Enter Weight");
			jobj3.put("weight", scan.nextInt());
			System.out.println("Enter price");
			jobj3.put("price", scan.nextInt());
			jarr2.add(jobj3);
		}
		//input for pulses
		System.out.println("Enter number of input for pulses");
		int pulses= scan.nextInt();
		for(int i=0;i<pulses;i++){
			JSONObject jobj3= new JSONObject();
			System.out.println("Enter pulses"+(i+1)+" name");
			jobj3.put("name",scan.next());
			System.out.println("Enter Weight");
			jobj3.put("weight", scan.nextInt());
			System.out.println("Enter price");
			jobj3.put("price", scan.nextInt());
			jarr3.add(jobj3);
		}
		//writing in file
		BufferedWriter bw= new BufferedWriter(new FileWriter("/home/bridgeit/txt.json"));
		bw.write(jobj2.toJSONString());
		bw.flush();
		bw.close();
		//reading from file
		JSONParser jp= new JSONParser();
		JSONObject obj= (JSONObject)jp.parse(new FileReader("/home/bridgeit/txt.json"));
		System.out.println(obj);
	}
}

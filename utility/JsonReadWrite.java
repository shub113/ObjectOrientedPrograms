package com.bridgeit.ObjectOrientedPrograms.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReadWrite {
	BufferedWriter bw;
	JSONObject obj= new JSONObject();
	JSONArray jar= new JSONArray();
	public void ReadJFile(String filename) throws Exception, ParseException{
		JSONParser jp= new JSONParser();
		JSONObject obj= (JSONObject)jp.parse(new FileReader("/home/bridgeit/"+filename+".json"));
		System.out.println(obj);
	}
	public void WriteFile(String filename,String string) throws Exception, ParseException {
		JSONParser jp= new JSONParser();
		JSONObject obj= (JSONObject)jp.parse(new FileReader("/home/bridgeit/"+filename+".json"));
		System.out.println(obj);
	}
}

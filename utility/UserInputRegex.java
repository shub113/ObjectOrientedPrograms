package com.bridgeit.ObjectOrientedPrograms.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserInputRegex {
		private String fname;
		private String lname;
		private String phonenum;
		private String date;
		
		public void setFname(String fname){
			this.fname= fname;
		}
		public void setLname(String lname){
			this.lname= lname;
		}
		public void setPhoneNum(String phonenum){
			this.phonenum= phonenum;
		}
		public void setDate(){
			java.util.Date dat= new java.util.Date();
			date= dat.toString();
		}
		public String getFname(){
			return this.fname;
		}
		public String getLname(){
			return this.lname;
		}
		public String getPhoneNum(){
			return phonenum;
		}
		public String getDate(){
			return date;
		}
}

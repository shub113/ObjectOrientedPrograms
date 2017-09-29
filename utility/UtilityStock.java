package com.bridgeit.ObjectOrientedPrograms.utility;



	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.Date;
	import java.util.Iterator;
	import java.util.Random;
	import java.util.Scanner;

	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.JSONValue;
	import org.json.simple.parser.JSONParser;
	import org.json.simple.parser.ParseException;

	public class UtilityStock{
		
		static String  userName;
		public static void readOnFile(File file) {
		
			try {
				
					FileReader fileReader=new FileReader(file);
					JSONParser parser=new JSONParser();
					JSONObject json=(JSONObject)parser.parse(fileReader);
			
					Iterator iterator = json.keySet().iterator(); 
					
					while(iterator.hasNext()) {
						
					    String outerKey = (String) iterator.next();
						JSONObject jsonObject=(JSONObject)json.get(outerKey);
						
						Iterator iterator1 = jsonObject.keySet().iterator(); 
						
						while(iterator1.hasNext()) {
							
							String key=(String) iterator1.next();
							System.out.println(key+" : "+jsonObject.get(key));
							
						 }
						System.out.println();
						System.out.println("The Toatal cost of "+jsonObject.get("Name")+" is: "
						+ Integer.parseInt(jsonObject.get("Price").toString()) *
						  Integer.parseInt(jsonObject.get("Weight").toString())  );
						System.out.println("*****************************************");

					 }
				
				} catch (IOException | ParseException e) {
						e.printStackTrace();
			     }
		}
		
		public static void writeOnFile(File file) {
			try {
					FileWriter fileWriter=new FileWriter(file);
					
					JSONObject products=new JSONObject();
					
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("Name", "Sona Masuri");
					jsonObject.put("Weight", 50);
					jsonObject.put("Price", 55);
					
					JSONObject jsonObject1=new JSONObject();
					jsonObject1.put("Name", "wheat101");
					jsonObject1.put("Weight", 50);
					jsonObject1.put("Price", 45);
					
					JSONObject jsonObject2=new JSONObject();
					jsonObject2.put("Name", "Moong dal");
					jsonObject2.put("Weight", 50);
					jsonObject2.put("Price", 150);
					
					
					products.put("Rice", jsonObject);
					products.put("Wheat", jsonObject1);
					products.put("Pulses", jsonObject2);
					//System.out.println(products);
					fileWriter.write(JSONValue.toJSONString(products));
					fileWriter.flush();
					fileWriter.close();
					
				
			} catch (IOException e) {
					e.printStackTrace();
				}
		}
		public static void finalString(String message, String name, String mobileNumber){
			String []arrayName=name.split(" ");
			message=message.replace("<<name>>", arrayName[0]);
			message=message.replace("<<full name>>", name);
			message=message.replace("xxxxxxxxxx", mobileNumber);
			
		    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		    Date dateobj = new Date();
		    String []today=df.format(dateobj).toString().split(" ");
		    message=message.replace("01/01/2016",today[0]);

			System.out.println(message);
		}
		static ArrayList<ArrayList<String>> stocs=new ArrayList<ArrayList<String>>();

		public static  ArrayList<ArrayList<String>> creatingStocks( String shareName, String numberOfShares, String sharePrice) {

			try {
				  ArrayList<String> stock=new ArrayList<String>();
				  stock.add(shareName);
				  stock.add(numberOfShares);
				  stock.add(sharePrice);
				  stocs.add(stock);
			} catch(Exception ex) {
				ex.getMessage();
			}
			return stocs;
		}
		public static void valueOfEachStock() {
			try {
				  for (ArrayList<String> value:stocs) {
			
					 System.out.println("*****************************************");
					 System.out.println("Share Name: "+value.get(0));
					 System.out.println("Number of shares are: "+value.get(1));
					 System.out.println("Share Price is: "+value.get(2));
					 System.out.println();
					 System.out.println(value.get(0)+" Stock value is: "+Integer.parseInt(value.get(1).toString())*Integer.parseInt(value.get(2).toString()));

				  }
			 } catch(Exception ex) {
				System.out.println(ex);		
			  }
		}
		public static void valueOfTotalStock() {
			int total=0;
			try{
				  for (ArrayList<String> value:stocs) {
				     total=total+Integer.parseInt(value.get(1))*Integer.parseInt(value.get(2));
				 }
					System.out.println("*****************************************");

				System.out.println("The total Stock Price is : "+total);
			} catch(Exception ex) {
				System.out.println(ex);
			 }
		}
		public static double valueOf() {
			FileReader fileReader=null;
			File file=new File("/home/bridgeit/Stock.json");

			try {
				fileReader=new FileReader(file);
				JSONParser parser=new JSONParser();
				JSONObject json=(JSONObject)parser.parse(fileReader);
				System.out.println("The account balance is: "+json.get("Balance"));
				 //}
				} catch ( IOException | ParseException e) {
				
					e.printStackTrace();
			}		
			return 1;
		}
		
		public static void buy(int amount, String symbol) {
			
			JSONObject object=null;
			JSONObject obj=null;
			JSONParser parser=null;
			FileReader fileReader=null;
			try {
				 fileReader=new FileReader(new File("/home/bridgeit/Stock.json"));
				 parser=new JSONParser();
				 object=(JSONObject) parser.parse(fileReader);
				 int numshare=0;
				 int finalShares=0;
				 Iterator itr=object.keySet().iterator();
				
				
				while(itr.hasNext()) {
					
					String key=(String) itr.next();
					obj=(JSONObject)object.get(key);
					
					if(key.equals(symbol)) {
						
						numshare=amount/Integer.parseInt(obj.get("SharePrice").toString());
						
						if(numshare<=Integer.parseInt(obj.get("NumberOfShares").toString())) {
							
							finalShares=Integer.parseInt(obj.get("NumberOfShares").toString())-numshare;
						
						} else {
							System.out.println("buying shares is not possible: ");
						}
					}	
				}
				String check="buy";
			//	System.out.println(finalShares);
				userAccountUpdated(numshare,amount,check);
				// saving sahre details in with new share values
				save(finalShares,symbol);
				
				
			} catch (  IOException | ParseException ex) {
				ex.printStackTrace();
				System.out.println("Exception is:"+ex);
			}
			
			}

		public static void sell(String symbol) {
			 JSONObject obj=null;
			 JSONParser parser=null;
			 JSONObject object=null;
			 Scanner scanner=null;
			 FileReader fileReader=null;
			try {
				 fileReader=new FileReader(new File("/home/bridgeit/Stock.json"));
				 parser=new JSONParser();
				 object=(JSONObject) parser.parse(fileReader);
				 
				 scanner=new Scanner(System.in);
				 System.out.println("number of shares: ");
				 int userNumber=scanner.nextInt();
				 
				 int amount=0;
				 int numShares=0;
				 Iterator itr=object.keySet().iterator();
				 
			   	 while(itr.hasNext()) {
					
					String key=(String) itr.next();
					obj=(JSONObject)object.get(key);
					
					if(key.equals(symbol)) {
						
						 amount=Integer.parseInt(obj.get("SharePrice").toString())*userNumber;
						 numShares=Integer.parseInt(obj.get("NumberOfShares").toString())+userNumber;
					}
				
				}
			   	 String check="sell";
			   	 save(numShares,symbol);
			   	 userAccountUpdated(userNumber,amount,check);
			//System.out.println(numShares);
			
			} catch (IOException | ParseException ex) {

				ex.printStackTrace();
				System.out.println("Exception is:"+ex);
			}
				
		}
		
		public static void userAccountUpdated(int numShares, int amount, String check) {
			JSONObject object=null;
			FileReader fileReader=null;
			FileWriter fileWriter=null;
			File file=new File("/home/bridgeit/Stock.json");

			try {
				fileReader=new FileReader(file);
				JSONParser parser=new JSONParser();
				 object=(JSONObject) parser.parse(fileReader); 
					 if(check.equals("sell")) {
						if(object.get("Name").equals(userName)){
							int finalShares=Integer.parseInt(object.get("NumberOfShares").toString())-numShares;

							object.remove("NumberOfShares");
							object.put("NumberOfShares", finalShares);
							double finalAmount=Double.parseDouble(object.get("Balance").toString())+amount;
							object.remove("Balance");
							object.put("Balance", finalAmount);
						}
					 } if(check.equals("buy")) {
						 if(object.get("Name").equals(userName)){
								int finalShares=Integer.parseInt(object.get("NumberOfShares").toString())+numShares;

								object.remove("NumberOfShares");
								object.put("NumberOfShares", finalShares);
								double finalAmount=Double.parseDouble(object.get("Balance").toString())-amount;
								object.remove("Balance");
								object.put("Balance", finalAmount);
							}
					 }
						fileWriter =new FileWriter(file);
						fileWriter.write(JSONValue.toJSONString(object));
						fileWriter.flush();
						
						System.out.println("User Account is updated succesfully: ");
					
			}catch(Exception ex){
				System.out.println(ex);
			}
			 
		}
		public static void save(int numShares,String symbol) {
			FileReader fileReader=null;
			FileWriter fileWriter=null;
			try {
				fileReader=new FileReader(new File("/home/bridgeit/Stock.json"));
				JSONParser parser1=new JSONParser();
				JSONObject json=(JSONObject) parser1.parse(fileReader);
				
				try {
	                 Iterator iterator1 = json.keySet().iterator(); 
					
					 while(iterator1.hasNext()) {
						
						String key1=(String) iterator1.next();
						JSONObject obj=(JSONObject)json.get(key1);

						if(key1.equals(symbol)){
							obj.remove("NumberOfShares");
							obj.put("NumberOfShares", numShares);
							
							}
						}
					fileWriter =new FileWriter(new File("/home/bridgeit/Stock.json"));
					fileWriter.write(JSONValue.toJSONString(json));
					fileWriter.flush();
					
					System.out.println("Shares Account is udated succesfully: ");

				} catch (IOException ex) {
					ex.printStackTrace();
					System.out.println("Exception is:"+ex);

				} 
			}catch(Exception ex){
				System.out.println(ex);
				ex.printStackTrace();
			}
		}

		public static void printReport() {
			JSONParser parser=null;
			JSONObject object=null;
			FileReader fileReader=null;

			File file=new File("/home/bridgeit/Stock.json");

			try {
				 fileReader=new FileReader(file);
				 parser=new JSONParser();
				 object=(JSONObject) parser.parse(fileReader);
				 Iterator itr=object.keySet().iterator();
				 while(itr.hasNext()) {
					
					 String key=(String) itr.next();
					 System.out.println(key+" : "+object.get(key));
				}
			} catch(Exception ex) {
				System.out.println(ex);
				ex.printStackTrace();
			}
		}
	   
		public static void createAccount(String name, double balance) {
			FileWriter fileWriter=null;
			File file=new File("/home/bridgeit/Stock.json");

			JSONObject json=new JSONObject();
			json.put("Name", name);
			json.put("Balance", balance);
			json.put("NumberOfShares", 1000);
			
			try {
				  fileWriter =new FileWriter(file);
				  fileWriter.write(JSONValue.toJSONString(json));
				  fileWriter.flush();
				  System.out.println("Account is created succesfully: ");

			} catch (IOException ex) {
				System.out.println("Exception is: "+ex);
				ex.printStackTrace();
			} 
		}
	    
	    public static void userAccount(int num) {
	    	  JSONParser parser=null;
	    	  JSONObject object=null;
	    	  FileReader fileReader=null;
	  		  File file=new File("/home/bridgeit/Stock.json");

	    	  try {
		    	
	    		  fileReader=new FileReader(file);
				  parser=new JSONParser();
				  object=(JSONObject) parser.parse(fileReader);
				  Scanner  scanner=new Scanner(System.in);

				  System.out.println("Enter User Name: ");
				    userName=scanner.nextLine();
				
				  if(object.get("Name").equals(userName)) {
							
					System.out.println("Enter share symbol want to buy  [!,@,#]: ");
					String symbol=scanner.next();
					System.out.println("For buying shares pres -b or  For selling shares press- s");
					String choice=scanner.next().toLowerCase();
					
					if(choice.equals("b")) {
						System.out.println("Enter your amount to buy shares: ");
						int amount=scanner.nextInt();
						//calling buy method
						buy(amount,symbol);
					} else { 
						//calling sell method
						  sell(symbol);
					}
					
				 } else {
					System.out.println("Enter wrong choice: ");
				 }
			
						
			} catch(Exception ex) {
				System.out.println(ex);
			}
		}
	    static JSONArray stockJsonArray=new JSONArray();
	  	public static void creatingStocksInventor(String shareName, String numberOfShares, String sharePrice) {
	  		JSONObject shareObject=new JSONObject();
	  		shareObject.put("shareName", shareName);
	  		shareObject.put("numberOfShares", numberOfShares);
	  		shareObject.put("sharePrice", sharePrice);
	  		stockJsonArray.add(shareObject );
	  	}
	  	public static void writeOnFile() {
	  		File file=new File("/home/bridgeit/Stock.json");

	  		try {
	  				FileWriter fileWriter=new FileWriter(file);
	  				fileWriter.write(JSONValue.toJSONString(stockJsonArray));
	  				fileWriter.flush();
	  				fileWriter.close();
	  		} catch(Exception ex) {
	  			System.out.println(ex);
	  		} 
	  	}
	  	public static void valueOfEachStockInventor() {
	  		File file=new File("/home/bridgeit/Stock.json");

	  		try {
	  			
	  			FileReader fileReader=new FileReader(file);
	  			JSONParser parser=new JSONParser();
	  			JSONObject json=(JSONObject)parser.parse(fileReader);
	  	
	  			Iterator iterator = json.keySet().iterator(); 
	  			
	  			while(iterator.hasNext()) {
	  				
	  			    String outerKey = (String) iterator.next();
	  				JSONObject jsonObject=(JSONObject)json.get(outerKey);
	  				
	  				Iterator iterator1 = jsonObject.keySet().iterator(); 
	  				System.out.println("*****************************************");

	  				while(iterator1.hasNext()) {
	  					
	  					String key=(String) iterator1.next();
	  					System.out.println(key+" : "+jsonObject.get(key));
	  					
	  				}
	  				System.out.println("The Toatal cost of "+jsonObject.get("shareName")+" is: "
	  						+ Integer.parseInt(jsonObject.get("numberOfShares").toString()) *
	  						  Integer.parseInt(jsonObject.get("sharePrice").toString())  );
	  						//System.out.println("*****************************************");

	  					 
	  			}
	  		} catch (IOException | ParseException e) {
	  						e.printStackTrace();
	  	     }
	  		
	  	}

	  	public static void valueOfTotalStockInventor() {
	  		File file=new File("/home/bridgeit/Stock.json");

	  		try {
	  			
	  				FileReader fileReader=new FileReader(file);
	  				JSONParser parser=new JSONParser();
	  				JSONObject json=(JSONObject)parser.parse(fileReader);
	  				int total=0;
	  				Iterator iterator = json.keySet().iterator(); 
	  			
	  				while(iterator.hasNext()) {
	  				
	  					String outerKey = (String) iterator.next();
	  					JSONObject jsonObject=(JSONObject)json.get(outerKey);				
	  					total=total+ Integer.parseInt(jsonObject.get("numberOfShares").toString()) *
	  						  Integer.parseInt(jsonObject.get("sharePrice").toString())  ;
	  						
	  				}
	  				System.out.println("*****************************************");
	  				System.out.println("The Total Stock price is : "+total);
	  		} catch (IOException | ParseException e) {
	  						
	  			e.printStackTrace();
	  	     }
	  		
	  	}
				    
		public static void addPerson(File file) {
					Scanner scanner=null;
					FileWriter fileWriter=null;
					FileReader fileReader=null;
					
					scanner=new Scanner(System.in);
					try {
					System.out.println("Enter Your First Name: ");
					String userFirstName=scanner.nextLine();
					
					System.out.println("Enter your Last Name: ");
					String userLastName=scanner.nextLine();
					
					System.out.println("Enter your Address: ");
					String userAddress=scanner.nextLine();
					
					System.out.println("Enter your City: ");
					String userCity=scanner.nextLine();
					
					System.out.println("Enter your State: ");
					String userState=scanner.nextLine();
					
					System.out.println("Enter your ZIP: ");
					int userZIP=scanner.nextInt();
					
					System.out.println("Enter your Mobile No: ");
					long userMobileNumber=scanner.nextLong();
					
					fileReader=new FileReader(file);
					JSONParser parser=new JSONParser();
					JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
					//JSONArray jsonArray=new JSONArray();
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("FirstName",userFirstName);
					jsonObject.put("LastName", userLastName);
					jsonObject.put("Address", userAddress);
					jsonObject.put("City", userCity);
					jsonObject.put("State", userState);
					jsonObject.put("Zip", userZIP);
					jsonObject.put("MobileNumber", userMobileNumber);
					jsonArray.add(jsonObject);
					try {
						fileWriter=new FileWriter(file);
						fileWriter.write(JSONValue.toJSONString(jsonArray));
						fileWriter.flush();
						fileWriter.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}

		public static void editPerson(File file) {
					
			Scanner scanner=null;
			FileWriter fileWriter=null;
			FileReader fileReader=null;
					
			scanner=new Scanner(System.in);
			System.out.println("Enter name you want edit: ");
			
			try {
				    String userEntry=scanner.nextLine();
					fileReader=new FileReader(file);
					JSONParser parser=new JSONParser();
					JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
					Iterator iterator=jsonArray.iterator();
						
					while(iterator.hasNext()) {
							
				        int key=(int) iterator.next();
						JSONObject jsonObject= (JSONObject) jsonArray.get(key);
						
						if(jsonObject.get("FirstName").equals(userEntry)) {
							
							System.out.println("Select what you want to edit: \n 1. Address \n2. City \n 3. State \n 4. ZIP \n 5. Mobile Number \n 6. Edit All ");
							int choice=scanner.nextInt();
							
							switch(choice){
								
								case 1:	 System.out.println("Enter your Address: ");
										 String userAddress=scanner.next();
											
										 jsonObject.remove("Address");
										 jsonObject.put("Address", userAddress);
											
											break;
								
								case 2 : System.out.println("Enter your City: ");
										 String userCity=scanner.nextLine();
										 jsonObject.remove("City");
										 jsonObject.put("City", userCity);

										 break;
										 
								case 3 : System.out.println("Enter your State: ");
										 String userState=scanner.nextLine();
										 jsonObject.remove("State");
										 jsonObject.put("State", userState);
										 break;
										 
								case 4 : System.out.println("Enter your ZIP: ");
										 int userZIP=scanner.nextInt();
										 jsonObject.remove("Zip");
										 jsonObject.put("Zip", userZIP);

										 break;
										 
								case 5 : System.out.println("Enter your Mobile No: ");
										 long userMobileNumber=scanner.nextLong();
										 jsonObject.remove("MobileNumber");
										 jsonObject.put("MobileNumber", userMobileNumber);

										 break;
										 
								case 6 : System.out.println("Enter your Address: ");
										 String userAddress1=scanner.nextLine();
								
										 System.out.println("Enter your City: ");
										 String userCity1=scanner.nextLine();
								
										 System.out.println("Enter your State: ");
										 String userState1=scanner.nextLine();
								
										 System.out.println("Enter your ZIP: ");
										 int userZIP1=scanner.nextInt();
								
										 System.out.println("Enter your Mobile No: ");
										 long userMobileNumber1=scanner.nextLong();	
										 
										 jsonObject.put("Address", userAddress1);
										 jsonObject.put("City", userCity1);
										 jsonObject.put("State", userState1);
										 jsonObject.put("Zip", userZIP1);
										 jsonObject.put("MobileNumber", userMobileNumber1);
										 
										 break;
										 
								default:
									System.out.println("Wrong choice: ");
							}
							
							jsonArray.remove(key);
							jsonArray.add(jsonObject);
							
							fileWriter=new FileWriter(file);
							fileWriter.write(JSONValue.toJSONString(jsonArray));
							fileWriter.flush();
							fileWriter.close();
							System.out.println("Edited");
						} else {
							System.out.println("User does not exist");
						 }
					}
	     	} catch ( IOException | org.json.simple.parser.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						scanner.close();
					}
					
				}

		public static void deletePerson(File file) {
			Scanner scanner=null;
			FileWriter fileWriter=null;
			FileReader fileReader=null;
						
			scanner=new Scanner(System.in);
			System.out.println("Enter name you want delete: ");
			try {
				    String userEntry=scanner.nextLine();
					fileReader=new FileReader(file);
					JSONParser parser=new JSONParser();
					JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
					Iterator iterator=jsonArray.iterator();
							
				    while(iterator.hasNext()) {
								
						JSONObject jsonObject= (JSONObject) iterator.next();
								
						if(jsonObject.get("FirstName").equals(userEntry)) {
								
							jsonArray.remove(0);
							fileWriter=new FileWriter(file);
							fileWriter.write(JSONValue.toJSONString(jsonArray));
							fileWriter.flush();
							fileWriter.close();
							System.out.println("Deleted");
						} else {
								System.out.println("User not exist: ");
						}
					}
			} catch ( IOException | org.json.simple.parser.ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
			} finally {
				scanner.close();
			}
		}

		public static void sortDetails(File file) {
					
			class AddressComparator implements Comparator<Object> {
				@Override
				public int compare(Object o1, Object o2) {

					JSONObject json1=(JSONObject)o1;  
					JSONObject json2=(JSONObject)o2;  
							  
						return (json1.get("Address").toString()).compareTo(json2.get("Address").toString());
				}
			}	
			class CityComparator implements Comparator<Object> {

				@Override
				public int compare(Object o1, Object o2) {
				JSONObject json1=(JSONObject)o1;  
				JSONObject json2=(JSONObject)o2;  
							  
				return (json1.get("City").toString()).compareTo(json2.get("City").toString());
				}

			}
			class LastNameComparator implements Comparator<Object> {

				@Override
				 public int compare(Object o1, Object o2) {
					 JSONObject json1=(JSONObject)o1;  
					 JSONObject json2=(JSONObject)o2;  
								  
					return (json1.get("LastName").toString()).compareTo(json2.get("LastName").toString());
				}

			}
			class MobileNumberComparator implements Comparator<Object> {

				 @Override
				 public int compare(Object o1, Object o2) {
					JSONObject json1=(JSONObject)o1;  
					JSONObject json2=(JSONObject)o2;  
								  
					return (json1.get("MobileNumber").toString()).compareTo(json2.get("MobileNumber").toString());
				}

			}	 
			class NameComparator implements Comparator<Object> {

				@Override
				public int compare(Object o1, Object o2) {
					JSONObject json1=(JSONObject)o1;  
					JSONObject json2=(JSONObject)o2;  
								  
					return (json1.get("FirstName").toString()).compareTo(json2.get("FirstName").toString());
				}

			}
			class StateComparator implements Comparator<Object> {

				 @Override
				 public int compare(Object o1, Object o2) {
					 JSONObject json1=(JSONObject)o1;  
					 JSONObject json2=(JSONObject)o2;  
								  
					 return (json1.get("State").toString()).compareTo(json2.get("State").toString());
					}

			}		 
			class ZipComparator implements Comparator<Object> {

				 @Override
				 public int compare(Object o1, Object o2) {
					 JSONObject json1=(JSONObject)o1;  
					 JSONObject json2=(JSONObject)o2;  
								  
					return (json1.get("Zip").toString()).compareTo(json2.get("Zip").toString());
				}

			}

			FileReader fileReader=null;
			Scanner scanner=new Scanner(System.in);
			
			try {
					fileReader=new FileReader(file);
					JSONParser parser=new JSONParser();
					JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
						
					boolean check=true;
					do {
						    System.out.println("Sort according to \n 1.First Name1 \n 2.Last Name \n 3. Address \n 4.City \n 5.State \n 6.Zip \n 7.Mobile Number  ");
							int choice=scanner.nextInt();
							switch(choice) {
									case 1 : 
										     System.out.println("Sorting according to First Names: ");
									
											 Collections.sort(jsonArray,new NameComparator());
					
											 Iterator nameIterator=jsonArray.iterator(); 
											 
											 while(nameIterator.hasNext()) {  
												 JSONObject json=(JSONObject)nameIterator.next();  
												 System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
													   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")		
														 );
											 	}  
											 break;
											 
									 case 2 : //Last Name sorting
									         System.out.println("Sorting according to Last Names: ");

											 Collections.sort(jsonArray,new LastNameComparator());
										
											 Iterator lastNameIterator=jsonArray.iterator();  
										
											 while(lastNameIterator.hasNext()){  
											
												 JSONObject json=(JSONObject)lastNameIterator.next();  
												 System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
														   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
													);
											 }  		 
											 break;
									 case 3: // Address sorting
										 		System.out.println("Sorting according to Address : ");
							
												Collections.sort(jsonArray,new AddressComparator());
													
												Iterator addressIterator=jsonArray.iterator();  
												while(addressIterator.hasNext()){  
													JSONObject json=(JSONObject)addressIterator.next();  
													System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
																   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
														);
												}
												break;
									
								 	case 4: //City sorting
								 				System.out.println("Sorting according to City : ");
							
												Collections.sort(jsonArray,new CityComparator());
												
												Iterator cityIterator=jsonArray.iterator();  
												while(cityIterator.hasNext()){  
													JSONObject json=(JSONObject)cityIterator.next();  
													System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
																   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
														);
												}
												break;
										
									 case 5: //State Sorting
							 					System.out.println("Sorting according to State : ");
		 					
												Collections.sort(jsonArray,new StateComparator());
												
												Iterator stateIterator=jsonArray.iterator();  
												while(stateIterator.hasNext()){  
													JSONObject json=(JSONObject)stateIterator.next();  
													System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
																   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
														);
												}
												break;
									 case 6: //Zip sorting
						 						System.out.println("Sorting according to Zip : ");
							
												Collections.sort(jsonArray,new ZipComparator());
												
												Iterator zipIterator=jsonArray.iterator();  
												while(zipIterator.hasNext()){  
													JSONObject json=(JSONObject)zipIterator.next();  
													System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
																   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
														);
												}
												break;
									 case 7: // Mobile number sorting
					 							System.out.println("Sorting according to Mobile number : ");
					 						
												Collections.sort(jsonArray,new MobileNumberComparator());
												
												Iterator mobileNumberIterator=jsonArray.iterator();  
												while(mobileNumberIterator.hasNext()){  
													JSONObject json=(JSONObject)mobileNumberIterator.next();  
													System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
																   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
														);
												}
												
												break;
									 default:
										 		System.out.println("Wrong Choice :");
										 		
							}
							System.out.println("you want try again press\"Y\" else press \"N\" ");
							String ch=scanner.next().toLowerCase();
							if(ch.equals("y")) {
								check=true;
							} else {
								check=false;
							}
						}while(check);
						
					} catch ( IOException |  org.json.simple.parser.ParseException e) {
						
						e.printStackTrace();
					} finally {
						scanner.close();
					}
					
				}

		public static void personDetails(File file) {
			FileReader fileReader=null;
			Scanner scanner=new Scanner(System.in);

			try {
				 	System.out.println("Enter a name want to search : ");
					String userName=scanner.nextLine();
						
					fileReader=new FileReader(file);
					JSONParser parser=new JSONParser();
					JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
					Iterator iterator=jsonArray.iterator();
						
					while(iterator.hasNext()) {
							
						 JSONObject jsonObject= (JSONObject) iterator.next();
						 if (jsonObject.get("FirstName").equals(userName)) {
								 
							 Iterator iterator1=  jsonObject.keySet().iterator();
							 while(iterator1.hasNext()) {
									 
								 String jsonKey=(String) iterator1.next();
						    	
								 System.out.println(jsonKey+" :" +jsonObject.get(jsonKey));
								 }
							 }
						 }
					 } catch ( IOException |  org.json.simple.parser.ParseException e) {
						e.printStackTrace();
					} finally {
						scanner.close();
					}
					
				}
		
	}

package com.teter;
import static utils.CustomerUtils.displayCountOfMonthlyCustomers;
import static utils.CustomerUtils.displayCustomerInAkurdi;
import static utils.CustomerUtils.displayCustomers;
import static utils.CustomerUtils.displayCustomersInJan;
import static utils.CustomerUtils.signIn;
import static utils.CustomerUtils.sortByFirstName;
import static utils.CustomerUtils.sortByPlan;
import static utils.DatePopulation.populateCustomerList;
import static utils.validationRules.validateAllInputs;
import static utils.CustomerUtils.modifyFirstName;
import static utils.CustomerUtils.discountForYearlyCustomers;
import static utils.CustomerUtils.changePassword;
import static utils.CustomerUtils.sortByRegistrationDate;
import static utils.CustomerUtils.unSubscribeCustomer;
import static utils.CustomerIO.getData;
import static utils.CustomerIO.restoreDataFromBin;
import static utils.CustomerIO.storeData;
import static utils.CustomerIO.storeDataInBin;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import com.code.Customer;

import Custom_Exception.CustomerCustomException;

public class Monthly_Mess_System {

	public static void main(String[] args) throws CustomerCustomException {
		int ch;
		Map<String,Customer>CustomerMap= populateCustomerList();
	try(Scanner sc = new Scanner(System.in)){
		System.out.println("Enter your choice : ");
		
		do  {
		System.out.println(""
				+ "\n 1.sign up\n "
				+ "2.sign in\n "
				+ "3.change password\n "
				+ "4.sort customers as per first name\n "
				+ "5.sort customers as per plan\n "
				+ "6.sort customers as per date of registration\n "
				+ "7.unsubscribe customer according to plan duration\n "
				+ "8.Display customer list\n "
				+ "9.modify all customer's first name (first alphabet should be capital)\n "
				+ "10.Display email addresses of the customers who did registration in month of January\n"
				+ "11.Display count of the Customers who have register for plan: Monthly\n "
				+ "12.Search the Customer who lived in Akurdi\n "
		        + "13.Give the 20% discount to the customers who have selected plan for 1 year\n"
		        + "14.Store data into a file\n"
		        + "15.re-store data from file\n"
		        + "16.Store data into a file in binary form\n"
		        + "17.re-Store data from a binary filen\n");
		ch=sc.nextInt();
		try {
		switch(ch) {
		case 1 :
			 System.out.println("sign up ");
			 System.out.println("Enter details of customer : ");
			 System.out.println("firstName, lastname, email, password, address, registrationDate, phoneNnumber, plan,final Amount");
			 Customer customer =validateAllInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt()),sc.next(),sc.next(),sc.nextDouble(),CustomerMap);
			 CustomerMap.put(customer.getEmail(), customer);
			 System.out.println("Customer logged in successfully!!");
			 break;
			
		case 2 :
			System.out.println("sign in ");
			System.out.println("Enter your email Id and password");
			signIn(sc.next(),sc.next(),CustomerMap);
			System.out.println("Signed in successfully");
			break;
		
		case 3 : 
			System.out.println("change password");
			System.out.println("Enter your email Id and old password and new password ");
			changePassword(sc.next(),sc.next(),sc.next(),CustomerMap);
			System.out.println("Password changed successfully!!");
			break;
			
		case 4 : 
			System.out.println("sort customers as per first name");
			sortByFirstName(CustomerMap);
			break;
		
		case 5 :
			System.out.println("sort customers as per plan");
			sortByPlan(CustomerMap);
			break;
			
		case 6 : 
			System.out.println("sort customers as per date of registration");
			sortByRegistrationDate(CustomerMap);
			break;
			
		case 7 :
			System.out.println("unsubscribe customer according to plan duration");
			System.out.println("Enter email and password of customer you want to unsubscribe : ");
		    unSubscribeCustomer(CustomerMap);
			break;
		
			
		case 8 :
			System.out.println("Display customer list");
			displayCustomers(CustomerMap);
			break;
			
		case 9 :
			System.out.println("modify all customer's first name (first alphabet should be capital)");
			modifyFirstName(CustomerMap);
			break;
			
		case 10 : 
			System.out.println("Display email addresses of the customers who did registration in month of January");
			displayCustomersInJan(CustomerMap);
			break;
		
		case 11 :
			System.out.println("Display count of the Customers who have register for plan: Monthly");
			displayCountOfMonthlyCustomers(CustomerMap);
			break;
			
		case 12 : 
			System.out.println("Search the Customer who lived in Akurdi");
			displayCustomerInAkurdi(CustomerMap);
			break;
			
		case 13 :
			System.out.println("Give the 20% discount to the customers who have selected plan for 1 year");
			discountForYearlyCustomers(CustomerMap);
			break;
		case 14:
			System.out.println("Store data into a file");
			System.out.println("Enter file name :");
			storeData(sc.next(),CustomerMap);
			break;
		case 15 :
			System.out.println("get data from file");
			System.out.println("Enter file name :");
			getData(sc.next());
			break;
		case 16 :
			System.out.println("Store data into a file in form of binary");
			System.out.println("Enter file name :");
			storeDataInBin(sc.next(),CustomerMap);
			break;
		case 17 :
			System.out.println("get data from binary file ");
			System.out.println("Enter file name : ");
			restoreDataFromBin(sc.next());
			break;
			
		}
		}catch(Exception e) {
		e.getMessage();	
		}
		}while(ch!=0);
	}
}	
}

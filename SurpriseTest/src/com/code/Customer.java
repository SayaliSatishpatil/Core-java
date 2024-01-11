package com.code;

import java.io.Serializable;
import java.time.LocalDate;

import Custom_Exception.CustomerCustomException;

public class Customer implements Serializable{
//Customer id(int) , first name(String), last name (String), email(String), password(String), 
//Address String, RegisterDate(LocalDate), planEndDate(LocalDate), Address(String), Phone No(String),
//plan Enum, final_amount double
	
//data variable declaration
private int cudtomerId;
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public void setFinal_Amount(double final_Amount) {
	this.final_Amount = final_Amount;
}


private String firstName;
private String lastname;
private String email;
private String password;
private String address;
private LocalDate registrationDate;
private LocalDate planEndDate;
private String phoneNnumber;
private MessPlan plan;
private double final_Amount;
private static int idGenerator;
private boolean isSubscribed;
static {
	idGenerator=100;
}

//constructor for email
public Customer(String email) {
	this.email=email;
}

public Customer( String firstName, String lastname, String email, String password, String address,
		LocalDate registrationDate, String phoneNnumber, MessPlan plan, double final_Amount) {
	super();
	this.firstName = firstName;
	this.lastname = lastname;
	this.email = email;
	this.password = password;
	this.address = address;
	this.registrationDate = registrationDate;
	this.phoneNnumber = phoneNnumber;
	this.plan = plan;
	this.planEndDate=calculatePlanEndDate(registrationDate,plan);
	this.final_Amount = final_Amount;
	this.cudtomerId=idGenerator+1;
	this.isSubscribed=true;
	idGenerator++;
}
//calculating end date according to registration date and plan
public static LocalDate calculatePlanEndDate(LocalDate regDate , MessPlan newPlan) {
	if(newPlan.equals(MessPlan.MONTHLY))
		return regDate.plusMonths(1);
	if(newPlan.equals(MessPlan.HALF_YEAR))
		return regDate.plusMonths(6);
	if (newPlan.equals(MessPlan.QUARTERLY))
		return regDate.plusMonths(4);
	if (newPlan.equals(MessPlan.YEARLY))
		return regDate.plusYears(1);
	return null;
}

//getters and setters
public int getCudtomerId() {
	return cudtomerId;
}
public String getFirstName() {
	return firstName;
}
public String getLastname() {
	return lastname;
}
public String getEmail() {
	return email;
}
public String getPassword() {
	return password;
}
public String getAddress() {
	return address;
}
public LocalDate getRegistrationDate() {
	return registrationDate;
}
public LocalDate getPlanEndDate() {
	return planEndDate;
}
public String getPhoneNnumber() {
	return phoneNnumber;
}
public MessPlan getPlan() {
	return plan;
}
public double getFinal_Amount() {
	return final_Amount;
}

@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer) {
		return this.email.equals(((Customer) obj).email);
	}
		return false;
		}


//toString to print data 
@Override
public String toString() {
	return "Customer [cudtomerId=" + cudtomerId + ", firstName=" + firstName + ", lastname=" + lastname + ", email="
			+ email + ", password=" + password + ", address=" + address + ", registrationDate=" + registrationDate
			+ ", planEndDate=" + planEndDate + ", phoneNnumber=" + phoneNnumber + ", plan=" + plan + ", final_Amount="
			+ final_Amount + " Status=" + isSubscribed + "\n]";
}


}

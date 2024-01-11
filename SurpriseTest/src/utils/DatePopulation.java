package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import com.code.Customer;
import com.code.MessPlan;
import com.code.MessPlan.*;

import Custom_Exception.CustomerCustomException;

public class DatePopulation {
	
	public static Map<String,Customer> populateCustomerList() throws CustomerCustomException{
		Map<String,Customer>customerData= new HashMap<>();
		customerData.put("sayalipatil@gmail",new Customer("sayali","patil","sayalipatil@gmail","sayali123","akurdi",LocalDate.of(2023, 05, 05),"9860299161",MessPlan.YEARLY,32000));
		customerData.put("pradnyapatil@gmail",new Customer("pradnya","patil","pradnyapatil@gmail","pradnya123","satara",LocalDate.of(2023, 05, 05),"1234567890",MessPlan.HALF_YEAR,17500));
		customerData.put("prachiAgrawal@gmail",new Customer("prachi","Agrawal","prachiAgrawal@gmail","prachi123","jalgaon",LocalDate.of(2023, 10, 05),"0987654321",MessPlan.QUARTERLY,11700));
		customerData.put("poojataur@gmail",new Customer("pooja","taur","poojataur@gmail","pooja123","beed",LocalDate.of(2023, 10, 12),"7652875356",MessPlan.MONTHLY,3000));
		customerData.put("divyapatil@gmail",new Customer("divya","patil","divyapatil@gmail","divya123","miraj",LocalDate.of(2023, 05, 23),"8357865498",MessPlan.MONTHLY,3000));
		customerData.put("ankitaAusekar@gmail",new Customer("Ankita","Ausekar","ankitaAusekar@gmail","ankita123","osmanabad",LocalDate.of(2023, 01, 30),"6528763234",MessPlan.YEARLY,32000));
		return customerData;
	}

}
//MONTHLY(3000),QUARTERLY(11700),HALF_YEAR(17500),YEARLY(32000);
package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Map;

import com.code.Customer;

public class CustomerIO {

	public static void storeData(String fileName , Map<String,Customer>custMap) throws IOException {
		try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
			custMap.values().stream()
			.forEach(pw::println);
		}
	}
	
	public static void getData(String fileName) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			br.lines()
			.forEach(p->System.out.println(p));
			
		}
	}
	
	public static void storeDataInBin(String fileName, Map<String,Customer>map) throws FileNotFoundException, IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
			out.writeObject(map);
		}
	}
	
	public static void restoreDataFromBin(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
			System.out.println(in.readObject());
		}
		
	}
}
    
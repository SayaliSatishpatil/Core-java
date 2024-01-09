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
import java.util.List;

import com.code.Doctor;

public class IOUtils {

	public static void storeDetails(String fileName,List<Doctor>list) throws IOException{
		try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
			list.stream().forEach(pw::println);
		}
	}
	
	public static void reStoreDetails(String fileName , List<Doctor>list) throws FileNotFoundException, IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			br.lines()
			.forEach(System.out::println);
		}
	}
	
	
	public static void storeDetailsInBinary(String fileName, List<Doctor>list) throws IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
			out.writeObject(list);
		}
	}
	
	
	public static void reStoreDeatailsInBinary(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
			 System.out.println(in.readObject());		
		}
	}
	
}

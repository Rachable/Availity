package FileProcessing;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProcessFile {

	public static void main(String[] args) {

		if (args.length < 2) {			
			System.out.println("You must enter input file path and output directory.");
			return;			
		}		
		String inputFilePath = args[0];
		String outputDirectory = args[1];
				
		try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))) {
		    Map<String, Map<String, Optional<Customer>>> insuranceCompanies = stream.map(s -> new Customer(s))
		            																.collect(
		            																		Collectors.groupingBy(
		            																				Customer::getInsuranceCompany, 
		            																				Collectors.groupingBy(
		            																						Customer::getUserID, 
		            																						Collectors.maxBy(Comparator.comparingInt(Customer::getVersion))
		            																				)
		            																		)
		            																);	    
		    
		    for(Map.Entry<String, Map<String,Optional<Customer>>> insuranceCompany :  insuranceCompanies.entrySet()) {
		    	
		    	BufferedWriter bf = new BufferedWriter(new FileWriter(outputDirectory + insuranceCompany.getKey() + ".csv"));
		    	
		    	List<Customer> sortedCustomers = insuranceCompany.getValue().entrySet().stream()
		    										   .map(entry -> (Customer) entry.getValue().get())
		    										   .sorted(Comparator.comparing(Customer::getLastName).thenComparing(Customer::getFirstName)).collect(Collectors.toList());
		    	
		    	for (Customer x : sortedCustomers) {
		    		bf.write(x.toString());
		    		bf.newLine();
		    	}
		    	bf.close();
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}

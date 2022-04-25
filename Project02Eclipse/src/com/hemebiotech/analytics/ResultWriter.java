package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class ResultWriter implements SymptomWriter {

	public String filePath;
	public Map<String, Integer> symptomsMap;
	
	/**
	 * 
	 * @param filepath a full or partial path to file where write result, symptomsMap a ordored map of counted symptoms
	 */
	public ResultWriter(String filePath, Map<String, Integer> symptomsMap) {
		this.filePath = filePath;
		this.symptomsMap = symptomsMap;
	}
	
	@Override
	public void writeSymptoms() throws FileNotFoundException {
		try {
			FileWriter writer = new FileWriter(filePath);
			symptomsMap.forEach((key, value) -> {
				try {
					writer.write(key + " " + value + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			writer.close();					
		}
		catch (FileNotFoundException e) {
	        throw e; // catch and re-throw
	    } catch (IOException e) {
	        System.err.print("Something went wrong");
	    }
	}
}

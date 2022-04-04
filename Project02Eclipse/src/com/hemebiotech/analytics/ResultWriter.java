/**
 * 
 */
package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author Home
 *
 */
public class ResultWriter implements SymptomWriter {

	public String filepath;
	public Map<String, Integer> symptomsMap;
	
	public ResultWriter(String filepath, Map<String, Integer> symptomsMap) {
		this.filepath = filepath;
		this.symptomsMap = symptomsMap;
	}
	
	@Override
	public void writeSymptoms() throws FileNotFoundException {
		try
		{
			FileWriter writer = new FileWriter(filepath);
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

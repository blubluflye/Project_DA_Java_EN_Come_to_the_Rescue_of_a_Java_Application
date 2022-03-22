package com.hemebiotech.analytics;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public class ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 * @throws FileNotFoundException 
	 */
	
		public static void main(String args[]) throws FileNotFoundException {
				ReadSymptomDataFromFile symptomList = new ReadSymptomDataFromFile("C:\\Users\\Home\\OneDrive\\Bureau\\WorkPlaceOpenclassrooms\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
				AnalyticsCounter analytics = new AnalyticsCounter(symptomList.GetSymptoms());
				Map<String, Integer> result = analytics.getAnalytics();
				try
				{
					FileWriter writer = new FileWriter("result.out");
					result.forEach((key, value) -> {
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

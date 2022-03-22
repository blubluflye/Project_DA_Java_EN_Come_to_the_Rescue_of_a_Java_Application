package com.hemebiotech.analytics;

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
	 */
	
		public static void main(String args[]) {
				ReadSymptomDataFromFile symptomList = new ReadSymptomDataFromFile("C:\\Users\\Home\\OneDrive\\Bureau\\WorkPlaceOpenclassrooms\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
				AnalyticsCounter analytics = new AnalyticsCounter(symptomList.GetSymptoms());
				Map<String, Integer> result = analytics.getAnalytics();
				result.forEach((key, value) -> System.out.println(key + " " + value));
		}
	
}

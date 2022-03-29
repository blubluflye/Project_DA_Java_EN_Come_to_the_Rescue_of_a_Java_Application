package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	List<String> symptomList;
	
	AnalyticsCounter(List<String> symptomList)
	{
		this.symptomList = symptomList;
	}
	public Map<String, Integer> getAnalytics()
	{
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (int i = 0; i < symptomList.size(); i++)
		{
			if ( result.get(symptomList.get(i)) == null)
			{
				result.put(symptomList.get(i), 1);
			}
			else
			{
				result.put(symptomList.get(i), result.get(symptomList.get(i)) + 1);
			}
		}
		return result;
	}

	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile symptomList = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");
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
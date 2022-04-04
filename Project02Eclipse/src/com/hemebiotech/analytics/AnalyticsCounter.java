package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * From a list of symptoms give u an ordered Map of the counted symptoms
 * Write this Map in a file result.out
 * 
 */
public class AnalyticsCounter {
	List<String> symptomList;
	
	/**
	 * 
	 * @param a list of String which is the symptom's list
	 */
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
	
	/**
	 * Sort a Map
	 * @param a Map
	 * @return a Map
	 */
	public Map<String, Integer> sort_map(Map<String, Integer> unsorted_map)
	{
		Map<String, Integer> sorted_map = new TreeMap<String, Integer>(unsorted_map);
		return sorted_map;
	}

	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile symptomList = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");
		AnalyticsCounter analytics = new AnalyticsCounter(symptomList.getSymptoms());
		Map<String, Integer> result = analytics.sort_map(analytics.getAnalytics());
		ResultWriter writer = new ResultWriter("result.out", result);
		writer.writeSymptoms();
	}
}
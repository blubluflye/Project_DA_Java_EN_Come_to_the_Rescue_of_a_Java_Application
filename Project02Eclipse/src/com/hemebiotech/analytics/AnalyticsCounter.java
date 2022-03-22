package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

	
public class AnalyticsCounter {
	
	List<String> symptomList;
	//private static int headacheCount = 0;	// initialize to 0
	//private static int rashCount = 0;		// initialize to 0
	//private static int pupilCount = 0;		// initialize to 0
	
	
	
		/* first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		//these 2 variables are useless
		//int i = 0;	// set i to 0 we never use i
		//int headCount = 0;	// counts headaches we already have headacheCount
		while (line != null) {
			//i++;	// increment i
			//System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			//rush when it should rash for the equal
			else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rashes: " + rashCount);
			}
			else if (line.contains("pupils")) {
				pupilCount++;
				System.out.println("number of pupils: " + pupilCount);
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
	
		
		AnalyticsCounter(List<String> symptomList)
		{
			this.symptomList = symptomList;
		}
		public Map<String, Integer> getAnalytics()
		{
			Map<String, Integer> result = new HashMap<String, Integer>();
			for (int i = 0; i < symptomList.size(); i++)
			{
				//String symtpom = symptomList.get(i);
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
}

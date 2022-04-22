package com.hemebiotech.analytics;

import java.io.FileNotFoundException;

/**
 * Anything that will write data from a source into a result.out file
 *
 */
public interface SymptomWriter {
	
	void writeSymptoms() throws FileNotFoundException;
}

package com.fizzbuzz.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author harshali
 * 
 *         FileGenerator class- utility to generate a file
 *
 */
@Component
public class FileGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileGenerator.class);

	@Value("${fizzbuzz.file.path}")
	private String filePath;

	/**
	 * @param result
	 * @throws IOException
	 */
	public void generateFile(List<Object> result) throws IOException {
		File file = new File(filePath);
		FileWriter writer = new FileWriter(file);

		result.stream().forEach(item -> {
			try {
				writer.write(item + "\n");
			} catch (IOException e) {
				LOGGER.error("There is an error while writing the fizzBuzz output in file", e);
			}
		});
		if (null != writer)
			writer.close();
	}

}

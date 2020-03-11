package com.fizzbuzz.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileGenerator.class);

	@Value("${fizzbuzz.file.path}")
	private String filePath;

	public void generateFile(List<String> result) throws IOException {
		File file = new File(filePath);

		// FileOutputStream output = new FileOutputStream(file.getAbsoluteFile());
		FileWriter writer = new FileWriter(file);

		result.stream().forEach(item -> {
			try {

				writer.write(item + "\n");

			} catch (IOException e) {
				LOGGER.error("There is an error while writing the fizzBuzz output in file", e);
			} /*
				 * finally { if (null != writer) { writer.close(); } }
				 */
		});
		if (null != writer)
			writer.close();
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.*;
/**
 *
 * @author Usuario
 */
public class fileChooser {
    private stack<String> FileContent = new stack<String>();

	/*
	 * Default Class Constructor
	 **/
	public fileChooser(String Name) throws Exception {
		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(Name));
			String line;

			while ((line = fileReader.readLine()) != null) {
				FileContent.push(line);
			}
			fileReader.close();
		} catch (IOException e) {
			throw new Exception(e);
		}
	}
	
	public stack<String> getFileContent() {
		return FileContent;
	}
    
}

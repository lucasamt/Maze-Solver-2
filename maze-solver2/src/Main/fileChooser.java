/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        @Override
        public String toString() {
                stack auxiliar = new stack();
                String allText = "";
                while(!FileContent.isEmpty()){
                    try {
                        auxiliar.push(FileContent.pop());
                    } 
                    catch (Exception ex) {
                    }
                }
                while(!auxiliar.isEmpty())
                {
                    String aux;
                    try {
                        aux = (String) auxiliar.pop();
                        FileContent.push(aux);
                        allText += aux + "\n";
                    } catch (Exception ex) {
                    }
                }
                
                return allText;
        }
}

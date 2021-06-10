package Main;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fileChooser {
    private stack<String> FileContent = new stack<String>();

	/**
         * Método construtor
         * 
         * @param Name String - Nome do arquivo
         * @return Void
         */
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
	
        /**
         * Retornar o conteúdo do arquivo
         * 
	 * @return stack<String> - Pilha do conteúdo do arquivo
	 */

	public stack<String> getFileContent() {
		return FileContent;
	}
        
        public Integer getMazeNum() throws Exception{
            int val = 0;
            try{
                val = Integer.parseInt(FileContent.getTop(0));
            }catch(Exception ex){
                val = FileContent.getTopIndex();
            }
            return val;
        }
        
        /**
          * Retorna dados da classe
          * 
	  * @return String
	  */
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
                int first = 1;
                while(!auxiliar.isEmpty())
                {
                    String aux;
                    try {
                        aux = (String) auxiliar.pop();
                        if(first != 1){
                            FileContent.push(aux);
                            allText += aux + "\n";   
                        }else{
                            first = 0;
                        }
                    } catch (Exception ex) {
                    }
                }
                
                return allText;
        }
    
    /**
     * Retorna hashcode da classe
     * 
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.FileContent);
        return hash;
    }

    /**
     * Retorna se uma classe é igual a outra
     * 
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final fileChooser other = (fileChooser) obj;
        if (!Objects.equals(this.FileContent, other.FileContent)) {
            return false;
        }
        return true;
    }
        
        
}

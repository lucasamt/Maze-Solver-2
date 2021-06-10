/**
 * Classe responsável pela configuração remota do programa.
 */
package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;


public class RemoteConfig {
    
    /**
     * Método responsável em pegar a configuração da 
     * @return remoteHost 
     */
    public String getRemote(){
        String remoteHost;
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader("remote.config"));
            remoteHost = fileReader.readLine();
        } catch (Exception ex) {
            remoteHost = "";
        }
        return remoteHost;
    }
    
    /**
     * Método responsável pela edição da configuração remota.
     * 
     * @param text
     * @return 
     */
    public Boolean setRemote(String text){
            try{
                FileWriter arquivo;
                arquivo = new FileWriter(new File("remote.config"));
                arquivo.write(text);
                arquivo.close();
                return true;
            }catch(Exception ex){
                return false;
            }
    }   
}

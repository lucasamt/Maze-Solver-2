/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author RGrupos
 */
public class RemoteConfig {
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

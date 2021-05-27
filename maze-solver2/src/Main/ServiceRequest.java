/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.Serializable;
import java.net.Socket;
import java.io.*;

/**
 *
 * @author RGrupos
 */
public class ServiceRequest {
    private String source;
    private Integer requestFlag = null;
    private String data = null;
    
    public ServiceRequest(String source){
        this.source = source;
    }
    public void setGetList(){
        this.requestFlag = 100;
    }
    public void setSaveFile(String file){
        this.requestFlag = 200;
        this.data = file;
    }
    
    public Object[] getRequestObject(){
        Object[] request = {source, requestFlag, data};
        return request;
    }
    
    public Boolean request(){
        try{
            // need host and port, we want to connect to the ServerSocket at port 7777
            RemoteConfig config = new RemoteConfig();
            String remoteHost = config.getRemote();
            Socket socket = new Socket(remoteHost, 7777);
            System.out.println("Connected!");
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            
            // Prepare request

            System.out.println("Sending messages to the ServerSocket");
            objectOutputStream.writeObject(this.getRequestObject());

            System.out.println("Closing socket and terminating program.");
            socket.close();
        }catch(Exception ex){
            return false;
        }
        return true;
    }

}

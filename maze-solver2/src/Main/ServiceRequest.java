/**
 * Classe que tem a função de fazer as requisições ao servidor, abrindo e fechando
 * sockets.
 */
package Main;

import java.io.Serializable;
import java.net.Socket;
import java.io.*;
import java.util.Objects;

public class ServiceRequest {
    private String source;
    private Integer requestFlag = null;
    private String data = null;
    
    /**
     * Método que denomina a função string source.
     * 
     * @param source 
     */
    public ServiceRequest(String source){
        this.source = source;
    }
    
    /**
     * Método responsável pela requisição de pegar a lista, nomeado com o Flag
     * de 100.
     */
    public void setGetList(){
        this.requestFlag = 100;
    }
    
    /**
     * Método responsável pela requisição de salvar o arquivo, nomeada com o Flag
     * de 200.
     * 
     * @param file 
     */
    public void setSaveFile(String file){
        this.requestFlag = 200;
        this.data = file;
    }
    
    /**
     * Método reponsável por pegar a requisição do objeto, retornando 
     * o source, requestFlag e os dados.
     * 
     * @return 
     */
    public Object[] getRequestObject(){
        Object[] request = {source, requestFlag, data};
        return request;
    }
    
    /**
     * Método booleano que quando retorna verdadeiro irá fazer uma nova configuração remota
     * abrindo um socket com uma requisição ao servidor, enviando os objetos,
     * após as operações o socket fechará, caso contrário retorna falso.
     * 
     * @return 
     */
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.source);
        hash = 41 * hash + Objects.hashCode(this.requestFlag);
        hash = 41 * hash + Objects.hashCode(this.data);
        return hash;
    }

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
        final ServiceRequest other = (ServiceRequest) obj;
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.requestFlag, other.requestFlag)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ServiceRequest{" + "source=" + source + ", requestFlag=" + requestFlag + ", data=" + data + '}';
    }

    
}

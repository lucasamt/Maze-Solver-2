/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import Main.RemoteConfig;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author RGrupos
 */
public class PedidoLabirintos extends Comunicado {

    private String idCliente; // vai ser o ip

    public PedidoLabirintos(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return this.idCliente;
    }
    
    final public Labirintos enviarDado() throws IOException, ClassNotFoundException{
        
        // Solicitar Labirintos
        RemoteConfig config = new RemoteConfig();
        Socket socket = new Socket(config.getRemote(), 7777);
        System.out.println("Connected!");
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        Object[] dataToSend = {200, getIdCliente()};
        objectOutputStream.writeObject(dataToSend);
        socket.close();   
        
        //Preparar porta de resposta
        ServerSocket requestIn  = new ServerSocket (7780); // Resposta       
        Socket conn = requestIn.accept();
        
        ObjectInputStream listener = new ObjectInputStream (conn.getInputStream ());
        System.out.println ("Recebido dado  do Servidor");
        Object[] request = (Object[])listener.readObject();
        Integer responseCode = Integer.parseInt(request[0].toString());
        System.out.println ("Code=>"+responseCode);        
        conn.close();
        
        
        Labirintos resposta = (Labirintos) request[1];
        return resposta;
    }
}

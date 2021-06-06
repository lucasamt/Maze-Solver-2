/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import Main.*;

/**
 *
 * @author RGrupos
 */
public class PedidoSalvamento extends Comunicado implements Serializable{

    private String idCliente;
    private Labirinto labirinto;

    public PedidoSalvamento(String idCliente, Labirinto lab) {
        this.idCliente = idCliente;
        this.labirinto = lab;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public Labirinto getLabirinto() {
        return this.labirinto;
    }
    
    @Override
    public String toString(){
        return this.labirinto.getConteudo();
    }
    
    final public void enviarDado() throws IOException{
        RemoteConfig config = new RemoteConfig();
        Socket socket = new Socket(config.getRemote(), 7777);
        System.out.println("Connected!");
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        Labirinto lab = getLabirinto();
        Object[] dataToSend = {100, getIdCliente(), lab};
        objectOutputStream.writeObject(dataToSend);
        socket.close();
    }
}

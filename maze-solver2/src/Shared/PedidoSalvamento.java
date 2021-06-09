/**
 * Essa classe é responsável pelos métodos que irão cuidar para que faça um
 * pedido de salvamento para o servidor através de socket, após todos os dados 
 * coletados irá enviar os dados.
 */

package Shared;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import Main.*;
import java.util.Objects;

public class PedidoSalvamento extends Comunicado implements Serializable{

    private String idCliente;
    private Labirinto labirinto;
    
    /**
     * Método que define os parâmetros para o pedido de salvamento, sendo eles
     * o id do Cliente e o labirinto.
     * 
     * @param idCliente
     * @param lab 
     */
    public PedidoSalvamento(String idCliente, Labirinto lab) {
        this.idCliente = idCliente;
        this.labirinto = lab;
    }

    /**
     * Esse método string retorna o id do determinado cliente(ip).
     * 
     * @return idCliente 
     */
    public String getIdCliente() {
        return this.idCliente;
    }
    
    /**
     * Esse método, após a certificação do ip do cliente irá retornar o labirinto
     * 
     * @return labirinto 
     */
    public Labirinto getLabirinto() {
        return this.labirinto;
    }
    
    @Override
    public String toString(){
        return this.labirinto.getConteudo();
    }
    
    /**
     * Esse método faz uma conexão remota através do ip do cliente, após isso 
     * realiza uma nova conexäo em socket, enviando os dados e após todo o processo
     * irá fechar a conexão em socket.
     * 
     * @throws IOException 
     */
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idCliente);
        hash = 67 * hash + Objects.hashCode(this.labirinto);
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
        final PedidoSalvamento other = (PedidoSalvamento) obj;
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        if (!Objects.equals(this.labirinto, other.labirinto)) {
            return false;
        }
        return true;
    }
    
    
}

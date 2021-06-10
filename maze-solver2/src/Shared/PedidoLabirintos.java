/**
 * Essa classe foi criada para auxiliar o servidor, com a função de certificar
 * a segunrança do envio, inserção, edição e acesso as informações colocadas no 
 * sistema a partir do id do Cliente pré definido, através do ip.
 */

package Shared;

import Main.RemoteConfig;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;


public class PedidoLabirintos extends Comunicado {

    private String idCliente; // vai ser o ip
    
    /**
     * Esse método é um construtor, que define o idCliente, que é pelo ip 
     * da pessoa, definindo o parâmetro idCliente.
     * 
     * @param idCliente 
     */
    public PedidoLabirintos(String idCliente) {
        this.idCliente = idCliente;
    }
    
    /**
     * Após definido o ip do cliente, esse método tem como funcionalidade
     * retorna-lo.
     * 
     * @return idCliente
     */
    public String getIdCliente() {
        return this.idCliente;
    }
    
    /**
     * Esse método de origem "Labirintos" solicita uma conexão remota, através do
     * ip do cliente, mandando a resposta em forma de socket para o servidor,
     * após isto o servidor retorna uma reposta, recebendo os dados e fazendo uma
     * requisição.
     * 
     * @return resposta
     * @throws IOException
     * @throws ClassNotFoundException 
     */
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
        requestIn.close();
        
        
        Labirintos resposta = (Labirintos) request[1];
        return resposta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.idCliente);
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
        final PedidoLabirintos other = (PedidoLabirintos) obj;
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PedidoLabirintos{" + "idCliente=" + idCliente + '}';
    }
    
    
}

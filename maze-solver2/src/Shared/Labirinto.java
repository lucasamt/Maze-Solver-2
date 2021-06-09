/**
 * Essa classe foi criada para que as variáveis padrões do labirinto sejam
 * pré definidas para a manipulação das informações dos labirintos.
 */

package Shared;
import java.io.Serializable;
import java.util.Objects;

public class Labirinto implements Serializable, Cloneable{

    private String nome;
    private String dataCriacao;
    private String dataUltimaAtualizacao;
    private String conteudo;
    
    /**
     * Esse método têm como objetivo passar os parâmetros de nome e o conteúdo 
     * do labirinto
     * 
     * @param nom
     * @param lab 
     */
    public Labirinto(String nom, String lab) {
        nome = nom;
        conteudo = lab;
    }

    /**
     * Esse método têm a função de editar o conteúdo do labirinto
     * 
     * @param lab 
     */
    public void setConteudo(String lab) {
        conteudo = lab;
    }

    /**
     * Esse método retorna o conteúdo que está dentro do labirinto
     * 
     * @return conteudo 
     */
    public String getConteudo() {
        return conteudo;
    }
    
    /**
     * Esse método tem uma função getter, de pegar o nome e retorná-lo
     * 
     * @return nome
     */
    public String getNome(){
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.dataCriacao);
        hash = 97 * hash + Objects.hashCode(this.dataUltimaAtualizacao);
        hash = 97 * hash + Objects.hashCode(this.conteudo);
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
        final Labirinto other = (Labirinto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.dataUltimaAtualizacao, other.dataUltimaAtualizacao)) {
            return false;
        }
        if (!Objects.equals(this.conteudo, other.conteudo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Labirinto{" + "nome=" + nome + ", dataCriacao=" + dataCriacao + ", dataUltimaAtualizacao=" + dataUltimaAtualizacao + ", conteudo=" + conteudo + '}';
    }
    
    
}

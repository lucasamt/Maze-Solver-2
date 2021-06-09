/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Shared;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author RGrupos
 */
public class Labirinto implements Serializable, Cloneable{

    private String nome;
    private String dataCriacao;
    private String dataUltimaAtualizacao;
    private String conteudo;

    public Labirinto(String nom, String lab) {
        nome = nom;
        conteudo = lab;
    }

    public void setConteudo(String lab) {
        conteudo = lab;
    }

    public String getConteudo() {
        return conteudo;
    }
    
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Shared;
import java.io.Serializable;

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
}

/**
 * Essa classe tem como função, primeiro cria um novo array em forma de lista
 * de um objeto Labirinto, após isto, pode adicionar novos labirintos dentro dessa
 * Array, pegar a quantidade ou pega a informação e retornando-as.
 */

package Shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Labirintos implements Serializable, Cloneable{

    private ArrayList<Labirinto> labirintos;

    /**
     * Esse é um método construtor, que têm a função de criar uma nova
     * Array de objeto Labirinto.
     */
    public Labirintos() {
        labirintos = new ArrayList<Labirinto>();
    }

    /**
     * Esse método faz que ao array criado no método anterior receba adicionado
     * um labirinto novo.
     * 
     * @param novo 
     */
    public void addLabirinto(Labirinto novo) {
        labirintos.add(novo);
    }

    /**
     * Esse método retorna uma quantidade de labirintos.
     * 
     * @return labirintos.size() 
     */
    public double getQtd() {
        return labirintos.size();
    }

    /**
     * Esse método primeiro pega a informação dentro do labirinto(i), após isto
     * retorna-o.
     * 
     * @param i
     * @return labirintos.get(i)
     */
    public Labirinto getLabirinto(int i) {
        return labirintos.get(i);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.labirintos);
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
        final Labirintos other = (Labirintos) obj;
        if (!Objects.equals(this.labirintos, other.labirintos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Labirintos{" + "labirintos=" + labirintos + '}';
    }
    
}

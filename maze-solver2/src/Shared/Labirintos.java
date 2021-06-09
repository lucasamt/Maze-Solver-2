/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author RGrupos
 */
public class Labirintos implements Serializable, Cloneable{

    private ArrayList<Labirinto> labirintos;

    public Labirintos() {
        labirintos = new ArrayList<Labirinto>();
    }

    public void addLabirinto(Labirinto novo) {
        labirintos.add(novo);
    }

    public double getQtd() {
        return labirintos.size();
    }

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

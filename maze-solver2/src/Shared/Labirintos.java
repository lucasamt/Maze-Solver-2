/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import java.io.Serializable;
import java.util.ArrayList;

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
}

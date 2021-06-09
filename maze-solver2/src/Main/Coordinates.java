/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Coordinates {
    private int coordinate[] = new int[2];
	
	public Coordinates(int x, int y) {
		this.coordinate[0] = x;
		this.coordinate[1] = y;
	}
	
	public int[] getCoordinate() {
		return this.coordinate;
	}
	
	public int getX() {
		return this.coordinate[0];
	}
	
	public int getY() {
		return this.coordinate[1];
	}
	
	public void updateCoordinates(int x, int y) {
		this.coordinate[0] = x;
		this.coordinate[1] = y;
	}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Arrays.hashCode(this.coordinate);
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
        final Coordinates other = (Coordinates) obj;
        if (!Arrays.equals(this.coordinate, other.coordinate)) {
            return false;
        }
        return true;
    }   

    @Override
    public String toString() {
        return "Coordinates{" + "coordinate=" + coordinate + '}';
    }
    
    
}

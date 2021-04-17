/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
    
}

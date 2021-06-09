/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 * Classe que mostra as coordenadas a serem percorridas no labirinto
 * 
 * @param  coordinate            Coordenada inteira que será transformada em 2 coordenadas x e y
 * @param  getCoordinate         Obtém as coordenadas a serem percorridas
 * @param  getX                  Obtém as coordenadas X percorridas no labirinto
 * @param  getY                  Obtém as coordenadas Y percorridas no labirinto
 * @param  updateCoordinates     Atualiza as coordenadas percorridas no labirinto
 * @return this.coordinates      Retorna todas as coordenadas obtidas
 * @return this.coordinate[0]    Retorna as coordenadas obtidas de X na String 0
 * @return this.coordinate[1]    Retorna as coordenadas obtidas de Y na String 1
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

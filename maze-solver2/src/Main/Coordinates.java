/**
 * A Classe <b>Coordinates<b> tem a função de a partir das Coordenadas declaradas 
 * em Positions (TOP,BOTTOM, LEFT, RIGHT) ter as as coordenadas a serem percorridas 
 * no labirinto utilizando os métodos padrões(get e set) criados para o uso. 
 * 
 */
package Main;

import java.util.Arrays;

public class Coordinates {
    private int coordinate[] = new int[2];
	
	public Coordinates(int x, int y) {
		this.coordinate[0] = x;
		this.coordinate[1] = y;
	}
	
        /**
         * Método que retorna as coordenadas(inteira), que são percorridas pelo Labirinto
         * @return coordinate 
         */
	public int[] getCoordinate() {
		return this.coordinate;
	}
	
        /**
         * Método que retorna as coordenadas percorridas de X
         * @return coordinate 
         */
	public int getX() {
		return this.coordinate[0];
	}
	
        /**
         * Método que retorna as coordenadas percorridas de Y
         * @return coordinate 
         */
	public int getY() {
		return this.coordinate[1];
	}
	
        /**
         * Método que atualiza as coordenadas percorridas em x e y
         * 
         * @param x
         * @param y 
         */
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

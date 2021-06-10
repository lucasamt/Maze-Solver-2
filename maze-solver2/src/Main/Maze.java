/**
 * 
 * A Classe  <b>Maze<b> tem por função criar um mapa de labirinto, 
 * que define a quantidade e o tipo de linha e colunas, 
 * demonstrando se o Labirinto é valido ou não.
 * 
 */
package Main;

import java.util.Arrays;

public class Maze {
    public String[][] mazeMap;
    
	/**
         * Método que define o número de linhas e colunas no labirinto, 
         * definindo o padrão para o tamanho do labirinto e se o labirinto nao 
         * adenter esse padrão pode retornar como labirinto inválido ou inexistente.
         * 
         * @param File
         */
	public Maze(stack<String> File) throws Exception {
		int numberLines; 
		int numberColumns;
		try {
                        System.out.println(File.getTop(0));
			numberLines = Integer.parseInt(File.getTop(0));
			numberColumns = File.getTop().length()+1;
		}
		catch(Exception error){ 
			throw new IllegalArgumentException(error);
		}
		
		if (numberLines <= 0) 
			throw new IllegalArgumentException("Invalid Maze 2");
	
		mazeMap = new String[numberLines+1][numberColumns+1];
		Boolean hasEntry = false;
		Boolean hasExit = false;
		
		int lines = 0;
		lines++;
		while(lines <= numberLines) {
			String line = File.getTop(lines);
			String[] lineC = line.split("");
			
			if(line.indexOf("E") >= 0)
				hasEntry = true;
			if(line.indexOf("S") >= 0)
				hasExit = true;
				
			mazeMap[(lines-1)] = lineC;
			lines++;
		}
		
		if(!hasEntry)
			throw new IllegalArgumentException("Maze has no Entry");
		if(!hasExit)
			throw new IllegalArgumentException("Maze has no Exit");
		/*
		for(int intLine = 0; intLine < mazeMap.length-1; intLine++) {
			for(int intColumn = 0; intColumn < mazeMap[intLine].length; intColumn++) {
				System.out.print(mazeMap[intLine][intColumn]);
			}
			System.out.print("\n");
		}
		*/
		
	}
        
	/**
         * Método que retorna o mapa do labirinto criado  
         * 
         * @return mazeMap
         */
	public String[][] getMazeMap(){
		return this.mazeMap;
	}
	
        /**
         * Método que printa no labirinto os rastros deixados por Bob ate chegar na saida  
         * 
         * @param coordinate 
         */
	public void footPrint(Coordinates coordinate) {
		int x = coordinate.getX();
		int y = coordinate.getY();
		String tile = this.mazeMap[x][y];
		
		if(x < 0 || y < 0 || x > this.mazeMap.length-1 || y > this.mazeMap[x].length-1)
			throw new IllegalArgumentException("You are a not a fish to swim outside the land!");
		
		if(tile.equals("#")) {
			throw new IllegalArgumentException("You can not jump walls!");
		}
		
		this.mazeMap[x][y] = "*";
	}
	
        /**
         * Método que apaga no labirinto os "rastros" deixados por Bod, que nao chegam até a saída.
         * 
         * @param coordinate 
         */
	public void eraseFootPrint(Coordinates coordinate) {
		int x = coordinate.getX();
		int y = coordinate.getY();
		String tile = this.mazeMap[x][y];
		
		if(x < 0 || y < 0 || x > this.mazeMap.length-1 || y > this.mazeMap[x].length-1)
			throw new IllegalArgumentException("You are a not a fish to swim outside the land! ("+x+","+y+")");
		
		if(!tile.equals("*"))
			throw new IllegalArgumentException("You can't cheat an honest code ("+x+","+y+")");
		
		
		this.mazeMap[x][y] = " ";
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Arrays.deepHashCode(this.mazeMap);
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
        final Maze other = (Maze) obj;
        if (!Arrays.deepEquals(this.mazeMap, other.mazeMap)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Maze{" + "mazeMap=" + mazeMap + '}';
    }
        
        
}

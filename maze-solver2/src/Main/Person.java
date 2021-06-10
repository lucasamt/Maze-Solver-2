/**
 * Classe que declara o labirinto, as coordenadas da pilha que a pessoa
 * irá passar e verificar se é ou não campeão.
 * Nesta classe encontramos os métodos progressivos e regressivos,
 * procura o 'E' para ver onde está e o 'S' para encontrar a saída do labirinto.
 * Além de definir as posições pelas quais Bob passa. 
 * Escreve e apaga a "trilha" deixadas por Bob.
 * 
 */

package Main;

import java.util.Objects;

public class Person {
    private Maze maze;
	private Coordinates coordinate;
	private stack<Coordinates> adjacent;
	private stack<stack<Coordinates>> chance;
	private stack<Coordinates> mentalMap;
	private boolean winner = false;
        
        /**
         * Método que declara e cria um novo Labirinto e uma pilha com as coordenadas,
         * para retornar mapa do labirinto com as coordenadas, 
         * e procura o 'E' - Entrada do labirinto, para encontrar onde esta.
         * 
         * @param maze
         */	
	public Person(Maze maze) throws Exception {
		this.maze = maze;
		this.chance = new  stack<stack<Coordinates>>(3);
		this.mentalMap = new stack<Coordinates>(3);
		String[][] mazeMap = maze.getMazeMap();
		boolean foundEntry = false;
		outerloop: // Sair do loop inteiro
		for(int intLine = 0; intLine < mazeMap.length-1; intLine++) {
			for(int intColumn = 0; intColumn < mazeMap[intLine].length; intColumn++) {
				if(mazeMap[intLine][intColumn].equals("E")) {
					this.coordinate = new Coordinates(intLine, intColumn);
					foundEntry = true;
					break outerloop;
				}
			}
		}
		
		if(!foundEntry)
			throw new IllegalArgumentException("Sorry, I could'nt find the entry");
	}
        
        /**
         * Metodo que faz "Bob" pensar qual caminho deve seguir, até encontrar o 'S' - Saida
         * Declara as posições que Bob deve andar no labirinto, verifica se as posições estão vazias 
         * se sim ele segue e chama o método progressivo.
         * 
         * @return Void
         */
	public Boolean think() throws Exception {
		this.adjacent = new stack<Coordinates>(3);
		
		if(this.winner) {
			throw new IllegalArgumentException("I already found the exit, I won!");
		}
		else if(getStepAt().equals("S")) {
			winner = true;
			trackInMap();
			return false;
		}else {
			int[] me = this.coordinate.getCoordinate();
			look(Positions.TOP);
			look(Positions.BOTTOM);
			look(Positions.LEFT);
			look(Positions.RIGHT);
			
			if(!this.adjacent.isEmpty()) {
				keepForward();
			}else {
				goBack();
			}
			
			return true;
		}
	}
        
        /**
         * Método progressivo, que faz Bob andar para frente pelo labirinto até encontrar a Saída.
         */
	private void keepForward() throws Exception {
		trackInMap();
		walk(this.adjacent.getTop());
		this.mentalMap.push(adjacent.pop());
		this.chance.push(adjacent);
		
	}
        
        /**
         * Método regressivo, que faz Bob retornar pelo caminho que ele andou ao chegar em um beco sem Saida.
         */
	private void goBack() throws Exception {
		this.mentalMap.pop();
		while(!this.chance.isEmpty()) {
			this.adjacent = this.chance.pop();
			if(this.adjacent.isEmpty()) {
				walk(this.mentalMap.pop());
				eraseMap();
			}else {
			    Coordinates mMap = this.mentalMap.pop();
                walk(mMap);
                this.mentalMap.push(mMap);
               
                eraseMap();
                keepForward();
                break;
			}
		}
	}
        
        /**
         * Metodo que apaga os "rastros" deixados por bob enquanto caminha
         */
	private void eraseMap() {
		this.maze.eraseFootPrint(this.coordinate);
	}
	
        /**
         * Método que deixa apenas os rastos validos que levam até a saída.
         */
	private void trackInMap() {
		this.maze.footPrint(this.coordinate);
	}
	
        /**
         * Metodo que verifica as posições que Bob pode andar, 
         * analisa se essas posições são validas, ou seja, se é possivel andar 
         * e manda Bob ir em frente até encontrar 'S'.
         * 
         * @param lookingAt 
         */
	private void look(Positions lookingAt) {
		int x = this.coordinate.getX();
		int y = this.coordinate.getY();
		String tile = null;
		
		if(lookingAt == Positions.TOP) {
			if(x == 0)
				return;
			x--;
			tile =  maze.getMazeMap()[x][y];
		}
		else if(lookingAt == Positions.BOTTOM) {
			if(x == maze.getMazeMap().length-1)
				return;
			x++;
			tile =  maze.getMazeMap()[x][y];
		}
		else if(lookingAt == Positions.LEFT) {
			if(y == 0)
				return;
			y--;
			tile =  maze.getMazeMap()[x][y];
		}
		else if(lookingAt == Positions.RIGHT) {
			if(y == maze.getMazeMap()[x].length-1)
				return;
			y++;
			tile =  maze.getMazeMap()[x][y];
		}
		
		// Only adds if he sees a way
		if((tile.equals("S") || tile.equals(" ")) && tile != null) {
			Coordinates coordinateToAdd = new Coordinates(x, y);
			
			this.adjacent.push(coordinateToAdd);
		}
		
		return;
	}
        
        /**
         * Metodo que retorna as coordenadas que Bob caminhou pelo labirinto
         * 
         * @param coordinate 
         */
	public void walk(Coordinates coordinate) {
		this.coordinate = coordinate;
	}
	
        /**
         * Metodo que define uma String para que as coordenadas sejam gravadas no mapa do labirinto
         * 
         * @return maze
         */
	public String getStepAt() {
		return maze.getMazeMap()[this.coordinate.getX()][this.coordinate.getY()];
	}
	
        /**
         * Metodo que declara Bob como o novo campeão quando ele encontra 'S'.
         * 
         * @return winner
         */
	public boolean isTheWinner() {
		return this.winner;
	}
	
        /**
         * Metodo que escreve a solução do labirinto no mapa e o o printa no final
         * 
         * @return print
         */
	public String writeSolution() {
		this.maze = maze;
		String[][] mazeMap = maze.getMazeMap();
                String print = "";
		boolean foundEntry = false;
		outerloop: // Sair do loop inteiro
		for(int intLine = 0; intLine < mazeMap.length-1; intLine++) {
			for(int intColumn = 0; intColumn < mazeMap[intLine].length; intColumn++) {
				print += mazeMap[intLine][intColumn];
			}
			print += "\n";
		}
                return print;
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.maze);
        hash = 67 * hash + Objects.hashCode(this.coordinate);
        hash = 67 * hash + Objects.hashCode(this.adjacent);
        hash = 67 * hash + Objects.hashCode(this.chance);
        hash = 67 * hash + Objects.hashCode(this.mentalMap);
        hash = 67 * hash + (this.winner ? 1 : 0);
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
        final Person other = (Person) obj;
        if (this.winner != other.winner) {
            return false;
        }
        if (!Objects.equals(this.maze, other.maze)) {
            return false;
        }
        if (!Objects.equals(this.coordinate, other.coordinate)) {
            return false;
        }
        if (!Objects.equals(this.adjacent, other.adjacent)) {
            return false;
        }
        if (!Objects.equals(this.chance, other.chance)) {
            return false;
        }
        if (!Objects.equals(this.mentalMap, other.mentalMap)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "maze=" + maze + ", coordinate=" + coordinate + ", adjacent=" + adjacent + ", chance=" + chance + ", mentalMap=" + mentalMap + ", winner=" + winner + '}';
    }
        
        
}

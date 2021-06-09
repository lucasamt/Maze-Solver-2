/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 * Classe que declara o labirinto, as coordenadas da pilha que a pessoa
 * irá passar e verificar se ele não é um campeão.
 * Nesta classe encontramos os métodos progressivos e regressivos,
 * procura o 'E' para ver onde está e o 'S' para encontrar a saída do labirinto.
 * Além de definir as posições pelas quais Bob passa. 
 * Escreve e apaga a "trilha" deixadas por Bob.
 * 
 * @param winner  Parametro que define Bob como campeão
 */

public class Person {
    private Maze maze;
	private Coordinates coordinate;
	private stack<Coordinates> adjacent;
	private stack<stack<Coordinates>> chance;
	private stack<Coordinates> mentalMap;
	private boolean winner = false;
	
	public Person(Maze maze) throws Exception {
		this.maze = maze;
		this.chance = new  stack<stack<Coordinates>>(3);
		this.mentalMap = new stack<Coordinates>(3);
		String[][] mazeMap = maze.getMazeMap();
		
/**
 * Tenta encontrar `E`, para se localizar no Labirinto
 * 
 * @param foundEntry    Procura o E- Entrada do Labirinto.
 * @param intLine       Define o tamanho das linhas do labirinto para localizar.
 * @param intColumn 	Define o tamanho das colunas do labirinto para localizar.
 * @return		void
 */
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
 * @param  think   Faz "Bob" pensar qual caminho deve seguir.       
 * @param  me 	   Declara as posições que Bob deve andar no labirinto.
 * @return true	   Retorna verdadeiro se o lado adjacente estiver vazio.	
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
 * Aqui temos o método progressivo
 * 
 * @param  keepForward   Faz Bob andar para frente pelo labirinto até encontrar a saída.       	
 * @return               void		
 */
        
	private void keepForward() throws Exception {
		trackInMap();
		walk(this.adjacent.getTop());
		this.mentalMap.push(adjacent.pop());
		this.chance.push(adjacent);
		
	}
        
/**    
 * Aqui temos o método regressivo
 * 
 * @param  goBack   Faz Bob retornar pelo caminho que ele andou ao chegar em um beco sem saida. 
 * @return          void		
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
 * Aqui temos o método que apaga os "rastros" deixados por bob enquanto caminha.
 * O que ajuda ele a ficar no caminho certo para chegar à saída.
 * 
 * @param  eraseMap     Apaga os "rastros" deixados por Bob. 
 * @param  trackInMap   Deixa apenas a trilha que vai até a saída do labirinto.
 * @param  look         Verifica as posições que Bob pode andar e faz ele seguir em frente apenas se ele estiver a caminho de 'S'.
 * @param  x		Define a aparência das linhas do labirinto, a partir das posições que bob tem que andar.
 * @param  y		Define a aparência das colunas do labirinto, a partir das posições que bob tem que andar.
 * @return              void		
 */
        
	private void eraseMap() {
		this.maze.eraseFootPrint(this.coordinate);
	}
	
	private void trackInMap() {
		this.maze.footPrint(this.coordinate);
	}
	
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
 * @param  walk         Define as coordenadas para Bob caminhar no labirinto. 
 * @param  isTheWinner  Declara Bob como o novo campeão quando ele chega na Saida.
 * @return              void		
 */
        
	public void walk(Coordinates coordinate) {
		this.coordinate = coordinate;
	}
	
	public String getStepAt() {
		return maze.getMazeMap()[this.coordinate.getX()][this.coordinate.getY()];
	}
	
	public boolean isTheWinner() {
		return this.winner;
	}
	
	public String writeSolution() {
		this.maze = maze;
		String[][] mazeMap = maze.getMazeMap();
                String print = "";
		
/**  
 * 
 * Procura 'E' para saber onde esta. 
 * 
 * @return  Retorna com o resultado de tudo printado na tela	
 */
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
}

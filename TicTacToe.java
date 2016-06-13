public class TicTacToe{

	private char[][] field = {{' ', ' ', ' '},
							  {'x', ' ', ' '},
							  {'o', 'o', 'o'}};

	public boolean isFull(){
		boolean isFull = true;
		for (int i = 0; i < field.length; i++){
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == ' '){
					isFull = false;
				} 
			}
		}
		return isFull;
	}

	public boolean checkVertical(char player){
		return true;
	}

	public boolean checkHorizontal(char symbol){
		for (int i = 0; i < field.length ; i++) {
			System.out.println("==================================================================");
			int count = 0;
			for (int j = 0;j < field.length ; j++) {
				System.out.println("reihe " + i + ", spalte " + j + ", symbol " + field[i][j]);
				if(field[i][j] == symbol){
					count++;
					if(count == 3){
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean checkDiagonal(){
		return true;
	}
}
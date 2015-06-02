
public class TIcTacToe {

	
	private String[][] table;
	
	
	public TIcTacToe() {
		
		this.table = new String[3][3];
		
		for (int i = 0; i < 3; i++) {
			
			this.table[i] = new String[3];
			
		}
		
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				this.table[i][j] = "";
				
			}
			
		}
		
	}
	
	
	public String getStringAtPos (int i, int j) throws OutOfBoundException {
		
		if ( i >= 0 && i < 3 && j >= 0 && j < 3) {
			
			return this.table[i][j];
		
		} else {
			
			throw new OutOfBoundException("i = " + i + " | j = " + j);
						
		}
		
	}
	
	
	public void setPos(int i, int j, String symbol) throws OutOfBoundException {
		
		if ( i >= 0 && i < 3 && j >= 0 && j < 3) {
			
			this.table[i][j] = symbol;
		
		} else {
			
			throw new OutOfBoundException("i = " + i + " | j = " + j);
			
		}
			
	}
	
	
	public boolean checkVincitor (String symbol) {
		
		boolean vict = false;
		
		
		// Check Rows
		for (int i = 0; (i < 3 && !vict); i++) {
			
			if (this.table[i][0].equals(symbol)) {
				
				if (this.table[i][1].equals(symbol)) {
									
					if (this.table[i][2].equals(symbol)) {
						
						vict = true;
					
					}
					
				}
				
			}
					
		}
		
		
		// Check Columns
		if (!vict) {
					
			for (int j = 0; (j < 3 && !vict); j++) {
							
				if (this.table[0][j].equals(symbol)) {
								
					if (this.table[1][j].equals(symbol)) {
									
						if (this.table[2][j].equals(symbol)) {
							
							vict = true;
						
						}
						
					}
					
				}
							
			}
				
		}
				
				
		// Check First Diagonal
		if (!vict) {
			
			if (this.table[0][0].equals(symbol)) {
				
				if (this.table[1][1].equals(symbol)) {
					
					if (this.table[2][2].equals(symbol)) {
						
						vict = true;
						
					}
					
				}				
				
			}
			
		}
		
		
		// Check Second Diagonal
		if (!vict) {
			
			if (this.table[2][0].equals(symbol)) {
				
				if (this.table[1][1].equals(symbol)) {
					
					if (this.table[0][2].equals(symbol)) {
						
						vict = true;
						
					}
					
				}				
				
			}
			
		}
		
		return vict;
		
	}
	
	
	public boolean checkDraw() {
		
		boolean draw = true;
		
		for (int i = 0; (i < 3 && draw); i++) {
			
			for (int j = 0; (j < 3 && draw); j++) {
				
				if (this.table[i][j].equals("")) {
					
					draw = false;
					
				}
				
			}
			
		}		
		
		return draw;
	
	}
	
	
	public String[][] getTable () {
		
		return this.table;
		
	}
	
	
}

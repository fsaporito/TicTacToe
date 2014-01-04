
public class Tris {

	
	private String[][] matrix;
	
	
	public Tris() {
		
		this.matrix = new String[3][3];
		
		for (int i = 0; i < 3; i++) {
			
			this.matrix[i] = new String[3];
			
		}
		
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				this.matrix[i][j] = "";
				
			}
			
		}
		
	}
	
	
	public String getStringAtPos (int i, int j) throws OutOfBoundException {
		
		if ( i >= 0 && i < 3 && j >= 0 && j < 3) {
			
			return this.matrix[i][j];
		
		} else {
			
			throw new OutOfBoundException("i = " + i + " | j = " + j);
						
		}
		
	}
	
	
	public void setPos(int i, int j, String symbol) throws OutOfBoundException {
		
		if ( i >= 0 && i < 3 && j >= 0 && j < 3) {
			
			this.matrix[i][j] = symbol;
		
		} else {
			
			throw new OutOfBoundException("i = " + i + " | j = " + j);
			
		}
			
	}
	
	
	public boolean checkVincitor (String symbol) {
		
		boolean vict = false;
		
		
		// Check Rows
		for (int i = 0; (i < 3 && !vict); i++) {
			
			if (this.matrix[i][0].equals(symbol)) {
				
				if (this.matrix[i][1].equals(symbol)) {
									
					if (this.matrix[i][2].equals(symbol)) {
						
						vict = true;
					
					}
					
				}
				
			}
					
		}
		
		
		// Check Columns
		if (!vict) {
					
			for (int j = 0; (j < 3 && !vict); j++) {
							
				if (this.matrix[0][j].equals(symbol)) {
								
					if (this.matrix[1][j].equals(symbol)) {
									
						if (this.matrix[2][j].equals(symbol)) {
							
							vict = true;
						
						}
						
					}
					
				}
							
			}
				
		}
				
				
		// Check First Diagonal
		if (!vict) {
			
			if (this.matrix[0][0].equals(symbol)) {
				
				if (this.matrix[1][1].equals(symbol)) {
					
					if (this.matrix[2][2].equals(symbol)) {
						
						vict = true;
						
					}
					
				}				
				
			}
			
		}
		
		
		// Check Second Diagonal
		if (!vict) {
			
			if (this.matrix[2][0].equals(symbol)) {
				
				if (this.matrix[1][1].equals(symbol)) {
					
					if (this.matrix[0][2].equals(symbol)) {
						
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
				
				if (this.matrix[i][j].equals("")) {
					
					draw = false;
					
				}
				
			}
			
		}
		
		
		return draw;
	}
	
	
}

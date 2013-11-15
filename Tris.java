
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
	
	
	public void setX(int i, int j) throws OutOfBoundException {
		
		if ( i >= 0 && i < 3 && j >= 0 && j < 3) {
			
			this.matrix[i][j] = "X";
		
		} else {
			
			throw new OutOfBoundException("i = " + i + " | j = " + j);
			
		}
			
	}
	
	
	public void setO(int i, int j) throws OutOfBoundException {
		
		if ( i >= 0 && i < 3 && j >= 0 && j < 3) {
			
			this.matrix[i][j] = "O";
		
		} else {
			
			throw new OutOfBoundException("i = " + i + " | j = " + j);
			
		}
		
	}
	
	
	public boolean checkVincitorX () {
		
		boolean vict = false;
		
		
		// Check Rows
		for (int i = 0; (i < 3 && !vict); i++) {
			
			if (this.matrix[i][0].equals("X")) {
				
				if (this.matrix[i][1].equals("X")) {
									
					if (this.matrix[i][2].equals("X")) {
						
						vict = true;
					
					}
					
				}
				
			}
					
		}
		
		
		// Check Columns
		if (!vict) {
					
			for (int j = 0; (j < 3 && !vict); j++) {
							
				if (this.matrix[0][j].equals("X")) {
								
					if (this.matrix[1][j].equals("X")) {
									
						if (this.matrix[2][j].equals("X")) {
							
							vict = true;
						
						}
						
					}
					
				}
							
			}
				
		}
				
				
		// Verifica Diagonale Principale
		if (!vict) {
			
			if (this.matrix[0][0].equals("X")) {
				
				if (this.matrix[1][1].equals("X")) {
					
					if (this.matrix[2][2].equals("X")) {
						
						vict = true;
						
					}
					
				}				
				
			}
			
		}
		
		
		// Verifica Seconda Diagonale Principale
		if (!vict) {
			
			if (this.matrix[2][0].equals("X")) {
				
				if (this.matrix[1][1].equals("X")) {
					
					if (this.matrix[0][2].equals("X")) {
						
						vict = true;
						
					}
					
				}				
				
			}
			
		}
		
		return vict;
		
	}
	
	
	public boolean checkVincitorO () {
		
		boolean vict = false;
		
		
		// Check Rows
				for (int i = 0; (i < 3 && !vict); i++) {
					
					if (this.matrix[i][0].equals("O")) {
						
						if (this.matrix[i][1].equals("O")) {
											
							if (this.matrix[i][2].equals("O")) {
								
								vict = true;
							
							}
							
						}
						
					}
							
				}
				
				
				// Check Columns
				if (!vict) {
							
					for (int j = 0; (j < 3 && !vict); j++) {
									
						if (this.matrix[0][j].equals("O")) {
										
							if (this.matrix[1][j].equals("O")) {
											
								if (this.matrix[2][j].equals("O")) {
									
									vict = true;
								
								}
								
							}
							
						}
									
					}
						
				}
		
		
		// Verifica Diagonale Principale
		if (!vict) {
			
			if (this.matrix[0][0].equals("O")) {
				
				if (this.matrix[1][1].equals("O")) {
					
					if (this.matrix[2][2].equals("O")) {
						
						vict = true;
						
					}
					
				}				
				
			}
			
		}
		
		
		// Verifica Seconda Diagonale Principale
		if (!vict) {
			
			if (this.matrix[2][0].equals("O")) {
				
				if (this.matrix[1][1].equals("O")) {
					
					if (this.matrix[0][2].equals("O")) {
						
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

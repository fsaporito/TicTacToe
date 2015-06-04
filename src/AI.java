import java.util.ArrayList;


public class AI {
	
	private String player;
	private String AI;
	
	public AI (String player, String AI) {
		
		this.player = player;
		this.AI = AI;
		
	}
	
	public int[] move (String[][] table, String turn) throws OutOfBoundException {
		
		int posWin[] = {0, 0, 0};
		
		ArrayList<int[]> points = new ArrayList<int[]>();
		
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				if (table[i][j].equals("")) {
					
					TIcTacToe tmpTicTacToe = new TIcTacToe ();
						
					tmpTicTacToe.setTable(table);
						
					tmpTicTacToe.setPos(i, j, turn);
					
					if (tmpTicTacToe.checkVincitor(turn)) {
						
						if (turn.equals(this.player)) {
						
							int[] tmpPos = new int[3];
							
							tmpPos[0] = i;
							tmpPos[1] = j;
							tmpPos[2] = -10;	
							
							points.add(tmpPos);
														
						} else if (turn.equals(this.AI)) {
							
							int[] tmpPos = new int[3];
							
							tmpPos[0] = i;
							tmpPos[1] = j;
							tmpPos[2] = 10;	
							
							points.add(tmpPos);
							
						}
						
					} else if (tmpTicTacToe.checkDraw()) {
						
						int[] tmpPos = new int[3];
						
						tmpPos[0] = i;
						tmpPos[1] = j;
						tmpPos[2] = 0;	
						
						points.add(tmpPos);
						
					} else {
						
						String nextTurn = "";
						
						if (turn.equals(this.player)) {
							
							nextTurn = this.AI;
							
						} else if (turn.equals(this.AI)) {
							
							nextTurn = this.player;
							
						}
						
						int[] tmpPos = new int[3];
												
						tmpPos = this.move(tmpTicTacToe.getTable(), nextTurn);	
												
						points.add(tmpPos);
						
					}
						
				}
				
			}
			
		}		
		
		if (turn.equals(this.AI)) {
		
			posWin = this.maxValue(points);		
		
		} else if (turn.equals(this.player)) { 
		
			posWin = this.minValue(points);
			
		}	
		
		if (posWin == null) {
			
			throw new NullPointerException();
			
		}
		
		
		return posWin;
				
	}
	
	
	private int[] maxValue (ArrayList<int[]> points) {
		
		if (points == null || points.size() == 0) {
			
			return null;
			
		}
		
		int[] pointReturn = new int[3];
		
		pointReturn = points.get(0);
		
		for (int i = 0; i < points.size(); i++) {
			
			if (points.get(i)[2] > pointReturn[2]) {
				
				pointReturn = points.get(i);
				
			}
			
		}
		
		return pointReturn;
		
	}
	
	
	private int[] minValue (ArrayList<int[]> points) {
		
		if (points == null || points.size() == 0) {
			
			return null;
			
		}
		
		int[] pointReturn = new int[3];
		
		pointReturn = points.get(0);
		
		for (int i = 0; i < points.size(); i++) {
			
			if (points.get(i)[2] < pointReturn[2]) {
				
				pointReturn = points.get(i);
				
			}
			
		}
		
		return pointReturn;
		
	}
	

}

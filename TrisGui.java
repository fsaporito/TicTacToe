import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class TrisGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Tris tris;
	
	private JLabel message;
	
	private JButton resetButton;
	private JButton newGameButton;
	private JButton exitButton;
	
	
	private JButton b00;
	private JButton b01;
	private JButton b02;
	private JButton b10;
	private JButton b11;
	private JButton b12;
	private JButton b20;
	private JButton b21;
	private JButton b22;
	
	private String turn;
	private boolean win;
	private boolean draw;
	private String stringWin;
	private static final String stringDraw = "Draw!!!";
	
	
	private int counterX;
	private int counterO;
	private int matches;

	private JLabel labelX;
	private JLabel labelO;
	private JLabel labelMatches;

	private TrisWin guiWin;
	
	
	public TrisGui()  {

		super("Tris");
		this.setSize(400,400);
		this.setLayout(new BorderLayout());
		
		// Panel Label
		JPanel panelLabel = new JPanel();
		panelLabel.setSize(400, 20);
		panelLabel.setLayout(new BorderLayout());
		this.add("North", panelLabel);
		
		
		// LabelX
		this.labelX = new JLabel("");
		panelLabel.add("West", this.labelX);
				
				
		// LabelPlay 
		this.message = new JLabel("X Play");
		JPanel panelMessage = new JPanel();
		panelMessage.add(this.message);
		panelLabel.add("Center", panelMessage);
		
		
		// LabelO
		this.labelO = new JLabel("");
		panelLabel.add("East", this.labelO);
		
		
		// Panel Buttons
		JPanel panButtons = new JPanel();
		this.add("South", panButtons);
		
		
		// New Reset Button
		this.resetButton = new JButton ("Reset");
		this.resetButton.addActionListener(this);
		panButtons.add(this.resetButton);
		
		
		// New Game Button
		this.newGameButton = new JButton("New Game");
		this.newGameButton.addActionListener(this);
		panButtons.add(this.newGameButton);
		
		
		// Exit Button
		this.exitButton = new JButton("Exit");
		this.exitButton.addActionListener(this);
		panButtons.add(this.exitButton);
		
		
		// LabelMatches
		panButtons.add(new JLabel("   "));
		this.labelMatches = new JLabel("");
		panButtons.add(this.labelMatches);
		
		
		// Panel Tris
		JPanel panelTris = new JPanel();
		panelTris.setSize(400,375);
		panelTris.setLayout(new GridLayout(3,3));
		this.add("Center", panelTris);
		
		
		// Button 00
		this.b00 = new JButton("00");
		this.b00.addActionListener(this);
		panelTris.add(this.b00);
		
		
		// Button 01
		this.b01 = new JButton("01");
		this.b01.addActionListener(this);
		panelTris.add(this.b01);


		// Button 02
		this.b02 = new JButton("02");
		this.b02.addActionListener(this);
		panelTris.add(this.b02);


		// Button 10
		this.b10 = new JButton("10");
		this.b10.addActionListener(this);
		panelTris.add(this.b10);


		// Button 11
		this.b11 = new JButton("11");
		this.b11.addActionListener(this);
		panelTris.add(this.b11);

		
		// Button 12
		this.b12 = new JButton("12");
		this.b12.addActionListener(this);
		panelTris.add(this.b12);


		// Button 20
		this.b20 = new JButton("20");
		this.b20.addActionListener(this);
		panelTris.add(this.b20);
		
		
		// Button 21
		this.b21 = new JButton("21");
		this.b21.addActionListener(this);
		panelTris.add(this.b21);
			
		
		// Button 22
		this.b22 = new JButton("22");
		this.b22.addActionListener(this);
		panelTris.add(this.b22);
			
		
		// Start New Game
		this.resetGame();
		
	}

	
	private void resetGame () {
		
		this.counterX = 0;
		this.counterO = 0;
		this.matches = 0;
		
		this.turn = "X";		
		
		this.newGame();
		
	}
	
	
	private void newGame () {
		
		this.tris = new Tris();
		
		this.matches += 1;
		
		this.win = false;
		
		this.draw = false;
		
		this.guiWin = null;
		
		this.stringWin = "";
		
		this.labelX.setText("X: " + this.counterX);
		
		this.labelO.setText("O: " + this.counterO);
		
		this.labelMatches.setText("Matches: " + this.matches);
		
		this.message.setText(this.turn + " plays");
		
		this.b00.setText("");
		this.b01.setText("");
		this.b02.setText("");
		this.b10.setText("");
		this.b11.setText("");
		this.b12.setText("");
		this.b20.setText("");
		this.b21.setText("");
		this.b22.setText("");
		
		
	}
	
	
	private void switchTurn () {
		
		if (this.turn.equals("X")) {
			
			this.turn = "O";
			
			if (!this.win && !this.draw) {
				
				this.message.setText("O plays");
			
			}
			
		}  else if (this.turn.equals("O")) {
			
			this.turn = "X";
			
			if (!this.win && !this.draw) {
				
				this.message.setText("X plays");
			
			}
			
		}

	}
	
	
	private String insertPos (int i, int j) {
		
		String returnString = "";
		
		if (!this.win && !this.draw) {
		
			try {
			
				if (this.turn.equals("X")) {
										
					if (!this.tris.getStringAtPos(i,j).equals("O")) {
						
						this.tris.setX(i,j);
					
						this.switchTurn();
												
						returnString = "X";
						
						if (this.tris.checkVincitorX()) {
							
							this.stringWin = "X Wins :)";
							
							this.counterX++;
							
							this.labelX.setText("X: " + this.counterX);
									
							this.message.setText(this.stringWin);
							
							this.win = true;
							
							this.newGameButton.setText("Continue");
							
							this.guiWin = new TrisWin(this.message.getText());
							
							this.guiWin.setVisible(true);
														
						}
					
					}
				
				} else if (this.turn.equals("O")) {
					
					if (!this.tris.getStringAtPos(i,j).equals("X")) {
					
						this.tris.setO(i,j);
					
						this.switchTurn();
						
						returnString = "O";
						
						if (this.tris.checkVincitorO()) {
							
							this.stringWin = "O Wins :)";
							
							this.counterO++;
							
							this.labelO.setText("O: " + this.counterO);
									
							this.message.setText(this.stringWin);
							
							this.win = true;
							
							this.newGameButton.setText("Continue");
							
							this.guiWin = new TrisWin(this.message.getText());
							
							this.guiWin.setVisible(true);
								
						}
						
					}
				
				}
				
				
				if (this.tris.checkDraw()) {
					
					this.message.setText(TrisGui.stringDraw);
					
					this.draw = true;
					
					this.newGameButton.setText("Continue");
					
					this.guiWin = new TrisWin(this.message.getText());
					
					this.guiWin.setVisible(true);
					
					this.switchTurn();
					
				}
				
		
			} catch (OutOfBoundException e1) {
			
				e1.printStackTrace();
		
			}
			
		}
		
		return returnString;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (!this.win && !this.draw) {
		
			if (e.getSource() == this.b00) {
			
				String s = this.insertPos(0,0);
			
				if (!s.equals("")) {
				
					this.b00.setText(s);
				
				}
			
			
			}


			if (e.getSource() == this.b01) {
			
				String s = this.insertPos(0,1);
				
				if (!s.equals("")) {
				
					this.b01.setText(s);
				
				}
			
			}
		
		
			if (e.getSource() == this.b02) {
			
				String s = this.insertPos(0,2);
				
				if (!s.equals("")) {
				
					this.b02.setText(s);
				
				}
			
			}
		
		
			if (e.getSource() == this.b10) {
			
				String s = this.insertPos(1,0);
				
				if (!s.equals("")) {
				
					this.b10.setText(s);
				
				}
			
			}
		
		
			if (e.getSource() == this.b11) {
			
				String s = this.insertPos(1,1);
				
				if (!s.equals("")) {
				
					this.b11.setText(s);
				
				}
			
			}
		
		
			if (e.getSource() == this.b12) {
			
				String s = this.insertPos(1,2);
				
				if (!s.equals("")) {
				
					this.b12.setText(s);
				
				}
			
			}		

		
			if (e.getSource() == this.b20) {
			
				String s = this.insertPos(2,0);
				
				if (!s.equals("")) {
				
					this.b20.setText(s);
				
				}
			
			}		

		
			if (e.getSource() == this.b21) {
			
				String s = this.insertPos(2,1);
				
				if (!s.equals("")) {
				
					this.b21.setText(s);
				
				}
			
			}		

		
			if (e.getSource() == this.b22) {
			
				String s = this.insertPos(2,2);
				
				if (!s.equals("")) {
				
					this.b22.setText(s);
				
				}
			
			}		
		
		}
		
		
		if (e.getSource() == this.resetButton) {
			
			this.resetGame();
			
		}
		
		if (e.getSource() == this.newGameButton) {
			
			this.newGame();
			
		}
		
		
		if (e.getSource() == this.exitButton) {
			
			System.exit(0);
			
		}
		
	}

	
	public static void main(String[] args) {
		
		try{ 
			   
			UIManager.setLookAndFeel(
			UIManager.getSystemLookAndFeelClassName());
		
		} catch(Exception e){
			
			e.printStackTrace();
		
		}
		
		TrisGui guiTris = new TrisGui();
		
		guiTris.setVisible(true);

	}

}

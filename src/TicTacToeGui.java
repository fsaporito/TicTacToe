import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TicTacToeGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private TIcTacToe tris;
	private AI AIplayer;

	private JLabel message;

	private JButton resetButton;
	private JButton newGameButton;
	private JButton exitButton;

	private JButton[][] buttonTable;

	private String turn;
	private boolean win;
	private boolean draw;
	private String stringWin;
	private static final String stringDraw = "Draw!!!";

	private static String p1;
	private static String p2;
	private static String s1;
	private static String s2;
	private static boolean AI;

	private int counterP1;
	private int counterP2;
	private int matches;


	private JLabel labelP1;
	private JLabel labelP2;

	private JLabel labelMatches;

	private TicTacToeGuiWin guiWin;


	public TicTacToeGui(String player1, String player2, String symbol1, String symbol2, boolean AIflag) throws WrongInputException  {

		super("Tris");
		this.setSize(400,400);
		this.setLayout(new BorderLayout());

		// Player Info Check
		TicTacToeGui.infoCheck(player1, player2, symbol1, symbol2);

		// Players Info
		p1 = player1;
		p2 = player2;
		s1 = symbol1;
		s2 = symbol2;
		AI = AIflag;

		// Panel Label
		JPanel panelLabel = new JPanel();
		panelLabel.setSize(400, 20);
		panelLabel.setLayout(new BorderLayout());
		this.add("North", panelLabel);


		// LabelX
		this.labelP1 = new JLabel("");
		panelLabel.add("West", this.labelP1);


		// LabelPlay
		this.message = new JLabel("X Play");
		JPanel panelMessage = new JPanel();
		panelMessage.add(this.message);
		panelLabel.add("Center", panelMessage);


		// LabelO
		this.labelP2 = new JLabel("");
		panelLabel.add("East", this.labelP2);


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

		// TableButton
		this.buttonTable = new JButton[3][3];

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				this.buttonTable[i][j] = new JButton("" + i + j);
				this.buttonTable[i][j].addActionListener(this);
				panelTris.add(this.buttonTable[i][j]);

			}

		}


		// AI
		if (AI) {

			this.AIplayer = new AI (symbol1, symbol2);

		}


		// Start New Game
		this.resetGame();

	}


	public static void infoCheck(String player1, String player2, String symbol1, String symbol2) throws WrongInputException {

		//------------ Player 2 ------------//

		// Player 1 Name Must Be Different From Null
		if (player1 == null) {

			throw new WrongInputException ("Player 1 Name Not Set (Is Null)!!!");

		}

		// Player 1 Name Must Be Less Than 10 Characters
		if (player1.length() > 10) {

			throw new WrongInputException ("Player 1 Name Must Be Less Than 10 Characters !!!");

		}


		// Player 1 Name Mustn't Be Composed Only By Spaces
		boolean allSpacesName1 = true;

		for (int i = 0; i < player1.length(); i++) {

			if (player1.charAt(i) != ' ') {

				allSpacesName1 = false;

				i = player1.length();

			}

		}

		if (allSpacesName1) {

			throw new WrongInputException ("Player 1 Name Mustn't Be Composed Only By Spaces !!!");

		}


		//------------ Player 2 ------------//

		// Player 2 Name Must Be Different From Null
		if (player2 == null) {

			throw new WrongInputException ("Player 2 Name Not Set (Is Null)!!!");

		}

		// Player 2 Name Must Be Less Than 10 Characters
		if (player2.length() > 10) {

			throw new WrongInputException ("Player 2 Name Must Be Less Than 10 Characters !!!");

		}


		// Player 1 Name Mustn't Be Composed Only By Spaces
		boolean allSpacesName2 = true;

		for (int i = 0; i < player2.length(); i++) {

			if (player2.charAt(i) != ' ') {

				allSpacesName2 = false;

				i = player2.length();

			}

		}

		if (allSpacesName2) {

			throw new WrongInputException ("Player 2 Name Mustn't Be Composed Only By Spaces !!!");

		}

		// The Players Names Must Be Different
		if (player1.equals(player2)) {

			throw new WrongInputException ("The Names Must Be Different !!!");

		}


		//------------ Symbol1 ------------//

		// Symbol1 Must Be Different From Null And Space
		if (symbol1 == null || symbol1.equals(" ")) {

			throw new WrongInputException ("Player 1 Symbol Not Set (Null Or Space) !!!");

		}

		// Symbol1 Must Be One Character
		if (symbol1.length() != 1) {

			throw new WrongInputException ("Player 1 Symbol Must Be Only One Characters !!!");

		}


		//------------ Symbol2 ------------//

		// Symbol2 Must Be Different From Null And Space
		if (symbol2 == null || symbol2.equals(" ")) {

			throw new WrongInputException ("Player 2 Symbol Not Set (Null Or Space) !!!");

		}

		// Symbol2 Must Be One Character
		if (symbol2.length() != 1) {

			throw new WrongInputException ("Player 2 Symbol Must Be Only One Characters !!!");

		}

		// The Players Symbols Must Be Different
		if (symbol1.equals(symbol2)) {

			throw new WrongInputException ("The Symbols Must Be Different !!!");

		}

		return;

	}


	private void resetGame () {

		this.counterP1 = 0;
		this.counterP2 = 0;
		this.matches = 0;

		this.turn = p1;

		this.newGame();

	}


	private void newGame () {

		this.tris = new TIcTacToe();

		this.matches += 1;

		this.win = false;

		this.draw = false;

		this.guiWin = null;

		this.stringWin = "";

		this.labelP1.setText(p1 + "  " + this.counterP1);

		this.labelP2.setText(this.counterP2 + "  " + p2);

		this.labelMatches.setText("Matches: " + this.matches);

		this.message.setText(this.turn + " plays");

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				this.buttonTable[i][j].setText("");

			}

		}

		if (AI) {

			if (this.turn.equals(p2)) {

				try {

					int values[] = this.AIplayer.move(this.tris.getTable(), s2);
					int i = values[0];
					int j = values [1];

					this.buttonTable[i][j].doClick();

				} catch (OutOfBoundException e) {

					e.printStackTrace();

				}

			}

		}

	}


	private void switchTurn () throws OutOfBoundException {

		if (this.turn.equals(p1)) {

			this.turn = p2;

			if (!this.win && !this.draw) {

				this.message.setText(p2 + " plays");

				if (AI) {

					int values[] = this.AIplayer.move(this.tris.getTable(), s2);

					int i = values[0];
					int j = values [1];

					this.buttonTable[i][j].doClick();


				}

			}

		}  else if (this.turn.equals(p2)) {

			this.turn = p1;

			if (!this.win && !this.draw) {

				this.message.setText(p1 + " plays");

			}

		}

	}


	private void insertPos (int i, int j) {

		if (!this.win && !this.draw) {

			try {

				if (this.turn.equals(p1)) {

					this.tris.setPos(i, j, s1);

					if (this.tris.checkVincitor(s1)) {

						this.stringWin = p1 + " Wins :)";

						this.counterP1++;

						this.labelP1.setText(p1 + " " + this.counterP1);

						this.message.setText(this.stringWin);

						this.win = true;

						this.newGameButton.setText("Continue");

						this.guiWin = new TicTacToeGuiWin(this.message.getText());

						this.guiWin.setVisible(true);

					}

					this.switchTurn();

				} else if (this.turn.equals(p2)) {

					this.tris.setPos(i, j, s2);

					if (this.tris.checkVincitor(s2)) {

						this.stringWin = p2 + " Wins :)";

						System.out.println(this.stringWin);

						this.counterP2++;

						this.labelP2.setText(this.counterP2 + "  " + p2);

						this.message.setText(this.stringWin);

						this.win = true;

						this.newGameButton.setText("Continue");

						this.guiWin = new TicTacToeGuiWin(this.message.getText());

						this.guiWin.setVisible(true);

					}

					this.switchTurn();

				}


				if (!this.win) {

					if (this.tris.checkDraw()) {

						this.message.setText(TicTacToeGui.stringDraw);

						this.draw = true;

						this.newGameButton.setText("Continue");

						System.out.println ("Draw 1");

						this.guiWin = new TicTacToeGuiWin(this.message.getText());

						this.guiWin.setVisible(true);

						if (this.turn.equals(p1)) {

							this.turn = p2;

						}  else if (this.turn.equals(p2)) {

							this.turn = p1;

						}

					}

				}


			} catch (OutOfBoundException e1) {

				e1.printStackTrace();

			}

		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (!this.win && !this.draw) {

			for (int i = 0; i < 3; i++) {

				for (int j = 0; j < 3; j++) {

					if (e.getSource() == this.buttonTable[i][j]) {

						try {

							if (this.buttonTable[i][j].getText().equals("") && this.tris.getStringAtPos(i,j).equals("")) {

								if (this.turn.equals(p1)) {

									this.buttonTable[i][j].setText(s1);

								} else if (this.turn.equals(p2)) {

									this.buttonTable[i][j].setText(s2);

								}

								this.insertPos(i,j);

							}

						} catch (OutOfBoundException e1) {

							e1.printStackTrace();

						}

					}

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

}

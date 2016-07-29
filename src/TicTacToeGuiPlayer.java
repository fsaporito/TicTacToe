import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JCheckBox;


public class TicTacToeGuiPlayer extends JFrame implements ActionListener {


	private JPanel pan; // General Panel

	private JLabel titleLabel; // Label With Instructions
	private JLabel errorLabel; // Label For Displaying Errors

	private JPanel panOk; // Panel For The OK Button
	private JButton ok; // Ok Button


	private JPanel panP1; // Player 1 Pan
	private JPanel panP2; // Player 2 Pan
	private JTextField p1TextName; // Player 1 Text Field For Name Input
	private JTextField p2TextName; // Player 2 Text Field For Name Input
	private JLabel p1NameLabel; // Player 1 Name Label
	private JLabel p2NameLabel; // Player 2 Name Label
	private JTextField p1TextSymbol; // Player 1 Text Field For Symbol Input
	private JTextField p2TextSymbol; // Player 2 Text Field For Symbol Input
	private JLabel p1SymbolLabel; // Player 1 Symbol Label
	private JLabel p2SymbolLabel; // Player 2 Symbol Label


	private JPanel panelAI; // AI Choice Panel
	private JCheckBox AIcheckBox; // AI Choice CheckBox
	private boolean AIenabled; // Boolean For AI Choice


	private String p1; // Player 1 Name
	private String p2; // Player 2 Name
	private String symbol1; // Player 1 Symbol
	private String symbol2; // Player 2 Symbol


	private static final long serialVersionUID = 1L;



	/**
	 * Constructor
	 */
	public TicTacToeGuiPlayer () {

		/*try{

			UIManager.setLookAndFeel(
			UIManager.getSystemLookAndFeelClassName());

		} catch(Exception e){

			e.printStackTrace();

		}*/

		try{

			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch(Exception e){

			e.printStackTrace();

		}


		// Set Window Size
		this.setSize(400,300);


		// Center Panel
		this.pan = new JPanel();
		this.pan.setLayout(new GridLayout(6,1));
		getContentPane().add("Center", this.pan);


		// Error Label
		this.titleLabel = new JLabel();
		this.titleLabel.setText("Input The Names And The Symbols For Each Player: ");
		this.pan.add(this.titleLabel);


		// AI Panel
		this.panelAI = new JPanel();
		this.pan.add(this.panelAI);
		this.AIcheckBox = new JCheckBox("Player vs Computer");
		this.panelAI.add(this.AIcheckBox);
		this.AIcheckBox.addActionListener(this);
		this.AIcheckBox.setSelected(false);
		this.AIenabled = false;


		// Player 1 Pan
		this.panP1 = new JPanel();
		this.panP1.setLayout(new GridLayout(2,2));
		this.pan.add(this.panP1);

		// Player 1 Name Label
		this.p1NameLabel = new JLabel();
		this.p1NameLabel.setText("Player 1 Name");
		this.panP1.add(this.p1NameLabel);

		// Player 1 Text Field For Name Input
		this.p1TextName = new JTextField(15);
		this.panP1.add(this.p1TextName);

		// Player 1 Symbol Label
		this.p1SymbolLabel = new JLabel();
		this.p1SymbolLabel.setText("Player 1 Symbol");
		this.panP1.add(this.p1SymbolLabel);

		// Player 1 Text Field For Symbol Input
		this.p1TextSymbol = new JTextField(3);
		this.panP1.add(this.p1TextSymbol);



		// Player 2 Pan
		this.panP2 = new JPanel();
		this.panP2.setLayout(new GridLayout(2,2));
		this.pan.add(this.panP2);

		// Player 2 Name Label
		this.p2NameLabel = new JLabel();
		this.p2NameLabel.setText("Player 2 Name");
		this.panP2.add(this.p2NameLabel);

		// Player 2 Text Field For Name Input
		this.p2TextName = new JTextField(15);
		this.panP2.add(this.p2TextName);

		// Player 2 Symbol Label
		this.p2SymbolLabel = new JLabel();
		this.p2SymbolLabel.setText("Player 2 Symbol");
		this.panP2.add(this.p2SymbolLabel);

		// Player 1 Text Field For Symbol Input
		this.p2TextSymbol = new JTextField(3);
		this.panP2.add(this.p2TextSymbol);


		// Error Label
		this.errorLabel = new JLabel();
		this.pan.add(this.errorLabel);


		//  Ok Panel&Button
		this.panOk = new JPanel();
		this.pan.add(this.panOk);
		this.ok = new JButton("Ok");
		this.ok.addActionListener(this);
		this.panOk.add(this.ok);



	}



	/**
	 * Action Performed Override
	 * - Check If AI Is Selected
	 * - Check Input
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == this.AIcheckBox) {

			if (this.AIcheckBox.isSelected()) {

				this.p2TextName.setText("Skynet");

				this.p2TextName.setEditable(false);

				this.p2TextSymbol.setText("S");

				this.p2TextSymbol.setEditable(false);

				this.AIenabled = true;

			} else {

				this.p2TextName.setText("");

				this.p2TextName.setEditable(true);

				this.p2TextSymbol.setText("");

				this.p2TextSymbol.setEditable(true);

				this.AIenabled = false;


			}

		}
		if (arg0.getSource() == this.ok) {

			boolean inputOk = true;

			try {

				TicTacToeGui.infoCheck(this.p1TextName.getText(),
									   this.p2TextName.getText(),
									   this.p1TextSymbol.getText(),
									   this.p2TextSymbol.getText());

			} catch (WrongInputException e) {

				this.errorLabel.setText(e.getMessage());

				this.errorLabel.setForeground(Color.red);

				inputOk = false;

			}

			// Input Is Correct
			if (inputOk) {

				this.p1 = this.p1TextName.getText();

				this.p2 = this.p2TextName.getText();

				this.symbol1 = this.p1TextSymbol.getText();

				this.symbol2 = this.p2TextSymbol.getText();

				this.setVisible(false);

			}

		}


	}




	/**
	 * @return the p1
	 */
	public String getP1() {

		return this.p1;

	}




	/**
	 * @return the p2
	 */
	public String getP2() {

		return this.p2;

	}




	/**
	 * @return the symbol1
	 */
	public String getSymbol1() {

		return this.symbol1;

	}




	/**
	 * @return the symbol2
	 */
	public String getSymbol2() {

		return this.symbol2;

	}



	/**
	 * @return the AIenabled boolean value
	 */
	public boolean getAIenabled() {

		return this.AIenabled;

	}



}

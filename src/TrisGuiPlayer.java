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


public class TrisGuiPlayer extends JFrame implements ActionListener {
	
	
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
	
	
	private String p1; // Player 1 Name
	private String p2; // Player 2 Name
	private String symbol1; // Player 1 Symbol
	private String symbol2; // Player 2 Symbol
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	public TrisGuiPlayer () {
		
		try{ 
			   
			UIManager.setLookAndFeel(
			UIManager.getSystemLookAndFeelClassName());
		
		} catch(Exception e){
			
			e.printStackTrace();
		
		}
		
		
		// Set Window Size
		this.setSize(400,300);
		
		
		// Center Panel
		this.pan = new JPanel();
		this.pan.setLayout(new GridLayout(5,1));
		this.add("Center", this.pan);
		
		
		// Error Label
		this.titleLabel = new JLabel();
		this.titleLabel.setText("Input The Names And The Symbols For Each Player: ");
		this.pan.add(this.titleLabel);		
		
		
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

	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == this.ok) {
			
			boolean inputOk = true;
			
			
			// Player 1 Name Must Be Different From Null
			if (this.p1TextName.getText() == null) { 
				
				this.errorLabel.setText("Player 1 Name Not Set !!!");
				
				inputOk = false;
				
			}
			
			
			// Player 1 Name Must Be Less Than 10 Characters
			if (inputOk && this.p1TextName.getText().length() > 10) { 
				
				this.errorLabel.setText("Player 1 Name Must Be Less Than 10 Characters !!!");
				
				inputOk = false;
				
			}
			
			
			// Player 1 Name Mustn't Be Composed Only By Spaces
			if (inputOk) { 
							
				boolean allSpacesName1 = true;
				
				for (int i = 0; i< this.p1TextName.getText().length(); i++) {
					
					if (this.p1TextName.getText().charAt(i) != ' ') {
						
						allSpacesName1 = false;
						
						i = this.p1TextName.getText().length();
						
					}
					
				}
				
				if (allSpacesName1) {
					
					this.errorLabel.setText("Player 1 Name Mustn't Be Composed Only By Spaces !!!");
							
					inputOk = false;
					
				}
					
			}
			
			
			// Player 2 Name Must Be Different From Null
			if (inputOk && this.p2TextName.getText() == null) { 
				
				this.errorLabel.setText("Player 2 Name Not Set !!!");
				
				inputOk = false;
				
			}
			
			
			// Player 2 Name Must Be Less Than 10 Characters
			if (inputOk && this.p2TextName.getText().length() > 10) { 
				
				this.errorLabel.setText("Player 2 Name Must Be Less Than 10 Characters !!!");
				
				inputOk = false;
				
			}
			
			
			// Player 2 Name Mustn't Be Composed Only By Spaces
			if (inputOk) { 
										
				boolean allSpacesName1 = true;
							
				for (int i = 0; i< this.p2TextName.getText().length(); i++) {
								
					if (this.p2TextName.getText().charAt(i) != ' ') {
									
						allSpacesName1 = false;
									
						i = this.p2TextName.getText().length();
									
					}
								
				}
							
				if (allSpacesName1) {
								
					this.errorLabel.setText("Player 2 Name Mustn't Be Composed Only By Spaces !!!");
										
					inputOk = false;
								
				}
								
			}
			
			
			
			// The Names Must Be Different
			if (inputOk && this.p1TextName.getText().equals(this.p2TextName.getText())) { 
				
				this.errorLabel.setText("The Names Must Be Different !!!");
				
				inputOk = false;
				
			}
			
			
			// Player 1 Symbol Must Be Different From Null And Space
			if (inputOk && this.p1TextSymbol.getText() == null || this.p1TextSymbol.getText().equals(" ")) { 
							
				this.errorLabel.setText("Player 1 Symbol Not Set !!!");
							
				inputOk = false;
							
			}
						
						
			// Player 1 Symbol Must Be One Character
			if (inputOk && this.p1TextSymbol.getText().length() != 1) { 
							
				this.errorLabel.setText("Player 1 Symbol Must Be Only One Characters !!!");
							
				inputOk = false;
							
			}
						
						
			// Player 2 Symbol Must Be Different From Null And Space
			if (inputOk && this.p2TextSymbol.getText() == null || this.p2TextSymbol.getText().equals(" ")) { 
										
				this.errorLabel.setText("Player 2 Symbol Not Set !!!");
										
				inputOk = false;
										
			}
						
						
			// Player 2 Symbol Must Be One Character
			if (inputOk && this.p1TextSymbol.getText().length() != 1) { 
										
				this.errorLabel.setText("Player 1 Symbol Must Be Only One Characters !!!");
										
				inputOk = false;
										
			}
			
			
			// The Symbols Must Be Different
			if (inputOk && this.p1TextSymbol.getText().equals(this.p2TextSymbol.getText())) { 
							
				this.errorLabel.setText("The Symbols Must Be Different!!!");
							
				inputOk = false;
							
			}
			
			this.errorLabel.setForeground(Color.red);
			
			
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

	
	
	
}

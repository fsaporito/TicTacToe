import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class TickTackToeGuiWin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton ok;
	
	public TickTackToeGuiWin (String vincitor) {
		
		super(vincitor);
		
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
		
		this.setSize(200,200);
		
		// General Panel
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		this.add(panel1);
		
		
		// Label
		JLabel label = new JLabel(vincitor);
		JLabel labelEmpty = new JLabel(" ");
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,3));
		panel2.add(labelEmpty);
		panel2.add(label);
		panel1.add(panel2);
		
		
		// Button OK
		this.ok = new JButton("Ok");
		this.ok.addActionListener(this);
		JPanel panel3 = new JPanel();
		panel3.add("North", this.ok);
		panel1.add(panel3);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == this.ok) {
			
			this.setVisible(false);
			
		}
		

	}

}

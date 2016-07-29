import javax.swing.UIManager;


public class GameMain {

	public static void main (String[] args) {

		String p1;
		String p2;
		String symbol1;
		String symbol2;
		boolean AIenabled;

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

		TicTacToeGuiPlayer guiPlayer = new TicTacToeGuiPlayer();

		guiPlayer.setVisible(true);


		while (guiPlayer.isShowing()) {

			try {

				Thread.sleep(700);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}


		p1 = guiPlayer.getP1();
		p2 = guiPlayer.getP2();
		symbol1 = guiPlayer.getSymbol1();
		symbol2 = guiPlayer.getSymbol2();
		AIenabled = guiPlayer.getAIenabled();



		if (p1 == null) {

			p1 = "p1";

		}

		if (p2 == null) {

			p2 = "p2";

		}

		if (symbol1 == null) {

			symbol1 = "X";

		}

		if (symbol2 == null) {

			symbol2 = "O";

		}

		TicTacToeGui guiTris;
		try {

			guiTris = new TicTacToeGui(p1, p2, symbol1, symbol2, AIenabled);

			guiTris.setVisible(true);

		} catch (WrongInputException e) {

			e.printStackTrace();

		}

	}

}

import javax.swing.JFrame;

public class Game {
	public static void main(String[] args) {
		GuessNumberGame app = new GuessNumberGame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500, 200);
		app.setVisible(true);
	}
}

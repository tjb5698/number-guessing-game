import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuessNumberGame extends JFrame{

	private int secretNumber, guessCount;
	private int lastDistance;
	private JTextField guessInput;
	private JLabel prompt1, prompt2, message;
	private JButton newGame;
	Container container;
	
	public GuessNumberGame()
	{
		super("Number Guessing Game");
		guessCount = 0;
		container = getContentPane();
		container.setBackground(Color.lightGray);
		theGame();
		prompt1 = new JLabel ("I have a number between 1 and 1000. Can you guess my number?");
		prompt2 = new JLabel ("Please enter your First Guess:");
		guessInput = new JTextField(5);
		guessInput.addActionListener(new GuessHandler());
		message = new JLabel ("Guess result appears here.");
		newGame = new JButton("New Game");
		newGame.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent evt)
			{
				message.setText("Guessresult appears here.");
				guessInput.setText(" ");
				guessInput.setEditable(true);
				container.setBackground(Color.lightGray);
				theGame();
			}
				});
		container.setLayout(new FlowLayout());
		container.add(prompt1);
		container.add(prompt2);
		container.add(guessInput);
		container.add(message);
		container.add(newGame);
		setSize(300,150);
		setVisible(true);
		
	}
	
	public void theGame()
	{
		secretNumber = (int) (Math.random() * 999 + 1);		
	}
	
	public void react (int guess)
	{
		int currentDistance =1000;
	  /*  while (guess!=secretNumber) {*/
	          guessCount ++;
	          if(guess!=secretNumber && guessCount == 1)
	        	  {
	        	    lastDistance = Math.abs(guess-secretNumber);
	                if (guess>secretNumber)
	              	  message.setText("Too high. Try a lower number.");
	                else
	              	  message.setText("Too low. Try a higher number.");
	              }
	           else if(guess!=secretNumber && guessCount!=1)
	        	   {
	            	 currentDistance = Math.abs(guess - secretNumber);
	            	  if(guess>secretNumber) 
	            	  {
	            		message.setText("Too high. Try a lower number.");
	            		container.setBackground((currentDistance <= lastDistance)?Color.red:Color.blue);
	            		lastDistance = currentDistance;
	            	  }
	            	  else
	            	  {
	            		  message.setText("Too low. Try a higher number.");
	            		  container.setBackground((currentDistance <= lastDistance)?Color.red:Color.blue);
	            		  lastDistance = currentDistance;
	            	  }
	            	}
	     /* } */
	           else if (guess == secretNumber)
        {
      	  message.setText("Correct!");
      	  container.setBackground(Color.lightGray);
      	  guessInput.setEditable(false);
      	  guessCount = 0;
        }
	  }
		
	public class GuessHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			int guess= Integer.parseInt(guessInput.getText());
			react(guess);
		}
  }
}
	


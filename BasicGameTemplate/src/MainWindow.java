import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.UnitTests;

//NIKOLA ZLOKAPA, 20207414

/*
 * Created by Abraham Campbell on 15/01/2020.
 *   Copyright (c) 2020  Abraham Campbell

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
   
   (MIT LICENSE ) e.g do what you want with this :-) 
 */

public class MainWindow {

	private static JFrame frame = new JFrame("Mazeman"); // Change to the name of your game
	private static JComboBox<String> cb;
	private static JComboBox<String> cb2;
	private static JButton btn2;
	private static JButton btn;
	private static Model gameworld;
	private static Viewer canvas;
//	private static Model gameworld = new Model();
//	private static Viewer canvas = new Viewer(gameworld);
	private static KeyListener Controller = new Controller();
	private static int TargetFPS = 100;
	private static boolean startGame = false;
	private static JLabel BackgroundImageForStartMenu;
	private static JLabel BackgroundImageForGameOver;
	private static boolean restartGame = false;
	private static JButton restartGameBtn;
	private static boolean restartGameMenu = false;
	private static JButton startMenuButton;
	private static JButton test;
	private static int currentLevel;
	private static long startTime;
	private static long winningTime;
	private static long totalTime;
	private static long minutes;
	private static long seconds;
	private static String difficulty = "EASY";
	private static String noPlayers = "TWO";
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();

	public MainWindow() throws FileNotFoundException {
		currentLevel = 0;

		gameworld = new Model(0, "EASY", "ONE");
		canvas = new Viewer(gameworld);

		frame.setSize(975, 1000); // you can customise this later and adapt it to change on size.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If exit // you can modify with your way of quitting ,
																// just is a template.
		frame.setLayout(null);
		frame.add(canvas);
		canvas.setBounds(0, 0, 975, 1000);
		canvas.setBackground(new Color(255, 255, 255)); // white background replaced by Space background but if you
														// remove the background method this will draw a white screen
		canvas.setVisible(false); // this will become visible after you press the key.

		startMenuButton = new JButton("Start Game"); // start button

		startMenuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				panel.setVisible(false);
				panel2.setVisible(false);
				startMenuButton.setVisible(false);
				test.setVisible(false);
				BackgroundImageForStartMenu.setVisible(false);
				canvas.setVisible(true);
				canvas.addKeyListener(Controller); // adding the controller to the Canvas
				canvas.requestFocusInWindow(); // making sure that the Canvas is in focus so keyboard input will be
												// taking in .
				startGame = true;
				restartGameMenu = false;

				if (currentLevel == 1) {
					startTime = System.currentTimeMillis();
				}
				System.out.println("OUTPUT BTN 1 " + noPlayers);
				System.out.println("OUTPUT BTN 2 " + difficulty);
			}
		});
		startMenuButton.setBounds(400, 500, 200, 40);

		// loading background image
		File BackroundToLoad = new File("res/mainScreen.v1COPY.png"); // should work okay on OSX and Linux but check if
																		// you
																		// have issues depending your eclipse install or
																		// if
																		// your running this without an IDE
		try {

			BufferedImage myPicture = ImageIO.read(BackroundToLoad);
			BackgroundImageForStartMenu = new JLabel(new ImageIcon(myPicture));
			BackgroundImageForStartMenu.setBounds(0, 0, 1000, 1000);
			// displayDropDownMenu();
			frame.add(BackgroundImageForStartMenu);

		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.add(startMenuButton);

		test = new JButton("Start Game"); // start button
		test.setText(getHighScore());
		test.setBounds(570, 150, 200, 40);
		test.setBackground(Color.BLACK);
		test.setForeground(Color.RED);
		test.setFont(new Font("Arial", Font.PLAIN, 40));
		test.setBorderPainted(false);
		test.setFocusPainted(false);
		frame.add(test);

		startMenuButton.setBackground(Color.BLACK);
		startMenuButton.setForeground(Color.WHITE);

		frame.setVisible(true);

		displayDropDownMenu();
	}

	public static void main(String[] args) throws IOException {
		MainWindow hello = new MainWindow(); // sets up environment
		while (true) // not nice but remember we do just want to keep looping till the end. // this
						// could be replaced by a thread but again we want to keep things simple
		{
			// swing has timer class to help us time this but I'm writing my own, you can of
			// course use the timer, but I want to set FPS and display it

			int TimeBetweenFrames = 1000 / TargetFPS;
			long FrameCheck = System.currentTimeMillis() + (long) TimeBetweenFrames;

			// wait till next time step
			while (FrameCheck > System.currentTimeMillis()) {
			}

			if (startGame) {
				gameloop();

			}

			if (gameworld.getGameWon() == true) {
				if (currentLevel == 0) {
					currentLevel = 1;
					displayGameWinnerScreen(currentLevel, "Play Next Level");
				} else if (currentLevel == 1) {
					displayGameWinnerScreen(currentLevel, "Restart Game");

					String outcome = totalTime + ",";
					File f = new File("playerTimes.txt");
					if (!f.exists()) {
						try {
							f.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					FileOutputStream outputStream = null;
					try {
						outputStream = new FileOutputStream("playerTimes.txt", true);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					byte[] strToBytes = outcome.getBytes();
					outputStream.write(strToBytes);
					outputStream.close();
				}

			}

			if (gameworld.getPlayersAlive() < 1) {

				if (currentLevel == 0) {
					displayGameOverScreen(currentLevel, "Restart Level 1");
				} else if (currentLevel == 1) {
					displayGameOverScreen(currentLevel, "Restart Level 2");
				}

				// displayGameOverScreen("res/gameOver.png", "Restart Game");
			}
//			 UNIT test to see if framerate matches
			UnitTests.CheckFrameRate(System.currentTimeMillis(), FrameCheck, TargetFPS);

		}

	}

	// Basic Model-View-Controller pattern
	private static void gameloop() {
		// GAMELOOP

		// controller input will happen on its own thread
		// So no need to call it explicitly

		// model update

		gameworld.gamelogic();
		// view update

		canvas.updateview();

		winningTime = System.currentTimeMillis();

		if (startTime > 0) {
			totalTime = winningTime - startTime;
			minutes = (totalTime / 1000) / 60;
			seconds = (totalTime / 1000) % 60;
			frame.setTitle("Current time :  " + minutes + ":" + seconds);
		}

	}

	private static void displayGameOverScreen(int level, String btnMsg) {

		if (restartGameMenu == false) {

			canvas.setVisible(false);

			if (level == 0) {
				gameworld = new Model(level, difficulty, "ONE");
			} else {
				gameworld = new Model(level, difficulty, noPlayers);
			}

			canvas = new Viewer(gameworld);
			frame.setSize(975, 1000); // you can customise this later and adapt it to change on size.
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If exit // you can modify with your way of quitting
																	// ,
																	// just is a template.
			frame.setLayout(null);
			frame.add(canvas);
			canvas.setBounds(0, 0, 975, 1000);
			canvas.setBackground(new Color(255, 255, 255)); // white background replaced by Space background but if you
															// remove the background method this will draw a white
															// screen
			canvas.setVisible(false); // this will become visible after you press the key.

			File BackroundToLoad = new File("res/gameOverimg.png"); // should work okay on OSX and Linux but check if
			startMenuButton.setVisible(true); // you have issues
			startMenuButton.setText(btnMsg);
			// depending your eclipse install or if your running this without an
			// IDE
			try {

				BufferedImage myPicture = ImageIO.read(BackroundToLoad);
				BackgroundImageForStartMenu = new JLabel(new ImageIcon(myPicture));
				BackgroundImageForStartMenu.setBounds(0, 0, 1000, 1000);
				frame.add(BackgroundImageForStartMenu);

			} catch (IOException e) {
				e.printStackTrace();
			}

			frame.add(startMenuButton);
			frame.setVisible(true);

			restartGameMenu = true;

		}

	}

	private static void displayGameWinnerScreen(int level, String btnMsg) {

		canvas.setVisible(false);

		if (level == 0) {
			gameworld = new Model(level, difficulty, "ONE");
		} else {
			gameworld = new Model(level, difficulty, noPlayers);
		}
		canvas = new Viewer(gameworld);
		frame.setSize(975, 1000); // you can customise this later and adapt it to change on size.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If exit // you can modify with your way of quitting ,
																// just is a template.
		frame.setLayout(null);
		frame.add(canvas);
		canvas.setBounds(0, 0, 975, 1000);
		canvas.setBackground(new Color(255, 255, 255)); // white background replaced by Space background but if you
														// remove the background method this will draw a white screen
		canvas.setVisible(false); // this will become visible after you press the key.

		File BackroundToLoad = new File("res/winner.png"); // should work okay on OSX and Linux but check if
		startMenuButton.setVisible(true); // you have issues
		startMenuButton.setText(btnMsg);
		// depending your eclipse install or if your running this without an
		// IDE
		try {

			BufferedImage myPicture = ImageIO.read(BackroundToLoad);
			BackgroundImageForStartMenu = new JLabel(new ImageIcon(myPicture));
			BackgroundImageForStartMenu.setBounds(0, 0, 1000, 1000);
			frame.add(BackgroundImageForStartMenu);

		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.add(startMenuButton);
		frame.setVisible(true);

		restartGameMenu = true;

	}

	private String getHighScore() throws FileNotFoundException {

		Scanner inFile1 = new Scanner(new File("playerTimes.txt")).useDelimiter(",");
		long fastestTime = Long.MAX_VALUE;
		String returnTime = "";

		List<Long> temps = new ArrayList<Long>();

		// while loop
		while (inFile1.hasNext()) {
			// find next line
			long token1 = inFile1.nextLong();
			temps.add(token1);
		}
		inFile1.close();

		Long[] tempsArray = temps.toArray(new Long[0]);

		for (Long s : tempsArray) {
			if (s < fastestTime) {
				fastestTime = s;
			}
			System.out.println(s);
		}

		if (fastestTime != Long.MAX_VALUE) {

			int min = (int) ((fastestTime / 1000) / 60);
			int sec = (int) ((fastestTime / 1000) % 60);

			returnTime = String.valueOf(min + ":" + sec);
		}

		return returnTime;
	}

	private void displayDropDownMenu() {

		frame.setVisible(true);

		panel = new JPanel();
		panel.setBounds(30, 10, 200, 200);
		// panel.setBackground(Color.BLACK);
		frame.add(panel);

		JLabel lbl = new JLabel("PLAYERS :  ");
		lbl.setForeground(Color.WHITE);
		// lbl.setBackground(Color.BLACK);
		lbl.setVisible(true);

		panel.add(lbl);

		String[] choices = { "TWO", "SINGLE" };

		cb = new JComboBox<String>(choices);
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				noPlayers = e.getItem().toString();
			}
		});
		cb.setForeground(Color.RED);
		// cb.setBackground(Color.BLACK);
		cb.setVisible(true);
		panel.add(cb);

		panel2 = new JPanel();
		panel2.setBounds(30, 10, 200, 200);
		// panel2.setBackground(Color.BLACK);
		frame.add(panel2);

		JLabel lbl2 = new JLabel("DIFFICULTY :");
		lbl2.setForeground(Color.WHITE);
		// lbl2.setBackground(Color.BLACK);
		lbl2.setVisible(true);

		panel.add(lbl2);

		String[] choices2 = { "EASY", "MEDIUM", "HARD" };

		cb2 = new JComboBox<String>(choices2);

		cb2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				difficulty = e.getItem().toString();
			}
		});

		cb2.setForeground(Color.RED);
		// cb2.setBackground(Color.BLACK);

		cb.setVisible(true);
		panel.add(cb2);

	}

}

/*
 * 
 * 
 * 
 * Hand shake agreement
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,=+++
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * :::::::::::::::::::::::::::::::::::::::::::,,,,,,:::::,=+++????
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * :::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,:++++????+??
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * ::::::::::::::::::,:,:,,:,:,,,,,,,,,,,,,,,,,,,,++++++?+++++????
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * :::::::::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,=++?+++++++++++??????
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * ::::,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,~+++?+++?++?++++++++++?????
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,:
 * ::,,,,,,,,,,,,,,,,,,,,,,,,,,,~+++++++++++++++????+++++++???????
 * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,:,,,,,
 * ,,,,,,,,,,,,,,,,,:===+=++++++++++++++++++++?+++????????????????
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,,,,,,,,
 * ,,,,,,,,,,~=~~~======++++++++++++++++++++++++++????????????????
 * ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,::::,,,,,,=~.,
 * ,,,,,,+===~~~~~~====++++++++++++++++++++++++++++???????????????
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::,:,,,,,~~.~??++~.,
 * ~~~~~======~=======++++++++++++++++++++++++++????????????????II
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::,:,,,,:=+++??=====~~~~
 * ~~====================+++++++++++++++++++++?????????????????III
 * :::::::::::::::::::::::::::::::::::::::::::::::::::,:,,,++~~~=+=~~~~~~==~~~::
 * ::~~==+++++++==++++++++++++++++++++++++++?????????????????IIIII
 * ::::::::::::::::::::::::::::::::::::::::::::::::,:,,,:++++==+??+=======~~~~=~
 * ::~~===++=+??++++++++++++++++++++++++?????????????????I?IIIIIII
 * ::::::::::::::::::::::::::::::::::::::::::::::::,,:+????+==??+++++?++====~~~~
 * ~:~~~++??+=+++++++++?++++++++++??+???????????????I?IIIIIIII7I77
 * ::::::::::::::::::::::::::::::::::::::::::::,,,,+???????++?+?+++???7?++======
 * ~~+=====??+???++++++??+?+++???????????????????IIIIIIIIIIIIIII77
 * :::::::::::::::::::::::::::::::::::::::,,,,,,=??????IIII7???+?+II$Z77??+++?+=
 * +++++=~==?++?+?++?????????????III?II?IIIIIIIIIIIIIIIIIIIIIIIIII
 * ::::::::::::::::::::::::::::::,,,,,,~=======++++???III7$???+++++Z77ZDZI?????I
 * ?777I+~~+=7+?II??????????????IIIIIIIIIIIIIIIIIIIIII??=:,,,,,,,,
 * ::::::::,:,:,,,,,,,:::~==+=++++++++++++=+=+++++++???I7$7I?+~~~I$I??++??
 * I78DDDO$7?++==~I+7I7IIIIIIIIIIIIIIIIII777I?=:,,,,,,,,,,,,,,,,,,,,,,,,
 * ++=++=++++++++++++++?+????+??????????+===+++++????I7$$ZZ$I+=~$7I???++++++===~
 * ~==7??++==7II?~,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * +++++++++++++?+++?++????????????IIIII?I+??I???????I7$ZOOZ7+=~7II?+++?II?I?+++
 * =+=~~~7?++:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * +?+++++????????????????I?I??I??IIIIIIII???II7II??I77$ZO8ZZ?~~7I?+==++?O7II??+
 * ??+=====.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * ?????????????III?II?????I?????IIIII???????II777IIII7$ZOO7?+~+7I?+=~~+???
 * 7NNN7II?+=+=++,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * ????????????IIIIIIIIII?IIIIIIIIIIII????II?III7I7777$ZZOO7++=$77I???==+++????
 * 7ZDN87I??=~,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * IIII?II??IIIIIIIIIIIIIIIIIIIIIIIIIII???+??II7777II7$$OZZI?+$$$$77IIII????????
 * ?++=+.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII?+++?IIIII7777$$$$$$7$$$$7IIII7I$IIIIII?
 * ??I+=,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII???????IIIIII77I7777$7$$$II????I??
 * I7Z87IIII?=,,,,,,,,,,,:,,::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * 777777777777777777777I7I777777777~,,,,,,,+77IIIIIIIIIII7II7$$$Z$?I????III???
 * II?,,,,,,,,,,::,::::::::,,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * 777777777777$77777777777+::::::::::::::,,,,,,,=7IIIII78ZI?II78$7++D7?7O777II?
 * ?:,,,:,,,::::::::::::::,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * $$$$$$$$$$$$$77=:,:::::::::::::::::::::::::::,,7II$,,8ZZI++$8ZZ?+=ZI==IIII,+7
 * :,,,,:::::::::::::::::,:::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * $$$I~::::::::::::::::::::::::::::::::::::::::::II+,,,OOO7?$DOZII$I$I7=77?,,,,
 * ,,:::::::::::::::::::::,,,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * ::::::::::::::::::::::::::::::::::::::::::::::::::::::+ZZ?,$ZZ$77ZZ$?,,,,,:::
 * :::::::::::::::::::::::,::::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::I$::::::::::::::
 * :::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * ::::::::::::::::::::::::::::::,,,:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * ::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * ::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,,,,,,
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * ::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,,,,
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * :::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * :::::::::::::::::::::::::::::::::::::::::,,,,,,,,,,,,,,,,,,,,,,
 * GlassGiant.com
 * 
 * 
 */

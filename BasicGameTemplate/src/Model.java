import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//import application.Box;
import util.GameObject;
import util.Point3f;
import util.Vector3f;

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
public class Model {

	private int level;
	private GameObject enemyUp;
	private GameObject enemyDown;
	private GameObject enemyLeft;
	private GameObject enemyRight;

	private GameObject Player;
	private GameObject Player2;

	private GameObject key1;
	private GameObject key2;
	private GameObject key3;
	private GameObject key4;
	private GameObject key5;
	private GameObject key6;
	private GameObject key7;
	private GameObject key8;

	private GameObject testingPlayer1;
	private GameObject testingPlayer2;

	private GameObject leftWall;
	private GameObject rightWall;
	private GameObject topWall;
	private GameObject bottomWall;

	private GameObject spriteWall1;
	private GameObject spriteWall2;
	private GameObject spriteWall3;
	private GameObject spriteWall4;
	private GameObject spriteWall5;
	private GameObject spriteWall6;
	private GameObject spriteWall7;
	private GameObject spriteWall8;
	private GameObject spriteWall9;
	private GameObject spriteWall10;
	private GameObject spriteWall11;
	private GameObject spriteWall12;
	private GameObject spriteWall13;
	private GameObject spriteWall14;
	private GameObject spriteWall15;
	private GameObject spriteWall16;
	private GameObject spriteWall17;
	private GameObject spriteWall18;
	private GameObject spriteWall19;
	private GameObject spriteWall20;
	private GameObject spriteWall21;
	private GameObject spriteWall22;
	private GameObject spriteWall23;
	private GameObject spriteWall24;
	private GameObject spriteWall25;
	private GameObject spriteWall26;
	private GameObject spriteWall27;
	private GameObject spriteWall28;
	private GameObject spriteWall29;
	private GameObject spriteWall30;
	private GameObject spriteWall31;
	private GameObject spriteWall32;
	private GameObject spriteWall33;
	private GameObject spriteWall34;
	private GameObject spriteWall35;
	private GameObject spriteWall36;
	private GameObject spriteWall37;
	private GameObject spriteWall38;
	private GameObject spriteWall39;
	private GameObject spriteWall40;
	private GameObject spriteWall41;
	private GameObject spriteWall42;
	private GameObject exitDoor;
	private GameObject exitDoorMsg;
	private GameObject testSprite;
	private int playersAlive;
	private int difficulty;
	private int noPlayers;

	private GameObject img1;
	private GameObject wrongKey;

	private boolean gameWon = false;

	private Controller controller = Controller.getInstance();
	private CopyOnWriteArrayList<GameObject> EnemiesList = new CopyOnWriteArrayList<GameObject>();
	private CopyOnWriteArrayList<GameObject> BulletList = new CopyOnWriteArrayList<GameObject>();
	private CopyOnWriteArrayList<GameObject> keyList = new CopyOnWriteArrayList<GameObject>();
	private CopyOnWriteArrayList<GameObject> playerList = new CopyOnWriteArrayList<GameObject>();
	private int Score = 0;
	private int counter = 0;
	private boolean printKey = false;

	private int skeletonInteractionCounter;

	public Model(int level, String difficulty, String noPlayers) {
		// setup game world
		// Player

		this.level = level;

		if (difficulty == "HARD") {
			this.difficulty = 3;
		} else if (difficulty == "MEDIUM") {
			this.difficulty = 2;
		} else {
			this.difficulty = 1;
		}

		if (noPlayers == "TWO") {
			this.noPlayers = 2;
		} else {
			this.noPlayers = 1;

		}

		// 337, 337, 288, 96

		if (this.noPlayers == 2) {
			Player2 = new GameObject("res/Char_walk_up.png", 40, 40, new Point3f(100, 820, 0));
			playerList.add(Player2);
			playersAlive++;
		} else {
			Player2 = new GameObject("res/Char_walk_up.png", 0, 0, new Point3f(0, 0, 0));
		}
		Player = new GameObject("res/Char_walk_up.png", 40, 40, new Point3f(100, 820, 0));

		playerList.add(Player);
		playersAlive++;

		if (level == 0) {

			spriteWall1 = new GameObject("res/bullet.png", 280, 22, new Point3f(338, 482, 0));
			spriteWall2 = new GameObject("res/bullet.png", 117, 22, new Point3f(505, 603, 0));
			spriteWall3 = new GameObject("res/bullet.png", 22, 140, new Point3f(338, 482, 0));
			spriteWall4 = new GameObject("res/bullet.png", 22, 140, new Point3f(600, 482, 0));
			spriteWall5 = new GameObject("res/bullet.png", 120, 22, new Point3f(338, 603, 0));
			spriteWall6 = new GameObject("res/bullet.png", 45, 143, new Point3f(100, 674, 0));
			spriteWall7 = new GameObject("res/bullet.png", 44, 110, new Point3f(195, 768, 0));
			spriteWall8 = new GameObject("res/bullet.png", 572, 44, new Point3f(195, 768, 0));
			spriteWall9 = new GameObject("res/bullet.png", 45, 120, new Point3f(459, 674, 0));
			spriteWall10 = new GameObject("res/bullet.png", 162, 44, new Point3f(243, 674, 0));
			spriteWall11 = new GameObject("res/bullet.png", 159, 44, new Point3f(562, 674, 0));
			spriteWall12 = new GameObject("res/bullet.png", 44, 88, new Point3f(723, 338, 0));
			spriteWall13 = new GameObject("res/bullet.png", 45, 200, new Point3f(676, 482, 0));
			spriteWall14 = new GameObject("res/bullet.png", 44, 280, new Point3f(625, 145, 0));
			spriteWall15 = new GameObject("res/bullet.png", 88, 88, new Point3f(723, 55, 0));
			spriteWall16 = new GameObject("res/bullet.png", 44, 88, new Point3f(723, 195, 0));
			spriteWall17 = new GameObject("res/bullet.png", 150, 44, new Point3f(723, 195, 0));
			spriteWall18 = new GameObject("res/bullet.png", 150, 44, new Point3f(723, 390, 0));
			spriteWall19 = new GameObject("res/bullet.png", 67, 44, new Point3f(100, 674, 0));
			spriteWall20 = new GameObject("res/bullet.png", 240, 22, new Point3f(150, 696, 0));
			spriteWall21 = new GameObject("res/bullet.png", 22, 80, new Point3f(383, 600, 0));
			spriteWall22 = new GameObject("res/bullet.png", 60, 22, new Point3f(499, 674, 0));
			spriteWall23 = new GameObject("res/bullet.png", 22, 70, new Point3f(722, 420, 0));
			spriteWall24 = new GameObject("res/bullet.png", 22, 70, new Point3f(600, 420, 0));
			spriteWall25 = new GameObject("res/bullet.png", 22, 70, new Point3f(723, 280, 0));
			spriteWall26 = new GameObject("res/bullet.png", 70, 22, new Point3f(670, 121, 0));
			spriteWall27 = new GameObject("res/bullet.png", 70, 22, new Point3f(450, 600, 0));

		} else if (level == 1) {
			spriteWall1 = new GameObject("res/bullet.png", 230, 44, new Point3f(338, 380, 0));
			spriteWall2 = new GameObject("res/bullet.png", 44, 120, new Point3f(530, 267, 0));
			spriteWall3 = new GameObject("res/bullet.png", 280, 22, new Point3f(338, 482, 0));
			spriteWall4 = new GameObject("res/bullet.png", 117, 22, new Point3f(505, 603, 0));
			spriteWall5 = new GameObject("res/bullet.png", 22, 140, new Point3f(338, 482, 0));
			spriteWall6 = new GameObject("res/bullet.png", 22, 140, new Point3f(600, 482, 0));
			spriteWall7 = new GameObject("res/bullet.png", 120, 22, new Point3f(338, 603, 0));
			spriteWall8 = new GameObject("res/bullet.png", 45, 143, new Point3f(100, 674, 0));
			spriteWall9 = new GameObject("res/bullet.png", 44, 110, new Point3f(195, 768, 0));
			spriteWall10 = new GameObject("res/bullet.png", 572, 44, new Point3f(195, 768, 0));
			spriteWall11 = new GameObject("res/bullet.png", 45, 120, new Point3f(459, 674, 0));
			spriteWall12 = new GameObject("res/bullet.png", 162, 44, new Point3f(243, 674, 0));
			spriteWall13 = new GameObject("res/bullet.png", 159, 44, new Point3f(562, 674, 0));
			spriteWall14 = new GameObject("res/bullet.png", 44, 44, new Point3f(770, 674, 0));
			spriteWall15 = new GameObject("res/bullet.png", 44, 88, new Point3f(723, 338, 0));
			spriteWall16 = new GameObject("res/bullet.png", 45, 138, new Point3f(820, 674, 0));
			spriteWall17 = new GameObject("res/bullet.png", 45, 200, new Point3f(676, 482, 0));
			spriteWall18 = new GameObject("res/bullet.png", 44, 144, new Point3f(770, 482, 0));
			spriteWall19 = new GameObject("res/bullet.png", 44, 195, new Point3f(243, 482, 0));
			spriteWall20 = new GameObject("res/bullet.png", 44, 136, new Point3f(243, 288, 0));
			spriteWall21 = new GameObject("res/bullet.png", 235, 44, new Point3f(150, 195, 0));
			spriteWall22 = new GameObject("res/bullet.png", 22, 66, new Point3f(243, 70, 0));
			spriteWall23 = new GameObject("res/bullet.png", 44, 22, new Point3f(243, 120, 0));
			spriteWall24 = new GameObject("res/bullet.png", 44, 22, new Point3f(337, 120, 0));
			spriteWall25 = new GameObject("res/bullet.png", 22, 44, new Point3f(361, 70, 0));
			spriteWall26 = new GameObject("res/bullet.png", 44, 164, new Point3f(148, 120, 0));
			spriteWall27 = new GameObject("res/bullet.png", 44, 140, new Point3f(148, 340, 0));
			spriteWall28 = new GameObject("res/bullet.png", 44, 71, new Point3f(148, 554, 0));
			spriteWall29 = new GameObject("res/bullet.png", 90, 45, new Point3f(95, 240, 0));
			spriteWall30 = new GameObject("res/bullet.png", 44, 164, new Point3f(433, 120, 0));
			spriteWall31 = new GameObject("res/bullet.png", 137, 44, new Point3f(340, 290, 0));
			spriteWall32 = new GameObject("res/bullet.png", 44, 120, new Point3f(575, 70, 0));
			spriteWall33 = new GameObject("res/bullet.png", 44, 280, new Point3f(625, 145, 0));
			spriteWall34 = new GameObject("res/bullet.png", 120, 44, new Point3f(528, 170, 0));
			spriteWall35 = new GameObject("res/bullet.png", 88, 88, new Point3f(723, 55, 0));
			spriteWall36 = new GameObject("res/bullet.png", 44, 88, new Point3f(723, 195, 0));
			spriteWall37 = new GameObject("res/bullet.png", 150, 44, new Point3f(722, 195, 0));
			spriteWall38 = new GameObject("res/bullet.png", 150, 44, new Point3f(722, 390, 0));
			spriteWall39 = new GameObject("res/bullet.png", 120, 22, new Point3f(148, 482, 0));
			spriteWall40 = new GameObject("res/bullet.png", 137, 45, new Point3f(150, 240, 0));
			spriteWall41 = new GameObject("res/bullet.png", 67, 44, new Point3f(100, 674, 0));
			spriteWall42 = new GameObject("res/bullet.png", 9, 9, new Point3f(760, 810, 0));

		}

		leftWall = new GameObject("res/bullet.png", 22, 840, new Point3f(75, 50, 0));
		topWall = new GameObject("res/bullet.png", 815, 22, new Point3f(75, 50, 0));
		bottomWall = new GameObject("res/bullet.png", 815, 22, new Point3f(75, 868, 0));
		rightWall = new GameObject("res/bullet.png", 22, 840, new Point3f(866, 50, 0));

		exitDoor = new GameObject("res/bullet.png", 40, 40, new Point3f(820, 60, 0));
		exitDoorMsg = new GameObject("res/bullet.png", 20, 20, new Point3f(800, 170, 0));

		img1 = new GameObject("res/pick_up_correct_key.png", 400, 70, new Point3f(280, 890, 0));

		testSprite = img1;

		if (level == 1) {
			img1.setHeight(0);
			img1.setWidth(0);
		}

	}

	// This is the heart of the game , where the model takes in all the inputs
	// ,decides the outcomes and then changes the model accordingly.
	public void gamelogic() {

		// Player Logic first
		playerLogic();
		// Enemy Logic next
		enemyLogic();
		// interactions between objects
		gameLogic();

		keyLogic();

	}

	private void keyLogic() {

		if (level == 0) {
			if (printKey == false) {
				key1 = new GameObject("res/keynew.png", 20, 20, new Point3f(475, 520, 0));
				key2 = new GameObject("res/keynew.png", 20, 20, new Point3f(420, 690, 0));

				keyList.add(key1);
				keyList.add(key2);

				key1.setCanOpenDoor(true);

				printKey = true;
			}
		} else if (level == 1) {

			if (printKey == false) {
				int randomNum;

				if (noPlayers == 1) {

					key1 = new GameObject("res/keynew.png", 20, 20, new Point3f(475, 520, 0));
					key2 = new GameObject("res/keynew.png", 20, 20, new Point3f(160, 90, 0));
					key3 = new GameObject("res/keynew.png", 20, 20, new Point3f(300, 300, 0));
					key4 = new GameObject("res/keynew.png", 20, 20, new Point3f(830, 830, 0));

					keyList.add(key1);
					keyList.add(key2);
					keyList.add(key3);
					keyList.add(key4);

					randomNum = ThreadLocalRandom.current().nextInt(1, 8 + 1);
					switch (randomNum) {
					case 1:
						key1.setCanOpenDoor(true);
						key1.setTextureLocation("res/keyCorrect.png");
						break;
					case 2:
						key2.setCanOpenDoor(true);
						key2.setTextureLocation("res/keyCorrect.png");
						break;
					case 3:
						key3.setCanOpenDoor(true);
						key3.setTextureLocation("res/keyCorrect.png");
						break;
					case 4:
						key4.setCanOpenDoor(true);
						key4.setTextureLocation("res/keyCorrect.png");
						break;
					case 5:
						key1.setCanOpenDoor(true);
						key1.setTextureLocation("res/keyCorrect.png");
						break;
					case 6:
						key2.setCanOpenDoor(true);
						key2.setTextureLocation("res/keyCorrect.png");
						break;
					case 7:
						key3.setCanOpenDoor(true);
						key3.setTextureLocation("res/keyCorrect.png");
						break;
					default:
						key4.setCanOpenDoor(true);
						key4.setTextureLocation("res/keyCorrect.png");
						break;
					}

				} else {
					key1 = new GameObject("res/keynew.png", 20, 20, new Point3f(475, 520, 0));
					key2 = new GameObject("res/keynew.png", 20, 20, new Point3f(160, 90, 0));
					key3 = new GameObject("res/keynew.png", 20, 20, new Point3f(300, 300, 0));
					key4 = new GameObject("res/keynew.png", 20, 20, new Point3f(830, 830, 0));
					key5 = new GameObject("res/keynew.png", 20, 20, new Point3f(200, 600, 0));
					key6 = new GameObject("res/keynew.png", 20, 20, new Point3f(800, 300, 0));
					key7 = new GameObject("res/keynew.png", 20, 20, new Point3f(630, 90, 0));
					key8 = new GameObject("res/keynew.png", 20, 20, new Point3f(540, 90, 0));

					keyList.add(key1);
					keyList.add(key2);
					keyList.add(key3);
					keyList.add(key4);
					keyList.add(key5);
					keyList.add(key6);
					keyList.add(key7);
					keyList.add(key8);

					randomNum = ThreadLocalRandom.current().nextInt(1, 8 + 1);
					switch (randomNum) {
					case 1:
						key1.setCanOpenDoor(true);
						key1.setTextureLocation("res/keyCorrect.png");
						break;
					case 2:
						key2.setCanOpenDoor(true);
						key2.setTextureLocation("res/keyCorrect.png");
						break;
					case 3:
						key3.setCanOpenDoor(true);
						key3.setTextureLocation("res/keyCorrect.png");
						break;
					case 4:
						key4.setCanOpenDoor(true);
						key4.setTextureLocation("res/keyCorrect.png");
						break;
					case 5:
						key5.setCanOpenDoor(true);
						key5.setTextureLocation("res/keyCorrect.png");
						break;
					case 6:
						key6.setCanOpenDoor(true);
						key6.setTextureLocation("res/keyCorrect.png");
						break;
					case 7:
						key7.setCanOpenDoor(true);
						key7.setTextureLocation("res/keyCorrect.png");
						break;
					default:
						key8.setCanOpenDoor(true);
						key8.setTextureLocation("res/keyCorrect.png");
						break;
					}

				}

				System.out.println(randomNum);

				printKey = true;
			}

		}

		for (GameObject temp : keyList) {

			if (Player.intersects(temp)) {

				if (Player.hasKey() == false) {
					if (level == 0) {
						img1.setTextureLocation("res/unlock_the_door.png");
					}
					if (temp.getCanOpenDoor() == true) {
						Player.setCanOpenDoor(true);
						System.out.println("THIS KEY CAN OPEN THE DOOR!");
					}
					Player.setKey(true);
					keyList.remove(temp);
				} else {
					if (level == 0) {
						img1.setTextureLocation("res/one_key_at_a_time.png");
					}
				}

			}
			if (Player2.intersects(temp)) {

				if (Player2.hasKey() == false) {

					if (level == 0) {
						img1.setTextureLocation("res/unlock_the_door.png");
					}
					if (temp.getCanOpenDoor() == true) {
						Player2.setCanOpenDoor(true);
						System.out.println("THIS KEY CAN OPEN THE DOOR!");
					}
					Player2.setKey(true);
					keyList.remove(temp);

				} else {
					if (level == 0) {
						img1.setTextureLocation("res/one_key_at_a_time.png");
					}
				}

			}
			temp.getCentre().ApplyVector(new Vector3f(0, 0, 0));
		}

	}

	private void gameLogic() {

		// this is a way to increment across the array list data structure

		// see if they hit anything
		// using enhanced for-loop style as it makes it alot easier both code wise and
		// reading wise too
		if (playersAlive == 0) {
			// System.out.println("GAME OVER");
			playSound("gameOver.wav");
		}

		for (GameObject temp : playerList) {
			if (temp.intersects(exitDoor)) {
				if (temp.hasKey() && temp.getCanOpenDoor() == false) {
					temp.setKey(false);
					img1.setTextureLocation("res/try_another_key.png");

					if (level == 1) {
						img1.setHeight(70);
						img1.setWidth(400);
						System.out.println("WRONG KEY");
					}

				} else if (temp.getCanOpenDoor() == true) {
					gameWon = true;
					playSound("win.wav");
				}
			}
		}

	}

	private void enemyLogic() {
		// if(difficulty = )

		if (playersAlive > 0) {
			// TODO Auto-generated method stub
			for (GameObject temp : EnemiesList) {
				// Move enemies

				enemyDown = new GameObject("res/UFO.png", 40, 40,
						new Point3f(temp.getCentre().getX(), temp.getCentre().getY(), 0));

				enemyUp = new GameObject("res/UFO.png", 40, 40,
						new Point3f(temp.getCentre().getX(), temp.getCentre().getY(), 0));

				enemyLeft = new GameObject("res/UFO.png", 40, 40,
						new Point3f(temp.getCentre().getX(), temp.getCentre().getY(), 0));

				enemyRight = new GameObject("res/UFO.png", 40, 40,
						new Point3f(temp.getCentre().getX(), temp.getCentre().getY(), 0));

				enemyUp.getCentre().ApplyVector(new Vector3f(0, 0.5f, 0));
				enemyDown.getCentre().ApplyVector(new Vector3f(0, -0.5f, 0));
				enemyLeft.getCentre().ApplyVector(new Vector3f(-0.5f, 0, 0));
				enemyRight.getCentre().ApplyVector(new Vector3f(0.5f, 0, 0));

				if (temp.getMoveDirection() == "down") {
					if (checkCollision(enemyDown)) {
						temp.getCentre().ApplyVector(new Vector3f(0, -0.5f, 0));
					} else {
						int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);

						if (randomNum == 0) {
							temp.setMoveDirection("right");

						} else if (randomNum == 1) {
							temp.setMoveDirection("left");

						} else {
							temp.setMoveDirection("up");
						}
					}

				} else if (temp.getMoveDirection() == "up") {
					if (checkCollision(enemyUp)) {
						temp.getCentre().ApplyVector(new Vector3f(0, 0.5f, 0));
					} else {
						int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);

						if (randomNum == 0) {
							temp.setMoveDirection("right");

						} else if (randomNum == 1) {
							temp.setMoveDirection("left");

						} else {
							temp.setMoveDirection("down");

						}
					}
				} else if (temp.getMoveDirection() == "left") {
					if (checkCollision(enemyLeft)) {
						temp.getCentre().ApplyVector(new Vector3f(-0.5f, 0, 0));
					} else {
						int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);

						if (randomNum == 0) {
							temp.setMoveDirection("right");

						} else if (randomNum == 1) {
							temp.setMoveDirection("up");

						} else {
							temp.setMoveDirection("down");

						}
					}
				} else if (temp.getMoveDirection() == "right") {
					if (checkCollision(enemyRight)) {
						temp.getCentre().ApplyVector(new Vector3f(0.5f, 0, 0));
					} else {
						int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);

						if (randomNum == 0) {
							temp.setMoveDirection("left");

						} else if (randomNum == 1) {
							temp.setMoveDirection("up");

						} else {
							temp.setMoveDirection("down");

						}
					}

				}

				if (skeletonIntersectsPlayer(temp, Player)) {

					if (Player.hasKey()) {

						GameObject k = new GameObject("res/keynew.png", 20, 20,
								new Point3f(Player.getCentre().getX(), Player.getCentre().getY(), 0));

						if (Player.getCanOpenDoor() == true) {
							k.setCanOpenDoor(true);
						}
						keyList.add(k);
					}

					Player = new GameObject("res/Char_walk_up.png", 0, 0, new Point3f(0, 0, 0));
					System.out.println("Player One Died");
					playersAlive--;
				}

				if (skeletonIntersectsPlayer(temp, Player2)) {
					if (Player2.hasKey()) {

						GameObject k = new GameObject("res/keynew.png", 20, 20,
								new Point3f(Player2.getCentre().getX(), Player2.getCentre().getY(), 0));

						if (Player2.getCanOpenDoor() == true) {
							k.setCanOpenDoor(true);
						}
						keyList.add(k);
					}

					Player2 = new GameObject("res/Char_walk_up.png", 0, 0, new Point3f(0, 0, 0));
					System.out.println("Player Two Died");
					playersAlive--;
				}
			}

			if (EnemiesList.size() < 1) {

				EnemiesList.add(new GameObject("res/Skel_walk_down.png", 40, 40, new Point3f(510, 510, 0)));
				if (level == 1) {
					if (difficulty > 0) {
						EnemiesList.add(new GameObject("res/Skel_walk_down.png", 40, 40, new Point3f(100, 100, 0)));
						EnemiesList.add(new GameObject("res/Skel_walk_down.png", 40, 40, new Point3f(100, 200, 0)));
						EnemiesList.add(new GameObject("res/Skel_walk_down.png", 40, 40, new Point3f(635, 100, 0)));
					}
					if (difficulty > 1) {
						EnemiesList.add(new GameObject("res/Skel_walk_down.png", 40, 40, new Point3f(390, 100, 0)));
						EnemiesList.add(new GameObject("res/Skel_walk_down.png", 40, 40, new Point3f(100, 620, 0)));
						EnemiesList.add(new GameObject("res/Skel_walk_down.png", 40, 40, new Point3f(720, 815, 0)));
					}
					if (difficulty > 2) {
						EnemiesList.add(new GameObject("res/Skel_walk_down.png", 40, 40, new Point3f(820, 320, 0)));
						EnemiesList.add(new GameObject("res/Skel_walk_down.png", 40, 40, new Point3f(635, 100, 0)));
						EnemiesList.add(new GameObject("res/Skel_walk_down.png", 40, 40, new Point3f(100, 620, 0)));
					}

				}

			}

		}

	}

	private void playerLogic() {

		// smoother animation is possible if we make a target position // done but may
		// try to change things for students

		// check for movement and if you fired a bullet

		if (level == 0) {
			if (skeletonInteractionCounter == 0) {
				if (Player.intersects(spriteWall27) || Player2.intersects(spriteWall27)) {
					img1.setTextureLocation("res/skeleton_dangerous.png");
					skeletonInteractionCounter++;
				}
			}

		}

		if (level == 1 && img1.getHeight() > 0) {
			if (Player.intersects(exitDoorMsg) || Player2.intersects(exitDoorMsg)) {
				img1.setHeight(0);
				img1.setWidth(0);

			}
		}

		if (Controller.getInstance().isKeyAPressed()) {
			testingPlayer1 = new GameObject("res/UFO.png", 40, 40,
					new Point3f(Player.getCentre().getX(), Player.getCentre().getY(), 0));
			testingPlayer1.getCentre().ApplyVector(new Vector3f(-1, 0, 0));

			if (checkCollision(testingPlayer1)) {
				Player.setTextureLocation("res/Char_walk_left.png");
				Player.getCentre().ApplyVector(new Vector3f(-1, 0, 0));
			}
		}

		if (Controller.getInstance().isKeyDPressed()) {

			testingPlayer1 = new GameObject("res/UFO.png", 40, 40,
					new Point3f(Player.getCentre().getX(), Player.getCentre().getY(), 0));
			testingPlayer1.getCentre().ApplyVector(new Vector3f(1, 0, 0));

			if (checkCollision(testingPlayer1)) {
				Player.setTextureLocation("res/Char_walk_right.png");
				Player.getCentre().ApplyVector(new Vector3f(1, 0, 0));
			}

		}

		if (Controller.getInstance().isKeyWPressed()) {

			testingPlayer1 = new GameObject("res/UFO.png", 40, 40,
					new Point3f(Player.getCentre().getX(), Player.getCentre().getY(), 0));
			testingPlayer1.getCentre().ApplyVector(new Vector3f(0, 1, 0));

			if (checkCollision(testingPlayer1)) {
				Player.setTextureLocation("res/Char_walk_up.png");
				Player.getCentre().ApplyVector(new Vector3f(0, 1, 0));
			}
		}

		if (Controller.getInstance().isKeySPressed()) {

			testingPlayer1 = new GameObject("res/UFO.png", 40, 40,
					new Point3f(Player.getCentre().getX(), Player.getCentre().getY(), 0));
			testingPlayer1.getCentre().ApplyVector(new Vector3f(0, -1, 0));

			if (checkCollision(testingPlayer1)) {
				Player.setTextureLocation("res/Char_walk_down.png");
				Player.getCentre().ApplyVector(new Vector3f(0, -1, 0));
			}
		}

		if (Controller.getInstance().isKeyJPressed()) {

			testingPlayer2 = new GameObject("res/UFO.png", 40, 40,
					new Point3f(Player2.getCentre().getX(), Player2.getCentre().getY(), 0));
			testingPlayer2.getCentre().ApplyVector(new Vector3f(-1, 0, 0));

			if (checkCollision(testingPlayer2)) {
				Player2.setTextureLocation("res/Char2_walk_left.png");
				Player2.getCentre().ApplyVector(new Vector3f(-1, 0, 0));
			}

		}

		if (Controller.getInstance().isKeyLPressed()) {

			testingPlayer2 = new GameObject("res/UFO.png", 40, 40,
					new Point3f(Player2.getCentre().getX(), Player2.getCentre().getY(), 0));
			testingPlayer2.getCentre().ApplyVector(new Vector3f(1, 0, 0));

			if (checkCollision(testingPlayer2)) {
				Player2.setTextureLocation("res/Char2_walk_right.png");
				Player2.getCentre().ApplyVector(new Vector3f(1, 0, 0));
			}

		}

		if (Controller.getInstance().isKeyIPressed()) {

			testingPlayer2 = new GameObject("res/UFO.png", 40, 40,
					new Point3f(Player2.getCentre().getX(), Player2.getCentre().getY(), 0));
			testingPlayer2.getCentre().ApplyVector(new Vector3f(0, 1, 0));

			if (checkCollision(testingPlayer2)) {
				Player2.setTextureLocation("res/Char2_walk_up.png");
				Player2.getCentre().ApplyVector(new Vector3f(0, 1, 0));
			}

		}

		if (Controller.getInstance().isKeyKPressed()) {

			testingPlayer2 = new GameObject("res/UFO.png", 40, 40,
					new Point3f(Player2.getCentre().getX(), Player2.getCentre().getY(), 0));
			testingPlayer2.getCentre().ApplyVector(new Vector3f(0, -1, 0));

			if (checkCollision(testingPlayer2)) {
				Player2.setTextureLocation("res/Char2_walk_down.png");
				Player2.getCentre().ApplyVector(new Vector3f(0, -1, 0));
			}

		}

	}

	public Boolean checkCollision(GameObject go) {

		if (level == 0) {
			if (!go.intersects(spriteWall1) && !go.intersects(spriteWall2) && !go.intersects(spriteWall3)
					&& !go.intersects(spriteWall4) && !go.intersects(spriteWall5) && !go.intersects(spriteWall6)
					&& !go.intersects(spriteWall7) && !go.intersects(spriteWall8) && !go.intersects(spriteWall9)
					&& !go.intersects(spriteWall10) && !go.intersects(spriteWall11) && !go.intersects(spriteWall12)
					&& !go.intersects(spriteWall13) && !go.intersects(spriteWall14) && !go.intersects(spriteWall15)
					&& !go.intersects(spriteWall16) && !go.intersects(spriteWall17) && !go.intersects(spriteWall18)
					&& !go.intersects(spriteWall19) && !go.intersects(spriteWall20) && !go.intersects(spriteWall21)
					&& !go.intersects(spriteWall22) && !go.intersects(spriteWall23) && !go.intersects(spriteWall24)
					&& !go.intersects(spriteWall25) && !go.intersects(spriteWall26) && !go.intersects(topWall)
					&& !go.intersects(rightWall) && !go.intersects(leftWall) && !go.intersects(bottomWall)) {
				return true;
			} else {
				return false;
			}
		} else if (level == 1) {
		}

		if (!go.intersects(spriteWall1) && !go.intersects(spriteWall2) && !go.intersects(spriteWall3)
				&& !go.intersects(spriteWall4) && !go.intersects(spriteWall5) && !go.intersects(spriteWall6)
				&& !go.intersects(spriteWall7) && !go.intersects(spriteWall8) && !go.intersects(spriteWall9)
				&& !go.intersects(spriteWall10) && !go.intersects(spriteWall11) && !go.intersects(spriteWall12)
				&& !go.intersects(spriteWall13) && !go.intersects(spriteWall14) && !go.intersects(spriteWall15)
				&& !go.intersects(spriteWall16) && !go.intersects(spriteWall17) && !go.intersects(spriteWall18)
				&& !go.intersects(spriteWall19) && !go.intersects(spriteWall20) && !go.intersects(spriteWall21)
				&& !go.intersects(spriteWall22) && !go.intersects(spriteWall23) && !go.intersects(spriteWall24)
				&& !go.intersects(spriteWall25) && !go.intersects(spriteWall26) && !go.intersects(spriteWall27)
				&& !go.intersects(spriteWall28) && !go.intersects(spriteWall29) && !go.intersects(spriteWall30)
				&& !go.intersects(spriteWall31) && !go.intersects(spriteWall32) && !go.intersects(spriteWall33)
				&& !go.intersects(spriteWall34) && !go.intersects(spriteWall35) && !go.intersects(spriteWall36)
				&& !go.intersects(spriteWall37) && !go.intersects(spriteWall38) && !go.intersects(spriteWall39)
				&& !go.intersects(spriteWall40) && !go.intersects(spriteWall41) && !go.intersects(spriteWall42)
				&& !go.intersects(topWall) && !go.intersects(rightWall) && !go.intersects(leftWall)
				&& !go.intersects(bottomWall)) {
			return true;
		} else {
			return false;
		}

	}

	private Boolean skeletonIntersectsPlayer(GameObject go, GameObject go2) {
		if (go.intersects(go2)) {
			return true;
		}
		return false;
	}

	public GameObject getPlayer() {
		return Player;
	}

	public GameObject getPlayer2() {
		return Player2;
	}

	public GameObject getTestSprite() {
		return testSprite;
	}

	public CopyOnWriteArrayList<GameObject> getEnemies() {
		return EnemiesList;
	}

	public CopyOnWriteArrayList<GameObject> getKeys() {
		return keyList;
	}

	public CopyOnWriteArrayList<GameObject> getBullets() {
		return BulletList;
	}

	public int getScore() {
		return Score;
	}

	public int getPlayersAlive() {
		return playersAlive;
	}

	public boolean getGameWon() {
		return gameWon;
	}

	public int getLevel() {
		return level;

	}

	public CopyOnWriteArrayList<GameObject> getPlayerList() {
		return playerList;
	}

	private static void playSound(String name) {

		try {

			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Model.class.getClassLoader().getResource(name));

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

			while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
			}
			System.out.println("Song ended ");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

/*
 * MODEL OF your GAME world
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWNNNXXXKKK000000000000KKKXXXNNNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNXXK0OOkkxddddooooooolllllllloooooooddddxkkOO0KXXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNXK0OkxddooolllllllllllllllllllllllllllllllllllllllloooddxkO0KXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXK0OkdooollllllllooddddxxxkkkOOOOOOOOOOOOOOOkkxxdddooolllllllllllooddxO0KXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNK0kxdoollllllloddxkO0KKXNNNNWWWWWWMMMMMMMMMMMMMWWWWNNNXXK00Okkxdoollllllllloodxk0KNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXKOxdooolllllodxkO0KXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNXK0OkxdolllllolloodxOKXWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOxdoolllllodxO0KNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXKOkdolllllllloodxOKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0kdolllllooxk0KNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNK0kdolllllllllodk0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0xdolllllodk0XNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWMMMMMMMMMMMWN0kdolllllllllodx0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0xoollllodxOKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWMMMMMMMMMMWNXKOkkkk0WMMMMMMMMMMMMWNKkdolllloololodx0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0kdolllllox0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXK0kxk0KNWWWWNX0OkdoolllooONMMMMMMMMMMMMMMMWXOxolllllllollodk0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOdollllllllokXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0xooollloodkOOkdoollllllllloxXWMMMMMMMMMMMMMMMWXkolllllllllllllodOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0koolllllllllllokNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxolllllllllllllllllllllllllllox0XWWMMMMMMMMMWNKOdoloooollllllllllllok0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0xoolllllllllllllloONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxllolllllllllllllllllloollllllolodxO0KXNNNXK0kdoooxO0K0Odolllollllllllox0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOdolllllllllllllllllokXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkolllllllllloolllllllllllllllllllolllloddddoolloxOKNWMMMWNKOxdolollllllllodOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMWXOdolllolllllllllllllloxKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxlllolllllloxkxolllllllllllllllllolllllllllllllxKWMWWWNNXXXKKOxoollllllllllodOXWMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMWXOdollllllllllllllllllllokNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOollllllllllxKNKOxooollolllllllllllllllllllolod0XX0OkxdddoooodoollollllllllllodOXWMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMN0xollllllllllllllllllllllld0NMMMMMMMMMMMMMMMMMMMMMMMWWNKKNMMMMMMMMMMMW0dlllllllllokXWMWNKkoloolllllllllllllllllllolokkxoolllllllllllllollllllllllllllox0NMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMWKxolllllllllllllllllllllllllloONMMMMMMMMMMMMMMMMMMMWNKOxdookNMMMMMMMMMWXkollllllodx0NWMMWWXkolooollllllllllllllllllllooollllllllllllllolllllllllllloooolloxKWMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMWXOdllllllllllllllooollllllllollld0WMMMMMMMMMMMMMMMMWXOxollllloOWMMMMMMMWNkollloodxk0KKXXK0OkdoollllllllllllllllllllllllllllllollllllllloollllllollllllllllllldOXWMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMN0xolllllllllllolllllllllllloodddddONMMMMMMMMMMMMMMMNOdolllllllokNMMMMMMWNkolllloddddddoooolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllox0NMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMWXkolllllllllllllllllllodxxkkO0KXNNXXXWMMMMMMMMMMMMMMNkolllllllllod0NMMMMMNOollllloollllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllolllllllllllllokXWMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMWKxollllllllllllllllllox0NWWWWWMMMMMMMMMMMMMMMMMMMMMMW0dlllllllllllookKNWWNOolollloolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloxKWMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMN0dlllllllllllllllllllldKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkoloolllollllolloxO0Odllllllllllllllllllllllllllllllllllllllllllllollllllllllllllllllllllllllllllllllllllllllllllld0NWMMMMMMMMMMMMM
 * MMMMMMMMMMMMMXkolllllllllllllllllolllxXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXOO0KKOdollllllllllooolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloONWMMMMMMMMMMMM
 * MMMMMMMMMMMWXkollllllllllllllllllllllxXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMMMMWNKOxoollllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllokXWMMMMMMMMMMM
 * MMMMMMMMMMWKxollllllllllllllllllllllokNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWKxollllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloxKWMMMMMMMMMM
 * MMMMMMMMMWKxollllllllllllodxkkkkkkkO0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMNKOkO0KK0OkdolllllloolllllllllllloooollllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloxKWMMMMMMMMM
 * MMMMMMMMWKxllllllllllolodOXWWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxolloooollllllllllllllllloollllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllxKWMMMMMMMM
 * MMMMMMMWKxlllllllllollokXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxololllllllooolloollllloolloooolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllxKWMMMMMMM
 * MMMMMMWXxllllllllooodkKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKdloollllllllllololodxxddddk0KK0kxxxdollolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllxXWMMMMMM
 * MMMMMMXkolllllodk0KXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKdllollllllllllllodOXWWNXXNWMMMMWWWNX0xolollllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllokNMMMMMM
 * MMMMMNOollllodONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dooollllllllllllodOXNWWWWWWMMMMMMMMMWXOddxxddolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloONMMMMM
 * MMMMW0dllllodKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKKK0kdlllllllllllloodxxxxkkOOKNWMMMMMMWNNNNNXKOkdooooollllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllld0WMMMM
 * MMMWKxllllloOWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkolllllollllllllllllllllodOKXWMMMMMMMMMMMMWNXKK0OOkkkxdooolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllxKWMMM
 * MMMNkollllokXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWXOdlllllolllllllllllloloolllooxKWMMMMMMMMMMMMMMMMMMMMWWWNXKOxoollllllllllllllllllllllllllllllllllllllllllllllllllllllllllolokNMMM
 * MMW0ollllldKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOOkxdollllllllllllllllllllllllllllox0NWMMMMWWNNXXKKXNWMMMMMMMMMWNKOxolllolllllllllllllllllllllllllllllllllllllllllllllllllllllllo0WMM
 * MMXxllllloONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXkolllllllllllllllllllllllllllllllllllooxO000OkxdddoooodkKWMMMMMMMMMMWXxllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllxXWM
 * MWOollllldKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXkollllllllllllllllllllllllllllllllllllllllllllllllllllllld0WMMMMMMMMMWKdlllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloOWM
 * MXxllllloONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXkollllllllllllllllllllllllllllllllllooollllllllllllllllllold0WMMMMMMWN0dolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllxXM
 * W0ollllld0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNKkdolllllllllllllllllllllllllllllllllllllllllllllllllolllllllllokKXNWWNKkollllllllloxdollllllllolllllllllllllllllllllllllolllllllllllllolo0W
 * NkllllloxXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkollllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllodxkkdoolollllllllxKOolllllllllllllllllllllllollooollllllloolllllloolllllkN
 * KxllllloONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0doolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllkX0dlllllllllllllllllllloollloOKKOkxdddoollllllllllllllxK
 * Oolllllo0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllxXXkollllooolllllllllllllllloONMMMWNNNXX0xolllllllllolloO
 * kolllllo0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOollllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllxXWXkollollllllllllllllllllodKMMMMMMMMMMWKxollllolollolok
 * kllllllo0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dlllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloolllllllllxXWWXkolllllllllllllllolllloONMMMMMMMMMMMW0dllllllllllllk
 * xollolld0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxllllolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloollllllolloONMMN0xoolllllllolllllllloxXWMMMMMMMMMMMMXxollllllloollx
 * dollllld0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxlllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloollld0WMMWWXOdollollollllllloxXWMMMMMMMMMMMMMNOollllllokkold
 * olllllld0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNxlllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllldONMMMMWXxollllolllllox0NWMMMMMMMMMMMMMMNOollllllxXOolo
 * llllllld0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXxllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloONMMMMMXxddxxxxkkO0XWMMMMMMMMMMMMMMMMMNOolllllxKW0olo
 * llllllld0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKdlllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllldONWMMMWNXNNWWWMMMMMMMMMMMMMMMMMMMMMMMW0dllollOWW0oll
 * llllllld0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloxO0KXXXXKKKXNWMMMMMMMMMMMMMMMMMMMMMMMNOdolllkNWOolo
 * ollllllo0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllooooddooloodkKWMMMMMMMMMMMMMMMMMMMMMMWXOolldKNOooo
 * dollllloONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllloollllo0WMMMMMMMMMMMMMMMMMMMMMMMMXkold0Nkold
 * xollllloxXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllollokNMMMMMMMMMMMMMMMMMMMMMMMMMWOookXXxolx
 * xolllllloONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllokXWMMMMMMMMMMMMMMMMMMMMMMMMMN00XW0dlox
 * kollllllloxOKXXNNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOxollllllllllllllllllllllllllllllolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllolllllolo0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWOollk
 * OolllllllllloodddkKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOkkxddooooollllllllllooodxxdollolllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllokXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkoloO
 * KdllllllllllllllllxXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNXXXK0OOkkkkkkkkOKXXXNNX0xolllllllllllllllllllllllllllllllllllllllllllllllllllllllloollllllllloox0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKdlldK
 * NkllllollloolllllldKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWMMMMMMMMMWNOdlllllllllllllllllllllllllllllllllllllllllllllllllllllllollllllllodOKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWOolokN
 * WOolllllllllllolllokXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxollllllllllllllllllllllllllllllllllllllllllllllllllllllllllllod0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXxolo0W
 * WXxllllllllllllllllox0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxollllllllllllllllllllllllllllllllllllllllllllllllllllllllllokXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOollxXM
 * MWOollllllllllllllooloxKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKdllllllllllllllllllllllllllllllllllllllllllllllllllllloolld0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKdlloOWM
 * MWXxllolllllllllllllllldOXWWNNK00KXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dllllllllllllllllllllllllllllllllllllllllllllllllllllllod0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxollxXWM
 * MMWOollllllllloollllllolodxkxdollodk0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOollllllllllllllllllllllllllllllllllllllllllllllllllodxOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWN0dlllo0WMM
 * MMMXxllolllllllllllllllllllllllllllloox0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0dooollllllllllllllllllllllllllllllllllllllllllllodOXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKOkxxolllokNMMM
 * MMMW0dlllllllllllllllllllolllllllollollokXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOdoolllllllllllllllllllllllllllllllllllllllllllxKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNOoollllllldKWMMM
 * MMMMNOollllllllllllllllllllllllllllllllloOWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXKOdolllllllllllllllllllllllllllllllllllllllloONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOolllllllloOWMMMM
 * MMMMMXkollllllllllllllllllllllllllllllllokNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dlllllllllllllllllllllllllllllllllllllllld0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dllolllllokNMMMMM
 * MMMMMWXxlllllllllllllllllllllllllllllllloxXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0ollllllllllllllllllllllllllllllllllllllldKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWOollllllllxXWMMMMM
 * MMMMMMWKdlllllllllllllllllllllllllllllllokNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxolllllllllllllllllllllllllllllllllllllloONWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOolllllllxKWMMMMMM
 * MMMMMMMW0dlllllllllllllllllllllllllllllloOWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dlllloollllllllllllllllllllllllllllllllloxkOKKXXKKXNMMMMMMMMMMMMMMMMMMMMMMMMNOolllllldKWMMMMMMM
 * MMMMMMMMW0dllllllllllllllllllllllllllllldKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKdlllllllllllllllllllllllllllllllllllllllllllloooood0WMMMMMMMMMMMMMMMMMMMMMMMNOollolldKWMMMMMMMM
 * MMMMMMMMMW0dlllllllllllllllllllllllllllokXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dllllllllllllllllllllllllllllllolllllllllllllllllld0WMMMMMMMMMMMMMMMMMMMMMMWKxllllldKWMMMMMMMMM
 * MMMMMMMMMMW0dlllllllllllllllllllllllllloxXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkolllllllllllllllllllllllllllllllllllllllllllllllllxXMMMMMMMMMMMMMMMMMMMMMWXOdolllldKWMMMMMMMMMM
 * MMMMMMMMMMMWKxollllllllllllllllllllllllloOWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dlllllllllllllllllllllllllllllllloolllllllolllollllkNMMMMMMMMMMMMMMMMMMMWXOdolllloxKWMMMMMMMMMMM
 * MMMMMMMMMMMMWKxollllllllllllllllllllllllod0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkoloollllllllllllllllllllllllllllloddollllllllllllld0WMMMMMMMMMMMMMMMWWNKOdolllllokXWMMMMMMMMMMMM
 * MMMMMMMMMMMMMWXkollllllllllllllllllllllllldKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dllollllllllllllllllllllllllllllld0XOollllllllllllkNMMMMMMMMMMMMWNK0OkxollllllloONWMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMNOdlllllllllllllllllllllllokXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0dlllllllllllllllllllllllllolllld0NWN0dlllllloodxkKWMMMMMMMMMMMMNOollllllllllld0NMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMWKxolollllllllllllllllllokXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOolllllllllllllllllllllllllllldONMMMWKkdoooxOXNNWMMMMMMMMMMMMMNOollllllllllokXWMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMWXOdlllllllllllllllllloONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKdllllllllllllllllllllllllllld0NMMMMMWWXXXXNWMMMMMMMMMMMMMMMMW0dlllllllllod0NMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMWKxollolllllllllllloONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxllllllllllllllllllllllllloxKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dlllllllllokXWMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMWNOdollllllloolllldKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkolllloollllooolllllllllodONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkllllllolox0NMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMWXkollllllolllllox0NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKdlllllollllllllllllllodkKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0dllllllodOXWMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMWKxoolllllllllllokXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0dollllllllllooddxxk0KNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOdollllldOXWMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMN0xolllllllllllokXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxolllllodk0KXNNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKkdollolodkXWMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMNKxoolllllllllodOKNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOdolldOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0xoollllodkXWMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNKkolllollllllloxOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOx0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOdolllllldOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKOdollllllllllodx0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOdoollllloxOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0xollollollollodxOXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0kdooollllodk0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKkdooolllllllllooxOKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOxdollllllloxOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0kdllllllllollllodkOKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWXKOkdoolllllloodOKNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0kdolllllllllllllodxO0XNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNX0OxdollloolllloxOKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0kdoolllllllllllllooxkO0XNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNX0OkxoololllllllooxOKNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNK0kdoolllllllllllloooodxkO0KXNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNXK0Okxdoolllllollllloxk0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOkdoollllllllloolllllloodxkkO00KXXNNWWWWWWMMMMMMMMMWWWWWWWNNXXK00Okxxdoolllllllllllloooxk0KNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNK0kxdoollllllllllllllllllllloodddxxxkkOOOOOOOOOOOkkkxxxdddoollllllllllllllllloodxO0XNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXK0OxdooollllllllllllooolllllllllllllllllllllllllllllllllllllllllllooodkO0KNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXK0OkxdooollllllllllllllllllllllllllllllllllllllllllloooddxkO0KXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNNXK0OOkkxdddoooooollllllllllllllllooooooddxxkOO0KKXNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNNXXXKK00OOOOOOOOOOOOOOOO00KKXXXNNWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
 */

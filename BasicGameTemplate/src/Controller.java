import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

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

//Singeton pattern
public class Controller implements KeyListener {

	private static boolean KeyAPressed = false;
	private static boolean KeySPressed = false;
	private static boolean KeyDPressed = false;
	private static boolean KeyWPressed = false;

	private static boolean KeyJPressed = false;
	private static boolean KeyKPressed = false;
	private static boolean KeyLPressed = false;
	private static boolean KeyIPressed = false;

	private static final Controller instance = new Controller();

	public Controller() {
	}

	public static Controller getInstance() {
		return instance;
	}

	@Override
	// Key pressed , will keep triggering
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 65:
			setKeyAPressed(true);
			break;
		case 83:
			setKeySPressed(true);
			break;
		case 87:
			setKeyWPressed(true);
			break;
		case 68:
			setKeyDPressed(true);
			break;

		case 37:
			setKeyJPressed(true);
			break;
		case 40:
			setKeyKPressed(true);
			break;
		case 38:
			setKeyIPressed(true);
			break;
		case 39:
			setKeyLPressed(true);
			break;

//			case 32 :setKeySpacePressed(true);break;   
		default:
			// System.out.println("Controller test: Unknown key pressed");
			break;
		}

		// You can implement to keep moving while pressing the key here .

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {

		case 65:
			setKeyAPressed(false);
			break;
		case 83:
			setKeySPressed(false);
			break;
		case 87:
			setKeyWPressed(false);
			break;
		case 68:
			setKeyDPressed(false);
			break;

		case 37:
			setKeyJPressed(false);
			break;
		case 40:
			setKeyKPressed(false);
			break;
		case 38:
			setKeyIPressed(false);
			break;
		case 39:
			setKeyLPressed(false);
			break;

		default:
			break;
		}

	}

	public boolean isKeyAPressed() {
		return KeyAPressed;
	}

	public void setKeyAPressed(boolean keyAPressed) {
		KeyAPressed = keyAPressed;
	}

	public boolean isKeySPressed() {
		return KeySPressed;
	}

	public void setKeySPressed(boolean keySPressed) {
		KeySPressed = keySPressed;
	}

	public boolean isKeyDPressed() {
		return KeyDPressed;
	}

	public void setKeyDPressed(boolean keyDPressed) {
		KeyDPressed = keyDPressed;
	}

	public boolean isKeyWPressed() {
		return KeyWPressed;
	}

	public void setKeyWPressed(boolean keyWPressed) {
		KeyWPressed = keyWPressed;
	}

	public boolean isKeyJPressed() {
		return KeyJPressed;
	}

	public void setKeyJPressed(boolean keyJPressed) {
		KeyJPressed = keyJPressed;
	}

	public boolean isKeyKPressed() {
		return KeyKPressed;
	}

	public void setKeyKPressed(boolean keyKPressed) {
		KeyKPressed = keyKPressed;
	}

	public boolean isKeyLPressed() {
		return KeyLPressed;
	}

	public void setKeyLPressed(boolean keyLPressed) {
		KeyLPressed = keyLPressed;
	}

	public boolean isKeyIPressed() {
		return KeyIPressed;
	}

	public void setKeyIPressed(boolean keyIPressed) {
		KeyIPressed = keyIPressed;
	}

}

/*
 * 
 * KEYBOARD :-) . can you add a mouse or a gamepad
 * 
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@
 * 
 * @@@
 * 
 * @@@ @@@@ @@@@ @@@@ @@@@ @@@ @@@ @@@ @@@ @@@
 * 
 * @@@ @@@ @@@ @@@@ @@@ @@@ @@@ @@@ @@@ @@@
 * 
 * @@@ @@@ @@@ @@@@ @@@@ @@@ @@@ @@@ @@@ @@@
 * 
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * 
 * @@@
 * 
 * @ @@@ @@@ @@@ @@ @@@ @@@ @@@ @@@ @@@ @
 * 
 * @ @@@ W @@@ @@@ @@ @@@ @@@ @@@ @@@ @@@ @
 * 
 * @@ @@@@ @@@@ @@@@ @@@@ @@@@ @@@ @@@ @@@ @@@ @
 * 
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@N@@@@@@@@@@@@@@@@@@@@@@@@
 * 
 * @@@
 * 
 * @@@ @@@ @@ @@ @@ @@@ @@@ @@@ @@@ @@@
 * 
 * @@@ A @@@ S @@ D @@ @@@ @@@ @@@ @@@ @@@ @@@
 * 
 * @@@@ @ @@@@@@@@@@@@ @@@@@@@ @@@@@@@@@@@@ @@@@@@@@@@@@ @@@@ @@@@@
 * 
 * @@@ @@@@ @@@@ @@@@ $@@@ @@@ @@@ @@@ @@@ @@@
 * 
 * @@@ $ @@@ @@ @@ /Q @@ ]M @@@ @@@ @@@ @@@ @@@
 * 
 * @@@ @@@ @@ @@ @@ @@@ @@@ @@@ @@@ @@@
 * 
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * 
 * @@@
 * 
 * @ @@@ @@@ @@@ @
 * 
 * @ @@@ SPACE KEY @@@ @@ PQ
 * 
 * @ @@@ @@@ @@
 * 
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * 
 * @@@
 * 
 * 
 * 
 * 
 * 
 */

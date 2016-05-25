package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

/**
 *	Use keyboard to check if a key works or not
 */
public class KeyboardListener implements KeyListener {

	private JLabel[][] keys;
	private boolean[] keyBools = new boolean[2]; //Check KeyCombo Alt+Q
	
	private boolean ctrlPressed;				// Stupid ALTGR key makes this bool necessary
	private boolean ctrlFlag;					//Stupid ALTGR key makes it necessary that ctrl activates when pressed
	
	private Keys keyStuff;

	public KeyboardListener(Keys k) {
		keys = k.getKeyArray();
		keyStuff = k;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(!ctrlFlag)
		ctrlPressed = false;
		
		int keyLocation = e.getKeyLocation();
		
		if(keyLocation == KeyEvent.KEY_LOCATION_NUMPAD){
			if(checkNumpadKeys(e))
				return;
		}
		
		if(keyLocation == KeyEvent.KEY_LOCATION_STANDARD){
		
			if(checkEditKeys(e))
				return;
			
			else if(checkLetterKeys(e))
				return;
			
			else if (checkFKeys(e))
				return;
		
			else if (checkNumberKeys(e))
				return;
			
			else if(checkArrowKeys(e))
				return;
		}
		
		//contains std, left and right area ...
			if (checkSystemKeys(e))
				return;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(ctrlPressed){
			ctrlFlag = true;
			ctrlPressed = false;
		}

		//PrintScreen key only checkable here???
		if (e.getKeyCode() == KeyEvent.VK_PRINTSCREEN) {
			keys[0][17].setBackground(Color.YELLOW);
			return;
		}
		
		//Alt+Q
		if(keyBools[0] && keyBools[1]){
			ctrlFlag = false;
			keyStuff.setBaseColorAndBorder();
		}
		
		keyBools[0] = false;
		keyBools[1] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Checks if text edit keys were pressed
	 * @param e KeyEvent: Uses Keycode() or KeyChar() to check if given key was pressed
	 * */
	private boolean checkEditKeys(KeyEvent e) {

		int editKey = e.getKeyCode();
		if (editKey == KeyEvent.VK_INSERT) {
			keys[2][16].setBackground(Color.YELLOW);
			return true;
		}

		else if (editKey == KeyEvent.VK_DELETE) {
			keys[3][16].setBackground(Color.YELLOW);
			return true;
		}

		else if (editKey == KeyEvent.VK_PAGE_UP) {
			keys[2][18].setBackground(Color.YELLOW);
			return true;
		}

		else if (editKey == KeyEvent.VK_PAGE_DOWN) {
			keys[3][18].setBackground(Color.YELLOW);
			return true;
		}

		else if (editKey == KeyEvent.VK_HOME) {
			keys[2][17].setBackground(Color.YELLOW);
			return true;
		} 
		
		else if (editKey == KeyEvent.VK_END) {
			keys[3][17].setBackground(Color.YELLOW);
			return true;
		} 
		
		else if (editKey == KeyEvent.VK_CAPS_LOCK) {
			keys[4][0].setBackground(Color.YELLOW);
			keys[4][1].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (editKey == KeyEvent.VK_BACK_SPACE) {
			keys[2][13].setBackground(Color.YELLOW);
			keys[2][14].setBackground(Color.YELLOW);
			return true;
		} 
		
		else if (editKey == KeyEvent.VK_ENTER
				&& e.getKeyLocation() == KeyEvent.KEY_LOCATION_STANDARD) {
			keys[3][13].setBackground(Color.YELLOW);
			keys[3][14].setBackground(Color.YELLOW);
			keys[4][14].setBackground(Color.YELLOW);
			return true;
		}
		
		else {
		return false;
		}
	}

	/**
	 * Checks if system keys like ctrl, alt, window-key etc. were pressed
	 * @param e KeyEvent: Uses Keycode() or KeyChar() to check if given key was pressed
	 * */
	private boolean checkSystemKeys(KeyEvent e) {
		
		int systemKey = e.getKeyCode();
		int location = e.getKeyLocation();
		
		if (systemKey == KeyEvent.VK_ESCAPE) {
			keys[0][0].setBackground(Color.YELLOW);
			return true;
			
		} else if (systemKey == KeyEvent.VK_SCROLL_LOCK) {
			keys[0][18].setBackground(Color.YELLOW);
			return true;
		}

		else if (systemKey == KeyEvent.VK_ALT && location == KeyEvent.KEY_LOCATION_RIGHT) {
			if(!ctrlFlag)
			keys[6][0].setBackground(Color.WHITE);
			keys[6][11].setBackground(Color.YELLOW);
			return true;
		}
		
		//To prevent the altGr key to bug, I will activate ctrl when released.
		else if (systemKey == KeyEvent.VK_CONTROL && location == KeyEvent.KEY_LOCATION_LEFT) {
			keys[6][0].setBackground(Color.YELLOW);
			ctrlPressed = true;
			return true;
		}

		else if (systemKey == KeyEvent.VK_CONTROL
				&& location == KeyEvent.KEY_LOCATION_RIGHT) {
			keys[6][14].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (systemKey == KeyEvent.VK_PAUSE) {
			keys[0][19].setBackground(Color.YELLOW);
			return true;
		}

		else if (systemKey == KeyEvent.VK_WINDOWS
				&& location == KeyEvent.KEY_LOCATION_LEFT) {
			keys[6][1].setBackground(Color.YELLOW);
			return true;
		} else if (systemKey == KeyEvent.VK_WINDOWS
				&& location == KeyEvent.KEY_LOCATION_RIGHT) {
			keys[6][12].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (systemKey == KeyEvent.VK_ALT && location == KeyEvent.KEY_LOCATION_LEFT) {
			keys[6][2].setBackground(Color.YELLOW);
			keyBools[0] = true;
			return true;
		}

		else if (systemKey == KeyEvent.VK_TAB) {
			keys[3][0].setBackground(Color.YELLOW);
			return true;
		}

		else if (systemKey == KeyEvent.VK_CONTEXT_MENU) {
			keys[6][13].setBackground(Color.YELLOW);
			return true;
		}

		//Shift is no system but edit key for me ... but oh well.... location wise I put it here for convenience
		else if (systemKey == KeyEvent.VK_SHIFT && location == KeyEvent.KEY_LOCATION_LEFT) {
			keys[5][0].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (systemKey == KeyEvent.VK_SHIFT
				&& location == KeyEvent.KEY_LOCATION_RIGHT) {
			keys[5][13].setBackground(Color.YELLOW);
			keys[5][14].setBackground(Color.YELLOW);
			return true;
		}
		
		else
			return false;
	}

	/**
	 * Checks if F-Keys were pressed
	 * @param e KeyEvent: Uses Keycode() or KeyChar() to check if given key was pressed
	 * */
	private boolean checkFKeys(KeyEvent e) {
		// F1 until F12
		int fKey = e.getKeyCode();
		
		if (fKey >= KeyEvent.VK_F1
				&& fKey <= KeyEvent.VK_F12) {
			if (fKey < KeyEvent.VK_F5)
				keys[0][fKey - 110].setBackground(Color.YELLOW);

			if (fKey >= KeyEvent.VK_F5
					&& fKey < KeyEvent.VK_F9)
				keys[0][fKey - 109].setBackground(Color.YELLOW);

			if (fKey >= KeyEvent.VK_F9)
				keys[0][fKey - 108].setBackground(Color.YELLOW);

			return true;
		}
		return false;
	}
	/**
	 * Checks if standard area number keys were pressed
	 * @param e KeyEvent: Uses Keycode() or KeyChar() to check if given key was pressed
	 * */
	private boolean checkNumberKeys(KeyEvent e) {
		int numKey = e.getKeyCode();
		
		if (numKey >= KeyEvent.VK_0 && numKey <= KeyEvent.VK_9) {
			if (numKey == KeyEvent.VK_0) {
				keys[2][10].setBackground(Color.YELLOW);	
			}
			else{
				String numberPos = "" + e.getKeyChar();
				keys[2][Integer.parseInt(numberPos)].setBackground(Color.YELLOW);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if Numpad keys were pressed
	 * @param e KeyEvent: Uses Keycode() or KeyChar() to check if given key was pressed
	 * */
	private boolean checkNumpadKeys(KeyEvent e){
		int numpad = e.getKeyCode();
		
		if(numpad == KeyEvent.VK_NUMPAD0 || numpad == KeyEvent.VK_INSERT){
			keys[6][20].setBackground(Color.YELLOW);
			keys[6][21].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD1 || numpad == KeyEvent.VK_END){
			keys[5][20].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD2 || numpad == KeyEvent.VK_DOWN){
			keys[5][21].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD3 || numpad == KeyEvent.VK_PAGE_DOWN){
			keys[5][22].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD4 || numpad == KeyEvent.VK_LEFT){
			keys[4][20].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD5 || numpad == KeyEvent.VK_CLEAR){
			keys[4][21].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD6 || numpad == KeyEvent.VK_RIGHT){
			keys[4][22].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD7 || numpad == KeyEvent.VK_HOME){
			keys[3][20].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD8 || numpad == KeyEvent.VK_UP){
			keys[3][21].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD9 || numpad == KeyEvent.VK_PAGE_UP){
			keys[3][22].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUM_LOCK){
			keys[2][20].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_DELETE || numpad == KeyEvent.VK_DECIMAL){
			keys[6][22].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_ADD){
			keys[3][23].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_SUBTRACT){
			keys[2][23].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_MULTIPLY){
			keys[2][22].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_DIVIDE){
			keys[2][21].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (numpad == KeyEvent.VK_ENTER) {
			keys[5][23].setBackground(Color.YELLOW);
			keys[6][23].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == 0 && e.getKeyChar() == '.'){
			keys[4][23].setBackground(Color.YELLOW);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks if arrow keys were pressed
	 * @param e KeyEvent: Uses Keycode() or KeyChar() to check if given key was pressed
	 * */
	private boolean checkArrowKeys(KeyEvent e){
		int arrow = e.getKeyCode();
		if(arrow == KeyEvent.VK_UP){
			keys[5][17].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(arrow == KeyEvent.VK_DOWN){
			keys[6][17].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(arrow == KeyEvent.VK_LEFT){
			keys[6][16].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(arrow == KeyEvent.VK_RIGHT){
			keys[6][18].setBackground(Color.YELLOW);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks if a letter key or keys in the letter area were pressed
	 * @param e KeyEvent: Uses Keycode() or KeyChar() to check if given key was pressed
	 * */
	private boolean checkLetterKeys(KeyEvent e){
		int letter = e.getKeyCode();
		
		if(letter == KeyEvent.VK_SPACE){
			for(int i = 3; i < 11 ; i++){
				keys[6][i].setBackground(Color.YELLOW);
			}
			return true;
		}
	
		
		else if(letter == KeyEvent.VK_BACK_SLASH){
			keys[5][1].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_Z){
			keys[5][2].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_X){
			keys[5][3].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_C){
			keys[5][4].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_V){
			keys[5][5].setBackground(Color.YELLOW);
			return true;
		}
		else if(letter == KeyEvent.VK_B){
			keys[5][6].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_N){
			keys[5][7].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_M){
			keys[5][8].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_COMMA){
			keys[5][9].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_PERIOD){
			keys[5][10].setBackground(Color.YELLOW);
			return true;
		}
		
		//Hier war der Punkt
		
		else if(letter == KeyEvent.VK_SEMICOLON){
			keys[5][11].setBackground(Color.YELLOW);
			return true;
		}
		
		//letter == KeyEvent.VK_SLASH does not happen with ABNT2 keyboard... lol
		else if(letter == 0 && e.getKeyChar() == '/'){
			keys[5][12].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_A){
			keys[4][2].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_S){
			keys[4][3].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_D){
			keys[4][4].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_F){
			keys[4][5].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_G){
			keys[4][6].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_H){
			keys[4][7].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_J){
			keys[4][8].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_K){
			keys[4][9].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_L){
			keys[4][10].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(e.getKeyChar() == 'ç' || e.getKeyChar() == 'Ç'){
			keys[4][11].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_DEAD_TILDE){
			keys[4][12].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_CLOSE_BRACKET){
			keys[4][13].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_Q){
			keyBools[1] = true;
			keys[3][1].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_W){
			keys[3][2].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_E){
			keys[3][3].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_R){
			keys[3][4].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_T){
			keys[3][5].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_Y){
			keys[3][6].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_U){
			keys[3][7].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_I){
			keys[3][8].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_O){
			keys[3][9].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_P){
			keys[3][10].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_DEAD_ACUTE){
			keys[3][11].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_OPEN_BRACKET){
			keys[3][12].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_MINUS){
			keys[2][11].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_EQUALS){
			keys[2][12].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (letter == KeyEvent.VK_QUOTE) {
			keys[2][0].setBackground(Color.YELLOW);
			return true;
		}	
		return false;
	}
	
	/**
	 * Not necessary anymore but might be useful if I need to update stuff ...
	 * @param e KeyEvent: Uses Keycode() or KeyChar() to check if given key was pressed
	 * */
	@SuppressWarnings("unused")
	@Deprecated
	private void debug(KeyEvent e){
		String location = "";
		switch(e.getKeyLocation()){
		case 1: location = "Standard";
			break;
		case 2: location = "Links";
		break;
		case 3: location  = "Rechts";
		break;
		case 4: location = "Numpad";
		}
		System.out.println("Keycode: " + e.getKeyCode() + " | Location: " + location + " | Zeichen: " + e.getKeyChar());
	}
}

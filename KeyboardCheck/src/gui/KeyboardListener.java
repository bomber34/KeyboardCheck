package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class KeyboardListener implements KeyListener {

	private JLabel[] keys = new JLabel[168];
	private boolean[] keyBools = new boolean[3];
	private Keys keyStuff;

	public KeyboardListener(Keys k) {
		keys = k.getKeyArray();
		keyStuff = k;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Workaround for ALT-GR keys
//		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
//			keyBools[0] = true;
//		}
//		if (e.getKeyCode() == KeyEvent.VK_ALT) {
//			keyBools[1] = true;
//		}
		
		if(e.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD){
			if(checkNumpadKeys(e))
				return;
		}
		
		if(e.getKeyLocation() == KeyEvent.KEY_LOCATION_STANDARD){
		
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
		//ALT-GR Key
		if (keyBools[0] && keyBools[1]) {
			keys[155].setBackground(Color.YELLOW);
		}

		//PrintScreen key only checkable here???
		if (e.getKeyCode() == KeyEvent.VK_PRINTSCREEN) {
			keys[17].setBackground(Color.YELLOW);
			return;
		}
		
		if(keyBools[1] && keyBools[2]){
			keyStuff.setBaseColorAndBorder();
		}
		
		for(int i = 0; i < keyBools.length;i++){
			keyBools[i] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Checks if text edit keys were pressed
	 * @param e KeyEvent: Uses Keycode() or KeyChar() to check if given key was pressed
	 * */
	private boolean checkEditKeys(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_INSERT) {
			keys[64].setBackground(Color.YELLOW);
			return true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
			keys[88].setBackground(Color.YELLOW);
			return true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
			keys[66].setBackground(Color.YELLOW);
			return true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
			keys[90].setBackground(Color.YELLOW);
			return true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_HOME) {
			keys[65].setBackground(Color.YELLOW);
			return true;
		} 
		
		else if (e.getKeyCode() == KeyEvent.VK_END) {
			keys[89].setBackground(Color.YELLOW);
			return true;
		} 
		
		else if (e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
			keys[96].setBackground(Color.YELLOW);
			keys[97].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			keys[61].setBackground(Color.YELLOW);
			keys[62].setBackground(Color.YELLOW);
			return true;
		} 
		
		else if (e.getKeyCode() == KeyEvent.VK_ENTER
				&& e.getKeyLocation() == KeyEvent.KEY_LOCATION_STANDARD) {
			keys[85].setBackground(Color.YELLOW);
			keys[86].setBackground(Color.YELLOW);
			keys[110].setBackground(Color.YELLOW);
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

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			keys[0].setBackground(Color.YELLOW);
			return true;
		} else if (e.getKeyCode() == KeyEvent.VK_SCROLL_LOCK) {
			keys[18].setBackground(Color.YELLOW);
			return true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_CONTROL && e.getKeyLocation() == KeyEvent.KEY_LOCATION_LEFT) {
			keys[144].setBackground(Color.YELLOW);
			keyBools[0] = true;
			return true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_CONTROL
				&& e.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT) {
			keys[158].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_PAUSE) {
			keys[19].setBackground(Color.YELLOW);
			return true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_WINDOWS
				&& e.getKeyLocation() == KeyEvent.KEY_LOCATION_LEFT) {
			keys[145].setBackground(Color.YELLOW);
			return true;
		} else if (e.getKeyCode() == KeyEvent.VK_WINDOWS
				&& e.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT) {
			keys[156].setBackground(Color.YELLOW);
			return true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_ALT) {
			keyBools[1] = true;
			keys[146].setBackground(Color.YELLOW);
			return true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_TAB) {
			keys[72].setBackground(Color.YELLOW);
			return true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_CONTEXT_MENU) {
			keys[157].setBackground(Color.YELLOW);
			return true;
		}

		//Shift is no system but edit key for me ... but oh well....
		else if (e.getKeyCode() == KeyEvent.VK_SHIFT && e.getKeyLocation() == KeyEvent.KEY_LOCATION_LEFT) {
			keys[120].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_SHIFT
				&& e.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT) {
			keys[133].setBackground(Color.YELLOW);
			keys[134].setBackground(Color.YELLOW);
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
		if (e.getKeyCode() >= KeyEvent.VK_F1
				&& e.getKeyCode() <= KeyEvent.VK_F12) {
			if (e.getKeyCode() < KeyEvent.VK_F5)
				keys[e.getKeyCode() - 110].setBackground(Color.YELLOW);

			if (e.getKeyCode() >= KeyEvent.VK_F5
					&& e.getKeyCode() < KeyEvent.VK_F9)
				keys[e.getKeyCode() - 109].setBackground(Color.YELLOW);

			if (e.getKeyCode() >= KeyEvent.VK_F9)
				keys[e.getKeyCode() - 108].setBackground(Color.YELLOW);

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
				keys[58].setBackground(Color.YELLOW);
			} else {
				keys[numKey].setBackground(Color.YELLOW);
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
			keys[164].setBackground(Color.YELLOW);
			keys[165].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD1 || numpad == KeyEvent.VK_END){
			keys[140].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD2 || numpad == KeyEvent.VK_DOWN){
			keys[141].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD3 || numpad == KeyEvent.VK_PAGE_DOWN){
			keys[142].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD4 || numpad == KeyEvent.VK_LEFT){
			keys[116].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD5 || numpad == KeyEvent.VK_CLEAR){
			keys[117].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD6 || numpad == KeyEvent.VK_RIGHT){
			keys[118].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD7 || numpad == KeyEvent.VK_HOME){
			keys[92].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD8 || numpad == KeyEvent.VK_UP){
			keys[93].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUMPAD9 || numpad == KeyEvent.VK_PAGE_UP){
			keys[94].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_NUM_LOCK){
			keys[68].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_DELETE || numpad == KeyEvent.VK_DECIMAL){
			keys[166].setBackground(Color.YELLOW);
			return true;
		}
		
//		else if(numpad == KeyEvent.VK_){
//			keys[119].setBackground(Color.YELLOW);
//			return true;
//		}
		
		else if(numpad == KeyEvent.VK_ADD){
			keys[95].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_SUBTRACT){
			keys[71].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_MULTIPLY){
			keys[70].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(numpad == KeyEvent.VK_DIVIDE){
			keys[69].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (numpad == KeyEvent.VK_ENTER) {
			keys[143].setBackground(Color.YELLOW);
			keys[167].setBackground(Color.YELLOW);
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
			keys[137].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(arrow == KeyEvent.VK_DOWN){
			keys[161].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(arrow == KeyEvent.VK_LEFT){
			keys[160].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(arrow == KeyEvent.VK_RIGHT){
			keys[162].setBackground(Color.YELLOW);
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
			for(int i = 147; i < 155 ; i++){
				keys[i].setBackground(Color.YELLOW);
			}
			return true;
		}
	
		
		else if(letter == KeyEvent.VK_BACK_SLASH){
			keys[121].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_Z){
			keys[122].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_X){
			keys[123].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_C){
			keys[124].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_V){
			keys[125].setBackground(Color.YELLOW);
			return true;
		}
		else if(letter == KeyEvent.VK_B){
			keys[126].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_N){
			keys[127].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_M){
			keys[128].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_COMMA){
			keys[129].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_PERIOD){
			keys[130].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == 0 && e.getKeyChar() == '.'){
			keys[119].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_SEMICOLON){
			keys[131].setBackground(Color.YELLOW);
			return true;
		}
		
		//letter == KeyEvent.VK_SLASH
		else if(letter == 0 && e.getKeyChar() == '/'){
			keys[132].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_A){
			keys[98].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_S){
			keys[99].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_D){
			keys[100].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_F){
			keys[101].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_G){
			keys[102].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_H){
			keys[103].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_J){
			keys[104].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_K){
			keys[105].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_L){
			keys[106].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(e.getKeyChar() == 'ç' || e.getKeyChar() == 'Ç'){
			keys[107].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_DEAD_TILDE){
			keys[108].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_CLOSE_BRACKET){
			keys[109].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_Q){
			keyBools[2] = true;
			keys[73].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_W){
			keys[74].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_E){
			keys[75].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_R){
			keys[76].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_T){
			keys[77].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_Y){
			keys[78].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_U){
			keys[79].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_I){
			keys[80].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_O){
			keys[81].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_P){
			keys[82].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_P){
			keys[82].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_DEAD_ACUTE){
			keys[83].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_OPEN_BRACKET){
			keys[84].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_MINUS){
			keys[59].setBackground(Color.YELLOW);
			return true;
		}
		
		else if(letter == KeyEvent.VK_EQUALS){
			keys[60].setBackground(Color.YELLOW);
			return true;
		}
		
		else if (e.getKeyChar() == '\'') {
			keys[48].setBackground(Color.YELLOW);
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

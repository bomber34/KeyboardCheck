package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *	main class to set up the jframe and its components
 */
public class KeyboardCheck {

	private final JFrame window;
	private JPanel masterPanel;
	private KeyboardListener kListener;
	private KeyBoardImagePanel kbPan;
	
	public KeyboardCheck() {
		window = new JFrame("Keyboard Check");
		window.setSize(1200, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setFocusTraversalKeysEnabled(false);
		
		kbPan = new KeyBoardImagePanel();
		masterPanel = kbPan.getPanel();
		
		kListener = new KeyboardListener(kbPan.getKeys());
		window.addKeyListener(kListener);
		
		new WindowMenuBar(this);
		window.setVisible(true);
	}
	
	public JFrame getWindow(){
		return window;
	}
	public JPanel getMasterPanel(){
		return masterPanel;
	}
	
	public KeyBoardImagePanel getKBPan(){
		return kbPan;
	}
	

}

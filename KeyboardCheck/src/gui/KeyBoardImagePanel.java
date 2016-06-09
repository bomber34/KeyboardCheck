package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 *	Creates the panel that presents you the keyboard keys.
 */
public class KeyBoardImagePanel {

	private JPanel kbPanel;
	private Keys keyboard;
	
	public KeyBoardImagePanel(){
		
		keyboard = new Keys();
		
		kbPanel = new JPanel();
		kbPanel.setLayout(new GridLayout(7,24));
		
		int rows = keyboard.getNumberOfPanelRows(); // 7
		int columns = keyboard.getNumberOfPanelColumns(); // 24
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				kbPanel.add(keyboard.getLabelAt(i,j));
			}
		}
	}
	
	public JPanel getPanel(){
		return kbPanel;
	}
	
	public Keys getKeys(){
		return keyboard;
	}
}

package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class KeyBoardImagePanel extends JPanel {

	private static final long serialVersionUID = -97815897532460326L;
	private JPanel kbPanel;
	private Keys keyboard;
	
	public KeyBoardImagePanel(){
		
		keyboard = new Keys();
		
		kbPanel = new JPanel();
		kbPanel.setLayout(new GridLayout(7,24));

		for(int i = 0; i < keyboard.getNumberOfPanels();i++){
			kbPanel.add(keyboard.getLabelAt(i));
		}
	}
	
	public JPanel getPanel(){
		return kbPanel;
	}
	
	public Keys getKeys(){
		return keyboard;
	}
}

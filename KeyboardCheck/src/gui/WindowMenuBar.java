package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *	Adds menubar to the mainframe 
 */
public class WindowMenuBar implements ActionListener {

	private JFrame window;
	private JPanel masterPanel;
	private KeyBoardImagePanel kbPanel;
	private WinListener winListener;
	
	//Option menu
	private JMenu options;
	private JMenuItem restart;
	
	//Help Menu
	private JMenu help;
	private JMenuItem known_Issues;

	
	public WindowMenuBar(KeyboardCheck kbCheck){
		window = kbCheck.getWindow();
		masterPanel = kbCheck.getMasterPanel();
		kbPanel = kbCheck.getKBPan();
		winListener = new WinListener(window);
		
		JMenuBar menu = new JMenuBar();
		
		options = new JMenu("Options");
		restart = new JMenuItem("Restart   ALT+Q");
		restart.addActionListener(this);
		options.add(restart);
		menu.add(options);
		
		help = new JMenu("Help");
		known_Issues = new JMenuItem("Known Issues");
		known_Issues.addActionListener(this);
		help.add(known_Issues);
		menu.add(help);
		menu.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "none");
		
		window.add(menu, BorderLayout.NORTH);
		window.add(masterPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == restart){
			kbPanel.getKeys().setBaseColorAndBorder();
		}
		
		if(ae.getSource() == known_Issues){
			JFrame infoWindow = new JFrame("Known Issues");
			infoWindow.setAlwaysOnTop(true);
			infoWindow.setSize(600, 400);
			
			window.setEnabled(false);
			infoWindow.addWindowListener(winListener);
			
			JPanel textPan = new JPanel();
			JLabel hint = new JLabel("<html>Following keys have issues:<br><br>Left Control:<br>	"
					+"Key is only recognized when released, due to ALTGR activating it when pressed"
					+ "<br><br>"
					+ "PrintScreen:<br>    Key is only recognized when released."
					+ "<br><br>"
					+ "FN:<br>    Java can't recognize the FN key at all. Test functions instead."
					+ "<br><br>"
					+ "Refreshing keyboard with ALT+Q:<br>    Key combo must be released together."
					+ "<br><br>"
					+ "Using different language layouts instead of brazilian ABNT2 may activate wrong keys <br>"
					+ "than showed on screen. Should still indicate if key functions at all."
					+ "<br><br>"
					+ "F10: Will unfocus the window ...</html>");
			hint.setHorizontalAlignment(JLabel.CENTER);
			hint.setVerticalAlignment(JLabel.CENTER);
			textPan.add(hint);
			
			infoWindow.add(textPan);
			infoWindow.setVisible(true);
		}
	}
	
}

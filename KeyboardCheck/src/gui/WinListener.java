package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

/**
 * WindowListener is used for extra JFrames like the "known issues" one.
 */
public class WinListener implements WindowListener {

	private JFrame mainWin;
	
	public WinListener(JFrame mainWindow){
		mainWin = mainWindow;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		mainWin.setEnabled(true);
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		mainWin.setEnabled(true);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}

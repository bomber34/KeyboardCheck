package gui;

public class GUI_Start {

	public GUI_Start() {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new KeyboardCheck();
				
			}
			
		});
		
	}

	public static void main(String[] args) {
		new GUI_Start();
	}

}

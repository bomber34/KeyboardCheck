package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;


/**
 *	create the JLabel matrix to display keys on the main frame in ABNT2
 *	@toDo: Create a way to use a few other layouts
 */
public class Keys {

	//Reihen | Tasten
	// 1  | 16
	// 2  | 18
	// 3  | 18
	// 4  | 16
	// 5  | 18
	// 6  | 13
	private JLabel[][] key;
	public Keys(){
		key = new JLabel[7][24];
		createTopRow();
		create2ndEmptyRow();
		create3rdRow();
		create4thRow();
		create5thRow();
		create6thRow();
		createFinalRow();
		setBaseColorAndBorder();

	}
	
	public JLabel[][] getKeyArray(){
		return key;
	}
	
	public JLabel getLabelAt(int row, int column ){
		boolean correctRow = (row >= 0 && row < 7 ? true : false);
		boolean correctColumn = (column >= 0 && column < 24 ? true : false);
	
		if(correctRow && correctColumn){
			return key[row][column];
		}
		
		else
			return key[1][0]; //Empty row, empty panel
	}
	
	public int getNumberOfPanelRows(){
		return key.length;
	}
	public int getNumberOfPanelColumns(){
		return key[0].length;
	}


	private boolean isKey(int row, int column){
		
		switch(row){
		//first row
		case 0:
			if(column == 1 || column == 6 || column == 11 || column == 16 || (column >=20 && column<=23)){
			return false;
			}
		break;
		//2nd Row
		case 1: 
			return false;

		//3rd row
		case 2:
			if(column == 15 || column == 19){
			return false;
			}
			break;
					
		//4th row
		case 3:
			if(column == 15 || column == 19){
			return false;
			}
			break;
		//5th row
		case 4:
			if(column>=15 && column<= 19){
			return false;
			}
			break;
		
		//6th row
		case 5:
			if(column == 15 || column==16 || column==18 || column==19){
			return false;
			}
			break;
		//final row
		case 6:
			if(column == 15 || column == 19){
			return false;
			}
			break;
		default: 
			break;
		}
		return true;
		
	}
	
	public void setBaseColorAndBorder(){
		
		for(int row = 0; row < 7; row++){
			for(int column = 0; column < 24; column++){
				if(isKey(row, column)){
					key[row][column].setOpaque(true);
			
					key[row][column].setBackground(Color.WHITE);
					if(isSmallKey(row, column)){
						key[row][column].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
						key[row][column].setHorizontalAlignment(JLabel.CENTER);
					}
				}
			}
		}
	}
	private boolean isSmallKey(int row, int column){
		
		switch(row){
		
		case 2:
		//Backspace
		if(column == 13){ 
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			key[row][column].setHorizontalAlignment(JLabel.RIGHT);
			return false;
		}
		
		else if(column == 14){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			return false;
		}
		else 
			break;
		
		case 3:
		// Top Enter
		if(column == 13){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			key[row][column].setHorizontalAlignment(JLabel.RIGHT);
			return false;
		}
		
		else if(column == 14){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.BLACK));
			key[row][column].setHorizontalAlignment(JLabel.LEFT);
			return false;
		}
		else
			break;
		
		case 4:
		
			//CapsLock
		if(column == 0){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			key[row][column].setHorizontalAlignment(JLabel.RIGHT);
		
			return false;
		}
			
		else if(column == 1){
		
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			return false;
		}
			
		//Standard Enter bottom
		else if(column == 14){
			key[row][column].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
			return false;
		}
		else{
			break;
		}
			
		case 5:
		//Right Shift
		if(column == 13){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			key[row][column].setHorizontalAlignment(JLabel.RIGHT);
			return false;
		}
			
		else if(column == 14){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			return false;
		}
			
		//Numpad Enter top
		else if(column == 23){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
			key[row][column].setHorizontalAlignment(JLabel.CENTER);
			return false;
		}
		else {
			break;
		}

		case 6:
			//spacebar
			if(column == 3){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			return false;}
			
			else if(column >= 4 && column <= 9){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
			return false;
			}
			
			else if(column == 10){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			return false;
			}
		
		//Numpad 0 | Insert
			else if(column == 20){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			key[row][column].setHorizontalAlignment(JLabel.RIGHT);
			return false;
			}
			
			else if(column == 21){
			key[row][column].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			return false;
			}
		
			//Numpad Enter bottom
			else if(column == 23){
			key[row][column].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
			return false;
			}
			
			else{
				break;
			}
		default:
				break;
		}
		return true;
	}
	
	// von 144 bis 167
	private void createFinalRow(){
		key[6][0] = new JLabel("Ctrl");
		key[6][1] = new JLabel("Win");
		key[6][2] = new JLabel("Alt");
		key[6][3] = new JLabel("");
		key[6][4] = new JLabel("");
		key[6][5] = new JLabel("");
		key[6][6] = new JLabel("");
		key[6][7] = new JLabel("");
		key[6][8] = new JLabel("");
		key[6][9] = new JLabel("");
		key[6][10] = new JLabel("");
		key[6][11] = new JLabel("AltGr");
		key[6][12] = new JLabel("Win");
		key[6][13] = new JLabel("Menu");
		key[6][14] = new JLabel("Ctrl");
		key[6][15] = new JLabel(" ");
		key[6][16] = new JLabel("LT");
		key[6][17] = new JLabel("DW");
		key[6][18] = new JLabel("RT");
		key[6][19] = new JLabel(" ");
		key[6][20] = new JLabel("<html>0<br>Ins</html>");
		key[6][21] = new JLabel("<html><br>ert</html>");
		key[6][22] = new JLabel(",");
		key[6][23] = new JLabel(" ");
 	}
	
	//von 120 bis 143
	private void create6thRow(){
		key[5][0] = new JLabel("Shift");
		key[5][1] = new JLabel("\\");
		key[5][2] = new JLabel("Z");
		key[5][3] = new JLabel("X");
		key[5][4] = new JLabel("C");
		key[5][5] = new JLabel("V");
		key[5][6] = new JLabel("B");
		key[5][7] = new JLabel("N");
		key[5][8] = new JLabel("M");
		key[5][9] = new JLabel(",");
		key[5][10] = new JLabel(".");
		key[5][11] = new JLabel(";");
		key[5][12] = new JLabel("/");
		key[5][13] = new JLabel("Shift");
		key[5][14] = new JLabel("Right");
		key[5][15] = new JLabel(" ");
		key[5][16] = new JLabel(" ");
		key[5][17] = new JLabel("UP");
		key[5][18] = new JLabel(" ");
		key[5][19] = new JLabel(" ");
		key[5][20] = new JLabel("1");
		key[5][21] = new JLabel("2");
		key[5][22] = new JLabel("3");
		key[5][23] = new JLabel("Enter");
	}
	
	// von 96 bis 119
	private void create5thRow(){
		key[4][0] = new JLabel("Caps");
		key[4][1] = new JLabel("Lock");
		key[4][2] = new JLabel("A");
		key[4][3] = new JLabel("S");
		key[4][4] = new JLabel("D");
		key[4][5] = new JLabel("F");
		key[4][6] = new JLabel("G");
		key[4][7] = new JLabel("H");
		key[4][8] = new JLabel("J");
		key[4][9] = new JLabel("K");
		key[4][10] = new JLabel("L");
		key[4][11] = new JLabel("Ç");
		key[4][12] = new JLabel("~");
		key[4][13] = new JLabel("]");
		//1x für Enter| 5x leere
		for(int i = 14; i < 20; i++){
			key[4][i] = new JLabel(" ");
		}
		key[4][20] = new JLabel("4");
		key[4][21] = new JLabel("5");
		key[4][22] = new JLabel("6");
		key[4][23] = new JLabel(".");
		
	}
	
	//von 72 bis 95
	private void create4thRow(){
		key[3][0] = new JLabel("Tab");
		key[3][1] = new JLabel("Q");
		key[3][2] = new JLabel("W");
		key[3][3] = new JLabel("E");
		key[3][4] = new JLabel("R");
		key[3][5] = new JLabel("T");
		key[3][6] = new JLabel("Y");
		key[3][7] = new JLabel("U");
		key[3][8] = new JLabel("I");
		key[3][9] = new JLabel("O");
		key[3][10] = new JLabel("P");
		key[3][11] = new JLabel("´");
		key[3][12] = new JLabel("[");
		key[3][13] = new JLabel("Ent");
		key[3][14] = new JLabel("er");
		key[3][15] = new JLabel(" ");
		key[3][16] = new JLabel("Del");
		key[3][17] = new JLabel("End");
		key[3][18] = new JLabel("<html>Page<br>Down</html>");
		key[3][19] = new JLabel(" ");
		key[3][20] = new JLabel("7");
		key[3][21] = new JLabel("8");
		key[3][22] = new JLabel("9");
		key[3][23] = new JLabel("+");
	}
	
	//von 48 bis 71
	private void create3rdRow(){
		key[2][0] = new JLabel("'");
		for(int i = 1; i < 11; i++){
			key[2][i] = new JLabel("" + i % 10);
		}
		key[2][11] = new JLabel("-");
		key[2][12] = new JLabel("=");
		key[2][13] = new JLabel("Back");
		key[2][14] = new JLabel("Space");
		key[2][15] = new JLabel(" ");
		key[2][16] = new JLabel("Insert");
		key[2][17] = new JLabel("Home");
		key[2][18] = new JLabel("<html>Page<br>Up</html>");
		key[2][19] = new JLabel(" ");
		key[2][20] = new JLabel("Num");
		key[2][21] = new JLabel("/");
		key[2][22] = new JLabel("*");
		key[2][23] = new JLabel("-");
	}
	
	//von 24 bis 47
	private void create2ndEmptyRow(){
		for(int i = 0; i < 24; i++){
			key[1][i] = new JLabel(" ");
		}
	}
	// von 0 bis 23
	private void createTopRow(){
		key[0][0] = new JLabel("ESC");
		key[0][1] = new JLabel(" ");
		key[0][2] = new JLabel("F1");
		key[0][3] = new JLabel("F2");
		key[0][4] = new JLabel("F3");
		key[0][5] = new JLabel("F4");
		key[0][6] = new JLabel(" ");
		key[0][7] = new JLabel("F5");
		key[0][8] = new JLabel("F6");
		key[0][9] = new JLabel("F7");
		key[0][10] = new JLabel("F8");
		key[0][11] = new JLabel(" ");
		key[0][12] = new JLabel("F9");
		key[0][13] = new JLabel("F10");
		key[0][14] = new JLabel("F11");
		key[0][15] = new JLabel("F12");
		key[0][16] = new JLabel(" ");
		key[0][17] = new JLabel("<html>Print<br>Screen</html>");
		key[0][18] = new JLabel("Scroll");
		key[0][19] = new JLabel("Pause");
		for(int l = 20; l < 24;l++){
			key[0][l] = new JLabel(" ");
		}
	}
}

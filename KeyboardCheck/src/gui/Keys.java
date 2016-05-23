package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Keys {

	//Reihen | Tasten
	// 1  | 16
	// 2  | 18
	// 3  | 18
	// 4  | 16
	// 5  | 18
	// 6  | 13
	private JLabel[] key;
	public Keys(){
		key = new JLabel[168];
		createTopRow();
		create2ndEmptyRow();
		create3rdRow();
		create4thRow();
		create5thRow();
		create6thRow();
		createFinalRow();
		setBaseColorAndBorder();

	}
	
	public JLabel[] getKeyArray(){
		return key;
	}
	
	public JLabel getLabelAt(int i ){
		return key[i];
	}
	public int getNumberOfPanels(){
		return key.length;
	}


	private boolean isKey(int n){
		
		//First row
		if(n == 1 || n == 6 || n == 11 || n == 16 || (n >=20 && n<=23)){
			return false;
		}
		//2nd Row
		else if(n >= 24 && n <= 47)
			return false;
		
		//3rd row
		else if(n == 63 || n == 67)
			return false;
					
		//4th row
		else if(n == 87 || n == 91)
			return false;
		
		//5th row
		else if(n>=111 && n<= 115)
			return false;
		
		//6th row
		else if(n == 135 || n==136 || n==138 || n==139)
			return false;
		
		//final row
		else if(n == 159 || n == 163)
			return false;
		
		else
			return true;
		
	}
	
	public void setBaseColorAndBorder(){
		
		for(int i = 0; i < key.length; i++){
			if(isKey(i)){
			key[i].setOpaque(true);
			
			key[i].setBackground(Color.WHITE);
				if(isSmallKey(i)){
					key[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
					key[i].setHorizontalAlignment(JLabel.CENTER);
				}
			}
		}
	}
	private boolean isSmallKey(int i){
		
		switch(i){
		
		//Backspace
		case 61: 
			key[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			key[i].setHorizontalAlignment(JLabel.RIGHT);
			return false;
		
		case 62:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			return false;
			
		//Enter
		case 85:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			key[i].setHorizontalAlignment(JLabel.RIGHT);
			return false;
			
		case 86:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.BLACK));
			key[i].setHorizontalAlignment(JLabel.LEFT);
			return false;
			
		case 110:
			key[i].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
			return false;
			
		//CapsLock
		case 96:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			key[i].setHorizontalAlignment(JLabel.RIGHT);
			return false;
			
		case 97:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			return false;
			
		//Right Shift
		case 133:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			key[i].setHorizontalAlignment(JLabel.RIGHT);
			return false;
			
		case 134:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			return false;
			
		//Spacebar
		case 147:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			return false;
			
		case 148:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
			return false;
			
		case 149:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
			return false;
			
		case 150:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
			return false;
			
		case 151:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
			return false;
			
		case 152:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
			return false;
			
		case 153:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
			return false;
			
		case 154:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			return false;
			
		//Numpad 0 | Insert
		case 164:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
			key[i].setHorizontalAlignment(JLabel.RIGHT);
			return false;
			
		case 165:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			return false;
			
		//Numpad Enter
		case 143:
			key[i].setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
			key[i].setHorizontalAlignment(JLabel.CENTER);
			return false;
		
		case 167:
			key[i].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
			return false;
					
		default:
				return true;
		
		}
	}
	
	// von 144 bis 167
	private void createFinalRow(){
		key[144] = new JLabel("Ctrl");
		key[145] = new JLabel("Win");
		key[146] = new JLabel("Alt");
		key[147] = new JLabel("");
		key[148] = new JLabel("");
		key[149] = new JLabel("");
		key[150] = new JLabel("");
		key[151] = new JLabel("");
		key[152] = new JLabel("");
		key[153] = new JLabel("");
		key[154] = new JLabel("");
		key[155] = new JLabel("AltGr");
		key[156] = new JLabel("Win");
		key[157] = new JLabel("Menu");
		key[158] = new JLabel("Ctrl");
		key[159] = new JLabel(" ");
		key[160] = new JLabel("LT");
		key[161] = new JLabel("DW");
		key[162] = new JLabel("RT");
		key[163] = new JLabel(" ");
		key[164] = new JLabel("<html>0<br>Ins</html>");
		key[165] = new JLabel("<html><br>ert</html>");
		key[166] = new JLabel(",");
		key[167] = new JLabel(" ");
 	}
	
	//von 120 bis 143
	private void create6thRow(){
		key[120] = new JLabel("Shift");
		key[121] = new JLabel("\\");
		key[122] = new JLabel("Z");
		key[123] = new JLabel("X");
		key[124] = new JLabel("C");
		key[125] = new JLabel("V");
		key[126] = new JLabel("B");
		key[127] = new JLabel("N");
		key[128] = new JLabel("M");
		key[129] = new JLabel(",");
		key[130] = new JLabel(".");
		key[131] = new JLabel(";");
		key[132] = new JLabel("/");
		key[133] = new JLabel("Shift");
		key[134] = new JLabel("Right");
		key[135] = new JLabel(" ");
		key[136] = new JLabel(" ");
		key[137] = new JLabel("UP");
		key[138] = new JLabel(" ");
		key[139] = new JLabel(" ");
		key[140] = new JLabel("1");
		key[141] = new JLabel("2");
		key[142] = new JLabel("3");
		key[143] = new JLabel("Enter");
	}
	
	// von 96 bis 119
	private void create5thRow(){
		key[96] = new JLabel("Caps");
		key[97] = new JLabel("Lock");
		key[98] = new JLabel("A");
		key[99] = new JLabel("S");
		key[100] = new JLabel("D");
		key[101] = new JLabel("F");
		key[102] = new JLabel("G");
		key[103] = new JLabel("H");
		key[104] = new JLabel("J");
		key[105] = new JLabel("K");
		key[106] = new JLabel("L");
		key[107] = new JLabel("Ç");
		key[108] = new JLabel("~");
		key[109] = new JLabel("]");
		//1x für Enter| 5x leere
		for(int i = 110; i < 116; i++){
			key[i] = new JLabel(" ");
		}
		key[116] = new JLabel("4");
		key[117] = new JLabel("5");
		key[118] = new JLabel("6");
		key[119] = new JLabel(".");
	}
	
	//von 72 bis 95
	private void create4thRow(){
		key[72] = new JLabel("Tab");
		key[73] = new JLabel("Q");
		key[74] = new JLabel("W");
		key[75] = new JLabel("E");
		key[76] = new JLabel("R");
		key[77] = new JLabel("T");
		key[78] = new JLabel("Y");
		key[79] = new JLabel("U");
		key[80] = new JLabel("I");
		key[81] = new JLabel("O");
		key[82] = new JLabel("P");
		key[83] = new JLabel("´");
		key[84] = new JLabel("[");
		key[85] = new JLabel("Ent");
		key[86] = new JLabel("er");
		key[87] = new JLabel(" ");
		key[88] = new JLabel("Del");
		key[89] = new JLabel("End");
		key[90] = new JLabel("<html>Page<br>Down</html>");
		key[91] = new JLabel(" ");
		key[92] = new JLabel("7");
		key[93] = new JLabel("8");
		key[94] = new JLabel("9");
		key[95] = new JLabel("+");
	}
	
	//von 48 bis 71
	private void create3rdRow(){
		key[48] = new JLabel("'");
		int number = 1;
		for(int i = 49; i < 59; i++){
			key[i] = new JLabel("" + number%10);
			number++;
		}
		key[59] = new JLabel("-");
		key[60] = new JLabel("=");
		key[61] = new JLabel("Back");
		key[62] = new JLabel("Space");
		key[63] = new JLabel(" ");
		key[64] = new JLabel("Insert");
		key[65] = new JLabel("Home");
		key[66] = new JLabel("<html>Page<br>Up</html>");
		key[67] = new JLabel(" ");
		key[68] = new JLabel("Num");
		key[69] = new JLabel("/");
		key[70] = new JLabel("*");
		key[71] = new JLabel("-");
	}
	
	//von 24 bis 47
	private void create2ndEmptyRow(){
		for(int i = 24; i < 48; i++){
			key[i] = new JLabel(" ");
		}
	}
	// von 0 bis 23
	private void createTopRow(){
		key[0] = new JLabel("ESC");
		key[1] = new JLabel(" ");
		key[2] = new JLabel("F1");
		key[3] = new JLabel("F2");
		key[4] = new JLabel("F3");
		key[5] = new JLabel("F4");
		key[6] = new JLabel(" ");
		key[7] = new JLabel("F5");
		key[8] = new JLabel("F6");
		key[9] = new JLabel("F7");
		key[10] = new JLabel("F8");
		key[11] = new JLabel(" ");
		key[12] = new JLabel("F9");
		key[13] = new JLabel("F10");
		key[14] = new JLabel("F11");
		key[15] = new JLabel("F12");
		key[16] = new JLabel(" ");
		key[17] = new JLabel("<html>Print<br>Screen</html>");
		key[18] = new JLabel("Scroll");
		key[19] = new JLabel("Pause");
		for(int l = 20; l < 24;l++){
			key[l] = new JLabel(" ");
		}
	}
}

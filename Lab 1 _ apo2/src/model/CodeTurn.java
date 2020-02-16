package model;

public class CodeTurn {
	
	private int num ;
	private char letter ;
	private String code;
	
	public CodeTurn(int num, char letter) {
		
		this.setLetter(letter);
		this.setNum(num);
		this.setCode(letter+num+"");
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	

}

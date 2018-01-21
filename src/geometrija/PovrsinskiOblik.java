package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik {
	private String strBojaUnutrasnjosti = "bela";
	private Color clrBojaUnutrasnjosti = Color.WHITE;
	
	public abstract void popuni(Graphics g);

	public String getStrBojaUnutrasnjosti() {
		return strBojaUnutrasnjosti;
	}

	public void setStrBojaUnutrasnjosti(String strBojaUnutrasnjosti) {
		this.strBojaUnutrasnjosti = strBojaUnutrasnjosti;
	}

	public Color getClrBojaUnutrasnjosti() {
		return clrBojaUnutrasnjosti;
	}

	public void setClrBojaUnutrasnjosti(Color clrBojaUnutrasnjosti) {
		this.clrBojaUnutrasnjosti = clrBojaUnutrasnjosti;
	}

	
	
	


}

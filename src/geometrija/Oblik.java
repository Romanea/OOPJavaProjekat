package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Comparable<Object>{
	private String strBoja = "crna";
	private Color bojaIvice = Color.BLACK; 
	private boolean selektovan;
	
	public Oblik() {
		
	}
	public Oblik(String boja){
		this.strBoja = boja;
	}
	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);
	
	
	
	public String getBoja() {
		return strBoja;
	}

	public void setBoja(String boja) {
		this.strBoja = boja;
	}
	public boolean isSelektovan() {
		return selektovan;
	}
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
	public Color getBojaIvice() {
		return bojaIvice;
	}
	public void setBojaIvice(Color bojaIvice) {
		this.bojaIvice = bojaIvice;
	}
	
	
}

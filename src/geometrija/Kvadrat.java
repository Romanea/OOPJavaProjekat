package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik implements Pomerljiv{
	protected Tacka goreLevo;
	protected int duzinaStranice;
	

	public Kvadrat() {

	}

	public Kvadrat(Tacka goreLevo, int duzinaStranice) {
		this.goreLevo = goreLevo;
		this.duzinaStranice = duzinaStranice;
	}

	public Kvadrat(Tacka goreLevo, int duzinaStranice, String boja) {
		this(goreLevo, duzinaStranice);
		setBoja(boja);
	}
	public Kvadrat(Tacka goreLevo, int duzinaStranice, Color bojaIvice, Color bojaUnutrasnjosti) {
		this(goreLevo, duzinaStranice);
		setBojaIvice(bojaIvice);
		setClrBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	public Kvadrat(Tacka goreLevo, int duzinaStranice, String bojaIvice, String bojaUnutrasnjosti) {
		this(goreLevo, duzinaStranice);
		setBoja(bojaIvice);
		setStrBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + duzinaStranice,goreLevo.getY() + duzinaStranice));
	}

	public Tacka centar(){
		return dijagonala().sredinaLinije();
	}
	public String toString() {
		return "gornji levi ugao = (" + goreLevo.getX() + ", " + goreLevo.getY() + "), stranica = " + duzinaStranice;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Kvadrat) {
			Kvadrat pomocni = (Kvadrat) obj;
			if (this.goreLevo.equals(pomocni.goreLevo) && this.duzinaStranice == pomocni.duzinaStranice)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public void pomeriNa(int x, int y) {
		goreLevo.setX(x);
		goreLevo.setY(y);
	}

	public void pomeriZa(int x, int y) {
		goreLevo.setX(goreLevo.getX() + x);
		goreLevo.setY(goreLevo.getY() + y);
	}

	public int obim() {
		return 4*duzinaStranice;
	}

	public int povrsina() {
		return duzinaStranice * duzinaStranice;
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + duzinaStranice)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + duzinaStranice))
			return true;
		else 
			return false;
	}
	public void selektovan(Graphics g) {
		
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice), dijagonala().gettKrajnja()).selektovan(g);

	}
	public void crtajSe(Graphics g){
		g.setColor(getBojaIvice());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, duzinaStranice);
		this.popuni(g);
		if(isSelektovan()) selektovan(g);
	}
	public void popuni(Graphics g){
		g.setColor(getClrBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, duzinaStranice-1);
	}
	public int compareTo(Object o) {
		if(o instanceof Kvadrat){
			Kvadrat pomocni  = (Kvadrat) o;
			return this.povrsina() - pomocni.povrsina();
		}
		else 
			return 0;
	}
	public Tacka getGoreLevo() {
		return goreLevo;
	}

	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}

	public void setDuzinaStranica(int duzinaStranica) {
		this.duzinaStranice = duzinaStranica;
	}

}

package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat{
	private int sirina;

	public Pravougaonik(){

	}
	public Pravougaonik(Tacka goreLevo, int visina, int sirina){
		super(goreLevo, visina);
		this.sirina = sirina;
	}
	public Pravougaonik(Tacka goreLevo, int visina, int sirina, String boja){
		this(goreLevo, visina, sirina);
		setBoja(boja);
	}
	
	public Pravougaonik(Tacka goreLevo, int visina, int sirina, Color bojaIvice, Color bojaUnutrasnjosti){
		this(goreLevo, visina, sirina);
		setBojaIvice(bojaIvice);
		setClrBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	
	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + getDuzinaStranice(),goreLevo.getY() + sirina));
	}
	public Tacka centar(){
		return dijagonala().sredinaLinije();
	}
	public boolean equals(Object obj){
		if(obj instanceof Pravougaonik){
			Pravougaonik pomocni=(Pravougaonik) obj;
			if(this.goreLevo.equals(pomocni.goreLevo) && this.sirina==pomocni.sirina && this.getDuzinaStranice()==pomocni.getDuzinaStranice())
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public String toString(){
		return "Gornji levi ugao="+goreLevo+",sirina="+sirina+",getDuzinaStranica()="+getDuzinaStranice();
	}

	public int obim(){
		return 2 * (sirina + getDuzinaStranice());
	}
	public int povrsina(){
		return sirina * getDuzinaStranice();
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + sirina)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + duzinaStranice))
			return true;
		else 
			return false;
	}
	public void selektovan(Graphics g) {
		
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+sirina)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+sirina), dijagonala().gettKrajnja()).selektovan(g);
	}
	public void crtajSe(Graphics g){
		g.setColor(getBojaIvice());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), sirina, duzinaStranice);
		this.popuni(g);
		if(isSelektovan())
			selektovan(g);
	}
	public void popuni(Graphics g){
		g.setColor(getClrBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, sirina-1,  duzinaStranice-1);
		
	}

	public int getSirina() {
		return sirina;
	}


	public void setSirina(int sirina) {
		this.sirina = sirina;
	}



}

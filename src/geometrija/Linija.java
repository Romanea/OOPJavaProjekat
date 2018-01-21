package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik{
	private Tacka tPocetna;
	private Tacka tKrajnja;


	public Linija()
	{

	}
	public Linija(Tacka tPocetna, Tacka tKrajnja)
	{
		this.tPocetna = tPocetna;
		this.tKrajnja = tKrajnja;
	}
	public Linija(Tacka tPocetna, Tacka tKrajnja,String boja)
	{
	
		this(tPocetna, tKrajnja);
		setBoja(boja);

	}
	
	public Linija(Tacka tPocetna, Tacka tKrajnja,Color boja)
	{
	
		this(tPocetna, tKrajnja);
		setBojaIvice(boja);

	}
	
	public Tacka sredinaLinije()
	{
		
		return new Tacka((tPocetna.getX() + tKrajnja.getX()) / 2, (tPocetna.getY() + tKrajnja.getY()) / 2);
	}
	
	public String toString()
	{
		return "("+tPocetna.getX()+"," +tPocetna.getY()+") --> (" + tKrajnja.getX()+","+ tKrajnja.getY() + ")";
	}

	public boolean equals(Object obj)
	{
		if(obj instanceof Linija){
			Linija pomocna=(Linija)obj;
			if(this.tPocetna.equals(pomocna.tPocetna) && this.tKrajnja.equals(pomocna.tKrajnja))
				return true;
			else
				return false;
		}
		else
			return false;
	}


	public double duzina()
	{
		return tPocetna.udaljenost(tKrajnja);
	}

	public void pomeriZa(int x, int y)
	{
		tPocetna.setX(tPocetna.getX()+x);
		tPocetna.setY(tPocetna.getY()+y);
		tKrajnja.setX(tKrajnja.getX()+x);
		tKrajnja.setY(tKrajnja.getY()+y);
	}
	public boolean sadrzi(int x, int y)
	{
		Tacka mestoKlika = new Tacka(x, y);
		if(mestoKlika.udaljenost(tPocetna)+mestoKlika.udaljenost(tKrajnja)-this.duzina()<=0.5)
			return true;
		 else 
			return false;		
	}
	public void selektovan(Graphics g)
	{
		g.setColor(Color.BLUE);
		tPocetna.selektovan(g);
		tKrajnja.selektovan(g);
		sredinaLinije().selektovan(g);
	}
	public void crtajSe(Graphics g)
	{
		g.setColor(getBojaIvice());
		g.drawLine(tPocetna.getX(), tPocetna.getY(), tKrajnja.getX(), tKrajnja.getY());
		if(isSelektovan())
			selektovan(g);
	}

	public int compareTo(Object o)
	{
		if(o instanceof Linija){
			Linija pomocna = (Linija) o;
			return (int)this.duzina() - (int)pomocna.duzina();
		}
		else
			return 0;
	}
	public Tacka gettPocetna(){
		return tPocetna;
	}
	public Tacka gettKrajnja(){
		return tKrajnja;
	}
	public void settPocetna(Tacka tPocetna){
		this.tPocetna = tPocetna;
	}
	public void settKrajnja(Tacka tKrajnja){
		this.tKrajnja = tKrajnja;
	}


}

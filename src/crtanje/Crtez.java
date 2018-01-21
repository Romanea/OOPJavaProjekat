package crtanje;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import geometrija.Oblik;

public class Crtez extends JPanel{

	private static final long serialVersionUID = 1L;

	protected static Color pBojaIvice;

	Stack<Oblik> stkOblici = new Stack<Oblik>();
	
	public static Oblik tmpOblik;
	
	public Crtez(){
		
		setBorder(new LineBorder(Color.BLACK, 2));
		setBackground(Color.WHITE);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		if(tmpOblik!=null){
				stkOblici.push(tmpOblik);
				tmpOblik = null;
				
		}
		for(Oblik o :stkOblici){
			o.crtajSe(arg0);
		}
		
	}
	
	public Oblik getTmpOblik() {
		return tmpOblik;
	}
	
	public void setTmpOblik(Oblik o) {
		tmpOblik = o;
	}
	
}
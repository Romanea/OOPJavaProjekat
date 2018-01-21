package crtanje;

import java.awt.EventQueue;
import geometrija.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crtanje.ColorChooserButton.ColorChangedListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Component;

public class GlavniProzorCrtanje extends JFrame {



	
	private static final long serialVersionUID = 1L;
	protected static JLabel lblUputstvoKoriscenja;
	private JPanel contentPane;
	private ColorChooserButton btnIzborBojeivice;
	private ColorChooserButton btnIzborBojeUnutrasnjosti;
	private JComboBox<String> cmbOdabirOblika;
	public static Color pBojaIvice = Color.BLACK;
	public static Color pBojaUnutrasnjosti = Color.WHITE;
	private Tacka pocetnaTackaLinije;
	private boolean isLinija = false;
	static Crtez pnlCrtez = new Crtez();
	private static Oblik selektovanOblik;
	private JToggleButton tglbtnSelekcija;
	JButton btnModifikuj;
	JButton btnObrisi;
	JButton btnObrisiSve;
	public static Object syncObject = new Object();
	public JLabel lblObavestenje;
	
	
	


	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzorCrtanje frame = new GlavniProzorCrtanje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GlavniProzorCrtanje() {
		
		setTitle("IT20-2015 Romanic Andrea");
		init();
		events();
	}
	
	
	  //////////////////////////////
	 //inicijalizacija komponenti//
	//////////////////////////////
	public void init()
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 541);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		pnlCrtez.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		pnlCrtez.setForeground(Color.DARK_GRAY);
		pnlCrtez.setBackground(Color.WHITE);
		
		// combo box za odabir oblika
		JLabel lblIzaberiteOblik = new JLabel("Izaberite oblik:");
		lblIzaberiteOblik.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cmbOdabirOblika = new JComboBox<String>();
		cmbOdabirOblika.setModel(new DefaultComboBoxModel<String>(new String[] {"Tacka", "Linija", "Krug", "Kvadrat", "Pravougaonik"}));
		
		// JLabel za odabir boja ivice i un
		JLabel lblIzaberiteBojuIvice = new JLabel("Izaberite boju ivice:");
		lblIzaberiteBojuIvice.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnIzborBojeivice = new ColorChooserButton(Color.BLACK);
		JLabel lblIzaberiteBojuUnutrasnjosti = new JLabel("Izaberite boju unutrasnjosti:");
		lblIzaberiteBojuUnutrasnjosti.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnIzborBojeUnutrasnjosti = new ColorChooserButton(Color.WHITE);
		btnIzborBojeUnutrasnjosti.setEnabled(false);
		
		// opcije levo
		tglbtnSelekcija = new JToggleButton("Selekcija");
		btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.setEnabled(false);
		btnObrisi = new JButton("Obrisi");
		btnObrisi.setEnabled(false);
		btnObrisiSve = new JButton("Obrisi sve");
		
		lblObavestenje = new JLabel("");
		lblObavestenje.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblObavestenje.setBackground(Color.LIGHT_GRAY);
		lblObavestenje.setText("Mod: Crtanje");
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblObavestenje, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
						.addComponent(btnModifikuj, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
						.addComponent(tglbtnSelekcija, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
						.addComponent(btnObrisi, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
						.addComponent(btnObrisiSve, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIzaberiteOblik, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbOdabirOblika, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(lblIzaberiteBojuIvice)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnIzborBojeivice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(lblIzaberiteBojuUnutrasnjosti)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnIzborBojeUnutrasnjosti, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(pnlCrtez, GroupLayout.PREFERRED_SIZE, 735, GroupLayout.PREFERRED_SIZE)
							.addGap(22))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblIzaberiteBojuUnutrasnjosti)
							.addComponent(lblIzaberiteBojuIvice)
							.addComponent(lblIzaberiteOblik, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
							.addComponent(cmbOdabirOblika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnIzborBojeUnutrasnjosti, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(btnIzborBojeivice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tglbtnSelekcija)
							.addGap(18)
							.addComponent(lblObavestenje, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnModifikuj)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnObrisi)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnObrisiSve))
						.addComponent(pnlCrtez, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		contentPane.setLayout(gl_contentPane);
	}

	
	  /////////////////////////
	 //deklaracija dogadjaja//
	/////////////////////////
	public void events()
	{
		tglbtnSelekcija.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				
				if( ie.getStateChange() == ItemEvent.SELECTED)
				{
					lblObavestenje.setText("Mod: Selekcija");
					btnObrisiSve.setEnabled(false);
						pnlCrtez.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent arg0) {
								if(pnlCrtez.stkOblici.isEmpty() && tglbtnSelekcija.isSelected())
								{
									JOptionPane.showMessageDialog(null, "Nema elemenata za selekciju na crtezu!");
									tglbtnSelekcija.setSelected(false);
								}
								else
								{
								deselekcija();
								for(int i = pnlCrtez.stkOblici.size()-1;i>=0;i--)
								{
									if(pnlCrtez.stkOblici.get(i).sadrzi(arg0.getX(), arg0.getY()) && tglbtnSelekcija.isSelected())
									{
										pnlCrtez.stkOblici.get(i).setSelektovan(true);
										setSelektovanOblik(pnlCrtez.stkOblici.get(i));
										btnModifikuj.setEnabled(true);
										btnObrisi.setEnabled(true);
										repaint();
										break;
									}
								}
								
							}
							}
						});
							
						
					}
				else if( ie.getStateChange() == ItemEvent.DESELECTED)
				{
					lblObavestenje.setText("Mod: Crtanje");
					btnObrisiSve.setEnabled(true);
					deselekcija();
					btnModifikuj.setEnabled(false);
					btnObrisi.setEnabled(false);
					repaint();
					
				}
				
			}
		});
		
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = pnlCrtez.stkOblici.size()-1;i>=0;i--)
					if(pnlCrtez.stkOblici.get(i).equals(selektovanOblik))
					{
						// TODO modifikacija tacke i linije
						// !!! provera pravougaonika pre kvadrata
						if(selektovanOblik instanceof Tacka)
						{
							ModifikovanjeTacke modifikuj = new ModifikovanjeTacke();
							modifikuj.setVisible(true);
						}
						else if(selektovanOblik instanceof Linija)
						{
							ModifikovanjeLinije modifikuj = new ModifikovanjeLinije();
							modifikuj.setVisible(true);
						}
						else if(selektovanOblik instanceof Krug)
						{
							ModifikovanjeKruga modifikuj = new ModifikovanjeKruga();
							modifikuj.setVisible(true);
						}
						else if(selektovanOblik instanceof Pravougaonik)
						{
							ModifikovanjePravougaonika modifikuj = new ModifikovanjePravougaonika();
							modifikuj.setVisible(true);
						}
						else if(selektovanOblik instanceof Kvadrat)
						{
							ModifikovanjeKvadrata modifikuj = new ModifikovanjeKvadrata();
							modifikuj.setVisible(true);
						}
						
						btnModifikuj.setEnabled(false);
						btnObrisi.setEnabled(false);
						break;
					}
				}
		});
		
		
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlCrtez.stkOblici.remove(selektovanOblik);
				btnModifikuj.setEnabled(false);
				btnObrisi.setEnabled(false);
				repaint();
			}
		});
		
		btnObrisiSve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlCrtez.stkOblici.removeAllElements();
				repaint();
			}
		});
		
		cmbOdabirOblika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cmbOdabirOblika.getSelectedItem().toString() == "Tacka" || cmbOdabirOblika.getSelectedItem().toString()== "Linija")
					btnIzborBojeUnutrasnjosti.setEnabled(false);
				else
					btnIzborBojeUnutrasnjosti.setEnabled(true);
			}
		});
		btnIzborBojeivice.addColorChangedListener(new ColorChangedListener() {
			@Override
		    public void colorChanged(Color newColor) {
		            pBojaIvice = newColor;
		    }
		});
		
		btnIzborBojeUnutrasnjosti.addColorChangedListener(new ColorChangedListener() {
			@Override
		    public void colorChanged(Color newColor) {
		            pBojaUnutrasnjosti = newColor;
		    }
		});
		
		pnlCrtez.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				//mod crtanje
				if(!tglbtnSelekcija.isSelected())
				{
				switch(cmbOdabirOblika.getSelectedItem().toString()){
				case "Tacka":
				{
					pnlCrtez.setTmpOblik(new Tacka(arg0.getX(),arg0.getY(),pBojaIvice));
			       repaint();
					break;
				}
				case "Linija": 
				{
					if(!isLinija)
					{
						JOptionPane.showMessageDialog(null, "Izabrali ste pocetnu tacku linije. Izaberite krajnju tacku.");
						pocetnaTackaLinije= new Tacka(arg0.getX(),arg0.getY());
						isLinija = true;
					} 
					else if(isLinija)
					{
						
						pnlCrtez.setTmpOblik(new Linija(pocetnaTackaLinije, new Tacka(arg0.getX(),arg0.getY()), pBojaIvice));
						repaint();
						isLinija = false;
					}
					break;
				}
				
				case "Krug":
				{
				
					CrtanjeKruga nacrtaj = new CrtanjeKruga(new Tacka(arg0.getX(),arg0.getY()));
					nacrtaj.setVisible(true);
					
					break;
				}
				
				case "Kvadrat":
				{
					
					CrtanjeKvadrata nacrtaj = new CrtanjeKvadrata(new Tacka(arg0.getX(),arg0.getY()));
					nacrtaj.setVisible(true);
					
					break;
				}
				
				case "Pravougaonik":
				{
					
					CrtanjePravougaonika nacrtaj = new CrtanjePravougaonika(new Tacka(arg0.getX(),arg0.getY()));
					nacrtaj.setVisible(true);
				
					break;
				}
				
				}
			}
			
				
		}
			});
		
	}


public static void deselekcija()
{
	for(Oblik o: pnlCrtez.stkOblici)
		if(o.isSelektovan()) o.setSelektovan(false);
	
}
public static Oblik getSelektovanOblik() {
	return selektovanOblik;
}
public static void setSelektovanOblik(Oblik selektovanOblik) {
	GlavniProzorCrtanje.selektovanOblik = selektovanOblik;
}
}

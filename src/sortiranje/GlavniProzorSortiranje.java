package sortiranje;

import java.awt.EventQueue;
import geometrija.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;

public class GlavniProzorSortiranje extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDodajKvadrat;
	private static JList<Kvadrat> lstIspis;
	private static DefaultListModel<Kvadrat> mdl = new DefaultListModel<>();
	private JButton btnIzbaciKvadrat;
	private Kvadrat selektovan = new Kvadrat();

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzorSortiranje frame = new GlavniProzorSortiranje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	
	public GlavniProzorSortiranje() 
	{
		
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
		setBounds(100, 100, 453, 337);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnDodajKvadrat = new JButton("Dodaj kvadrat");
		
		JScrollPane scrolllstIspis = new JScrollPane();
		
		btnIzbaciKvadrat = new JButton("Izbaci kvadrat");
		
		btnIzbaciKvadrat.setVisible(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrolllstIspis, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDodajKvadrat)
						.addComponent(btnIzbaciKvadrat))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrolllstIspis, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnIzbaciKvadrat)
							.addGap(18)
							.addComponent(btnDodajKvadrat)))
					.addContainerGap())
		);
		
		lstIspis = new JList<Kvadrat>();
		
		scrolllstIspis.setViewportView(lstIspis);
		lstIspis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstIspis.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		lstIspis.setModel(mdl);
		contentPane.setLayout(gl_contentPane);}
	
	  /////////////////////////
	 //deklaracija dogadjaja//
	/////////////////////////
	public void events() 
	{
		btnDodajKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajKvadrat dodaj = new DodajKvadrat();
				dodaj.setModal(true);
				dodaj.setVisible(true);
			}
		});
		
		lstIspis.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnIzbaciKvadrat.setVisible(true);
				selektovan = lstIspis.getSelectedValue();
			}
			
		});
		
		btnIzbaciKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodajKvadrat.kvadrati.remove(selektovan);
				prikaziListu();
				btnIzbaciKvadrat.setVisible(false);
			}
		});
		
	}

	
	//ispis liste
	public static void prikaziListu()
	{
		
		if(!DodajKvadrat.kvadrati.isEmpty())
		{
			Collections.sort(DodajKvadrat.kvadrati, new Comparator<Kvadrat>(){
				@Override
				public int compare(Kvadrat k1, Kvadrat k2) 
				{
					return k1.povrsina() - k2.povrsina();
				}
			});
			
			mdl.removeAllElements();
			
			Iterator<Kvadrat> it = DodajKvadrat.kvadrati.iterator();
			while(it.hasNext()) mdl.addElement(it.next());
			
		}
		
		else
			mdl.removeAllElements();
		
		
		
	}
}





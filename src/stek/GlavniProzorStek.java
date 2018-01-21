package stek;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class GlavniProzorStek extends JFrame {

	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	public static JTextArea txtPrikazSteka;
	private JButton btnDodajKvadrat;
	private JButton btnIzuzmiKvadrat;
	
	

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzorStek frame = new GlavniProzorStek();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GlavniProzorStek()
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
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnDodajKvadrat = new JButton("Dodaj kvadrat");
		
		
		btnIzuzmiKvadrat = new JButton("Izuzmi kvadrat");
	
			
		JScrollPane scrPrikazSteka = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrPrikazSteka, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnDodajKvadrat, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addGap(104)
							.addComponent(btnIzuzmiKvadrat, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrPrikazSteka, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDodajKvadrat)
						.addComponent(btnIzuzmiKvadrat))
					.addContainerGap())
		);
		
		txtPrikazSteka = new JTextArea();
		txtPrikazSteka.setEditable(false);
		scrPrikazSteka.setViewportView(txtPrikazSteka);
		contentPane.setLayout(gl_contentPane);
	}
	
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
		
		btnIzuzmiKvadrat.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!DodajKvadrat.stekKvadrata.isEmpty())
			{
			IzuzmiKvadrat izuzmi = new IzuzmiKvadrat();
			izuzmi.setModal(true);
			izuzmi.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(null, "Stek je prazan!");
		}
	});
	
	}


}

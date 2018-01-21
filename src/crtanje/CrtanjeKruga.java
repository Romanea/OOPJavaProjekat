package crtanje;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.*;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrtanjeKruga extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblPoluprecnik;
	private JTextField txtPoluprecnik;

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			CrtanjeKruga dialog = new CrtanjeKruga(new Tacka(0,0));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public CrtanjeKruga(Tacka tackaKlika) {
		setResizable(false);
		setBounds(100, 100, 330, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblPoluprecnik = new JLabel("Unesite poluprecnik kruga:");
		}
		
		txtPoluprecnik = new JTextField();
		txtPoluprecnik.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPoluprecnik)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPoluprecnik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPoluprecnik)
						.addComponent(txtPoluprecnik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton  btnNacrtaj = new JButton("OK");
				btnNacrtaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							if(Integer.parseInt(txtPoluprecnik.getText())>0)
							{
							Crtez.tmpOblik = new Krug(tackaKlika, Integer.parseInt(txtPoluprecnik.getText()), 
							GlavniProzorCrtanje.pBojaIvice, GlavniProzorCrtanje.pBojaUnutrasnjosti);
							GlavniProzorCrtanje.pnlCrtez.repaint();
							dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Duzina poluprecnika mora biti pozitivan broj!");
								
						} catch (NumberFormatException e2) {
							
							JOptionPane.showMessageDialog(null, "Duzina poluprecnika mora biti celobrojna vrednost!");
						}
						
					}
					
				});
				btnNacrtaj.setActionCommand("OK");
				buttonPane.add(btnNacrtaj);
				getRootPane().setDefaultButton(btnNacrtaj);
			}
			{
				JButton btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnOdustani.setActionCommand("Odustani");
				buttonPane.add(btnOdustani);
			}
		}
	}
}

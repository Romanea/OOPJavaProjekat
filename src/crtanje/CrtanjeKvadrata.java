package crtanje;

import geometrija.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrtanjeKvadrata extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtStranicaKvadrata;

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			CrtanjeKvadrata dialog = new CrtanjeKvadrata(new Tacka(0,0));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public CrtanjeKvadrata(Tacka tackaKlika) {
		setResizable(false);
		setBounds(100, 100, 329, 143);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblStranicaKvadrata = new JLabel("Unesite stranicu kvadrata:");

		txtStranicaKvadrata = new JTextField();
		txtStranicaKvadrata.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(contentPanel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblStranicaKvadrata)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtStranicaKvadrata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStranicaKvadrata)
						.addComponent(txtStranicaKvadrata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		contentPanel.setLayout(groupLayout);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNacrtaj = new JButton("OK");
				btnNacrtaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(Integer.parseInt(txtStranicaKvadrata.getText())>0)
							{
								Crtez.tmpOblik = new Kvadrat(tackaKlika, Integer.parseInt(txtStranicaKvadrata.getText()), 
								GlavniProzorCrtanje.pBojaIvice, GlavniProzorCrtanje.pBojaUnutrasnjosti);
								GlavniProzorCrtanje.pnlCrtez.repaint();
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Duzina stranice mora biti pozitivan broj!");
								
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Duzina stranice mora biti celobrojna vrednost!");
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

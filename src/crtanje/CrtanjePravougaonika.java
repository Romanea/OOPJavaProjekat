package crtanje;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import geometrija.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrtanjePravougaonika extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtVisina;
	private JTextField txtDuzina;

	
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			CrtanjePravougaonika dialog = new CrtanjePravougaonika(new Tacka(0,0));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	
	public CrtanjePravougaonika(Tacka tackaKlika) {
		setResizable(false);
		setBounds(100, 100, 378, 203);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblVisina = new JLabel("Unesite visinu pravougaonika:");
		JLabel lblDuzina = new JLabel("Unesite duzinu pravougaonika:");
		txtVisina = new JTextField();
		txtVisina.setText("");
		txtVisina.setColumns(10);
		txtDuzina = new JTextField();
		txtDuzina.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVisina)
						.addComponent(lblDuzina))
					.addGap(24)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDuzina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtVisina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVisina)
						.addComponent(txtVisina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuzina)
						.addComponent(txtDuzina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNacrtaj = new JButton("OK");
				btnNacrtaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(Integer.parseInt(txtVisina.getText())>0 
									&& Integer.parseInt(txtDuzina.getText())>0 )
							{
							Crtez.tmpOblik = new Pravougaonik(tackaKlika, Integer.parseInt(txtVisina.getText()), Integer.parseInt(txtDuzina.getText()),
							GlavniProzorCrtanje.pBojaIvice, GlavniProzorCrtanje.pBojaUnutrasnjosti);
							GlavniProzorCrtanje.pnlCrtez.repaint();
							dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Duzine stranica moraju biti pozitivni brojevi!");
								
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Duzine stranica moraju biti celobrojne vrednosti!");
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

package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import crtanje.ColorChooserButton.ColorChangedListener;
import geometrija.Oblik;
import geometrija.*;

public class ModifikovanjeLinije extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Color cBojaIvice;
	private JTextField txtPocetnaX;
	private JTextField txtPocetnaY;
	private JTextField txtKrajnjaX;
	private JTextField txtKrajnjaY;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			ModifikovanjeTacke dialog = new ModifikovanjeTacke();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public ModifikovanjeLinije() {
		setTitle("Modifikovanje linije:");
		setResizable(false);
		setBounds(100, 100, 343, 293);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		JLabel lblBoja = new JLabel("Boja:");
		ColorChooserButton btnBojaIvice = new ColorChooserButton(((Linija)GlavniProzorCrtanje.getSelektovanOblik()).getBojaIvice());
		cBojaIvice=((Linija)GlavniProzorCrtanje.getSelektovanOblik()).getBojaIvice();
		btnBojaIvice.addColorChangedListener(new ColorChangedListener() {
			@Override
		    public void colorChanged(Color newColor) {
		            cBojaIvice = newColor;
		    }
		});
		
		JLabel lblPocetna = new JLabel("Pocetna tacka (x, y):");
		
		txtPocetnaX = new JTextField();
		txtPocetnaX.setText(Integer.toString(((Linija)GlavniProzorCrtanje.getSelektovanOblik()).gettPocetna().getX()));
		txtPocetnaX.setColumns(10);
		
		txtPocetnaY = new JTextField();
		txtPocetnaY.setText(Integer.toString(((Linija)GlavniProzorCrtanje.getSelektovanOblik()).gettPocetna().getY()));
		txtPocetnaY.setColumns(10);
		
		JLabel lblKrajnja = new JLabel("Krajnja tacka (x, y):");
		
		txtKrajnjaX = new JTextField();
		txtKrajnjaX.setText(Integer.toString(((Linija)GlavniProzorCrtanje.getSelektovanOblik()).gettKrajnja().getX()));
		txtKrajnjaX.setColumns(10);
		
		txtKrajnjaY = new JTextField();
		txtKrajnjaY.setText(Integer.toString(((Linija)GlavniProzorCrtanje.getSelektovanOblik()).gettKrajnja().getY()));
		txtKrajnjaY.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblKrajnja, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPocetna, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtKrajnjaX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocetnaX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtKrajnjaY, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPocetnaY, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblBoja)
							.addGap(18)
							.addComponent(btnBojaIvice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(80))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblBoja)
							.addGap(24))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnBojaIvice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPocetna)
						.addComponent(txtPocetnaX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPocetnaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKrajnja)
						.addComponent(txtKrajnjaX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtKrajnjaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("OK");
				btnPotvrdi.setActionCommand("OK");
				buttonPane.add(btnPotvrdi);
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						try {
							for(Oblik o: GlavniProzorCrtanje.pnlCrtez.stkOblici)
									if(o == GlavniProzorCrtanje.getSelektovanOblik())
									{
										
										((Linija)o).setBojaIvice(cBojaIvice);
										((Linija)o).settPocetna(new Tacka(Integer.parseInt(txtPocetnaX.getText()), Integer.parseInt(txtPocetnaY.getText())));
										((Linija)o).settKrajnja(new Tacka(Integer.parseInt(txtKrajnjaX.getText()), Integer.parseInt(txtKrajnjaY.getText())));
										 o.setSelektovan(false);
									}
							GlavniProzorCrtanje.pnlCrtez.repaint();
							dispose();
							
								
						} catch (NumberFormatException e2) {
							
							JOptionPane.showMessageDialog(null, "Vrednosti koordinata moraju biti celobrojne vrednosti!");
						}
						
					}
					
				});
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				JButton btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnOdustani.setActionCommand("Odustani");
				buttonPane.add(btnOdustani);
			}
		}
	}

}

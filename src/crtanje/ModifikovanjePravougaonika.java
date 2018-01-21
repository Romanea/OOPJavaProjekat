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
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import crtanje.ColorChooserButton.ColorChangedListener;
import geometrija.*;

import javax.swing.LayoutStyle.ComponentPlacement;

public class ModifikovanjePravougaonika extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDuzinaPravougaonika;
	protected Color cBojaUnutrasnjosti;
	protected Color cBojaIvice;
	private JTextField txtNaX;
	private JTextField txtNaY;
	private JTextField txtZaX;
	private JTextField txtZaY;
	private JTextField txtSirinaPravougaonika;


	public static void main(String[] args) {
		try {
			ModifikovanjePravougaonika dialog = new ModifikovanjePravougaonika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public ModifikovanjePravougaonika() {
		setTitle("Modifikovanje pravougaonika:");
	setResizable(false);
	setBounds(100, 100, 388, 324);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	
	JLabel lblDuzinaPravougaonika = new JLabel("Duzina pravougaonika:");
	
	txtDuzinaPravougaonika = new JTextField();
	txtDuzinaPravougaonika.setText(Integer.toString(((Pravougaonik)GlavniProzorCrtanje.getSelektovanOblik()).getDuzinaStranice()));
	txtDuzinaPravougaonika.setColumns(10);
	
	txtSirinaPravougaonika = new JTextField();
	txtSirinaPravougaonika.setText(Integer.toString(((Pravougaonik)GlavniProzorCrtanje.getSelektovanOblik()).getSirina()));
	txtSirinaPravougaonika.setColumns(10);
	
	JLabel lblBojaIvice = new JLabel("Boja ivice:");
	JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:");
	ColorChooserButton btnBojaIvice = new ColorChooserButton(((Pravougaonik)GlavniProzorCrtanje.getSelektovanOblik()).getBojaIvice());
	ColorChooserButton btnBojaUnutrasnjosti = new ColorChooserButton(((Pravougaonik)GlavniProzorCrtanje.getSelektovanOblik()).getClrBojaUnutrasnjosti());
	cBojaIvice=((Pravougaonik)GlavniProzorCrtanje.getSelektovanOblik()).getBojaIvice();
	cBojaUnutrasnjosti=((Pravougaonik)GlavniProzorCrtanje.getSelektovanOblik()).getClrBojaUnutrasnjosti();
	btnBojaIvice.addColorChangedListener(new ColorChangedListener() {
		

		@Override
	    public void colorChanged(Color newColor) {
	            cBojaIvice = newColor;
	    }
	});
	
	btnBojaUnutrasnjosti.addColorChangedListener(new ColorChangedListener() {
		@Override
	    public void colorChanged(Color newColor) {
	            cBojaUnutrasnjosti = newColor;
	    }
	});
	
	JLabel lblPomeriNa = new JLabel("Pomeri na (x, y):");
	
	txtNaX = new JTextField();
	txtNaX.setText(Integer.toString(((Pravougaonik)GlavniProzorCrtanje.getSelektovanOblik()).getGoreLevo().getX()));
	txtNaX.setColumns(10);
	
	txtNaY = new JTextField();
	txtNaY.setText(Integer.toString(((Pravougaonik)GlavniProzorCrtanje.getSelektovanOblik()).getGoreLevo().getY()));
	txtNaY.setColumns(10);
	
	JLabel lblPomeriZa = new JLabel("Pomeri za (x, y):");
	
	txtZaX = new JTextField();
	txtZaX.setText("0");
	txtZaX.setColumns(10);
	
	txtZaY = new JTextField();
	txtZaY.setText("0");
	txtZaY.setColumns(10);
	
	JLabel lblSirinaPravougaonika = new JLabel("Sirina pravougaonika:");
	
	
	GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
	gl_contentPanel.setHorizontalGroup(
		gl_contentPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPanel.createSequentialGroup()
				.addGap(21)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(31)
						.addComponent(lblPomeriZa, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtZaX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(txtZaY, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPomeriNa)
										.addComponent(lblDuzinaPravougaonika)
										.addComponent(lblSirinaPravougaonika)))
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
									.addComponent(lblBojaIvice)
									.addGap(8)))
							.addComponent(lblBojaUnutrasnjosti))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(18)
								.addComponent(txtNaX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtNaY, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnBojaIvice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnBojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtDuzinaPravougaonika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtSirinaPravougaonika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(79)))
				.addContainerGap(112, Short.MAX_VALUE))
	);
	gl_contentPanel.setVerticalGroup(
		gl_contentPanel.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_contentPanel.createSequentialGroup()
				.addContainerGap(21, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDuzinaPravougaonika)
							.addComponent(txtDuzinaPravougaonika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSirinaPravougaonika)
							.addComponent(txtSirinaPravougaonika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(21)
						.addComponent(lblBojaIvice))
					.addComponent(btnBojaIvice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
					.addComponent(btnBojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblBojaUnutrasnjosti))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(3)
						.addComponent(lblPomeriNa))
					.addComponent(txtNaX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtNaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtZaX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPomeriZa))
					.addComponent(txtZaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(70))
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
						if(Integer.parseInt(txtDuzinaPravougaonika.getText())>0 && Integer.parseInt(txtSirinaPravougaonika.getText())>0)
						{
							for(Oblik o: GlavniProzorCrtanje.pnlCrtez.stkOblici)
								if(o == GlavniProzorCrtanje.getSelektovanOblik())
								{
									((Pravougaonik)o).setDuzinaStranica(Integer.parseInt(txtDuzinaPravougaonika.getText()));
									((Pravougaonik)o).setSirina(Integer.parseInt(txtSirinaPravougaonika.getText()));
									((Pravougaonik)o).setBojaIvice(cBojaIvice);
									((Pravougaonik)o).setClrBojaUnutrasnjosti(cBojaUnutrasnjosti);
									((Pravougaonik)o).pomeriNa(Integer.parseInt(txtNaX.getText()), Integer.parseInt(txtNaY.getText()));
									((Pravougaonik)o).pomeriZa(Integer.parseInt(txtZaX.getText()), Integer.parseInt(txtZaY.getText()));
									 o.setSelektovan(false);
								}
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

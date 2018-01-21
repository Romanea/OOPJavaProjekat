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
import geometrija.*;
import geometrija.Oblik;

public class ModifikovanjeTacke extends JDialog {


	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Color cBojaIvice;
	private JTextField txtNaX;
	private JTextField txtNaY;
	private JTextField txtZaX;
	private JTextField txtZaY;
	
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

	
	public ModifikovanjeTacke() {
		setTitle("Modifikovanje tacke:");
		setResizable(false);
		setBounds(100, 100, 343, 293);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		JLabel lblBoja = new JLabel("Boja:");
		ColorChooserButton btnBojaIvice = new ColorChooserButton(((Tacka)GlavniProzorCrtanje.getSelektovanOblik()).getBojaIvice());
		cBojaIvice=((Tacka)GlavniProzorCrtanje.getSelektovanOblik()).getBojaIvice();
		btnBojaIvice.addColorChangedListener(new ColorChangedListener() {
			@Override
		    public void colorChanged(Color newColor) {
		            cBojaIvice = newColor;
		    }
		});
		
		JLabel lblPomeriNa = new JLabel("Pomeri na (x, y):");
		
		txtNaX = new JTextField();
		txtNaX.setText(Integer.toString(((Tacka)GlavniProzorCrtanje.getSelektovanOblik()).getX()));
		txtNaX.setColumns(10);
		
		txtNaY = new JTextField();
		txtNaY.setText(Integer.toString(((Tacka)GlavniProzorCrtanje.getSelektovanOblik()).getY()));
		txtNaY.setColumns(10);
		
		JLabel lblPomeriZa = new JLabel("Pomeri za (x, y):");
		
		txtZaX = new JTextField();
		txtZaX.setText("0");
		txtZaX.setColumns(10);
		
		txtZaY = new JTextField();
		txtZaY.setText("0");
		txtZaY.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPomeriNa)
								.addComponent(lblPomeriZa, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtZaX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNaX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtZaY, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNaY, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(lblPomeriNa)
						.addComponent(txtNaX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPomeriZa)
						.addComponent(txtZaX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtZaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(8, Short.MAX_VALUE))
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
										
										((Tacka)o).setBojaIvice(cBojaIvice);
										((Tacka)o).pomeriNa(Integer.parseInt(txtNaX.getText()), Integer.parseInt(txtNaY.getText()));
										((Tacka)o).pomeriZa(Integer.parseInt(txtZaX.getText()), Integer.parseInt(txtZaY.getText()));
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
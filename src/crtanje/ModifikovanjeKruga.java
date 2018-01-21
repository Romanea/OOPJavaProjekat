package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crtanje.ColorChooserButton.ColorChangedListener;
import geometrija.Krug;
import geometrija.Oblik;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifikovanjeKruga extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPoluprecnikKruga;
	private Color cBojaIvice;
	private Color cBojaUnutrasnjosti;
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
			ModifikovanjeKruga dialog = new ModifikovanjeKruga();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public ModifikovanjeKruga() {
		setTitle("Modifikovanje kruga:");
		setResizable(false);
		setBounds(100, 100, 451, 301);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblPoluprecnikKruga = new JLabel("Poluprecnik kruga:");
		
		txtPoluprecnikKruga = new JTextField();
		txtPoluprecnikKruga.setText(Integer.toString(((Krug)GlavniProzorCrtanje.getSelektovanOblik()).getR()));
		txtPoluprecnikKruga.setColumns(10);
		
		
		JLabel lblBojaIvice = new JLabel("Boja ivice:");
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:");
		ColorChooserButton btnBojaIvice = new ColorChooserButton(((Krug)GlavniProzorCrtanje.getSelektovanOblik()).getBojaIvice());
		ColorChooserButton btnBojaUnutrasnjosti = new ColorChooserButton(((Krug)GlavniProzorCrtanje.getSelektovanOblik()).getClrBojaUnutrasnjosti());
		cBojaIvice=((Krug)GlavniProzorCrtanje.getSelektovanOblik()).getBojaIvice();
		cBojaUnutrasnjosti=((Krug)GlavniProzorCrtanje.getSelektovanOblik()).getClrBojaUnutrasnjosti();
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
		txtNaX.setText(Integer.toString(((Krug)GlavniProzorCrtanje.getSelektovanOblik()).getCentar().getX()));
		txtNaX.setColumns(10);
		
		txtNaY = new JTextField();
		txtNaY.setText(Integer.toString(((Krug)GlavniProzorCrtanje.getSelektovanOblik()).getCentar().getY()));
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
					.addGap(35)
					.addComponent(lblPoluprecnikKruga)
					.addGap(18)
					.addComponent(txtPoluprecnikKruga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(82)
					.addComponent(lblBojaIvice)
					.addGap(18)
					.addComponent(btnBojaIvice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addComponent(lblBojaUnutrasnjosti)
					.addGap(18)
					.addComponent(btnBojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblPomeriZa, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtZaX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtZaY, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblPomeriNa)
							.addGap(18)
							.addComponent(txtNaX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtNaY, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblPoluprecnikKruga))
						.addComponent(txtPoluprecnikKruga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblBojaIvice))
						.addComponent(btnBojaIvice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblBojaUnutrasnjosti))
						.addComponent(btnBojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtNaX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPomeriNa))
						.addComponent(txtNaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtZaX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPomeriZa))
						.addComponent(txtZaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(114, Short.MAX_VALUE))
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
							if(Integer.parseInt(txtPoluprecnikKruga.getText())>0)
							{
								for(Oblik o: GlavniProzorCrtanje.pnlCrtez.stkOblici)
									if(o == GlavniProzorCrtanje.getSelektovanOblik())
									{
										((Krug)o).setR(Integer.parseInt(txtPoluprecnikKruga.getText()));
										((Krug)o).setBojaIvice(cBojaIvice);
										((Krug)o).setClrBojaUnutrasnjosti(cBojaUnutrasnjosti);
										((Krug)o).pomeriNa(Integer.parseInt(txtNaX.getText()), Integer.parseInt(txtNaY.getText()));
										((Krug)o).pomeriZa(Integer.parseInt(txtZaX.getText()), Integer.parseInt(txtZaY.getText()));
										 o.setSelektovan(false);
									}
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

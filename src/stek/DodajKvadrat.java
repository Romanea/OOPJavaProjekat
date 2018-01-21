package stek;

import geometrija.*;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class DodajKvadrat extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Komponente
	private final JPanel contentPanel = new JPanel();
	private JLabel lblUnosX;
	private JTextField txtUnosX;
	private JTextField txtUnosY;
	private JTextField txtUnosStranice;
	private JButton btnDodaj;
	private JComboBox<String> cmbIzborBojeIvice;
	private JComboBox<String> cmbIzborBojeUn;
	
	public static Stack<Kvadrat> stekKvadrata = new Stack<Kvadrat>();
	
	
	

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DodajKvadrat dialog = new DodajKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public DodajKvadrat() 
	{
		init();
		events();
	}
	
	 //////////////////////////////
	//inicijalizacija komponenti//
   //////////////////////////////
	public void init()
	{
		setResizable(false);
		setTitle("Dodaj kvadrat");
		setBounds(100, 100, 364, 367);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblUnosX = new JLabel("Unesite X koordinate ta\u010Dke gore levo:");
		}
		txtUnosX = new JTextField();
		txtUnosX.setColumns(10);
		
		JLabel lblUnosY = new JLabel("Unesite Y koordinate ta\u010Dke gore levo:");
		
		txtUnosY = new JTextField();
		txtUnosY.setColumns(10);
		
		JLabel lblUnosStranice = new JLabel("Unesite du\u017Einu stranice:");
		
		txtUnosStranice = new JTextField();
		txtUnosStranice.setColumns(10);
		
		JLabel lblIzborBojeIvice = new JLabel("Izaberite boju ivice:");
		
		JLabel lblIzborBojeUn = new JLabel("Izaberite boju unutra\u0161njosti:");
		
		cmbIzborBojeIvice = new JComboBox<String>();
		cmbIzborBojeIvice.setModel(new DefaultComboBoxModel<String>(new String[] {"crna", "bela", "plava", "crvena", "zelena", "zuta", "pink"}));
		
		cmbIzborBojeUn = new JComboBox<String>();
		cmbIzborBojeUn.setModel(new DefaultComboBoxModel<String>(new String[] {"crna", "bela", "plava", "crvena", "zelena", "zuta", "pink"}));
		
		btnDodaj = new JButton("Dodaj");
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblUnosX, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtUnosX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblUnosY)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addComponent(txtUnosY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUnosStranice)
								.addComponent(lblIzborBojeIvice)
								.addComponent(lblIzborBojeUn))
							.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnDodaj, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cmbIzborBojeUn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cmbIzborBojeIvice, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtUnosStranice))))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnosX, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUnosX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnosY)
						.addComponent(txtUnosY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUnosStranice)
						.addComponent(txtUnosStranice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIzborBojeIvice)
						.addComponent(cmbIzborBojeIvice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIzborBojeUn)
						.addComponent(cmbIzborBojeUn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(btnDodaj))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	
	
  /////////////////////////
 //deklaracija dogadjaja//
/////////////////////////
	public void events()
	{
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(Integer.parseInt(txtUnosStranice.getText())>0)
					{
						
						stekKvadrata.push(new Kvadrat(new Tacka(Integer.parseInt(txtUnosX.getText()),
								Integer.parseInt(txtUnosY.getText())), 
								Integer.parseInt(txtUnosStranice.getText()), 
								cmbIzborBojeIvice.getSelectedItem().toString(),
								cmbIzborBojeUn.getSelectedItem().toString() ));
						
						GlavniProzorStek.txtPrikazSteka.setText("");
						
						for (Kvadrat kvadrat : stekKvadrata) 
							GlavniProzorStek.txtPrikazSteka.append(kvadrat.toString()+"\n");
						
						
						JOptionPane.showMessageDialog(null, "Kvadrat je dodat!");
						dispose();
					}
					
					else
						JOptionPane.showMessageDialog(null, "Vrednost stranice mora biti veca od 0!");
					
				
					
				} catch (NumberFormatException e) {

					JOptionPane.showMessageDialog(null, "Koordinate i duzina stranice moraju biti celobrojne vrednosti!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Greska!");
					dispose();
				}
				
				
				
				
				
				
			}
		});
	}
}



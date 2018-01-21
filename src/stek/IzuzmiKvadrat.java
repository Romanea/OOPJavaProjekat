package stek;

import geometrija.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzuzmiKvadrat extends JDialog {
	

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//Komponente
		private final JPanel contentPanel = new JPanel();
		private JLabel lblX;
		private JTextField txtX;
		private JTextField txtY;
		private JTextField txtStranica;
		private JButton btnIzuzmi;
		private JTextField txtBojaIvice;
		private JTextField txtBojaUnutrasnjosti;
		private JButton btnOdustani;

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			IzuzmiKvadrat dialog = new IzuzmiKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public IzuzmiKvadrat() {
		init();
		
		if(!DodajKvadrat.stekKvadrata.isEmpty())
		{
			Kvadrat temp = DodajKvadrat.stekKvadrata.peek();
			txtX.setText( Integer.toString(temp.getGoreLevo().getX()));
			txtY.setText( Integer.toString(temp.getGoreLevo().getY()));
			txtStranica.setText(Integer.toString(temp.getDuzinaStranice()));
			txtBojaIvice.setText(temp.getBoja());
			txtBojaUnutrasnjosti.setText(temp.getStrBojaUnutrasnjosti());
		}
		
		events();
	}
	
	
   //////////////////////////////
  //inicijalizacija komponenti//
 //////////////////////////////
		public void init()
		{
			
			setTitle("Izuzmi kvadrat");
			setBounds(100, 100, 403, 408);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.NORTH);
			{
				lblX = new JLabel("X koordinate ta\u010Dke gore levo:");
			}
			txtX = new JTextField();
			txtX.setEditable(false);
			txtX.setColumns(10);
			
			
			
			JLabel lblY = new JLabel("Y koordinate ta\u010Dke gore levo:");
			
			txtY = new JTextField();
			txtY.setEditable(false);
			txtY.setColumns(10);
			
			
			JLabel lblStranica = new JLabel("Du\u017Eina stranice:");
			
			txtStranica = new JTextField();
			txtStranica.setEditable(false);
			txtStranica.setColumns(10);
			
			JLabel lblBojaIvice = new JLabel("Boja ivice:");
			
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutra\u0161njosti:");
			
			btnIzuzmi = new JButton("Izuzmi");
			
			
			txtBojaIvice = new JTextField();
			txtBojaIvice.setEditable(false);
			txtBojaIvice.setColumns(10);
			
			txtBojaUnutrasnjosti = new JTextField();
			txtBojaUnutrasnjosti.setEditable(false);
			txtBojaUnutrasnjosti.setColumns(10);
			
			JLabel lblPotvrda = new JLabel("Da li ste sigurni da \u017Eelite da \r\nizuzmete kvadrat sa steka?");
			lblPotvrda.setHorizontalTextPosition(SwingConstants.LEFT);
			lblPotvrda.setHorizontalAlignment(SwingConstants.LEFT);
			lblPotvrda.setVerticalTextPosition(SwingConstants.TOP);
			lblPotvrda.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			btnOdustani = new JButton("Odustani");
			
				
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblBojaUnutrasnjosti)
								.addPreferredGap(ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
								.addComponent(txtBojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblBojaIvice)
								.addPreferredGap(ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
								.addComponent(txtBojaIvice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblStranica)
								.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
								.addComponent(txtStranica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblY)
								.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
								.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblPotvrda)
							.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
								.addComponent(btnOdustani)
								.addGap(18)
								.addComponent(btnIzuzmi, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblPotvrda, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblY))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtStranica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblStranica))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtBojaIvice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblBojaIvice))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBojaUnutrasnjosti)
							.addComponent(txtBojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnIzuzmi)
							.addComponent(btnOdustani)))
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
			btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
			
			btnIzuzmi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajKvadrat.stekKvadrata.pop();
					
					GlavniProzorStek.txtPrikazSteka.setText("");
					for (Kvadrat kvadrat : DodajKvadrat.stekKvadrata) 
						GlavniProzorStek.txtPrikazSteka.append(kvadrat.toString()+"\n");
					
					JOptionPane.showMessageDialog(null, "Kvadrat je izuzet!");
					dispose();
				}
			});
			
			
		}
}

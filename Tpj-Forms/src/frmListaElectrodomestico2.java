import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Clases.*;
import Controlador.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
public class frmListaElectrodomestico2 extends JFrame {

	private JPanel contentPane;
	private ControladorElectrodomestico contElectrodomestico;
	private JTable tableEle;
	private JTextField txtMin;
	private JTextField txtMax;
	private JTable tableElectrodomestico;
	private JComboBox cmbConsumo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panelFiltros;
	
	
	
	public void modificarElectrodomestico()
	{
		int indexrow=this.tableElectrodomestico.getSelectedRow();
		if(indexrow==-1)
		{
			JOptionPane.showMessageDialog(null, "Debe seleccionar un electrodomestico");
		}
		else
		{
		int codEle=Integer.parseInt( this.tableElectrodomestico.getValueAt(indexrow, 0).toString());
		Electrodomestico ele= contElectrodomestico.getElectrodomestico(codEle);
		if(ele!=null)
		{
		final frmAMElectrodomestico2 frmAMele=new frmAMElectrodomestico2(ele);
		frmAMele.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		frmAMele.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			llenarjTable();
			frmAMele.setVisible(false);
			}
			
		});	
		
		frmAMele.setVisible(true);	

		}
		
		}
	}
	
	public void ocultarControles()
	{
		
		btnEliminar.setVisible(false);
		btnModificar.setVisible(false);
	}
	public void eliminarElectrodomestico()
	{
		int indexrow=this.tableElectrodomestico.getSelectedRow();
		if(indexrow==-1)
		{
			JOptionPane.showMessageDialog(null, "Debe seleccionar un electrodomestico");
		}
		else
		{
			 int dialogButton = JOptionPane.YES_NO_OPTION;
             JOptionPane.showConfirmDialog (null, "¿Esta seguro que quiere eliminar un electrodomestico?","Warning",dialogButton);

             if(dialogButton == JOptionPane.YES_OPTION){ //The ISSUE is here

		int codEle=Integer.parseInt( this.tableElectrodomestico.getValueAt(indexrow, 0).toString());
		 contElectrodomestico.eliminarElectrodomestico(codEle);
		
		
		llenarjTable();
		}
		}
	}
		
		public void llenarjTable()
		{
			int montoMin=-1,montoMax=-1;
			char consumo=' ';
			if(!txtMin.getText().isEmpty())
				montoMin=Integer.parseInt( txtMin.getText());
			if(!txtMax.getText().isEmpty())
				montoMax=Integer.parseInt( txtMax.getText());
			
			if(montoMin>montoMax)
				JOptionPane.showMessageDialog(null,"El precio minimo no puede ser mayor que el maximo");
			
			if(!cmbConsumo.getSelectedItem().toString().isEmpty())
				consumo=cmbConsumo.getSelectedItem().toString().charAt(0);
				
			this.tableElectrodomestico.setModel(contElectrodomestico.getModelElectrodomestico(montoMin, montoMax, consumo));
		}
		/**
		 * Create the application.
		 */
		
		
			public void cerrar()
			{
				this.setVisible(false);;
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmListaElectrodomestico2 frame = new frmListaElectrodomestico2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmListaElectrodomestico2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelFiltros = new JPanel();
		panelFiltros.setBounds(10, 11, 352, 95);
		contentPane.add(panelFiltros);
		panelFiltros.setLayout(null);
		
		JLabel lblImp = new JLabel("Importe:");
		lblImp.setBounds(16, 3, 46, 14);
		panelFiltros.add(lblImp);
		
		txtMin = new JTextField();
		txtMin.setBounds(112, 0, 86, 20);
		panelFiltros.add(txtMin);
		txtMin.setColumns(10);
		
		JLabel lblMin = new JLabel("Min:");
		lblMin.setBounds(72, 3, 46, 14);
		panelFiltros.add(lblMin);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setBounds(73, 34, 46, 14);
		panelFiltros.add(lblMax);
		
		txtMax = new JTextField();
		txtMax.setBounds(112, 31, 86, 20);
		panelFiltros.add(txtMax);
		txtMax.setColumns(10);
		
		JLabel label_3 = new JLabel("Consumo energetico:");
		label_3.setBounds(0, 76, 110, 14);
		panelFiltros.add(label_3);
		
		cmbConsumo = new JComboBox();
		cmbConsumo.setBounds(114, 73, 93, 20);
		panelFiltros.add(cmbConsumo);
		cmbConsumo.setModel(new DefaultComboBoxModel(new String[] {"", "A", "B", "C", "D", "E", "F"}));
		
		JButton button = new JButton("Buscar");
		button.setBounds(263, 72, 89, 23);
		panelFiltros.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				llenarjTable();
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				modificarElectrodomestico();
			}
		});
		btnModificar.setBounds(20, 343, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				eliminarElectrodomestico();
			}
		});
		btnEliminar.setBounds(128, 343, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton button_3 = new JButton("Cancelar");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cerrar();
			}
		});
		button_3.setBounds(567, 343, 89, 23);
		contentPane.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 132, 652, 200);
		contentPane.add(scrollPane);
		
		tableElectrodomestico = new JTable();
		tableElectrodomestico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableElectrodomestico);
		contElectrodomestico=new ControladorElectrodomestico();
	}
}

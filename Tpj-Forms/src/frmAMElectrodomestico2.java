import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import Clases.*;
import Controlador.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class frmAMElectrodomestico2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtPeso;
	private JTextField txtCarga;
	private JTextField txtPulgadas;
	private boolean esModificacion=false;
	private int codEle=0;
	private JComboBox cmbConsumo;
	private JComboBox cmbColor;
	private JComboBox cmbTipo;
	private JCheckBox chTDT;
	
	public void cargarElectrodomestico(Electrodomestico ele)
	{
		if(ele.getTipo().equals("Lavarropas"))
		{
			Lavarropas lav=(Lavarropas)ele;
			
			cmbTipo.setSelectedIndex(1);
			txtDescripcion.setText(lav.getDescripcion());
			txtCarga.setText(Integer.toString( lav.getCarga()));
			txtPeso.setText(Integer.toString(lav.getPeso()));
			txtPrecio.setText(Integer.toString(lav.getPrecio_base()));
			Object col=lav.colores.getDescripcionColor();
			cmbColor.setSelectedItem(col);
			Object consum=Character.toString( lav.ConsumoEnergetico.getDescripcionConsumo());
			cmbConsumo.setSelectedItem(consum);
			
		}
		else
		{
			Television tel=(Television)ele;
			cmbTipo.setSelectedIndex(2);
			txtDescripcion.setText(tel.getDescripcion());
			
			txtPeso.setText(Integer.toString(tel.getPeso()));
			txtPrecio.setText(Integer.toString(tel.getPrecio_base()));
			Object col=tel.colores.getDescripcionColor();
			cmbColor.setSelectedItem(col);
			Object consum=Character.toString( tel.ConsumoEnergetico.getDescripcionConsumo());
			cmbConsumo.setSelectedItem(consum);
			txtPulgadas.setText(Integer.toString(tel.getPulgadas()));
			chTDT.setSelected(tel.getSintonizador());
		}
		cmbTipo.setEnabled(false);
		this.codEle=ele.getCodElectrodomestico();
		setEsModificacion(true);
	}
	
	public void setEsModificacion(boolean esModificacion) {
		this.esModificacion = esModificacion;
	}

	

	public void Crear()
	{
		ControladorElectrodomestico con=new ControladorElectrodomestico();
		if(cmbTipo.getSelectedItem().toString().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Selecciones algun tipo de electrodomestido");
		}
		else
		{		
		con.AltaModificacion(cmbTipo.getSelectedItem().toString(), txtDescripcion.getText(),txtPeso.getText().toString(), cmbConsumo.getSelectedItem().toString(), txtCarga.getText().toString(), cmbColor.getSelectedItem().toString(), txtPulgadas.getText().toString(),txtPrecio.getText().toString() , chTDT.isSelected(),this.esModificacion,this.codEle);		
		}
		limpiarControles();
		
	
	}
	public void limpiarControles()
	{
		txtCarga.setText("");
		txtDescripcion.setText("");
		txtPeso.setText("");
		txtPrecio.setText("");
		txtPulgadas.setText("");
		cmbColor.setSelectedIndex(0);
		cmbConsumo.setSelectedIndex(0);
		cmbTipo.setSelectedIndex(0);
		chTDT.setSelected(false);
		txtCarga.setEnabled(true);
		txtPulgadas.setEnabled(true);
		chTDT.setEnabled(true);
	}
	
public void habilitarControles()
{
	if(cmbTipo.getSelectedItem().toString()=="Lavarropas")
	{
		txtPulgadas.setEnabled(false);
		txtPulgadas.setText("");
		chTDT.setEnabled(false);
		chTDT.setSelected(false);
		txtCarga.setEnabled(true);
	}
	if(cmbTipo.getSelectedItem().toString()=="Television")
	{
		txtPulgadas.setEnabled(true);
		chTDT.setEnabled(true);
		txtCarga.setText("");
		txtCarga.setEnabled(false);
	}
}
	
	
	public void cerrar()
	{
		this.setVisible(false);
		
	}
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAMElectrodomestico2 frame = new frmAMElectrodomestico2();
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
	public frmAMElectrodomestico2() {
		initComponents();
		
		
	}
	public frmAMElectrodomestico2(Electrodomestico ele)
	{
		initComponents();
			cargarElectrodomestico(ele);
		
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Tipo:");
		label.setBounds(71, 21, 34, 30);
		contentPane.add(label);
		
		cmbTipo = new JComboBox();
		cmbTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				habilitarControles();
			}
		});
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"", "Lavarropas", "Television"}));
		cmbTipo.setBounds(115, 26, 182, 20);
		contentPane.add(cmbTipo);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(114, 97, 332, 20);
		contentPane.add(txtDescripcion);
		
		JLabel label_1 = new JLabel("Descripcion:");
		label_1.setBounds(48, 100, 66, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Color:");
		label_2.setBounds(58, 137, 46, 14);
		contentPane.add(label_2);
		
		cmbColor = new JComboBox();
		cmbColor.setModel(new DefaultComboBoxModel(new String[] {"", "Blanco", "Negro", "Rojo", "Azul", "Gris"}));
		cmbColor.setBounds(114, 134, 86, 20);
		contentPane.add(cmbColor);
		
		JLabel label_3 = new JLabel("Consumo:");
		label_3.setBounds(48, 168, 55, 14);
		contentPane.add(label_3);
		
		cmbConsumo = new JComboBox();
		cmbConsumo.setModel(new DefaultComboBoxModel(new String[] {"", "A", "B", "C", "D", "E", "F"}));
		cmbConsumo.setBounds(114, 165, 55, 20);
		contentPane.add(cmbConsumo);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(114, 196, 86, 20);
		contentPane.add(txtPrecio);
		
		JLabel label_4 = new JLabel("Precio base:");
		label_4.setBounds(48, 199, 66, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Peso:");
		label_5.setBounds(68, 230, 46, 14);
		contentPane.add(label_5);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(114, 227, 86, 20);
		contentPane.add(txtPeso);
		
		txtCarga = new JTextField();
		txtCarga.setColumns(10);
		txtCarga.setBounds(114, 258, 86, 20);
		contentPane.add(txtCarga);
		
		JLabel label_6 = new JLabel("Carga:");
		label_6.setBounds(58, 261, 46, 14);
		contentPane.add(label_6);
		
		txtPulgadas = new JTextField();
		txtPulgadas.setColumns(10);
		txtPulgadas.setBounds(114, 289, 86, 20);
		contentPane.add(txtPulgadas);
		
		JLabel label_7 = new JLabel("Pulgadas:");
		label_7.setBounds(48, 292, 66, 14);
		contentPane.add(label_7);
		
		chTDT = new JCheckBox("TDT");
		chTDT.setBounds(114, 319, 97, 23);
		contentPane.add(chTDT);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Crear();
			}
		});
		btnGuardar.setBounds(258, 362, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cerrar();
			
			}
		});
		btnCancelar.setBounds(357, 362, 89, 23);
		contentPane.add(btnCancelar);
	}
}

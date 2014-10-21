import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class frmPrincial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincial window = new frmPrincial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmPrincial() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 797, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Electrodomesticos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNuevoElectrodomestico = new JMenuItem("Nuevo");
		mntmNuevoElectrodomestico.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				frmAMElectrodomestico2 frmAbME= new frmAMElectrodomestico2();
				frmAbME.setVisible(true);
			
			}
		
			
		});
		mnNewMenu.add(mntmNuevoElectrodomestico);
		
		JMenuItem mntmElectrodomesticos = new JMenuItem("Baja/Modificacion");
		mntmElectrodomesticos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frmListaElectrodomestico2 frmLi= new frmListaElectrodomestico2();
			frmLi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmElectrodomesticos);
		
		JMenuItem mntmLista = new JMenuItem("Lista");
		mntmLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frmListaElectrodomestico2 frmLi= new frmListaElectrodomestico2();
				frmLi.ocultarControles();
				frmLi.llenarjTable();
				frmLi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmLista);
	}

}

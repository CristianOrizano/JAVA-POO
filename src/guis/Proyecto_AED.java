package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Paciente;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Proyecto_AED extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmCama;
	private JMenuItem mntmPaciente;
	private JMenuItem mntmMedicina;
	private JMenuItem mntmSalir;
	private JMenuItem mntmAtencion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto_AED frame = new Proyecto_AED();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Proyecto_AED() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 504);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnNewMenu.add(mntmSalir);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmCama = new JMenuItem("Cama");
		mntmCama.addActionListener(this);
		mnMantenimiento.add(mntmCama);
		
		mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.addActionListener(this);
		mnMantenimiento.add(mntmPaciente);
		
		mntmMedicina = new JMenuItem("Medicina");
		mntmMedicina.addActionListener(this);
		mnMantenimiento.add(mntmMedicina);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmAtencion = new JMenuItem("Atencion");
		mntmAtencion.addActionListener(this);
		mnRegistro.add(mntmAtencion);
		
		JMenuItem mntmInternamiento = new JMenuItem("Internamiento");
		mnRegistro.add(mntmInternamiento);
		
		JMenu mnPago = new JMenu("Pago");
		menuBar.add(mnPago);
		
		JMenuItem mntmAtenciones = new JMenuItem("Atenciones");
		mnPago.add(mntmAtenciones);
		
		JMenuItem mntmInternamientos = new JMenuItem("Internamientos");
		mnPago.add(mntmInternamientos);
		
		JMenu mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		JMenuItem mntmAtencionesPendientes = new JMenuItem("Atenciones Pendientes");
		mnReporte.add(mntmAtencionesPendientes);
		
		JMenuItem mntmAtencionesPagadas = new JMenuItem("Atenciones Pagadas");
		mnReporte.add(mntmAtencionesPagadas);
		
		JMenuItem mntmInterenamientosPendientes = new JMenuItem("Interenamientos Pendientes");
		mnReporte.add(mntmInterenamientosPendientes);
		
		JMenuItem mntmInternamientosPagadas = new JMenuItem("Internamientos Pagados");
		mnReporte.add(mntmInternamientosPagadas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmAtencion) {
			actionPerformedMntmAtencion(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmMedicina) {
			actionPerformedMntmMedicina(arg0);
		}
		if (arg0.getSource() == mntmPaciente) {
			actionPerformedMntmPaciente(arg0);
		}
		if (arg0.getSource() == mntmCama) {
			actionPerformedMntmCama(arg0);
		}
	}
	protected void actionPerformedMntmCama(ActionEvent arg0) {
		Cama c = new Cama();
		c.setLocationRelativeTo(this);
		c.setVisible(true);
	}
	protected void actionPerformedMntmPaciente(ActionEvent arg0) {
		guiPaciente pa = new guiPaciente();
		pa.setLocationRelativeTo(this);
		pa.setVisible(true);
		
	}
	protected void actionPerformedMntmMedicina(ActionEvent arg0) {
		guiMedicina me = new guiMedicina();
		me.setLocationRelativeTo(this);
		me.setVisible(true);
		
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedMntmAtencion(ActionEvent arg0) {
		guiAtencion at = new guiAtencion();
		at.setLocationRelativeTo(this);
		at.setVisible(true);
	}
}

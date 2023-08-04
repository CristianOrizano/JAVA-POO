package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloPaciente;
import Clases.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class guiPaciente extends JDialog implements ActionListener, MouseListener {
	
	//variable global
	
	ArregloPaciente ar = new ArregloPaciente();
	DefaultTableModel modelo = new DefaultTableModel();

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTextField txtApellidos;
	private JTextField txtCodigo;
	private JTable tblTabla;
	private JButton btnAdicionar;
	private JButton btnAceptar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			guiPaciente dialog = new guiPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public guiPaciente() {
		setModal(true);
		setBounds(100, 100, 704, 463);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo");
		label.setBounds(10, 25, 110, 23);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("Nombres");
		label_1.setBounds(10, 55, 70, 23);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Apellidos");
		label_2.setBounds(10, 85, 70, 23);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("Tel\u00E9fono");
		label_3.setBounds(10, 115, 70, 23);
		contentPanel.add(label_3);
		
		JLabel label_4 = new JLabel("DNI");
		label_4.setBounds(10, 145, 70, 23);
		contentPanel.add(label_4);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(90, 145, 85, 23);
		contentPanel.add(txtDni);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(90, 115, 85, 23);
		contentPanel.add(txtTelefono);
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(90, 85, 200, 23);
		contentPanel.add(txtApellidos);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(90, 25, 85, 23);
		contentPanel.add(txtCodigo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setForeground(Color.BLUE);
		btnAceptar.setBounds(190, 25, 100, 23);
		contentPanel.add(btnAceptar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.setBounds(506, 25, 150, 23);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.BLUE);
		btnModificar.setBounds(506, 55, 150, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.setBounds(506, 85, 150, 23);
		contentPanel.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 179, 668, 234);
		contentPanel.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.addMouseListener(this);
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		//tabla
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Telefono");
		modelo.addColumn("Dni");
		tblTabla.setModel(modelo);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(90, 59, 178, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		correlativo();
		listar();
		select();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		correlativo();
		//txt
		edita();
		limpieza();
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		int co = Integer.parseInt(txtCodigo.getText());
		String nom = txtNombre.getText();
		String ape = txtApellidos.getText();
		int tele = Integer.parseInt(txtTelefono.getText());
		int dni = Integer.parseInt(txtDni.getText());
		Paciente pa = new Paciente(co, nom, ape, tele, dni);
		
		if(btnAdicionar.isEnabled()==false) {
			ar.adicionar(pa);
			btnAdicionar.setEnabled(true);
			btnAceptar.setEnabled(false);
			ar.guardar();
			listar();
			//limpieza();
			btnAceptar.setEnabled(false);
			inabilitar();
		}
		if(btnModificar.isEnabled()==false) {
			Paciente x = ar.buscar(co);
			x.setNombre(nom);
			x.setApellido(ape);
			x.setTelefono(tele);
			x.setDni(dni);
			ar.guardar();
			listar();
			btnAceptar.setEnabled(false);
			btnModificar.setEnabled(true);
			inabilitar();
			
		}
		
		
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		
		btnModificar.setEnabled(false);
		btnAdicionar.setEnabled(true);
		btnAceptar.setEnabled(true);
		select();
		edita();
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		
		if(ar.tamaño()==0) {
			JOptionPane.showMessageDialog(null, "no hay paciente");
		}else {
			int a = JOptionPane.showConfirmDialog(this,"Seguro de ELiminar" ,"Alerta", 0, 1, null);
			if(a==0) {
			int codi = Integer.parseInt(txtCodigo.getText());
			ar.eliminar(ar.buscar(codi));
			listar();
			}
		}
			
	}
	
	//listar
	public void listar() {
		//--selecion automatica
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblTabla.getSelectedRow();
		if (modelo.getRowCount() == ar.tamaño() - 1)
			posFila = ar.tamaño() - 1;
		if (posFila == ar.tamaño())
			posFila --;
		//----------------
		modelo.setRowCount(0);
		for(int a=0;a<ar.tamaño();a++) {
			Paciente x = ar.obtener(a);
			Object row[]= {
					 x.getCodigo(),
					 x.getNombre(),
					 x.getApellido(),
					 x.getTelefono(),
					 x.getDni()			
			          };
			modelo.addRow(row);
		}
		if (ar.tamaño() > 0)
			tblTabla.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	public void correlativo() {
		txtCodigo.setText(String.valueOf(ar.numeroCorrelativo()));
	}
	
	//limpieza
	public void limpieza() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
		txtNombre.requestFocus();
	}
	
	public void select() {
		int fila = tblTabla.getSelectedRow();
		
		String codigo= tblTabla.getValueAt(fila, 0).toString();
		String nombre= tblTabla.getValueAt(fila, 1).toString();
		String apellido = tblTabla.getValueAt(fila, 2).toString();
		String telefono = tblTabla.getValueAt(fila, 3).toString();
		String dni = tblTabla.getValueAt(fila, 4).toString();
		
		txtCodigo.setText(String.valueOf(codigo));
		txtNombre.setText(String.valueOf(nombre));
		txtApellidos.setText(String.valueOf(apellido));
		txtTelefono.setText(String.valueOf(telefono));
		txtDni.setText(String.valueOf(dni));
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblTabla) {
			mouseClickedTblTabla(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblTabla(MouseEvent arg0) {
		select();
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		inabilitar();
	}
	public void inabilitar() {
		txtCodigo.setEditable(false);
		txtNombre.setEditable(false);
		txtApellidos.setEditable(false);
		txtTelefono.setEditable(false);
		txtDni.setEditable(false);
	}
	public void edita() {
		txtNombre.setEditable(true);
		txtApellidos.setEditable(true);
		txtTelefono.setEditable(true);
		txtDni.setEditable(true);
	}
}

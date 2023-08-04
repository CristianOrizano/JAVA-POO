package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloMedicina;
import Clases.Medicina;

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

public class guiMedicina extends JDialog implements ActionListener, MouseListener {
	
	//variable global
	ArregloMedicina am = new ArregloMedicina();
	DefaultTableModel modelo = new DefaultTableModel();

	private final JPanel contentPanel = new JPanel();
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTextField txtLaboratorio;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnELiminar;
	private JScrollPane scrollPane;
	private JTable tblTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			guiMedicina dialog = new guiMedicina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public guiMedicina() {
		setModal(true);
		setBounds(100, 100, 737, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		label = new JLabel("C\u00F3digo");
		label.setBounds(10, 29, 110, 23);
		contentPanel.add(label);
		
		label_1 = new JLabel("Nombre");
		label_1.setBounds(10, 59, 70, 23);
		contentPanel.add(label_1);
		
		label_2 = new JLabel("Laboratorio");
		label_2.setBounds(10, 89, 70, 23);
		contentPanel.add(label_2);
		
		label_3 = new JLabel("Stock");
		label_3.setBounds(10, 119, 70, 23);
		contentPanel.add(label_3);
		
		label_4 = new JLabel("Precio");
		label_4.setBounds(10, 149, 70, 23);
		contentPanel.add(label_4);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(90, 149, 85, 23);
		contentPanel.add(txtPrecio);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setColumns(10);
		txtStock.setBounds(90, 119, 85, 23);
		contentPanel.add(txtStock);
		
		txtLaboratorio = new JTextField();
		txtLaboratorio.setEditable(false);
		txtLaboratorio.setColumns(10);
		txtLaboratorio.setBounds(90, 89, 200, 23);
		contentPanel.add(txtLaboratorio);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(90, 59, 200, 23);
		contentPanel.add(txtNombre);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(90, 29, 85, 23);
		contentPanel.add(txtCodigo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setForeground(Color.BLUE);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(190, 29, 100, 23);
		contentPanel.add(btnAceptar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.setBounds(535, 29, 150, 23);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.BLUE);
		btnModificar.setBounds(535, 54, 150, 23);
		contentPanel.add(btnModificar);
		
		btnELiminar = new JButton("Eliminar");
		btnELiminar.addActionListener(this);
		btnELiminar.setForeground(Color.BLUE);
		btnELiminar.setBounds(535, 79, 150, 23);
		contentPanel.add(btnELiminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 194, 701, 226);
		contentPanel.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.addMouseListener(this);
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		//tabble
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Laboratorio");
		modelo.addColumn("Stock");
		modelo.addColumn("Precio");
		tblTabla.setModel(modelo);
		//
		correlativo();
		listar();
		select();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnELiminar) {
			actionPerformedBtnELiminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		
		btnAdicionar.setEnabled(false);
		btnAceptar.setEnabled(true);
		btnModificar.setEnabled(true);
		correlativo();
		visible();
		limpiar();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnModificar.setEnabled(false);
		btnAceptar.setEnabled(true);
		btnAdicionar.setEnabled(true);
		select();
		visible();
		//correlativo();
	}
	protected void actionPerformedBtnELiminar(ActionEvent arg0) {
		btnAceptar.setEnabled(false);
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		ocultar();
		select();
		if(am.tamaño()==0) {
			JOptionPane.showMessageDialog(null,"No hay Paciente");
		}else {
			int a = JOptionPane.showConfirmDialog(this,"Seguro de Eliminar","Alerta",0,1,null);
			if(a==0) {
				int codi = Integer.parseInt(txtCodigo.getText());
				am.eliminar(am.buscar(codi));
				am.Guardar();
				listar();
				select();
			}
				
		}
			
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		
		int codigo = Integer.parseInt(txtCodigo.getText());
		int stoc = Integer.parseInt(txtStock.getText());
	    String nom= txtNombre.getText();
	    String labo = txtLaboratorio.getText();
	    double precio = Double.parseDouble(txtPrecio.getText());
	    Medicina m = new Medicina(codigo, nom, labo, stoc, precio);
	    if(btnAdicionar.isEnabled()==false) {
	    	am.adicionar(m);
	    	btnAceptar.setEnabled(false);
	    	btnAdicionar.setEnabled(true);
	    	ocultar();
	    	am.Guardar();
	    	listar();
	    	
	    }
	    
	    if(btnModificar.isEnabled()==false) {
	    	Medicina x = am.buscar(codigo);
	    	x.setNombre(nom);
	    	x.setLaboratorio(labo);
	    	x.setStock(stoc);
	    	x.setPrecioUnitario(precio);
	    	am.Guardar();
	    	listar();
	    	btnModificar.setEnabled(true);
	    	btnAceptar.setEnabled(false);
	    	ocultar();
	    	JOptionPane.showMessageDialog(null, "Modificado");
	    }
	}
	
	public void correlativo() {
		txtCodigo.setText(String.valueOf(am.correlativi()));
	}
	public void visible() {
		txtLaboratorio.setEditable(true);
		txtNombre.setEditable(true);
		txtPrecio.setEditable(true);
		txtStock.setEditable(true);
	}
	public void ocultar() {
		txtLaboratorio.setEditable(false);
		txtNombre.setEditable(false);
		txtPrecio.setEditable(false);
		txtStock.setEditable(false);
	}
	public void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblTabla.getSelectedRow();
		if (modelo.getRowCount() == am.tamaño() - 1)
			posFila = am.tamaño() - 1;
		if (posFila == am.tamaño())
			posFila --;
		
		modelo.setRowCount(0);
		for(int a=0;a<am.tamaño();a++) {
			Medicina m = am.obtener(a);
			Object row[]= {
					m.getCodigoMedicina(),
					m.getNombre(),
					m.getLaboratorio(),
					m.getStock(),
					m.getPrecioUnitario()
			        };
			modelo.addRow(row);
		}
		if (am.tamaño() > 0)
			tblTabla.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	public void limpiar() {
		txtLaboratorio.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
		txtNombre.requestFocus();
		
	}
	public void select() {
		int fila=tblTabla.getSelectedRow();
		
		String codig = tblTabla.getValueAt(fila, 0).toString();
		String nomb = tblTabla.getValueAt(fila, 1).toString();
	    String labo  = tblTabla.getValueAt(fila, 2).toString();
	    String stock  = tblTabla.getValueAt(fila, 3).toString();
	    String precio  = tblTabla.getValueAt(fila, 4).toString();
		
	    txtCodigo.setText(String.valueOf(codig));
	    txtLaboratorio.setText(String.valueOf(labo));
		txtNombre.setText(String.valueOf(nomb));
		txtPrecio.setText(String.valueOf(precio));
		txtStock.setText(String.valueOf(stock));
	    
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
		ocultar();
		btnAdicionar.setEnabled(true);
		btnAceptar.setEnabled(false);
		btnModificar.setEnabled(true);
	}
}

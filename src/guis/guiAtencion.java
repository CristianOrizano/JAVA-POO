package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Arreglos.ArregloAtencion;
import Arreglos.ArregloMedicina;
import Arreglos.ArregloPaciente;
import Arreglos.ArregloReceta;
import Clases.Atencion;
import Clases.Medicina;
import Clases.Paciente;
import Clases.Receta;
import Libreria.Fecha;
import Libreria.Lib;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class guiAtencion extends JDialog implements ActionListener, MouseListener {

	 ArregloAtencion at = new ArregloAtencion();
	 DefaultTableModel modelo = new DefaultTableModel();
	
	private final JPanel contentPanel = new JPanel();
	private JLabel label;
	private JLabel label_1;
	private JLabel lblCodigoMedicina;
	private JComboBox<String> cboCodMedicina;
	private JTextField txtPaciente;
	private JTextField txtCodigo;
	private JButton btnQuitar;
	private JComboBox<String> cboCodigoMedicina;
	private JComboBox<String> cboCodPaciente;
	private JButton btnProceder;
	private JButton btnAgregar;
	private JButton btnAtender;
	private JScrollPane scrollPane;
	private JTable tblTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			guiAtencion dialog = new guiAtencion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public guiAtencion() {
		setBounds(100, 100, 693, 384);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		label = new JLabel("C\u00F3digo");
		label.setBounds(10, 22, 60, 23);
		contentPanel.add(label);
		
		label_1 = new JLabel("Paciente");
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(10, 52, 60, 23);
		contentPanel.add(label_1);
		
		lblCodigoMedicina = new JLabel("Medicina");
		lblCodigoMedicina.setForeground(Color.BLUE);
		lblCodigoMedicina.setBounds(10, 82, 60, 23);
		contentPanel.add(lblCodigoMedicina);
		
		cboCodMedicina = new JComboBox<String>();
		cboCodMedicina.setBounds(70, 82, 85, 23);
		contentPanel.add(cboCodMedicina);
		
		txtPaciente = new JTextField();
		txtPaciente.setEditable(false);
		txtPaciente.setColumns(10);
		txtPaciente.setBounds(70, 52, 85, 23);
		contentPanel.add(txtPaciente);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(70, 22, 85, 23);
		contentPanel.add(txtCodigo);
		
		btnQuitar = new JButton((Icon) null);
		btnQuitar.addActionListener(this);
		btnQuitar.setBounds(161, 82, 23, 23);
		contentPanel.add(btnQuitar);
		
		cboCodigoMedicina = new JComboBox<String>();
		cboCodigoMedicina.setBounds(190, 82, 100, 23);
		contentPanel.add(cboCodigoMedicina);
		
		cboCodPaciente = new JComboBox<String>();
		cboCodPaciente.addActionListener(this);
		cboCodPaciente.setBounds(190, 52, 100, 23);
		contentPanel.add(cboCodPaciente);
		
		btnProceder = new JButton("Proceder");
		btnProceder.addActionListener(this);
		btnProceder.setForeground(Color.BLUE);
		btnProceder.setEnabled(false);
		btnProceder.setBounds(189, 22, 102, 23);
		contentPanel.add(btnProceder);
		
		btnAgregar = new JButton((Icon) null);
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(296, 82, 23, 23);
		contentPanel.add(btnAgregar);
		
		btnAtender = new JButton("Atender");
		btnAtender.addActionListener(this);
		btnAtender.setForeground(Color.BLUE);
		btnAtender.setBounds(442, 35, 150, 23);
		contentPanel.add(btnAtender);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 657, 201);
		contentPanel.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.addMouseListener(this);
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		//columnas
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("PACIENTE");
		modelo.addColumn("FECHA CONSULTA");
		modelo.addColumn("HORA CONSULTA");
		modelo.addColumn("A PAGAR");
		modelo.addColumn("ESTADO");
		tblTabla.setModel(modelo);
		
		colocarCodigosPacientes();
		colocarCodigoMedicina();
		ajustarAnchoColumnas();
		txtCodigo.setText("" + at.codigoCorrelativo());
		listar();
		editarFila();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnQuitar) {
			actionPerformedBtnQuitar(arg0);
		}
		if (arg0.getSource() == cboCodPaciente) {
			actionPerformedCboCodPaciente(arg0);
		}
		if (arg0.getSource() == btnProceder) {
			actionPerformedBtnProceder(arg0);
		}
		if (arg0.getSource() == btnAtender) {
			actionPerformedBtnAtender(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		int c = Integer.parseInt(txtCodigo.getText());
		Atencion a = at.buscar(c);
		if (a.getEstado() == 0) {
			int cod= Integer.parseInt(cboCodigoMedicina.getSelectedItem().toString());
			int codigoMedicina = cod;
			int ok = JOptionPane.showConfirmDialog(this, obtenerDatosMedicina(codigoMedicina), "¿ Recetar ?",0,1,null);
			if (ok == 0) {
				int cantidad = Integer.parseInt(confirmarIngreso("Cantidad"));
			ArregloMedicina am = new ArregloMedicina();
			Medicina m = am.buscar(codigoMedicina);
			if (cantidad <= m.getStock()) {
				//int ab = Integer.parseInt(txtCodigo.getText());
				String re = txtCodigo.getText();
				ArregloReceta ar = new ArregloReceta(re);
				ar.adicionar(new Receta(codigoMedicina, cantidad, m.getPrecioUnitario()));
				ar.grabarReceta();
				m.setStock(m.getStock() - cantidad);
				am.Guardar();
				a.setaPagar(redondear(a.getaPagar()+ cantidad*m.getPrecioUnitario()));
				at.Guardar();
				cboCodMedicina.addItem(cboCodigoMedicina.getSelectedItem().toString());
				cboCodigoMedicina.removeItem(cboCodigoMedicina.getSelectedItem());
				listar();
			}
			else
				JOptionPane.showMessageDialog(null, "Sólo hay " + m.getStock() + " unidades en stock");
		}
		 
		}else
				JOptionPane.showMessageDialog(null, "No se puede agregar medicinas porque la Atención está Pagada");
		
		
	}
	protected void actionPerformedBtnAtender(ActionEvent arg0) {
		if (cboCodPaciente.getSelectedIndex() < 0)
			JOptionPane.showMessageDialog(null,"Todos los pacientes están en Atención");
		else {
			visibleInvisible(false);
			btnAtender.setEnabled(false);
			btnProceder.setEnabled(true);
			txtCodigo.setText("" + at.codigoCorrelativo());
			txtPaciente.setText("" + cboCodPaciente.getSelectedItem());
		}
		
	}
	void visibleInvisible(boolean sino) {
		lblCodigoMedicina.setVisible(sino);
		cboCodMedicina.setVisible(sino);
		btnQuitar.setVisible(sino);
		cboCodigoMedicina.setVisible(sino);
		btnAgregar.setVisible(sino);
	}
	protected void actionPerformedBtnProceder(ActionEvent arg0) {
		
		int codigoAtencion = Integer.parseInt(txtCodigo.getText());
		int codigoPaciente = Integer.parseInt(txtPaciente.getText());
		int ok = JOptionPane.showConfirmDialog(this, obtenerDatosPaciente(),"¿ Registrar Atención ?",0,1,null);
		if (ok == 0) {
			Atencion nueva = new Atencion(codigoAtencion, codigoPaciente, fechaActual(), horaActual(), 100.0, 0);
			at.adicionar(nueva);
			at.Guardar();
			cboCodPaciente.removeItem(cboCodPaciente.getSelectedItem());
			editarFila();
			listar();
		}
		visibleInvisible(true);
		btnAtender.setEnabled(true);
		btnProceder.setEnabled(false);
		listar();
		at.Guardar();
		editarFila();
	}
	//fecha actual y hora
	//==============
	String fechaActual() {
		int dd, mm, aa;
		Calendar c = new GregorianCalendar();
		dd = c.get(Calendar.DAY_OF_MONTH);
		mm = c.get(Calendar.MONTH) + 1;
		aa = c.get(Calendar.YEAR);
		return ajustar(dd) + "/" + ajustar(mm) + "/" + aa;
	}
	String horaActual() {
		int hh, mm, ss;
		Calendar c = new GregorianCalendar();
		hh = c.get(Calendar.HOUR_OF_DAY);
		mm = c.get(Calendar.MINUTE);
		ss = c.get(Calendar.SECOND);
		return ajustar(hh) + ":" + ajustar(mm) + ":" + ajustar(ss);
	}
	String ajustar(int numero) {
		return String.format("%02d", numero);
	}
	//==============================
	public void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblTabla.getSelectedRow();
		if (modelo.getRowCount() == at.tamaño() - 1)
			posFila = at.tamaño() - 1;
		if (posFila == at.tamaño())
			posFila --;
	     modelo.setRowCount(0);
	     for(int a=0;a<at.tamaño();a++) {
	    	 Atencion x = at.obtener(a);
	    	 Object []row= {
	    			 x.getCodigoAtencion(),
	    			 x.getCodigoPaciente(),
	    			Fecha.enTextoFecha(x.getFechaAtencion()),
	    			 x.getHoraAtencion(),
	    			 x.getaPagar(),
	    			 Lib.estadosConsulta[x.getEstado()]
	    	 };
	    	 modelo.addRow(row);
	     }
	     if (at.tamaño() > 0)
				tblTabla.getSelectionModel().setSelectionInterval(posFila, posFila);
	     
	}
	
	void colocarCodigosPacientes() {
		ArregloPaciente ap = new ArregloPaciente();
		Paciente p;
		for (int i=0; i<ap.tamaño(); i++) {
			p = ap.obtener(i);
			//esto es para evitar que al cargar el codigo en el combo no se repita
			if (at.procedeCodigoPacientes(p.getCodigo()))
				cboCodPaciente.addItem("" + p.getCodigo());
			
		}
	}
	
	public void colocarCodigoMedicina() {
		ArregloMedicina am = new ArregloMedicina();
		Medicina m;
		for(int a=0;a<am.tamaño();a++) {
			m = am.obtener(a);
			cboCodigoMedicina.addItem(""+m.getCodigoMedicina());
		}
		
	}
	//
	  public  String obtenerDatosPaciente() {
	ArregloPaciente ap = new ArregloPaciente();
	int a= Integer.parseInt(txtPaciente.getText());
    Paciente p = ap.buscar(a);
    return "Nombres :  " + p.getNombre() + "\n" +
	       "Apellidos :  " + p.getApellido();
    }
	  String obtenerDatosMedicina(int codigoMedicina) {
			ArregloMedicina am = new ArregloMedicina();
		    Medicina m = am.buscar(codigoMedicina);
		    return "Nombre :  " + m.getNombre() + "\n" +
			       "Precio unitario :  S/ " + m.getPrecioUnitario();
		}
	
	protected void actionPerformedCboCodPaciente(ActionEvent arg0) {
		txtPaciente.setText(""+cboCodPaciente.getSelectedItem());
	}
	String confirmarIngreso(String s) {
		return JOptionPane.showInputDialog(this, "", s, 3);
	}
	double redondear(double real) {
		return Math.round(real * 100) / 100.0;
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
		//if (btnProceder.isEnabled())
		visibleInvisible(true);
		//if(btnAtender)
		btnProceder.setEnabled(false);
		btnAtender.setEnabled(true);
		editarFila();
	}
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblTabla.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(16));  // codigoAtencion
		tcm.getColumn(1).setPreferredWidth(anchoColumna(16));  // codigoPaciente
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  // fechaAtencion
		tcm.getColumn(3).setPreferredWidth(anchoColumna(16));  // horaAtencion
		tcm.getColumn(4).setPreferredWidth(anchoColumna(16));  // totalPagar
		tcm.getColumn(5).setPreferredWidth(anchoColumna(16));  // estado
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	protected void actionPerformedBtnQuitar(ActionEvent arg0) {
		
		int ag = Integer.parseInt(txtCodigo.getText());
		Atencion a = at.buscar(ag);
		if (a.getEstado() == 0) {
				
			int codMedicina = Integer.parseInt(cboCodMedicina.getSelectedItem().toString());
			int ok = JOptionPane.showConfirmDialog(this,"¿ Quitar medicina de la Receta ?","Alerta",0,1,null);
			if (ok == 0) {				
                String co = txtCodigo.getText();			
				ArregloReceta ar = new ArregloReceta(co);
				Receta r = ar.buscar(codMedicina);
				ar.eliminar(r);
				ar.grabarReceta();
				ArregloMedicina am = new ArregloMedicina();
				Medicina m = am.buscar(codMedicina);
				m.setStock(m.getStock() + r.getCantidad());
				am.Guardar();
				a.setaPagar(redondear(a.getaPagar() - r.getCantidad()*r.getPrecioUnitario()));
				at.Guardar();
				cboCodigoMedicina.addItem(cboCodMedicina.getSelectedItem().toString());
				cboCodMedicina.removeItem(cboCodMedicina.getSelectedItem());
				listar();		
		        }
		}
		else {
			JOptionPane.showMessageDialog(null, "No se puede quitar medicinas porque la Atención está Pagada");
		}
	}
	void editarFila() {
		if (at.tamaño() == 0)
			txtCodigo.setText("" + at.codigoCorrelativo());
		else {
			Atencion a = at.obtener(tblTabla.getSelectedRow());
			txtCodigo.setText("" + a.getCodigoAtencion());
			txtPaciente.setText("" + a.getCodigoPaciente());
			distribuirCodigosMedicinas();
		}
	}
	void distribuirCodigosMedicinas() {
		String ab = txtCodigo.getText();
		ArregloReceta ar = new ArregloReceta(ab);
		Receta r;
		cboCodMedicina.removeAllItems();
		for (int i=0; i<ar.tamaño(); i++) {
			r = ar.obtener(i);
			cboCodMedicina.addItem("" + r.getCodigoMedicina());
		}  
		ArregloMedicina am = new ArregloMedicina();
		Medicina m;
		cboCodigoMedicina.removeAllItems();
		for (int i=0; i<am.tamaño(); i++) {
			m = am.obtener(i);
			if (ar.buscar(m.getCodigoMedicina()) == null)
				cboCodigoMedicina.addItem("" + m.getCodigoMedicina());
		}	
	}
	
	
}

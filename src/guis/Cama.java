package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloCama;
import Clases.Camass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.print.attribute.standard.RequestingUserName;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Cama extends JDialog implements ActionListener, MouseListener {
	
	//variable global
	ArregloCama ca = new ArregloCama();
	DefaultTableModel modelo = new DefaultTableModel();
	

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtNumero;
	private JTable tblTabla;
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JComboBox<String> cboCategoria;
	private JComboBox<String> cboEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cama dialog = new Cama();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cama() {
		setModal(true);
		setBounds(100, 100, 740, 423);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("N\u00FAmero");
		label.setBounds(10, 22, 110, 23);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("Categor\u00EDa");
		label_1.setBounds(10, 52, 70, 23);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Precio");
		label_2.setBounds(10, 82, 70, 23);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("Estado");
		label_3.setBounds(10, 112, 70, 23);
		contentPanel.add(label_3);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupada"}));
		cboEstado.setEnabled(false);
		cboEstado.setBounds(90, 112, 85, 23);
		contentPanel.add(cboEstado);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(90, 82, 85, 23);
		contentPanel.add(txtPrecio);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setEnabled(false);
		cboCategoria.addActionListener(this);
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"B\u00E1sica", "Standar", "Premium"}));
		cboCategoria.setBounds(90, 52, 85, 23);
		contentPanel.add(cboCategoria);
		
		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		txtNumero.setBounds(90, 22, 85, 23);
		contentPanel.add(txtNumero);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		btnAceptar.setForeground(Color.BLUE);
		btnAceptar.setBounds(190, 22, 100, 23);
		contentPanel.add(btnAceptar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.setBounds(483, 22, 150, 23);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		
		btnModificar.setForeground(Color.BLUE);
		btnModificar.setBounds(483, 52, 150, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.setBounds(483, 82, 150, 23);
		contentPanel.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 146, 689, 227);
		contentPanel.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.addMouseListener(this);
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo.addColumn("Numero");
		modelo.addColumn("Categoria");
		modelo.addColumn("Precio");
		modelo.addColumn("Estado");
		tblTabla.setModel(modelo);
		//
		cboCategoria.setSelectedIndex(0);
		limpieza();
		listar();
		select();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboCategoria) {
			actionPerformedCboCategoria(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		
		int num = Integer.parseInt(txtNumero.getText());
		int cate= cboCategoria.getSelectedIndex();
		double pre = Double.parseDouble(txtPrecio.getText());
		int est = cboEstado.getSelectedIndex();
		if(btnAdicionar.isEnabled()== false) {
			Camass cs = new Camass(num, cate,pre,est);
			ca.adicionar(cs);
			ca.guardar();
			btnAdicionar.setEnabled(true);
			cboCategoria.setEnabled(false);
			btnAceptar.setEnabled(false);
			
		}
		if(btnModificar.isEnabled()==false){
			int nu = Integer.parseInt(txtNumero.getText());
			Camass x = ca.Buscar(nu);
			x.setCategoria(cate);
			x.setPrecioDia(pre);
			x.setEstado(est);
			ca.guardar();
			btnModificar.setEnabled(true);
			cboCategoria.setEnabled(false);
			btnAceptar.setEnabled(false);
		}
		listar();
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		cboCategoria.setEnabled(true);
		limpieza();
		
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnModificar.setEnabled(false);
		btnAdicionar.setEnabled(true);
		
		if(ca.tamaño()==0) {
			btnAceptar.setEnabled(false);
			cboCategoria.setEnabled(false);
			JOptionPane.showMessageDialog(null, "No hay camas");
		}else {
			select();
			int a = Integer.parseInt(txtNumero.getText());
			Camass x = ca.Buscar(a);
			if(x.getEstado()==0) {
				btnAceptar.setEnabled(true);
			    cboCategoria.setEnabled(true);
			}else {
			    	btnModificar.setEnabled(true);
			 JOptionPane.showMessageDialog(null,"no se puede eliminar cama"+a+"porque esta ocupada");
			}
		}
		
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAceptar.setEnabled(false);
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		if(ca.tamaño()==0)
			JOptionPane.showMessageDialog(null, "nohay camas");
		else {
			cboCategoria.setEnabled(false);
			select();
			int nu= Integer.parseInt(txtNumero.getText());
			Camass x = ca.Buscar(nu);
			if(x.getEstado()==0) {
				int ok= JOptionPane.showConfirmDialog(this, "seguro","alerta", 0,1,null);
				if(ok==0) {
					ca.Eliminar(ca.Buscar(nu));
					ca.guardar();
					listar();
					select();
				}
			  }else {
				  JOptionPane.showMessageDialog(null, "no se puede eliminar porque esta ocupado");
			  }
	
		}
			
			
	}
	
	public void limpieza() {
		txtNumero.setText(String.valueOf(ca.numeroCorrelativo()));
	}
	
	public void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblTabla.getSelectedRow();
		if (modelo.getRowCount() == ca.tamaño() - 1)
			posFila = ca.tamaño() - 1;
		if (posFila == ca.tamaño())
			posFila --;
		modelo.setRowCount(0);
		for(int a=0;a<ca.tamaño();a++) {
			Object row[]= {
				ca.obtener(a).getNumeroCama(),
				enTextoCategoria(ca.obtener(a).getCategoria()),
				ca.obtener(a).getPrecioDia(),
				estados(ca.obtener(a).getEstado())
			};
			modelo.addRow(row);
		}
		if (ca.tamaño() > 0)
			tblTabla.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	protected void actionPerformedCboCategoria(ActionEvent arg0) {
		int cate = cboCategoria.getSelectedIndex();
		if(cate==0) {
			txtPrecio.setText(String.valueOf(50.0));
		}else if(cate==1) {
			txtPrecio.setText(String.valueOf(100.0));
		}else
			txtPrecio.setText(String.valueOf(150.0));
	}
	
	String enTextoCategoria(int i) {
		return cboCategoria.getItemAt(i);
	}
    String estados(int a) {
	   return cboEstado.getItemAt(a);
   }
    public double precio() {
    	 int a =cboCategoria.getSelectedIndex();
    	if(a==0) {
    		return 50.0;
    	}else if(a==1){
    		return 100.0;
    	}else
    		return 150.0;
    	
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
		
		btnModificar.setEnabled(true);
		btnAdicionar.setEnabled(true);
		btnAceptar.setEnabled(false);
		cboCategoria.setEnabled(false);
		select();

	}
	public void select() {
		int fila= tblTabla.getSelectedRow();
		String num = tblTabla.getValueAt(fila, 0).toString();
		String cat = tblTabla.getValueAt(fila, 1).toString();
		String pr = tblTabla.getValueAt(fila, 2).toString();
		String est = tblTabla.getValueAt(fila, 3).toString();
		
		txtNumero.setText(num);
		cboCategoria.setSelectedItem(cat);
		cboEstado.setSelectedItem(est);
	}
	
}

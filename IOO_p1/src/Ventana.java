import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Ventana extends JFrame {
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtVal1;
	private JTextField txtVal2;
	JRadioButton rdContratado;
	JRadioButton rdAdmininistrativo;
	JLabel lblVal1;
	JLabel lblVal2;
	JList lstEmpleados;
	DefaultListModel lmodel = new DefaultListModel();
	Sistema sistema = new Sistema();
	

	public Ventana() {
		getContentPane().setLayout(null);
		
		JLabel lblEmpleado = new JLabel("DNI Empleado:");
		lblEmpleado.setBounds(10, 21, 88, 14);
		getContentPane().add(lblEmpleado);

		JLabel lblNombreEmpleado = new JLabel("Nombre Empleado:");
		lblNombreEmpleado.setBounds(10, 50, 110, 14);
		getContentPane().add(lblNombreEmpleado);

		txtDni = new JTextField();
		txtDni.setBounds(107, 18, 86, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(107, 47, 86, 20);
		getContentPane().add(txtNombre);

		JLabel lblTipoEmpleado = new JLabel("Tipo Empleado");
		lblTipoEmpleado.setBounds(10, 95, 88, 14);
		getContentPane().add(lblTipoEmpleado);

		rdContratado = new JRadioButton("Contratado");
		
		rdContratado.setBounds(84, 116, 109, 23);
		getContentPane().add(rdContratado);

		txtVal1 = new JTextField();
		txtVal1.setColumns(10);
		txtVal1.setBounds(94, 146, 86, 20);
		getContentPane().add(txtVal1);

		txtVal2 = new JTextField();
		txtVal2.setColumns(10);
		txtVal2.setBounds(94, 176, 86, 20);
		getContentPane().add(txtVal2);

		lblVal1 = new JLabel("val1");
		lblVal1.setBounds(10, 150, 76, 14);
		getContentPane().add(lblVal1);

		lblVal2 = new JLabel("val2");
		lblVal2.setBounds(10, 179, 74, 14);
		getContentPane().add(lblVal2);

		JList list = new JList();
		list.setBounds(355, 103, 102, -68);
		getContentPane().add(list);

		lstEmpleados = new JList();
		lstEmpleados.setBounds(318, 33, 191, 173);
		getContentPane().add(lstEmpleados);

		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setBounds(321, 18, 88, 14);
		getContentPane().add(lblEmpleados);

		JTextArea txaResultado = new JTextArea();
		txaResultado.setBounds(10, 237, 485, 85);
		getContentPane().add(txaResultado);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdAdmininistrativo.isSelected()) {
					rdContratado.setSelected(false);
					Administrativo adm = new Administrativo(txtDni.getText(), txtNombre.getText(),
							Float.valueOf(txtVal1.getText()), Float.valueOf(txtVal2.getText()));
					sistema.empleados.add(adm);
					cargaLista();
				} else {
					rdAdmininistrativo.setSelected(false);
					Contratado con = new Contratado(txtDni.getText(), txtNombre.getText(),
							Float.valueOf(txtVal1.getText()), Float.valueOf(txtVal2.getText()));
					sistema.empleados.add(con);
					cargaLista();
				}
				
			}
		});
		
		
		
		rdAdmininistrativo = new JRadioButton("Administrativo");
		rdAdmininistrativo.setBounds(84, 91, 109, 23);
		getContentPane().add(rdAdmininistrativo);
		rdAdmininistrativo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdAdmininistrativo.isSelected()) {
					rdContratado.setSelected(false);
					lblVal1.setText("Sueldo Basico:");
					lblVal2.setText("Descuentos:");
				}
			}
		});
		rdContratado.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				 if (rdContratado.isSelected()) {
						rdAdmininistrativo.setSelected(false);
						lblVal1.setText("Valor Hora:");
						lblVal2.setText("Horas:");
					}
			}
		});
		btnAgregar.setBounds(186, 146, 122, 23);
		getContentPane().add(btnAgregar);

		JButton btnCalcularsueldo = new JButton("CalcularSueldo");
		btnCalcularsueldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Empleado e1 : sistema.empleados)
					txaResultado.setText(txaResultado.getText() + "\n" + e1.dni + " - " + e1.nombre + " - Sueldo: " + e1.calcularSueldo());
				txaResultado.setText(txaResultado.getText() + "\n Sueldos Totales: " + sistema.calcularSueldo());
			}
		});
		btnCalcularsueldo.setBounds(186, 175, 122, 30);
		getContentPane().add(btnCalcularsueldo);
		rdAdmininistrativo.setSelected(true);
		
	}
	
	public void cargaLista() {
		txtDni.setText("");
		txtNombre.setText("");
		txtVal1.setText("");
		txtVal2.setText("");
		lmodel.removeAllElements();
		for (Empleado e : sistema.empleados)
			lmodel.addElement(e.dni + " - " + e.nombre);
		lstEmpleados.setModel(lmodel);
		lstEmpleados.repaint();
	}
}

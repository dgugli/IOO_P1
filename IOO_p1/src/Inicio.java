import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Inicio {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		Ventana abm = new Ventana();
		abm.setTitle("ABM Empleados");
		abm.pack();
		abm.setBounds(0,0, 589, 387);
		abm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		abm.setLocationRelativeTo(null);
		abm.setVisible(true);

	}

}

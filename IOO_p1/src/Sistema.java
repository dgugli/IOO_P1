import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

	List<Empleado> empleados = new ArrayList<>();
	
	public Sistema() {
	}
	
	public void altaAdm(String dni, String nombre, float sueldo, float descuento) {
		Administrativo adm = new Administrativo(dni,nombre,sueldo,descuento);
		empleados.add(adm);
	}
	
	public void altaCon(String dni, String nombre, float valorH, float horas) {
		Contratado con = new Contratado(dni, nombre, valorH, horas);
		empleados.add(con);
		
	}
	
	public float calcularSueldo() {
		float acum = 0;
		for (Empleado e : empleados)
			acum += e.calcularSueldo();
		
		return acum;
	}
}

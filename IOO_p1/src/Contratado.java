
public class Contratado extends Empleado {
	private float valorHora;
	private float horas;
	
	public Contratado(String dni, String nombre, float valorH, float horas) {
		super(dni,nombre);
		this.valorHora = valorH;
		this.horas = horas;
	}
	
	@Override
	public float calcularSueldo() {
		return valorHora*horas;
	}

}

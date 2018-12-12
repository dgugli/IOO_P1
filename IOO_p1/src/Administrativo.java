
public class Administrativo extends Empleado {

	private float sueldoBasico;
	private float descuentos;
	
	public Administrativo(String dni, String nombre, float sdo, float desc) {
		super(dni,nombre);
		this.sueldoBasico = sdo;
		this.descuentos = desc;
		
	}
	@Override
	public float calcularSueldo() {
		return sueldoBasico-descuentos;
	}
	
	public float getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	public float getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(float descuentos) {
		this.descuentos = descuentos;
	}
	
	

}

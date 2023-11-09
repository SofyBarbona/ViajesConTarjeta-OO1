package modelo;

import java.time.LocalDateTime;

public class Viaje {
	private Tarjeta tarjeta;
	private String linea;
	private String medio;
	private LocalDateTime fechaHoraViaje;
	private double precio;
	
	public Viaje(Tarjeta tarjeta, String linea, String medio, LocalDateTime fechaHoraViaje, double precio) throws Exception {
		super();
		this.tarjeta = tarjeta;
		this.linea = linea;
		this.medio = medio;
		this.fechaHoraViaje = fechaHoraViaje;
		this.setPrecio(precio);
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public LocalDateTime getFechaHoraViaje() {
		return fechaHoraViaje;
	}

	public void setFechaHoraViaje(LocalDateTime fechaHoraViaje) {
		this.fechaHoraViaje = fechaHoraViaje;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) throws Exception {
		if(precio <= 0) throw new Exception("Error, el viaje es incorrecto por precio erroneo");
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Viaje [tarjeta=" + tarjeta + ", linea=" + linea + ", medio=" + medio + ", fechaHoraViaje="
				+ fechaHoraViaje + ", precio=" + precio + "]";
	}

	
	
	
	
}

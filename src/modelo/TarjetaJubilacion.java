package modelo;

public class TarjetaJubilacion extends Tarjeta {
	private double porcentajeDeDescuento;
	
	public TarjetaJubilacion(String codigo, int id, boolean descuentoActivo, double porcentajeDeDescuento) {
		super(codigo, id, descuentoActivo);
		this.porcentajeDeDescuento = porcentajeDeDescuento;
	}

	public double getPorcentajeDeDescuento() {
		return porcentajeDeDescuento;
	}

	public void setPorcentajeDeDescuento(double porcentajeDeDescuento) {
		this.porcentajeDeDescuento = porcentajeDeDescuento;
	}

	@Override
	public String toString() {
		return super.toString() + "TarjetaJubilacion [porcentajeDeDescuento=" + porcentajeDeDescuento + "]";
	}
	
	
	
}

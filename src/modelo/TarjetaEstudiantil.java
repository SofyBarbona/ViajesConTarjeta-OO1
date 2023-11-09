package modelo;

public class TarjetaEstudiantil extends Tarjeta{
	private double saldoAFavor;

	public TarjetaEstudiantil(String codigo, int id, boolean descuentoActivo, double saldoAFavor) {
		super(codigo, id, descuentoActivo);
		this.saldoAFavor = saldoAFavor;
	}

	public double getSaldoAFavor() {
		return saldoAFavor;
	}

	public void setSaldoAFavor(double saldoAFavor) {
		this.saldoAFavor = saldoAFavor;
	}

	@Override
	public String toString() {
		return super.toString() + "TarjetaEstudiantil [saldoAFavor=" + saldoAFavor + "]";
	}
	
	
}

package modelo;

public abstract class Tarjeta {
	protected String codigo;
	protected int id;
	protected boolean descuentoActivo;
	
	public Tarjeta(String codigo, int id, boolean descuentoActivo) {
		super();
		this.codigo = codigo;
		this.id = id;
		this.descuentoActivo = descuentoActivo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDescuentoActivo() {
		return descuentoActivo;
	}

	public void setDescuentoActivo(boolean descuentoActivo) {
		this.descuentoActivo = descuentoActivo;
	}

	@Override
	public String toString() {
		return "Tarjeta [codigo=" + codigo + ", id=" + id + ", descuentoActivo=" + descuentoActivo + "]";
	}
	
	
}

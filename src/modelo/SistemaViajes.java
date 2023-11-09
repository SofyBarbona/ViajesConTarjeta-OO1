package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaViajes {
	private List<Tarjeta> tarjetas;
	private List<Viaje> viajes;
	
	public SistemaViajes() {
		super();
		this.tarjetas = new ArrayList<Tarjeta>();
		this.viajes = new ArrayList<Viaje>();
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	@Override
	public String toString() {
		return "SistemaViajes [tarjetas=" + tarjetas + ", viajes=" + viajes + "]";
	}
	
	public Tarjeta traerTarjeta(String codigo) {
		Tarjeta tarjeta = null;
		
		int i = 0;
		while(i < this.tarjetas.size() && tarjeta == null) {
			if(this.tarjetas.get(i).getCodigo().equals(codigo)) {
				tarjeta = this.tarjetas.get(i);
			}
			i = i + 1;
		}
		return tarjeta;
	}
	
	public boolean agregarTarjetaEstudiantil(String codigo, double saldoAFavor, boolean descuentoActivo) throws Exception {
		if(this.traerTarjeta(codigo) != null) throw new Exception("Error, ya existe una tarjeta con el mismo código");
		
		int idTarjeta = 1;
		if(this.tarjetas.size() > 0) {
			idTarjeta = this.tarjetas.get(this.tarjetas.size()-1).getId() + 1;
		}
		
		return this.tarjetas.add(new TarjetaEstudiantil(codigo, idTarjeta, descuentoActivo, saldoAFavor));
	}
	
	public boolean agregarTarjetaJubilacion(String codigo, double porcentajeDeDescuento, boolean descuentoActivo) throws Exception {
		if(this.traerTarjeta(codigo) != null) throw new Exception("Error, ya existe una tarjeta con el mismo código");
		
		int idTarjeta = 1;
		if(this.tarjetas.size() > 0) {
			idTarjeta = this.tarjetas.get(this.tarjetas.size()-1).getId() + 1;
		}
		
		return this.tarjetas.add(new TarjetaJubilacion(codigo, idTarjeta, descuentoActivo, porcentajeDeDescuento));
	}
	
	public boolean agregarViaje(Tarjeta tarjeta, String linea, String medio, LocalDateTime fechaHoraViaje, double precio) throws Exception {
		return this.viajes.add(new Viaje(tarjeta, linea, medio, fechaHoraViaje, precio));
	}
	
	public List<Viaje> traerViaje(LocalDateTime desde, LocalDateTime hasta){
		List<Viaje> lstViajesEntre = new ArrayList<Viaje>();
		
		for(int i=0;i<this.viajes.size();i++) {
			if(!this.viajes.get(i).getFechaHoraViaje().isBefore(desde) && !this.viajes.get(i).getFechaHoraViaje().isAfter(hasta)) {
				lstViajesEntre.add(this.viajes.get(i));
			}
		}
		
		return lstViajesEntre;
	}
	
	public List<Viaje> traerViajeTarjetaEstudiantil(LocalDateTime desde, LocalDateTime hasta){
		List<Viaje> lstViajesEstudiantilEntre = new ArrayList<Viaje>();
		List<Viaje> lstViajesEntre = this.traerViaje(desde, hasta);
		
		for(int i = 0;i<lstViajesEntre.size();i++) {
			if(lstViajesEntre.get(i).getTarjeta() instanceof TarjetaEstudiantil) {
				lstViajesEstudiantilEntre.add(lstViajesEntre.get(i));
			}
		}
		
		return lstViajesEstudiantilEntre;
	}
	
	public List<Tarjeta> traerTarjetaJubilacionActivasConPorcentajeMayorA(double porcentajeMayorA){
		List<Tarjeta> lstJubilacionActivasConPorcentajeMayorA = new ArrayList<Tarjeta>();
		
		for(int i=0;i<this.tarjetas.size();i++) {
			if(this.tarjetas.get(i) instanceof TarjetaJubilacion) {
				TarjetaJubilacion tarjetaJubilacion = (TarjetaJubilacion) this.tarjetas.get(i);
				
				if(tarjetaJubilacion.isDescuentoActivo() && tarjetaJubilacion.getPorcentajeDeDescuento() > porcentajeMayorA) {
					lstJubilacionActivasConPorcentajeMayorA.add(tarjetaJubilacion);
				}
				
			}
		}
		
		return lstJubilacionActivasConPorcentajeMayorA;
	}
}

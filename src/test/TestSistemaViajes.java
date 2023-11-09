package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import modelo.SistemaViajes;

public class TestSistemaViajes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaViajes sistema = new SistemaViajes();
		
		System.out.println("\nParcial corto (primer parcial ausente, segundo aprobado): CasosDeUso 1,2,3,4,5,6,11 y Ejercicios 1,2,3,4,5,6,8");
		System.out.println("\n-----------EJERCICIO 1-----------");
		try {
			sistema.agregarTarjetaEstudiantil("11111111", 1000, true);
			sistema.agregarTarjetaJubilacion("22222222", 40, false);
			sistema.agregarTarjetaJubilacion("33333333", 50, true);
			sistema.agregarTarjetaEstudiantil("44444444", 80, true);
			sistema.agregarTarjetaJubilacion("55555555", 40, true);
			sistema.agregarTarjetaJubilacion("66666666", 60, true);
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		System.out.println(sistema.getTarjetas());
		
		System.out.println("\n-----------EJERCICIO 2-----------");
		try {
			sistema.agregarTarjetaEstudiantil("11111111", 1000, true);
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		System.out.println("\n-----------EJERCICIO 3-----------");
		try {
			sistema.agregarViaje(sistema.traerTarjeta("11111111"), "linea 1", "medio 1", LocalDateTime.of(LocalDate.of(2023, 9, 1), LocalTime.of(10, 00)), 50);
			sistema.agregarViaje(sistema.traerTarjeta("11111111"), "linea 2", "medio 2", LocalDateTime.of(LocalDate.of(2023, 9, 1), LocalTime.of(10, 30)), 50);
			sistema.agregarViaje(sistema.traerTarjeta("22222222"), "linea 1", "medio 1", LocalDateTime.of(LocalDate.of(2023, 9, 1), LocalTime.of(10, 00)), 60);
			sistema.agregarViaje(sistema.traerTarjeta("22222222"), "linea 3", "medio 3", LocalDateTime.of(LocalDate.of(2023, 9, 2), LocalTime.of(11, 00)), 100);
			sistema.agregarViaje(sistema.traerTarjeta("33333333"), "linea 2", "medio 2", LocalDateTime.of(LocalDate.of(2023, 9, 2), LocalTime.of(15, 00)), 60);
			sistema.agregarViaje(sistema.traerTarjeta("33333333"), "linea 3", "medio 3", LocalDateTime.of(LocalDate.of(2023, 9, 3), LocalTime.of(22, 00)), 60);
			sistema.agregarViaje(sistema.traerTarjeta("44444444"), "linea 2", "medio 2", LocalDateTime.of(LocalDate.of(2023, 9, 2), LocalTime.of(10, 30)), 100);
			sistema.agregarViaje(sistema.traerTarjeta("44444444"), "linea 3", "medio 3", LocalDateTime.of(LocalDate.of(2023, 9, 3), LocalTime.of(10, 00)), 100);
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		System.out.println(sistema.getViajes());
		
		System.out.println("\n-----------EJERCICIO 4-----------");
		try {
			sistema.agregarViaje(sistema.traerTarjeta("11111111"), "linea 1", "medio 1", LocalDateTime.of(LocalDate.of(2023, 9, 1), LocalTime.of(10, 00)), -10);
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		System.out.println("\n-----------EJERCICIO 5-----------");
		System.out.println(sistema.traerViaje(LocalDateTime.of(LocalDate.of(2023, 9, 2), LocalTime.of(10, 30)), LocalDateTime.of(LocalDate.of(2023, 9, 3), LocalTime.of(10, 00))));
		
		System.out.println("\n-----------EJERCICIO 6-----------");
		System.out.println(sistema.traerViajeTarjetaEstudiantil(LocalDateTime.of(LocalDate.of(2023, 9, 2), LocalTime.of(10, 30)), LocalDateTime.of(LocalDate.of(2023, 9, 3), LocalTime.of(10, 00))));
		
		System.out.println("\n-----------EJERCICIO 8-----------");
		System.out.println(sistema.traerTarjetaJubilacionActivasConPorcentajeMayorA(40));
		
	}

}

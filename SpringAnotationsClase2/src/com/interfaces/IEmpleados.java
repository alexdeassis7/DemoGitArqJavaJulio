package com.interfaces;

//creamos una abstraccion , que tiene el metodo getTareas() y getInforme()
public interface IEmpleados {
	public String getTareas();

	// este metodo lo utilizaremos para la DI (Inyeccion de dependencias )
	public String getInforme();
}

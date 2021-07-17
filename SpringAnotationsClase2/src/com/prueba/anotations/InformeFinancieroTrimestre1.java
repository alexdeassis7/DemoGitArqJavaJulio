package com.prueba.anotations;

import org.springframework.stereotype.Component;

import com.interfaces.CreacionInformesFinancieros;

//esta clase es la dependencia de la clase comercialexperimentado 

@Component
//con @Component registramos la clase en el contenedor de Spring 
public class InformeFinancieroTrimestre1 implements CreacionInformesFinancieros{
	
	@Override
	public String getInformeFinanciero() {
		return "presentacion del informe financiero del primer trimestre del año";
	}
	
}

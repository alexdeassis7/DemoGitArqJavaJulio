package com.prueba.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.interfaces.IEmpleados;

public class DemoUsoAnotations {
	public static void main(String[] args) {
		// 1 ) cargamos el xml de configuracion de Spring
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2)solicitamos el bean al contenedor de Spring
		IEmpleados comercial = contexto.getBean("comercialExperimentado", IEmpleados.class);

		// 3) Utilizamos el bean
		System.out.println("Utilizamos nuestro bean con Anotaciones!");
		System.out.println(comercial.getTareas());
		System.out.println(comercial.getInforme());

		// 4) cerramos el contexto , para liberar recursos
		contexto.close();

	}
}

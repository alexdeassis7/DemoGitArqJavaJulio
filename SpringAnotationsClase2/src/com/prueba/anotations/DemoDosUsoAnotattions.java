package com.prueba.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interfaces.IEmpleados;

public class DemoDosUsoAnotattions {
	// demostracion de anotation @Scope
	public static void main(String[] args) {

		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

		IEmpleados comercialJose = contexto.getBean("comercialExperimentado", IEmpleados.class);
		IEmpleados comercialPedro = contexto.getBean("comercialExperimentado", IEmpleados.class);

		// comporbamos si los dos objetos apuntan a la misma direccion de memoria
		System.out.println("Direcciones de memoria :");
		System.out.println(comercialJose + "\n" + comercialPedro);
		if (comercialJose == comercialPedro) {
			System.out.println("singleton : apuntan al mismo lugar de memoria ");
		} else {
			System.out
					.println("prototype : apuntan a distintos lugares de memoria," + "son dos instancias diferentes  ");
		}

		contexto.close();
	}

}

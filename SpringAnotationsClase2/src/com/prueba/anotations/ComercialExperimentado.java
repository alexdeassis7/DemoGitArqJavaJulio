package com.prueba.anotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.interfaces.CreacionInformesFinancieros;
import com.interfaces.IEmpleados;

//Utilizamos una anotation @Component y le definimos un id "comercialExperimentado", no es necesario que 
//el nombre coincida con el nombre de la clase , una vez importanda la anotation ya tendriamos registrado 
//nuestro bean 
@Component("comercialExperimentado")
//podemos presindir de darle un nombre o un id al componente , en ese caso Spring tomaria como 
//id al  nombre de la clase pero con la primer letra en minuscula ,
//entoces se vuelve muy importante erscribir bien el nombre de nuestras clases , para no tener 
//problemas luego a la hora de solicitar nuestros beans 
//ej @Component()

//demo @Scope , lo modificamos para que sea capaz de crear varias instancias
//@Scope("prototype")
public class ComercialExperimentado implements IEmpleados {

	// creacion de atributo de tipo "CreacionInformeFinanciero"
	// para inyeccion de dependencias
	private CreacionInformesFinancieros informeNuevo;

	// el @Override chequea que exita el metodo en la clase padre , no es
	// obligatorio utilizarlo pero si recomendable
	@Override
	public String getTareas() {
		return "soy un vendedor y me encargo de vender mucho!";
	}

	// creamos un constructor para que a traves de este podamos inyectar la
	// dependencia con la anotacion
	// @Autowired , spring busca en mi proyecto si existe una clase que implemente
	// la interface informeFinanciero y si
	// la encuentra es de esa clases de donde obtiene la inyeccion de dependencia
	// ,una vez que spring detecta
	// la clase solamente deberiamos llamar al metodo getInforme()
	@Autowired
	// si comentamos el @Autowired todo seguira funcionando , enb la ultimas
	// versiones de Spring no es
	// necesario utilizarlo si el bean que necesita utilizar la Inyeccion de
	// dependencia
	// define solamente un UNICO CONSTRUCTOR y es justo nuestro caso
	// como recomendacion Utilicen simepre el @Autowired para que a la hora de
	// escalar
	// la aplicacion y agregar mas constructores no nos olvidemos y tengamos
	// problemas.
	// *Autowired tambien se puede implementar en Atributos (gracias al concepto de
	// reflexion) e incluso en los Setters
	public ComercialExperimentado(CreacionInformesFinancieros informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	@Override
	public String getInforme() {
		// utilizamos el metodo getInforme de la interface (Sin la inyeccion de
		// dependencia )
//		return "Informe creado por el comercial con mucha experiencia ";

		// ahora lo hacemos con la inyeccion de dependencias (osea con el @Autowired ya
		// implementado )
		return informeNuevo.getInformeFinanciero();
	}

	// para usar @PostConsttruct y @PreDestroyd SI O SI debemos utilizar el scope
	// SIGLETON , esto se debe a que spring no controla el ciclo de vida por
	// completyo del
	// bean si trabajamos con un scope PROTOTYPE

	// ejecucion de codigo despues de la creacion del bean
	// este codigo se ejecuta despues de la construccion del bean
	@PostConstruct
	public void ejecutaDespuesCreacion() {
		System.out.println("ejecutando tras la creacion del bean ");
	}

	// ejcucion de codigo despues del apagado del contenedor de Spring
	@PreDestroy
	public void ejecutaAntesCreacion() {
		System.out.println("ejecutando tareas magicas antes de la destruccion");
	}
}

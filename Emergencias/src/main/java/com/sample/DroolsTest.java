package com.sample;

import java.time.LocalDateTime;

import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 * @author: Nicolás Lambertucci, Nicolás Núñez, Agustín Dávila, Leandro Sgroi.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

        	kSession.addEventListener( new DebugAgendaEventListener() );
			kSession.addEventListener( new DebugRuleRuntimeEventListener() );

        	KieRuntimeLogger logger = ks.getLoggers().newFileLogger( kSession, "./helloworld" );
        	
        	// Prueba con paciente con problemas cardíacos
        	crearPacienteCardiaco(kSession);
        	
        	//Prueba con paciente menor a 15 años para derivación Notti
        	crearMenorEdad(kSession);
        	
        	//Paciente Codigo Rojo o Amarillo distinto de infarto
        	crearCodigoRojoOAmarillo(kSession);
        	
        	//Paciente con COVID-19
        	crearPacienteCovid(kSession);
        	
        	//Paciente con traslado
        	crearPacienteConTraslado(kSession);
        	
        	//Paciente con quemaduras
        	crearPacienteConQuemaduras(kSession);
        	
        	kSession.dispose();
        	logger.close();
        	
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    //Llamadas a las reglas.
    
    public static void crearPacienteCardiaco(KieSession kSession) {
    	Paciente pacienteNico = pacienteNicoLamber();
    	Motivo motivo1 = motivo2();
    	Domicilio domicilioNico = new Domicilio("Lafinur",1093,Localidad.DORREGO);
    	Despacho despachoNico = new Despacho();
    	despachoNico.setFechaHora(LocalDateTime.parse("2020-06-23T18:24:30"));
    	
    	Recepcion recepcionNico = new Recepcion();
    	recepcionNico.setNumeroRecepcion(1);
    	recepcionNico.setDomicilio(domicilioNico);
    	recepcionNico.setPaciente(pacienteNico);
    	recepcionNico.setMotivo(motivo1);
    	recepcionNico.setDespacho(despachoNico);
    	
    	kSession.insert(recepcionNico);		
    	kSession.fireAllRules();
    }
    
    public static void crearCodigoRojoOAmarillo(KieSession kSession) {
    	Paciente pacienteNunez = pacienteNicoNunez();
    	Motivo motivoNunez = motivo5();
    	Domicilio domicilioNunez = new Domicilio("Avenida San Martin",1788,Localidad.TUNUYAN);
    	Despacho despachoNunez = new Despacho();
    	despachoNunez.setFechaHora(LocalDateTime.parse("2020-04-26T12:45:33"));
    	
    	Recepcion recepcionNunez = new Recepcion();
    	recepcionNunez.setNumeroRecepcion(3);
    	recepcionNunez.setDomicilio(domicilioNunez);
    	recepcionNunez.setPaciente(pacienteNunez);
    	recepcionNunez.setMotivo(motivoNunez);
    	recepcionNunez.setDespacho(despachoNunez);
    	
    	kSession.insert(recepcionNunez);
    	kSession.fireAllRules();
    }
    
    public static void crearMenorEdad(KieSession kSession) {
    	
    	Paciente pacienteThiago = pacienteThiagoMessi();
    	Motivo motivoThiago = motivo3();
    	Domicilio domicilioThiago = new Domicilio("Patricias Mendocinas",742, Localidad.JUNIN);
    	Despacho despachoThiago = new Despacho();
    	despachoThiago.setFechaHora(LocalDateTime.parse("2020-06-15T05:12:00"));
    	
    	Recepcion recepcionThiago = new Recepcion();
    	recepcionThiago.setNumeroRecepcion(2);
    	recepcionThiago.setDomicilio(domicilioThiago);
    	recepcionThiago.setPaciente(pacienteThiago);
    	recepcionThiago.setMotivo(motivoThiago);
    	recepcionThiago.setDespacho(despachoThiago);
    	
    	kSession.insert(recepcionThiago);		
    	kSession.fireAllRules();
    }
    
    public static void crearPacienteCovid(KieSession kSession) {
    	Paciente pacienteLeandro = pacienteLeanSgroi();
    	Motivo motivoLean = motivo3();
    	Domicilio domicilioLean = new Domicilio("Manuel Belgrano",97,Localidad.JUNIN);
    	Despacho despachoLean = new Despacho();
    	despachoLean.setFechaHora(LocalDateTime.parse("2020-06-12T18:33:20"));
    	
    	Recepcion recepcionLean = new Recepcion();
    	recepcionLean.setNumeroRecepcion(4);
    	recepcionLean.setDomicilio(domicilioLean);
    	recepcionLean.setPaciente(pacienteLeandro);
    	recepcionLean.setMotivo(motivoLean);
    	recepcionLean.setDespacho(despachoLean);
    	
    	kSession.insert(recepcionLean);
    	kSession.fireAllRules();
    }
    
    public static void crearPacienteConTraslado(KieSession kSession) {
    	
    	Paciente pacienteAgustin = pacienteAgusDavila();
    	Motivo motivoAgus = motivo9();
    	Domicilio domicilioAgus = new Domicilio("Gutierrez",457,Localidad.LAS_CANIAS);
    	Despacho despachoAgus = new Despacho();
    	despachoAgus.setFechaHora(LocalDateTime.parse("2020-06-25T09:00:00"));
    	
    	Recepcion recepcionAgus = new Recepcion();
    	recepcionAgus.setNumeroRecepcion(5);
    	recepcionAgus.setDomicilio(domicilioAgus);
    	recepcionAgus.setPaciente(pacienteAgustin);
    	recepcionAgus.setMotivo(motivoAgus);
    	recepcionAgus.setDespacho(despachoAgus);
    	
    	kSession.insert(recepcionAgus);
    	kSession.fireAllRules();
    }
    
    public static void crearPacienteConQuemaduras(KieSession kSession) {

    	Paciente pacienteCarlos = pacienteCarlosMartinez();
    	Motivo motivoCarlos = motivo7();
    	Domicilio domicilioCarlos =  new Domicilio("Los viñedos",3312,Localidad.SAN_CARLOS);
    	Despacho despachoCarlos = new Despacho();
    	despachoCarlos.setFechaHora(LocalDateTime.parse("2020-02-14T09:00:00"));
    	
    	Recepcion recepcionCarlos = new Recepcion();
    	recepcionCarlos.setNumeroRecepcion(6);
    	recepcionCarlos.setDomicilio(domicilioCarlos);
    	recepcionCarlos.setPaciente(pacienteCarlos);
    	recepcionCarlos.setMotivo(motivoCarlos);
    	recepcionCarlos.setDespacho(despachoCarlos);
    	
    	kSession.insert(recepcionCarlos);
    	kSession.fireAllRules();
    }
    
    
    
    //Seteamos diferentes Hospitales para poder configurar las reglas
    
    public static Institucion hospitalCentral() {
    	return new Institucion("Hospital Central");
    }
    public static Institucion clinicaDeCuyo() {
    	return new Institucion("Clínica de Cuyo");
    }
    public static Institucion hospitalItaliano() {
    	return new Institucion("Hospital Italiano");
    }
    public static Institucion hospitalPerrupato() {
    	return new Institucion("Hospital Perrupato");
    }
    
   public static Institucion hospitalScaravelli() {
	   return new Institucion ("Hospital Antonio Scaravelli");
   }
   public static Institucion hospitalNotti() {
   	return new Institucion("Hospital Notti");
   }
   
   //seteamos diferentes Motivos para las reglas. 
   
   public static Motivo motivo1() {
   	return new Motivo("ACV",Codigo.ROJO);
   }
   public static Motivo motivo2() {
   	return new Motivo("INFARTO",Codigo.ROJO);
   }
   public static Motivo motivo3() {
   	return new Motivo("COVID-19",Codigo.AMARILLO);
   }
   public static Motivo motivo4() {
   	return new Motivo("FIEBRE",Codigo.VERDE);
   }
   public static Motivo motivo5() {
   	return new Motivo("MALESTAR GENERAL",Codigo.VERDE);
   }
   public static Motivo motivo6() {
   	return new Motivo("VOMITOS",Codigo.VERDE);
   }
   public static Motivo motivo7() {
	 return new Motivo("QUEMADURAS",Codigo.AMARILLO);
   }
	public static Motivo motivo8() {
		return new Motivo("TAQUICARDIA",Codigo.AMARILLO);
	}
	public static Motivo motivo9() {
		return new Motivo("ACCIDENTE DE AUTO",Codigo.TRASLADO);
	}
	
	
	//Seteo de Bases para las reglas.
	public static Base baseGranMendoza() {
		return new Base("Mendoza Capital");
	}
	public static Base baseTunuyan() {
		return new Base("Valle de Uco (Tunuyan)");
	}
	
	//Pacientes para probar las reglas
	
	public static Paciente pacienteNicoLamber(){
		return new Paciente("Nicolás","Lambertucci",24,39076554,'M',123456789L);
	}
	public static Paciente pacienteNicoNunez(){
		return new Paciente("Nicolás","Núñez",24,39234567,'M',123987654L);
	}
	public static Paciente pacienteLeanSgroi(){
		return new Paciente("Leandro","Sgroi",23,40123456,'M',132465879L);
	}
	public static Paciente pacienteAgusDavila(){
		return new Paciente("Agustín","Dávila",23,40333444,'M',156789076L);
	}
	public static Paciente pacienteThiagoMessi() {
		return new Paciente("Thiago","Messi",6,56789008,'M',153446778L);
	}
	public static Paciente pacienteCarlosMartinez() {
		return new Paciente("Carlos","Martinez",42,27896778,'M',152789007L);
	}
}

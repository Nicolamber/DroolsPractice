package com.sample;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
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

			// To setup a file based audit logger, uncomment the next line
			KieRuntimeLogger logger = ks.getLoggers().newFileLogger( kSession, "./helloworld" );
			
			
        	Order silverOrder = getOrderWithSilverCustomer();
            kSession.insert(silverOrder);
            kSession.fireAllRules();
            
        	Order goldOrder = getOrderWithGoldCustomer();
            kSession.insert(goldOrder);
            kSession.fireAllRules();
            
            Order tenProductsOrder = getOrderWithGoldCustomerAndTenProductsInSeptember();
            kSession.insert(tenProductsOrder);
            kSession.fireAllRules();

           
            logger.close();
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static Order getOrderWithDefaultCustomer() {
		final Order order = new Order(getDefaultCustomer());
		order.addProduct(getProduct1());
		order.setMonth(Month.AGOSTO);
		return order;
	}
 
	private static Order getOrderWithSilverCustomer() {
		final Order order = new Order(getSilverCustomer());
		order.addProduct(getProduct1());
		order.setMonth(Month.SEPTIEMBRE);
		return order;
	}
 
	private static Order getOrderWithGoldCustomer() {
		final Order order = new Order(getGoldCustomer());
		order.addProduct(getProduct1());
		order.setMonth(Month.MARZO);
		return order;
	}
	
	private static Order getOrderWithGoldCustomerAndTenProductsInSeptember() {
		final Order order = new Order(getGoldCustomer());
		for (int i = 0; i < 11; i++) {
			order.addProduct(getProduct1());
		}
		order.setMonth(Month.SEPTIEMBRE);
		return order;
	}
 
	private static Order getOrderWithGoldCustomerAndTenProducts() {
		final Order order = new Order(getGoldCustomer());
		order.setMonth(Month.DICIEMBRE);
		for (int i = 0; i < 15; i++) {
			order.addProduct(getProduct1());
		}
		return order;
	}
 
	private static Customer getDefaultCustomer() {
		return new Customer(Customer.DEFAULT_CUSTOMER, "Cliente estandar");
	}
 
	private static Customer getSilverCustomer() {
		return new Customer(Customer.SILVER_CUSTOMER, "Cliente SILVER");
	}
 
	private static Customer getGoldCustomer() {
		return new Customer(Customer.GOLD_CUSTOMER, "Cliente GOLD");
	}
 
	private static Product getProduct1() {
		return new Product(1, "Producto 1", 100d);
	}
 
	private static void showResults(List<Order> orders) {
		for (Order order : orders) {
			System.out.println("Cliente " + order.getCustomer() + " productos: " + order.getProducts().size()
					+ " Precio total: " + order.getTotalPrice());
		}
	}
}

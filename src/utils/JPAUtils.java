package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	private static final String UNIDAD_DE_PERSISTENCIA ="proyecto";
	private static EntityManagerFactory factory;
	
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
		}
		System.out.println("la conexion "+factory);
		return factory;
	}
	
	
}

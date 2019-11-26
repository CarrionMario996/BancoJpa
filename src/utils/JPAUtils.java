package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
private static final String NOMBRE_UNIDAD_PERSISTENCIA="WSInsert_transaction";
private static EntityManagerFactory emf;
public static EntityManagerFactory getEntityManagerFactory() {
	if(emf==null) {
		emf=Persistence.createEntityManagerFactory(NOMBRE_UNIDAD_PERSISTENCIA);
	}
	return emf;
}

}

package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory FABRICA = Persistence.createEntityManagerFactory("gravadora");
	
	public static EntityManager getEntityManager() {
		return FABRICA.createEntityManager();
	}
}

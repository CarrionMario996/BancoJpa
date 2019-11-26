package dao;



import javax.persistence.EntityManager;


public abstract class AbstractFacade<T> {
	public Class<T> entityClass;

	public AbstractFacade(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	public boolean create(T entity) {
		EntityManager em = getEntityManager();
		boolean flag = false;
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			if (em.getTransaction() != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}

		}
		return flag;
	}

}

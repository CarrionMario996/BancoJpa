package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import entity.Cliente;
import utils.JPAUtils;

public class ClienteFacade extends AbstractFacade<Cliente> implements Serializable{

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	
	public ClienteFacade() {
		super(Cliente.class);
		getEntityManager();
	}


	@Override
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = JPAUtils.getEntityManagerFactory().createEntityManager();
		}
		
		return em;
	}
	
	

}

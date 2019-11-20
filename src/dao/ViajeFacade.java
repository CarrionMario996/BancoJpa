package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import entity.Viaje;
import utils.JPAUtils;

public class ViajeFacade extends AbstractFacade<Viaje>implements Serializable{

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public ViajeFacade() {
		super(Viaje.class);
		getEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() {
		if(em==null) {
			em=JPAUtils.getEntityManagerFactory().createEntityManager();
		}
		return em;
	}

}

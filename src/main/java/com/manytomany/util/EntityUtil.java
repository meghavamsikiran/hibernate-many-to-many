package com.manytomany.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityUtil {
	
	public static EntityManager getEntityManager()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manytomany");
		EntityManager em = emf.createEntityManager();
		return em;
	}
}

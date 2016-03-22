package org.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lrvera
 */
public class UtilidadDAO {

    public static EntityManager getEntityManager() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContabilidadPU");
        return emf.createEntityManager();
    }
}

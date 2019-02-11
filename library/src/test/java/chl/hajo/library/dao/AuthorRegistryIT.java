package chl.hajo.library.dao;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Some testing of classes. Using JUnit (so run outside container)
 * Not much used here, see later at databases
 * @author hajo
 */
public class AuthorRegistryIT {

    static AuthorRegistry areg;
    static EntityManager em;

    @BeforeClass
    public static void setUpClass() throws NamingException {
      
    }

    @AfterClass
    public static void tearDownClass() {
        em.close();
    }

    @Test
    public void testCreateCountDelete() throws Exception {
       
    }

    public void testSelctFromTo() throws Exception {

    }


}

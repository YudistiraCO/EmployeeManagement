/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import DAO.DAOLogin;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yudistira CO
 */
public class TblHrdTest {
    
    public TblHrdTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save_hrd method, of class TblHrd.
     */
    @Test
    public void testSave_hrd() {
        System.out.println("save_hrd");

        TblHrd newtblHrd = new TblHrd ();
        newtblHrd.setUsername("Yudis");
        newtblHrd.setPassword("Yudis123");
        
        DAOLogin instance = new DAOLogin();
        boolean result = instance.add_hrd(newtblHrd);
        boolean expResult = true;
        
        assertEquals (expResult, result);
        
        
    }

    /**
     * Test of login_hrd method, of class TblHrd.
     */
    @Test
    public void testLogin_hrd() {
        System.out.println("login_hrd");
        TblHrd instance = new TblHrd();
        instance.setUsername("yasa");
        instance.setPassword("123"); 
        
        String expResult = "sukses";
        String result = instance.login_hrd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}

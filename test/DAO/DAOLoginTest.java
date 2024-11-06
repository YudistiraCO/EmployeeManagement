/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.TblHrd;

/**
 *
 * @Yudistira CO
 */
public class DAOLoginTest {
    
    public DAOLoginTest() {
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
     * Test of getBy method, of class DAOLogin.
     */
    @Test
    public void testGetBy() {
        System.out.println("getBy");
        String uName = "yasa";
        String uPass = "123";
        int empty=0;
        DAOLogin instance = new DAOLogin();
        List<TblHrd> result = instance.getBy(uName, uPass);
        System.out.println(result.toArray().length);
        assertThat(result.toArray().length, is(not(equalTo(empty))));

        
    }

    /**
     * Test of add_hrd method, of class DAOLogin.
     */
    @Test
    public void testAdd_hrd() {
        System.out.println("add_hrd");
        TblHrd newtblHrd = new TblHrd ();
        newtblHrd.setUsername("Yudis");
        newtblHrd.setPassword("Yudis123");
        
        DAOLogin instance = new DAOLogin();
        boolean result = instance.add_hrd(newtblHrd);
        boolean expResult = true;
        
        assertEquals (expResult, result);
        
        
        
        
    }
    
}

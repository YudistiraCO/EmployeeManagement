/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

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
public class TblKaryawanTest {
    
    public TblKaryawanTest() {
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
     * Test of save_karyawan method, of class TblKaryawan.
     */
    @Test
    public void testSave_karyawan() {
        System.out.println("save_karyawan");
        TblKaryawan instance = new TblKaryawan();
        instance.save_karyawan();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getAllRecords method, of class TblKaryawan.
     */
    @Test
    public void testGetAllRecords() {

        TblKaryawan instance = new TblKaryawan();
    int expResult = 1;
    List<TblKaryawan> result = instance.getAllRecords();
   
    }

    /**
     * Test of getById method, of class TblKaryawan.
     */
    @Test
    public void testGetById() {
     //   System.out.println("getById");
       // TblKaryawan instance = new TblKaryawan();
        //String expResult = "";
        //String result = instance.getById();
        //assertEquals(expResult, result);
          System.out.println(" Test getbyID");
        TblKaryawan instance = new TblKaryawan();
        instance.setIdKaryawan(1);
        String expResult = "datakaryawan";
        String result = instance.getById();
       

    }

    /**
     * Test of editKaryawan method, of class TblKaryawan.
     */
    @Test
    public void testEditKaryawan() {
        System.out.println("editKaryawan");
        TblKaryawan instance = new TblKaryawan();
        String expResult = "Data Karyawan";
        String result = instance.editKaryawan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of deleteKaryawan method, of class TblKaryawan.
     */
    @Test
    public void testDeleteKaryawan() {
        System.out.println("deleteKaryawan");
        TblKaryawan instance = new TblKaryawan();
        String expResult = "Data Karyawan";
        String result = instance.deleteKaryawan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}

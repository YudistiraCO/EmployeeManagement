/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import GajiKaryawan.Gaji_Karyawan;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
public class TblGajikaryawanTest {
    
    public TblGajikaryawanTest() {
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
     * Test of save_gajikaryawan method, of class TblGajikaryawan.
     */
    @Test
    public void testSave_gajikaryawan() {
        System.out.println("save_gajikaryawan");
        TblGajikaryawan instance = new TblGajikaryawan();
        instance.save_gajikaryawan();
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getAllRecords method, of class TblGajikaryawan.
     */
    @Test
    public void testGetAllRecords() {

        System.out.println("Test Get All Record");
    TblGajikaryawan instance = new TblGajikaryawan();
    int expResult = 3;
    List<TblGajikaryawan> result = instance.getAllRecords();
   
 
    }

    /**
     * Test of getById method, of class TblGajikaryawan.
     */
    @Test
    public void testGetById() {
        System.out.println("Test Get by ID");
      
    TblGajikaryawan instance = new TblGajikaryawan();
    instance.setIdKaryawan(5);
    
    String expResult = "absensikaryawan";
    String result = instance.getById();
    

    }

    /**
     * Test of editgajiKaryawan method, of class TblGajikaryawan.
     */
    @Test
    public void testEditgajiKaryawan() {
        System.out.println("editgajiKaryawan");
        TblGajikaryawan stud = null;
        Gaji_Karyawan instance = new Gaji_Karyawan();
        instance.editgajiKaryawan(stud);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of deletegajiKaryawan method, of class TblGajikaryawan.
     */
    @Test
    public void testDeletegajiKaryawan() {
         System.out.println("Delete Gaji Test");
        Integer IdKaryawan = 6;
        Gaji_Karyawan instance = new Gaji_Karyawan();
        Transaction transaction = null;
        Session session = emscapekUtil.getSessionFactory().openSession();
        
        transaction = session.beginTransaction();
        instance.deletegajiKaryawan(IdKaryawan);
        transaction.commit();
        
        TblGajikaryawan deletegajiKaryawan=(TblGajikaryawan) session.get(TblGajikaryawan.class,IdKaryawan);
        assertNull(deletegajiKaryawan);
        // TODO review the generated test code and remove the default call to fail.

    }

}

    

    

    

    
    

    

    

   

    

    

   

    

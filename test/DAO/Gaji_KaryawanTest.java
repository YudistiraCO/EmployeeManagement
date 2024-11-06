package DAO;

import GajiKaryawan.Gaji_Karyawan;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.TblGajikaryawan;
import pojo.emscapekUtil;

/**
 * Kelas pengujian untuk Gaji_Karyawan.
 */
public class Gaji_KaryawanTest {
    
    private Gaji_Karyawan gajiKaryawan; // Instance of Gaji_Karyawan
    private Session session; // Hibernate session for database operations

    @Before
    public void setUp() {
        gajiKaryawan = new Gaji_Karyawan();
        session = emscapekUtil.getSessionFactory().openSession();
    }
    
    @After
    public void tearDown() {
        if (session != null && session.isOpen()) {
            session.close(); // Close the session after each test
        }
    }

    /**
     * Test of retrieveTblGajikaryawan method, of class Gaji_Karyawan.
     */
    @Test
    public void testRetrieveTblGajikaryawan() {
        System.out.println("retrieveTblGajikaryawan");
        List<TblGajikaryawan> result = gajiKaryawan.retrieveTblGajikaryawan();
        
        assertNotNull("Hasil tidak boleh null.", result);
        assertFalse("Hasil tidak boleh kosong.", result.isEmpty());
    }

    /**
     * Test of getbyID method, of class Gaji_Karyawan.
     */
    @Test
    public void testGetbyID() {
        System.out.println("getbyID");
        
        // Add test data for retrieval
        TblGajikaryawan newGajiKaryawan = new TblGajikaryawan();
        newGajiKaryawan.setIdKaryawan(9);
        newGajiKaryawan.setNomorKaryawan("NK-09");
        newGajiKaryawan.setJabatan("Manager");
        newGajiKaryawan.setNamaKaryawan("Budi");
        newGajiKaryawan.setTanggalKehadiran("2024-11-01");
        newGajiKaryawan.setPekerjaan("Manager");
        newGajiKaryawan.setGaji("5000000");
        
        gajiKaryawan.add_gajikaryawan(newGajiKaryawan); // Add the new record to the database
        
        // Test retrieving the record
        List<TblGajikaryawan> result = gajiKaryawan.getbyID(9);
        
        assertNotNull("Hasil tidak boleh null.", result);
        assertFalse("Hasil harus mengandung setidaknya satu data gaji.", result.isEmpty());
    }

    /**
     * Test of deletegajiKaryawan method, of class Gaji_Karyawan.
     */
    @Test
    public void testDeletegajiKaryawan() {
        System.out.println("Delete Gaji Test");
        
        // Add test data to delete
        Integer idKaryawan = 6; // Use an ID that exists for the test
        TblGajikaryawan newGajiKaryawan = new TblGajikaryawan();
        newGajiKaryawan.setIdKaryawan(idKaryawan);
        newGajiKaryawan.setNomorKaryawan("NK-06");
        newGajiKaryawan.setJabatan("Staff");
        newGajiKaryawan.setNamaKaryawan("Joko");
        newGajiKaryawan.setTanggalKehadiran("2024-11-01");
        newGajiKaryawan.setPekerjaan("Staff");
        newGajiKaryawan.setGaji("3000000");
        
        gajiKaryawan.add_gajikaryawan(newGajiKaryawan); // Add the new record to the database

        Transaction transaction = session.beginTransaction();
        gajiKaryawan.deletegajiKaryawan(idKaryawan);
        transaction.commit();

        TblGajikaryawan deletedGajiKaryawan = (TblGajikaryawan) session.get(TblGajikaryawan.class, idKaryawan);
        assertNull("Gaji karyawan yang dihapus harus null.", deletedGajiKaryawan);
    }

    /**
     * Test of editgajiKaryawan method, of class Gaji_Karyawan.
     */
    @Test
    public void testEditgajiKaryawan() {
        System.out.println("editgajiKaryawan");
        
        // Add test data for editing
        TblGajikaryawan gajiKaryawanToEdit = new TblGajikaryawan();
        gajiKaryawanToEdit.setIdKaryawan(9);
        gajiKaryawanToEdit.setNomorKaryawan("NK-09");
        gajiKaryawanToEdit.setJabatan("Manager");
        gajiKaryawanToEdit.setNamaKaryawan("Budi");
        gajiKaryawanToEdit.setTanggalKehadiran("2024-11-01");
        gajiKaryawanToEdit.setPekerjaan("Manager");
        gajiKaryawanToEdit.setGaji("5000000");

        // First, add the record to be edited
        gajiKaryawan.add_gajikaryawan(gajiKaryawanToEdit);
        
        // Now, edit the record
        gajiKaryawanToEdit.setJabatan("Senior Manager"); // Update the jabatan
        boolean result = gajiKaryawan.editgajiKaryawan(gajiKaryawanToEdit);
        assertTrue("Pengeditan gaji karyawan harus berhasil.", result);
    }

    /**
     * Test of add_gajikaryawan method, of class Gaji_Karyawan.
     */
    @Test
    public void testAdd_gajikaryawan() {
        System.out.println("add_gajikaryawan");
        
        TblGajikaryawan newGajiKaryawan = new TblGajikaryawan();
        newGajiKaryawan.setIdKaryawan(99);
        newGajiKaryawan.setNomorKaryawan("NK-99");
        newGajiKaryawan.setJabatan("Ketua");
        newGajiKaryawan.setNamaKaryawan("Andi");
        newGajiKaryawan.setTanggalKehadiran("2024-11-01");
        newGajiKaryawan.setPekerjaan("Ketua Proyek");
        newGajiKaryawan.setGaji("7000000");
        
        boolean result = gajiKaryawan.add_gajikaryawan(newGajiKaryawan);
        assertTrue("Penambahan gaji karyawan harus berhasil.", result);
    }
}

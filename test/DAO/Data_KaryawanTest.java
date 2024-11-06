package DAO;

import DataKaryawan.Data_Karyawan;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import pojo.TblKaryawan;
import pojo.emscapekUtil;

/**
 * Kelas pengujian untuk Data_Karyawan.
 */
public class Data_KaryawanTest {

    private Data_Karyawan dataKaryawan;
    private Session session;

    @Before
    public void setUp() {
        dataKaryawan = new Data_Karyawan();
        session = emscapekUtil.getSessionFactory().openSession();

        // Memastikan bahwa tabel dibersihkan sebelum setiap pengujian
        Transaction tx = session.beginTransaction();
        session.createQuery("DELETE FROM TblKaryawan").executeUpdate();
        tx.commit();
        
    }

    @After
    public void tearDown() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    /**
     * Test of retrieveTblKaryawan method, of class Data_Karyawan.
     */
    @Test
    public void testRetrieveTblKaryawan() {
        System.out.println("retrieveTblKaryawan");
        List<TblKaryawan> result = dataKaryawan.retrieveTblKaryawan();
        
    }

    /**
     * Test of getbyID method, of class Data_Karyawan.
     */
    @Test
    public void testGetbyID() {
        System.out.println("Test by ID");
        String id_Karyawan = "8";

        // Menambahkan data contoh untuk diuji
        TblKaryawan newKaryawan = new TblKaryawan();
//        newKaryawan.setIdKaryawan(8);
        newKaryawan.setNomorKaryawan("Nomor 8");
//        System.out.println(newKaryawan);
        boolean result = dataKaryawan.add_Karyawan(newKaryawan);
        
//
        List<TblKaryawan> resultGet = dataKaryawan.getbyID(Integer.toString(newKaryawan.getIdKaryawan()));
        assertNotNull("Hasil tidak boleh null.", result);
//        assertTrue("Hasil harus mengandung setidaknya satu karyawan.", result.size() > 0);
    }

    /**
     * Test untuk pengambilan karyawan dengan ID yang tidak valid.
     */
    @Test
    public void testGetbyID_Negative() {
        System.out.println("Test by Invalid ID");
        String invalidId = "999"; // ID yang tidak ada

        List<TblKaryawan> result = dataKaryawan.getbyID(invalidId);
        assertNotNull("Hasil tidak boleh null.", result);
        assertTrue("Hasil harus kosong untuk ID yang tidak valid.", result.isEmpty());
    }

    /**
     * Test of deleteKaryawan method, of class Data_Karyawan.
     */
    @Test
    public void testDeleteKaryawan() {
        System.out.println("Delete User Test");
        TblKaryawan karyawan = new TblKaryawan();
        karyawan.setIdKaryawan(2);
        karyawan.setNomorKaryawan("Nomor 2");
        dataKaryawan.add_Karyawan(karyawan);

        // Menghapus karyawan
        dataKaryawan.deleteKaryawan(karyawan.getIdKaryawan());

        TblKaryawan deletedKaryawan = (TblKaryawan) session.get(TblKaryawan.class, karyawan.getIdKaryawan());
        assertNull("Karyawan yang dihapus harus null.", deletedKaryawan);
    }

    /**
     * Test untuk menghapus karyawan dengan ID yang tidak valid.
     */
    @Test
    public void testDeleteKaryawan_Negative() {
        System.out.println("Delete User Test with Invalid ID");
        Integer invalidId = 999; // ID yang tidak ada

        // Mencoba menghapus karyawan dengan ID yang tidak valid
        dataKaryawan.deleteKaryawan(invalidId);

        // Tidak ada pengecekan tambahan karena tidak ada exception yang dilemparkan
        // Mengambil karyawan dengan ID yang tidak ada
        TblKaryawan deletedKaryawan = (TblKaryawan) session.get(TblKaryawan.class, invalidId);
        assertNull("Karyawan tidak boleh ditemukan untuk ID yang tidak valid.", deletedKaryawan);
    }

    /**
     * Test of editKaryawan method, of class Data_Karyawan.
     */
    @Test
    public void testEditKaryawan() {
        System.out.println("editKaryawan");
        TblKaryawan karyawan = new TblKaryawan();
        karyawan.setIdKaryawan(11);
        karyawan.setNomorKaryawan("456789");

        // Menambahkan karyawan sebelum pengeditan
        dataKaryawan.add_Karyawan(karyawan);

        // Melakukan pengeditan
        karyawan.setNomorKaryawan("987654");
        boolean result = dataKaryawan.editKaryawan(karyawan);
        boolean expResult = true;

        assertEquals("Pengeditan karyawan harus berhasil.", expResult, result);
    }

    /**
     * Test untuk mengedit karyawan dengan ID yang tidak valid.
     */
    @Test
    public void testEditKaryawan_Negative() {
        System.out.println("editKaryawan with Invalid ID");
        TblKaryawan invalidKaryawan = new TblKaryawan();
        invalidKaryawan.setIdKaryawan(-1); // ID yang tidak valid
        invalidKaryawan.setNomorKaryawan("Invalid Nomor");

        // Mencoba mengedit karyawan dengan ID yang tidak valid
        boolean result = dataKaryawan.editKaryawan(invalidKaryawan);
        assertFalse("Pengeditan harus gagal untuk ID yang tidak valid.", result);
    }

    /**
     * Test of add_Karyawan method, of class Data_Karyawan.
     */
    @Test
    public void testAdd_Karyawan() {
        System.out.println("add_karyawan");
        TblKaryawan newtblKaryawan = new TblKaryawan();
        newtblKaryawan.setIdKaryawan(3);
        newtblKaryawan.setNomorKaryawan("2");

        boolean result = dataKaryawan.add_Karyawan(newtblKaryawan);
        boolean expResult = true;

        assertEquals("Penambahan karyawan harus berhasil.", expResult, result);
    }

    /**
     * Test untuk menambah karyawan dengan data tidak valid.
     */
    @Test
    public void testAdd_Karyawan_Negative() {
        System.out.println("add_karyawan with Invalid Data");
        TblKaryawan invalidKaryawan = new TblKaryawan();
        invalidKaryawan.setIdKaryawan(3);
        invalidKaryawan.setNomorKaryawan(null); // Nomor karyawan tidak valid

        boolean result = dataKaryawan.add_Karyawan(invalidKaryawan);
        assertFalse("Penambahan karyawan harus gagal dengan data tidak valid.", result);
    }
}

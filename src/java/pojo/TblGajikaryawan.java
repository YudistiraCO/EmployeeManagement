package pojo;
// Generated Oct 5, 2022 7:48:08 PM by Hibernate Tools 4.3.1

import GajiKaryawan.Gaji_Karyawan;
import java.util.List;
import javax.faces.bean.ManagedBean;




/**
 * TblGajikaryawan generated by hbm2java
 */
@ManagedBean

public class TblGajikaryawan  implements java.io.Serializable {


     private Integer idKaryawan;
     private String nomorKaryawan;
     private String jabatan;
     private String namaKaryawan;
     private String tanggalKehadiran;
     private String pekerjaan;
     private String gaji;
     
     
     public void save_gajikaryawan()
    {
        Gaji_Karyawan add = new Gaji_Karyawan();
        add.add_gajikaryawan(this);
    }
     
    public List<TblGajikaryawan> getAllRecords()
    {
        Gaji_Karyawan stud = new Gaji_Karyawan();
        List<TblGajikaryawan> iStud = stud.retrieveTblGajikaryawan();
        return iStud;
    }
    
        public String getById()
    {
        int id_karyawan = idKaryawan;
        Gaji_Karyawan stud = new Gaji_Karyawan();
        List<TblGajikaryawan> stud1 = stud.getbyID(id_karyawan);
        try {
            if (stud1 != null) {
                idKaryawan = stud1.get(0).idKaryawan;
                nomorKaryawan = stud1.get(0).nomorKaryawan;
                jabatan = stud1.get(0).jabatan;
                namaKaryawan = stud1.get(0).namaKaryawan;
                tanggalKehadiran = stud1.get(0).tanggalKehadiran;
                pekerjaan = stud1.get(0).pekerjaan;
                gaji = stud1.get(0).gaji;
                return "Gaji Karyawan";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Failed Search Gaji Karyawan";
    }
    
    public String editgajiKaryawan()
    {
        Gaji_Karyawan stud = new Gaji_Karyawan();
        stud.editgajiKaryawan(this);
        idKaryawan = 0;
        nomorKaryawan = "";
        jabatan = "";
        namaKaryawan = "";
        tanggalKehadiran = "";
        pekerjaan = "";
        gaji = "";
        return "Gaji Karyawan";
    }
    
    public String deletegajiKaryawan()
    {
       
        Gaji_Karyawan stud = new Gaji_Karyawan();
        stud.deletegajiKaryawan(idKaryawan);
        idKaryawan = 0;
        nomorKaryawan = "";
        jabatan = "";
        namaKaryawan = "";
        tanggalKehadiran = "";
        pekerjaan = "";
       gaji = "";
        return "Gaji Karyawan";
    }

    public TblGajikaryawan() {
    }

    public TblGajikaryawan(int idKaryawan,String nomorKaryawan, String jabatan, String namaKaryawan, String tanggalKehadiran, String pekerjaan, String gaji) {
       this.idKaryawan = idKaryawan;
       this.nomorKaryawan = nomorKaryawan;
       this.jabatan = jabatan;
       this.namaKaryawan = namaKaryawan;
       this.tanggalKehadiran = tanggalKehadiran;
       this.pekerjaan = pekerjaan;
       this.gaji = gaji;
    }
   
    public Integer getIdKaryawan() {
        return this.idKaryawan;
    }
    
    public void setIdKaryawan(Integer idKaryawan) {
        this.idKaryawan = idKaryawan;
    }
    public String getNomorKaryawan() {
        return this.nomorKaryawan;
    }
    
    public void setNomorKaryawan(String nomorKaryawan) {
        this.nomorKaryawan = nomorKaryawan;
    }
    public String getJabatan() {
        return this.jabatan;
    }
    
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    public String getNamaKaryawan() {
        return this.namaKaryawan;
    }
    
    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }
    public String getTanggalKehadiran() {
        return this.tanggalKehadiran;
    }
    
    public void setTanggalKehadiran(String tanggalKehadiran) {
        this.tanggalKehadiran = tanggalKehadiran;
    }
    public String getPekerjaan() {
        return this.pekerjaan;
    }
    
    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
    public String getGaji() {
        return this.gaji;
    }
    
    public void setGaji(String gaji) {
        this.gaji = gaji;
    }




}



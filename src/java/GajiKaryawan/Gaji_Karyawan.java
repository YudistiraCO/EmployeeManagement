/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GajiKaryawan;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.TblGajikaryawan;
import pojo.emscapekUtil;
/**
 *
 * @author rezar
 */
public class Gaji_Karyawan {
        public List<TblGajikaryawan> retrieveTblGajikaryawan()
    {
        List stud = new ArrayList();
        TblGajikaryawan stud1 = new TblGajikaryawan();
        Transaction trans = null;
        Session session = emscapekUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblGajikaryawan");
            stud = query.list();
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        return stud;
    }

public List<TblGajikaryawan> getbyID(int IdKaryawan)
    {
        TblGajikaryawan stud = new TblGajikaryawan();
        List<TblGajikaryawan> iStud = new ArrayList();
        
        Transaction trans = null;
        Session session = emscapekUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblGajikaryawan where idKaryawan = :id");
            query.setParameter("id", IdKaryawan);
            stud = (TblGajikaryawan) query.uniqueResult();
            iStud = query.list();
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
        return iStud;
    }
 public void deletegajiKaryawan(Integer IdKaryawan)
    {
        Transaction trans = null;
        Session session =emscapekUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            TblGajikaryawan stud = (TblGajikaryawan) session.load(TblGajikaryawan.class, new Integer(IdKaryawan));
            session.delete(stud);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public boolean editgajiKaryawan(TblGajikaryawan stud)
    {
        Transaction trans = null;
        Session session = emscapekUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.update(stud);
            trans.commit();
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public boolean add_gajikaryawan (TblGajikaryawan stud)
    {
        Transaction trans = null;
        Session session = emscapekUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.save(stud);
            trans.commit();
            return true;
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}


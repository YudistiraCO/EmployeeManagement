/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataKaryawan;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.TblKaryawan;
import pojo.emscapekUtil;

/**
 *
 * @author rezar
 */

public class Data_Karyawan {
    public List <TblKaryawan> retrieveTblKaryawan()
    {
    List stud = new ArrayList();
    TblKaryawan stud1 = new TblKaryawan();
    Transaction trans = null;
    Session session = emscapekUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
          Query query = session.createQuery("from TblKaryawan");
          stud = query.list();
          trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stud;
    }
    public List<TblKaryawan> getbyID(String IdKaryawan)
    {
        TblKaryawan stud = new TblKaryawan();
        List<TblKaryawan> iStud = new ArrayList();
        Transaction trans = null;
        Session session =emscapekUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblKaryawan where id_karyawan = :id");
            query.setParameter("id", IdKaryawan);
            stud = (TblKaryawan) query.uniqueResult();
            iStud = query.list();
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
        return iStud;
    }    
    

     public void deleteKaryawan(Integer IdKaryawan)
    {
        Transaction trans = null;
        Session session =emscapekUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            TblKaryawan stud = (TblKaryawan) session.load(TblKaryawan.class, new Integer(IdKaryawan));
            session.delete(stud);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public boolean editKaryawan(TblKaryawan stud)
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
    
    public boolean add_Karyawan(TblKaryawan stud)
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

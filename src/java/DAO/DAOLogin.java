/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.TblHrd;
import pojo.emscapekUtil;

/**
 *
 * @author rezar
 */
public class DAOLogin {
    public List<TblHrd> getBy(String uName,String uPass)
    {
        Transaction trans = null;
        TblHrd us = new TblHrd();
        List<TblHrd> hrd = new ArrayList();
        Session session = emscapekUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblHrd where username =:uName AND password =:uPass ");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            us = (TblHrd)query.uniqueResult();
            hrd = query.list();
            trans.commit();
        } catch (Exception e) {
          System.out.println(e);
        }
        return hrd;
    }
    public boolean add_hrd(TblHrd hrd)
    {
        Transaction trans = null;
        Session session = emscapekUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.save(hrd);
            trans.commit();
            return true;
            
        } catch (Exception e){
            System.out.println(e);
                return false;
        }
    }
}
    

   
    

    

    
package pojo;
// Generated Oct 5, 2022 7:48:08 PM by Hibernate Tools 4.3.1

import DAO.DAOLogin;
import java.util.List;
import javax.faces.bean.ManagedBean;




/**
 * TblHrd generated by hbm2java
 */
@ManagedBean
public class TblHrd  implements java.io.Serializable {


     private Integer idHrd;
     private String username;
     private String password;
     
public void save_hrd()
     {
        DAOLogin add = new DAOLogin();
        add.add_hrd(this);
        
     }

     public String login_hrd()
     {
         DAOLogin uDao = new DAOLogin();
         List<TblHrd> us = uDao.getBy(username, password);
         try {
             if(us != null){
             username = us.get(0).username;
             password = us.get(0).password;
             return "sukses";
                     
             }
         }catch (Exception e) {
             System.out.println(e);
         }
         
         return "gagal";
         
     }
             
             
    public TblHrd() {
    }

    public TblHrd(String username, String password) {
       this.username = username;
       this.password = password;
    }
   
    public Integer getIdHrd() {
        return this.idHrd;
    }
    
    public void setIdHrd(Integer idHrd) {
        this.idHrd = idHrd;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}



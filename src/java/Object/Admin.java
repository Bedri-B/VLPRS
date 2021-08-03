/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.io.Serializable;

/**
 *
 * @author E6440
 */
public class Admin implements Serializable{
    private String Email;

    public Admin() {
    }
    private String UserID;

    public Admin(String Email, String UserID) {
        this.Email = Email;
        this.UserID = UserID;
    }

    public String getEmail() {
        return Email;
    }

    public String getUserid() {
        return UserID;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
    
}

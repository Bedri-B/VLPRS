/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.io.Serializable;
import java.sql.Date;


/**
 *
 * @author E6440
 */
public class OwnerInfo implements Serializable{
    private String Firstname;
    private String Lastname;
    private String Sex;
    private String RegArea;
    private String Phone;
    private String OwnerID;
    
    private Date Dob;

    public OwnerInfo() {
        this.Firstname = "";
        this.Lastname = "";
        this.Sex = "";
        this.RegArea = "";
        this.Phone = "";
        this.OwnerID = "";
        this.Dob = new Date(0);
    }

    public OwnerInfo(String Firstname, String Lastname, String Sex, String RegArea, String Phone, String OwnerID, Date Dob) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Sex = Sex;
        this.RegArea = RegArea;
        this.Phone = Phone;
        this.OwnerID = OwnerID;
        this.Dob = Dob;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getSex() {
        return Sex;
    }

    public String getRegArea() {
        return RegArea;
    }

    public String getPhone() {
        return Phone;
    }

    public String getOwnerID() {
        return OwnerID;
    }


    public Date getDob() {
        return Dob;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public void setRegArea(String RegArea) {
        this.RegArea = RegArea;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setOwnerID(String OwnerID) {
        this.OwnerID = OwnerID;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }
      
}

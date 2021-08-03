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
public class Report implements Serializable{
    private String Fullname;
    private String Userid;
    private String Title;
    private String Content;
    private Date date;
    private int Reportid;

    public Report() {
    }

    public Report(String Userid, String FullName, String Title, String Content, int ID, Date date) {
        this.Userid = Userid;
        this.Fullname = FullName;
        this.Title = Title;
        this.Content = Content;
        this.Reportid = ID;
        this.date = date;
    }

    public String getUserid() {
        return Userid;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return Content;
    }

    public Date getDate() {
        return date;
    }

    public void setUserid(String Userid) {
        this.Userid = Userid;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getReportid() {
        return Reportid;
    }

    public void setReportid(int ID) {
        this.Reportid = ID;
    }
    
    public String getFullname() {
        return Fullname;
    }
    
}

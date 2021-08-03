/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.io.Serializable;
import java.sql.Date;




public class VehicleInfo implements Serializable {
    private String Chasisno;
    private String Motorno;
    private String Brand;
    private String Model;
    private String Fueltype;
    private String Region;
    private String City;
    private String Ownerid;
    private String Plateno;
    
    private int Seatsno;
    private int Motorsize;
    private int Horsepower;
    private int Code;
    
    private Date Prodyear;
    private Date Inspectionyear;

    public VehicleInfo() {
        this.Chasisno = "";
        this.Motorno = "";
        this.Brand = "";
        this.Model = "";
        this.Fueltype = "";
        this.Region = "";
        this.City = "";
        this.Ownerid = "";
        this.Plateno = "";
        this.Seatsno = -1;
        this.Motorsize = -1;
        this.Horsepower = -1;
        this.Code = -1;
        this.Prodyear = new Date(0);
        this.Inspectionyear = new Date(0);
    }
    
    

    public VehicleInfo(String Chasisno, String Motorno, String Brand, String Fueltype, String Region, String Model, String City, String Ownerid, String Plateno, int Seatsno, int Motorsize, int Horsepower, int Code, Date Prodyear, Date Inspectionyear) {
        this.Chasisno = Chasisno;
        this.Motorno = Motorno;
        this.Brand = Brand;
        this.Fueltype = Fueltype;
        this.Region = Region;
        this.Model = Model;
        this.City = City;
        this.Ownerid = Ownerid;
        this.Plateno = Plateno;
        this.Seatsno = Seatsno;
        this.Motorsize = Motorsize;
        this.Horsepower = Horsepower;
        this.Code = Code;
        this.Prodyear = Prodyear;
        this.Inspectionyear = Inspectionyear;
    }

    public void setChasisno(String Chasisno) {
        this.Chasisno = Chasisno;
    }

    public void setMotorno(String Motorno) {
        this.Motorno = Motorno;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public void setFueltype(String Fueltype) {
        this.Fueltype = Fueltype;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setOwnerid(String Ownerid) {
        this.Ownerid = Ownerid;
    }

    public void setSeatsno(int Seatsno) {
        this.Seatsno = Seatsno;
    }

    public void setMotorsize(int Motorsize) {
        this.Motorsize = Motorsize;
    }

    public void setHorsepower(int Horsepower) {
        this.Horsepower = Horsepower;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }


    public void setProdyear(Date Prodyear) {
        this.Prodyear = Prodyear;
    }

    public void setInspectionyear(Date Inspectionyear) {
        this.Inspectionyear = Inspectionyear;
    }

    public String getChasisno() {
        return Chasisno;
    }

    public String getMotorno() {
        return Motorno;
    }

    public String getBrand() {
        return Brand;
    }


    public String getFueltype() {
        return Fueltype;
    }

    public String getRegion() {
        return Region;
    }

    public String getModel() {
        return Model;
    }

    public String getCity() {
        return City;
    }

    public String getOwnerid() {
        return Ownerid;
    }

    public int getSeatsno() {
        return Seatsno;
    }

    public int getMotorsize() {
        return Motorsize;
    }

    public int getHorsepower() {
        return Horsepower;
    }

    public int getCode() {
        return Code;
    }

    public Date getProdyear() {
        return Prodyear;
    }

    public Date getInspectionyear() {
        return Inspectionyear;
    }
    public String getPlateno() {
        return Plateno;
    }

    public void setPlateno(String Plateno) {
        this.Plateno = Plateno;
    }
    
}

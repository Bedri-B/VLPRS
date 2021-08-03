/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author E6440
 */
public class User implements Serializable{
    private String Email;
    private String Userid;
    private OwnerInfo Info;
    private ArrayList<VehicleInfo> Vehicles;

    

    public User() {
        this.Email = "";
        this.Userid = "";
    }

    public User(String Email, String Userid, int Type) {
        this.Email = Email;
        this.Userid = Userid;
    }

    public String getEmail() {
        return Email;
    }

    public String getUserid() {
        return Userid;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setUserid(String Userid) {
        this.Userid = Userid;
    }
    
    public List<VehicleInfo> getVehicles() {
        return Vehicles;
    }
    
    public void setVehicles(ArrayList<VehicleInfo> Vehicles) {
        this.Vehicles = Vehicles;
    }
    
    public void addOwnerItem(VehicleInfo info){
        this.Vehicles.add(info);
    }
    
    public VehicleInfo getOwnerItem(int index){
        if(!(Vehicles.size() <= index)){
            return Vehicles.get(index);
        }
        return null;
    }

    public OwnerInfo getInfo() {
        return Info;
    }

    public void setInfo(OwnerInfo Info) {
        this.Info = Info;
    }
    
    public VehicleInfo getMyVehicle(String ChasisNo){
        for(VehicleInfo v : this.Vehicles){
            if(v.getChasisno().equals(ChasisNo)) return v;
        }
        return null;
    }
}

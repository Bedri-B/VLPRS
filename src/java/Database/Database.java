/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Object.Admin;
import Object.OwnerInfo;
import Object.Report;
import Object.User;
import Object.VehicleInfo;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author E6440
 */
public class Database {

    private Connection connection;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/VLPRS", "root", "");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean Close() {
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean checkUser(String Email) {
        try {
            String SQL = "Select * from User where Email=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkAdmin(String Email) {
        try {
            String SQL = "Select * from Admin where Email=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Admin getAdmin(String Email) {
        try {
            String SQL = "Select * from Admin where Email=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Admin(Email, rs.getString("UserID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Admin();
    }

    public boolean checkVehicleInfo(String Attribute, Object Value) {
        try {
            String SQL = "Select OwnerID from Vehicle_Info where " + Attribute + "=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setObject(1, Value);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPhoneNo(String PhoneNo) {
        try {
            String SQL = "Select * from Owner_Info where Phone=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, PhoneNo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ValidateAdmin(String Email, String Password) {
        try {
            String SQL = "Select Password from Admin where Email=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String password = rs.getString("Password");
                return password.equals(Password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Validate(String Email, String Password) {
        try {
            String SQL = "Select Password from User where Email=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String password = rs.getString("Password");
                return password.equals(Password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int CheckVehicleStatus(String ChasisNo) {
        try {
            String SQL = "Select Status from vehicle_Info Where ChasisNo=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, ChasisNo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("Status");
            }
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -3;
    }

    public void ChangeVehicleStatus(String ChasisNo, int value) {
        try {
            String SQL = "Update vehicle_Info set Status=?  Where ChasisNo=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setObject(1, value);
            pst.setString(2, ChasisNo);

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean CheckSession(String UserID, String SessionCode) {
        try {
            String SQL = "Select * from User_Session where UserID=? and Session_Code=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, UserID);
            pst.setString(2, SessionCode);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt("Active") == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void TerminateSession(String UserID, String SessionCode) {
        try {
            String SQL = "Update User_Session set Active=0 where UserID=? and Session_Code=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, UserID);
            pst.setString(2, SessionCode);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateSession(String UserID, String SessionCode) {
        try {
            String SQL = "Insert into User_Session(UserID, Session_Code, Last_Date) values(?,?,NOW())";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, UserID);
            pst.setString(2, SessionCode);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RegisterUser(String Email, String Password, String FirstName,
            String LastName, String Sex, String RegArea, String Phone, Date DoB) {

        try {
            String SQL = "Insert into User(Email, Password, UserID) values(?,?,?)";
            String UserID = GenerateID(FirstName);

            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, Email);
            pst.setString(2, EncryptPassword(Password));
            pst.setString(3, UserID);

            pst.executeUpdate();

            SQL = "Insert into Owner_Info(FirstName, LastName, OwnerID, DoB, Sex, RegArea, Phone) values(?,?,?,?,?,?,?)";

            pst = connection.prepareStatement(SQL);
            pst.setString(1, FirstName);
            pst.setString(2, LastName);
            pst.setString(3, UserID);
            pst.setDate(4, DoB);
            pst.setString(5, Sex);
            pst.setString(6, RegArea);
            pst.setString(7, Phone);

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> FetchUsers() {
        ArrayList<String> userID = new ArrayList<String>();
        try {
            String SQL = "Select * from User";
            PreparedStatement pst = connection.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                userID.add(rs.getString("Email"));
            }
            return userID;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userID;
    }

    public OwnerInfo FetchOwnerInfo(String UserID) {
        try {
            String SQL = "Select * from Owner_Info where OwnerID=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, UserID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new OwnerInfo(rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Sex"), rs.getString("RegArea"), rs.getString("Phone"), rs.getString("OwnerID"), rs.getDate("DoB"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String FetchUserID(String Email) {
        try {
            String SQL = "Select * from User where Email=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString("UserID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void RegisterVehicle(String ChasisNo, String MotorNo, String OwnerID, String Brand, String Model,
            Date ProdYear, int SeatsNo, String FuelType, int MotorSize, int HorsePower,
            Date InspectionYear, String Region, String City, int Code) {

        try {
            String SQL = "Insert into Vehicle_Info(ChasisNo, MotorNo, OwnerID, Brand, Model, "
                    + "ProdYear, Seats, FuelType, MotorSize, HorsePower, "
                    + "InspectionYear, Region, City, Code) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, ChasisNo);
            pst.setString(2, MotorNo);
            pst.setString(3, OwnerID);
            pst.setString(4, Brand);
            pst.setString(5, Model);
            pst.setDate(6, ProdYear);
            pst.setInt(7, SeatsNo);
            pst.setString(8, FuelType);
            pst.setInt(9, MotorSize);
            pst.setInt(10, HorsePower);
            pst.setDate(11, InspectionYear);
            pst.setString(12, Region);
            pst.setString(13, City);
            pst.setInt(14, Code);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void UpdateVehicle(String PrevChasisNo, String ChasisNo, String MotorNo, String OwnerID, String Brand, String Model,
            Date ProdYear, int SeatsNo, String FuelType, int MotorSize, int HorsePower,
            Date InspectionYear, String Region, String City, int Code) {

        try {
            String SQL = "Update Vehicle_Info set ChasisNo=?, MotorNo=?, OwnerID=?, Brand=?, Model=?,"
                    + "ProdYear=?, Seats=?, FuelType=?, MotorSize=?, HorsePower=?, "
                    + "InspectionYear=?, Region=?, City=?, Code=? where ChasisNo=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, ChasisNo);
            pst.setString(2, MotorNo);
            pst.setString(3, OwnerID);
            pst.setString(4, Brand);
            pst.setString(5, Model);
            pst.setDate(6, ProdYear);
            pst.setInt(7, SeatsNo);
            pst.setString(8, FuelType);
            pst.setInt(9, MotorSize);
            pst.setInt(10, HorsePower);
            pst.setDate(11, InspectionYear);
            pst.setString(12, Region);
            pst.setString(13, City);
            pst.setInt(14, Code);
            pst.setString(15, PrevChasisNo);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<VehicleInfo> FetchVehicleInfo() {
        ArrayList<VehicleInfo> list = new ArrayList<VehicleInfo>();
        try {
            String SQL = "Select * from Vehicle_Info";
            PreparedStatement pst = connection.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String plate = "Pending";
                if (!rs.getString("Plate").equals("")) {
                    plate = rs.getString("Plate");
                }
                VehicleInfo temp = new VehicleInfo(rs.getString("ChasisNo"), rs.getString("MotorNo"), rs.getString("Brand"),
                        rs.getString("FuelType"), rs.getString("Region"), rs.getString("Model"), rs.getString("City"), rs.getString("OwnerID"),
                        plate, rs.getInt("Seats"), rs.getInt("MotorSize"), rs.getInt("HorsePower"), rs.getInt("Code"),
                        rs.getDate("ProdYear"), rs.getDate("InspectionYear"));

                list.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<VehicleInfo> FetchVehicleInfo(String OwnerID) {
        ArrayList<VehicleInfo> list = new ArrayList<VehicleInfo>();
        try {
            String SQL = "Select * from Vehicle_Info where OwnerID=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, OwnerID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String plate = "Pending";
                if (!rs.getString("Plate").equals("")) {
                    plate = rs.getString("Plate");
                }
                VehicleInfo temp = new VehicleInfo(rs.getString("ChasisNo"), rs.getString("MotorNo"), rs.getString("Brand"),
                        rs.getString("FuelType"), rs.getString("Region"), rs.getString("Model"), rs.getString("City"), rs.getString("OwnerID"),
                        plate, rs.getInt("Seats"), rs.getInt("MotorSize"), rs.getInt("HorsePower"), rs.getInt("Code"),
                        rs.getDate("ProdYear"), rs.getDate("InspectionYear"));

                list.add(temp);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<VehicleInfo> FetchVehicleInfo(String Attribute, String Value) {
        ArrayList<VehicleInfo> list = new ArrayList<VehicleInfo>();
        try {
            String SQL = "Select * from Vehicle_Info where " + Attribute + "=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, Value);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String plate = "Pending";
                if (!rs.getString("Plate").equals("")) {
                    plate = rs.getString("Plate");
                }
                VehicleInfo temp = new VehicleInfo(rs.getString("ChasisNo"), rs.getString("MotorNo"), rs.getString("Brand"),
                        rs.getString("FuelType"), rs.getString("Region"), rs.getString("Model"), rs.getString("City"), rs.getString("OwnerID"),
                        plate, rs.getInt("Seats"), rs.getInt("MotorSize"), rs.getInt("HorsePower"), rs.getInt("Code"),
                        rs.getDate("ProdYear"), rs.getDate("InspectionYear"));

                list.add(temp);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void UpdateVehicleInfo(String ChasisNo, String Attribute, Object Update) {
        try {
            String SQL = "Update Vehicle_Info set " + Attribute + "=?  Where ChasisNo=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setObject(1, Update);
            pst.setString(2, ChasisNo);

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteVehicleInfo(String ChasisNo) {
        try {
            String SQL = "Delete from Vehicle_Info Where ChasisNo=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setObject(1, ChasisNo);

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateOwnerInfo(String OwnerID, String Attribute, Object Update) {
        try {
            String SQL = "Update Owner_Info set " + Attribute + "=?  Where OwnerID=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setObject(1, Update);
            pst.setString(2, OwnerID);

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteOwnerInfo(String UserID) {
        try {
            String SQL = "Delete from Owner_Info Where OwnerID=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, UserID);
            pst.executeUpdate();

            SQL = "Delete from User Where UserID=?";
            pst = connection.prepareStatement(SQL);
            pst.setString(1, UserID);
            pst.executeUpdate();

            SQL = "Delete from Vehicle_Info Where OwnerID=?";
            pst = connection.prepareStatement(SQL);
            pst.setString(1, UserID);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ChangePassword(String Email, String Password) {
        try {
            String SQL = "Update Owner_Info set Password=?  Where Eamil=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setObject(1, EncryptPassword(Password));
            pst.setString(2, Email);

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getPlateSequence(int code) {
        try {
            String SQL = "Select last from plate where code=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, code);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("last");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void UpdatePlateSequence(int code) {
        try {
            String SQL = "Update plate set last=? where code=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            int next = this.getPlateSequence(code);
            pst.setInt(1, ++next);
            pst.setInt(2, code);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String GeneratePlateNo(VehicleInfo vehicle) {
        String Plate = "";
        String Region = "";
        if (vehicle.getRegion().equals("Addis Abeba")) {
            Region = "AA";
        } else if (vehicle.getRegion().equals("Afar")) {
            Region = "AF";
        } else if (vehicle.getRegion().equals("Amhara")) {
            Region = "AM";
        } else if (vehicle.getRegion().equals("Benishangul Gumuz")) {
            Region = "BG";
        } else if (vehicle.getRegion().equals("Dire Dawa")) {
            Region = "DD";
        } else if (vehicle.getRegion().equals("Gambela")) {
            Region = "GA";
        } else if (vehicle.getRegion().equals("Harari")) {
            Region = "HA";
        } else if (vehicle.getRegion().equals("Oromia")) {
            Region = "OR";
        } else if (vehicle.getRegion().equals("Sidama")) {
            Region = "SI";
        } else if (vehicle.getRegion().equals("SNNPR")) {
            Region = "AA";
        } else if (vehicle.getRegion().equals("Somale")) {
            Region = "SO";
        } else if (vehicle.getRegion().equals("Tigray")) {
            Region = "TG";
        }
        int last = this.getPlateSequence(vehicle.getCode());
        System.out.println("Last: " + vehicle.getCode() + "  " + last);
        Plate += Region + String.format("%1$05d", (last + 1));
        this.UpdatePlateSequence(vehicle.getCode());
        last = this.getPlateSequence(vehicle.getCode());
        System.out.println("Last: " + vehicle.getCode() + "  " + last);
        return Plate;
    }

    public String GenerateID(String FirstName) {
        return FirstName.trim() + new java.util.Date().getTime();
    }

    public String EncryptPassword(String Password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] a = md.digest(Password.getBytes());
            StringBuilder b = new StringBuilder();
            for (byte value : a) {
                b.append(Integer.toHexString((value & 0xFF) | 0x100).substring(1, 3));
            }
            return b.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public void SubmitReport(String UserID, String Title, String Content) {
        try {
            String SQL = "Insert into Report(UserID, Title, Content, Date) values(?,?,?,NOW())";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, UserID);
            pst.setString(2, Title);
            pst.setString(3, Content);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Report GetReport(int ID) {
        try {
            String SQL = "Select * from Report where ID=?";
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                OwnerInfo info = this.FetchOwnerInfo(rs.getString("UserID"));
                String FullName = info.getFirstname() + " " + info.getLastname();
                return new Report(rs.getString("UserID"), FullName, rs.getString("Title"), rs.getString("Content"), rs.getInt("ID"), rs.getDate("Date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Report();
    }

    public ArrayList<Report> GetReport() {
        ArrayList<Report> list = new ArrayList<Report>();
        try {
            String SQL = "Select * from Report";
            PreparedStatement pst = connection.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OwnerInfo info = this.FetchOwnerInfo(rs.getString("UserID"));
                String FullName = info.getFirstname() + " " + info.getLastname();
                list.add(new Report(rs.getString("UserID"), FullName, rs.getString("Title"), rs.getString("Content"), rs.getInt("ID"), rs.getDate("Date")));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

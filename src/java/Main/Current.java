/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Database.Database;
import Object.User;
import Object.VehicleInfo;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.servlet.http.Cookie;

/**
 *
 * @author E6440
 */
public class Current {

    public static Database DB = null;

    public static void Initialize() {
        if (DB != null) {
            return;
        }
        DB = new Database();
    }

    public static User Setup(String Email) {
        User user = new User();
        user.setEmail(Email);
        user.setUserid(DB.FetchUserID(Email));
        user.setInfo(DB.FetchOwnerInfo(user.getUserid()));
        user.setVehicles(DB.FetchVehicleInfo(user.getUserid()));
        return user;
    }

    public static TreeMap<String, String> Cookies(Cookie[] cookies) {

        TreeMap<String, String> map = new TreeMap<String, String>();
        if (cookies != null) {
            for (int x = 0; x < cookies.length; x++) {
                System.out.println(cookies[x].getName() + " ------ " + cookies[x].getValue());
                if (cookies[x].getName().equals("Email")) {
                    map.put(cookies[x].getName(), cookies[x].getValue());
                }
                if (cookies[x].getName().equals("UserID")) {
                    map.put(cookies[x].getName(), cookies[x].getValue());
                }
                if (cookies[x].getName().equals("SessionCode")) {
                    map.put(cookies[x].getName(), cookies[x].getValue());
                }
            }
        }

        if (map.size() != 0) {
            try {
                System.out.println(map.size());
                System.out.println(" -- " + Current.DB.checkUser(map.get("Email")));
                System.out.println(" -- " + Current.DB.CheckSession(map.get("UserID"), map.get("SessionCode")));
                System.out.println(map.size() + " -- " + Current.DB.checkAdmin(map.get("Email")) + " -- " + Current.DB.CheckSession(map.get("UserID"), map.get("SessionCode")));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public static String GenerateSessionCode(String UserID) {
        return UserID + new java.util.Date().getTime();
    }

    public static String EncryptSessionCode(String Password) {
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

    public static ArrayList<User> Users() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            for (String Email : DB.FetchUsers()) {
                users.add(Setup(Email));
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<VehicleInfo> SearchVehicle(String Query) {
        Query = Query.toLowerCase();
        ArrayList<VehicleInfo> result = new ArrayList<VehicleInfo>();
        for (VehicleInfo v : DB.FetchVehicleInfo()) {
            if (v.getBrand().toLowerCase().contains(Query) || v.getModel().toLowerCase().contains(Query)
                    || v.getFueltype().toLowerCase().contains(Query) || v.getOwnerid().toLowerCase().contains(Query)) {
                result.add(v);
            }
        }
        return result;
    }

    public static long parseDate(String date) {
        try {
            SimpleDateFormat Parser = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(date);
            return Parser.parse(date).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new java.util.Date().getTime();
    }
}

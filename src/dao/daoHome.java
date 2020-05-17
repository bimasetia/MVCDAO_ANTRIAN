/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.JavaConnector;
import model.HomeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bimas
 */
public class daoHome implements implementHome {

    Connection connection;
    final String insert = "INSERT INTO service(Customer_Name,Type_Of_Service,Description,Detail_Date) VALUES (?,?,?,?)";
    final String update = "UPDATE service set Customer_Name=?,Type_Of_Service=?,Description=? where Serial=?";
    final String delete = "delete from service  where Serial=?";
    final String select = "select Serial,Customer_Name,Type_Of_Service,Description from service";

    public daoHome() {
        connection = JavaConnector.ConnecrDb();
    }

    public void insert(HomeModel d) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, d.getName());
            statement.setString(2, d.getType());
            statement.setString(3, d.getDesc());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                d.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void update(HomeModel d) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, d.getName());
            statement.setString(2, d.getType());
            statement.setString(3, d.getDesc());
            statement.setInt(4, d.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
        public List<HomeModel> getALL() {
        List<HomeModel> lb = null;
        try {
            lb = new ArrayList<HomeModel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                HomeModel d = new HomeModel();
                d.setId(rs.getInt("Serial"));
                d.setName(rs.getString("Customer_Name"));
                d.setType(rs.getString("Type_Of_Service"));
                d.setDesc(rs.getString("Description"));
                lb.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoHome.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }
    
    

}

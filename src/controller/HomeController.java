/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.daoHome;
import dao.implementHome;
import model.HomeModel;
import model.tableModelHome;
import view.Home;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author bimas
 */
public class HomeController {

    Home home;
    implementHome implHome;
    List<HomeModel> lb;

    public HomeController(Home home) {
        this.home = home;
        implHome = new daoHome();
        lb = implHome.getALL();
    }

    //menampilkan data ke dalam table
    public void isiTable() {
        lb = implHome.getALL();
        tableModelHome tmb = new tableModelHome(lb);
        home.getTableData().setModel(tmb);
    }

    //menampilkan data yang dipilih dari table
    public void isiField(int row) {
        home.getTxtIDUpdate().setText(lb.get(row).getId().toString());
        home.getTxtNameUpdate().setText(lb.get(row).getName());
        home.getTxtTypeUpdate().setSelectedItem(lb.get(row).getType());
        home.getTxtDescUpdate().setText(lb.get(row).getDesc());
    }

    //insert data berdasarkan inputan user dari textfield di home
    public void insert() {
        HomeModel d = new HomeModel();
        d.setName(home.getTxtNameNew().getText());
        d.setType((String) home.getTxtTypeNew().getSelectedItem());
        d.setDesc(home.getTxtDescNew().getText());

        implHome.insert(d);
    }

    //update data berdasarkan inputan user dari textfield di home
    public void update() {
        HomeModel d = new HomeModel();
        d.setName(home.getTxtNameNew().getText());
        d.setType((String) home.getTxtTypeNew().getSelectedItem());
        d.setDesc(home.getTxtDescNew().getText());
        d.setId(Integer.parseInt(home.getTxtIDUpdate().getText()));
        implHome.update(d);
    }
}

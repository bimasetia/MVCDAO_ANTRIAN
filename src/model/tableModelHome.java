/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author bimas
 */
public class tableModelHome extends AbstractTableModel {
    List<HomeModel> lb;
    
    public tableModelHome(List<HomeModel> lb){
        this.lb =lb;
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    public int getRowCount() {
        return lb.size();
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Name";
            case 2:
                return "Type";
            case 3:
                return "Desc";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getName();
            case 2:
                return lb.get(row).getType();
            case 3:
                return lb.get(row).getDesc();
            default:
                return null;
        }
    }
}

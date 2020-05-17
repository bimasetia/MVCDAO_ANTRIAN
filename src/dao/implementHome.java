/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.*;
/**
 *
 * @author bimas
 */
public interface implementHome {
    
    public void insert(HomeModel d);
    public void update(HomeModel d);
    public void delete(int id);
    public List<HomeModel> getALL();
}

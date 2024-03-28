/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.wms.client;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pl.wms.client.ENTITY.Product;

/**
 *
 * @author danie
 */

class MyTableModel extends AbstractTableModel {
    
    private String[] cols = {"Nazwa produktu", "Data ważności", "Ilość na stanie"};
    List<Product> data = new ArrayList<Product>();
    
    public void setCols(String[] cols) {
        this.cols = cols;
    }
    public void setData(List<Product> data) {
        this.data = data;
    }
    
    public Object getValueAt(int r, int c) {
        Product productObj = data.get(r);
        
        return switch (c) {
            case 0 -> productObj.getName();
            case 1 -> productObj.getValidity_data();
            case 2 -> productObj.getQuantity();
            default -> null;
        };
    }

    public int getColumnCount() {
        return cols.length;
    }

    public int getRowCount() {
        return data.size();
    }
    
    public String[] getCols() {
        return cols;
    }
    
    public String getColumnName(int c) {
          return cols[c];  
    }
}
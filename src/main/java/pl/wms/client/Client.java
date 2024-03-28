/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pl.wms.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import pl.wms.client.API.ClientAPI;
import pl.wms.client.API.ProductAPI;
import pl.wms.client.ENTITY.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author danie
 */
public class Client implements ActionListener {
    private JFrame jf;
    private MyTableModel mtm;
    private JTable jt;
    private JScrollPane jsp;
    private JButton jBtnRefresh;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Client();
            }
        });
    }
    
    public Client() {
        jf = new JFrame("Client");
        jf.setPreferredSize(new Dimension(800, 600));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());
        mtm = new MyTableModel();
        jt = new JTable(mtm);
        jt.setPreferredScrollableViewportSize(new Dimension(700, 500));
        jsp = new JScrollPane(jt);
        
        jBtnRefresh = new JButton("Odśwież");
        jBtnRefresh.addActionListener(this);
        
        jf.getContentPane().add(jsp);
        jf.getContentPane().add(jBtnRefresh);
        
        jf.setVisible(true);
        
        jf.pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        loadStockData(); 
    }

    private void loadStockData() {
        List<Product> responseData = new ArrayList<>();
        
        try {
            ProductAPI productAPI = ClientAPI.getClient().create(ProductAPI.class);
            productAPI.findAll().enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    if(response.isSuccessful()) {
                        for(Product product : response.body()){
                            responseData.add(product);
                        }
                        mtm.setData(responseData);
                        mtm.fireTableStructureChanged();
                        mtm.fireTableDataChanged();
                    }
                }

                @Override
                public void onFailure(Call<List<Product>> arg0, Throwable t) {
                    JOptionPane.showConfirmDialog(null, t.getMessage());
                }
            });
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
}

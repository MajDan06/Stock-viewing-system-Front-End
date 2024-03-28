/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.wms.client.API;

import java.util.List;
import pl.wms.client.ENTITY.Product;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * @author danie
 */
public interface ProductAPI {
    @GET("/GetProducts")
    Call<List<Product>> findAll();
}

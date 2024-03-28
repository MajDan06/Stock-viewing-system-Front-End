/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.wms.client.ENTITY;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author danie
 */
public class Product implements Serializable {
    
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("validity_data")
    private String validity_data;
    @SerializedName("quantity")
    private String quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValidity_data() {
        return validity_data;
    }

    public void setValidity_data(String validity_data) {
        this.validity_data = validity_data;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

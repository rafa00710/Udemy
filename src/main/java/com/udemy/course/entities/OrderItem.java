package com.udemy.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.course.entities.pk.OrdemItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1l;

    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem() {

    }
    //Esses (order e product) tivemos que fazer na mão e tb os getter e setter.
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);

        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);

    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);

    }

    //Metodo do Sub-Total

    public Double getSubTotal(){
     return quantity * price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem ordemItem = (OrderItem) o;
        return Objects.equals(id, ordemItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

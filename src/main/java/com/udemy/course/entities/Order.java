package com.udemy.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.course.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final  long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Data
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    //Associações
    //Pode ter muitos pedidos para um unico cliente.
    //Quando temos uma associação para muitos, devemos utilizar o jsonignore para não estourar a memoria
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Users client;

    @JsonIgnore
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    //Associação e inserindo os getter and setter
    //Essa anotação vai verificar que o pedido 1 = pagamento 1
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    //Cosntrutor

    public Order(){

    }

    public Order(long id, Instant moment,OrderStatus orderStatus, Users client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Users getClient() {
        return client;
    }

    public void setClient(Users client) {
        this.client = client;
    }

    public Set<OrderItem> getItems(){
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    //Metodo para pegar o valor total dos pedidos

    public Double getTotal(){
        double sum = 0;
        for (OrderItem x: items) {
            sum += x.getSubTotal();

        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId() == order.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}

package entity;

import lombok.*;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@ToString(exclude = "orderDetails")
@Getter
@Setter
@Entity
@Table(name = "`Order`")

public class Order implements SuperEntity {
        @Id
    private String id;
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "customerId",referencedColumnName = "id",nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "order",cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<OrderDetail> orderDetails;


    public Order(String id, Date date,Customer customerId) {
        this.id = id;
        this.date = date;
        this.customer = customerId;
    }

    public Order(String id, Date date,Customer customerId,List<OrderDetail>orderDetails) {
        this.id = id;
        this.date = date;
        this.customer = customerId;
        for (OrderDetail orderDetail:orderDetails) {
            orderDetail.setOrder(this);
        }
        this.orderDetails=orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails){
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrder(this);
        }
        this.orderDetails=orderDetails;
    }

    public void addOrderDetail(OrderDetail orderDetail){
        orderDetail.setOrder(this);
        this.getOrderDetails().add(orderDetail);
    }


}

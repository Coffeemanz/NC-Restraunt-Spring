package entities;

import javax.persistence.*;

/**
 * Created by Сергей on 03.05.2017.
 */
@Entity
@Table(name = "bills", schema = "restraunt_nc", catalog = "restraunt_nc")
public class BillsEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int order_id;
    private double totalPrice;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id", nullable = false, precision = 0)
    public int getOrder_id() {return order_id;}

    public void setOrder_id(int order_id) {this.order_id = order_id;}

    @Basic
    @Column(name = "total_price", nullable = false, precision = 0)
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillsEntity that = (BillsEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.totalPrice, totalPrice) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

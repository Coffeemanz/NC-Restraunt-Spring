package entities;

import com.sun.deploy.util.Waiter;

import javax.persistence.*;

/**
 * Created by Сергей on 03.05.2017.
 */
@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "orders", schema = "restraunt_nc", catalog = "restraunt_nc")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private WaitersEntity waiterByWaiterId;
    private ClientsEntity clientsByClientId;
    private FoodEntity foodByFoodId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public ClientsEntity getClientsByClientId() {
        return clientsByClientId;
    }

    public void setClientsByClientId(ClientsEntity clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "waiter_id", referencedColumnName = "id", nullable = false)
    public WaitersEntity getWaiterByWaiterId() {
        return waiterByWaiterId;
    }

    public void setWaiterByWaiterId(WaitersEntity waiterByWaiterId) {
        this.waiterByWaiterId = waiterByWaiterId;
    }



    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id", nullable = false)
    public FoodEntity getFoodByFoodId() {
        return foodByFoodId;
    }

    public void setFoodByFoodId(FoodEntity foodByFoodId) {
        this.foodByFoodId = foodByFoodId;
    }
}

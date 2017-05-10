package entities;

import javax.persistence.*;

/**
 * Created by Сергей on 03.05.2017.
 */
@Entity
@Table(name = "food", schema = "restraunt_nc" , catalog = "restraunt_nc")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String foodName;
    private String foodDesc;
    private double foodPrice;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "food_name", nullable = false, length = 45)
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Basic
    @Column(name = "food_desc", nullable = true, length = 45)
    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    @Basic
    @Column(name = "food_price", nullable = false, precision = 0)
    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodEntity that = (FoodEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.foodPrice, foodPrice) != 0) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (foodDesc != null ? !foodDesc.equals(that.foodDesc) : that.foodDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (foodDesc != null ? foodDesc.hashCode() : 0);
        temp = Double.doubleToLongBits(foodPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

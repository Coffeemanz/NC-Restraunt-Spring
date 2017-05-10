package entities;

import javax.persistence.*;

/**
 * Created by Сергей on 03.05.2017.
 */
@Entity
@Table(name = "waiters", schema = "restraunt_nc", catalog = "restraunt_nc")
public class WaitersEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String waiterName;
    private String waiterEmail;
    private String waiterPassword;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "waiter_name", nullable = true, length = 45)
    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    @Basic
    @Column(name = "waiter_email", nullable = true, length = 45)
    public String getWaiterEmail() {
        return waiterEmail;
    }

    public void setWaiterEmail(String waiterEmail) {
        this.waiterEmail = waiterEmail;
    }

    @Basic
    @Column(name = "waiter_password", nullable = true, length = 45)
    public String getWaiterPassword() {
        return waiterPassword;
    }

    public void setWaiterPassword(String waiterPassword) {
        this.waiterPassword = waiterPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WaitersEntity that = (WaitersEntity) o;

        if (id != that.id) return false;
        if (waiterName != null ? !waiterName.equals(that.waiterName) : that.waiterName != null) return false;
        if (waiterEmail != null ? !waiterEmail.equals(that.waiterEmail) : that.waiterEmail != null) return false;
        if (waiterPassword != null ? !waiterPassword.equals(that.waiterPassword) : that.waiterPassword != null)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "WaitersEntity{" +
                "id=" + id +
                ", waiterName='" + waiterName + '\'' +
                ", waiterEmail='" + waiterEmail + '\'' +
                ", waiterPassword='" + waiterPassword + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (waiterName != null ? waiterName.hashCode() : 0);
        result = 31 * result + (waiterEmail != null ? waiterEmail.hashCode() : 0);
        result = 31 * result + (waiterPassword != null ? waiterPassword.hashCode() : 0);
        return result;
    }
}

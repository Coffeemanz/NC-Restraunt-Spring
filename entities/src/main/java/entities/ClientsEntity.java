package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Сергей on 03.05.2017.
 */
@Entity
@Table(name = "clients", schema = "restraunt_nc", catalog = "restraunt_nc")
public class ClientsEntity  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String clientName;
    private String clientEmail;
    private String clientPassword;
    private Double clientCash;
    private Byte paid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "client_name", nullable = true, length = 45)
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Basic
    @Column(name = "client_email", nullable = true, length = 45)
    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Basic
    @Column(name = "client_password", nullable = true, length = 45)
    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    @Basic
    @Column(name = "client_cash", nullable = true, precision = 0)
    public Double getClientCash() {
        return clientCash;
    }

    public void setClientCash(Double clientCash) {
        this.clientCash = clientCash;
    }

    @Basic
    @Column(name = "paid", nullable = true)
    public Byte getPaid() {
        return paid;
    }

    public void setPaid(Byte paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "ClientsEntity{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientPassword='" + clientPassword + '\'' +
                ", clientCash=" + clientCash +
                ", paid=" + paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (id != that.id) return false;
        if (clientName != null ? !clientName.equals(that.clientName) : that.clientName != null) return false;
        if (clientEmail != null ? !clientEmail.equals(that.clientEmail) : that.clientEmail != null) return false;
        if (clientPassword != null ? !clientPassword.equals(that.clientPassword) : that.clientPassword != null)
            return false;
        if (clientCash != null ? !clientCash.equals(that.clientCash) : that.clientCash != null) return false;
        if (paid != null ? !paid.equals(that.paid) : that.paid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientEmail != null ? clientEmail.hashCode() : 0);
        result = 31 * result + (clientPassword != null ? clientPassword.hashCode() : 0);
        result = 31 * result + (clientCash != null ? clientCash.hashCode() : 0);
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        return result;
    }
}

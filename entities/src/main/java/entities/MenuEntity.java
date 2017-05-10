package entities;

import javax.persistence.*;

/**
 * Created by Сергей on 03.05.2017.
 */
@Entity
@Table(name = "menu", schema = "restraunt_nc", catalog = "restraunt_nc")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String menuName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "menu_name", nullable = true, length = 45)
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuEntity that = (MenuEntity) o;

        if (id != that.id) return false;
        if (menuName != null ? !menuName.equals(that.menuName) : that.menuName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        return result;
    }
}

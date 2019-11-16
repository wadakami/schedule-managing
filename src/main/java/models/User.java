package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "users")
@NamedQueries({
    @NamedQuery(
            name = "getAllUsers",
            query = "SELECT e FROM User AS e ORDER BY e.id ASC"
            ),
    @NamedQuery(
            name = "getUsersCount",
            query = "SELECT COUNT(e) FROM User AS e"
            ),
    @NamedQuery(
            name = "getUser",
            query = "SELECT u FROM User AS u WHERE u.name = :name"
            ),
    @NamedQuery(
            name = "checkRegisteredName",
            query = "SELECT COUNT(e) FROM User AS e WHERE e.name = :name"
            ),
    @NamedQuery(
            name = "checkUserColor",//同じ系統の中で同じ色があるか：validation用
            query = "SELECT COUNT(u) FROM User AS u WHERE u.color = :color AND u.admin_flag = :admin"
            ),
    @NamedQuery(
            name = "checkMyColor",//登録者の色を検索
            query = "SELECT u.name FROM User AS u WHERE u.color = :color AND u.admin_flag = :admin"
            ),
    @NamedQuery(
            name = "checkLoginNameAndPassword",
            query = "SELECT u FROM User AS u WHERE u.delete_flag = 0 AND u.name = :name AND u.password = :pass"
            )
})
@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)//管理者、生徒、教師
    private String name;

    @Lob
    @Column(name = "book")//
    private String book;

    @Column(name = "color")//生徒と教師に付与
    private String color;

    @Column(name = "max")//生徒と教師に付与
    private Integer max;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "admin_flag", nullable = false)//生徒：0、教師：1、管理者：2
    private Integer admin_flag;

    @Column(name = "delete_flag", nullable = false)
    private Integer delete_flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdmin_flag() {
        return admin_flag;
    }

    public void setAdmin_flag(Integer admin_flag) {
        this.admin_flag = admin_flag;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }


}

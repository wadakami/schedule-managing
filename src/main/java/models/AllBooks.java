package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "allbooks")
@NamedQueries({
    @NamedQuery(
            name = "getAllBooks",
            query = "SELECT b FROM AllBooks AS b ORDER BY b.id DESC"
            ),
    @NamedQuery(
            name = "getBookName",
            query = "SELECT b.book_name FROM AllBooks AS b ORDER BY b.id DESC"
            ),
    @NamedQuery(
            name = "getBooksCount",
            query = "SELECT COUNT(b) FROM AllBooks AS b"
            )
})
@Entity
public class AllBooks {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name")
    private String book_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

}

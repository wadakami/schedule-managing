package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "schedules")
@NamedQueries({
    @NamedQuery(
            name = "getThenSchedules",//本日の日付のスケジュールを出力
            query = "SELECT s FROM Schedule AS s WHERE s.date = :date ORDER BY s.teacher, s.time"
            ),
    @NamedQuery(
            name = "getTime",//本日の時限のスケジュールを出力
            query = "SELECT s FROM Schedule AS s WHERE s.date = :date And s.time = :time ORDER BY s.teacher"
            ),
    @NamedQuery(
            name = "getTeacherSchedule",//指定した日付と先生のスケジュールを出力
            query = "SELECT s FROM Schedule AS s WHERE s.date = :date AND s.teacher = :teacher"
            ),
    @NamedQuery(
            name = "getStudentSchedule",//指定した日付生徒のスケジュールを出力
            query = "SELECT s FROM Schedule AS s WHERE s.date = :date AND s.student = :student"
            ),
    @NamedQuery(
            name = "getStudentCount",//指定した日付生徒のスケジュールをカウント
            query = "SELECT COUNT(s) FROM Schedule AS s WHERE s.date = :date AND s.student = :student"
            ),
    @NamedQuery(
            name = "getExactTime",//指定した日付と先生の1時間の授業を出力
            query = "SELECT s FROM Schedule AS s WHERE s.date = :date AND s.teacher = :teacher And s.time = :time"
            ),
    @NamedQuery(
            name = "getThenAllTeacher",//指定した日付の先生の名前一覧（重複なし
            query = "SELECT DISTINCT s.teacher FROM Schedule AS s WHERE s.date = :date ORDER BY s.teacher"
            ),
    @NamedQuery(
            name = "getThenTeacher",//本日の日付の先生の数を出力　validation用
            query = "SELECT COUNT(s) FROM Schedule AS s WHERE s.date = :date AND s.teacher = :teacher"
            ),
    @NamedQuery(
            name = "getOverWrap",//日付の生徒の時間割を検索　validation用
            query = "SELECT COUNT(s) FROM Schedule AS s WHERE s.date = :date AND s.student = :student And s.time = :time"
            ),
    @NamedQuery(
            name = "getOverWrapT",//日付の教師の時間割を検索　validation用
            query = "SELECT COUNT(s) FROM Schedule AS s WHERE s.date = :date AND s.teacher = :teacher And s.time = :time"
            ),
    @NamedQuery(
            name = "valiUpdate",//日付の先生と生徒の時間割を検索　validation用
            query = "SELECT COUNT(s) FROM Schedule AS s WHERE s.date = :date AND s.student = :student And s.time = :time AND s.teacher = :teacher"
            ),
    @NamedQuery(
            name = "getSchedulesCount",
            query = "SELECT COUNT(s) FROM Schedule AS s"
            )
})
@Entity
public class Schedule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "student_name")
    private String student;

    @Column(name = "teacher_name")
    private String teacher;

    @Column(name = "book_name")
    private String book;

    @Column(name = "time")
    private Integer time;//何限目か？1~8

    @Column(name = "date")
    private Date date;

    @Column(name = "absent")
    private Integer absent;//出欠可能か？0=可　1=不可

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAbsent() {
        return absent;
    }

    public void setAbsent(Integer absent) {
        this.absent = absent;
    }

}

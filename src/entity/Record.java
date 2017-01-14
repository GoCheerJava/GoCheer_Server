package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by Donggu on 2017/1/14.
 */
@Entity
@Table(name = "record", schema = "javaEE", catalog = "")
public class Record {
    private String word;
    private Timestamp datetime;
    private String user;
    private int id;
    public Record(){
        datetime=Timestamp.valueOf(LocalDateTime.now());
    }
    public Record(String word, String user){
        this();
        this.word=word;
        this.user=user;
    }

    @Basic
    @Column(name = "word", nullable = false, length = 255)
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Basic
    @Column(name = "datetime", nullable = false)
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "user", nullable = false, length = 255)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

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

        Record record = (Record) o;

        if (id != record.id) return false;
        if (word != null ? !word.equals(record.word) : record.word != null) return false;
        if (datetime != null ? !datetime.equals(record.datetime) : record.datetime != null) return false;
        if (user != null ? !user.equals(record.user) : record.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}

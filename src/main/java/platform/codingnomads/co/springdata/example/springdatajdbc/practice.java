package platform.codingnomads.co.springdata.example.springdatajdbc;
import lombok.Data;
@Data
public class practice {
    private long id;
    private String firstname, lastname;

    public practice(long id, String firstname, String lastname){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

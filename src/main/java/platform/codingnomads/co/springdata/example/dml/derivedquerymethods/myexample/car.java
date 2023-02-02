package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class car {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
   @Column
   private String brand;
   @Column
   private String style;
   @Column
   private int mileage;
}

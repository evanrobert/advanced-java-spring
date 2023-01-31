package platform.codingnomads.co.springdata.example.ddl.manytomany.jointableexample;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (nullable = false)
    private int size;
    @Column
    private int color;
    @Column
    private String brand;
    @ManyToMany
    private Set<Wheel> wheels;
}

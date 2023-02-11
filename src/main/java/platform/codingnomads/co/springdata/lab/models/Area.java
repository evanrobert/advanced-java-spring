package platform.codingnomads.co.springdata.lab.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "areas")
@Builder
@ToString
public class Area implements Serializable {

    private static final long serialVersionUID = 153236560504273881L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "area_generator")
    private Long id;

    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "area")
    private List<Connection> connection;

    public void addConnection(Connection connection) {
        if (this.connection == null) {
            this.connection = new ArrayList<>(Collections.singletonList(connection));
        } else {
            this.connection.add(connection);
        }
    }
}



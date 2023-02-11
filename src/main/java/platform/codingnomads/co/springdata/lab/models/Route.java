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
@Table(name = "routes")
@Builder
@ToString
public class Route implements Serializable {

    private static final long serialVersionUID = -2624055642258734917L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "route_generator")
    private Long id;

    @Column(unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "origin_area_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_routes_origin_area_id")
    )
    private Area origin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_area_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_routes_destination_area_id")
    )
    private Area destination;
    @ManyToMany(mappedBy = "routes")
    private List<Connection> connections;

    @Builder
    public Route(Area origin, Area destination) {
        this.origin = origin;
        this.destination = destination;
        this.code = (origin.getCode()) + "-" + destination.getCode();

    }

    public void addConnection(Connection connection) {
        if (this.connections == null) {
            this.connections = new ArrayList<>(Collections.singletonList(connection));
        } else {
            this.connections.add(connection);
        }
    }
}


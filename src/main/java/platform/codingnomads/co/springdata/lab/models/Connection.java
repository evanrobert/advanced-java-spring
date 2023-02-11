package platform.codingnomads.co.springdata.lab.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "connections")
@Transactional
public class Connection implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "conn_generator")
    private long id;
    private String type;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    Area area;
    @ManyToMany
    @JoinTable(name = "con_route", joinColumns = @JoinColumn(name = "con_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<Route> routes;

    public Connection(String type, String name, Area area) {
        this.type = type;
        this.name = name;
        this.area = area;
        area.addConnection(this);
    }

    public Connection(String type, String name, Route route) {
        this.type = type;
        this.name = name;
        this.routes = List.of(route);
    }

    public void addRoutes(List<Route> routes) {
        if (routes != null) {
            routes.forEach(r -> r.addConnection(this));
        } else {
            routes = new ArrayList<>();

        }
        if (this.routes == null) {
            this.routes = routes;
        } else {
            this.routes.addAll(routes);
        }
    }

    @Override
    public String toString() {
        return "Connection{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';


    }
}

package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Food {
    private long id;
    private int cost;
    private String name;
    private String type;
    private double servingsize;

    public Food(long id, int cost, String name, String type, double serving_size) {
        this.id = id;
        this.cost = cost;
        this.name = name;
        this.type = type;
        this.servingsize = serving_size;
    }
}

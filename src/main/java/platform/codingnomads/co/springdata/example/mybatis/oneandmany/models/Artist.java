package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
//@ToString(exclude = "songs")
@Getter
@Setter
public class Artist {

    private Long id;

    private String name;

    private String bio;

    private ArrayList<Album> albums;
}

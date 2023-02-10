package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Song {

    private Long id;

    private String name;

    private String album;

    private Artist artist;

    //song length in seconds
    private int songLength;

    public Song(String name, String album, Artist artist, int songLength) {
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.songLength = songLength;
    }
}


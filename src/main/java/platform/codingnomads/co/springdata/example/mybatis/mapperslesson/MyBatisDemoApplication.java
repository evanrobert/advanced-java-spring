package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "songs_table.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            Song song5 = new Song();
            song5.setName("Otherside");
            song5.setAlbum_name("Red hot chili peppers");
            song5.setArtist_name("Red hot chili peppers");
            song5.setSong_length(300);

            Song song4 = new Song();
            song4.setName("Backseat Freestyle");
            song4.setAlbum_name("Maad city");
            song4.setArtist_name("Kendrick lamar");
            song4.setSong_length(250);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);
            songMapper.insertNewSong(song5);
            songMapper.insertNewSong(song4);


            Song song3 = songMapper.getSongById(1L);

            ArrayList<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);

            longSongs.forEach(System.out::println);

            System.out.println(song3.toString());
            songMapper.deleteName("Backseat Freestyle");
            songMapper.getSongsWithLengthGreaterThan(220);
            songMapper.getSongsByArtist("Red hot chili peppers");
            songMapper.getAlbums("Orca");


        };
    }
}

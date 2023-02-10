package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@ToString


public class Album {
  private   String artist;
    private String name;
    private String year;
    private ArrayList<Song> songs;

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public ArrayList<Song> getSongs() {
    return songs;
  }

  public void setSongs(ArrayList<Song> songs) {
    this.songs = songs;
  }
}

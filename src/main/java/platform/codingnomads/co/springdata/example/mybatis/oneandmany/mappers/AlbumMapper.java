package platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Album;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Artist;


@Mapper
public interface AlbumMapper {
    @Insert("INSERT INTO mybatis.albums (artist,name,year) VALUES (#{artist},#{name},#{year};")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewArtist(Album album);
    @Select("SELECT * FROM mybatis.albums WHERE year = #{param1};")
    void GetYear();
    @Select("SELECT * FROM mybatis.album WHERE id = #{param1};")
    Artist getAlbumById(Long id);

}

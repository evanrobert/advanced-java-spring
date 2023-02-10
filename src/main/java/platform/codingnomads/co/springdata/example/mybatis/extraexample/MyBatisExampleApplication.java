package platform.codingnomads.co.springdata.example.mybatis.extraexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.ChapterMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.ImageMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.LessonMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.SectionMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Chapter;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Image;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Lesson;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Section;

import java.util.ArrayList;

@SpringBootApplication
public class MyBatisExampleApplication implements CommandLineRunner {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "database_structure.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    LessonMapper lessonMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    SectionMapper sectionMapper;

    public static void main(String[] args) {
        SpringApplication.run(MyBatisExampleApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
sectionMapper.insertNewSection("section 1");
sectionMapper.insertNewSection("section 2");
chapterMapper.insertNewChapter("chapter",3L);
chapterMapper.insertNewChapter("THIS IS ALSO A CHAPTER ",4L);
        lessonMapper.insertNewLesson("new lesson practice", "WE ARE MAING AN EXAMPLE",5L);
        chapterMapper.deleteChapterById(5L);





















    }
}

package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface FoodMapper {
    @Insert(" INSERT INTO mybatis.Food " +
            "(cost, name, type, serving_size) " +
            "VALUES (#{cost}, #{name}, #{type}, #{servingsize});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewFood(Food food);

    @Select("SELECT * " + "FROM mybatis.Food " +
            "WHERE id = #{param1};")

    @Results(
            id = "foodresultmapper",
            value = {
                    @Result(property = "cost", column = "cost"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "type", column = "type"),
                    @Result(property = "servingsize", column = "serving_size")
            })
    Food getFoodByID(Long id);

    @Select("SELECT *" + "FROM mybatis.Food" +
            "WHERE name = #{param1};")
    @ResultMap("foodresultmapper")
    ArrayList<Food> getFoodByName(String name);

@Select("SELECT *" + "FROM mybatis.Food" + "WHERE type = #{param};")
        @ResultMap("foodresultmapper")
ArrayList<Food> getFoodByType(String type);
@Update("UPDATE mybatis.songs" + "SET cost = #{cost},name = #{name},type =#{type} servingsize = #{serving_size}" + "WHERE id = #{id};")
    void uodate(Food food);
}


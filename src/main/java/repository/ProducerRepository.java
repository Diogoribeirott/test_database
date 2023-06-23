package repository;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import conn.ConnectionFactory;
import dominio.Produce;


public class ProducerRepository {

    public static void save(Produce producer){
      String sql = "INSERT INTO `anime_store`.`produce` (`name`) VALUES ('%s');".formatted(producer.getName());
      try(Connection conn= ConnectionFactory.getConnection();
      Statement stmt= conn.createStatement()){
        int executeUpdate = stmt.executeUpdate(sql);

        System.out.println(executeUpdate);
        System.out.println("Add sucess");

      }catch(SQLException e){
        System.out.println("Error while trying to insert produce  ".formatted(producer.getName()));
        e.printStackTrace();
      }
    }
    
    public static void Delete(int id){
      String sql = "DELETE FROM `anime_store`.`produce` WHERE (`id` = '%d');".formatted(id);
      try(Connection conn= ConnectionFactory.getConnection();
      Statement stmt= conn.createStatement()){
        int executeUpdate = stmt.executeUpdate(sql);

        System.out.println(executeUpdate);
        System.out.println("delete sucess "+id);
      }catch(SQLException e){
        System.out.println("Error while trying to insert produce  ".formatted(id));
        e.printStackTrace();
      }
    }

      public static void Update(Produce produce){
      String sql = "UPDATE `anime_store`.`produce` SET `name` = '%s' WHERE (`id` = '%d');".formatted(produce.getName(),produce.getId());
      try(Connection conn= ConnectionFactory.getConnection();
      Statement stmt= conn.createStatement()){
        int executeUpdate = stmt.executeUpdate(sql);

        System.out.println(executeUpdate);
        System.out.println("UPDATE sucess "+produce.getId());
      }catch(SQLException e){
        System.out.println("Error while trying to insert produce  ".formatted(produce.getId()));
        e.printStackTrace();
      }
    }
    public static List<Produce> findAll(){
    return findByName("");
    }

    public static List<Produce> findByName(String name){
      String sql = "select id, name from anime_store.produce where name like '%%%s%%';".formatted(name);
      List<Produce> producers = new ArrayList<>();
      try(Connection conn= ConnectionFactory.getConnection();
      Statement stmt= conn.createStatement();
      ResultSet rs =stmt.executeQuery(sql)){
        
        while(rs.next()){
          int idDataBase = rs.getInt("id");
          String nameDataBase = rs.getString("name");

          Produce produce = Produce.ProducerBuilder
                .Build()
                .idBuild(idDataBase)
                .nameBuilder(nameDataBase)
                .build();
          producers.add(produce);

        };

      }catch(SQLException e){
        e.printStackTrace();
      }
      return producers;
    }

    public static void showProduceAll(){
      String sql = "select * from anime_store.produce;";
      try(Connection conn= ConnectionFactory.getConnection();
      Statement stmt= conn.createStatement();
      ResultSet rs =stmt.executeQuery(sql)){
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <=columnCount; i++) {
          System.out.println("table name : "+metaData.getTableName(i));
          System.out.println("Column name: "+metaData.getColumnName(i));
          System.out.println("Column size :"+metaData.getColumnDisplaySize(i));
          System.out.println("Column Type: "+metaData.getColumnTypeName(i));
          
        }

      }catch(SQLException e){
        e.printStackTrace();
      }
    }


}
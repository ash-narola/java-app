package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Vishal Kotecha
 */
@Repository
public class DemoDao {


  @Autowired
  private DataSource dataSource;

  public List<User> findAllUsers(){
    List<User> users = new ArrayList<>();
    String sql = "SELECT * FROM USER";
    try (Connection conn = dataSource.getConnection()) {
      PreparedStatement ps = conn.prepareStatement(sql);
      User customer = null;
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        customer = new User(
            rs.getString("NAME")
        );
      }
      rs.close();
      ps.close();
      users.add(customer);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return users;
  }

}

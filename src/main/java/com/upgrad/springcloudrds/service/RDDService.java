/**
 *
 */
package com.upgrad.springcloudrds.service;

import com.upgrad.springcloudrds.Entity.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Vishwa 10th June 2021
 */
@Service
public class RDDService {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public RDDService(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Transactional(readOnly = true)
  public List<Student> all() {
    return this.jdbcTemplate.query("SELECT * FROM Student", new RowMapper<Student>() {
      @Override
      public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Student(resultSet.getString("name"), resultSet.getInt("age"));
      }
    });
  }

  @Transactional
  public void store(Student student) {
    this.jdbcTemplate.update("INSERT INTO Student(name, age) VALUES (?,?)", student.getName(), student.getAge());
  }
}

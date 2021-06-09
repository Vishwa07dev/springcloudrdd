package com.upgrad.springcloudrds;

import com.upgrad.springcloudrds.Entity.Student;
import com.upgrad.springcloudrds.service.RDDService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by Vishwa 10th June 2021
 */
@SpringBootTest
class SpringcloudrdsApplicationTests {

  @Autowired
  private RDDService rddService;

  @Test
  void testCurrentDate() {
    rddService.store(new Student("Vishwa", 29));

    List<Student> students = rddService.all();

    System.out.println(students.toString());
  }
}

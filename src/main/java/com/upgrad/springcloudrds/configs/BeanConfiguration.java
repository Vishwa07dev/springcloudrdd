/**
 *
 */
package com.upgrad.springcloudrds.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.awspring.cloud.jdbc.config.annotation.RdsInstanceConfigurer;
import io.awspring.cloud.jdbc.datasource.TomcatJdbcDataSourceFactory;


/**
 * Created by Vishwa 10th June 2021
 */
@Configuration
public class BeanConfiguration {
  @Bean
  public RdsInstanceConfigurer instanceConfigurer() {
    return () -> {
      TomcatJdbcDataSourceFactory dataSourceFactory = new TomcatJdbcDataSourceFactory();
      dataSourceFactory.setInitialSize(10);
      dataSourceFactory.setValidationQuery("SELECT 1 FROM DUAL");
      return dataSourceFactory;
    };
  }
}

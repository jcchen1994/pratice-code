package unknow.webproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@MapperScan("unknow.daoproject.mapper")
public class WebProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(WebProjectApplication.class, args);
  }

}


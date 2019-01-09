package unknow.webproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("unknow.daoproject.mapper")
@EnableCaching
public class WebProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(WebProjectApplication.class, args);
  }

}


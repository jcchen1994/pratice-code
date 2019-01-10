package unknow.toolproject;

import unknow.toolproject.redis.RedisClient;

/*
@SpringBootApplication
*/
public class ToolProjectApplication {

  public static void main(String[] args) {
/*
    SpringApplication.run(ToolProjectApplication.class, args);
*/
    RedisClient redisClient = RedisClient.getInstance("192.168.2.218",
        6379,"1234567");
    System.out.println(redisClient.get("uc"));
  }

}


package unknow.toolproject;

import redis.clients.jedis.Jedis;
import unknow.toolproject.redis.RedisClient;

/*
@SpringBootApplication
*/
public class ToolProjectApplication {

  public static void main(String[] args) {
/*
    SpringApplication.run(ToolProjectApplication.class, args);
*/
    RedisClient redisClient = RedisClient.getInstance("10.211.55.11",
        6379,"123456");
    try (Jedis jedis = redisClient.getJedis()){
      jedis.lpush("aa", "bb", "cc");
      System.out.println(jedis.lpop("aa"));
      System.out.println(jedis.lpop("aa"));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

}


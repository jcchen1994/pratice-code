package unknow.toolproject.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {

  private static JedisPool jedisPool;//非切片连接池
  private static RedisClient instance;

  private RedisClient(String redisIp, int redisPort, String pass) {
    initialPool(redisIp, redisPort, pass);
  }

  public static RedisClient getInstance(String redisIp, int redisPort, String pass) {
    if(instance == null){
      synchronized (RedisClient.class) {
        if(instance == null){
          instance = new RedisClient(redisIp, redisPort, pass);
        }
      }
    }
    return instance;
  }

  /**
   * 初始化非切片池
   */
  private void initialPool(String redisIp, int redisPort,String pass) {
    JedisPoolConfig config = new JedisPoolConfig();
    config.setMaxIdle(10);
    config.setMaxTotal(50);
    config.setMaxWaitMillis(10000);
    config.setTestOnBorrow(true);
    config.setTestOnReturn(true);
    if (pass == null) {
      jedisPool = new JedisPool(config, redisIp, redisPort);
    } else {
      jedisPool = new JedisPool(config, redisIp, redisPort, 10000, pass);
    }
  }

  public void put(String key, String value) {
     try (Jedis jedis = jedisPool.getResource()) {
      jedis.set(key, value);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String get(String key) {
    try (Jedis jedis = jedisPool.getResource()){

      return jedis.get(key);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void publish(String channel, String message) {
    try (Jedis jedis = jedisPool.getResource()) {
      jedis.publish(channel, message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Jedis getJedis() {
    return jedisPool.getResource();
  }
}
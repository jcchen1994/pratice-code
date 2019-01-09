package unknow.webproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import unknow.daoproject.domain.User;
import unknow.daoproject.mapper.UserMapper;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  @Cacheable(value = "object", key = "#id")
  public User getUsers(String id) {
    System.out.println("read from database");
    return userMapper.selectByPrimaryKey(Integer.valueOf(id));
  }
}

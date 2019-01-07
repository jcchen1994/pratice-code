package unknow.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unknow.daoproject.domain.User;
import unknow.daoproject.mapper.UserMapper;

@RestController
public class Controller {
  @Autowired
  public UserMapper userMapper;
  @RequestMapping("/hi")
  public String hi()  {
    User user = userMapper.findUserById(1);
    System.out.println(user);
    System.out.println(user.name);
    return "hi";
  }
}

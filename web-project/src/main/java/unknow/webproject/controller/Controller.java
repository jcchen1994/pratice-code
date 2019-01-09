package unknow.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unknow.daoproject.domain.User;
import unknow.daoproject.mapper.UserMapper;
import unknow.webproject.service.UserService;

@RestController
public class Controller {

  @Autowired
  public UserMapper userMapper;

  @Autowired
  public UserService userService;

  @RequestMapping("/hi")
  public String hi()  {
    User user = userService.getUsers("1");
    return user.getPass();
  }
}

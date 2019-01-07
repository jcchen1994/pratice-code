package unknow.daoproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import unknow.daoproject.domain.User;

@Mapper
@Component("userMapper")
public interface UserMapper {
  User findUserById(Integer id);
}

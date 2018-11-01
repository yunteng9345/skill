package com.jishou.schoolfellow.Dao;

import com.jishou.schoolfellow.model.Role;
import com.jishou.schoolfellow.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginMapper {
    Role selectRoleByRidAndRpw(Role role);
    List<Role> selectAllRole();
    Integer deletRoleByRno(Role role);
    Integer addRole(Role role);
    List<User> allUser();
    List<User> allUserByRname(Role role);
    Integer deleteUserByUno(User user);

    Integer alterUserByUno22(User user);
    Integer alterUserByUno33(User user);
    Integer deleteUserByUno1(User user);
    Integer addUser(User user);
    Integer alterUserByUno(User user);
    Integer alterUserByUno1(User user);
    Integer quxiao(User user);
    User selectOneUser(User user);
    Integer lixiao(User user);
    List<User> allUser11();
    User selectREG(User user);

}

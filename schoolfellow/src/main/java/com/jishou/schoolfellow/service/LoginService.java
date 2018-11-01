package com.jishou.schoolfellow.service;

import com.jishou.schoolfellow.Dao.LoginMapper;
import com.jishou.schoolfellow.model.Role;
import com.jishou.schoolfellow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    //查询用户密码是否符合
    public  Role selectRoleByRidAndRpw(Role role){ return  loginMapper.selectRoleByRidAndRpw(role);}
    public  List<Role> selectAllRole(){return  loginMapper.selectAllRole();}
    public  Integer deletRoleByRno(Role role){return  loginMapper.deletRoleByRno(role);}
    public  Integer addRole(Role role){return  loginMapper.addRole(role);}
    public  List<User> allUser(){return  loginMapper.allUser();}
    public List<User> allUserByRname(Role role){return  loginMapper.allUserByRname(role);}
    public  Integer deleteUserByUno(User user){return  loginMapper.deleteUserByUno(user); }
    public  Integer deleteUserByUno1(User user){return  loginMapper.deleteUserByUno1(user); }
    public   Integer addUser(User user){return  loginMapper.addUser(user);}
    public  Integer alterUserByUno(User user){return  loginMapper.alterUserByUno(user);}

    public  Integer alterUserByUno22(User user){return  loginMapper.alterUserByUno22(user);}
    public  Integer alterUserByUno33(User user){return  loginMapper.alterUserByUno33(user);}
    public Integer alterUserByUno1(User user){return  loginMapper.alterUserByUno1(user);}
    public    Integer quxiao(User user){return  loginMapper.quxiao(user);}
    public User selectOneUser(User user){return  loginMapper.selectOneUser(user);}
    public  Integer lixiao(User user){return  loginMapper.lixiao(user);}

    public  List<User> allUser11(){return  loginMapper.allUser11();}
    public User selectREG(User user){return loginMapper.selectREG(user);}
}

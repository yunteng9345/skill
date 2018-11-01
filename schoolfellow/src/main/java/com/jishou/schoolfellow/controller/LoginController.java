package com.jishou.schoolfellow.controller;

import com.jishou.schoolfellow.model.Role;
import com.jishou.schoolfellow.model.User;
import com.jishou.schoolfellow.service.LoginService;
import com.jishou.schoolfellow.tools.POI_Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/xy")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /*
    登陆页面
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showindex(ModelMap mode) {
        mode.addAttribute("role", new Role());
        mode.addAttribute("mes", " ");
        return "login";
    }
    @RequestMapping(value = "/zhuxiao", method = RequestMethod.GET)
    public String zhuxiao(ModelMap mode) {
        mode.addAttribute("role", new Role());
        return "redirect:index";
    }

    /*
    用户登陆认证
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String adminLogin(@ModelAttribute(value = "role") Role role, ModelMap mode, HttpServletRequest request) {

        ///超级管理员
        if (role.getRid().equals("admin") && role.getRpw().equals("jishou$123")) {
            mode.addAttribute("allrole", loginService.selectAllRole());
            mode.addAttribute("alluser", loginService.allUser());
            HttpSession session = request.getSession();
            session.setAttribute("nowrole1", role);
            return "super_admin";
        } else if (loginService.selectRoleByRidAndRpw(role) == null) {
            mode.addAttribute("mes", "账户或密码错误！");
            return "login";
        }
        //普通管理员

        Role role1 = loginService.selectRoleByRidAndRpw(role);

        HttpSession session = request.getSession();
        session.setAttribute("nowrole", role1);
        mode.addAttribute("role",role1);

        mode.addAttribute("alluser", loginService.allUserByRname(loginService.selectRoleByRidAndRpw(role1)));
        return "admin";
    }

    /*
    超级管理员界面删除账号
     */
    @RequestMapping(value = "/delete")
    public String deleteRole(String id, ModelMap mode,HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        Role role=(Role)session.getAttribute("nowrole");
//        Role role1=(Role)session.getAttribute("nowrole1");
//        if(role==null||role1==null)
//        {
//            mode.addAttribute("role", new Role());
//            return "login";
//        }
        //System.out.println(id);
        Role role2 = new Role();
        role2.setRno(Integer.parseInt(id));
        loginService.deletRoleByRno(role2);

        mode.addAttribute("role", new Role());
        mode.addAttribute("allrole", loginService.selectAllRole());
        mode.addAttribute("alluser", loginService.allUser());
        return "super_admin";
    }

    /*
    超级管理员界面添加账号
     */
    @RequestMapping(value = "/addRole")
    public String deleteRole(@ModelAttribute(value = "role") Role role, ModelMap mode,HttpServletRequest request) {
        HttpSession session = request.getSession();
       Role role3=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
       if(role3==null&&role1==null)
        {
           mode.addAttribute("role", new Role());
            return "login";
       }
        loginService.addRole(role);
        mode.addAttribute("role", new Role());
        mode.addAttribute("allrole", loginService.selectAllRole());
        mode.addAttribute("alluser", loginService.allUser());
        return "super_admin";
    }

    /*
    删除用户
     */
    @RequestMapping(value = "/deleteUserByUno")
    public String deleteUserByUno(String id, ModelMap mode,HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        Role role=(Role)session.getAttribute("nowrole");
//        Role role1=(Role)session.getAttribute("nowrole1");
//        if(role==null||role1==null)
//        {
//            mode.addAttribute("role", new Role());
//            return "login";
//        }
        User user = new User();
        user.setUno(Integer.parseInt(id));
        loginService.deleteUserByUno(user);

        mode.addAttribute("role", new Role());
        mode.addAttribute("allrole", loginService.selectAllRole());
        mode.addAttribute("alluser", loginService.allUser());
        return "super_admin";
    }

    @RequestMapping(value = "/deleteUserByUno1")
    public String deleteUserByUno1(String id, String name, ModelMap mode, HttpServletRequest request) {
        HttpSession session = request.getSession();
//        Role role=(Role)session.getAttribute("nowrole");
//        Role role1=(Role)session.getAttribute("nowrole1");
//        if(role==null||role1==null)
//        {
//            mode.addAttribute("role", new Role());
//            return "login";
//        }
        User user = new User();
        user.setUno(Integer.parseInt(id));
        loginService.deleteUserByUno1(user);

        //session.getAttribute("nowrole");
        // /System.out.println(name);
        mode.addAttribute("alluser", loginService.allUserByRname((Role) session.getAttribute("nowrole")));
        return "admin";
    }

    /*
    添加校友
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(ModelMap mode,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
       if(role==null&&role1==null)
       {
           mode.addAttribute("role", new Role());
           return "login";

       }
       User user = new User();
       user.setUrname(role.getRname());

       mode.addAttribute("user", user);
       return "adduser";
    }
    @RequestMapping(value = "/returnGL", method = RequestMethod.GET)
    public String returnGL(ModelMap mode,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            return "login";
        }
        mode.addAttribute("allrole", loginService.selectAllRole());
        mode.addAttribute("alluser", loginService.allUser());
        return "super_admin";
    }

    @RequestMapping(value = "/reflush", method = RequestMethod.GET)
    public String reflush(ModelMap mode,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            return "login";
        }
        mode.addAttribute("alluser", loginService.allUser());
        return "super_admin";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(value = "user") User user, ModelMap mode, HttpServletRequest request) {
        HttpSession session = request.getSession();
       Role role=(Role)session.getAttribute("nowrole");
//        Role role1=(Role)session.getAttribute("nowrole1");
//        if(role==null||role1==null)
//        {
//            mode.addAttribute("role", new Role());
//            return "login";
//        }
        //HttpSession session = request.getSession();
        //Role role2 = (Role) session.getAttribute("nowrole");
        Date date =new Date();
        user.setUtime(date);
        user.setJt("1");
        //user.setUtime(role.getRname());
        user.setUrname(role.getRname());
        String[] args=request.getParameterValues("hd");
        if(args!=null){

            for (String s:args){
                if(s.equals("1")){
                    user.setHd1("1、沈从文学术论坛");
                }
                if(s.equals("2")){
                    user.setHd2("2、沈从文雕像揭幕");
                }
                if(s.equals("3")){
                    user.setHd3("3、校地合作签约");
                }
                if(s.equals("4")){
                    user.setHd4("4、60周年校庆晚会");
                }
                if(s.equals("5")){
                    user.setHd5("5、民族教育成果展");

                }
                if(s.equals("6")){
                    user.setHd6("6、参观文化场馆");

                }
            }
        }
        //System.out.println(user.getUrname());

        loginService.addUser(user);
        mode.addAttribute("role",role);
        mode.addAttribute("alluser", loginService.allUserByRname(role));
        return "admin";

    }

    /*
    修改用户信息
     */

    @RequestMapping(value = "/alterUser", method = RequestMethod.GET)
    public String alterUser(String id, String name,String phone,String company,String uclass,
                            String room,String remark,String ltime,String jt,
                            String hd1,String hd2,String hd3,String hd4,String hd5,String hd6,ModelMap mode, HttpServletRequest request) {
        HttpSession session = request.getSession();
       Role role=(Role)session.getAttribute("nowrole");
       Role role1=(Role)session.getAttribute("nowrole1");
      if(role==null&&role1==null)
       {
           mode.addAttribute("role", new Role());
           return "login";
       }
        //HttpSession session = request.getSession();
        session.setAttribute("nowid", id);
        //mode.addAttribute("name", name);
        User user =new User();
        user.setUname(name);
        user.setUphone(phone);
        user.setUclass(uclass);
        user.setUcompany(company);
        user.setUremark(remark);
        user.setUroom(room);
        user.setLtime(ltime);
        user.setHd1(hd1);
        user.setHd2(hd2);
        user.setHd3(hd3);
        user.setHd4(hd4);
        user.setHd5(hd5);
        user.setHd6(hd6);
        //user.setJt(jt);
        Date date =new Date();
        user.setUtime(date);

        mode.addAttribute("user", user);
        return "alteruser";
    }


    @RequestMapping(value = "/alterUser1", method = RequestMethod.GET)
    public String alterUser1(String id, String name,String phone,String company,String uclass,
                            String room,String remark,String ltime,String jt,
                             String hd1,String hd2,String hd3,String hd4,String hd5,String hd6,ModelMap mode, HttpServletRequest request) {
       HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
           return "login";
        }
       // HttpSession session = request.getSession();
        session.setAttribute("nowSuperid", id);
        session.setAttribute("nowname", name);
        User user =new User();
        user.setUname(name);
        user.setUphone(phone);
        user.setUclass(uclass);
        user.setUcompany(company);
        user.setUremark(remark);
        user.setUroom(room);
        user.setLtime(ltime);
        user.setHd1(hd1);
        user.setHd2(hd2);
        user.setHd3(hd3);
        user.setHd4(hd4);
        user.setHd5(hd5);
        user.setHd6(hd6);
        //user.setJt(jt);
        System.out.println(user.getHd6());

        mode.addAttribute("user", user);

        return "alteruser1";
    }



    @RequestMapping(value = "/alterUserByUno")
    public String alterUserByUno44(@ModelAttribute(value = "user") User user, ModelMap mode, HttpServletRequest request) {
        HttpSession session = request.getSession();
       Role role=(Role)session.getAttribute("nowrole");
//        Role role1=(Role)session.getAttribute("nowrole1");
//        if(role==null||role1==null)
//        {
//            mode.addAttribute("role", new Role());
//            return "login";
//        }
        //HttpSession session = request.getSession();
        String id = (String)session.getAttribute("nowid");
        //Role role =(Role) session.getAttribute("nowrole");
        user.setUno(Integer.parseInt(id));
        user.setUrname(role.getRname());



        String[] args=request.getParameterValues("hd");
        if(args!=null){

        for (String s:args){
            if(s.equals("1")){
                user.setHd1("1、沈从文学术论坛");
            }
            if(s.equals("2")){
                user.setHd2("2、沈从文雕像揭幕");
            }
            if(s.equals("3")){
                user.setHd3("3、校地合作签约");
            }
            if(s.equals("4")){
                user.setHd4("4、60周年校庆晚会");
            }
            if(s.equals("5")){
                user.setHd5("5、民族教育成果展");

            }
            if(s.equals("6")){
                user.setHd6("6、参观文化场馆");

            }

           }
        }
        User user1 = loginService.selectOneUser(user);
        if(user1.getJt()==null){
            System.out.println("用户第一次签到");
            Date date =new Date();
            user.setUtime(date);
            user.setJt("1");
            loginService.alterUserByUno(user);

        }
        else {
            System.out.println("用户第二次签到");
            user.setJt("1");
            loginService.alterUserByUno22(user);

        }



//        User user1 = loginService.selectOneUser(user);
//        if(user1.getJt()=="1"){
//            Date date =new Date();
//            user.setUtime(date);
//            user.setJt("2");
//            loginService.alterUserByUno(user);
//        }
//        if(user1.getJt()=="2")  {
//            loginService.alterUserByUno22(user);
//        }

        mode.addAttribute("role",role);
        mode.addAttribute("alluser", loginService.allUserByRname(role));
        return "admin";

    }


//    @RequestMapping(value = "/alterUser1", method = RequestMethod.GET)
//    public String alterUser(String id,ModelMap mode, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.setAttribute("nowSuperid", id);
//        mode.addAttribute("user", new User());
//
//        return "alteruser1";
//    }


    @RequestMapping(value = "/alterUserByUno1")
    public String alterUserByUno(@ModelAttribute(value = "user") User user, ModelMap mode, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            return "login";
        }

        //HttpSession session = request.getSession();
        String id = (String)session.getAttribute("nowSuperid");
        String name = (String)session.getAttribute("nowname");
        user.setUno(Integer.parseInt(id));
        //user.setUrname(name);
       // User user1 = loginService.selectOneUser(user);
        //if(user1.getUtime()==null) {
//        User user1 = loginService.selectOneUser(user);
//        if(user1.getJt()==null){
//            Date date =new Date();
//            user.setUtime(date);
//            user.setJt("1");
//        }
     //   User user1 = loginService.selectREG(user);
//        if(user1==null){
//            Date date =new Date();
//            user.setUtime(date);
//        }
     //       Date date = new Date();
     //       user.setUtime(date);
//        Date date =new Date();
//        user.setUtime(date);
        String[] args=request.getParameterValues("hd");
        if(args!=null){

        for (String s:args){
            if(s.equals("1")){
                user.setHd1("1、沈从文学术论坛");
            }
            if(s.equals("2")){
                user.setHd2("2、沈从文雕像揭幕");
            }
            if(s.equals("3")){
                user.setHd3("3、校地合作签约");
            }
            if(s.equals("4")){
                user.setHd4("4、60周年校庆晚会");
            }
            if(s.equals("5")){
                user.setHd5("5、民族教育成果展");

            }
            if(s.equals("6")){
                user.setHd6("6、参观文化场馆");

            }
          }
        }
        User user1 = loginService.selectOneUser(user);
        if(user1.getJt()==null){
            System.out.println("用户第一次签到");
            Date date =new Date();
            user.setUtime(date);
            user.setJt("1");
            loginService.alterUserByUno1(user);

        }

        else {
            System.out.println("用户第二次签到");
            user.setJt("1");
            loginService.alterUserByUno33(user);
        }

        //loginService.alterUserByUno1(user);
        mode.addAttribute("user", new User());
        mode.addAttribute("role", new Role());
        mode.addAttribute("allrole", loginService.selectAllRole());
        mode.addAttribute("alluser", loginService.allUser());
        return "super_admin";
    }


    @RequestMapping(value = "/addUser1", method = RequestMethod.GET)
    public String addUser1(ModelMap mode,HttpServletRequest request) {
       HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            return "login";
        }
      //  User user = new User();
      //  user.setUrname(role.getRname());

        mode.addAttribute("user", new User());
        return "adduser1";
    }


    @RequestMapping(value = "/add1", method = RequestMethod.POST)
    public String add1(@ModelAttribute(value = "user") User user, ModelMap mode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            return "login";
        }
        Date date =new Date();
        user.setUtime(date);
        String[] args=request.getParameterValues("hd");
        if(args!=null){

            for (String s:args){
                if(s.equals("1")){
                    user.setHd1("1、沈从文学术论坛");
                }
                if(s.equals("2")){
                    user.setHd2("2、沈从文雕像揭幕");
                }
                if(s.equals("3")){
                    user.setHd3("3、校地合作签约");
                }
                if(s.equals("4")){
                    user.setHd4("4、60周年校庆晚会");
                }
                if(s.equals("5")){
                    user.setHd5("5、民族教育成果展");

                }
                if(s.equals("6")){
                    user.setHd6("6、参观文化场馆");

                }
            }
        }
        user.setJt("1");
        loginService.addUser(user);

        mode.addAttribute("role", new Role());
        mode.addAttribute("allrole", loginService.selectAllRole());
        mode.addAttribute("alluser", loginService.allUser());
        return "super_admin";

    }
    @RequestMapping(value = "/addjs", method = RequestMethod.GET)
    public String addjs(ModelMap mode,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            return "login";
        }
        mode.addAttribute("allrole", loginService.selectAllRole());
        mode.addAttribute("role", new Role());
        return "addjs";
    }

    @RequestMapping(value = "/quxiao", method = RequestMethod.GET)
    public String add1(String id, ModelMap mode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            return "login";
        }
        User user = new User();
        user.setUno(Integer.parseInt(id));
        loginService.quxiao(user);

        mode.addAttribute("role", new Role());
        mode.addAttribute("allrole", loginService.selectAllRole());
        mode.addAttribute("alluser", loginService.allUser());
        return "super_admin";

    }

    @RequestMapping(value = "/lixiao", method = RequestMethod.GET)
    public String lixiao(String id, ModelMap mode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            return "login";
        }
        User user = new User();
        user.setUno(Integer.parseInt(id));

        Date date =new Date();
        SimpleDateFormat formatter22 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = formatter22.format(date);
        user.setLtime(time);

        loginService.lixiao(user);

        mode.addAttribute("role", new Role());
        mode.addAttribute("allrole", loginService.selectAllRole());
        mode.addAttribute("alluser", loginService.allUser());
        return "super_admin";

    }

    @RequestMapping(value = "/lixiao1")
    public String lixiao1(String id, ModelMap mode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            return "login";
        }

        User user =new User();
        user.setUno(Integer.parseInt(id));
        Date date =new Date();
        SimpleDateFormat formatter22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = formatter22.format(date);
        user.setLtime(time);
        loginService.lixiao(user);
        mode.addAttribute("role",role);
        mode.addAttribute("alluser", loginService.allUserByRname(role));
        return "admin";
    }


    @RequestMapping(value = "/quxiao1")
    public String quxiao1(String id, ModelMap mode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            return "login";
        }
        User user =new User();
        user.setUno(Integer.parseInt(id));
        loginService.quxiao(user);


        mode.addAttribute("alluser", loginService.allUserByRname(role));
        return "admin";
    }



    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    public void downloadFile1(HttpServletRequest request, HttpServletResponse response,ModelMap mode) {
        HttpSession session = request.getSession();
        Role role=(Role)session.getAttribute("nowrole");
        Role role1=(Role)session.getAttribute("nowrole1");
        if(role==null&&role1==null)
        {
            mode.addAttribute("role", new Role());
            //return "login";
        }
        mode.addAttribute("allrole", loginService.selectAllRole());
        mode.addAttribute("alluser", loginService.allUser());

        /*
        文件生成
         */
        String path= this.getClass().getResource("/").getPath()+"schoolfellow.xls";
        //File file = new File("C:/User/yunteng/Desktop/schoolfellowList.xls");
        POI_Test.poi(loginService.allUser11(),path);

        /*
        文件下载
         */
        String fileName = "schoolfellow.xls";// 文件名
        if (fileName != null) {
            //设置文件路径
            File file = new File(this.getClass().getResource("/").getPath()+"schoolfellow.xls");
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    //os.close();//我加的
                    //return "super_admin";

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {


                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        //return "super_admin";

    }


}

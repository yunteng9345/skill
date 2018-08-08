package com.example.datiproject.web;

import com.alibaba.fastjson.JSON;
import com.example.datiproject.entity.Timu;
import com.example.datiproject.service.DatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/timu")
public class DatiController {

    @Autowired
    private DatiService datiService;

    /*
    微信端json数据接口,通过关卡显示所有题目
     */
    @RequestMapping(value = "/dati",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    public @ResponseBody
    String timu(@RequestParam String guanka){

        Timu timu=new Timu();
        timu.setGuanka(guanka);
        List<Timu> timuList = datiService.selectByGk(timu);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("timu",timuList);
        return JSON.toJSONString(map);
    }
    /*
   微信端json数据接口，显示所有错误题目
    */
    @RequestMapping(value = "/errorTimu",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    public @ResponseBody
    String errorTimu(){

        List<Timu> timuList = datiService.selectByTno();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("timu",timuList);
        return JSON.toJSONString(map);
    }

    /*
     *显示所有题目信息
     * */

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public String showAllTimu(ModelMap mode){
        List<Timu> list = datiService.showAllTimu();
        mode.addAttribute("count",list.size());
        mode.addAttribute("timu",list);
        mode.addAttribute("timu1",new Timu());
       // mode.addAttribute("timu2",new Form());

        return  "index";
    }
    /*
     * 添加题目
     * */
    @RequestMapping(value = "/addTimu")
    public String addStu(@ModelAttribute(value="timu1")Timu  timu){
        timu.setIsError("0");
        datiService.addTimu(timu);
        System.out.println(timu.getAns());
        return  "redirect:show";
    }
    /*
     * 删除题目
     * */
    @RequestMapping(value = "/delet")
    public String deletStu(String tno){
        datiService.deleteTimu(tno);
        return  "redirect:show";
    }
    /*
     * 通过关卡搜索题目
     * */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(HttpServletRequest request,ModelMap mode){
        //datiService.deleteTimu(tno);
        Timu timu = new Timu();
        timu.setGuanka(request.getParameter("search"));
        List<Timu> timuList = datiService.selectByGk(timu);
        mode.addAttribute("count1",timuList.size());
        mode.addAttribute("timu",timuList);
        mode.addAttribute("timu1",new Timu());
        return  "index1";
    }
    /*
     * 加入错题本
     */
    @RequestMapping(value = "/erro", method = RequestMethod.GET)
    public @ResponseBody void addError(@RequestParam String tno){
        datiService.updateError(tno);
       System.out.println("加入错题本成功！");
    }
    /*
     * 移除错题本
     */
    @RequestMapping(value = "/yichu",method = RequestMethod.GET)
    public @ResponseBody  void yichu(String tno){
        datiService.yichuError(tno);
        System.out.println("移除错题成功！");
    }
}

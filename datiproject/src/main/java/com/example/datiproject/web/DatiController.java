package com.example.datiproject.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.datiproject.entity.Timu;
import com.example.datiproject.service.DatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/timu")
public class DatiController {

    @Autowired
    private DatiService datiService;

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
}

package com.example.datiproject.service;

import com.example.datiproject.dao.DatiMapper;
import com.example.datiproject.entity.Timu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatiService {

    @Autowired
    private DatiMapper datiMapper;
    /*
    通过关卡号查询所有对应的题目
     */
    public  List<Timu> selectByGk(Timu timu){return datiMapper.selectByGk(timu);}

    public  List<Timu> showAllTimu(){return  datiMapper.showAllTimu();}
    public  Integer addTimu(Timu timu){return datiMapper.addTimu(timu);}
    public Integer deleteTimu(String tno){return  datiMapper.deleteTimu(tno);}
    public Integer updateError(String tno){return  datiMapper.updateError(tno);}
    public  List<Timu> selectByTno(){return datiMapper.selectByTno();}

}

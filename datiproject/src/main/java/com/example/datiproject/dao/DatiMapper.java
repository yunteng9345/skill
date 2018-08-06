package com.example.datiproject.dao;

import com.example.datiproject.entity.Timu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatiMapper {
    /*
    通过关卡号查询所有对应的题目
     */
    List<Timu> selectByGk(Timu timu);
    List<Timu> showAllTimu();
    Integer addTimu(Timu timu);
    Integer deleteTimu(String tno);
   // List<Timu> searchByGk(Timu timu);

}

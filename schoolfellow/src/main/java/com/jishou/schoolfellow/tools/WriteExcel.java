package com.jishou.schoolfellow.tools;

import com.jishou.schoolfellow.model.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class WriteExcel {

    public static void write(OutputStream outputStream, List<User> userList) throws SQLException {
        //初始一个workbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        //List<Users> usersList = UsersDAO.getList();
        //创建单个sheet
        HSSFSheet sheet = workbook.createSheet("sheet0");
        //创建多行
        //创建第一行，设置列名
        HSSFRow row0 = sheet.createRow(0);
        for(int cellIndex = 0;cellIndex < 13;cellIndex++){
            HSSFCell cell = row0.createCell(cellIndex);
            switch(cellIndex){
                case 0:
                    cell.setCellValue("序号");
                    break;
                case 1:
                    cell.setCellValue("姓名");
                    break;
                case 2:
                    cell.setCellValue("单位");
                    break;
                case 3:
                    cell.setCellValue("职务");
                    break;
                case 4:
                    cell.setCellValue("电话");
                    break;
                case 5:
                    cell.setCellValue("住宿房间");
                    break;
                case 6:
                    cell.setCellValue("酒店");
                    break;
                case 7:
                    cell.setCellValue("备注");
                    break;
                case 8:
                    cell.setCellValue("注册时间");
                    break;
                case 9:
                    cell.setCellValue("离校时间");
                    break;
                case 10:
                    cell.setCellValue("交通住宿");
                    break;
                case 11:
                    cell.setCellValue("活动");
                    break;

//                case 7:
//                    cell.setCellValue("收获喜欢数");
//                    break;
            }
        }
        //创建剩余行
        for(int rowIndex = 1;rowIndex <= userList.size();rowIndex++){
            HSSFRow row = sheet.createRow(rowIndex);
            User user = userList.get(rowIndex-1);
            //创建多列
            for(int cellIndex = 0;cellIndex < 13;cellIndex++){
                HSSFCell cell = row.createCell(cellIndex);
                switch(cellIndex){
                    case 0:
                        cell.setCellValue(user.getUno());
                        break;
                    case 1:
                        cell.setCellValue(user.getUname());
                        break;
                    case 2:
                        cell.setCellValue(user.getUcompany());
                        break;
                    case 3:
                        cell.setCellValue(user.getUclass());
                        break;
                    case 4:
                        cell.setCellValue(user.getUphone());
                        break;
                    case 5:
                        cell.setCellValue(user.getUroom());
                        break;
                    case 6:
                        cell.setCellValue(user.getUrname());
                        break;
                    case 7:
                        cell.setCellValue(user.getUremark());
                        break;
                    case 8:
                        if(user.getUtime()!=null){
                            SimpleDateFormat formatter22 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            String time = formatter22.format(user.getUtime());
                            cell.setCellValue(time);
                        }
                        break;

                    case 9:
                        cell.setCellValue(user.getLtime());
                        break;
                    case 10:
                        cell.setCellValue(user.getJt());
                        break;
                    case 11:
                        String string="";
                        if(user.getHd1()!=null){

                            string = string+user.getHd1()+",";
                        }
                        if(user.getHd2()!=null){
                            string=string+user.getHd2()+",";
                        }
                         if(user.getHd3()!=null){
                            string=string+user.getHd3()+",";
                        }
                         if(user.getHd4()!=null){
                            string=string+user.getHd4()+",";
                        }
                         if(user.getHd5()!=null){
                            string=string+user.getHd5()+",";
                        }
                         if(user.getHd6()!=null){
                            string=string+user.getHd6()+",";
                        }
                        System.out.println(string);

                        cell.setCellValue(string);
                        break;

                }
            }
        }

        try {
           // workbook.write(outputStream);
            workbook.write(outputStream);
            //outputStream.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


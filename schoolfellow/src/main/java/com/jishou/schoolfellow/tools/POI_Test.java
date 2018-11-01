package com.jishou.schoolfellow.tools;

import com.jishou.schoolfellow.model.User;

import java.io.*;
import java.sql.SQLException;
import java.util.List;



public class POI_Test {

    public static void poi(List<User> userList,String path) {
        OutputStream out = null;
        try {

            out = new FileOutputStream(new File(path));
            WriteExcel.write(out, userList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}


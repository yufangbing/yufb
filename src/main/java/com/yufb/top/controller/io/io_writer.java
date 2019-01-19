package com.yufb.top.controller.printWriter;

import java.io.*;

public class io_writer {


    {
        try {
            FileOutputStream fos = new FileOutputStream("pw1.txt");
            //指定字符集，需要加上转换流
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            PrintWriter pw = new PrintWriter(osw,true);//true  具备自动行刷新
            pw.println("第一行");
            pw.println("第二行");
            pw.println("第三行");
            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

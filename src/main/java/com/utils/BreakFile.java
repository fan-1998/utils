package com.utils;

import java.io.*;

/**
 * @Description
 * @date 2022-11-24 17:03
 * @Author fanxg
 * 分割文件
 */
public class BreakFile {
    public static void main(String args[]) {

        try {

            FileReader read = new FileReader("D:/text.log");

            BufferedReader br = new BufferedReader(read);

            String row;


            int rownum = 1;


            int fileNo = 1;

            FileWriter fw = new FileWriter("D:/text"+fileNo +".txt");

            while ((row = br.readLine()) != null) {

                rownum ++;

                fw.append(row + "\r\n");


                if((rownum / 464183) > (fileNo - 1)){

                    fw.close();

                    fileNo ++ ;

                    fw = new FileWriter("D:/text"+fileNo +".txt");

                }

            }

            fw.close();

            System.out.println("rownum="+rownum+";fileNo="+fileNo);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}

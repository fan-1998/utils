package com.utils;

import java.io.*;

/**
 * @Description
 * @date 2022-08-07 16:03
 * @Author fanxg
 * 读取文件工具类
 */
public class ReadFile {
    public static void main(String[] args) {
        //单字节读取
        readFileByBytes001("D:\\个人\\Fan_笔记\\个人工具类\\读取文件\\test001.txt");
        //多字节读取
        readFileByBytes002("D:\\个人\\Fan_笔记\\个人工具类\\读取文件\\test001.txt");
        //单字符读取
        readFileByChars001("D:\\个人\\Fan_笔记\\个人工具类\\读取文件\\test001.txt");
        //多字符读取
        readFileByChars002("D:\\个人\\Fan_笔记\\个人工具类\\读取文件\\test001.txt");
        //行为单位读取文件
        readFileByLines("D:\\个人\\Fan_笔记\\个人工具类\\读取文件\\test001.txt");
        //随机读取
        readFileByRandomAccess("D:\\个人\\Fan_笔记\\个人工具类\\读取文件\\test001.txt");

        //========start将内容追加到文件尾部start===================//
        String fileName = "D:\\个人\\Fan_笔记\\个人工具类\\读取文件\\test001.txt";
        String content = "您好，我的朋友!";
        //按方法A追加文件
        appendMethodA(fileName, content);
        appendMethodA(fileName, "您好，我的朋友。。。。。\n");
        //显示文件内容
        readFileByLines(fileName);
        //按方法B追加文件
        appendMethodB(fileName, content);
        appendMethodB(fileName, "您好，我的朋友========= \n");
        //显示文件内容
        readFileByLines(fileName);
        //========end将内容追加到文件尾部end===================//

    }




//==========================start按字节读取文件内容start==================================================//
//以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件
    /**
     * 单字节读取
     * @param fileName
     */
    public static void readFileByBytes001(String fileName) {
        File file = new File(fileName);
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte = 0;
            //显示输入流中还剩的字节数
            ReadFile.showAvailableBytes(in);
            while ((tempbyte = in.read()) != -1) {
                //输入字符流
                System.out.write(tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    /**
     * 多字节读取
     * @param fileName
     */
    public static void readFileByBytes002(String fileName) {
        File file = new File(fileName);
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(fileName);
            //显示输入流中还剩的字节数
            ReadFile.showAvailableBytes(in);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                //输入字符流
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//==========================END按字节读取文件内容END==================================================//


//==========================start按字符读取文件内容start==================================================//
//以字符为单位读取文件，常用于读文本，数字等类型的文件
    /**
     * 单字符读取
     * @param fileName
     */
    public static void readFileByChars001(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar = 0;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 多字符读取
     * @param fileName
     */
    public static void readFileByChars002(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            char[] tempchars = new char[50];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length) && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

//==========================end按字节读取文件内容end==================================================//

//==========================start按行读取文件内容start==================================================//
//以行为单位读取文件，常用于读面向行的格式化文件

    /**
     * 行为单位读取文件
     * @param fileName
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

//==========================end按行读取文件内容end==================================================//

//==========================start随机读取文件内容start==================================================//
//随机读取文件内容

    /**
     * 随机读取
     * @param fileName
     */
    public static void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }

//==========================end随机读取文件内容end==================================================//
//==========================start将内容追加到文件尾部start==================================================//
    //将内容追加到文件尾部
    /**
     * A方法追加文件：使用RandomAccessFile
     * @param fileName
     * @param content
     */
    public static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * B方法追加文件：使用FileWriter
     * @param fileName
     * @param content
     */
    public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//==========================end随机读取文件内容end==================================================//
}

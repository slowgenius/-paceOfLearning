package slowgenius.someUtils.io;

import java.io.*;

/**
 * @author slowgenius
 * @date 1/6/2020 10:11 AM
 * @description
 */
public class IoExercise {

    public static void main(String[] args) {
        String str = "C:\\Users\\slowgenius\\Desktop\\test.txt";
        String text = "1324546576\n";
        mywrite(str, text);
    }
    public static void mywrite(String str,String text){
        File file = new File(str);    //1、建立连接
        OutputStream os = null;
        try {
            //2、选择输出流,以追加形式(在原有内容上追加) 写出文件 必须为true 否则为覆盖
            os = new FileOutputStream(file,true);
//            //和上一句功能一样，BufferedInputStream是增强流，加上之后能提高输出效率，建议
//            os = new BufferedOutputStream(new FileOutputStream(file,true));
            byte[] data = text.getBytes();    //将字符串转换为字节数组,方便下面写入
            os.write(data, 0, data.length);    //3、写入文件
            os.flush();    //将存储在管道中的数据强制刷新出去
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没有找到！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写入文件失败！");
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输出流失败！");
                }
            }
        }
    }

    public static void myRead(String filePath) {
        //读取文件(字节流)
        InputStream in = null;
        try {
            in = new FileInputStream("d:\\1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //写入相应的文件
        OutputStream out = null;
        try {
            out = new FileOutputStream("d:\\2.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //读取数据
        //一次性取多少字节
        byte[] bytes = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n = -1;
        //循环取出数据
        while (true) {
            try {
                if (!((n = in.read(bytes,0,bytes.length)) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            //转换成字符串
            String str = null;
            try {
                str = new String(bytes,0,n,"GBK");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println(str);
            //写入相关文件
            try {
                out.write(bytes, 0, n);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //关闭流
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

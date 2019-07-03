package inputstream;

import org.junit.Test;

import java.io.*;

public class InputStreamTest {

    @Test
    public void testFileInputStream() throws IOException {
        File file=new File("D:"+File.separator+"mydemo"+File.separator+"ToDo"+File.separator+"outline");
        FileInputStream fis=new FileInputStream(file);
        System.out.println("available result = "+fis.available());
        System.out.println("read result = "+fis.read());

        byte[] bs=new byte[10];
        fis.read(bs);
        fis.read(bs,0,10);
        for(byte b:bs){
            System.out.println(b+" "+(char)b);

        }

        fis.close();

    }

    @Test
    public void testFileOutputStream() throws IOException{
        File file=new File("D:"+File.separator+"mydemo"+File.separator+"ToDo"+File.separator+"temp.txt");
        FileOutputStream fos=new FileOutputStream(file);

        String str="hello";
        fos.write(str.getBytes());
        fos.close();

        byte[] rb=new byte[10];
        FileInputStream fis=new FileInputStream(file);
        System.out.println(fis.read(rb));
        fis.close();
    }

    /**
     * 比较FileInputStream和BufferInputStream读取大文件消耗的时间
     */
    @Test
    public void testBufferInputStream() throws IOException {
        int tmp = 0;
        File file = new File("E:" + File.separator + "技术文档" + File.separator + "jdk api 1.8_google.CHM");
        long fisStart = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        while((tmp=fis.read(b))!=-1){

        }
        fis.close();
        System.out.println("fileInputStream time = " + (System.currentTimeMillis() - fisStart));

        byte[] byteArray = new byte[1024];
        long bisStart=System.currentTimeMillis();
        FileInputStream fis2 = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis2, 1024);
        while ((tmp = bis.read(byteArray)) != -1) {
        }
        bis.close();
        System.out.println("bufferInputStream time = "+(System.currentTimeMillis()-bisStart));
    }
}

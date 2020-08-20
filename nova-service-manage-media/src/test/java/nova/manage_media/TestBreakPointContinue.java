package nova.manage_media;
/*
 * @Author:conghao
 * @description:
 */

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class TestBreakPointContinue {

    @Test
    public void testChuck() throws IOException {

        File sourceFile= new File("//Users/conghao/codes/javaCode/novaOnlineMooc/resource/videos/test.mp4");
        String chuckFileFolder="/Users/conghao/codes/javaCode/novaOnlineMooc/resource/videos/chunks";

        //chunk's size
        long chuckFileSize=1*1024*1024;

        //chunk's nums, should use ceil to make sure it is not a float or double.
        long chunkFileNum= (long)Math.ceil(sourceFile.length()*1.0/chuckFileSize);

        //build a reader obj
        RandomAccessFile rafRead=new RandomAccessFile(sourceFile,"r");

        //buffer
        byte[] b=new byte[1024];
        for(int i=0;i<chunkFileNum;i++){
            File chunkFile=new File(chuckFileFolder+i);
            int len=-1;
            //build a writer
            RandomAccessFile rafWrite=new RandomAccessFile(chunkFile,"rw");

            while((len=rafRead.read(b))!=-1){

                rafWrite.write(b,0,len);

                //if the file size== 1M, it continues to write next chunk.
                if(chunkFile.length()>=chuckFileSize){
                    break;
                }
            }
            rafWrite.close();
        }
        rafRead.close();
    }

    //测试文件合并
    @Test
    public void testMergeFile() throws IOException {
        //块文件目录
        String chunkFileFolderPath = "/Users/conghao/codes/javaCode/novaOnlineMooc/resource/videos/chunks";
        //块文件目录对象
        File chunkFileFolder = new File(chunkFileFolderPath);
        //块文件列表
        File[] files = chunkFileFolder.listFiles();
        List<File> fileList = new ArrayList<>();
        for(File f:files){
            if(f.getName().startsWith("."))
                continue;
            fileList.add(f);
        }
        //将块文件排序，按名称升序

        Collections.sort(fileList,(x,y)-> x.getName().length()==y.getName().length()?x.getName().compareTo(y.getName()):x.getName().length()-y.getName().length());

        //合并文件
        File mergeFile = new File("/Users/conghao/codes/javaCode/novaOnlineMooc/resource/videos/merged.mp4");
        //创建新文件
        boolean newFile = mergeFile.createNewFile();

        //创建写对象
        RandomAccessFile raf_write = new RandomAccessFile(mergeFile,"rw");

        byte[] b = new byte[1024];
        for(File chunkFile:fileList){
            //创建一个读块文件的对象
            RandomAccessFile raf_read = new RandomAccessFile(chunkFile,"r");
            int len = -1;
            while((len = raf_read.read(b))!=-1){
                raf_write.write(b,0,len);
            }
            raf_read.close();
        }
        raf_write.close();
    }
}

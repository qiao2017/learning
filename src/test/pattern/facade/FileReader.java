package test.pattern.facade;

/** 
 * @ClassName: FileReader
 * @description: 文件读取类，充当子系统类
 * @author: 乔莹
 * @Date: 2019年2月23日 下午5:23:11
 */
public class FileReader {
    public String read(String fileNameSrc) {
        System.out.println("已读取文件" + fileNameSrc);
        return fileNameSrc;
    }
}

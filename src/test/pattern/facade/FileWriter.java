package test.pattern.facade;

/** 
 * @ClassName: FileWriter
 * @description: 文件保存类，充当子系统
 * @author: 乔莹
 * @Date: 2019年2月23日 下午5:29:26
 */
public class FileWriter {
    public void writeToDisk(String encryptStr, String fileNameDes) {
        System.out.println("已将加密后的数据保存在" + fileNameDes);
    }
}

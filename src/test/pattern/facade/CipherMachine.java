package test.pattern.facade;

/** 
 * @ClassName: CipherMachine
 * @description: 数据加密类，充当子系统
 * @author: 乔莹
 * @Date: 2019年2月23日 下午5:26:42
 */
public class CipherMachine {
    public String encrypt(String plainText) {
        System.out.println("已将数据" + plainText + "加密");
        return plainText;
    }
}

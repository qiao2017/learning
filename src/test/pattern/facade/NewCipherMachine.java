package test.pattern.facade;

/** 
 * @ClassName: NewCipherMachine
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月23日 下午6:11:11
 */
public class NewCipherMachine {
    public String encrypt(String plainText) {
        System.out.println("使用新加密算法已将数据" + plainText + "加密");
        return plainText;
    }
}

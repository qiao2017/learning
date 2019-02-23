package test.pattern.facade;

/** 
 * @ClassName: Cilent
 * @description: 客户端测试类
 * @author: 乔莹
 * @Date: 2019年2月23日 下午5:35:54
 */
public class Cilent {
    public static void main(String[] args) {
//      AbstractEncryptFacade aef = new EncryptFacade(); 此处可使用反射
        AbstractEncryptFacade aef = new NewEncryptFacade();
        aef.fileencrypt("src.txt", "des.txt");
    }
}

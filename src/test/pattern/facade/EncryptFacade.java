package test.pattern.facade;

/** 
 * @ClassName: EncryptFacade
 * @description: 加密外观类，充当外观类
 * @author: 乔莹
 * @Date: 2019年2月23日 下午5:31:03
 */
public class EncryptFacade implements AbstractEncryptFacade{
    //维持对其他对象的引用
    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;
    public EncryptFacade() {
        reader = new FileReader();
        cipher = new CipherMachine();
        writer = new FileWriter();
    }
    
    //对外提供的加密方法
    @Override
    public void fileencrypt(String fileNameSrc, String fileNameDes) {
        String plainStr = reader.read(fileNameSrc);
        String encryptStr = cipher.encrypt(plainStr);
        writer.writeToDisk(encryptStr, fileNameDes);
    }
}

package test.pattern.facade;

/** 
 * @ClassName: NewEncryptFacade
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月23日 下午6:10:06
 */
public class NewEncryptFacade implements AbstractEncryptFacade{
    private FileReader reader;
    private NewCipherMachine cipher;
    private FileWriter writer;
    
    
    
    public NewEncryptFacade() {
        reader = new FileReader();
        cipher = new NewCipherMachine();
        writer = new FileWriter();
    }



    @Override
    public void fileencrypt(String fileNameSrc, String fileNameDes) {
        String plainStr = reader.read(fileNameSrc);
        String encryptStr = cipher.encrypt(plainStr);
        writer.writeToDisk(encryptStr, fileNameDes);
    }
    
}

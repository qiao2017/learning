package test.pattern.creator;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {
    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
    public static Object getBean() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("src/test/pattern/creator/config.xml"));
            
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = classNode.getNodeValue();
            Class<?> clazz = Class.forName(cName);
            return clazz.getDeclaredConstructor().newInstance();
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package test.pattern.decorator;

/** 
 * @ClassName: Client
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月23日 下午10:11:02
 */
public class Client {
    public static void main(String[] args) {
        Component component,componentSB,componentBB; //全部使用抽象构件定义

        component = new Window();

        componentSB = new ScrollBarDecorator(component);
        
        //将装饰了一次之后的对象继续注入到另一个装饰类中，进行第二次装饰
        componentBB = new BlackBorderDecorator(componentSB); 
        componentBB.display();

    }
}

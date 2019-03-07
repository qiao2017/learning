package test.pattern.decorator;

/** 
 * @ClassName: BlackBorderDecorator
 * @description: 黑色边框装饰类：具体装饰类
 * @author: 乔莹
 * @Date: 2019年2月23日 下午10:09:26
 */
public class BlackBorderDecorator extends  ComponentDecorator{

    public BlackBorderDecorator(Component component) {
        super(component);
    }
    
    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }

    private void setBlackBorder() {
        System.out.println("为构件增加黑色边框");
    }

}

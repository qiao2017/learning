package test.pattern.decorator;

/** 
 * @ClassName: ScrollBarDecorator
 * @description: 滚动条装饰类：具体装饰类
 * @author: 乔莹
 * @Date: 2019年2月23日 下午10:07:08
 */
public class ScrollBarDecorator extends ComponentDecorator{

    public ScrollBarDecorator(Component component) {
        super(component);
    }
    
    @Override
    public void display() {
        this.setScrollBar();
        super.display();
    }

    private void setScrollBar() {
        System.out.println("为构件添加滚动条");
    }
}

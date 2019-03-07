package test.pattern.decorator;

/** 
 * @ClassName: Window
 * @description: 窗体类，具体构建类
 * @author: 乔莹
 * @Date: 2019年2月23日 下午9:58:44
 */
public class Window extends Component{

    @Override
    public void display() {
        System.out.println("显示窗体");
    }

}

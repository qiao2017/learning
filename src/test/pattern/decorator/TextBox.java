package test.pattern.decorator;

/** 
 * @ClassName: TextBox
 * @description: 文本框类，具体构件类
 * @author: 乔莹
 * @Date: 2019年2月23日 下午9:58:44
 */
public class TextBox extends Component{

    @Override
    public void display() {
        System.out.println("显示文本框");
    }

}

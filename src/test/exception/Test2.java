package test.exception;

/** 
 * @ClassName: Test2
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月24日 下午9:39:29
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "hello";
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(s.equals(c));
        System.out.println(s.equals(new String(c)));
    }
    protected class A{}
}

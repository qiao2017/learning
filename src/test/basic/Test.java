package test.basic;

/** 
 * @ClassName: Test
 * @description: 
 * @author: 乔莹
 * @Date: 2019年3月11日 下午12:15:56
 */
public class Test extends TestAbstract implements TestInterface2, TesInterface{

    @Override
    public void run() {
        System.out.println(111);
    }
    
    public static void main(String[] args) {
        
        TestInterface2 tt = new Test();
        tt.run();
        System.out.println("-----------------");
        TestAbstract ttt = new Test();
         ttt.run();
        System.out.println("-----------------");
    }

}

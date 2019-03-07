package test.exception;

/** 
 * @ClassName: Test
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月24日 下午9:04:28
 */
public class Test
{
    public static void aMethod(int i) throws Exception
    {
        try{
            int a =  i / 0;
        }
        catch (Exception ex)
        {
//            System.out.println("ee");
            throw new Exception("exception in a Method");
        } finally{
            System.out.printf("finally");
        }
    }
 
    public static void main(String [] args)
    {
        try
        {
            aMethod(0);
        }
        catch (Exception ex)
        {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }
}

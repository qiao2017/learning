package test.algorithm.string;

/** 
 * @ClassName: LongestCommomSubString
 * @description: 
 * @author: 乔莹
 * @Date: 2019年3月10日 下午10:45:13
 */
public class LongestCommomSubString {
    
    public static void main(String[] args) {
        String str1 = "1234567";
        String str2 = "8123468";
        System.out.println(longestSubString(str1, str1.length()-1, str2, str2.length()-1));
    }
    
    public static int longestSubString(String A, int n,
                                String B, int m) {
        
        if(n == 0|| m == 0) {
            return 0;
        }
        
        if(A.charAt(n) == B.charAt(m)) {
            return longestSubString(A, n-1, B, m-1) + 1;
        }else {
            return Math.max(longestSubString(A, n-1, B, m), 
                        longestSubString(A, n, B, m-1));
        }
    }

}

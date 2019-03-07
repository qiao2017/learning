package test.algorithm.nowcoder;

import java.util.HashMap;
import java.util.Map;

/** 
 * @ClassName: SensitiveFilter
 * @description: 前缀树实现的敏感词过滤
 * @author: 乔莹
 * @Date: 2019年2月28日 下午5:31:42
 */
public class SensitiveFilter {
    TireNode root = new TireNode();
    class TireNode{
        int status;
        Map<Character, TireNode> routes;
        public int getStatus() {
            return status;
        }
        public void setStatus(int status) {
            this.status = status;
        }
        public Map<Character, TireNode> getRoutes() {
            return routes;
        }
        public void setRoutes(Map<Character, TireNode> routes) {
            this.routes = routes;
        }
        public TireNode() {
            status = 0;
            routes = new HashMap<>();
        }
    }
    
    
    
    public void addWord(String word) {
        TireNode p = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!p.routes.containsKey(c)) {
                p.getRoutes().put(c, new TireNode());
            }
            p = p.getRoutes().get(c);
        }
        p.setStatus(1);
    }
    
    public String filter(String word) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        int pp = 0;
        TireNode pTrieNode = root;
        while(p < word.length()) {
            pTrieNode = root;
            pp = p;
            while(true) {
                if(pTrieNode.getRoutes().containsKey(word.charAt(pp))) {
                    pTrieNode = pTrieNode.getRoutes().get(word.charAt(pp));
                    pp++;
                    if(pTrieNode.getStatus() == 1) {
                        sb.append("***");
                        p = pp;
                        break;
                    }
                }else {
                    sb.append(word.charAt(p));
                    p++;
                    break;
                }
            }
            
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        SensitiveFilter sf = new SensitiveFilter();
        sf.addWord("色情");
        sf.addWord("赌博");
        sf.addWord("辣鸡");
        System.out.println(sf.filter("你好色情啊赌博不好辣鸡"));
    }

}

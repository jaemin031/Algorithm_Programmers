import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String,Integer> mp = new HashMap<String,Integer>();
        
        for(int i=0;i<clothes.length;i++) {
        	mp.put(clothes[i][1], mp.getOrDefault(clothes[i][1], 0)+1);
        }
        Iterator<String> mpit = mp.keySet().iterator();
        
        while(mpit.hasNext()){
        	int num = mp.get(mpit.next());
        	answer *= (num+1);
        }
        answer--;
        
        return answer;
    }
}

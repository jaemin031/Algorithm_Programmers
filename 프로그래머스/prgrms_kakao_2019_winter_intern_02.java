import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int n;
        int[] answer;
        String st = s.replaceAll("[\\{}]","");
        String[] spl_st = st.split(",");
        Map<Integer,Integer> mp = new HashMap<>();
        List<Integer> keyList;

        for(String st1 : spl_st) {
            n = Integer.parseInt(st1);
            mp.put(n,mp.getOrDefault(n, 0) + 1);
        }

        keyList = new ArrayList<>(mp.keySet());
        answer = new int[mp.size()];

        Collections.sort(keyList, (o1, o2) -> (mp.get(o2).compareTo(mp.get(o1))));

        for(int i=0; i<answer.length;i++) {
            answer[i] = keyList.get(i);
        }
        return answer;
    }
}

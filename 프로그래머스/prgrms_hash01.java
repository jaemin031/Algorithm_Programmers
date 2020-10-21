import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> mp = new HashMap<String,Integer>();
        
        for(int i=0; i<completion.length;i++) {
        	mp.put(completion[i],mp.getOrDefault(completion[i], 0)+1);
        }
     
        for(int i=0; i<participant.length;i++) {
        	if(mp.containsKey(participant[i])) {
        		mp.put(participant[i],mp.get(participant[i])-1);
        		if(mp.get(participant[i])<0) {
        			answer = participant[i];
        			break;
        		}
        	}else {
        		answer = participant[i];
        		break;
        	}
        }
        return answer;
    }
}

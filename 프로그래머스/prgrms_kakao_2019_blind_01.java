import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] record) {
        Map<String,String> userMap = new HashMap<>();
		ArrayList<String> arr = new ArrayList();
		String[] st;
        for(int i=0;i<record.length;i++) {
        	st = record[i].split(" ");
        	if(st[0].equals("Enter")||st[0].equals("Change")) {
        		userMap.put(st[1], st[2]);
        	}
        }
        
        for(int i=0;i<record.length;i++) {
        	st = record[i].split(" ");
        	String id = st[1];
        	if(st[0].equals("Enter")) {
        		arr.add(userMap.get(id)+"님이 들어왔습니다.");
        	}else if(st[0].equals("Leave")) {
        		arr.add(userMap.get(id)+"님이 나갔습니다.");
        	}
        }
        
        String[] answer = new String[arr.size()];
        for(int i=0;i<arr.size();i++) {
        	answer[i] = arr.get(i);
        }
        
        
        return answer;
    }
}

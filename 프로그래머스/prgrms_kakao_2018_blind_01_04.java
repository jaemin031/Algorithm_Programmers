import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
		
		if(cacheSize==0)
			return cities.length*5;
		
		LinkedList<String> list = new LinkedList<>();
		
		for(String city1 : cities) {
			String city = city1.toUpperCase();
			if(list.remove(city)) {
				list.add(city);
				answer += 1;
			}else {
				int size = list.size();
				if(size==cacheSize) {
					list.pollFirst();
				}
				list.addLast(city);
				answer += 5;
				
			}
		}
		
		
        return answer;
    }
}

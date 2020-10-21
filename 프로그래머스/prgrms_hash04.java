import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        class music implements Comparable<music>{
    	   int num, playCount;
    	   String genre;
    	   
    	   music(int num, int playCount, String genre){
    		   this.num = num;
    		   this.playCount = playCount;
    		   this.genre = genre;
    	   }
    	   
    	   public int getNum() {
    			return num;
    		}
    		public String getGenre() {
    			return genre;
    		}

		@Override
		public int compareTo(music o) {
			if(this.playCount == o.playCount) {
				return this.num - o.num;
			}else {
				return -(this.playCount - o.playCount);
			}
		}
        /*
		@Override
			public String toString() {
				return "num = " + this.num + "  / playCount = " + this.playCount + "  / genre = " + this.genre +"\n";
			}
        */
       }
	
		ArrayList<music> msList = new ArrayList<>();
		ArrayList<Integer> answer2 = new ArrayList<>();
		Map<String,Integer> mp = new HashMap<>();
		int count = genres.length;
		
		for(int i=0; i<count;i++) {
			msList.add(new music(i,plays[i],genres[i]));
			mp.put(genres[i],mp.getOrDefault(genres[i], 0) + plays[i]);
		}
		
		Collections.sort(msList);
		
		List<String> keyList = new ArrayList<>(mp.keySet());
		
		Collections.sort(keyList, (o1, o2) -> (mp.get(o2).compareTo(mp.get(o1))));

		for(String key : keyList) {
			
			int j = 0;
			
			for(int i=0;i<count;i++) {
				if(j==2)
					break;
				
				if(msList.get(i).getGenre().equals(key)){
					answer2.add(msList.get(i).getNum());
					j++;
				}
			}
			
		}
		int[] answer = new int[answer2.size()];
		
		for(int i=0;i<answer.length;i++) {
			answer[i] = answer2.get(i);
		}
		
       return answer;
    }
}

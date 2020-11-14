import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        String[] spt1 = str1.toUpperCase().replaceAll("[^A-Z]", " ").split(" ");
	   String[] spt2 = str2.toUpperCase().replaceAll("[^A-Z]", " ").split(" ");
	   Map<String,Integer> mp1 = new HashMap<>();
	   Map<String,Integer> mp2 = new HashMap<>();
	   double union = 0;
	   double intersection = 0;
	   
	   for(int i=0;i<spt1.length;i++) {
		   for(int j=0;j<spt1[i].length()-1;j++) {
			   String st = spt1[i].substring(j,j+2);
			   mp1.put(st,mp1.getOrDefault(st, 0) + 1);
		   }
	   }
	   for(int i=0;i<spt2.length;i++) {
		   for(int j=0;j<spt2[i].length()-1;j++) {
			   String st = spt2[i].substring(j,j+2);
			   mp2.put(st,mp2.getOrDefault(st, 0) + 1);
		   }
	   }
	   
	   if(mp1.size()==0 && mp2.size()==0)
		   return 65536;
	   
	   for(String key1 : mp1.keySet()) {
		   if(mp2.containsKey(key1)) {
			   intersection += Math.min(mp1.get(key1), mp2.get(key1));
			   union += Math.max(mp1.get(key1), mp2.get(key1));
		   }else {
			   union += mp1.get(key1);
		   }
	   }
	   
	   for(String key2 : mp2.keySet()) {
		   if(!mp1.containsKey(key2))
			   union += mp2.get(key2);
	   }


       return (int)((intersection/union)*65536);
    }
}

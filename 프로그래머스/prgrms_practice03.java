import java.util.*;

class Solution {
    static Set<String> set = new HashSet<>();
    public int solution(int n) {
        if(n==0)
			return 0;
		
        List<String> list = new ArrayList<>();
        list.add("0");
        countBracket(list,"0",n-1,n);
        
        return set.size();
    }
    public static void countBracket(List<String> list,String s,int remain0, int remain1) {
        if(remain0>remain1)
            return;
		if(remain0==0&&remain1==0) {
			StringBuilder st = new StringBuilder();
			int check = 0;
			
			for(String st2 : list) {
				if(st2.equals("0"))
					check++;
				if(st2.equals("1"))
					check--;
				if(check<0) {
					return;
				}else
					st.append(st2);
			}
			
			set.add(st.toString());
		}else {
			if(remain0!=0) {
				List<String> list2 = new ArrayList<>(list);
				list2.add("0");
				countBracket(list2,"0",remain0-1,remain1);
			}
			if(remain1!=0) {
				List<String> list3 = new ArrayList<>(list);
				list3.add("1");
				countBracket(list3,"1",remain0,remain1-1);
			}
		}
		
	}
}

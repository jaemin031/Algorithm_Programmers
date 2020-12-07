class Solution {
    public int[] solution(int n, String[] words) {
        int len = words.length;
        int turn = 1;
        char ch = words[0].substring(words[0].length()-1).charAt(0);
        
        for(int i=1;i<len;i++) {
        	if(i%n==0)
        		turn++;
        	if(ch!=words[i].charAt(0)) {
        		if((i+1)%n==0)
        			return new int[] {n,turn};
        		else
        			return new int[] {(i+1)%n,turn};
        	}
        	for(int j=i-1;j>=0;j--) {
        		if(words[i].equals(words[j]))
        			if((i+1)%n==0)
            			return new int[] {n,turn};
            		else
            			return new int[] {(i+1)%n,turn};
        	}
        	ch = words[i].substring(words[i].length()-1).charAt(0);
        }
        
        return new int[] {0,0};
        
    }
}

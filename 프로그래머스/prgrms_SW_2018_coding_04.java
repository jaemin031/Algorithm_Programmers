class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        for(int i=0; i< cookie.length-1;i++) {
			int a = i;
			int aCookie = cookie[i];
			
			int b = i+1;
			int bCookie = cookie[i+1];
			
			while (true) {
		        if (aCookie == bCookie && answer < aCookie) { 
		          answer = aCookie; 
		        } else if (aCookie <= bCookie && a > 0) {
		          aCookie +=  cookie[--a];
		        } else if (aCookie > bCookie && b < cookie.length - 1) {
		          bCookie +=  cookie[++b];
		        } else  
		          break;
		      }
		}
        
        return answer;
    }
}

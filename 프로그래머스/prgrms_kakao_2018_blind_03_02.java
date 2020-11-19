class Solution {
  public String solution(int n, int t, int m, int p) {
        p--;
		char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		String answer = "";
		
		String st = "0";
		for(int i=1;i<m*t;i++) {
			int num = i;
			StringBuffer sb = new StringBuffer();
			while(num > 0) {
				sb.insert(0,ch[num%n]);
				num /= n;
			}
			st += sb.toString();
		}
		
		while(answer.length()<t) {
			answer += st.charAt(p);
			p += m;
		}
 
        return answer;
    }
}

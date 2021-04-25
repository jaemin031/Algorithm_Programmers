class Solution {
    public String solution(int n) {
        String answer = "";
        String[] num = {"4", "1", "2"};
        
        while(n>0) {
        	int p = n%3;
        	if(p==0)
        		n = (n/3)-1;
        	else
        		n /= 3;

        	answer = num[p] + answer;
        }
        return answer;
    }
}

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int A,B;
        
        if(a>b) {
        	A = a;
        	B = b;
        }else {
        	A = b;
        	B = a;
        }
        	
        while(true) {
        	if(B%2 !=0 && A==B+1)
        		break;
        	
        	A = (A+1) / 2;
        	B = (B+1) / 2;
        	answer++;
        }

        return answer;
    }
}

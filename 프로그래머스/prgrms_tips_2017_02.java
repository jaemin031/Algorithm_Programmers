import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>(); 
        
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++) {
        	char ch = s.charAt(i);
        	if(!stack.empty()&&stack.peek()==ch) {
        		stack.pop();
        	}else
        		stack.push(ch);
        }
        if(stack.empty())
        	return 1;
        else
        	return 0;
    }
}

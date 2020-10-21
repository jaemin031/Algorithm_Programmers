import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<moves.length;i++) {
        	for(int j=0;j<board.length;j++) {
        		int num = board[j][moves[i]-1]; 
        		if(num==0) {
        			continue;
        		}else {
        			if(stack.isEmpty()) {
        				board[j][moves[i]-1] = 0;
        				stack.push(num);
        			}else {
        				if(stack.peek()==num) {
        					board[j][moves[i]-1] = 0;
        					stack.pop();
        					answer +=2;
        				}else {
        					board[j][moves[i]-1] = 0;
        					stack.push(num);
        				}
        			}
        			break;
        		}	
        	}
        }

        return answer;
    }
}

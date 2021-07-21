import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        List<Integer> list = new ArrayList<>();
        char[][] seat = new char[5][5];
        
        for(int i=0;i<5;i++) {
        	for(int j=0;j<5;j++)
        		seat[j] = places[i][j].toCharArray();
        	
        	if(ver(seat)&&hor(seat)&&dia(seat))
        		list.add(1);
        	else
        		list.add(0);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public boolean ver(char[][] s) {	// 세로
		for(int i=0;i<5;i++) {
			for(int j=0;j<3;j++) {
				if((s[j][i]=='P'&&s[j+2][i]=='P')&&(s[j+1][i]!='X'))
					return false;
				if(s[j][i]=='P'&&s[j+1][i]=='P')
					return false;
			}
			if(s[3][i]=='P'&&s[4][i]=='P')
				return false;
		}
		
		return true;
 	}
	public boolean hor(char[][] s) {	// 가로
		for(int i=0;i<5;i++) {
			for(int j=0;j<3;j++) {
				if((s[i][j]=='P'&&s[i][j+2]=='P')&&(s[i][j+1]!='X'))
					return false;
				if((s[i][j]=='P'&&s[i][j+1]=='P'))
					return false;
			}
			if(s[i][3]=='P'&&s[i][4]=='P')
				return false;
		}
		return true;
	}
	public boolean dia(char[][] s) {	// 대각선
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if((s[i][j]=='P'&&s[i+1][j+1]=='P')&&(s[i+1][j]!='X'||s[i][j+1]!='X'))
					return false;
			}
		}
		
		for(int i=0;i<4;i++) {
			for(int j=4;j>0;j--) {
				if((s[i][j]=='P'&&s[i+1][j-1]=='P')&&(s[i+1][j]!='X'||s[i][j-1]!='X'))
					return false;
			}
		}
		
		return true;
	}
}

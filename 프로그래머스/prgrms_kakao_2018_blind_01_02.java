class Solution {
    static char[][] chmap;
    public int solution(int m, int n, String[] board) {
        chmap = new char[m][n];
		boolean[][] check;
		int answer = 0;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				chmap[i][j] = board[i].charAt(j);
			}
		}
		while(!mapCheck(m,n)) {
			check = new boolean[m][n];
			for(int i=0;i<m-1;i++) {
				for(int j=0;j<n-1;j++) {
					if(chmap[i][j]!='\u0000'&&(chmap[i][j]==chmap[i][j+1]&&chmap[i][j]==chmap[i+1][j]&&chmap[i][j]==chmap[i+1][j+1])) {
						check[i][j] = true;
						check[i][j+1] = true;
						check[i+1][j] = true;
						check[i+1][j+1] = true;
					}
				}
			}
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++)
					if(check[i][j]) {
						chmap[i][j] = '\u0000';
						answer++;
					}
			downMap(m,n);
		
		}

		
        return answer;
    }

	public static void downMap(int m, int n) {
		for(int j=0;j<n;j++) {
			for(int i = m-1;i+1>0;i--) {
				if((int)chmap[i][j]==0) {
					for(int k = i-1;k>=0;k--) {
						if((int)chmap[k][j]!=0) {
							chmap[i][j] = chmap[k][j];
							chmap[k][j] = '\u0000';
							break;
						}
							
					}
				}
			}
		}
	}
	
	public static boolean mapCheck(int m, int n) {
		boolean flag = true;
		
		for(int i=0;i<m-1;i++) {
			for(int j=0;j<n-1;j++) {
				if(chmap[i][j]!='\u0000'&&(chmap[i][j]==chmap[i][j+1]&&chmap[i][j]==chmap[i+1][j]&&chmap[i][j]==chmap[i+1][j+1]))
					return false;
			}
		}
		return true;
	}
}

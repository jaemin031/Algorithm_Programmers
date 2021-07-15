import java.util.*;

class Solution {
    static int count = 0;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        List<Node> list = new ArrayList<>();
        
        for(int i=0;i<nodeinfo.length;i++)
        	list.add(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]));
        
        Collections.sort(list);
        
        Node root = list.get(0);
        
        for(int i=1;i<list.size();i++) {
        	makeNode(root,list.get(i));
        }

        preOrder(answer,root);
        count =0;
        postOrder(answer,root);

        return answer;
    }
	
	public static void preOrder(int[][] a,Node node) {
		if(node != null) {
			a[0][count++] = node.index;
			if(node.leftNode != null) preOrder(a, node.leftNode);
			if(node.rightNode != null) preOrder(a, node.rightNode);
		}
	}
	public static void postOrder(int[][] a, Node node) {
		if(node != null) {
			if(node.leftNode != null) postOrder(a, node.leftNode);
			if(node.rightNode != null) postOrder(a, node.rightNode);
			a[1][count++] = node.index;
		}
	}
	
	public static void makeNode(Node p, Node c) {
		if(c.x<p.x) {
			if(p.leftNode == null)
				p.leftNode = c;
			else
				makeNode(p.leftNode,c);
		}else {
			if(p.rightNode==null)
				p.rightNode = c;
			else
				makeNode(p.rightNode,c);
		}
	}
}
class Node implements Comparable<Node>{
	int index;
	int x;
	int y;
    Node leftNode;   
    Node rightNode;
	
    public Node(int index, int x, int y) {
		this.index = index;
		this.x = x;
		this.y = y;
	}
    
    @Override
    public int compareTo(Node n) {
        return n.y - this.y;
    }
    
}

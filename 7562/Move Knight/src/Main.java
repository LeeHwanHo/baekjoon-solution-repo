import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main {
    static ArrayList<Node> chessBoard = null;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
 
        //In Test Case
        while (testCase != 0) {
            //체스보드 한변의 길이 입력
            int chessBoardWidth = sc.nextInt();
            SetChessBoard(chessBoardWidth);
            //나이트 시작 칸 설정
            int initRow = sc.nextInt();
            int initColumn = sc.nextInt();
            Node initNode = chessBoard.get(initRow * chessBoardWidth + initColumn);
            //나이트 도착 칸 설정
            int targetRow = sc.nextInt();
            int targetColumn = sc.nextInt();
            Node targetNode = chessBoard.get(targetRow * chessBoardWidth + targetColumn);
 
            System.out.println(Search(initNode, targetNode));
            testCase--;
        }    
     
        //Scanner Close
        if(sc != null) sc.close();
    }
 
    static public class Node {
        public int row,column;
        public boolean marked;
        public LinkedList<Node> adjacentNodes;
        public int depth;
 
        Node(int r,int c){
            row = r;
            column = c;
            marked = false;
            depth = 0;
 
            adjacentNodes = new LinkedList<Node>();
        }
 
        public void SetAdjacentNodes(int width){
            //좌 상 하
            int r = row - 1;
            int c = column - 2;            
            if((r >= 0) && (c >= 0)){
                adjacentNodes.add(chessBoard.get(r * width + c));
            }
            //좌 상 상
            r = row - 2;
            c = column - 1;            
            if((r >= 0) && (c >= 0)){
                adjacentNodes.add(chessBoard.get(r * width + c));
            }
            //우 상 상
            r = row - 2;
            c = column + 1;            
            if((r >= 0) && (c < width)){
                adjacentNodes.add(chessBoard.get(r * width + c));
            }
            //우 상 하
            r = row - 1;
            c = column + 2;            
            if((r >= 0) && (c < width)){
                adjacentNodes.add(chessBoard.get(r * width + c));
            }
            //우 하 상
            r = row + 1;
            c = column + 2;            
            if((r < width) && (c < width)){
                adjacentNodes.add(chessBoard.get(r * width + c));
            }
            //우 하 하
            r = row + 2;
            c = column + 1;            
            if((r < width) && (c < width)){
                adjacentNodes.add(chessBoard.get(r * width + c));
            }
            //좌 하 하
            r = row + 2;
            c = column - 1;            
            if((r < width) && (c >= 0)){
                adjacentNodes.add(chessBoard.get(r * width + c));
            }
            //좌 하 상
            r = row + 1;
            c = column - 2;            
            if((r < width) && (c >= 0)){
                adjacentNodes.add(chessBoard.get(r * width + c));
            }                        
        }
 
        public boolean ChkImTarget(Node targetNode){
            if(this.row == targetNode.row && this.column == targetNode.column)
                return true;
 
            return false;
        }
    }
 
    static public int Search(Node rootNode,Node targetNode){
        Queue<Node> queue = new LinkedList<Node>();
        rootNode.marked = true;
        queue.add(rootNode);
 
        while(!queue.isEmpty()){
            Node cur_node = queue.poll();
            if(cur_node.ChkImTarget(targetNode)){
                return cur_node.depth;
            }
            else {
                for (Node node : cur_node.adjacentNodes) {
                   if(!node.marked){
                       node.marked = true;
                       node.depth = cur_node.depth + 1;
                       queue.add(node);
                   }
                }
            }
        }
 
        return -1;
    }
 
    static public void SetChessBoard(int width){
        chessBoard = new ArrayList<Node>();
 
        for(int r = 0;r<width;r++){
            for(int c =0;c<width;c++){
                chessBoard.add(new Node(r, c));
            }
        }
        
        for(int i =0;i < chessBoard.size();i++){
            Node node = chessBoard.get(i);
            node.SetAdjacentNodes(width);
        }
    }
}


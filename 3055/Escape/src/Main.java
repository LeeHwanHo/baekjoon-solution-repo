import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
        int[] dColumn = {-1,0,0,1};
        int[] dRow = {0,-1,1,0};

        //row,column 입력
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
            
        Node[][] map = InitMap(row,column);



        if(br != null) br.close();
        if(bw != null) bw.close();
    }

    static class Node{
        public int row,column;
        public boolean marked;
        public LinkedList<Node> adjacent = null;
        public boolean imWater;
        public int depth;

        Node(int row,int column){
            this.row = row;
            this.column = column;
            adjacent = new LinkedList<Node>();
            marked = false;
            imWater = false;
            depth = 0;
        }
    }


    // BFS
    static public void minute(int rowCnt,int columnCnt,Node S,Node water,Node D){
        Queue<Node> queueS = new LinkedList<Node>();
        Queue<Node> queueWater = new LinkedList<Node>();
        S.marked = true;
        water.marked = true;

        while(!queueS.isEmpty()){
            Node curSNode = queueS.poll();
            Node curWaterNode = queueWater.poll();
            if(!queueWater.isEmpty()){
                for(Node node : curWaterNode.adjacent){
                    if(!node.marked){
                        node.marked = true;
                        node.imWater = true;
                        queueWater.add(node);
                    }
                }
            }
            for(Node node : curSNode.adjacent){
                if(!node.marked && !node.imWater){
                    node.marked = true;
                    node.depth = curSNode.depth + 1;
                    queueS.add(node);
                }
            }
        }

    }

    static public Node[][] InitMap(int rowCnt,int columnCnt){
        Node[][] map = new Node[rowCnt][columnCnt];

        for(int row = 0;row < rowCnt;row++){
            for(int column = 0;column < columnCnt;column++){
                map[row][column] = new Node(row,column);
            }
        }

        return map;
    }
}

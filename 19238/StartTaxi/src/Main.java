import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Node[][] map = null;

        //N : 맵 크기,M : 승객 수,F : 연료양
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());

        map = InitMap(N);
        SetNode(st, br, map);

        if(br != null) br.close();
    }

    static public class Node{
        public int row,column;
        public boolean marked,imWall;
        public LinkedList<Node> adjacent = null;

        Node(int row,int column){
            this.row = row;
            this.column = column;
            marked = false;
            imWall = false;

            adjacent = new LinkedList<Node>();
        }
    }

    static public Node[][] InitMap(int mapSize){
        Node[][] map = new Node[mapSize][mapSize];

        for (int row = 0;row < mapSize;row++){
            for (int column = 0;column < mapSize;column++){
                map[row][column] = new Node(row,column);
            }
        }

        return map;
    }

    static public void SetNode(StringTokenizer st,BufferedReader br,Node[][] map) throws Exception{
        for(int row = 0;row < map.length;row++){
            st = new StringTokenizer(br.readLine());
            for(int column = 0;column < map[row].length;column++){
                if(st.countTokens() == 0) break;
                Node node = map[row][column];
                if(Integer.parseInt(st.nextToken().trim()) == 1) node.imWall = true;
            }
        }
    }
}

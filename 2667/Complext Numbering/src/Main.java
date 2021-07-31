import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int mapSize = 0;
        ArrayList<Node> map = null;

        mapSize = sc.nextInt(); 

        map = MapInit(mapSize);
        SetApart(sc,map,mapSize);

        ArrayList<Integer> apartComplexes = Search(map);

        Collections.sort(apartComplexes);
        int complexCnt = apartComplexes.size();
        System.out.println(complexCnt);
        for(int i =0;i<complexCnt;i++){
            System.out.println(apartComplexes.get(i));
        }

        if(sc != null) sc.close();
    }

    static public class Node{
        //Node 좌표
        int row,column;
        //Node 탐색 여부
        public boolean marked;
        public byte imApart;
        public LinkedList<Node> adjacent = null;

        Node(int row,int column){
            this.row = row;
            this.column = column;
            marked = false;
            imApart = 0;
            adjacent = new LinkedList<Node>();
        }
    }

    // Set Graph
    static public ArrayList<Node> MapInit(int mapSize){
        ArrayList<Node> map = new ArrayList<Node>();
        
        for(int i = 0;i < mapSize * mapSize ;i++){
            Node node = new Node(i / mapSize,i % mapSize);
            map.add(node);
        }

        return map;
    }

    // Set adjacent
    static public void SetApart(Scanner sc,ArrayList<Node> arguMap,int mapSize){
        ArrayList<Node> map = arguMap;

        for(int i =0;i < mapSize;i++){
            String line = sc.next();
            for(int j =0;j<mapSize;j++){
                Node node = map.get(i * mapSize + j%mapSize);
                byte c = Byte.parseByte(Character.toString(line.charAt(j)));
                node.imApart = c;
            }
            
        }

        //Set adjacent Node 💠
        for(int i = 0;i < map.size() ;i++){
            Node node = map.get(i);
            int chkRow,chkColumn = 0;

            if(node.imApart == 0) continue;

            //Upper
            chkRow = node.row - 1;
            if(chkRow >= 0){
                Node chkNode = map.get(chkRow * mapSize + i % mapSize);
                if(chkNode.imApart == 1) node.adjacent.add(chkNode);
            }
            //Down
            chkRow = node.row + 1;
            if(chkRow >=0 && chkRow < mapSize){
                Node chkNode = map.get(chkRow * mapSize + i % mapSize);
                if(chkNode.imApart == 1) node.adjacent.add(chkNode);
            }
            //Left
            chkColumn = node.column - 1;
            if(chkColumn >= 0){
                Node chkNode = map.get((i/mapSize * mapSize)+ chkColumn);
                if(chkNode.imApart == 1) node.adjacent.add(chkNode);
            }
            //Right
            chkColumn = node.column + 1;
            if(chkColumn >= 0 && chkColumn < mapSize){
                Node chkNode = map.get((i/mapSize * mapSize)+ chkColumn);
                if(chkNode.imApart == 1) node.adjacent.add(chkNode);
            }
        }
    }

    static public ArrayList<Integer> Search(ArrayList<Node> map){
        ArrayList<Integer> apartComplexes = new ArrayList<Integer>();

        for(int i = 0;i < map.size();i ++){
            Node rootNode = map.get(i);
            if(rootNode.imApart == 0) continue;

            int apartCnt = 1;

            if(!rootNode.marked){
                Queue<Node> queue = new LinkedList<Node>();
                rootNode.marked = true;
                queue.add(rootNode);
                while(!queue.isEmpty()){
                    Node cur_node = queue.poll();
                    for (Node node : cur_node.adjacent) {
                        if(!node.marked){
                            node.marked = true;
                            queue.add(node);
                            apartCnt++;
                        }
                    }
                }
                // if(apartCnt > 1) apartComplexes.add(apartCnt); 연결의 경우를 체크 안한다?
                apartComplexes.add(apartCnt);
            }
        }
        return apartComplexes;
    }
}
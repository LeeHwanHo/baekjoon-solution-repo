import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Node beaverNode = null;

        // row,column 입력
        st = new StringTokenizer(br.readLine());
        int rowCnt = Integer.parseInt(st.nextToken());
        int columnCnt = Integer.parseInt(st.nextToken());

        Node[][] map = InitMap(rowCnt, columnCnt);

        beaverNode = SetMap(br, map, rowCnt, columnCnt);
        if (beaverNode == null) {
            System.out.println("input error : beaver Node is not exist");
            return;
        }
        int cnt = Search(map, rowCnt, columnCnt, beaverNode);

        if (cnt == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(cnt);
        }
        br.close();
    }

    static class Node {
        public int row, column, depth;
        public boolean beaverMarked, imWater, imWaterTobe, imStone, imTarget;
        public LinkedList<Node> adjacent = null;

        Node(int row, int column) {
            this.row = row;
            this.column = column;
            adjacent = new LinkedList<Node>();
            beaverMarked = false;
            imWater = false;
            imWaterTobe = false;
            imStone = false;
            imTarget = false;
            depth = 0;
        }
    }

    // BFS
    static public int Search(Node[][] map, int rowCnt, int columnCnt, Node beaverNode) throws Exception {
        // Node S,Node[] waters,Node D
        Node S = beaverNode;

        Queue<Node> queueS = new LinkedList<Node>();
        queueS.add(S);

        S.beaverMarked = true;

        while (!queueS.isEmpty()) {
            // waters Move
            for (int row = 0; row < rowCnt; row++) {
                for (int column = 0; column < columnCnt; column++) {
                    Node node = map[row][column];
                    if (node.imWater) {
                        for (Node adjacentNode : node.adjacent) {
                            if (!adjacentNode.imStone && !adjacentNode.imTarget) {
                                adjacentNode.imWaterTobe = true;
                            }
                        }
                    }
                }
            }

            // WaterToboe To Water
            for (int row = 0; row < rowCnt; row++) {
                for (int column = 0; column < columnCnt; column++) {
                    Node node = map[row][column];
                    if (node.imWaterTobe) {
                        node.imWater = true;
                    }
                }
            }
            while(queueS.peek() != null){
                Node curSNode = queueS.poll();
                if (curSNode.imTarget) { return curSNode.depth;}
                
                // Check Beaver
                for (Node node : curSNode.adjacent) {
                    if (!node.beaverMarked && !node.imWater && !node.imStone) {
                        node.beaverMarked = true;
                        node.depth = curSNode.depth + 1;
                        queueS.add(node);
                    }
                }
                
                if(queueS.peek() == null) break;
                if(queueS.peek().depth != curSNode.depth) break;
            }

            // debuggingDraw(map,rowCnt,columnCnt);
        }
        return -1;
    }

    // map 초기화
    static public Node[][] InitMap(int rowCnt, int columnCnt) {
        Node[][] map = new Node[rowCnt][columnCnt];

        for (int row = 0; row < rowCnt; row++) {
            for (int column = 0; column < columnCnt; column++) {
                map[row][column] = new Node(row, column);
            }
        }

        return map;
    }

    // map 입력 및 인접노드 체크
    static public Node SetMap(BufferedReader br, Node[][] map, int rowCnt, int columnCnt) throws Exception {
        Node beaverNode = null;
        for (int row = 0; row < rowCnt; row++) {
            String[] value = br.readLine().split("");
            for (int column = 0; column < columnCnt; column++) {
                Node node = map[row][column];
                switch (value[column]) {
                    case "D":
                        node.imTarget = true;
                        break;
                    case "X":
                        node.imStone = true;
                        break;
                    case "*":
                        node.imWater = true;
                        break;
                    case "S":
                        beaverNode = node;
                        break;
                }

                if (!node.imTarget && !node.imStone) {
                    // left
                    int chkColumn = node.column - 1;
                    if (chkColumn >= 0) {
                        node.adjacent.add(map[row][chkColumn]);
                    }
                    // upper
                    int chkRow = node.row - 1;
                    if (chkRow >= 0) {
                        node.adjacent.add(map[chkRow][column]);
                    }
                    // right
                    chkColumn = node.column + 1;
                    if (chkColumn >= 0 && chkColumn < columnCnt) {
                        node.adjacent.add(map[row][chkColumn]);
                    }
                    // down
                    chkRow = node.row + 1;
                    if (chkRow >= 0 && chkRow < rowCnt) {
                        node.adjacent.add(map[chkRow][column]);
                    }
                }
            }
        }

        return beaverNode;
    }

    // static void debuggingDraw(Node[][] map,int r,int c) throws Exception{
    //     for(int row =0;row < r;row++){
    //         System.out.println();
    //         for(int column = 0; column < c;column++){
    //             Node node = map[row][column];
    //             String pic = "";
    //             if(node.imStone) {pic="X";}
    //             if(node.imTarget) {pic="D";}
    //             if(node.imWater) {pic="*";}
    //             if(node.imWaterTobe && !node.imWater) {pic="⁂";}
    //             if(node.beaverMarked && !node.imWater) {pic="S";}

    //             if(pic == ""){pic=".";}
    //             System.out.print(pic);
    //         }
    //     }
    //     System.out.println();
    //     System.out.println("====================================================== Next Move ======================================================");
    //     Thread.sleep(2000);
    // }
}
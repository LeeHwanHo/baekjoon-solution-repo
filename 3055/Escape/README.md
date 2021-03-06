## 백준 문제
> https://www.acmicpc.net/problem/3055

## 참고 사이트

## 참고 예시
**[test case 1]**

row,column : 10 11
```
D..........
...........
...........
...........
...........
...........
........S..
...........
...........
...........
```

정답 : 14

**[test case 2]**

row,column : 10 15
```
........X......
..XXXXX.X.*....
X.....X.X..*...
.X.S..X.X......
D.X...X.XXXXX..
.X....X........
.X....X.XXXXXXX
.XXXXXX.X......
........X......
XXXXXXXXX...*..
```

정답 : KAKTUS

**[test case 3]**

row,column : 10 15
```
........X......
..XXXXX.X.*....
X.....X.X..*...
.X.S..X.X......
D.X...X.XXXXXXX
.X....X........
.X....X.XXXXXXX
.XXXXXX.X......
........X......
XXXXXXXXX...*..
```

정답 : 30

**[test case 4]**

row,column : 20 30
```
..............................
..............................
.............XXXXXXXXXXX......
.............X...S.....X......
.............X.XXXXXXX.X......
.....XXXXXXXXX.X.....X.X......
........*......X.*...X.X......
.....XXXXXXXXX.X.....X.X......
.............X.X...*.X.X......
.............XDX.....X.X......
.............X.X.....X.X......
.............X.X.....X.X......
.............X.X..*..X.X......
.............X.X.....X.X......
.............X.X.....X.X......
.............X.XXXXXXX.X......
.............X.........X......
.............XXXXXXXXXXX......
..............................
..............................
```

정답 : 33

**[tset case 5]**
row,column : 50 50
```
X.X...X.....X..X.X.X....X.X.......XXXX.......X....
....X.........X....X........X...XX...X....X.X.X...
.XXX....X.....XX....XX....XX..X.........X...X.X.X.
.SX.X..........X.X.X.X...XX..X.X......X.X...XX....
.......X....XXXX.X.X.X....X...X..X...X..X...X....X
.........XX.XX..X.X.X........X.....XXX.XX...X.X.X.
..X.X.XX.....X.X.X...X.......XXX.....XX.X...XX.X..
.XX..............XX.X.X.X.X........X...X.XX.X..XX.
X....XX.X...X.X.X.X...X.X.......X..X...X.X..X.....
X.....X......X..XX.X...X........X.X..X.XX...X.X..X
X..X...XX...X..X..X.X....X.X..X....XX....X.XXX...X
..........X...........X.X....XX.X..X...X..........
.XXX.........X....XX..X...X.X..X..X...XX.X.X.X....
X.........X.XXXX....XX..X.X.X.XX.XX...X.........X.
....X....................X......XX..........X.....
......XXX...X.XXX.X....XX..X......XX.X...X.X.XX...
...X......X..X....X..X..X.........XXX....XXXX.....
..X.......X....X........XXX......X.XX...........X.
.X.X..........X...X...X....XX.X....X.X.....XX..XXX
X.XX....X..........XX..XXX..X.X...........X..X.X.X
X.X.XXX.XX.X....X.X.X....X....X..X....X.X..X..X...
.X..XX.X..X..XX.X...X..X.XX.........XX..XX.X..X.X.
.X.X........XX....XX...XX.....X.X...XXXX....X..X.X
.XX...X...X.......X.......X.....X.X..X.....X.XX..X
..XX..XX.......X...X.XX.X..........XXX.XX..XX..X.X
..X.X..X...X........XX.X.X.XX.X.....X.X..XX...XX.X
.X...X..X.....X..X..XX....XX....XX.....X..XX...X..
.X.X..X..X..X.X.X.......X.XX.X..XXX....X...X.X..X.
X..X.........X..X..X.........X.....XXX...X........
...XX..X....X....X..X.X...XX..XXX....XX.X.XXXX.XX.
.X....X.X...XX....X....X.X.....XX....XXX..X....X..
....XX..X.......X..XX.X.........X.......X..X.XX...
X....XX.....XX....X.X.X.XXX.X.X.....X........X....
..X..X..XX.X....XXX.X..X..X.X...XX....X.....XX....
.......XXXXX.X...X.X...XXX.....X.XXX..XX..........
.......X...X.......X.........XX..X.X...XXX..XX....
...XX.......X.X..X..X........X.X.X.X.X....X....X.X
.XX...X........XX..X.X.XX.....XX........X..X....XX
.X.X.....X.X.X..XXX...X...X..........X..XX....X...
...X...XX..X.X..X......X...XX..XX..X..XXXX.X.XXX..
..XX.XX.XXX...X...X........X.X.X....X.XX.....XX...
X.X.X..XX.......X...XX.....X...X.X..X..X...XX.....
...X.X.X...........X.XXX....XX..X.XXX.XXX......X..
...XX.....XX..XX.....X..X.XX.X..X....X.X.X..X....X
X.XX...........X.....XXXX.X.......XX.......D.X....
X..X.X.X........X.............X.X..X.....X...X.X..
...XX..X.XX.....X.X.X....X..X..XX.....XX...X.X....
.....X.X.....XXXXXX...X.X.X.XX..............X.XX.X
.........XX............XXXX.X..X..X..X..X.X......X
......XX..X..XX.....XX.X..XX.....X....X......X..X.
```
정답 : 33

**[test case 6]**

row,colmn : 50 50
```
...SXX...XX...X...XX.XX....X.......X....X.X....*X.
.XX.X..XX.X.X..X.X.X...XX.X.....X....X...X.XX....X
..X..X....X.X.X.X.XX....XX...X..XX....X...XXX...XX
X.....X..XXX.XX..X.X.X........XXX....X.X..XX..X...
X..X.....X......X.......X..X......X.....X.X..X....
......XXX..X..XX.X.......X..X......X.X.XXX.X..X...
...X...XX.X..X.........X..XX..XX.X..X.X....X..X..X
XX.........XX.XXX.XXX...X..X..XXX.XX.X..X...X.X.X.
.....X...X..X.X.X.....X.X.X...XX........XX..X..X..
XXXX..XX..X..X..X..XXX..X...X..X.X...X..XX.XX.X...
......X..X....X.........XX..X..X........X.XX...X.X
X..XX...X........X........XXXX.XX.........X.X.XXX.
.....XXX...X.XXX....X...XX........X...XXXX...X....
.X.XX....XXX...X...X...X.X...XXX...X...X..XX.XX...
...XXX....XXX.....X.X...XX...X.X.XXX.X.XX..X......
.......X..XX.X.X..........X.XX..X..X.XX.XXXX...XX.
X...X.X.X.XXX.X..X.XXX..X...X....X.X..X...X..XX..X
..X..X.XX..X.XXX..X...X..X..X..X.X....X..........X
XX....X.X.X.XX.....X..XXXX.XX..X....X.....X.....X.
.XX.....X.X..X..X.X...X......X....X..X.XX.XX.XX.X.
.....X.........X..X.X...X....XX.X...X..X..XX.XX...
.X........X..XX..X...X....XX.XXX.XX.X..X...X...XXX
...X.X.XX...X......XX.X.XXX..X.X.XX....XXX.X...X..
....X.....XX..XX.X.X...X..X.X....X.....XX.XX..XXX.
....X........XXXXXX.........XX..X....XX.XXXX......
..XX.XXX.X...X.X.X.X..XXXX....X.X.X...XX.X..X..X..
XX..XX.X...X....XX....X.......X..X.X......XXXXX...
XX..XX.XX.X..X...XX....XX.X..X...X.X....X.........
..X.....X...X..X.........X......X...XX.XX...X.....
X.X..XX.X.X.X.XXXX.X...X..X...XX..X.....X.X.XXX...
..X....X.X.X......X..X...XX..X...X.X.XXX.X....XX.X
X.....X.X...XXXXX.....X..XX...X....X...XXX....X...
.XXX...XXXX.X....X...XX.XX..X.X........X...X....X.
..XXX.XX....X.XX.X..X...X.X.X.....X...X....X.XXXXX
.XX...X.X....XXX......X.....X....X.X..X..X....XX.X
XX..XX.X....X...XXX....X..XXX.XXX.X.X....X.X......
XX....X.X....X..X.XX...X..X.X....X..XX...XX...X...
X.X...X...X..X....X.X.........X...X...X....X..X...
.X...X...X.X....X.....XX......XXX..XX.XX.X.....X..
..X.X..XX.X..X..........X.X.XX..X..X.X.XXXX.......
..X...XX.X.X..XX..XXXXX...X........XX...X.X..X..XX
.....X..XXX....X.XX....XX.XX..XX.X....XX.XX..X.XXX
X..X.XX.X.X.......X.X.X..X......X..XX....X.XXX.XXX
X..XXXX.........X..X..X............X.X..X..X...X..
X...XX.XX...X........X....X....X.X...X..XD...X..X.
......X.......XXXX..XXX.....X.X.X.X..........X....
X.....XX.XX.XXX.XX.X.X..X.X.......XXXX.....X...XXX
.X..XX..X.....XX...XX..X.....XX...X..X....X..X..XX
X....XX....XX.....XX.X.XXX....X.......X..X....X..X
X.....XX..XX.X.....XX....X..X..X.X.XX.......X..X..
```
정답 : 86

**[tset case 7]**

row,column : 50 50
```
..................................................
............................................XXXXD.
...............................................XXX
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
................................S.................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..................................................
..............................................*...
..................................................
..................................................
..................................................
```
정답 : 44

***[test case 8]***

row,column : 50 50
```
....X.XX.X....XX.X......XX....X..X..XX.X..X...X...
..SXX...X.....X...X...X..XXX...X....XXX.X.....X..X
.X..X......X..XX.X..XXX....X.X...X..X.XX.X..XX....
X.......X.X...XX..X.X.XX....X..X..X..XX.X.......X.
.....X.XX...XX......X.X....XX.X.X...X..XX...XX.X..
.XX..X..X.X.....X.X.X.X....X.XX.......XX.....XX.X.
.X...XXXXXXX...X.....XX..X..X.X...XXX.XX........X.
..X...XXX.X.......X..X....X.....XX....X.X..XX.X...
..X..XXXX.XXX.....XXX.......XXX..X.X.....XX...X...
.X...XX.X..X.X..X....X.X...X.........XX.X.X...XXX.
.X......X...X......X.X.X....XX....XXXXX........XX.
.X....X.XX.XX....X..XXX..X.X.XX......X....XX......
.X..........X..X.X...XX..XX.XX..XX..X...XX.....X..
.XX....X.X....X..X.X.X..XXX.......X........X...X..
...X.X..X...........X.X.X...X.....XXXXX..XX......X
.XX.......X...............XX.X....X.....X.X.......
.XX..........X....XXXX...X..X.X.XXX..XX..X....X.X.
...X.X.X.XXX.X.......XX.X...X..X..XX..........XX.X
XX..XXX.......X...X....X..XX....X...X..XX..X.XX.X.
.X..X....XX.....XX.........X.X.XXX...XX...XXXX.X..
.....X.X....X.X..XX.....X.X.......X.XX...X.X....X.
..X...X....XXXXX.X...XX......XX....XX.X...X......X
.X....X..XX.XX..X....X.X.X..XX.........XX.XXX.....
X..X.X.X.X...X.XXX.........X...X...X...X.X........
....X.X..XXX......XXX...XX.X.X..X..XX.XX.XX..XX..X
.X.XX..X.........XX.XXX...X.X.X....XX.XX..X...X...
..X...X....X...X...X..XX.X.X.....X.X..X.......XX..
...X.XXXX.X..X.X......XX.X.XX...XX.X...X....X..X..
X..X...XXXX....XX.X.XX.XXX......X........X...X....
X..X.......X.....X.XXX......XX....X..X....X..X.X.X
..X..X.....XXX.....X..X..X.X.X...X.XX..X..X....X.X
..X........XXX.XX.XX....X.XXX..XX...X.X...X.X....X
.X..XXX........X......X.X..XX.XX.X.....XXXX.X.....
.X.XX..X.X...XX...XXX...X.......X.X..XX......XXX..
.X.X.X.....X..X...XX.X......XX....XX..X..X.XXXXX..
.X..X....X......X..........X.XXXXX.XX...X.X..X..XX
.X..X.X.X.X...X...X..X..X...XX......XX...X..XXX...
.XX..X......X.X...X..XX..X.X.X..X.XXXXX.XX...X...X
..X.XX.XXX.X....X..XXX.......XX...X..XXXX.X.....X.
X.XXXXX.X...X...XXXX.XXXX..X..XX..XX..............
..X.X.X...X...XX.X.......X....XX.X.X....X.XX...X..
X.X..XXX.X.X....X....X...X.X..X.....X..X...XXXX.X.
..XX.X.XX.....XX.........X.......X.X..XX.X..XXX...
..X..X.XX.XX.X........X...X..X.X.XX...XX....D.X.XX
.X...X...X...X...XX..X....XX...X..X..X.X..XX.XXXXX
....XX...X...X.X.....XXX..XX....X.X.XXX...X...X...
..XXXX....XXX.X..XX........X.X......X.X.....X...XX
.*............X..XX..X.....X.XXXX...X...X......XX.
.XXX..X....X.XXX....X.X.XX.XXX.X....XXX.X.XX.X.XX.
X.X......X....XXX.X.....XXXX.X..XX....XX....XX....
```
정답 : 98

***[test case 9]***

row,column : 50 50
```
D.................................................
.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.XX.............................................X.
...*............................................X.
.XX.............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
.X..............................................X.
SXXXXXXXXXXXXXXXXXXXXXXXX.X.XXXXXXXXXXXXXXXXXXXXX.
..........................X.......................
```
정답 : 152

***[test case 10]***

row,column : 50 50
```
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
*********************SD***************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
**************************************************
```
정답 : 1
# Page-Rank-Algorithm

Compile instruction: javac pgrk0880.java
Execution instruction: java pgrk0880 <ITERATION> <INITIAL_VALUE> 

The INITIAL_VALUE helps us to set-up the initial values of iteration 0 as needed.

Argument INITIAL_VALUE sets the initial vector values. If it is 0 they are initialized to 0, if it is 1 they
are initialized to 1. If it is -1 they are initialized to 1/N, where N is the number of web-pages (vertices of the graph). 
If it is -2 they are initialized to square root(1/N).

Argument filename describes the input (directed) graph and it has the following form. The first
line contains two numbers: the number of vertices followed by the number of edges which is also thenumber of remaining lines. 
PAY ATTENTION THAT NUMBER of VERTICES comes first.

Our graph has (directed) edges (0,2),(0,3),(1,0),(2,1). Vector values are printed to 7 decimal digits. If the graph has N GREATER than
10, then the values for iterations, initialvalue are automatically set to 0 and -1 respectively. In such a case the 
hub/authority/pageranks at the stopping iteration (i.e t) are ONLY shown, one per line. 
The graph below will be referred to as samplegraph.txt

4 4
0 2
0 3
1 0
2 1

The following invocations relate to samplegraph.txt, with a fixed number of iterations and the fixed
error rate that determines how many iterations will run. Your code should compute for this graph the same
rank values (intermediate and final). A sample of the output for the case of N >10 is shown (output truncated
to first 4 lines of it).

% ./pgrk0880 15 -1 samplegraph.txt
Base : 0 :P[ 0]=0.2500000 P[ 1]=0.2500000 P[ 2]=0.2500000 P[ 3]=0.2500000
Iter : 1 :P[ 0]=0.2500000 P[ 1]=0.2500000 P[ 2]=0.1437500 P[ 3]=0.1437500
Iter : 2 :P[ 0]=0.2500000 P[ 1]=0.1596875 P[ 2]=0.1437500 P[ 3]=0.1437500
Iter : 3 :P[ 0]=0.1732344 P[ 1]=0.1596875 P[ 2]=0.1437500 P[ 3]=0.1437500
Iter : 4 :P[ 0]=0.1732344 P[ 1]=0.1596875 P[ 2]=0.1111246 P[ 3]=0.1111246
Iter : 5 :P[ 0]=0.1732344 P[ 1]=0.1319559 P[ 2]=0.1111246 P[ 3]=0.1111246
Iter : 6 :P[ 0]=0.1496625 P[ 1]=0.1319559 P[ 2]=0.1111246 P[ 3]=0.1111246
Iter : 7 :P[ 0]=0.1496625 P[ 1]=0.1319559 P[ 2]=0.1011066 P[ 3]=0.1011066
Iter : 8 :P[ 0]=0.1496625 P[ 1]=0.1234406 P[ 2]=0.1011066 P[ 3]=0.1011066
Iter : 9 :P[ 0]=0.1424245 P[ 1]=0.1234406 P[ 2]=0.1011066 P[ 3]=0.1011066
Iter : 10 :P[ 0]=0.1424245 P[ 1]=0.1234406 P[ 2]=0.0980304 P[ 3]=0.0980304
Iter : 11 :P[ 0]=0.1424245 P[ 1]=0.1208259 P[ 2]=0.0980304 P[ 3]=0.0980304
Iter : 12 :P[ 0]=0.1402020 P[ 1]=0.1208259 P[ 2]=0.0980304 P[ 3]=0.0980304
Iter : 13 :P[ 0]=0.1402020 P[ 1]=0.1208259 P[ 2]=0.0970858 P[ 3]=0.0970858
Iter : 14 :P[ 0]=0.1402020 P[ 1]=0.1200230 P[ 2]=0.0970858 P[ 3]=0.0970858
Iter : 15 :P[ 0]=0.1395195 P[ 1]=0.1200230 P[ 2]=0.0970858 P[ 3]=0.0970858

% ./pgrk0880 -3 -1 samplegraph.txt
Base : 0 :P[ 0]=0.2500000 P[ 1]=0.2500000 P[ 2]=0.2500000 P[ 3]=0.2500000
Iter : 1 :P[ 0]=0.2500000 P[ 1]=0.2500000 P[ 2]=0.1437500 P[ 3]=0.1437500
Iter : 2 :P[ 0]=0.2500000 P[ 1]=0.1596875 P[ 2]=0.1437500 P[ 3]=0.1437500
Iter : 3 :P[ 0]=0.1732344 P[ 1]=0.1596875 P[ 2]=0.1437500 P[ 3]=0.1437500
Iter : 4 :P[ 0]=0.1732344 P[ 1]=0.1596875 P[ 2]=0.1111246 P[ 3]=0.1111246
Iter : 5 :P[ 0]=0.1732344 P[ 1]=0.1319559 P[ 2]=0.1111246 P[ 3]=0.1111246
Iter : 6 :P[ 0]=0.1496625 P[ 1]=0.1319559 P[ 2]=0.1111246 P[ 3]=0.1111246
Iter : 7 :P[ 0]=0.1496625 P[ 1]=0.1319559 P[ 2]=0.1011066 P[ 3]=0.1011066
Iter : 8 :P[ 0]=0.1496625 P[ 1]=0.1234406 P[ 2]=0.1011066 P[ 3]=0.1011066
Iter : 9 :P[ 0]=0.1424245 P[ 1]=0.1234406 P[ 2]=0.1011066 P[ 3]=0.1011066
Iter : 10 :P[ 0]=0.1424245 P[ 1]=0.1234406 P[ 2]=0.0980304 P[ 3]=0.0980304
Iter : 11 :P[ 0]=0.1424245 P[ 1]=0.1208259 P[ 2]=0.0980304 P[ 3]=0.0980304
Iter : 12 :P[ 0]=0.1402020 P[ 1]=0.1208259 P[ 2]=0.0980304 P[ 3]=0.0980304
Iter : 13 :P[ 0]=0.1402020 P[ 1]=0.1208259 P[ 2]=0.0970858 P[ 3]=0.0970858

% ./pgrk0880 -1 verylargegraph.txt
Iter : 4
P[ 0]=0.0136364
P[ 1]=0.0194318
P[ 2]=0.0310227
... other vertices omitted

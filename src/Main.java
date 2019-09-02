
import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;

public class Main {



    static int N,E;

    static int [][] node;

    static boolean visited [] ;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();

        E = in.nextInt();

        node = new int[N][N];

        visited = new boolean[N];



        for(int i = 0; i<E; i++) {

            int p=in.nextInt();

            int q=in.nextInt();

            node[p][q] = 1;

            node[q][p] = 1;

        }



        for(int V = 0; V<N ;V++) {

            if(!visited[V]) {

                System.out.print("{ ");

                DFS(V);

                System.out.println("}");

            }

        }



        visited = new boolean[N];



        for(int V = 0; V<N; V++) {

            if(!visited[V]) {

                System.out.print("{ ");

                BFS(V);

                System.out.println("}");

            }

        }

    }



    private static void BFS(int V) {

        // TODO Auto-generated method stub

        Queue<Integer> qu = new LinkedList<>();

        qu.add(V);

        System.out.print(V+" ");

        visited[V]=true;

        while(!qu.isEmpty()) {

            int Vertex = qu.poll();

            for(int i = 0;i<N;i++) {

                if(node[Vertex][i]!=0&&visited[i]==false) {

                    qu.add(i);

                    System.out.print(i+" ");

                    visited[i] = true;

                }

            }

        }

    }



    private static void DFS(int V) {
        visited[V]=true;

        System.out.print(V+" ");

        for(int i = 0; i<N ; i++) {

            if(node[V][i]!=0&&visited[i]==false) {

                DFS(i);

            }

        }

    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abetrack3
 */

import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        run();
    }
    
    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        boolean flag = false;
        while (q --> 0)
        {
            System.gc();
            if(flag)
                System.out.println();
            flag = true;
            int edges = sc.nextInt();
            int queries = sc.nextInt();
            HashMap <String, Integer> label = new HashMap<String, Integer>();
            HashMap <Integer, String> label2 = new HashMap<Integer, String>();
            MyGraph G = new MyGraph(edges + 1, 2 * edges);
            for(int i = 0; i < edges; i++)
            {
                String from = sc.next();
                String to = sc.next();
                int f, t;
                if(label.containsKey(from))
                    f = label.get(from);
                else
                {
                    label.put(from, f = label.size());
                    label2.put(f, from);
                }
                if(label.containsKey(to))
                    t = label.get(to);
                else
                {
                    label.put(to, t = label.size());
                    label2.put(t, to);
                }
                G.addEdge(f, t, 1);
                G.addEdge(t, f, 1);
            }
            while (queries --> 0)
            {
                String from = sc.next();
                String to = sc.next();
                int f = label.get(from);
                int t = label.get(to);
                System.out.println(bfs(G, f, t, label2));
            }
        }
    }
    
    public static String bfs(MyGraph G, int from, int to, HashMap <Integer, String> label)
    {
        boolean notFound = true;
        boolean visited[] = new boolean[G.nodeCount];
        ArrayList <Integer> queue = new ArrayList<Integer>();
        ArrayList <Integer> back = new ArrayList<Integer>();
        visited[from] = true;
        queue.add(from);
        back.add(-1);
        for(int i = 0; i < queue.size() & notFound; i++)
        {
            int start = G.nodes[queue.get(i)].start;
            int end = G.nodes[queue.get(i)].end;
            for(int j = start; j <= end; j++)
            {
                int destination = G.edges[j].to;
                if(!visited[destination])
                {
                    queue.add(destination);
                    visited[destination] = true;
                    back.add((i));
                    
                }
                if(destination == to)
                {
                    notFound = false;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int u = queue.size() - 1;
        while (u != -1)
        {
            sb.insert(0, label.get(queue.get(u)).charAt(0));
            u = back.get(u);
        }
        return sb.toString();
    }
    
    static class MyGraph
    {
        int nodeCount;
        int edgeCount;
        int fillCount; //count of how many edges are added into edges[]
        Comparator <MyEdge> c;
        MyNode nodes[];
        MyEdge edges[];
        
        MyGraph(int n, int e)
        {
            nodeCount = n;
            nodes = new MyNode[n];
            for(int i = 0; i < nodes.length; i++)
                nodes[i] = new MyNode();
            edgeCount = e;
            edges = new MyEdge[e];
            c = new Comparator<MyEdge>()
            {
                public int compare(MyEdge a, MyEdge b)
                {
                    int c = a.from;
                    int d = b.from;
                    return (c == d) ? 0 : (c > d) ? 1 : -1;
                }
            };
        }
        
        public void addEdge(int f, int t, int w)
        {
            MyEdge e = new MyEdge(f, t, w);
            edges[fillCount++] = e;
            heapSwim(edges, fillCount - 1, c);
            if(fillCount == edgeCount)
            {
                sortEdges();
                updateNodeIndices();
            }
        }
        
        public void updateNodeIndices()
        {
            
            for(int i = 0; i < edges.length;)
            {
                int j = i + 1;
                for(; j < edges.length; j++)
                {
                    if(edges[j].from != edges[i].from)
                        break;
                }
                nodes[edges[i].from].start = i;
                nodes[edges[i].from].end = j - 1;
                i = j;
            }
        }
        
        public void sortEdges()
        {
            int size = edges.length;
            while (size --> 0)
            {
                mySwap(edges, 0, size);
                heapSink(edges, 0, c, size);
            }
        }
        
        public static <E> void heapSwim(E e[], int current, Comparator c)
        {
            int parent = (current - 1) / 2;
            while (current != 0)
            {
                if(c.compare(e[current], e[parent]) > 0)
                    mySwap(e, current, parent);
                else
                    break;
                current = parent;
                parent = (current - 1) / 2;
            }
        }
        
        public static <E> void mySwap(E e[], int index1, int index2)
        {
            E temp = e[index1];
            e[index1] = e[index2];
            e[index2] = temp;
        }
        
        public static <E> void heapSink(E e[], int parent, Comparator c, int size)
        {
            int leftChild = (2 * parent) + 1;
            int rightChild = leftChild + 1;
            if(rightChild < size) //has both left and right child
            {
                if(c.compare(e[leftChild], e[parent]) > 0)
                {
                    if(c.compare(e[rightChild], e[parent]) > 0)
                    {
                        if(c.compare(e[leftChild], e[rightChild]) > 0)
                        {
                            mySwap(e, parent, leftChild);
                            heapSink(e, leftChild, c, size);
                        }
                        else
                        {
                            mySwap(e, parent, rightChild);
                            heapSink(e, rightChild, c, size);
                        }
                    }
                    else
                    {
                        mySwap(e, parent, leftChild);
                        heapSink(e, leftChild, c, size);
                    }
                }
                else if(c.compare(e[rightChild], e[parent])> 0)
                {
                    mySwap(e, parent, rightChild);
                    heapSink(e, rightChild, c, size);
                }
                else
                    return;
            }
            else if(leftChild < size)//has only left child
            {
                if(c.compare(e[leftChild], e[parent]) > 0)
                {
                    mySwap(e, parent, leftChild);
                    heapSink(e, leftChild, c, size);
                }
                else
                    return;

            }
            else return; //no child
    }
        
        static class MyNode
        {
            int start;
            int end;
        }
        
        static class MyEdge
        {
            int from;
            int to;
            int weight;
            
            MyEdge(int f, int t, int w)
            {
                from = f;
                to = t;
                weight = w;
            }
            
            public String toString()
            {
                return from + " " + to + " " + weight;
            }
        }
        
    }
    
}

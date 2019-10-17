import java.rmi.*; 
import java.rmi.server.*;
import java.util.Iterator; 
import java.util.*; 

class Smallgraph{
    int v;
    Integer parent[]; 
    Integer dist[];
    Integer vis[];
    List<List<Integer>> adj;
    
    Smallgraph(int v)
    {
        this.v=v; 

        parent = new Integer[v];
        dist = new Integer[v];
        vis = new Integer[v];
        adj = new ArrayList<List<Integer> >(); 
 
        for (int i = 0; i < v; i++) { 
            
            List<Integer> item = new ArrayList<Integer>(); 
            adj.add(item); 
        } 
    } 
    boolean helper(int src, int dest) 
    {
        PriorityQueue<Integer> q=new PriorityQueue<Integer>();  
        for(int i=0;i<v;i++){
            parent[i]=-1;
            dist[i]= Integer.MAX_VALUE;
            vis[i]=0;
        }
        vis[src] = 1; 
        dist[src] = 0; 
        q.add(src); 
        int u;
        while (!q.isEmpty()){ 
            u = q.remove(); 
            for (int i = 0; i < adj.get(u).size(); i++) { 

                if (vis[adj.get(u).get(i)] == 0) { 
                    parent[adj.get(u).get(i)] = u;
                    dist[adj.get(u).get(i)] = dist[u] + 1; 
                    vis[adj.get(u).get(i)] = 1; 
                    q.add(adj.get(u).get(i)); 
                    if (adj.get(u).get(i) == dest) 
                    return true; 
                } 
            } 
        } 
        return false; 
    } 
    public String addedge(int a, int b){
        System.out.println("Adding edge");
       
        if(a<100 && b<100){
            if(a==b){
                adj.get(a).add(b);
            }
            else{
                adj.get(a).add(b);
                adj.get(b).add(a);
            }
           
            return "Edge added.";
        }
        return "Invalid node number.";
    }
    public String dist(int a, int b){
        boolean res = helper(a,b);
        String reply;
        if(res==false){
            reply = "No path between edges " + Integer.toString(a) + " - " + Integer.toString(b);
        }
        else{
            reply = "Shortest distance between "  + Integer.toString(a) + " - " + Integer.toString(b) + " = " + Integer.toString(dist[b]);
        }
        return reply;
    }
    public String display() {
        String reply ="";
        for (int i=0;i<adj.size();i++){
            if(adj.get(i).size()==0)
                continue;
            reply+= Integer.toString(i)+ ": ";
            for(int j=0;j<adj.get(i).size();j++){
                reply+= Integer.toString(adj.get(i).get(j)) + " ";
            }
            reply+="\n";
        }
        return reply;
    }
}
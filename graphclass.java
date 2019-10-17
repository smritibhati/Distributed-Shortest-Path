import java.rmi.*; 
import java.rmi.server.*;
import java.util.Iterator; 
import java.util.*; 
import java.util.HashMap;

public class graphclass extends UnicastRemoteObject 
                         implements Graph 
{ 
    HashMap<String, Smallgraph> mymap;
    
    graphclass() throws RemoteException {
        super();
        mymap =  new HashMap<String, Smallgraph>();
    }
    public String createnew(String name, int v){

        
        Smallgraph g1 = new Smallgraph(v);
        mymap.put(name,g1);
        System.out.println("New Graph created.");
        return "New Graph created.";
    }
    public String addedge(String name,int a, int b){
        if (!mymap.containsKey(name))
            return "Graph not found.";
        return mymap.get(name).addedge(a,b);
    }
    public String dist(String name,int a, int b){
        if (!mymap.containsKey(name))
            return "Graph not found.";
        return mymap.get(name).dist(a,b);
    }
    public String display(String name){
        if (!mymap.containsKey(name))
            return "Graph not found.";
        return mymap.get(name).display();
    }
    public String sayHello(){
        System.out.println("Client joined.");
        return "Welcome!";

    };
} 

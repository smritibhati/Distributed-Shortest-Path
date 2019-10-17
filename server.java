import java.rmi.*; 
import java.rmi.registry.*; 
public class server 
{ 
    public static void main(String args[]) 
    { 
        try
        { 
            Graph obj = new graphclass();
            LocateRegistry.createRegistry(1900); 
            Naming.rebind("rmi://localhost:1900"+ "/server",obj); 
        } 
        catch(Exception ae) 
        { 
            System.out.println(ae); 
        } 
    } 
} 
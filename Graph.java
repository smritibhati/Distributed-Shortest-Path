import java.rmi.*; 
import java.util.*; 
public interface Graph extends Remote 
{ 
    // Declaring the method prototype 
    public String sayHello() throws RemoteException;
    public String display(String name) throws RemoteException; 
    public String dist(String name,int a, int b) throws RemoteException;
    public String addedge(String name,int a, int b) throws RemoteException;
    public String createnew(String name, int v) throws RemoteException;
}
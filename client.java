import java.rmi.*; 
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client 
{ 
    public static void main(String args[]) 
    { 
        String answer; 
        try
        { 
            // lookup method to find reference of remote object 
            Graph g = (Graph)Naming.lookup("rmi://10.1.102.58:1900"+ "/server"); 
            answer = g.sayHello(); 
            System.out.println(answer);
            Scanner scn = new Scanner(System.in);
            int flag=1;
            int x,y;
            String sendmsg;
            String[] split;
            while(flag==1){
                sendmsg = scn.nextLine();
                split = sendmsg.split(" ");
                switch (split[0]) {
                    case "exit":
                        flag=0;
                        break;
                    case "create_graph":
                        if(split.length<3){
                            System.out.println("Invalid Command");
                            break;
                        }
                        answer = g.createnew(split[1], Integer.parseInt(split[2]));
                        System.out.println(answer);
                        break;
                    case "add_edge":
                        if (split.length!=4){
                            System.out.println("Invalid Command");
                            break;
                        }
                        x = Integer.parseInt(split[1]);
                        y = Integer.parseInt(split[2]);
                       
                        answer = g.addedge(split[3],x, y);
                        System.out.println(answer);
                        break;
                    case "shortest_distance":
                        if (split.length!=4){
                            System.out.println("Invalid Command");
                            break;
                        }
                        x = Integer.parseInt(split[1]);
                        y = Integer.parseInt(split[2]);
                        answer = g.dist(split[3],x, y);
                        System.out.println(answer);
                        break;
                    case "get_graph":
                        if(split.length!=2){
                            System.out.println("Invalid Command");
                            break;
                        }
                        answer = g.display(split[1]);
                        System.out.println(answer);
                        break;
                    default:
                        System.out.println("Invalid command.");
                }
  
            }
            
        } 
        catch(Exception ae) 
        { 
            System.out.println(ae); 
        } 
    } 
} 
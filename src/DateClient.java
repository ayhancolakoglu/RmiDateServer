
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class DateClient {
  public static void main (String[] args) throws Exception {
    if (args.length != 1)
      throw new IllegalArgumentException ("Syntax: DateClient <hostname>");
          
    try {
        //
        Registry registry = LocateRegistry.createRegistry(1099);
        //

      DateServer dateServer = (DateServer) Naming.lookup("rmi://" + args[0] + "/DateServer");
      Date when = dateServer.getDate ();
      System.out.println ("Date: " + when);
        
    } catch (Exception e) {
		System.out.println("DateClient: " + e.getMessage());
	    e.printStackTrace();
	}
    
  }
}

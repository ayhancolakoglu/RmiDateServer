

import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

public class DateServerImpl extends UnicastRemoteObject implements DateServer {
  public DateServerImpl () throws RemoteException {
  }
  public Date getDate () throws RemoteException {
    System.out.println("Invocation of getDate()");
    return new Date ();
  }

  public static void main (String[] args) {

    try {
      DateServerImpl dateServer = new DateServerImpl ();
      Naming.rebind ("DateServer", dateServer);
      System.out.println("The server is up");

    } catch (Exception e) {
		System.out.println("DateServerImpl: " + e.getMessage());
		e.printStackTrace();
	}
  }
}

//https://stackoverflow.com/questions/44272416/how-to-add-a-folder-to-path-environment-variable-in-windows-10-with-screensho
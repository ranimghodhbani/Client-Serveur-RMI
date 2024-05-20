package RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceRMI extends Remote {
    String convertirEnMajuscules(String input) throws RemoteException;
}

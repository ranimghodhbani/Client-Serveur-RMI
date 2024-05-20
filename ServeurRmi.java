package RMI;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServeurRMI implements ServiceRMI {

    public ServeurRMI() {}

    @Override
    public String convertirEnMajuscules(String input) throws RemoteException {
        return input.toUpperCase();
    }

    public static void main(String[] args) {
        try {
            ServeurRMI serveur = new ServeurRMI();
            ServiceRMI stub = (ServiceRMI) UnicastRemoteObject.exportObject(serveur, 0);

            // Création d'un registre RMI sur le port 10000
            Registry registry = LocateRegistry.createRegistry(10000);
            
            // Enregistrement du stub dans le registre
            registry.rebind("ServiceRMI", stub);

            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            System.err.println("Erreur du serveur RMI : " + e.toString());
            e.printStackTrace();
        }
    }
}

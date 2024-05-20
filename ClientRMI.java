package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {

    public static void main(String[] args) {
        try {
            // Localisation du registre RMI sur le port 10000
            Registry registry = LocateRegistry.getRegistry("localhost", 10000);
            
            // Récupération du stub du serveur
            ServiceRMI stub = (ServiceRMI) registry.lookup("ServiceRMI");

            // Appel de la méthode distante
            String result = stub.convertirEnMajuscules("hello world");

            System.out.println("Résultat du serveur RMI : " + result);
        } catch (Exception e) {
            System.err.println("Erreur du client RMI : " + e.toString());
            e.printStackTrace();
        }
    }
}

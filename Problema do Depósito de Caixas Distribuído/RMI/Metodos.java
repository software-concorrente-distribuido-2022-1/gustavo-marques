import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Metodos extends Remote{
    public int retirar() throws RemoteException;

    public int colocar() throws RemoteException;
}

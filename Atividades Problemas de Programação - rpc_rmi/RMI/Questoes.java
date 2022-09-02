import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Questoes extends Remote {
    public String q1(String nome, String cargo, double salario) throws RemoteException;

    public String q2(String nome, String sexo, int idade) throws RemoteException;

    public String q3(double nota1, double nota2, double nota3) throws RemoteException;

    public String q4(double altura, String sexo) throws RemoteException;

    public String q5(int idade) throws RemoteException;

    public String q6(String nome, String nivel, double salario, int dependentes) throws RemoteException;

    public String q7(int idade, int tempo) throws RemoteException;

    public String q8(double saldo) throws RemoteException;

    public String q9(int valor, int naipe) throws RemoteException;
}
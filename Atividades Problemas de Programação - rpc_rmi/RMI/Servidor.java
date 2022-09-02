import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements Questoes {

    public Servidor() throws RemoteException {
        super();
    }

    public String q1(String nome, String cargo, double salario) throws RemoteException {
        String mensagem = "Nome: " + nome + "\n";

        if (cargo.toLowerCase().equals("operador")) {
            salario = salario * 1.2;
        } else if (cargo.toLowerCase().equals("programador")) {
            salario = salario * 1.18;
        }
        mensagem = mensagem + "Salario reajustado: R$" + String.format("%.2f", salario);

        return mensagem;
    }

    public String q2(String nome, String sexo, int idade) throws RemoteException {
        sexo = sexo.toLowerCase();
        String mensagem = "Nome: " + nome + "\n";

        if ((sexo.equals("masculino") && idade >= 18) ||
                (sexo.equals("feminino") && idade >= 21)) {
            mensagem = mensagem + "Maior de idade";
        } else if ((sexo.equals("masculino") && idade < 18) ||
                (sexo.equals("feminino") && idade < 21)) {
            mensagem = mensagem + "Menor de idade";
        }

        return mensagem;
    }

    public String q3(double nota1, double nota2, double nota3) throws RemoteException {
        String mensagem = null;
        double media;

        media = (nota1 + nota2) / 2;
        if (media >= 7.0) {
            mensagem = "Aprovado";
        } else if (media > 3.0 && media < 7.0) {
            media = (media + nota3) / 2;
            if (media >= 5.0) {
                mensagem = "Aprovado";
            } else {
                mensagem = "Reprovado";
            }
        } else {
            mensagem = "Reprovado";
        }

        return mensagem;
    }

    public String q4(double altura, String sexo) throws RemoteException {
        String mensagem = null;
        double pesoIdeal = 0.0;

        if (sexo.toLowerCase().equals("masculino")) {
            pesoIdeal = (72.7 * altura) - 58;
        } else if (sexo.toLowerCase().equals("feminino")) {
            pesoIdeal = (62.1 * altura) - 44.7;
        }
        mensagem = "Peso ideal: " + String.format("%.2f", pesoIdeal) + "Kg";

        return mensagem;
    }

    public String q5(int idade) throws RemoteException {
        String mensagem = null;

        if (idade >= 5 && idade <= 7) {
            mensagem = "Infantil A";
        } else if (idade >= 8 && idade <= 10) {
            mensagem = "Infantil B";
        } else if (idade >= 11 && idade <= 13) {
            mensagem = "Juvenil A";
        } else if (idade >= 14 && idade <= 17) {
            mensagem = "Juvenil B";
        } else if (idade >= 18) {
            mensagem = "Adulto";
        }

        return mensagem;
    }

    public String q6(String nome, String nivel, double salarioBruto, int dependentes) throws RemoteException {
        double salarioLiquido = 0.0;
        String mensagem = "Nome: " + nome + "\nNivel: " + nivel.toUpperCase() + "\n";

        if (nivel.toUpperCase().equals("A")) {
            if (dependentes > 0) {
                salarioLiquido = salarioBruto * 0.92;
            } else {
                salarioLiquido = salarioBruto * 0.97;
            }
        } else if (nivel.toUpperCase().equals("B")) {
            if (dependentes > 0) {
                salarioLiquido = salarioBruto * 0.90;
            } else {
                salarioLiquido = salarioBruto * 0.95;
            }
        } else if (nivel.toUpperCase().equals("C")) {
            if (dependentes > 0) {
                salarioLiquido = salarioBruto * 0.85;
            } else {
                salarioLiquido = salarioBruto * 0.92;
            }
        } else if (nivel.toUpperCase().equals("D")) {
            if (dependentes > 0) {
                salarioLiquido = salarioBruto * 0.83;
            } else {
                salarioLiquido = salarioBruto * 0.90;
            }
        }
        mensagem = mensagem + "Salario liquido: R$" + String.format("%.2f", salarioLiquido);

        return mensagem;
    }

    public String q7(int idade, int tempo) throws RemoteException {
        String mensagem = null;

        if (idade >= 65) {
            mensagem = "Ja pode se aposentar";
        } else if (tempo >= 30) {
            mensagem = "Ja pode se aposentar";
        } else if (idade >= 60 && tempo >= 25) {
            mensagem = "Ja pode se aposentar";
        } else {
            mensagem = "Ainda nao pode se aposentar";
        }

        return mensagem;
    }

    public String q8(double saldoMedio) throws RemoteException {
        double credito = 0.0;
        String mensagem = "Saldo medio: R$" + String.format("%.2f", saldoMedio) + "\n";

        if (saldoMedio >= 201.0 && saldoMedio <= 400.99) {
            credito = saldoMedio * 0.2;
        } else if (saldoMedio >= 401.0 && saldoMedio <= 600.99) {
            credito = saldoMedio * 0.3;
        } else if (saldoMedio >= 601.0) {
            credito = saldoMedio * 0.4;
        }
        mensagem = mensagem + "Credito: R$" + String.format("%.2f", credito);

        return mensagem;
    }

    public String q9(int valor, int naipe) throws RemoteException {
        String mensagem = null;

        switch (valor) {
            case 1:
                mensagem = "As de ";
                break;
            case 2:
                mensagem = "Dois de ";
                break;
            case 3:
                mensagem = "Tres de ";
                break;
            case 4:
                mensagem = "Quatro de ";
                break;
            case 5:
                mensagem = "Cinco de ";
                break;
            case 6:
                mensagem = "Seis de ";
                break;
            case 7:
                mensagem = "Sete de ";
                break;
            case 8:
                mensagem = "Oito de ";
                break;
            case 9:
                mensagem = "Nove de ";
                break;
            case 10:
                mensagem = "Dez de ";
                break;
            case 11:
                mensagem = "Valete de ";
                break;
            case 12:
                mensagem = "Dama de ";
                break;
            case 13:
                mensagem = "Rei de ";
                break;
        }

        switch (naipe) {
            case 1:
                mensagem = mensagem + "ouros";
                break;
            case 2:
                mensagem = mensagem + "paus";
                break;
            case 3:
                mensagem = mensagem + "copas";
                break;
            case 4:
                mensagem = mensagem + "espadas";
                break;
        }

        return mensagem;
    }

    public static void main(String[] args) {
        try {
            Questoes obj = new Servidor();
            Naming.rebind("//localhost/QuestoesServer", obj);
            System.out.println("Servidor bound in registry");
        } catch (Exception e) {
            System.out.println("Servidor err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

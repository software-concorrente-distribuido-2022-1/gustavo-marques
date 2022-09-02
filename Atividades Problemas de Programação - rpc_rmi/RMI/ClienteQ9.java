import java.rmi.Naming;
import java.util.Random;
import java.util.Scanner;

class Carta {
    private int valor;
    private int naipe;

    public Carta() {
        final Random random = new Random();
        this.valor = random.nextInt(12) + 1;
        this.naipe = random.nextInt(3) + 1;
    }

    public int getValor() {
        return this.valor;
    }

    public int getNaipe() {
        return this.naipe;
    }
}

public class ClienteQ9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Questoes obj = null;
        int qtdCartas = 0;
        String mensagem = "em branco";

        try {
            obj = (Questoes) Naming.lookup("//localhost/QuestoesServer");

            System.out.println("Digite o numero de cartas para serem geradas: ");
            qtdCartas = sc.nextInt();
            for (int i = 0; i < qtdCartas; i++) {
                Carta carta = new Carta();
                mensagem = obj.q9(carta.getValor(), carta.getNaipe());
                System.out.println(mensagem);
            }
        } catch (Exception e) {
            System.out.println("Cliente exception: " +
                    e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}

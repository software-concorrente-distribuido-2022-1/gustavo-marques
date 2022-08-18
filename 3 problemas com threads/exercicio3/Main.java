package exercicio3;

public class Main {

	public static void main(String[] args) {
		Conta c1 = new Conta("professor", 100.00);
		ControlaAcesso monitor = new ControlaAcesso(c1);
		
		ThreadDeposito deposito = new ThreadDeposito(1000.00, monitor);
		ThreadAtualizacao atualizacao = new ThreadAtualizacao(monitor);
		
		deposito.start();
		atualizacao.start();
	}

}

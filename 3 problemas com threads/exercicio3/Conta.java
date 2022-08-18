package exercicio3;

import java.text.DecimalFormat;

public class Conta {
	private String nome;
	private double saldo;

	public Conta(String nome, double saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}

	public void depositar(double valor) {
		double novoSaldo = this.saldo + valor;
		this.saldo = novoSaldo;
	}

	public void atualizar(double taxa) {
		double saldoAtualizado = this.saldo * (1 + taxa);
		this.saldo = saldoAtualizado;
	}
	
	public void imprimirSaldo() {
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(nome + ": " + df.format(saldo));
	}
}

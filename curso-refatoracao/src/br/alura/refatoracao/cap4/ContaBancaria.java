package br.alura.refatoracao.cap4;

public abstract class ContaBancaria {
	protected String titular;
	protected double saldo;
	
	public ContaBancaria(String titular, double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public void saca(double valor)
	{
		this.saldo -= valor;
	}
	
	public void deposita(double valor)
	{
		this.saldo += valor;
	}
	

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	

}

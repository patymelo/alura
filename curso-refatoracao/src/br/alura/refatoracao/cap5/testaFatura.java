package br.alura.refatoracao.cap5;

public class testaFatura {

	public static void main(String[] args) {
		Fatura fatura = new Fatura();
		double valor1 = fatura.emReal();
		double valor2 = fatura.emDolar();	
		
		System.out.println("Conversão Dolar: "+valor2);
		System.out.println("Conversão Real: "+valor1);

	}

}

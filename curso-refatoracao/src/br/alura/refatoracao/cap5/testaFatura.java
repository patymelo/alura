package br.alura.refatoracao.cap5;

public class testaFatura {

	public static void main(String[] args) {
		Fatura fatura = new Fatura();
		double valor1 = fatura.emReal();
		double valor2 = fatura.emDolar();	
		
		System.out.println("Convers�o Dolar: "+valor2);
		System.out.println("Convers�o Real: "+valor1);

	}

}

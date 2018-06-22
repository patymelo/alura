package br.alura.refatoracao.cap3;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class testeMatricula {

	public static void main(String[] args) {
		Matricula matricula = new Matricula(true, new GregorianCalendar(2020,Calendar.JUNE,22));
		
		if(matricula.isValida())
		{
			System.out.println("Usuário com acesso!");
		}

	}

}

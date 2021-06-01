package principal;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Utils {
	
	public static Scanner input = new Scanner(System.in);
	public static DecimalFormat df = new DecimalFormat("#,##0.00");
	
	public static void alterarVetorC(double[] vetorC) {
		char op;
		String escolha;
		
		System.out.print("Deseja alterar o custo de produ��o de todas as por��es [s/n]? ");
		op = Character.toUpperCase(input.next().charAt(0));
		
		while (op != 'S' && op != 'N') {
			System.out.print("[ERRO] Entrada inv�lida!\nInforme novamente: ");
			op = Character.toUpperCase(input.next().charAt(0));
		}
		
		if (op == 'S') {
			String porcao = "";
			System.out.println("Alterar por��es: ");
			for (int i = 0; i < vetorC.length; i++) {
				switch (i) {
				case 0:
					porcao = "Pre�o do arroz: ";
					break;
				case 1:
					porcao = "Pre�o da carne: ";
					break;
				case 2:
					porcao = "Pre�o da salada: ";
					break;
				case 3:
					porcao = "Pre�o do tropeiro: ";
					break;
				}
				
				System.out.print("*" + porcao);
				vetorC[i] = input.nextDouble();
				
				while ( vetorC[i] < 0) {
					System.out.print("[ERRO] Entrada inv�lida!\nInforme novamanete: ");
					vetorC[i] = input.nextDouble();
				}
			}
			
			input.nextLine();
			
		} else {
			
			do {
				System.out.println();
				int escolha2;
				System.out.println("====[Op��es]====");
				System.out.println("[1] - Arroz");
				System.out.println("[2] - Carne");
				System.out.println("[3] - Salada");
				System.out.println("[4] - Tropeiro");
				System.out.print("Qual por��o deseja alterar: ");
				escolha2 = input.nextInt();
				
				while(escolha2 != 1 && escolha2 != 2 && escolha2 != 3 && escolha2 != 4) {
					System.out.print("[ERRO]Entrada inv�lida, informe novamente: ");
					escolha2 = input.nextInt();
				}
				
				String porcao = "";
				
				switch (escolha2) {
				case 1:
					porcao = "Pre�o do arroz: ";
					break;
				case 2:
					porcao = "Pre�o da carne: ";
					break;
				case 3:
					porcao = "Pre�o da salada: ";
					break;
				case 4:
					porcao = "Pre�o do tropeiro: ";
					break;
				}
				System.out.print("#" + porcao);
				vetorC[(escolha2) - 1] = input.nextDouble();
				
				while (vetorC[(escolha2) - 1] < 0) {
					vetorC[(escolha2) - 1] = input.nextDouble();
				}
				
				input.nextLine();
				
				System.out.print("Deseja alterar o custo de mais alguma por��o: [s/n] ");
				escolha = input.nextLine();
				
				while (!escolha.equalsIgnoreCase("s") && !escolha.equalsIgnoreCase("n")) {
					System.out.print("[ERRO] Entrada inv�lida!\nInforme novamente: ");
					escolha = input.nextLine();
				}
				
			} while (escolha.equalsIgnoreCase("s"));
			
		}
		
	}
	
	public static void mostrarVetorC(double[] vetorC) {
		String porcao = "";
		for (int i = 0; i < vetorC.length; i++) {
			switch (i) {
			case 0:
				porcao = "Pre�o do arroz: ";
				break;
			case 1:
				porcao = "Pre�o da carne: ";
				break;
			case 2:
				porcao = "Pre�o da salada: ";
				break;
			case 3:
				porcao = "Pre�o do tropeiro: ";
				break;
			}
			System.out.println(porcao + "R$ " + df.format(vetorC[i]));
		}
		
		
	}

	public static void mostrarMatrizP(int[][] matrizP) {
		
		for (int i = 0; i < matrizP.length; i++) {
			System.out.println("#Prato: " + (i + 1));
			for (int j = 0; j < matrizP[0].length; j++) {
				String porcao = "";
				switch (j) {
				case 0:
					porcao = "Por��es de arroz: ";
					break;
				case 1:
					porcao = "Por��es de carne: ";
					break;
				case 2:
					porcao = "Por��es de salada: ";
					break;
				case 3:
					porcao = "Por��es de tropeiro: ";
					break;
				}
				
				System.out.println(porcao + matrizP[i][j]);
				
			}
		}
		
	}
	
	public static void mostrarCustoPrato(int[][] matrizP, double[] vetorC) {
		
		double[] valorPrato = new double[matrizP.length];
	    for(int i = 0; i < matrizP.length; i++) {
	    	for(int j = 0; j < matrizP[0].length;j++) {
	    		valorPrato[i]+= vetorC[j]* matrizP[i][j];
	    	}
	    }
	    
	    for(int i = 0; i < 3; i++) {
	    	System.out.println("Valor prato " + (i + 1) + ": R$ "+ df.format(valorPrato[i]));	
	    }
	}
	
	public static void alterarMatrizComposi�aoPrato(int[][] matrizP) {
		
		String escolha;
		
		do {
			System.out.println("====[Menu]====");
			System.out.println("[1] - Prato 1");
			System.out.println("[2] - Prato 2");	
			System.out.println("[3] - Prato 3");
			System.out.print("Informe qual prato voc� deseja alterar: ");
			int n = input.nextInt();
			
			while(n != 1 && n != 2 && n != 3) {
				System.out.print("[ERRO]Entrada inv�lida, informe novamente: ");
				n = input.nextInt();
			}
			
			System.out.println("#Alterar Prato " + n + ": ");
			
			for(int j = 0; j < matrizP[0].length; j++) {
				String porcao = "";
				
				switch (j) {
				case 0:
					porcao = "Insira a quatidade de por��es de arroz: ";
					break;
				case 1:
					porcao = "Insira a quatidade de por��es de carne: ";
					break;
				case 2:
					porcao = "Insira a quatidade de por��es de salada: ";
					break;
				case 3:
					porcao = "Insira a quatidade de por��es de tropeiro: ";
					break;
				}
				
				System.out.print(porcao);
				matrizP[n - 1][j] = input.nextInt();
				
				while (matrizP[n - 1][j] < 0) {
					System.out.print("[ERRO] Entrada inv�lida!\nInforme novamente: ");
					matrizP[n - 1][j] = input.nextInt();
				}
			}
			
			input.nextLine();
			
			System.out.print("Deseja alterar a composi��o de mais algum prato: [s/n] ");
			escolha = input.nextLine();
			
			while (!escolha.equalsIgnoreCase("s") && !escolha.equalsIgnoreCase("n")) {
				System.out.print("[ERRO] Entrada inv�lida!\nInforme novamente: ");
				escolha = input.nextLine();
			}
			
		} while (escolha.equalsIgnoreCase("s"));
		
	}

}

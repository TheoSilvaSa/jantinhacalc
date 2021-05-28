package principal;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Utils {
	
	public static Scanner input = new Scanner(System.in);
	
	public static String printLogo() throws IOException {
		
		Path arquivoLogo = Paths.get("logo.txt");
		Scanner logo = new Scanner(arquivoLogo);
		String line = "";
		
		while (logo.hasNextLine()) {
		    line += " " + logo.nextLine() + "\n";
		}
		
		logo.close();
		return line;
	}
	
	public static void alterarVetorC(double[] vetorC) {
		
		char op;
		String escolha;
		
		System.out.print("Deseja alterar o custo de produ��o de todas as por��es [s/n]? ");
		op = Character.toUpperCase(input.next().charAt(0));
		
		while (op != 'S' && op != 'N') {
			System.out.print("[ERRO] Entrada inv�lida!\nInformer novamente: ");
			op = Character.toUpperCase(input.next().charAt(0));
		}
		
		if (op == 'S') {
			String porcao = "";
			System.out.println("|=>Alterar por��es: ");
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
				
				System.out.print(" *" + porcao);
				vetorC[i] = input.nextDouble();
			}
			
		} else {
			
			do {
				System.out.println("Deseja alterar o custo de mais alguma por��o: ");
				escolha = input.nextLine();
				
			} while (escolha.equalsIgnoreCase("sim"));
			
		}
		
		
		
		
		
		
	}
	
}

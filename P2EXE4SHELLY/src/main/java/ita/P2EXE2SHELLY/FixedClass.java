package ita.P2EXE2SHELLY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixedClass {
	public final void fixedMethod(String FILENAME) throws IOException {
		final Scanner console = new Scanner(System.in);
		while (true) {
			
			Pattern pattern = Pattern.compile("[^A-Za-z0-9._]"); // padroniza o arquivo
			Matcher matcher = pattern.matcher(FILENAME);
			
			
			
		    
		    System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
		    		+ "W para escrever em um arquivo, "+ "S para sair>: ");
		    try {
		    final String opr = console.nextLine();				// protegido com try/catch contra entradas proibidas
		    if ("R".equals(opr)){				// é mais seguro utilizar 'equals' com a string do lado esquerdo
				BufferedReader br = null;				
				
				
					String sCurrentLine = null;				// garantir que a variável está limpa

					br = new BufferedReader(new FileReader(FILENAME));

					while ((sCurrentLine = br.readLine()) != null) {
						matcher = pattern.matcher(sCurrentLine);
						if (!matcher.find())
							System.out.println(sCurrentLine);
						else{
							System.out.print("Arquivo problemático!\n");
							
							
						}
					}

				 										// fecha BufferedReader e FileReader

					

						if (br != null)
							br.close();

					

				
				
			}
		    else if ("W".equals(opr)) {
		    	BufferedWriter buffWrite = null;	
				  
					buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					System.out.println("Escreva algo: ");
				    buffWrite.append(console.nextLine() + "\n");
				
				

					

						if (buffWrite != null)
							buffWrite.close();

					

				
			}
		    else if ("S".equals(opr)){
		    	console.close();
		    	System.out.print("Programa finalizado.\n");
		    	break;
		    }
		    else {
		    	System.out.print("Entrada incorreta!\n");
		    }
		
		}
		catch (java.util.NoSuchElementException a) {  // para motivos de teste. Quando for simulado o usuário, só é possível simular uma entrada. A segunda entrada será nula e finalizará o programa.
			console.close();
			System.out.print("Não foi recebida a entrada devida!Programa encerrado.\n");
			break;
		}
	}
}
}
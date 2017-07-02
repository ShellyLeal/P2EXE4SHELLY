package ita.p2exe4shelly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixedClass {
  public final void fixedMethod(String filename) throws IOException {
    final Scanner console = new Scanner(System.in);
    while (true) {
      Pattern pattern = Pattern.compile("[^A-Za-z0-9._]"); // padroniza o arquivo
      Matcher matcher = pattern.matcher(filename);

      System.out.print("Digite a operacao desejada "
          + "para realizar no arquivo <R para ler um arquivo, "
          + "W para escrever em um arquivo, " + "S para sair>:");
      try {
        final String opr = console.nextLine();
        if ("R".equals(opr)) {
          BufferedReader br = null;
          String scurrentline = null;

          br = new BufferedReader(new FileReader(filename));

          while ((scurrentline = br.readLine()) != null) {
            matcher = pattern.matcher(scurrentline);
            if (!matcher.find()) {
              System.out.println(scurrentline);
            } else {
              System.out.print("Arquivo problematico!\n");
            }
          }

          if (br != null) {
            br.close();
          }
        } else if ("W".equals(opr)) {
          BufferedWriter buffWrite = null;
          buffWrite = new BufferedWriter(new FileWriter(filename));
          System.out.println("Escreva algo: ");
          buffWrite.append(console.nextLine() + "\n");
          if (buffWrite != null) {
            buffWrite.close();
          }
        }  else if ("S".equals(opr)) {
          console.close();
          System.out.print("Programa finalizado.\n");
          break;
        } else {
          System.out.print("Entrada incorreta!\n");
        }
      } catch (java.util.NoSuchElementException a) {  
        console.close();
        System.out.print("Não foi recebida a entrada devida!Programa encerrado.\n");
        break;
      }
    }
  }
}
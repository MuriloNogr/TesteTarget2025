package test05;

import java.util.Scanner;

public class Teste5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a string: ");
        String entrada = scanner.nextLine();

        String invertida = inverter(entrada);
        System.out.println("String invertida: " + invertida);
    }

    static String inverter(String str) {
        char[] chars = str.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return new String(chars);
    }
}

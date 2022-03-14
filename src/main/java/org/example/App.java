package org.example;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        for (int i = 1; input.hasNext() == true; i++) {
            System.out.println(i + " " + input.nextLine());
        }
    }
}

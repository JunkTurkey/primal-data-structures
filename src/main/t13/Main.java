package main.t13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main() {
        Abonents abonents = new Abonents();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );

        System.out.println("Input fio and tel:");
        try {
            String currentString = reader.readLine();
            while (!currentString.isEmpty()) {
                String[] input = Abonents.struct(currentString);
                abonents.add(input[0], input[1]);
                currentString = reader.readLine();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        abonents.print();
        abonents.Sort();
        abonents.print();
        System.out.println("input name to search");
        try {
            abonents.lfName(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("input telephone to search");
        try {
            abonents.lfTel(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

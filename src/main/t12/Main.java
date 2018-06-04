package main.t12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main() {

        int n=0, k=0;
        Circle circle = new Circle(1);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );

        try {
            System.out.println("Input N");
            n = Integer.parseInt(reader.readLine());
            System.out.println("Input K");
            k = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i=2; i<=n; i++)
            circle.insert(i);

            circle.doTask(k);
    }
}

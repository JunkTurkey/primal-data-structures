package main.t3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        PriorList pl = new PriorList();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("input items (<prioritet>, <value>): ");
        String cusStr = null;
        try {
            cusStr = reader.readLine();
            while (!cusStr.isEmpty()){
                String[] tmp = cusStr.split(", ");
                pl.push(Integer.parseInt(tmp[0]),tmp[1]);
                cusStr = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        pl.print();

        System.out.println("input value to search: ");
        try {
            String lfstr = reader.readLine();
            System.out.println(pl.search(lfstr)==null ? "no value " + lfstr + " in this queue" : pl.search(lfstr).prior + ": value=" + pl.search(lfstr).value);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("input values amount to delete: ");
        try {
            int x = Integer.parseInt(reader.readLine());
            for (int i=0; i<x; i++)
                pl.pop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

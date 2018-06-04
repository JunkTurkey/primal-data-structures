package main.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main (String[] args){


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Dictionary dictionary = null;

        System.out.println("input size");

        try {
            String curStr = reader.readLine();
            dictionary = new Dictionary(Integer.parseInt(curStr));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("input dictions");

        try {
            String curStr = reader.readLine();
            while (!curStr.isEmpty()){
                String[] tmp = curStr.split(" ");
                dictionary.add(tmp[0], tmp[1]);
                curStr = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        dictionary.print();

        System.out.println("input eng word to search translation");

        try {
            String curStr = reader.readLine();
            dictionary.search(curStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("input diction to delete");

        try {
            String curStr = reader.readLine();
            String[] tmp = curStr.split(" ");
            dictionary.delete(tmp[0], tmp[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

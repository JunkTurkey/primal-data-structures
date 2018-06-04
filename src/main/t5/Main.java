package main.t5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BinTree tree = new BinTree();
        System.out.print("input elements: \n");
        try {
            String inpStr = reader.readLine();
            while (!inpStr.isEmpty()){
                tree.add(Integer.parseInt(inpStr));
                inpStr = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        tree.search(22);
        tree.watchObxod();
        tree.remove(22);
        tree.watchObxod();
    }
}

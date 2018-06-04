package main.t6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {

    public static void main(String[] args) {
        InOrderTree inOrderTree = new InOrderTree();
        PreOrderTree preOrderTree = new PreOrderTree();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("input elements to tree:\n");
        try {
            String inpStr = reader.readLine();
            while (!inpStr.isEmpty()){
                inOrderTree.AddNode(Integer.parseInt(inpStr));
                preOrderTree.AddNode(Integer.parseInt(inpStr));
                inpStr = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("inorder obxod: " + inOrderTree.InorderStart());

        System.out.println("preorder obxod: " + preOrderTree.PreorderStart());
    }

}

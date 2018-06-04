package main.t6;

import java.util.ArrayList;

public class InOrderTree {
    public Node root;
    private String Inorder = new String("");
    private boolean isStitched;
    private Node parent;
    private ArrayList<Integer> inorderTreeNodes = new ArrayList<>();
    private ArrayList<Integer> preorderTreeNodes = new ArrayList<>();

    public void AddNode(int number){
        if (root == null){
            root = new Node(number, null, null, true, true);
            preorderTreeNodes.add(number);
        }
        else{
            boolean wasStitched = isStitched;
            if (wasStitched)
                Stich();
            if(!preorderTreeNodes.contains(number)){
                AddNode(root, number);
                preorderTreeNodes.add(number);
            }
            if (!wasStitched)
                Stich();
        }
    }

    public void deleteNode(int number){
        boolean wasStitched = isStitched;
        if (wasStitched)
            Stich();
        preorderTreeNodes.remove(number);
        ArrayList<Integer> nodes = (ArrayList<Integer>) preorderTreeNodes.clone();
        root = null;
        preorderTreeNodes.clear();

        for (Integer element:nodes)
            AddNode(element);
        if (wasStitched)
            Stich();
    }

    public void Stich(){
        if (isStitched)
        {
            UnStitch(root);
            isStitched = false;
        }
        else
        {
            parent = root;
            LeftStitch(root);
            parent = root;
            RightStitch(root);
            isStitched = true;
        }
    }

    // tree obxod
    public String InorderStart()
    {
        inorderTreeNodes.clear();
        String result = new String("");
        Inorder = "";

        if (isStitched)
        {
            StichInorderStart();
        }
        else
        {
            InorderStart(root);
        }

        Inorder = Inorder.substring(0, Inorder.length() - 1);
        result = Inorder.replace(" ", " -> ");
        return result;
    }

    //obxod stritched tree
    private void StichInorderStart()
    {
        Node curNode = GetStichedNextNode(root);
        while (curNode != root)
        {
            Inorder += curNode.data + " ";
            inorderTreeNodes.add(curNode.data);
            curNode = GetStichedNextNode(curNode);

            if (curNode == root && !inorderTreeNodes.contains(root.data))
            {
                Inorder += curNode.data + " ";
                inorderTreeNodes.add(curNode.data);
                curNode = GetStichedNextNode(curNode);
            }
        }
    }

    // get next element with inorder obxod
    private Node GetStichedNextNode(Node node)
    {
        Node result = node;

        if (result.LeftTag && !inorderTreeNodes.contains(result.left.data))
        {
            while (result.LeftTag)
            {
                result = result.left;
            }
        }
        else if (result.RightTag)
        {
            result = result.right;
            if (result.LeftTag)
            {
                while (result.LeftTag)
                {
                    result = result.left;
                }
            }
        }
        else
        {
            result = node.right;
        }

        return result;
    }

    //simple tree obxod
    private void InorderStart(Node node)
    {
        if (node == null)
            return;
        InorderStart(node.left);
        Inorder += node.data + " ";
        InorderStart(node.right);
    }

    //adding in simple tree
    public void AddNode(Node node, int number){
        if (number > node.data){
            if (node.right != null)
                AddNode(node.right, number);
            else
                node.right = new Node(number,null, null, true, true);
        }
        else{
            if (node.left != null)
                AddNode(node.left, number);
            else
                node.left = new Node(number, null, null, true, true);
        }
    }

    private void LeftStitch(Node node)
    {
        if (node == null)
            return;
        LeftStitch(node.left);
        if (node.left != null)
            node.LeftTag = true;
        else
        {
            node.LeftTag = false;
            node.left = parent;
        }
        parent = node;
        LeftStitch(node.right);
    }

    private void RightStitch(Node node)
    {
        if (node == null)
            return;
        RightStitch(node.right);
        if (node.right != null)
            node.RightTag = true;
        else
        {
            node.RightTag = false;
            node.right = parent;
        }
        parent = node;
        if (node.LeftTag)
            RightStitch(node.left);
    }

    private void UnStitch(Node node)
    {
        if (node == null)
            return;

        if (node.LeftTag)
            UnStitch(node.left);
        else
        {
            node.left = null;
            node.LeftTag = true;
        }

        if (node.RightTag)
            UnStitch(node.right);
        else
        {
            node.right = null;
            node.RightTag = true;
        }
    }

}

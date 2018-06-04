package main.t6;

import java.util.ArrayList;

public class PreOrderTree {
    public Node root;
    private String Preorder = new String("");
    private boolean isStitched;
    private Node parent;
    private ArrayList<Integer> preorderTreeNodes = new ArrayList<>();

    public void AddNode(int number)
    {
        if (root == null)
        {
            root = new Node(number, null, null, true, true);
            preorderTreeNodes.add(number);
        }
        else
        {
            boolean wasStitched = isStitched;
            if (wasStitched)
            {
                Stitch();
            }

            if (!preorderTreeNodes.contains(number))
            {
                AddNode(root, number);
                preorderTreeNodes.add(number);
            }

            if (wasStitched)
            {
                Stitch();
            }
        }
    }

    public void DeleteNode(int number)
    {
        boolean wasStitched = isStitched;
        if (wasStitched)
        {
            Stitch();
        }

        preorderTreeNodes.remove(number);

        ArrayList<Integer> nodes = (ArrayList<Integer>) preorderTreeNodes.clone();

        root = null;
        preorderTreeNodes.clear();

        for (Integer element:nodes)
        {
            AddNode(element);
        }

        if (wasStitched)
        {
            Stitch();
        }
    }

    public void Stitch()
    {
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

    // Обход дерева прямым методом
    public String PreorderStart()
    {
        //preorderTreeNodes.clear();
        String result = "";
        Preorder = "";

        if (isStitched)
        {
            //StitchPreorderStart();
        }
        else
        {
            PreorderStart(root);
        }

        Preorder = Preorder.substring(0, Preorder.length() - 1);
        result = Preorder.replace(" ", " -> ");
        return result;
    }

    // adding in simple tree
    private void AddNode(Node node, int number)
    {
        if (number > node.data)
        {
            if (node.right != null)
                AddNode(node.right, number);
            else
                node.right = new Node(number, null, null, true, true);
        }
        else
        {
            if (node.left != null)
                AddNode(node.left, number);
            else
                node.left = new Node(number, null, null, true, true);
        }
    }

    // obxod simple tree
    private void PreorderStart(Node node)
    {
        if (node == null)
            return;
        Preorder += node.data + " ";
        PreorderStart(node.left);
        PreorderStart(node.right);
    }

    private void LeftStitch(Node node)
    {
        if (node == null)
            return;

        if (node.left != null)
        {
            node.LeftTag = true;
        }
        else
        {
            node.LeftTag = false;
            node.left = parent;
        }

        parent = node;
        LeftStitch(node.left);
        LeftStitch(node.right);
    }

    private void RightStitch(Node node)
    {
        if (node == null)
            return;

        if (node.right != null)
        {
            node.RightTag = true;
        }
        else
        {
            node.RightTag = false;
            node.right = parent;
        }

        parent = node;
        RightStitch(node.right);

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

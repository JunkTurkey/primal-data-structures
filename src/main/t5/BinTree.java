package main.t5;

public class BinTree {
    static class Node{
        Comparable item;
        Node left = null;
        Node right = null;

        public Node(Comparable item) {
            this.item = item;
        }
    }

    Node root = null;

    public void add(Comparable item){
        Node newNode = new Node(item);
        Node parent = null;
        Node cur = root;
        int compare = 0;
        while (cur != null){
            parent = cur;
            if ((compare = cur.item.compareTo(item)) <= 0)
                cur = cur.right;
            else cur = cur.left;
        }
        if (parent == null)
            root = newNode;
        else if (compare <= 0)
            parent.right = newNode;
        else parent.left = newNode;
    }

    public void remove (Comparable item){
        final int left = -1;
        final int right = 1;
        final int nostep = 0;
        Node parent = null;
        Node cur = root;
        int comp = 0;
        int laststep = nostep;
        while (cur != null && (comp = cur.item.compareTo(item)) != 0){
            parent = cur;
            if (comp < 0){
                laststep = right;
                cur = cur.right;
            }
            else {
                laststep = left;
                cur = cur.left;
            }
        }
        if (cur == null) return;
        if (cur.left == null) {
            if (laststep == right)
                parent.right = cur.right;
            else if (laststep == left)
                parent.left = cur.right;
            else root = cur.right;
        }
        else if (cur.right == null){
            if (laststep == right)
                parent.right = cur.left;
            else if (laststep == left)
                parent.left = cur.left;
            else root = cur.left;
        }
        else {
            Node replace = cur.right;
            parent = cur;
            while (replace.left != null){
                parent = replace;
                replace = replace.left;
            }
            cur.item = replace.item;
            if (parent == cur)
                parent.right = replace.right;
            else parent.left = replace.right;
        }

    }

    public void search (Comparable key){
        for (Node cur = root; cur!=null; ){
            int comp = cur.item.compareTo(key);
            if (comp == 0) {
                System.out.println("your item " + cur.item);
                break;
            }
            else if (comp < 0)
                cur = cur.right;
            else cur = cur.left;
        }

    }

    private void pryamoi (Node node){
        if (node != null){
            System.out.print(node.item + " ");
            pryamoi(node.left);
            pryamoi(node.right);
        }
    }

    private void obratniy (Node node){
        if (node != null){
            obratniy(node.left);
            obratniy(node.right);
            System.out.print(node.item + " ");
        }
    }

    private void simmetri4niy (Node node){
        if (node != null){
            simmetri4niy(node.left);
            System.out.print(node.item + " ");
            simmetri4niy(node.right);
        }
    }

    public void watchObxod(){
        System.out.print("\n pryamoi obxod: \n");
        pryamoi(root);
        System.out.print("\n simmetri4niy obxod: \n");
        simmetri4niy(root);
        System.out.print("\n obratniy obxod: \n");
        obratniy(root);

    }

}

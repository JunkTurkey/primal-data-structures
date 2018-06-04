package main.t14;

public class Abonents {
    class Telephone{
        public String name;
        public String tel;
        public Telephone next;
        public Telephone prev;
        private boolean isHot;

        public Telephone(String name, String tel, Telephone next, Telephone prev) {
            this.name = name;
            this.tel = tel;
            this.next = next;
            this.prev = prev;
            this.isHot = tel.length()==3 ? true : false;
        }
    }
    static class Result{
        class Node {
            public String tel;
            public String name;
            public Node next;

            public Node(String tel, String name) {
                this.tel = tel;
                this.name = name;
            }
        }

        Node first = null;
        Node last = null;

        public void pushItem (String value1, String value2){
            Node newItem = new Node(value1, value2);
            if (last==null){
                first = newItem;
            }
            else {
                last.next = newItem;
            }
            last = newItem;
        }

        public void print(){
            for (Node cur = first; cur!=null; cur = cur.next){
                System.out.println(cur.name+"|"+cur.tel);
            }
        }
    }

    Telephone first;
    Telephone last;

    public Abonents() { first=last=null; }

    public void add(String name, String tel){
        Telephone curlast = this.last;
        Telephone cur = new Telephone(name, tel, null, curlast);
        if (this.last==null) {
            this.first = cur;
            this.last = cur;
        }
        else {
            curlast.next = cur;
            this.last = cur;
        }
    }

    public static Result sortByTask(Abonents abonents){
        Result result = new Result();

        for (Telephone cur = abonents.last; cur!=null; cur = cur.prev)
            if (!cur.isHot)
                result.pushItem(cur.name, cur.tel);

        return result;
    }

    public void print(){
        for (Telephone cur = this.first; cur!=null; cur = cur.next)
            System.out.println(cur.name+" "+cur.tel);
        System.out.println();
    }

    public void revprint(){
        for (Telephone cur = this.last; cur!=null; cur = cur.prev)
            System.out.println(cur.name+" "+cur.tel);
        System.out.println();
    }

    public static String[] struct(String s){
        return s.split(", ");
    }
}

package main.t3;

public class PriorList {
    class PriorItem{
        int prior;
        String value;
        PriorItem next;

        public PriorItem(int prior, String value, PriorItem next) {
            this.prior = prior;
            this.value = value;
            this.next = next;
        }
    }

    PriorItem head;
    PriorItem tail;

    public PriorList() {
        this.tail = null;
        this.head = null;
    }

    public void push(int prior, String value){
        PriorItem newItem = new PriorItem(prior, value, null);
        if (tail == null)
            head = newItem;
        else
            tail.next = newItem;
        tail = newItem;
        this.sort();
    }

    public void sort(){
        for (PriorItem cur = head; cur.next!=null; cur = cur.next){
            if (cur.prior < cur.next.prior){
                int tmpprior = cur.prior;
                String tmpvalue = cur.value;
                cur.prior = cur.next.prior;
                cur.value = cur.next.value;
                cur.next.prior = tmpprior;
                cur.next.value = tmpvalue;
            }
        }
    }

    public PriorItem search(String lfvalue){
        for (PriorItem cur = head; cur != null; cur = cur.next)
            if (cur.value.equals(lfvalue))
                return cur;
        return null;
    }

    public void pop(){
        System.out.println("deleted value " + head.value + " with prior " + head.prior);
        head = head.next;
    }

    public void print(){
        for (PriorItem cur = head; cur != null; cur=cur.next)
            System.out.println("prioritet=" + cur.prior + " | " + cur.value);
    }

}

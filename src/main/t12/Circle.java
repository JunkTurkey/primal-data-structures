package main.t12;

public class Circle{
    class Item{
        public int id;
        public Item next;

        public Item(int id, Item next){
            this.id = id;
            this.next = next;
        }
    }
    Item last;
    Item first;

    public Circle(int x) {
        Item newItem = new Item(x, null);
        first = newItem;
        last = newItem;
        first.next = last;
    }

    public void insert (int x){
        Item cur = new Item(x,null);
        last.next = cur;
        cur.next = first;
        last = cur;
    }

    public void doTask (int k){
        int count = 1;
        Item cur = first;
        Item prev = last;
        while (cur.next!=cur){
            if (count%k == 0){
                prev.next=cur.next;
                System.out.println(cur.id);
                cur = prev.next;
            }
            else {
                prev=cur;
                cur=cur.next;
            }
            count++;
        }
        first=cur;
        last=cur;
        System.out.println(last.id);
    }



}

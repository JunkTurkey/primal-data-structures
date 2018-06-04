package main.t11;

public class Mngchlen {
    class Item {
        public int value1;
        public int value2;
        public Item next;

        public Item(int value1, int value2, Item next) {
            this.value1 = value1;
            this.value2 = value2;
            this.next = next;
        }
    }

    Item last;
    Item first;
    int count;

    public Mngchlen() { last=null; count=0; }

    public void pushItem (int value1, int value2){
        Item newItem = new Item(value1, value2, null);
        if (last==null){
            first = newItem;
        }
        else {
            last.next = newItem;
        }
        last = newItem;
        count++;
    }

    public static int Meaning(Mngchlen p, int x){
        int func = 0;
        for (Item it=p.first; it.next!=null; it=it.next)
            func += it.value1*Math.pow(x, it.value2);

        return func;
    }

    public static boolean Equality(Mngchlen p, Mngchlen s){
        for (Item it=p.first; it.next!=null; it=it.next)
            if(p.last.value1!=s.last.value1 || p.last.value2!=s.last.value2) return false;
        return true;
    }

    public static void Add(Mngchlen p, Mngchlen s, Mngchlen res){

        for (Item it=p.first; it!=null; it=it.next)
            for (Item jt=s.first; jt!=null; jt=jt.next)
                if (it.value2==jt.value2 && it!=null && res.contains(it.value2)==null)
                    res.pushItem(it.value1+jt.value1, it.value2);

        for (Item it=p.first; it!=null; it=it.next)
            if (it!=null && res.contains(it.value2)==null)
                res.pushItem(it.value1,it.value2);

        for (Item jt=s.first; jt!=null; jt=jt.next)
            if (jt!=null && res.contains(jt.value2)==null)
                res.pushItem(jt.value1,jt.value2);
    }

    private Item contains(int i){
        if (this.first == null) return null;
        for (Item tt=this.first; tt.next!=null; tt=tt.next)
            if (tt.value2==i)
                return tt;
        return null;
    }

    public static int[] struct(String s){
        String[] tmp = s.split(", ");
        int[] result = new int[tmp.length];
        for (int i=0; i<tmp.length; i++)
            result[i] = Integer.parseInt(tmp[i]);
        return result;
    }

    public void print(){
        String result="";
        for (Item item = this.first; item!=null; item = item.next){
            if (item.value1 < 0)
                result+= item.value1 + "x^" + item.value2;
            else result+= "+" + item.value1 + "x^" + item.value2;
        }
        System.out.println(result);
    }


}

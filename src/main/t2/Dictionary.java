package main.t2;

public class Dictionary {

    class Diction{
        public String eng;
        public String rus;
        public int hashcode;
        public Diction next;

        public Diction(String eng, String rus) {
            this.eng = eng;
            this.rus = rus;
            this.hashcode = hash(eng);
            this.next=null;
        }

        public int hash(String s){
            int preres=0;
            for (int i=0; i < s.length(); i++)
                preres += s.charAt(i);
            return preres % s.length();
        }
    }

    Diction[] dictions;

    public Dictionary(int size) {

        dictions = new Diction[size];
    }

    public void add(String eng, String rus){
        Diction diction = new Diction(eng,rus);
        if (dictions[diction.hashcode] == null)
            dictions[diction.hashcode] = diction;
        else {
            Diction last = dictions[diction.hashcode];
            for (Diction cur = dictions[diction.hashcode]; cur!=null; cur = cur.next)
                last = cur;
            last.next = diction;
        }
    }

    public void delete(String eng, String rus){
        Diction diction = new Diction(eng, rus);
        for (int i=0; i<dictions.length; i++){
            Diction cur;
            if (dictions[i]!=null) {
                cur = dictions[i];
                if (cur.hashcode == diction.hashcode) {
                    if (cur.next==null) {
                        dictions[i] = null;
                        System.out.println("removed " + cur.eng + "|" + cur.rus);
                    }
                    else {
                        for (Diction current = dictions[cur.hashcode]; current.next != null; current = current.next) {
                            if (current.next.eng == diction.eng && current.next.rus == diction.rus) {
                                System.out.println("removed " + current.next.eng + "|" + current.next.rus);
                                current.next = current.next.next;
                                break;
                            }
                        }
                        System.out.println("didn't find your element");
                    }
                }
            }
        }
    }

    public void search(String eng){
        Diction diction = new Diction(eng,"");
        for (int i=0; i<dictions.length; i++){
            Diction cur = null;
            if (dictions[i]!=null) {
                cur = dictions[i];
                if (cur.hashcode == diction.hashcode) {
                    for (Diction current = dictions[cur.hashcode]; current != null; current = current.next) {
                        if (current.eng.equals(diction.eng)) {
                            System.out.println("found " + current.hashcode + " - " + current.eng + "|" + current.rus);
                            break;
                        }
                    }
                    System.out.println("didn't find your element");
                }
            }
        }
    }

    public void print(){
        for (int i=0; i<dictions.length; i++){
            Diction cur = null;
            if (dictions[i]!=null) {
                cur = dictions[i];
                for (; cur!=null; cur = cur.next)
                    System.out.println(cur.hashcode + " - " + cur.eng + "|" + cur.rus);
            }
        }
    }


}

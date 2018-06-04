package main.t13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Abonents {
    class Telephone{
        public String name;
        public String tel;
        public Telephone next;

        public Telephone(String name, String tel, Telephone next) {
            this.name = name;
            this.tel = tel;
            this.next = next;
        }
    }


    private Telephone first;
    private Telephone last;

    public Abonents() {        this.last = null;    }

    public void add(String name, String tel){
        Telephone telephone = new Telephone(name, tel, null);
        if (this.last==null){
            this.first = telephone;
        }
        else
            last.next = telephone;
        last = telephone;

    }

    public void Sort(){
        System.out.println("sorting abonents ...");
        for (Telephone tel = this.first; tel.next!=null; tel=tel.next )
            for (Telephone tel2 = this.first; tel2.next!=null; tel2=tel2.next)
                if (compareToNext(tel2)!=tel2)
                    swap(tel2, tel2.next);
    }

    private static void swap(Telephone telephone, Telephone next){
        String tempname = next.name;
        String temptel = next.tel;
        next.name = telephone.name;
        next.tel = telephone.tel;
        telephone.name = tempname;
        telephone.tel = temptel;
    }

    private Telephone compareToNext(Telephone telephone){
        return telephone.name.compareTo(telephone.next.name)<=0 ? telephone : telephone.next;
    }

    public void print(){
        for (Telephone cur = this.first; cur!=null; cur = cur.next)
            System.out.println(cur.name+" "+cur.tel);
        System.out.println();
    }

    public void lfName(String name){
        for (Telephone cur = this.first; cur!=null; cur=cur.next)
            if (cur.name.equals(name)){
                System.out.println(cur.name+" "+cur.tel+"\n");
                break;
            }
            else {
                System.out.println("didn't find this element");
                break;
            }

    }
    public void lfTel(String tel){
        for (Telephone cur = this.first; cur!=null; cur=cur.next)
            if (cur.tel.equals(tel)){
                System.out.println(cur.name+" "+cur.tel+"\n");
                break;
            }
            else {
                System.out.println("didn't find this element");
                break;
            }
    }

    public static String[] struct(String s){
        return s.split(", ");
    }


}

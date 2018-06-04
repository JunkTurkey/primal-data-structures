package main.t4;

public class Stack {
    class ItemList {
        class StackItem {
            char item;
            StackItem next;

            public StackItem(char item, StackItem next) {
                this.item = item;
                this.next = next;
            }
        }

        int count = 0;
        StackItem first;
        StackItem last;

        public void addLast(char input) {
            StackItem item = new StackItem(input, null);
            if (last == null)
                first = item;
            else last.next = item;
            last = item;
            count++;
        }

        public void addFirst(char input){
            StackItem item = new StackItem(input, null);
            if (first==null)
                last=item;
            first=item;
            count++;
        }

        public char remove(){
            char result = first.item;
            first=first.next;
            count--;
            return result;
        }
    }

    private char[] stackBody;
    private int count;

    public Stack(int count) {
        stackBody = new char[count];
        this.count = 0;
    }

    public void push(char ch){
        stackBody[count++] = ch;
    }

    public char pop(){
        return stackBody[--count];
    }

    public char peek(){
        return stackBody[count-1];
    }
    public boolean isEmpty(){
        return count==0;
    }
}

import java.util.Scanner;

class Main{
    static class Node<T> {
        public T data;
        public Node next;

        public Node(T data){
            this.data = data;
            this.next=null;
        }

        public void setData(T data){
            this.data = data;
        }
        public T GetData(){
            return this.data;
        }
        public void setNext(Node next){
            this.next=next;
        }
        public Node getNext(){
            return this.next;
        }
    }

    static class SinglyLinkedList<T>{
        public Node<T> head;

        public SinglyLinkedList(){
            this.head=null;
        }

        public void pushFront(Node data){
            data.setNext(head);
            this.head = data;
        }
        public void pushBack(Node data){
            Node start = head;
            if(start==null){
                data.setNext(head);
                this.head = data;
            }else{
                while(start.next!=null){
                    start = start.next;
                }
                start.next = data;
            }
        }
        public void popFront(){
            if(head==null){
                System.out.println("Can't pop. List is empty");
            }else{
                head = head.getNext();
            }
        }

        public void imprimir(){
            Node start = head;
            if(head==null){
                System.out.println("Nothing to print. List is empty");
            }
            else{
                while(start!=null){
                    if(start.next!=null){
                        System.out.print(start.data+" ");
                    }else if(start.next==null){
                        System.out.print(start.data);
                    }
                    start = start.next;
                }
            }

        }
    }


    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        String[] input = read.nextLine().split(" ");
        SinglyLinkedList<String> ogList = new SinglyLinkedList();
        for(String a:input){
            ogList.pushBack(new Node(a));
        }
        ogList.imprimir();
    }
}

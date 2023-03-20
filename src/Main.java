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
        public boolean isEmpty(){
            return head==null;
        }

        public void pushFront(Node data){
            data.setNext(head);
            this.head = data;
        }
        public void pushBack(Node data){
            Node start = head;
            if(head==null){
                head =data;
            }else{
                while(start.next!=null){
                    start = start.next;
                }
                //System.out.print("this is the data: ");
                //System.out.println(data.data);
                start.next = data;
            }
        }

        public Node popFront(){
            Node returned = null;
            if(head==null){
                System.out.println("Can't pop. List is empty");
            }else{
                returned = head;
                head = head.next;
            }
            return returned;
        }
        public Node popBack(){
            Node returned = null;
            Node start = head;
            if(head==null || head.next==null){
                returned = head;
                head=null;
            } else{
                while(start.next.next!=null){
                    start = start.next;
                }
                returned=start.next;
                start.next =null;
            }
            return returned;
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
        SinglyLinkedList<String> copyList = new SinglyLinkedList<>();

        while(!ogList.isEmpty()){
            Node popedFront;
            Node popedBack;
            popedFront = ogList.popFront();
            popedFront.next=null;
            popedBack = ogList.popBack();

            copyList.pushBack(popedFront);
            copyList.pushBack(popedBack);
        }
        copyList.imprimir();

    }
}

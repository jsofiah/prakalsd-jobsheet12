public class DoubleLinkedList01 {
    Node01 head;
    Node01 tail;
    int size = 0;

    public DoubleLinkedList01() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(Mahasiswa01 data){
        Node01 newNode = new Node01(data);
        if(isEmpty()){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Mahasiswa01 data){
        Node01 newNode = new Node01(data);
        if(isEmpty()){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void insertAfter(String keyNim, Mahasiswa01 data){
        Node01 current = head;
        while(current != null && !current.data.nim.equals(keyNim)){
            current = current.next;
        }
        if(current != null){
            Node01 newNode = new Node01(current, data, current.next);
            if(current.next != null){
                current.next.prev = newNode;
                } else {
                    tail = newNode;
                }
                current.next = newNode;
                size++;
        } else {
            System.out.println("Data gagal dimasukkan. Data " + keyNim + " tidak ditemukan.");
        }
    }

    public void print(){
        if(!isEmpty()){
            Node01 current = head;
            while (current != null) {
                current.data.tampil();
                current = current.next;
            }
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public Node01 search(String nim) {
        Node01 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void removeFirst(){
        if(isEmpty()){
            System.out.println("List kosong, tidak bisa dihapus");
            return;
        } else {
            System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah NIM " + head.data.nim);
            if (head == tail){
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }
    }

    public void removeLast(){
        if(isEmpty()){
            System.out.println("List kosong, tidak bisa dihapus");
            return;
        } else {
            System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah NIM " + tail.data.nim);
            if(head == tail){
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
        size--;
    }

    public void add(Mahasiswa01 data, int index){
        if (index < 0 || index > size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node01 newNode = new Node01(data);
            Node01 current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
    }

    public void removeAfter(String keyNim) {
        Node01 current = head;
        while (current != null) {
            if (current.data.nim.equals(keyNim)) {
                if (current.next == null) {
                    System.out.println("Tidak ada node setelah " + keyNim);
                    return;
                }
                Node01 hapus = current.next;
                current.next = hapus.next;
                if (hapus.next != null) {
                    hapus.next.prev = current;
                } else {
                    tail = current;
                }
                size--;
                System.out.println("Node setelah NIM " + keyNim + " berhasil dihapus.");
                return;
            }
            current = current.next;
        }
        System.out.println("NIM " + keyNim + " tidak ditemukan.");
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node01 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public void getFirst() {
        if (head != null) {
            head.data.tampil();
        } else {
            System.out.println("List kosong.");
        }
    }

    public void getLast() {
        if (tail != null) {
            tail.data.tampil();
        } else {
            System.out.println("List kosong.");
        }
    }

    public void getIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        Node01 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data.tampil();
    }

    public int getSize() {
        return size;
    }
}

public class Node01 {
    Mahasiswa01 data;
    Node01 prev;
    Node01 next;

    public Node01(Mahasiswa01 data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Node01(Node01 prev, Mahasiswa01 data, Node01 next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    
}

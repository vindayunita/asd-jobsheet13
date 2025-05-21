package dll;

public class DoubleLinkedList24 {
    Node24 head;
    Node24 tail;
    int size = 0;

    public DoubleLinkedList24() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void add(int index, Mahasiswa24 data) {
        if (index < 0 || index > size) {
            System.out.println("Indeks tidak valid!");
            return;
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node24 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            Node24 newNode = new Node24(data);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
            System.out.println("Data berhasil ditambahkan pada indeks ke-" + index);
        }
    }


    public void addFirst(Mahasiswa24 data) {
        Node24 newNode = new Node24(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Mahasiswa24 data) {
        Node24 newNode = new Node24(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void insertAfter(String keyNim, Mahasiswa24 data) {
        Node24 current = head;
    while (current != null && !current.data.nim.equals(keyNim)) {
        current = current.next;
    }
    if (current == null) {
        System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
        return;
    }
    Node24 newNode = new Node24(data);
    if (current == tail) {
        current.next = newNode;
        newNode.prev = current;
        tail = newNode;
    } else {
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
    }
    size++;
    System.out.println("Node berhasil disisipkan setelah NIM " +keyNim);
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada data yang dihapus!");
        } else {
            Mahasiswa24 dataTerhapus = head.data;

            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah...");
            dataTerhapus.tampil();
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus!");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void removeAfter(String keyNim) {
        Node24 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Tidak ada node setelah NIM " + keyNim + " yang bisa dihapus.");
            return;
        }

        Node24 toDelete = current.next;
        if (toDelete == tail) {
            tail = current;
            current.next = null;
        } else {
            current.next = toDelete.next;
            toDelete.next.prev = current;
        }
        size--;
        System.out.println("Node setelah NIM " + keyNim + " berhasil dihapus:");
        toDelete.data.tampil();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks tidak valid!");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node24 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            System.out.println("Data berhasil dihapus pada indeks ke-" + index + ":");
            current.data.tampil();

            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public void getFirst() {
        if (!isEmpty()) {
            System.out.println("Data pada node pertama:");
            head.data.tampil();
        } else {
            System.out.println("List kosong!");
        }
    }

    public void getLast() {
        if (!isEmpty()) {
            System.out.println("Data pada node terakhir:");
            tail.data.tampil();
        } else {
            System.out.println("List kosong!");
        }
    }

    public void getIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks tidak valid!");
            return;
        }
        Node24 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println("Data pada indeks ke-" + index + ":");
        current.data.tampil();
    }

    public Node24 search(String nim) {
        Node24 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong!");
            return;
        }
        Node24 current = head;
        System.out.println("Data Mahasiswa dalam Linked List:");
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }
}

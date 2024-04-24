class QueueOverflowException extends Exception {
    public QueueOverflowException(String message) {
        super(message);
    }
}

class QueueUnderflowException extends Exception {
    public QueueUnderflowException(String message) {
        super(message);
    }
}

class Queue {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    // Konstruktor
    public Queue(int capacity) {
        max = capacity;
        data = new int[max]; // Inisialisasi array data dengan ukuran max
        front = rear = -1;
        size = 0;
    }

    public boolean IsEmpty() {
        return size == 0;
    }

    public boolean IsFull() {
        return size == max;
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + data[front]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(data[i] + " ");
                i = (i + 1) % max;
            }
            System.out.println(data[rear]); // Print elemen terakhir
        }
    }

    public void clear() {
        if (!IsEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(int dt) throws QueueOverflowException {
        if (IsFull()) {
            throw new QueueOverflowException("Queue sudah penuh");
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max; // Perlu melakukan mod max untuk mengatasi circular queue
            }
            data[rear] = dt;
            size++;
        }
    }

    public int Dequeue() throws QueueUnderflowException {
        int dt = 0;
        if (IsEmpty()) {
            throw new QueueUnderflowException("Queue masih kosong");
        } else {
            dt = data[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                front = (front + 1) % max; // Perlu melakukan mod max untuk mengatasi circular queue
            }
        }
        return dt;
    }
}

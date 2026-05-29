import java.util.Arrays;

/// // making our own ArrayList<Integer>.</Integer>

class ArrayList {

    private int[] arr;
    private int size;

    ArrayList(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

   public void add(int ele) {
        if (size == arr.length) {
            capacityIncrease();
        }
        arr[size++] = ele;
    }

    private void capacityIncrease() {
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return arr[index];
    }

    void set(int index, int val) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        arr[index] = val;
    }

    int remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        int removed = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return removed;
    }

    int size() {
        return size; 
    }

    int capacity() {
        return arr.length;
    }

    void display() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}

public class OwnArrayList {
    public static void main(String[] args) {


        ArrayList arr = new ArrayList(10);
        System.out.println(arr.capacity());

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.display();
        arr.add(4);
        arr.display();
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.display();

        System.out.println(arr.capacity());
        arr.set(3, 22222);
        System.out.println(arr.get(2));


        arr.display();

    }


}

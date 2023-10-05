import java.util.Arrays;
import java.util.Random;

public class IntArray {

    private int[] arr;
    private int capacity;
    private int size;

    /**
     * sets up an internal array of size 5
     */
    public IntArray(){
        this.capacity = 5;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    /**
     * lets the programmer specify the initial capacity.
     */
    public IntArray(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    /**
     * An add(int x) method that appends an int as the last element in the internal array.
     * If the array is full, grow it so that it is big enough (double its capacity).
     */
    public void add(int x){
        if (this.size + 1 > this.capacity){
            this.capacity = this.capacity * 2;
            // create new array with double capacity
            int[] doubleArr = new int[this.capacity];
            // copy all elements to new array
            for (int i = 0; i < this.size; i++) {
                doubleArr[i] = this.arr[i];
            }
            // add new element
            doubleArr[this.size] = x;
            this.arr = doubleArr;
        }
        else {
            this.arr[this.size] = x;
        }
        this.size ++;
    }

    /**
     * An add(int index, int x) method that inserts x in the indexth slot.
     * All items after the indexth slot should be moved over.
     * If index is larger than the capacity of the internal array,
     * grow the array so that it is big enough (double its capacity, at least)
     */
    private void reArrange(int index, int newCapacity, int x){
        int[] newArray = new int[newCapacity * 2];
        if (index > newCapacity){
            for (int i = 0; i < this.size; i++) {
                newArray[i] = this.arr[i];
            }
        }
        else{
            // pointers
            int p = 0;
            int newP = 0;
            while (newP < this.size + 1){
                if (newP == index){
                    newArray[newP] = x;
                }
                else{
                    newArray[newP] = this.arr[p];
                    p ++;
                }
                newP ++;
            }
        }
        newArray[index] = x;
        this.arr = newArray;
        this.capacity = this.arr.length;
    }


    public void add(int index, int x){
        if (index >= this.capacity) {
            this.reArrange(index, index, x);
        }
        else if (this.size + 1 > this.capacity){
            this.reArrange(index, this.capacity, x);
        }
        else{
            // shift all elements from the back
            for (int i = this.size; i > index ; i--) {
                this.arr[i] = this.arr[i-1];
            }
            this.arr[index] = x;
        }
        this.size ++;
    }

    /**
     * A set(int index, int x) method that changes the indexth element to a given value x.
     * Both index and x should be sent in as parameters.
     * Use “assert” to specify that index must be within the size of the array.
     * If index is larger than the size of the internal array, the method should do nothing.
     */
    public void set(int index, int x){
        assert index < this.capacity && index > 0;
        this.arr[index] = x;
    }

    /**
     * A delete(index) method that removes the element at the index sent in as a parameter.
     * Use assert to specify the index must be within range.
     */
    public void delete(int index){
        assert index < this.capacity && index > 0;
        for (int i = index; i < this.size - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        this.arr[this.size - 1] = 0;
        this.size --;
    }


    /**
     * help method, get element by index.
     */
    private int get(int index){
        assert index < this.size && index > 0;
        return this.arr[index];
    }

    public boolean equals(IntArray intArray){
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] != intArray.get(i)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "IntArray{" +
                "arr=" + Arrays.toString(arr) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }


    public static void main(String[] args) {
        IntArray intArray = new IntArray();
        IntArray intArray2 = new IntArray(10);
        System.out.println(intArray + "[Default Capacity]");
        System.out.println(intArray2 + "[Custom Capacity]");
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int randInt = rand.nextInt(10, 100);
            intArray.add(randInt);
            intArray2.add(randInt);
        }
        System.out.println(intArray + "[Initial Add]");
        // add index resize
        intArray.add(2, 66666);
        System.out.println(intArray + "[Add Index Resize]");
        // add index out of boundary resize
        intArray2.add(10, 88888);
        System.out.println(intArray2 + "[Add Index Out of Capacity Resize]");
        // normal add
        intArray.add(999);
        System.out.println(intArray + "[Normal Add]");
        // set index
        intArray.set(2, 12345);
        System.out.println(intArray + "[Set Index]");
        // delete index
        intArray.delete(2);
        System.out.println(intArray + "[Delete Index]");
        // equals
        System.out.println(intArray.equals(intArray2) + "[Equals]");
        // equals
        intArray2 = intArray;
        System.out.println(intArray.equals(intArray2) + "[Equals]");
    }
}
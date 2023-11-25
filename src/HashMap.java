import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Data structure
 */

public class HashMap {
    ArrayList<LinkedList<HashEntry>> buckets;

    // inner class
    class HashEntry {
        String key;
        Object value;
        public HashEntry(String key, Object value){
            this.key = key;
            this.value = value;
        }
    }

    /**
     * a constructor which lets client specify how many buckets.*
     */
    public HashMap(int capacity){
        this.buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.buckets.add(i, new LinkedList<HashEntry>());
        }
    }

    /**
     * int hashcode(String key) -- get an integer value for a string.
     * Use the hashcode algorithm that Java uses for String.
     * @param key
     * @return
     */
    private int hashcode(String key){
        int hashCode = key.hashCode() % this.buckets.size();
        return hashCode < 0 ? hashCode*(-1) : hashCode;
    }

    /**
     * void put(String key, Object value)-- put an entry in the table
     * @param key
     * @param value
     */
    public void put(String key, Object value){
        int address = this.hashcode(key);    // get the address of the new key
        LinkedList<HashEntry> bucket = this.buckets.get(address);
        // loop through the linkedlist to see if the key already exists
        for (HashEntry entry: bucket){
            if (Objects.equals(entry.key, key)){
                // update the value and return
                entry.value = value;
                return;
            }
        }
        // no duplicate keys, create new entry and added to the linkedlist
        bucket.addLast(new HashEntry(key, value));
    }

    /**
     * Object get(String key) --get an entry from the table. Return -1 if key not in table.
     * @param key
     * @return
     */
    public Object get(String key){
        int address = this.hashcode(key);   // get the address of current key
        LinkedList<HashEntry> bucket = this.buckets.get(address);

        for(HashEntry entry: bucket){
            if (Objects.equals(entry.key, key)){
                return entry.value;
            }
        }
        return -1;
    }


    /**
     * Prints out the HashTable in a form that shows which bucket each word is in
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.buckets.size(); i++) {
            String s = "[BUCKET]" + i;
            sb.append(s);
            for(HashEntry entry: this.buckets.get(i)){
                String es = "[KEY]" + entry.key + "[VALUE]" + entry.value + "-->";
                sb.append(es);
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        HashMap hashmap = new HashMap(10);  // creates a HashTable with 10 buckets.

        // Puts 20 Mandarin words into it, with values of the English equivalent.
        hashmap.put("赵", "zhao");
        hashmap.put("钱", "qian");
        hashmap.put("孙", "sun");
        hashmap.put("李", "li");
        hashmap.put("周", "zhou");
        hashmap.put("吴", "wu");
        hashmap.put("郑", "zheng");
        hashmap.put("王", "wang");
        hashmap.put("王", "wong");
        hashmap.put("王", "wang");

        //Calls get a few times to show it works
        System.out.println(hashmap.get("王"));
        System.out.println(hashmap.get("周"));
        System.out.println(hashmap.get("钱"));

        // print out the whole hashmap
        System.out.println(hashmap);
    }
}

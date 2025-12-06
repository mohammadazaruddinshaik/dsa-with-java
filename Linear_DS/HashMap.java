
import java.util.*;
class HashMapDemo {
    public static void main(String[] args) {
        /*
            HashTable: is a datastructure that stores data in key-value pairs using hash functions.

            It gives O(1) for Avg Time complexity.
            *insert, search, delete

            How hash function works:
                1) We take a key
                2) Apply Hash Functions
                    ->convert key into an integer hash
                3) Compute index using modulus
                    index = hash(key)%capacity
            
            Collision Handling:we two keys generates the same index, that's a collision.

            Collision handling methods:
                1)Chaining (LinkedList):
                    each index stores LL of entries. 
                Open Addressing: stores inside array
                *Linear probing:    
                    if index is full go to next indexes such as index+1, index+2...
                *Quadratic probing:
                    if index is full, jump to next indexes such as index + 1^2, index + 2^2...
                *Double hashing:
                    compute second hash function inorder to calculate next step-size

                Common Methods:
                get()
                put()
                containsKey()
                containsValue()
                keySet()
                remove(key)
                remove(key,value)
                isEmpty()
                clear()
                entrySet() - entrySet().getKey(), entrySet.getValue()
                replace(key, new_value)
        */

        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(0, "azar");
        hm.put(1, "firoz");
        hm.put(2, "hitesh");
        System.out.println("Hashtable Elements: " + hm);

        System.out.println(hm.get(0));

        hm.remove(2);
        System.out.println("Hashtable Elements: " + hm);
        System.out.println("Size of Hashtable Elements: " + hm.size());

        for(int key: hm.keySet()){
            System.out.println(key);
        }

        for(String val: hm.values()){
            System.out.println(val);
        }

        //If order matters use TreeMap - sort's keys.
        //difference b/w hashmap & tree map
            //hashmap does'nt maintains order
            //tree map maintains order
            //hashmap is faster 
            //treemap is slower due to sort property
            //hashmap allow null keys 
            //treemap does'nt allow null keys 
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        //If you want a insertion order - use LinkedHashedMap
        //keeps them in the same order you put them in.


        HashMap<Integer,String> map = new LinkedHashedMap<>();
    }
}
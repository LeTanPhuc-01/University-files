import java.util.LinkedList;
import java.util.ArrayList;

class HashTable {
    private final int SIZE = 15;
    
    private ArrayList<LinkedList<Node>> table;

    class Node {
        String key;
        String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        table = new ArrayList<>(SIZE);
        
        for (int i = 0; i < SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }
    // hash code calculation
    private int hash(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += (int) c;
        }
        return hashCode % SIZE;
    }

    // insert key-value pair
    public void put(String key, String value) {
        int index = hash(key);
        for (Node node : table.get(index)) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        table.get(index).add(new Node(key, value));
    }

    // retrieve value by key
    public String get(String key) {
        int index = hash(key);
        for (Node node : table.get(index)) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("bucket " + i + ": ");
            for (Node node : table.get(i)) {
                System.out.print("[" + node.key + ": " + node.value + "] -> ");
            }
            System.out.println("null");
        }
    }
    public boolean remove(String key){
        int index = hash(key);
        for(Node node : table.get(index)){
            if(node.key.equals(key)){
                table.get(index).remove(node);
                return true;
            }
        } 
        return false;
    }
    public boolean containsKey(String key){
        int index = hash(key);
        for (Node node : table.get(index)){
            if(node.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> keys(){
        ArrayList<String> keyList = new ArrayList<>();
        for (LinkedList<Node> bucket : table){
            for (Node node : bucket){
                keyList.add(node.key);
            }
        }
        return keyList;
    }
    public ArrayList<String> values(){
        ArrayList<String> valueList = new ArrayList<>();
        for (LinkedList<Node> bucket : table){
            for (Node node : bucket){
                valueList.add(node.value);
            }
        }
        return valueList;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.put("cat", "Value1");
        hashTable.put("dog", "Value2");
        hashTable.put("apple", "Value3");
        hashTable.put("hello", "Value4");
        hashTable.put("world", "Value5");
        

        hashTable.display();

        System.out.println("Value for 'cat': " + hashTable.get("cat"));
        System.out.println("Value for 'world': " + hashTable.get("world"));
        System.out.println("Value for 'nonexistent': " + hashTable.get("nonexistent"));
        System.out.println("Removing cat: " + hashTable.remove("cat"));
        System.out.println("Contains dog: " + hashTable.containsKey("dog"));
        System.out.println("Contains cat: " + hashTable.containsKey("cat"));
        System.out.println("All keys: " + hashTable.keys());
        System.out.println("All values: " + hashTable.values());

    }
}
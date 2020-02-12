package tp2;

public class LinkedHashMap<KeyType, DataType> {

    private static final double COMPRESSION_FACTOR = 2; // 50%
    private static final int DEFAULT_CAPACITY = 20;
    private static final int CAPACITY_INCREASE_FACTOR = 2;

    private Node<KeyType, DataType>[] map;
    private int capacity;
    private int size = 0;

    public LinkedHashMap() {
        capacity = DEFAULT_CAPACITY;
        map = new Node[DEFAULT_CAPACITY];
    }

    public LinkedHashMap(int capacity) {
        this.capacity = capacity;
        map = new Node[capacity];
    }

    /**
     * Finds the index attached to a particular key
     * @param key Value used to access to a particular instance of a DataType within map
     * @return The index value attached to a particular key
     */
    private int getIndex(KeyType key){
        int keyHash = key.hashCode() % capacity;
        return keyHash < 0 ? -keyHash : keyHash;
    }

    private boolean shouldRehash() {
        return size * COMPRESSION_FACTOR > capacity;
    }

    /** TODO
     * Increases capacity by CAPACITY_INCREASE_FACTOR (multiplication) and
     * reassigns all contained values within the new map
     */
    private void rehash() {
        int capacity = map.length* CAPACITY_INCREASE_FACTOR;
        Node<KeyType, DataType> [] newMap = new Node[capacity];
        this.capacity=newMap.length;
        for (int i =0; i<map.length;i++){
            if(map[i] != null) {
                Node<KeyType, DataType> node = map[i];
                while (node != null) {
                    if (newMap[getIndex(node.key)] == null) {
                        newMap[getIndex(node.key)] = new Node<KeyType, DataType>(node.key, node.data);
                    }
                    else {
                        newMap[getIndex(node.key)].next = new Node<KeyType, DataType>(node.key, node.data);
                    }
                    node = node.next;
                }
            }
        }
        this.map = newMap.clone();
        int j;
    }

    public int size() {
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** TODO
     * Finds if map contains a key
     * @param key Key which we want to know if exists within map
     * @return if key is already used in map
     */
    public boolean containsKey(KeyType key) {
        Node <KeyType, DataType> node = map[getIndex(key)];

        while(node!=null) {
            if (node.key.equals(key)) {
                return true;
            }
            node=node.next;
        }
        return false;
    }

    /** TODO
     * Finds the value attached to a key
     * @param key Key which we want to have its value
     * @return DataType instance attached to key (null if not found)
     */
    public DataType get(KeyType key) {
        Node<KeyType, DataType> node = map[getIndex(key)];
        while (node != null && !node.key.equals(key)) {
            node = node.next;
        }
        if (node != null) {
            return node.data;
        } else {
            return null;
        }
    }

    /** TODO
     * Assigns a value to a key
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value) {

        if(containsKey(key)){
            DataType oldVal=get(key);
            map[getIndex(key)].data=value;
            return oldVal;
        }
        else{
            if(map[getIndex(key)]!=null){
                Node node=map[getIndex(key)];
                while(node.next!=null) {
                    node=node.next;
                }
                node.next = new Node<KeyType, DataType>(key, value);
            }
            else {
                map[getIndex(key)] = new Node<KeyType, DataType>(key, value);
            }
            size++;
            if(shouldRehash()){
                rehash();
            }
            return null;
        }

        /*DataType oldVal = null;
        for(Node<KeyType,DataType> node=map[getIndex(key)];node != null; node = node.next){
            if(node.key.equals(key)){
                oldVal=node.data;
                node.data=value;
                return oldVal;
            }
        }
        /*Node<KeyType,DataType> node=map[getIndex(key)];
        if(node!=null){
            node=node.next;
        }
        else {*/
            /*map[getIndex(key)] = new Node<KeyType, DataType>(key, value);
        //}
        size++;
        if (shouldRehash()) {
            rehash();
        }
        return null;*/
    }

    /** TODO
     * Removes the node attached to a key
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key) {
        if(containsKey(key)) {
            Node<KeyType, DataType> node = map[getIndex(key)];
            while (!node.key.equals(key)) {
                node = node.next;
            }
            DataType oldVal=node.data;
            node=null;
            size--;
            return oldVal;
        }
        return null;
    }

    /** TODO
     * Removes all nodes contained within the map
     */
    public void clear() {
        for(int i=0; i<map.length;i++){
            map[i]=null;
        }
        size=0;
    }


    static class Node<KeyType, DataType> {
        final KeyType key;
        DataType data;
        Node next; // Pointer to the next node within a Linked List

        Node(KeyType key, DataType data)
        {
            this.key = key;
            this.data = data;
            next = null;
        }
    }
}



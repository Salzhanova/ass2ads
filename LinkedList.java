public class LinkedList {

    public static void main(String[] args) {
        MyHashTable list = new MyHashTable(13);

        public void link () {
            list.insert("AAA");
            list.insert("aaa");
            list.insert("a");
            list.insert("Aaa");
            list.insert("aaA");

            assert -1 == list.find("nnn");
            assert 0 == list.find("aaa"); }

    }
}


class MyHashTable {

    String[] hashArray;
    int used = 0;
    int arrSize;

    public MyHashTable(int capacity) {

        if (!isPrimeNumber(capacity)) {
            capacity = getNextPrime(capacity);
        }
        arrSize = capacity;
        hashArray = new String[capacity];
    }


    int hash1(String word) {
        int Val = word.hashCode();
        Val = Val % arrSize;

        if (Val < 0) {
            Val = Val + arrSize;
        }
        return Val;
    }

    int hash2(int Val) {
        return 3 - Val % 3;
    }

    public boolean insert(String word) {
        int Val = hash1(word);
        int stepSize = hash2(Val);

        while (hashArray[Val] != null) {
            Val = Val + stepSize;
            Val = Val % arrSize;
        }
        hashArray[Val] = word;
        used++;
        System.out.printf("\n word %s index %s total space %s", word, Val, used);
        return true;
    }

    public int find(String word) {
        int Val = hash1(word);
        int stepSize = hash2(Val);
        while (hashArray[Val] != null) {
            if (hashArray[Val].equalsIgnoreCase(word)) {
                return Val;
            }
            Val += stepSize;
            Val %= stepSize;
        }
        return -1;
    }

    private boolean isPrimeNumber(int capacity) {

        for (int i = 2; i * i < capacity; i++) {
            if (capacity % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getNextPrime(int num) {
        for (int i = num; ; i++) {
            if (isPrimeNumber(i)) {
                return i;
            }
        }
    }
}
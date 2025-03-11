public class FindSocks {
    public static boolean findSocks(int[] A, int l, int r, int key) {
        // 1. If the range is invalid or empty, return false
        if (l >= r) {
            return false;
        }

        // 2. Find the midpoint
        int m = (l + r) / 2;

        // 3. Check if key at midpoint
        if (A[m] == key) {
            return true;
        }

        // 4 & 5. If key is smaller than midpoint value, search left half
        if (key < A[m]) {
            return findSocks(A, l, m, key);
        }
        // 6 & 7. If key is larger, search right half
        else if (key > A[m]) {
            return findSocks(A, m + 1, r, key);
        }
        // 8. Otherwise, return false (SocksNotFound)
        else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] boxes = {1, 2, 4, 6, 7, 9, 10};
        int key = 3;

        boolean found = findSocks(boxes, 0, boxes.length, key);
        System.out.println("Key " + key + " found in array: " + found);
    }
}

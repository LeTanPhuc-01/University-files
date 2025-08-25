public class App {
    public static void main(String[] args) {
        int[] numbers = new int[]{7,10,4,3,20,15};
        int k = 1;
        KthSmallestNumber kthSmallestNumber = new KthSmallestNumber();
        System.out.println(kthSmallestNumber.KSmall(numbers, 0, numbers.length-1, k));
    }
}

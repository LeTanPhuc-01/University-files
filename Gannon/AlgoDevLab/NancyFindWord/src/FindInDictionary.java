public class FindInDictionary {
    public static void main(String[] args) throws Exception {
        String[] dict = {"apple", "dog","mad","man","hello"};
        System.out.println(findWord("hello", 0, 4,dict));
    }
    public static int findWord(String a, int left, int right, String[] dict){
        int middle = (left + right) / 2;
        if(dict[left].equals(a)){
            return left;
        }else if (left >= right){
            return - 1;
        }else if(dict[middle].compareTo(a)<0){
            return findWord(a,middle+1,right,dict);
        }else{
            return findWord(a,left,middle,dict);
        }
        

    }
}

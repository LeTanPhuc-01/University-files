public class GenericBox<T> {
    private T content;
    // public GenericBox(T content) {
    //     this.content = content;
    // }
    public T getContent() {
        return content;
    }
    public void setContent(T content) {
        this.content = content;
    }
    public String toString() {
        return "Box with content: " + content.toString();
    }
    public static void main(String[] args) {
        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.setContent("Hello, World!");
        System.out.println(stringBox.toString());
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.setContent(123);
        System.out.println(integerBox.toString());
    }
    
}

public class ArrayStackDemo {
    public static void main(String[] args) {

        System.out.println("===== STACK INTEGER =====");
        ArrayStack<Integer> numbers = new ArrayStack<>(3);
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());

        System.out.println("\n===== STACK STRING =====");
        ArrayStack<String> texts = new ArrayStack<>(2);
        texts.push("PBO");
        texts.push("Collection");
        System.out.println(texts.pop());
        System.out.println(texts.pop());

        System.out.println("\n===== UJI OVERFLOW =====");
        ArrayStack<Integer> full = new ArrayStack<>(3);
        full.push(10);
        full.push(20);
        full.push(30);
        try {
            full.push(40);
        } catch (ArrayStack.ArrayStackException e) {
            System.out.println("Tertangkap: " + e.getMessage());
        }

        System.out.println("\n===== UJI UNDERFLOW =====");
        ArrayStack<Integer> empty = new ArrayStack<>(3);
        System.out.println("isEmpty awal = " + empty.isEmpty());
        empty.push(7);
        System.out.println("pop = " + empty.pop());
        System.out.println("isEmpty setelah pop = " + empty.isEmpty());
        try {
            empty.pop();
        } catch (ArrayStack.ArrayStackException e) {
            System.out.println("Tertangkap: " + e.getMessage());
        }
    }
}
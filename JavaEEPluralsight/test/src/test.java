public class test {
    public static void main(String[] args) {
        boolean isSome = true;

        isSome ? doSmth1() : doSmth2();
    }
    static void doSmth1() {
        System.out.println("1");
    }
    static void doSmth2() {
        System.out.println("2");
    }
}

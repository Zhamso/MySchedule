public class MyCounter {
    private int value = 0;

    public int getValue() {
        return value;
    }
    public void setValue(int a) {
        value = a;
    }
    public void incrementCounter() {
        value++;
        if(value == 14){
            value = 0;
        }
    }
}

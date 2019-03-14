package Count;

public class Count {
    private int count;
    public void setNumber(float s) {
        count = (int) s;
    }
    public int getNumber() {
        return count;
    }

    public void start() {
        System.out.println(count/120);
    }
}

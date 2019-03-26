package Count;

public class Count {
    private int cnt;

    public void setNumber(float s) {
        cnt = (int) s;
    }

    public int getNumber() {
        return cnt;
    }

    public void start() {
        System.out.println(cnt / 120);
    }
}

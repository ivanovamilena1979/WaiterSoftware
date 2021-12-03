package company;

public class Table {

    private int number;
    private boolean isFree = true;

    public Table(int number, boolean isFree) {
        this.number = number;
        this.isFree = isFree;
    }
    public Table() {
        this.number = 1;
    }
    public int getNumber() {
        return number;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "Table{" +
                "number=" + number +
                ", isFree=" + isFree +
                '}';
    }
}

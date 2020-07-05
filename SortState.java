import java.lang.reflect.Array;
import java.util.Arrays;

public class SortState {
    private int[] array;
    private int i;
    private int j;

    public SortState(int[] array, int i, int j) {
        this.array = Arrays.copyOf(array, array.length);
        this.i = i;
        this.j = j;
    }

    public int[] getArray() {
        return array;
    }


    public int getI() {
        return i;
    }


    public int getJ() {
        return j;
    }


}

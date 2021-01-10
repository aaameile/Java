package Compare;


import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Sorted implements Comparable<Sorted>{
    private Integer num1;
    private Integer unm2;

    public Sorted(Integer num1, Integer num2) {
        this.num1 = num1;
        this.unm2 = num2;
    }

    @Override
    public String toString() {
        return "Sorted{" +
                "num1=" + num1 +
                ", unm2=" + unm2 +
                '}';
    }

    public Integer getNum1() {
        return num1;
    }

    public Integer getUnm2() {
        return unm2;
    }

    @Override
    public int compareTo(@NotNull Sorted o) {
        if (this.unm2.equals(o.unm2)){
            return -this.num1.compareTo(o.num1);
        }
            return this.unm2.compareTo(o.unm2);
    }

    public static void main(String[] args) {
        TreeSet<Sorted> set = new TreeSet();
        List<int[]> ints = Arrays.asList(
                new int[]{2, -1},
                new int[]{1, 3},
                new int[]{1, 2},
                new int[]{0, 1},
                new int[]{2, -2},
                new int[]{3, 0},
                new int[]{2, 0},
                new int[]{-1, 0});
        for (int[] nums : ints){
            set.add(new Sorted(nums[0],nums[1]));
        }
        System.out.println("set = " + set);

    }

}

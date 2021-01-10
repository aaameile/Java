package Generic;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void test(){
//        Comparator<Employee> comp = new Comparator<Employee>() {
//
//
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                MyDate b1 = o1.getBirthday();
//                MyDate b2 = o2.getBirthday();
//                return b1.compareTo(b2);
//            }
//            };
        Comparator<Employee> comp = (o1, o2) -> {
            MyDate b1 = o1.getBirthday();
            MyDate b2 = o2.getBirthday();
            return b1.compareTo(b2);
        };

        TreeSet<Employee> set = new TreeSet<>(comp);
        Employee employee = new Employee("上单",12,new MyDate(1998 ,8,12));
        set.add(employee);


        set.add(new Employee("AD",10,new MyDate(1998 ,7,12)));
        set.add(new Employee("中路",16,new MyDate(1999 ,6,12)));
        set.add(new Employee("打野",13,new MyDate(1997 ,5,12)));
        set.add(new Employee("辅助",15,new MyDate(1990 ,4,12)));
        set.add(new Employee("辅助",13,new MyDate(1993 ,4,12)));

        for (Employee value : set) {
            System.out.println(value);
        }

    }
}

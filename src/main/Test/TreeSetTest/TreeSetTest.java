package TreeSetTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void test(){
        Comparator comp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    if (e1.getName().equals(e2.getName())){
                        return Integer.compare(e1.getAge(),e2.getAge());
                    }
                    return e1.getName().compareTo(e2.getName());
                }else {
                    throw new RuntimeException("添加数据类型不一致");
                }
            }
        };
        TreeSet set = new TreeSet(comp);
        Employee employee = new Employee("上单",12,new MyDate(1998 ,8,12));
        set.add(employee);


        set.add(new Employee("AD",10,new MyDate(1998 ,7,12)));
        set.add(new Employee("中路",16,new MyDate(1998 ,6,12)));
        set.add(new Employee("打野",13,new MyDate(1998 ,5,12)));
        set.add(new Employee("辅助",15,new MyDate(1998 ,4,12)));
        set.add(new Employee("辅助",13,new MyDate(1998 ,4,12)));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

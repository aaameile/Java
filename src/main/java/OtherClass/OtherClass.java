package OtherClass;
/*
System
math
BigInteger BigDecimal
        */

import org.junit.Test;

import java.util.Comparator;

public class OtherClass {
    //System类
    @Test
    public void test(){
        String os = System.getProperty("os.version");
        System.out.println(os);
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        String java = System.getProperty("java.version");
        System.out.println(java);
    }
    //Math类
    //BigInteger最大整型任意长度 BigDecimal高精度整型

    class a implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }


    @Test
    public void test2() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
    }

    }

package Optional;

import org.junit.Test;

import java.util.Optional;

/*
Optional 避免开发中出现空指针
 */
public class OptionalTest {
    @Test
    public void test(){
        Girl girl = new Girl();
        //girl = null;//NullPointerException
        //of.(T t)需要保证t不为空
        Optional<Object> o = Optional.of(girl);

    }
    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;//NullPointerException
        //ofNullable.(T t)需要保证t不为空
        Optional<Object> o = Optional.ofNullable(girl);
        System.out.println(o);
    }

    public String getGN(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test3(){
//        Boy boy = new Boy();
//        String gn = getGN(boy);
//        System.out.println(gn);

    }
}

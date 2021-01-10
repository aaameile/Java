package String;

public class StringTest1 {
    String str = new String("good");
    char[] ch = {'t','e','s','t'};
    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest1 test = new StringTest1();
        test.change(test.str,test.ch);
        System.out.println("test.str = " + test.str);
        System.out.println("test.ch = " + test.ch);
    }

}

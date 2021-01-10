package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name ;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public static List<User> getUsers(){
        List<User> list = new ArrayList<>();
        list.add(new User("小红",21));
        list.add(new User("小黄",41));
        list.add(new User("小蓝",11));
        list.add(new User("小白",24));
        list.add(new User("小紫",12));
        list.add(new User("小紫",12));
        list.add(new User("小紫",12));
        return list;
    }
}

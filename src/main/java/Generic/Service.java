package Generic;

import org.junit.Test;

import java.util.List;

public class Service {
    @Test
    public void test(){
        CustomerDAO customerDao = new CustomerDAO();
        customerDao.add("1001",new Customer("周杰伦", 1001));
        customerDao.add("1002",new Customer("昆凌", 1002));
        customerDao.add("1003",new Customer("邓紫棋", 1003));


//        boolean remove = customerDao.remove("1001");
//
        customerDao.update("1003",new Customer("方文山",1003));
        customerDao.remove("1001");
        List<Customer> list = customerDao.getList();
        list.forEach(System.out::println);//方法引用jdk新特性
//
//        Customer index = customerDao.getIndex(1);
//
//        List<Customer> customerList = customerDao.getList(10);
    }
    @Test
    public void test2(){
//        StudentDAO studentDAO = new StudentDAO();
//        studentDAO.add(new Student());Student
    }



}

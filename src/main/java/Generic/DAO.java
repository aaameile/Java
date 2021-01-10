package Generic;

import java.util.*;

/*
DAO data access object 数据库对象
 */
public class DAO<T> {
    private Map<String,T> map = new HashMap<>();
    //增 把值存放到map中
    public void add(String id, T entity){
        map.put(id,entity);
    }
    //删
    public void remove(String index){
         map.remove(index);
    }
    //改
    public void update(String index,T entity){
        if (map.containsKey(index)){
            map.put(index,entity);
        }
    }
    //查
    public T getIndex(String index){
        return map.get(index);
    }
    //查多个
    public List<T> getList(){
        Collection<T> values = map.values();
        return new ArrayList<>(values);
    }
    public <E> E getValue(){
        return null;
    }
}

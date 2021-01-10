package IOStream;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
获取文本字符出现的次数 把数据写入文件
 */
public class Count {
    @Test
    public void test(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            Map<Character ,Integer> map = new HashMap<>();
            FileReader reader = new FileReader("world.txt");
            br = new BufferedReader(reader);
            //遍历每一个字符把出现的字符次数放到map中
            int count = 0;
            while ((count = br.read()) != -1){
                char ch = (char) count;
//                if (map.get(ch) == null){
//                    map.put(ch,1);
//                }else {
//                    map.put(ch,map.get(ch) + 1);
//                }
                map.merge(ch, 1, Integer::sum);
            }
            FileWriter writer = new FileWriter("world2.txt");
            bw = new BufferedWriter(writer);
            Set<Map.Entry<Character,Integer>> entries = map.entrySet();
            for (Map.Entry<Character,Integer> entry : entries){
                switch (entry.getKey()){//看看key到底是什么
                    case ' ':
                        bw.write("空格有" + entry.getValue()+ "个");
                    case '\t':
                        bw.write("tab建有");
                    case '\r':
                        bw.write("回车有" + entry.getValue()+ "个");
                    case '\n':
                        bw.write("换行有" + entry.getValue()+ "个");
                    default:
                        bw.write(entry.getKey() + "有" + entry.getValue()+ "个");
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
                assert bw != null;
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

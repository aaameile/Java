package IO;

import java.io.File;
import java.io.FilenameFilter;

public class FileAccept implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return dir != null && name.toLowerCase().endsWith(".java");

    }

}
class Example{
    public static void main(String[] args) {
        System.out.println(" 当前目录下的文件 ");
        File file = new File("C:\\workspace.idea\\JavaSenior\\src\\main\\java\\IO");
        String[] list = file.list(new FileAccept());
        assert list != null;
        for (String f : list){
            System.out.println("f = " + f);
        }
    }



}
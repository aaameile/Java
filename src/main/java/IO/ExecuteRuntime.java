package IO;

import java.io.File;
import java.io.IOException;

public class ExecuteRuntime {
    public static void main(String[] args) {
        try {
            Runtime runtime = Runtime.getRuntime();
            File file = new File("c:\\windows\\system32","notepad.exe");
            runtime.exec(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

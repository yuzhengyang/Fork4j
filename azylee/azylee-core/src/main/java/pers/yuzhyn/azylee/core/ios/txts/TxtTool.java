package pers.yuzhyn.azylee.core.ios.txts;

import pers.yuzhyn.azylee.core.datas.strings.StringConst;
import pers.yuzhyn.azylee.core.datas.uuids.UuidTool;
import pers.yuzhyn.azylee.core.ios.files.FileTool;
import pers.yuzhyn.azylee.core.systems.souts.PrintTool;

import javax.swing.text.html.Option;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

public class TxtTool {

    public static List<String> readLine(String pathName) {
        List<String> result = null;
        if (FileTool.isExist(pathName)) {
            try {
                File file = new File(pathName);
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line = null;
                result = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
            } catch (Exception ex) {
            }
        }
        return result;
    }

    public static boolean append(String pathName, String txt) {
        FileTool.create(pathName);
        if (FileTool.isExist(pathName)) {
            FileWriter writer = null;
            try {
                File file = new File(pathName);
                writer = new FileWriter(file, true);
                writer.write(StringConst.NEWLINE);
                writer.write(txt);
                return true;
            } catch (Exception ex) {
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        {
//            String pp = "d:\\tmp\\t1.txt";
//            FileTool.recreate(pp);
//            long time = System.currentTimeMillis();
//            for (int i = 0; i < 10; i++) {
//                TxtTool.append(pp, "UuidTool.get()");
//            }
//            long time2 = System.currentTimeMillis();
//            System.out.println("append 方法 执行 共用时：" + (time2 - time));
//        }
//    }
}

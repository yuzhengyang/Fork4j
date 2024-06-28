package pers.yuzhyn.azylee.study;

import com.yuzhyn.azylee.core.ios.dirs.DirTool;

public class DirToolTest {
    public static void main(String[] args) {
        String path = "D:\\【临时文件】\\2024-06-28\\a1\\b1";
        DirTool.create(path);

        List<Tuple2<String,String>> list = new ArrayList<>();
        list.add(new Tuple2<>("a1","b1"));
        list.add(new Tuple2<>("a1","b2"));
    }
}

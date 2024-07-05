package com.yuzhyn.azylee.core.ios.dirs;

import com.yuzhyn.azylee.core.ios.files.FileTool;
import com.yuzhyn.azylee.core.logs.Alog;

import java.io.File;

public class DirTool {
    public static boolean isExist(String path) {
        try {
            File file = new File(path);
            return file.exists() && file.isDirectory();
        } catch (Exception ex) {
            return false;
        }
    }

    public static String parent(String path) {
        try {
            File file = new File(path);
            String strParentDirectory = file.getParent();
            return strParentDirectory;
        } catch (Exception ex) {
            Alog.e(ex.getMessage());
        }
        return path;
    }

    public static boolean create(String path) {
        if (!DirTool.isExist(path)) {
            try {
                File file = new File(path);
                return file.mkdirs();
            } catch (Exception ex) {
                Alog.e(ex.getMessage());
                return false;
            }
        }
        return true;
    }

    public static String combine(String path1, String path2) {
        if (path1.endsWith(File.separator) || path2.startsWith(File.separator)) {
            return path1 + path2;
        }
        return path1 + File.separator + path2;
    }

    public static String combine(String... paths) {
        if (paths.length > 0) {
            String result = paths[0];
            for (int i = 1; i < paths.length; i++) {
                result = combine(result, paths[i]);
            }
            return result;
        }
        return "";
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param path 参数
     * @return 返回 返回
     */
    public static boolean delete(String path) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!path.endsWith(File.separator)) path = path + File.separator;

        File dirFile = new File(path);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) return false;

        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = FileTool.delete(files[i].getAbsolutePath());
                if (!flag) break;
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = delete(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        return dirFile.delete();
    }

    public static void main(String[] args) {
//        boolean aa = DirTool.delete("D:\\code\\projects\\my-github-projects\\Hidoc\\03_SRC\\hidoc\\hidoc_data\\temp\\20211118\\116682060910821376");
//        int a = 0;
    }
}

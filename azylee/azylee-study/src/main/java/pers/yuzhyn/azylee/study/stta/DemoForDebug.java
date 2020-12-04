package pers.yuzhyn.azylee.study.stta;

/**
 * <p>Title: Demo11</p>
 * <p>Description:
 * <P>Program: javatraining
 * <P>Copyright:histone.com
 *
 * @author Ma Yinghui
 * @date 2019-12-17 17:29
 */
public class DemoForDebug {

    private static void print1(int i){
        System.out.println(i);
    }
    public static void main(String[] args) {
       for (int i = 0;i<10;i++)
           System.out.println(i);
        print1(1);
    }

}

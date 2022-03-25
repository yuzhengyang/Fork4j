package com.yuzhyn.azylee.core.datas.numbers;

public class RandomTool {

    /**
     * 获取随机数，包含两端
     * @param min
     * @param max
     * @return
     */
    public static int get(int min, int max) {
        if (max < min) {
            int tmp = max;
            max = min;
            min = tmp;
        }
        int num = (int) (Math.random() * (1 + max - min)) + min;
        return num;
    }

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 20; i++) {
                System.out.print(get(-1, 1) + "  ");
            }
            System.out.println();
        }
    }
}

package com.yuzhyn.azylee.core.datas.numbers;

public class RandomTool {

    /**
     * 通过范围区间，获取整数随机数
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return 返回
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

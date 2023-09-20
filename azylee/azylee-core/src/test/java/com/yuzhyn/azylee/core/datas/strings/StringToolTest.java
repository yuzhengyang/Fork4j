package com.yuzhyn.azylee.core.datas.strings;


import com.yuzhyn.azylee.core.datas.ids.UUIDTool;

public class StringToolTest {

    public static void main(String[] args) {
        long ts = System.currentTimeMillis();
        String s = "F3,7D,72,8D,48,F4,C0,EB,99,9A,7A,00,56,37,85,E9,CB,54,7E,8B,09,2B,73,AB,69,84,55,1E,E9,62,73,FD,8E,D7,FA,20,84,C1,08,CF,48,A7,79,9F,C2,14,D7,A5,52,1B,45,CB,3D,98,82,76,57,6C,1C,FE,B6,11,B1,49,71,EC,32,83,A5,DE,6F,30,15,29,D3,BC,AF,3F,76,FD,BA,85,21,8B,28,9A,28,6F,F6,A6,D7,9B,06,D1,06,6A,79,AD,30,25,05,33,BD,78,22,AF,F6,7E,61,60,DA,4B,3E,21,36,02,EE,12,5D,FA,57,DF,E7,6A,67,2B,23,20,73,14,EB,BA,10,88,81,AE,86,16,A9,10,75,F6,AC,D6,8F,89,58,EF,50,CB,5C,E8,10,46,75,43,50,D6,26,92,0F,97,FF,06,8D,5C,D8,D4,0F,CD,FB,9B,F7,F5,03,2D,CE,18,15,F7,75,46,9E,9E,3F,79,75,5E,DF,A8,E9,27,EF,2A,18,98,A1,37,A0,A9,F3,B5,A0,DA,FC,26,9C,3C,42,29,AA,1D,45,9A,EE,B3,87,91,28,10,73,80,E0,CD,9A,F5,CD,00,EB,B7,47,7D,75,54,38,B3,45,E2,D8,9E,84,F5,BD,8C,CC,F7,C7,4E,73,19,05,9F,51,8E,4E,29,05,D1,0B,1D,FE,0B,FB,FA,9C,8E,3C,8F,BE,62,10,F7,C7,9F,45,D5,07,13,5F,8D,1B,E7,0B,45,09,76,0D,B5,8B,F9,BC,50,C6,ED,B7,C7,3E,5F,30,18,95,30,22,51,EF,42,2A,DF,C8,F9,C5,18,79,6B,6E,AF,C5,26,0F,F7,67,8C,86,F0,4F,84,EE,02,27,50,5B,DF,09,FD,7D,FF,BC,AE,AC,49,E3,EF,7C,34,1D,C8,23,A4,7E,4E,E0,92,86,25,05,2E,EB,9B,54,E8,EA,84,03,30,E3,1E,D6,27,96,73,71,21,E9,B4,ED,84,42,72,7F,B4,0E,14,2C,D6,F3,A1,1C,28,02,3C,EB,D8,5D,78,E1,64,1D,B3,44,36,A7,38,A4,1D,45,BA,85,2E,11,BC,43,B5,0A,2D,04,2E,1D,D1,DE,02,E9,BC,50,FD,AE,78,67,C2,4D,20,1F,AD,C8,A8,FF,44,2F,14,47,86,25,AE,5A,FB,1A,10,25,B7,B3,1B,C9,BE,2F,97,FB,41,F0,BB,67,EE,6F,BA,07,ED,86,7C,F9,2D,E3,44,41,28,C6,51,AC,A3,4F,96,0B,FC,B5,E3,DC,1A,0C,FC,92,13,5D,F5,7E,57,1C,F0,BA,73,56,28,B4,10";
        String[] array = StringTool.split(s, ",", true, true);
        int i = 0;
        for (String item :
                array) {
            System.out.print(item);
            System.out.print("\t\t");
            i++;
            if (i == 15) {
                i = 0;
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("array 个数 " + array.length + " 耗时 " + (System.currentTimeMillis() - ts) + "ms");
    }
}
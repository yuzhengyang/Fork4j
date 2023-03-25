package com.yuzhyn.azylee.core.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamGroupTest {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "张无忌", "non", "倚天屠龙记", 20));
        userList.add(new User(2, "张三丰", "non", "倚天屠龙记", 100));
        userList.add(new User(3, "虚竹", "non", "天龙八部", 30));
        userList.add(new User(4, "段誉", "non", "天龙八部", 26));
        userList.add(new User(5, "杨过", "non", "神雕侠侣", 30));
        userList.add(new User(6, "小龙女", "non", "神雕侠侣", 40));
        userList.add(new User(7, "小鱼儿", "non", "小鱼儿与花无缺", 25));
        userList.add(new User(8, "花无缺", "non", "小鱼儿与花无缺", 24));


        // 根据group分组，获取每组年龄最大的User信息
        Map<String, User> map = userList.stream().collect(
                Collectors.toMap(User::getGroup, Function.identity(), (t1, t2) -> t1.getAge() > t2.getAge() ? t1 : t2)
        );

        List<User> list = new ArrayList<>(userList.stream().collect(
                Collectors.toMap(User::getGroup, Function.identity(), (t1, t2) -> t1.getAge() > t2.getAge() ? t1 : t2)
        ).values());

        for (User item : map.values()) {
            System.out.println(item);
        }
    }
}

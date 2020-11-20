package pers.yuzhyn.azylee.core.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(10, "tom", "A"));
        users.add(new User(12, "jerry", "C"));
        users.add(new User(15, "john", "D"));
        users.add(new User(25, "jobs", "A"));
        users.add(new User(26, "rose", "B"));
        users.add(new User(28, "jack", "C"));

        {
            // 1.输出符合表达式的每一个对象
            users.stream().filter(p -> p.getId() > 21).forEach(System.out::println);

            // 2.返回一个符合表达式的集合
            List<User> userList1 = users.stream().filter(p -> p.getId() > 21).collect(Collectors.toList());

            // 3.返回符合表达式的集合的第一个对象
            Optional<User> user1 = users.stream().filter(p -> p.getId() > 21).findFirst();

            // 4.抽取对象中所有的id的集合
            List<Integer> userList2 = users.stream().map(User::getId).collect(Collectors.toList());

            List<String> userList3 = users.stream().map(User::getCode).distinct().sorted().collect(Collectors.toList());

            int a = 0;
        }

        {
            System.out.println("=====================================");
            System.out.println("性能测试 1：");
            Date now = new Date();

            for (int i = 0; i < 1000000; i++) {
                List<User> userList1 = users.stream().parallel().filter(p -> p.getId() > 21).collect(Collectors.toList());
            }

            System.out.println("time：" + ((new Date()).getTime() - now.getTime()));
            System.out.println("=====================================");
        }

        {
            System.out.println("=====================================");
            System.out.println("性能测试 2：");
            Date now2 = new Date();

            for (int i = 0; i < 1000000; i++) {
                List<User> userList1 = new ArrayList<>();
                for (User item : users) {
                    if (item.getId() > 21) userList1.add(item);
                }
            }

            System.out.println("time：" + ((new Date()).getTime() - now2.getTime()));
            System.out.println("=====================================");
        }
    }
}

package pers.yuzhyn.azylee.core.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
            List<User> userList1 = users.stream().filter(p -> p.getId() > 21).collect(toList());

            // 3.返回符合表达式的集合的第一个对象
            Optional<User> user1 = users.stream().filter(p -> p.getId() > 21).findFirst();

            // 4.抽取对象中所有的id的集合
            List<Integer> userList2 = users.stream().map(User::getId).collect(toList());

            List<String> userList3 = users.stream().map(User::getCode).distinct().sorted().collect(toList());

            int a = 0;
        }

        {
            List<String> list1 = new ArrayList();
            list1.add("1111");
            list1.add("2222");
            list1.add("3333");

            List<String> list2 = new ArrayList();
            list2.add("3333");
            list2.add("4444");
            list2.add("5555");

            // 交集
            List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(toList());
            System.out.println("---得到交集 intersection---");
            intersection.parallelStream().forEach(System.out :: println);

            // 差集 (list1 - list2)
            List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
            System.out.println("---得到差集 reduce1 (list1 - list2)---");
            reduce1.parallelStream().forEach(System.out :: println);

            // 差集 (list2 - list1)
            List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(toList());
            System.out.println("---得到差集 reduce2 (list2 - list1)---");
            reduce2.parallelStream().forEach(System.out :: println);

            // 并集
            List<String> listAll = list1.parallelStream().collect(toList());
            List<String> listAll2 = list2.parallelStream().collect(toList());
            listAll.addAll(listAll2);
            System.out.println("---得到并集 listAll---");
            listAll.parallelStream().forEach(System.out :: println);

            // 去重并集
            List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
            System.out.println("---得到去重并集 listAllDistinct---");
            listAllDistinct.parallelStream().forEach(System.out :: println);

            System.out.println("---原来的List1---");
            list1.parallelStream().forEach(System.out :: println);
            System.out.println("---原来的List2---");
            list2.parallelStream().forEach(System.out :: println);

            // 一般有filter 操作时，不用并行流parallelStream ,如果用的话可能会导致线程安全问题
        }

        {
            System.out.println("=====================================");
            System.out.println("性能测试 1：");
            Date now = new Date();

            for (int i = 0; i < 1000000; i++) {
                List<User> userList1 = users.stream().parallel().filter(p -> p.getId() > 21).collect(toList());
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

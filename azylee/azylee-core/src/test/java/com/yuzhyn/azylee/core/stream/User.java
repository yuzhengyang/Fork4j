package com.yuzhyn.azylee.core.stream;

public class User {
    private Integer id;
    private String name;
    private String code;
    private String group;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Integer id, String name, String code) {
        setId(id);
        setName(name);
        setCode(code);
    }

    public User(Integer id, String name, String code, String group) {
        this(id, name, code);
        setGroup(group);
    }

    public User(Integer id, String name, String code, String group, Integer age) {
        this(id, name, code, group);
        setAge(age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", group='" + group + '\'' +
                ", age=" + age +
                "}";
    }
}
package pers.yuzhyn.azylee.study.designpattern.structural.filter;

import java.util.List;

public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
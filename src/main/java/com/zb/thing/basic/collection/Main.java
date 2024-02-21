package com.zb.thing.basic.collection;

import com.zb.thing.basic.pojo.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Float a= 7.5f;
        Float b = (float)7500/1000;
        if(a == b){
            System.out.println(" true");
        }
        if(a.equals(b)){
            System.out.println(" equals true");
        }



//        IntStream.range(0,2).toArray();
//
//        EntityTest entityTest = new EntityTest();
//        entityTest.setAge(10);
//        EntityTest entityTest1 = new EntityTest();
//        entityTest.setAge(11);
//        EntityTest entityTest2 = new EntityTest();
//        entityTest.setAge(13);
//        List<EntityTest> entityTests = new ArrayList<>();/* 假设这里有一些 Student 对象的列表 */;
//        entityTests.add(entityTest);
//        entityTests.add(entityTest1);
//        entityTests.add(entityTest2);
//
//
//
//        Map<Integer, List<EntityTest>> maxAgesByGroups = IntStream.range(0, (entityTests.size() + 9) / 10) // 将列表分成大小为 10 的块
//                .mapToObj(i -> entityTests.subList(i * 10, Math.min(entityTests.size(), (i + 1) * 10))) // 获取每个块的子列表
//                .map(sublist -> sublist.stream().max(Comparator.comparing(EntityTest::getAge)).orElse(null)) // 找到每组的最大年龄的学生对象
//                .filter(student -> student != null)
//                .collect(Collectors.groupingBy(student -> (student.getAge() - 1) / 10)); // 根据年龄分组，每 10 为一组
//
//        System.out.println(maxAgesByGroups);
    }

}

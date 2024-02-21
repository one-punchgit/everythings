package com.zb.thing.basic.concurrent;

import com.zb.thing.basic.pojo.LevelPojo;
import com.zb.thing.basic.pojo.TreePojo;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {
        LevelPojo build1 = LevelPojo.builder().id(1).name("1").levelCode("001").build();
        LevelPojo build2 = LevelPojo.builder().id(2).name("2").levelCode("001001").build();
        LevelPojo build3 = LevelPojo.builder().id(3).name("3").levelCode("001001001").build();
        LevelPojo build4 = LevelPojo.builder().id(4).name("4").levelCode("001002").build();
        LevelPojo build5 = LevelPojo.builder().id(5).name("5").levelCode("002").build();
        LevelPojo build6 = LevelPojo.builder().id(6).name("6").levelCode("002001").build();

        List<LevelPojo> levelPojos = Arrays.asList(build1, build2, build3,build4,build5,build6);
        List<LevelPojo> collect = levelPojos.stream().filter(x -> x.getLevelCode().length() == 3).collect(Collectors.toList());
        List<TreePojo> treePojos = new ArrayList<>();
        for (LevelPojo levelPojo : collect) {
            TreePojo tree = getTree(null, levelPojo, levelPojos);
            treePojos.add(tree);
        }
        System.out.println("over");

    }

    private static TreePojo getTree(TreePojo treePojo, LevelPojo levelPojo,List<LevelPojo> source){

        if(treePojo == null){
            treePojo = new TreePojo();
        }
        treePojo.setLevelPojo(levelPojo);
        String levelCode = levelPojo.getLevelCode();
        List<LevelPojo> collect = source.stream().filter(x -> x.getLevelCode().startsWith(levelCode) && x.getLevelCode().length() == levelCode.length() + 3 ).collect(Collectors.toList());
        if(collect.size() == 0){
            return treePojo;
        }
        List<TreePojo> childs = new ArrayList<>();
        // 001001 001002
        for (LevelPojo pojo : collect) {
            childs.add(getTree(null,pojo,source));
        }
        treePojo.setChilds(childs);
        return treePojo;
    }
}

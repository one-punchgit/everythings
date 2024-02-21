package com.zb.thing.basic.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreePojo {
    private LevelPojo levelPojo;
    private List<TreePojo> childs;
}

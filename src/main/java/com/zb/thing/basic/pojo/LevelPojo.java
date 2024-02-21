package com.zb.thing.basic.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelPojo {
    private Integer id;
    private String name;
    private String levelCode;
}

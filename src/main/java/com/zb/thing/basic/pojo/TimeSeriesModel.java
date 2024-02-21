package com.zb.thing.basic.pojo;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeSeriesModel {

    private String sensorID;

    private String sensorType;

    private long ts;

    private float rms_value;

    private float dynamic_rms_value;

    private float max_value;

    private float dynamic_max_value;

    private float min_value;

    private float dynamic_min_value;

    private float mm_value;

    private float dynamic_mm_value;

    private float std_value;

    private float dynamic_std_value;

    private float kurtosis_value;

    private float dynamic_kurtosis_value;

    private float frequency_centroid_value;

    private float frequency_std_value;
}
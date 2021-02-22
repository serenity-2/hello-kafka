package com.jrjz.kafkademo.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demo02Message {
    public static final String TOPIC = "DEMO_012";

    /**
     * 编号
     */
    private Integer id;


}

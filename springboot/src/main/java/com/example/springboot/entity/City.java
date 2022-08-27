package com.example.springboot.entity;

import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.Data;

/**
 * @author chenyile
 * @date 2022/8/27  23:12
 * @description:
 */

@Data
public class City {
    private String ID;
    private String Name;
    private String CountryCode;
    private String District;
    private String Population;
}

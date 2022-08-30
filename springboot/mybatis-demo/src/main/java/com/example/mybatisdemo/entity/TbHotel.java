package com.example.mybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenyile
 * @since 2022-08-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbHotel对象", description="")
public class TbHotel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "酒店id")
      @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Long id;

    @ApiModelProperty(value = "酒店名称")
    private String name;

    @ApiModelProperty(value = "酒店地址")
    private String address;

    @ApiModelProperty(value = "酒店价格")
    private Integer price;

    @ApiModelProperty(value = "酒店评分")
    private Integer score;

    @ApiModelProperty(value = "酒店品牌")
    private String brand;

    @ApiModelProperty(value = "所在城市")
    private String city;

    @ApiModelProperty(value = "酒店星级，1星到5星，1钻到5钻")
    private String starName;

    @ApiModelProperty(value = "商圈")
    private String business;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "酒店图片")
    private String pic;


}

package com.allwayz.freeseed.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Allwayz
 * @since 2020-02-05
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class UserDtl{

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_dtl_id", type = IdType.AUTO)
    private Integer userDtlId;

    private String firstName;

    private String lastName;

    private String birthday;

    private String telephone;

    private String address;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;

    private Integer userId;

    private Integer cityDtlId;


}

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
public class ProvinceDtl{

    private static final long serialVersionUID = 1L;

    @TableId(value = "province_dtl_id", type = IdType.AUTO)
    private Integer provinceDtlId;

    private String provinceDtlName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;

    private Integer nationalDtlId;


}

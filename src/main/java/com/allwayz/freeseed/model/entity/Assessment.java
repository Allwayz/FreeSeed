package com.allwayz.freeseed.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Allwayz
 * @since 2020-03-03
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class Assessment {

    private static final long serialVersionUID = 1L;

    @TableId(value = "assessment_id", type = IdType.AUTO)
    private Integer assessmentId;

    private String assessmentName;

    private Integer precentage;

    private Integer majorId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


}

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
 * @since 2020-03-04
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class Transcript{

    private static final long serialVersionUID = 1L;

    @TableId(value = "transcript_id", type = IdType.AUTO)
    private Integer transcriptId;

    private Integer assessmentId;

    private Integer enrollmentId;

    private String mark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


}

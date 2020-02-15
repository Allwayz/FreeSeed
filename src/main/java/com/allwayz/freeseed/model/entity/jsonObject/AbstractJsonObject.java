package com.allwayz.freeseed.model.entity.jsonObject;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AbstractJsonObject {
    private String code;
    private String message;
    private LocalDateTime time;

    public void setContent(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setStatusObject(StatusObject statusObject) {
        this.code = statusObject.getCode();
        this.message = statusObject.getMessage();
    }
}

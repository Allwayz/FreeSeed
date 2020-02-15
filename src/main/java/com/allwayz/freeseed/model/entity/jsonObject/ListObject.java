package com.allwayz.freeseed.model.entity.jsonObject;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListObject extends AbstractJsonObject{
    private List<?> items;
}

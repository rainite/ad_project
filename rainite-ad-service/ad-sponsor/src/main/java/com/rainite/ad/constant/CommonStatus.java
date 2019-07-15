package com.rainite.ad.constant;

import lombok.Getter;

@Getter
public enum CommonStatus {
    VALID(1, "Valid status"),
    INVALID(0, "Invalid status");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc){
        this.status = status;
        this.desc = desc;
    }
}

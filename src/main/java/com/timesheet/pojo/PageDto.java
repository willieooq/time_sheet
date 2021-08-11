package com.timesheet.pojo;

import com.github.pagehelper.Page;
import lombok.Data;

@Data
public class PageDto {
    public static final String Success = "success";
    public static final String Fail = "fail";

    private String resultCode;
    private String resultMessage;
    private Object resultObj;
    private Object param;
    private Page page;
}

package com.xrf.http.bc.form;

import lombok.Data;

@Data
public class FileForm {

    private String md5;

    private String uuid;

    private String date;

    private String name;

    private String size;

    private String total;

    private String index;

    private String action;

    private String partMd5;
}

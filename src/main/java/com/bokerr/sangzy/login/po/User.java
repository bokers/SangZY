package com.bokerr.sangzy.login.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
/*
-- auto-generated definition
create table user_info
(
  id        varchar(64)  not null primary key,
  account   varchar(32)  not null,
  phone     varchar(11)  null,
  sex       char         null,
  nickName  varchar(12)  null,
  mail      varchar(32)  null,
  introduce varchar(100) null,
  headImg   varchar(100) null,
  name      varchar(12)  not null
);
 */
public class User {
    private String userName;
    private String passWord;
    private String id;
    private String account;
    private String nickName;
    private String mail;
    private String headImg;
    private String introduce;
    private String sex;
    private String phone;
}


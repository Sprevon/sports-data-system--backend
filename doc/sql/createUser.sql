use sports_data_system;
create table t_user(
    username varchar(20) not null comment '用户名',
    password varchar(20) not null comment '密码',
    constraint cons_pk primary key (username)
) comment = '用户名密码表';

create table t_authority(
    username varchar(20) not null comment '用户名',
    authority varchar(20) not null comment '权限',
    constraint cons_pk primary key (username, authority)
) comment = '用户权限表';
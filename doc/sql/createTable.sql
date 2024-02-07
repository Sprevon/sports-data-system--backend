#创建数据模型
create schema sports_data_system;
use sports_data_system;
#创建设备信息表
drop table t_device;
create table t_device
(
    device_id          varchar(20)                not null comment '设备编号',
    device_field       varchar(20)               not null comment '设备领域',
    device_kind        varchar(20)               not null comment '设备类型',
    device_state       ENUM ('0', '1', '2', '3') not null default '0' comment '设备使用状态（0表示未使用，1表示正在使用，2表示维修状态，3表示报废状态）',
    create_person      bigint(20)                not null comment '创建人编号',
    create_date        datetime                  not null comment '创建时间',
    last_modify_person bigint(20)                not null comment '最后修改人编号',
    last_modify_date   datetime                  not null comment '最后修改时间',
    constraint cons_pk primary key (device_id)
) comment = '设备信息表';

#创建资源数据表
drop table t_coach;
create table t_coach
(
    c_id               varchar(20)  not null comment '教练编号',
    c_name             varchar(20) not null comment '教练名称',
    c_nation           varchar(20) not null comment '教练国籍',
    create_person      bigint(20)  not null comment '创建人编号',
    create_date        datetime    not null comment '创建时间',
    last_modify_person bigint(20)  not null comment '最后修改人编号',
    last_modify_date   datetime    not null comment '最后修改时间',
    constraint cons_pk primary key (c_id)
) comment = '教练员信息';

#创建装备管理员信息表
# drop table t_property_man;
create table t_property_man
(
    prop_id            bigint(20)           not null comment '识别信息',
    prop_name          varchar(20)          not null comment '姓名',
    prop_state         ENUM ('0', '1', '2') not null comment '管理员工作状态（0表示未上班，1表示正常上班，2表示休假）',
    prop_room_id       bigint(20)           not null comment '装备管理员负责的装备室号码',
    create_person      bigint(20)           not null comment '创建人编号',
    create_date        datetime             not null comment '创建时间',
    last_modify_person bigint(20)           not null comment '最后修改人编号',
    last_modify_date   datetime             not null comment '最后修改时间',
    constraint cons_pk primary key (prop_id)
) comment = '装备管理员信息表';

#创建运动员基础信息表
drop table t_player;
create table t_player
(
    pl_id              bigint(20)           not null comment '运动员编号',
    pl_name            varchar(20)           not null comment '运动员名称',
    pl_nation          varchar(20)           not null comment '运动员国籍',
    pl_state           ENUM ('0', '1', '2') not null comment '运动员状态（0无异常，1伤缺，2异常）',
    pl_field           varchar(20)           not null comment '运动种类',
    pl_position        varchar(20)           not null comment '场上位置',
    pl_device_id       bigint(20)           not null comment '使用设备序号',
    create_person      bigint(20)           not null comment '创建人编号',
    create_date        datetime             not null comment '创建时间',
    last_modify_person bigint(20)           not null comment '最后修改人编号',
    last_modify_date   datetime             not null comment '最后修改时间',
    constraint cons_pk primary key (pl_id)
) comment = '运动员信息表';

#创建发票表
drop table t_player_health;
create table t_player_health
(
    pl_id              bigint(20)     not null comment '运动员编号',
    pl_height          decimal(20, 2) not null comment '运动员身高',
    pl_weight          decimal(20, 2) not null comment '运动员体重',
    pl_max_heart_rate  bigint(20)     not null comment '运动员最大心率',
    pl_min_heart_rate  bigint(20)     not null comment '运动员最低心率',
    pl_avg_heart_rate  bigint(20)     not null comment '运动员平均心率',
    pl_total_distance  bigint(20)     not null comment '运动员运动距离',
    pl_sprint          bigint(20)     not null comment '运动员冲刺次数',
    create_person      bigint(20)     not null comment '创建人编号',
    create_date        datetime       not null comment '创建时间',
    last_modify_person bigint(20)     not null comment '最后修改人编号',
    last_modify_date   datetime       not null comment '最后修改时间',
    constraint cons_pk primary key (pl_id)
) comment = '运动员健康信息表';

#创建运动员心率表
# drop table player_heart_rate;
create table t_player_heart_rate
(
    pl_id              bigint(20)     not null comment '运动员编号',
    pl_current_heart_rate  bigint(20)     not null comment '运动员平均心率',
    create_person      bigint(20)     not null comment '创建人编号',
    create_date        datetime       not null comment '创建时间',
    constraint cons_pk primary key (pl_id)
) comment = '运动员心率表';

#创建账号表
create table t_account
(
    account            varchar(20) not null comment '账号',
    password           varchar(20) not null comment '密码',
    authority          varchar(20) not null comment '权限',
    create_person      bigint(20)  not null comment '创建人编号',
    create_date        datetime    not null comment '创建时间',
    last_modify_person bigint(20)  not null comment '最后修改人编号',
    last_modify_date   datetime    not null comment '最后修改时间',
    constraint cons_pk primary key (account)
) comment = '账号表';

create table t_team_doc
(
    doc_id             bigint(20)           not null comment '队医编号',
    doc_name           varchar(20)          not null comment '队医名称',
    doc_major          varchar(20)          not null comment '队医专业',
    doc_position       varchar(20)          not null comment '队医职位',
    doc_state          ENUM ('0', '1', '2') not null comment '队医状态（0表示未上班，1表示正常上班，2表示休假）',
    create_person      bigint(20)           not null comment '创建人编号',
    create_date        datetime             not null comment '创建时间',
    last_modify_person bigint(20)           not null comment '最后修改人编号',
    last_modify_date   datetime             not null comment '最后修改时间',
    constraint cons_pk primary key (doc_id)
) comment = '队医表';


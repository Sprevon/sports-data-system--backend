create table t_author
(
    auth_id   int primary key comment '作者编号',
    auth_name varchar(256) not null comment '作者名称'
) comment = '作者信息表';

drop table t_article;
create table t_article
(
    art_id   int primary key comment '文章编号',
    art_cont text comment '文章内容',
    auth_id  int comment '作者编号'
) comment = '文章信息表';

insert into t_author
values (1, 'Mike'),
       (2, 'Jack'),
       (3, 'John');


insert into t_article
values (1, '第一篇文章', 1),
       (2, '第二篇文章', 1),
       (3, '第三篇文章', 1),
       (4, '第四篇文章', 1),
       (5, '第五篇文章', 2),
       (6, '第六篇文章', 2);

insert into t_article
values (5, '第五篇文章', 2),
       (6, '第六篇文章', 2);
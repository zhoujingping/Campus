create database mydatabase;
use mydatabase;

create table student(
snumber varchar(18) primary key,
sname varchar(48),
spassword varchar(18),
saddress varchar(128),
sphone varchar(18),
sqq varchar(18),
sweixing varchar(18),
semail varchar(36),
sself varchar(128)
);

insert into student values("031602548","郑和","123456","福大","13695932688","2472685022","13695932658","244444@qq.com","哈哈哈");
insert into student values("031602549","乐于","123456","福大","13695932689","2472685022","13695832658","244444@qq.com","哈哈哈");
insert into student values("031602550","程顺","123456","福大","13695932888","4472685022","13695932658","244444@qq.com","哈哈哈");
insert into student values("031602551","张生","123456","福大","13695932688","2278685022","1369532658","244444@qq.com","哈哈哈");
insert into student values("031602552","乐乐","123456","福大","13695832688","2472685022","13695932658","244444@qq.com","哈哈哈");
insert into student values("031602553","哈哈","123456","福大","13695232688","2472685022","13695932658","244444@qq.com","哈哈哈");
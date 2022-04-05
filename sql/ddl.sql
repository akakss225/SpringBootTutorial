create table member(
                       id bigint auto_increment primary key,
                       name varchar(255)
);
insert into member(name) values("spring");
insert into member(name) values("spring1");

select * from member;
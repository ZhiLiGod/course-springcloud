create table if not exists `cloud_course`.`user` (
`id` bigint(20) not null auto_increment,
`username` varchar(128) not null default '',
`email` varchar(128) not null default '',
`create_time` datetime not null default '1970-01-01 08:00:00',
`update_time` datetime not null default '1970-01-01 08:00:00',
primary key (`id`),
unique key `key_username` (`username`)
) Engine=InnoDB auto_increment=6 DEfault charset=utf8 row_format=compact;

create table if not exists `cloud_course`.`user_course` (
`id` bigint(20) not null auto_increment,
`user_id` bigint(20) not null default 0,
`course_id` bigint(20) not null default 0,
`create_time` datetime not null default '1970-01-01 08:00:00',
`update_time` datetime not null default '1970-01-01 08:00:00',
primary key (`id`),
unique key `key_user_course` (`user_id`, `course_id`)
) Engine=InnoDB auto_increment=6 DEfault charset=utf8 row_format=compact;

create table if not exists `cloud_course`.`course` (
`id` bigint(20) not null auto_increment,
`course_name` varchar(128) not null default '',
`course_type` varchar(128) not null default '',
`course_icon` varchar(128) not null default '',
`course_intro` varchar(128) not null default '',
`create_time` datetime not null default '1970-01-01 08:00:00',
`update_time` datetime not null default '1970-01-01 08:00:00',
primary key (`id`),
unique key `key_course` (`course_name`)
) Engine=InnoDB auto_increment=6 DEfault charset=utf8 row_format=compact
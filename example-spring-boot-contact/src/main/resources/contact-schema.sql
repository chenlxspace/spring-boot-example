create table contacts (
	id identity,
	first_name varchar(30) not null,
	last_name varchar(50) not null,
	phone_number varchar(13),
	email_address varchar(30)
);
insert into contacts (first_name, last_name, phone_number, email_address) values ('张', '三', '18612345678', 'zhangsan@163.com');
insert into contacts (first_name, last_name, phone_number, email_address) values ('李', '四', '18687654321', 'lisi@163.com');

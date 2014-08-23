insert into users(user_id,user_username,user_password) values (1,'admin','admin');
insert into roles(role_id,role_description) values (1,'administrador');
insert into user_roles(user_id,role_id) values (1,1);
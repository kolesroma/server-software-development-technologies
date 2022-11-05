use software_dev;

alter table record drop foreign key fk_record_user;
alter table record drop foreign key fk_record_category;
alter table user drop foreign key fk_user_accounting;

alter table record add constraint fk_record_user foreign key (user_id) references user (id) on delete cascade;
alter table record add constraint fk_record_category foreign key (category_id) references category (id) on delete cascade;
alter table user add constraint fk_user_accounting foreign key (accounting_id) references accounting (id) on delete cascade;

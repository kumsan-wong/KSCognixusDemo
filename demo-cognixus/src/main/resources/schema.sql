create table to_do (id bigint not null auto_increment, description varchar(255), insert_date timestamp, name varchar(255), perform_date timestamp, status integer, update_date timestamp, primary key (id));

CREATE UNIQUE INDEX to_do_id_idx
ON to_do ( id );
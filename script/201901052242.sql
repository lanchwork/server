alter table sys_menu
  add menu_id int;

comment on column sys_menu.menu_id is '菜单id';


ALTER TABLE sys_user
  ADD CONSTRAINT fk_channel_mark
    FOREIGN KEY (channel_mark)
      REFERENCES sys_partner(channel_mark);


ALTER TABLE sys_dict_item
  ADD CONSTRAINT fk_type_id
    FOREIGN KEY (type_id)
      REFERENCES sys_dict_type(id);

ALTER TABLE sys_role_menu
  ADD CONSTRAINT fk_role_id
    FOREIGN KEY (role_id)
      REFERENCES sys_role(id),
  ADD CONSTRAINT fk_menu_id
    FOREIGN KEY (menu_id)
      REFERENCES sys_menu(id);




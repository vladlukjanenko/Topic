create table Role (
   RoleId               SERIAL               not null,
   UserId               INT4                 null,
   Username             VARCHAR(512)         not null,
   RoleName             VARCHAR(50)          not null,
   constraint PK_ROLE primary key (RoleId)
);

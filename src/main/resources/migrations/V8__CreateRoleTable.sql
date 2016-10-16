create table AccountRole (
   RoleId               SERIAL               not null,
   AccountId            INT4                 null,
   Username             VARCHAR(512)         not null,
   RoleName             VARCHAR(50)          not null,
   constraint PK_ACCOUNTROLE primary key (RoleId)
)
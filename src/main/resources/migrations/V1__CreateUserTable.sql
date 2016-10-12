create table "User" (
   UserId               SERIAL               not null,
   UserName             VARCHAR(512)         not null,
   UserGender           VARCHAR(10)          not null,
   UserEmail            VARCHAR(128)         not null,
   UserPhoto            VARCHAR(128)         null,
   IsAuthor             BOOL                 null,
   constraint PK_USER primary key (UserId)
);

create unique index User_PK on "User" (UserId);

create table Account (
   AccountId            BIGINT               AUTO_INCREMENT                not null,
   UserName             VARCHAR(512)         not null,
   UserGender           VARCHAR(10)          not null,
   UserEmail            VARCHAR(128)         not null,
   UserPhoto            VARCHAR(128)         null,
   IsAuthor             BOOL                 null,
   constraint PK_ACCOUNT primary key (AccountId)
);

create unique index Account_PK on Account (AccountId);

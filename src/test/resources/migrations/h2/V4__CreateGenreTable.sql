create table Genre (
   GenreId              BIGINT               AUTO_INCREMENT                not null,
   GenreName            VARCHAR(256)         not null,
   constraint PK_GENRE primary key (GenreId)
);

create unique index Genre_PK on Genre (GenreId);

create table Author (
   AuthorId             SERIAL               not null,
   AuthorName           VARCHAR(1024)        not null,
   constraint PK_AUTHOR primary key (AuthorId)
);

create unique index Author_PK on Author(AuthorId);

create table Book (
   BookId               BIGINT               AUTO_INCREMENT                not null,
   GenreId              INT4                 null,
   BookName             VARCHAR(1024)        not null,
   BookISBN             NUMERIC(13)          not null,
   BookPagesNumber      NUMERIC(5)           null,
   constraint PK_BOOK primary key (BookId)
);

create unique index Book_PK on Book(BookId);

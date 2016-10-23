create table BookGenre (
   GenreId              INT4                 not null,
   BookId               INT4                 not null,
   constraint PK_BOOKGENRE primary key (GenreId, BookId)
);

/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     16.10.2016 12:44:42                          */
/*==============================================================*/


drop index Account_PK;

drop table Account;

drop table AccountRole;

drop index Author_PK;

drop table Author;

drop table AuthorBook;

drop index Book_PK;

drop table Book;

drop table BookGenre;

drop index Genre_PK;

drop table Genre;

drop index Shelf_PK;

drop table Shelf;

drop index Sketch_PK;

drop table Sketch;

drop table persistent_logins;

/*==============================================================*/
/* Table: Account                                               */
/*==============================================================*/
create table Account (
   AccountId            SERIAL               not null,
   UserName             VARCHAR(512)         not null,
   UserGender           VARCHAR(10)          not null,
   UserEmail            VARCHAR(128)         not null,
   UserPhoto            VARCHAR(128)         null,
   IsAuthor             BOOL                 null,
   constraint PK_ACCOUNT primary key (AccountId)
);

/*==============================================================*/
/* Index: Account_PK                                            */
/*==============================================================*/
create unique index Account_PK on Account (
AccountId
);

/*==============================================================*/
/* Table: AccountRole                                           */
/*==============================================================*/
create table AccountRole (
   RoleId               SERIAL               not null,
   AccountId            INT4                 null,
   Username             VARCHAR(512)         not null,
   RoleName             VARCHAR(50)          not null,
   constraint PK_ACCOUNTROLE primary key (RoleId)
);

/*==============================================================*/
/* Table: Author                                                */
/*==============================================================*/
create table Author (
   AuthorId             SERIAL               not null,
   AuthorName           VARCHAR(1024)        not null,
   constraint PK_AUTHOR primary key (AuthorId)
);

/*==============================================================*/
/* Index: Author_PK                                             */
/*==============================================================*/
create unique index Author_PK on Author (
AuthorId
);

/*==============================================================*/
/* Table: AuthorBook                                            */
/*==============================================================*/
create table AuthorBook (
   AuthorId             INT4                 not null,
   BookId               INT4                 not null,
   constraint PK_AUTHORBOOK primary key (AuthorId, BookId)
);

/*==============================================================*/
/* Table: Book                                                  */
/*==============================================================*/
create table Book (
   BookId               SERIAL               not null,
   BookName             VARCHAR(1024)        not null,
   BookISBN             VARCHAR(25)          not null,
   BookPagesNumber      NUMERIC(5)           null,
   constraint PK_BOOK primary key (BookId)
);

/*==============================================================*/
/* Index: Book_PK                                               */
/*==============================================================*/
create unique index Book_PK on Book (
BookId
);

/*==============================================================*/
/* Table: BookGenre                                             */
/*==============================================================*/
create table BookGenre (
   GenreId              INT4                 not null,
   BookId               INT4                 not null,
   constraint PK_BOOKGENRE primary key (GenreId, BookId)
);

/*==============================================================*/
/* Table: Genre                                                 */
/*==============================================================*/
create table Genre (
   GenreId              SERIAL               not null,
   GenreName            VARCHAR(256)         not null,
   constraint PK_GENRE primary key (GenreId)
);

/*==============================================================*/
/* Index: Genre_PK                                              */
/*==============================================================*/
create unique index Genre_PK on Genre (
GenreId
);

/*==============================================================*/
/* Table: Shelf                                                 */
/*==============================================================*/
create table Shelf (
   ShelfId              SERIAL               not null,
   BookId               INT4                 null,
   AccountId            INT4                 null,
   ShelfName            VARCHAR(512)         not null,
   constraint PK_SHELF primary key (ShelfId)
);

/*==============================================================*/
/* Index: Shelf_PK                                              */
/*==============================================================*/
create unique index Shelf_PK on Shelf (
ShelfId
);

/*==============================================================*/
/* Table: Sketch                                                */
/*==============================================================*/
create table Sketch (
   SketchId             SERIAL               not null,
   GenreId              INT4                 null,
   AccountId            INT4                 null,
   constraint PK_SKETCH primary key (SketchId)
);

/*==============================================================*/
/* Index: Sketch_PK                                             */
/*==============================================================*/
create unique index Sketch_PK on Sketch (
SketchId
);

/*==============================================================*/
/* Table: persistent_logins                                     */
/*==============================================================*/
create table persistent_logins (
   username             VARCHAR(512)         not null,
   series               VARCHAR(64)          not null,
   token                VARCHAR(64)          not null,
   last_used            TIMESTAMP            not null,
   constraint PK_PERSISTENT_LOGINS primary key (series)
);

alter table AccountRole
   add constraint FK_ACCOUNTR_REFERENCE_ACCOUNT foreign key (AccountId)
      references Account (AccountId)
      on delete restrict on update restrict;

alter table AuthorBook
   add constraint FK_AUTHORBO_REFERENCE_AUTHOR foreign key (AuthorId)
      references Author (AuthorId)
      on delete restrict on update restrict;

alter table AuthorBook
   add constraint FK_AUTHORBO_REFERENCE_BOOK foreign key (BookId)
      references Book (BookId)
      on delete restrict on update restrict;

alter table BookGenre
   add constraint FK_BOOKGENR_REFERENCE_GENRE foreign key (GenreId)
      references Genre (GenreId)
      on delete restrict on update restrict;

alter table BookGenre
   add constraint FK_BOOKGENR_REFERENCE_BOOK foreign key (BookId)
      references Book (BookId)
      on delete restrict on update restrict;

alter table Shelf
   add constraint FK_SHELF_REFERENCE_ACCOUNT foreign key (AccountId)
      references Account (AccountId)
      on delete restrict on update restrict;

alter table Shelf
   add constraint FK_SHELF_REFERENCE_BOOK foreign key (BookId)
      references Book (BookId)
      on delete restrict on update restrict;

alter table Sketch
   add constraint FK_SKETCH_REFERENCE_ACCOUNT foreign key (AccountId)
      references Account (AccountId)
      on delete restrict on update restrict;

alter table Sketch
   add constraint FK_SKETCH_REFERENCE_GENRE foreign key (GenreId)
      references Genre (GenreId)
      on delete restrict on update restrict;


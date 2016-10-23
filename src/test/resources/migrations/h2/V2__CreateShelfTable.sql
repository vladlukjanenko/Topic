create table Shelf (
   ShelfId              BIGINT               AUTO_INCREMENT                not null,
   AccountId            INT4                 null,
   BookId               INT4                 null,
   ShelfName            VARCHAR(512)         not null,
   constraint PK_SHELF primary key (ShelfId)
);

create unique index Shelf_PK on Shelf(ShelfId);

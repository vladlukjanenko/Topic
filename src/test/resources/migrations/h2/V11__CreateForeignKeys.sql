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
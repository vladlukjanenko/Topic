create table Sketch (
   SketchId             BIGINT               AUTO_INCREMENT                not null,
   AccountId            INT4                 null,
   GenreId              INT4                 null,
   constraint PK_SKETCH primary key (SketchId)
);

create unique index Sketch_PK on Sketch(SketchId);

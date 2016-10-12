create table Sketch (
   SketchId             SERIAL               not null,
   UserId               INT4                 null,
   GenreId              INT4                 null,
   constraint PK_SKETCH primary key (SketchId)
);

create unique index Sketch_PK on Sketch(SketchId);

create table persistent_logins (
   username             VARCHAR(512)         not null,
   series               VARCHAR(64)          not null,
   token                VARCHAR(64)          not null,
   last_used            TIMESTAMP            not null,
   constraint PK_PERSISTENT_LOGINS primary key (series)
);

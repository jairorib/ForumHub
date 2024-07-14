create table topicos (
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(100) not null unique,
    dataCriacao timestamp not null DEFAULT CURRENT_TIMESTAMP,
    status varchar(100) DEFAULT 'ABERTA',
    autor varchar(100) not null,
    curso varchar(100) not null,

    primary key(id)
) ENGINE=InnoDB;
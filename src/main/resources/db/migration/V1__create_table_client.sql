CREATE TABLE client

(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(100) DEFAULT NULL,
    cpf varchar(100) DEFAULT NULL,
    email varchar(200) DEFAULT NULL,
    phone varchar(100) DEFAULT NULL,
    address varchar(100) DEFAULT NULL,
    district varchar(100) DEFAULT NULL,
    city varchar(100) DEFAULT NULL,
    state varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);
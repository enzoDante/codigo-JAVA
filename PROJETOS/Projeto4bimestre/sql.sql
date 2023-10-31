#create database projeto4_java;
use projeto4_java;
/*CREATE TABLE usuario (
    id INT PRIMARY KEY auto_increment,
    nome VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255),
    telefone VARCHAR(20)
);

CREATE TABLE imc_usuario (
    id INT PRIMARY KEY auto_increment,
    usuario_id INT,
    imcValue DECIMAL(5, 2),
    imcText varchar(255),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);*/
#insert into usuario (nome, email, senha, telefone) values("Teste3", "t3@g.com","123","12991231245");
#insert into imc_usuario (usuario_id, imcValue, imcText) values(1, 20.0, "normal");
select * from usuario left join imc_usuario on usuario.id=usuario_id;
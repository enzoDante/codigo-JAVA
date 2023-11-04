#create database projeto4_java;
use projeto4_java;
/*CREATE TABLE log (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data_hora DATETIME,
    operacao varchar(255)
);
CREATE TABLE Paciente (
    id INT PRIMARY KEY auto_increment,
    nome VARCHAR(255),
    email VARCHAR(255),
    altura decimal(5,2),
    peso decimal(5,2),
    imc decimal(5,2),
    imcDesc varchar(255)
);

CREATE TABLE imc_usuario (
    id INT PRIMARY KEY auto_increment,
    usuario_id INT,
    imcValue DECIMAL(5, 2),
    imcText varchar(255),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);*/
#insert into Paciente (nome, email, altura, peso, imc, imcDesc) values("Teste1", "t1@g.com",2,71.23, 17.5, "Magreza");
#DELETE FROM Paciente;
select * from Log;
SELECT * FROM Paciente order by nome;
#SELECT COUNT(*) FROM Paciente WHERE imc < 18.5;
#SELECT COUNT(*) FROM Paciente WHERE imc >= 18.5 AND imc< 25;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS homes;
DROP TABLE IF EXISTS category cascade constraints;
DROP TABLE IF EXISTS product cascade constraints;
DROP TABLE IF EXISTS seller cascade constraints;

CREATE TABLE cliente AS SELECT * FROM CSVREAD('classpath:baseClientesHackaton8Oct.csv');
CREATE TABLE usuario AS SELECT * FROM CSVREAD('classpath:baseUsuarios.csv');


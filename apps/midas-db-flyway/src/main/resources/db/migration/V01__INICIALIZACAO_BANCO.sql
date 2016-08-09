CREATE TABLE usuario(
    codigo INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    login VARCHAR(45) NOT NULL,
    senha VARCHAR(150) NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE banco (
    codigo INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    usuario_codigo INTEGER NOT NULL,
    nome VARCHAR(100) NOT NULL,
    numero INTEGER,
    PRIMARY KEY (codigo),
    CONSTRAINT fk_BANCO_USUARIO1
        FOREIGN KEY (usuario_codigo)
        REFERENCES usuario (codigo)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE conta (
    codigo INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    banco_codigo INTEGER NOT NULL,
    usuario_codigo INTEGER NOT NULL,
    saldo DOUBLE NOT NULL,
    PRIMARY KEY (codigo),
    CONSTRAINT fk_CONTA_BANCO
        FOREIGN KEY (banco_codigo)
        REFERENCES banco (codigo)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT fk_CONTA_USUARIO1
        FOREIGN KEY (usuario_codigo)
        REFERENCES usuario (codigo)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE cartao (
  codigo INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  nome VARCHAR(50) NOT NULL,
  dia_fechamento INTEGER NOT NULL,
  usuario_codigo INTEGER NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_CARTAO_USUARIO1
    FOREIGN KEY (usuario_codigo)
    REFERENCES usuario (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE tipo_recorrente (
  codigo INTEGER NOT NULL,
  nome VARCHAR(50) NOT NULL COMMENT 'SEMANA, QUINZENAL, MENSAL, TRIMESTRAL, SEMESTRAL, ANUAL',
  PRIMARY KEY (codigo)
);

INSERT INTO tipo_recorrente (codigo, nome) VALUES (1, 'SEMANA');
INSERT INTO tipo_recorrente (codigo, nome) VALUES (2, 'QUIZENAL');
INSERT INTO tipo_recorrente (codigo, nome) VALUES (3, 'MENSAL');
INSERT INTO tipo_recorrente (codigo, nome) VALUES (4, 'TRIMESTRAL');
INSERT INTO tipo_recorrente (codigo, nome) VALUES (5, 'SEMESTRAL');

CREATE TABLE tipo_movimentacao (
  codigo INTEGER NOT NULL,
  nome VARCHAR(50) NOT NULL,
  PRIMARY KEY (codigo)
);

CREATE TABLE tag_movimentacao (
  codigo INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  nome VARCHAR(150) NOT NULL,
  PRIMARY KEY (CODIGO))
;

CREATE TABLE fatura_cartao (
  codigo INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  valor DOUBLE NOT NULL,
  mes_ano_referencia INTEGER NOT NULL,
  cartao_codigo INTEGER NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_FATURA_CARTAO_CARTAO1
    FOREIGN KEY (cartao_codigo)
    REFERENCES cartao (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE movimentacao (
  codigo INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  tipo_movimentacao_codigo INTEGER NOT NULL,
  tipo_recorrente_codigo INTEGER NOT NULL,
  cartao_codigo INTEGER NOT NULL,
  conta_codigo INTEGER NOT NULL,
  DATA TIMESTAMP NOT NULL,
  descricao VARCHAR(250) NOT NULL,
  tag_movimentacao_codigo INTEGER NOT NULL,
  fatura_cartao_codigo INTEGER NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT fk_MOVIMENTACAO_TIPO_RECORRENTE1
    FOREIGN KEY (tipo_recorrente_codigo)
    REFERENCES tipo_recorrente (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_MOVIMENTACAO_TIPO_MOVIMENTACAO1
    FOREIGN KEY (tipo_movimentacao_codigo)
    REFERENCES tipo_movimentacao (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_MOVIMENTACAO_CARTAO1
    FOREIGN KEY (cartao_codigo)
    REFERENCES cartao (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_MOVIMENTACAO_CONTA1
    FOREIGN KEY (conta_codigo)
    REFERENCES conta (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_MOVIMENTACAO_TAG_MOVIMENTACAO1
    FOREIGN KEY (tag_movimentacao_codigo)
    REFERENCES tag_movimentacao (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_MOVIMENTACAO_FATURA_CARTAO1
    FOREIGN KEY (fatura_cartao_codigo)
    REFERENCES fatura_cartao (CODIGO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

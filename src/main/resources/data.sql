DROP TABLE IF EXISTS t_accounts;
DROP TABLE IF EXISTS t_clients;
DROP TABLE IF EXISTS t_cards;

CREATE TABLE t_clients (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstName VARCHAR(255),
  lastName VARCHAR(255),
  age INT
);

CREATE TABLE t_accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  accountNum VARCHAR(25),
  balance int DEFAULT 0,
  isoCode VARCHAR(3),

  client_id  INT NOT NULL,
    foreign key (client_id) references t_clients(id)
);

CREATE TABLE t_cards (
  id INT AUTO_INCREMENT  PRIMARY KEY,

  pinCode INT,
  cardNum VARCHAR(16),
  dateEnd DATE,
  cvcCvv2Code INT,

  account_id  INT NOT NULL,
    foreign key (account_id) references t_accounts(id)
);

INSERT INTO t_clients (firstName, lastName, age) VALUES
  ('IVAN', 'IVANOV', 30),
  ('PETR', 'PETROV', 65);

INSERT INTO t_accounts (accountNum, balance, isoCode, client_id) VALUES
  ('12345678901234567890', 580, 'RUR', 1),
  ('98765432198765432111', 787, 'RUR', 1),
  ('12312312312312312312', 967, 'USD', 2);

INSERT INTO t_cards (pinCode, cardNum, dateEnd, cvcCvv2Code, account_id) VALUES
  (1234, '1234567812345678', '2021-09-27', 123, 1),
  (4321, '8765432187654321', '2022-02-11', 321, 2),
  (7676, '4444555566667777', '2023-03-05', 701, 3);

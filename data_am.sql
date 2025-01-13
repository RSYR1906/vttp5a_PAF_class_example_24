USE money;

CREATE table BankAccount(
    id int NOT NULL auto_increment,
    fullname varchar(128) NOT NULL,
    isActive boolean,
    balance float default "100.0",
    
    CONSTRAINT pk_bankaccount_id PRIMARY KEY (id)
);

INSERT INTO BankAccount(fullname,isActive,balance)

VALUES ("Test Account",true,300.0);

UPDATE BankAccount SET
    isActive = false
    WHERE id = 1;

UPDATE BankAccount SET
    balance = 1000000.0 
    WHERE id = 1;
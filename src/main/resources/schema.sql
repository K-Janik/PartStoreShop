CREATE TABLE Part(
    Nr UUID NOT NULL PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Price NUMERIC(8,2)
    );

CREATE TABLE Worker(
    Id UUID NOT NULL PRIMARY KEY,
    Name VARCHAR(100) NOT NULL
    );

CREATE TABLE PartOrder(
    Order_Id UUID NOT NULL PRIMARY KEY,
    Part_Id VARCHAR(100),
    Part_price NUMERIC(8,2),
    Part_name VARCHAR(100) NOT NULL,
    Order_quantity NUMERIC(2,0) NOT NULL,
    Worker_Id UUID,
    Worker_name VARCHAR(100) NOT NULL
    );

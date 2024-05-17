CREATE TABLE IF NOT EXISTS client{
    id SERIAL,
    nui Varchar (100) NOT NULL,
    fullname VARCHAR(100) NOT NULL,
    address Varchar (100),
    email Varchar (100) NOT NUL,L
    PRIMARY KEY (id),
    UNIQUE (nui)
};
CREATE TABLE IF NOT EXISTS product{
    id SERIAL,
    description Varchar (200) NOT NULL,
    brant VARCHAR(100),
    price DECIMAL (9,2) DEFAULT 0.00,
    stock INT,
    PRIMARY KEY (id),
};
CREATE TABLE IF NOT EXISTS invoice{
    id SERIAL,
    code VARCHAR (17) NOT NULL,
    create_at DATE,
    total DECIMAL (7,2),
    client_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES client (id),
    UNIQUE (code)
};
CREATE TABLE IF NOT EXISTS detail{
    id SERIAL,
    quantity INT NOT NULL,
    price DECIMAL (7,2),
    subtotal DECIMAL (7,2) GENERATE ALWAYS AS (price*quantity) STORED,
    invoice_id INT,
    product_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (invoice_id) REFERENCES invoice (id),
    FOREIGN KEY (product_id) REFERENCES product (id),
    UNIQUE (invoice_id, product_id )
};
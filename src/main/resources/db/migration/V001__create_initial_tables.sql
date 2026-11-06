-- Sequences
CREATE SEQUENCE if not exists item_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE if not exists bom_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE if not exists bomline_seq START WITH 1 INCREMENT BY 1;

-- Item
CREATE TABLE if not exists item (
                      item_id BIGINT PRIMARY KEY,
                      item_name VARCHAR(255),
                      item_description VARCHAR(255)
);

-- BOM
CREATE TABLE if not exists bom (
                     bom_id BIGINT PRIMARY KEY,
                     item_id BIGINT NOT NULL UNIQUE
);

-- BOM Line
CREATE TABLE if not exists bom_line (
                          bomline_id BIGINT PRIMARY KEY,
                          bom_id BIGINT,
                          item_id BIGINT,
                          quantity integer
);
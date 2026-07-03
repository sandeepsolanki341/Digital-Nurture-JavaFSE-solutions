-- Doc 2, Hands-on 2: stock table. Load stock-data.sql (generated from stock-data.csv) into this.
USE ormlearn;

CREATE TABLE IF NOT EXISTS stock (
    st_id INT NOT NULL AUTO_INCREMENT,
    st_code VARCHAR(10),
    st_date DATE,
    st_open NUMERIC(10,2),
    st_close NUMERIC(10,2),
    st_volume NUMERIC,
    PRIMARY KEY (st_id)
);

-- Sample rows (real data comes from finance.yahoo.com export in the doc).
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-03', 184.00, 182.39, 9779400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-23', 1256.64, 1270.59, 1593400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-24', 242.00, 233.88, 9547600);

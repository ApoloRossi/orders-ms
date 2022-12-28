CREATE TABLE trips (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 trip_value decimal(10,2) NOT NULL,
 trip_description varchar(100) DEFAULT NULL,
PRIMARY KEY (id)
);

CREATE TABLE orders (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 order_value decimal(10,2) NOT NULL,
 user_id bigint(20) NOT NULL,
 trip_id bigint(20) NOT NULL,
 FOREIGN KEY (trip_id) references trips(id),
PRIMARY KEY (id)
);

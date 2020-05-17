CREATE TABLE map_info (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255),
    resolution_x int,
    resolution_y int
);

create table map_tile_data (
 id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
 map_id int not null,
 name varchar(255),
 zoom_level int not null,
 x int not null,
 y int not null,
 data mediumblob not null,

 FOREIGN KEY (map_id) REFERENCES map_info(id)
);

create UNIQUE INDEX ix_map_tile_data on map_tile_data (zoom_level, name, x, y);

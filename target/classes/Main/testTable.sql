SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS MENUS;




/* Create Tables */

CREATE TABLE MENUS
(
	menu_name varchar(20) NOT NULL,
	price int NOT NULL,
	PRIMARY KEY (menu_name)
);




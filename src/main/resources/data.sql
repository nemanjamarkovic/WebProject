INSERT INTO CINEMA(name,address,phone_number,email) VALUES ('Cinestar','NS','061333555','cinestar@gmail.com');
INSERT INTO CINEMA(name,address,phone_number,email) VALUES ('Cineplexx','BG','061555333','cineplexx@gmail.com');
INSERT INTO USER(dtype,username,password,name,lastname,phone_number,email,active,role,date) VALUES ('User', 'ari','123','Nemanja','Markovic','06666666','ari13@gmail.com',true,2,'2019-01-02');
INSERT INTO USER(dtype,username,password,name,lastname,phone_number,email,active,role,date) VALUES ('Viewer', 'djoka','1231231','Djordje','Tovilovic','061712383','sadas@gmail.com',false,1,'2010-03-01');
INSERT INTO USER(dtype,username,password,name,lastname,phone_number,email,active,role,date) VALUES ('Viewer', 'lavic','adada1','Lav','Maksimovic','06123123123','lav@gmail.com',true,1,'2019-03-01');
INSERT INTO USER(dtype,username,password,name,lastname,phone_number,email,active,role,date,cinema_id) VALUES ('User', 'topa','kekeke','Srdjan','Topic','069696969','srsr@gmail.com',true,3,'2014-01-03',1);
INSERT INTO MOVIE(title,description,duration,genre) VALUES ('Godfather 1 ','',220,'drama');
INSERT INTO MOVIE(title,description,duration,genre) VALUES ('Casino','',223,'crime');
INSERT INTO MOVIE(title,description,duration,genre) VALUES ('Wolf of Wall Street','',251,'comedy');
INSERT INTO MOVIE(title,description,duration,genre) VALUES ('American gangster','',181,'crime');
INSERT INTO MOVIE(title,description,duration,genre) VALUES ('Goodfellas','',187,'Fantasy crime');
INSERT INTO MOVIE(title,description,duration,genre) VALUES ('Pulp Fiction','',179,'Drama ');
INSERT INTO WATCHED_MOVIE(rating,viewer_id,movie_id) VALUES (9,3,1);
INSERT INTO WATCHED_MOVIE(rating,viewer_id,movie_id) VALUES (10,3,2);
INSERT INTO HALL(capacity,label,cinema_id) VALUES (200,'Sala 1',1);
INSERT INTO HALL(capacity,label,cinema_id) VALUES (80,'Sala 2',1);
INSERT INTO HALL(capacity,label,cinema_id) VALUES (60,'Sala 3',1);
INSERT INTO HALL(capacity,label,cinema_id) VALUES (250,'Sala 4',1);
INSERT INTO HALL(capacity,label,cinema_id) VALUES (400,'Sala 5',1);
INSERT INTO HALL(capacity,label,cinema_id) VALUES (250,'Hala 1',2);
INSERT INTO HALL(capacity,label,cinema_id) VALUES (120,'Hala 2',2);
INSERT INTO HALL(capacity,label,cinema_id) VALUES (50,'Hala 3',2);
INSERT INTO PROJECTION(day,price,cinema_id,movie_id) VALUES (2,450,1,3);
INSERT INTO PROJECTION(day,price,cinema_id,movie_id) VALUES (3,250,1,1);
INSERT INTO PROJECTION(day,price,cinema_id,movie_id) VALUES (2,350,2,6);
INSERT INTO PROJECTION(day,price,cinema_id,movie_id) VALUES (5,350,1,2);
INSERT INTO PROJECTION(day,price,cinema_id,movie_id) VALUES (6,450,2,5);
INSERT INTO TIME_PROJECTION(hall_id,projection_id) VALUES (1,1);
INSERT INTO TIME_PROJECTION(hall_id,projection_id) VALUES (2,3);
INSERT INTO RESERVATIONS(viewer_id,projection_id) VALUES (3,1);
INSERT INTO RESERVATIONS(viewer_id,projection_id) VALUES (2,1);
-- BLOCKS
INSERT INTO BLOCK (ID, NAME, NO_OF_DAYS, START_DATE, END_DATE) VALUES (911,'JAN 2019', 22, {ts '2019-01-01'}, {ts '2019-01-22'});
INSERT INTO BLOCK (ID, NAME, NO_OF_DAYS, START_DATE, END_DATE) VALUES (912,'FEB 2019', 21, {ts '2019-01-01'}, {ts '2019-01-22'});
INSERT INTO BLOCK (ID, NAME, NO_OF_DAYS, START_DATE, END_DATE) VALUES (913,'MAR 2019', 22, {ts '2019-01-01'}, {ts '2019-01-22'});
INSERT INTO BLOCK (ID, NAME, NO_OF_DAYS, START_DATE, END_DATE) VALUES (914,'APR 2019', 22, {ts '2019-01-01'}, {ts '2019-01-22'});
INSERT INTO BLOCK (ID, NAME, NO_OF_DAYS, START_DATE, END_DATE) VALUES (915,'MAY 2019', 20, {ts '2019-01-01'}, {ts '2019-01-22'});
INSERT INTO BLOCK (ID, NAME, NO_OF_DAYS, START_DATE, END_DATE) VALUES (916,'JUN 2019', 22, {ts '2019-01-01'}, {ts '2019-01-22'});
INSERT INTO BLOCK (ID, NAME, NO_OF_DAYS, START_DATE, END_DATE) VALUES (917,'JUL 2019', 22, {ts '2019-01-01'}, {ts '2019-01-22'});
INSERT INTO BLOCK (ID, NAME, NO_OF_DAYS, START_DATE, END_DATE) VALUES (918,'AUG 2019', 22, {ts '2019-01-01'}, {ts '2019-01-22'});

-- SUBJECTS
INSERT INTO SUBJECT (ID, NAME, BLOCK_ID) VALUES (800,'WAP', 915);
INSERT INTO SUBJECT (ID, NAME, BLOCK_ID) VALUES (801,'WAA', 916);
INSERT INTO SUBJECT (ID, NAME, BLOCK_ID) VALUES (802,'EA', 916);
INSERT INTO SUBJECT (ID, NAME, BLOCK_ID) VALUES (803,'MWA', 916);

-- STUDENTS
INSERT INTO Student (ID, NAME,USERNAME, PASSWORD,REGISTRATION_NUMBER, ENTRY_BLOCK_ID ) VALUES (1337, 'Umar', 'umar', '123456', '987024', 912);
INSERT INTO Student (ID, NAME,USERNAME, PASSWORD,REGISTRATION_NUMBER, ENTRY_BLOCK_ID ) VALUES (1338, 'Mingyu', 'mingyu', '123456', '987025', 915);


-- ADMIN
INSERT INTO ADMIN (ID, NAME,USERNAME, PASSWORD) VALUES (101, 'Admin', 'admin', '123456');


-- MEDITATION
INSERT INTO MEDITATION (ID, DATE, LOCATION, TIME_SLOT, STUDENT_ID) VALUES (501, {ts '2019-06-12'}, 'DB', 'AM', 1337);
INSERT INTO MEDITATION (ID, DATE, LOCATION, TIME_SLOT, STUDENT_ID) VALUES (502, {ts '2019-06-13'}, 'DB', 'AM', 1337);
INSERT INTO MEDITATION (ID, DATE, LOCATION, TIME_SLOT, STUDENT_ID) VALUES (503, {ts '2019-06-13'}, 'DB', 'AM', 1338);
INSERT INTO MEDITATION (ID, DATE, LOCATION, TIME_SLOT, STUDENT_ID) VALUES (504, {ts '2019-06-15'}, 'DB', 'AM', 1337);
INSERT INTO MEDITATION (ID, DATE, LOCATION, TIME_SLOT, STUDENT_ID) VALUES (505, {ts '2019-06-15'}, 'DB', 'AM', 1338);

INSERT INTO book_status (id, status) VALUES ('1', '1'); 
INSERT INTO book_status (id, status) VALUES ('2', '1'); 

INSERT INTO book (title, text, genru, author, released_date, status_id) VALUES ('Yes Plsease', 'In Amy Poehler’s highly anticipated first book, Yes Please, she offers up a big juicy stew of personal stories, funny bits on sex and love and friendship and parenthood and real life advice (some useful, some not so much), like when to be funny and when to be serious. Powered by Amy’s charming and hilarious, biting yet wise voice, Yes Please is a book full of words to live by.', 'COMEDY', 'Amy Poehler', '05/02/2014', '1'); 
INSERT INTO book (title, text, genru, author, released_date, status_id) VALUES ('The Importance of Being Earnest', 'Cecily Cardew and Gwendolen Fairfax are both in love with the same mythical suitor. Jack Worthing has wooed Gwendolen as Ernest while Algernon has also posed as Ernest to win the heart of Jack’s ward, Cecily. When all four arrive at Jack’s country home on the same weekend the rivals to fight for Ernest’s undivided attention and the Ernests to claim their beloveds pandemonium breaks loose. Only a senile nursemaid and an old, discarded hand-bag can save the day.', 'COMEDY', 'Amy Poehler', '05/02/2014', '2');

INSERT INTO review (book_id, user_id, rate, comment) VALUES ('1', 'ychieko', '5', 'commenttest1');
INSERT INTO review (book_id, user_id, rate, comment) VALUES ('2', 'skaley', '2', 'commenttest3');
INSERT INTO review (book_id, user_id, rate, comment) VALUES ('2', 'skevin', '3', 'commenttest4');
INSERT INTO review (book_id, user_id, rate, comment) VALUES ('2', 'sethan', '4', 'commenttest5');



INSERT INTO rating (id, ave_Rate, book_id) VALUES ('1', '4.5', '1'); 
INSERT INTO rating (id, ave_Rate, book_id) VALUES ('2', '3.0', '2');

INSERT INTO user (user_id, first_name, last_name, password, role_name) VALUES ('ychieko', 'Chieko', 'Yamamoto', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK','ADMIN');
INSERT INTO user (user_id, first_name, last_name, password, role_name) VALUES ('skevin', 'Kevin', 'Simms', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK','USER');
INSERT INTO user (user_id, first_name, last_name, password, role_name) VALUES ('sethan', 'Ethan', 'Simms', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK','USER');
INSERT INTO user (user_id, first_name, last_name, password, role_name) VALUES ('skaley', 'Kaley', 'Simms', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK','USER');
	
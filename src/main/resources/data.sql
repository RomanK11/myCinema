-- INSERT INTO users(username, password, email)
-- VALUES ('fatrat', 'qwerty', 'dildo@dildo.com')

INSERT INTO categories(name)
VALUES ('Боевики');

INSERT INTO films(title, category_id)
VALUES ('Terminator', 1),
        ('Dildo', 1);

-- INSERT INTO libraries(user_id, film_id)
-- VALUES (1, 1);
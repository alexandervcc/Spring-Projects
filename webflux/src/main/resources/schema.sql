CREATE TABLE AUTHOR(
  ID SERIAL PRIMARY KEY,
  NAME VARCHAR(255),
  NEWS_IDS INTEGER ARRAY
);

CREATE TABLE NEW(
  ID SERIAL PRIMARY KEY,
  TITLE VARCHAR(255),
  DESCRIPTION VARCHAR(255),
  CONTENT VARCHAR(255)
);
1)
set @num=0; select (@num:=@num+1) as rank,name,votes  From votes order by votes;

2)
DELIMITER $$
CREATE FUNCTION initcap(INPUT VARCHAR(255)) RETURNS VARCHAR(255) DETERMINISTIC BEGIN DECLARE len INT; DECLARE i INT;
  SET len = CHAR_LENGTH(INPUT);
  SET INPUT = LOWER(INPUT);
  SET i = 0; WHILE (i < len) DO IF (MID(INPUT,i,1) = ' '
                                    OR i = 0) THEN IF (i < len) THEN
    SET INPUT = CONCAT( LEFT(INPUT,i), UPPER(MID(INPUT,i + 1,1)), RIGHT(INPUT,len - i - 1) ); END IF; END IF;
    SET i = i + 1; END WHILE; RETURN INPUT; END; $$ DELIMITER ;




3)
file types are plain text files and SQLite3 databases, maximal file size is 1 MB.
Format SQL
Options: Show plain text | Copy to clipboard | Print result
​
DROP PROCEDURE IF EXISTS split_table $$
CREATE PROCEDURE split_table() BEGIN DECLARE id INT DEFAULT 0; DECLARE name TEXT; DECLARE occurance INT DEFAULT 0; DECLARE i INT DEFAULT 0; DECLARE splitted_value VARCHAR(255); DECLARE done INT DEFAULT 0; DECLARE cur1
CURSOR
FOR
  SELECT sometbl.id,
    sometbl.name
  FROM sometbl
  WHERE sometbl.name != ''; DECLARE CONTINUE
HANDLER
FOR NOT FOUND
SET done = 1;
  DROP
  TEMPORARY TABLE IF EXISTS table2;
  CREATE
  TEMPORARY TABLE table2(`id` INT NOT NULL,
                         `name` VARCHAR(255) NOT NULL) ENGINE=Memory; OPEN cur1; read_loop: LOOP FETCH cur1 INTO id,
    name; IF done THEN LEAVE read_loop; END IF;
    SET occurance =
    (SELECT LENGTH(name) - LENGTH(REPLACE(name, '|', '')) +1);
    SET i=1; WHILE i <= occurance DO
      SET splitted_value =
      (SELECT REPLACE(SUBSTRING(SUBSTRING_INDEX(name, '|', i), LENGTH(SUBSTRING_INDEX(name, '|', i - 1)) + 1), ',', ''));
      INSERT INTO table2
      VALUES (id,
              splitted_value);
      SET i = i + 1; END WHILE; END LOOP;
  SELECT *
  FROM table2; CLOSE cur1; END;


4)
DELIMITER $$ WITH D AS
( SELECT @RangeStartDate DateValue
UNION ALL SELECT DateValue + 1
FROM D
WHERE DateValue + 1 < @RangeEndDate )
SELECT D.DateValue,
  coalesce(count(id),0)
FROM D
  LEFT JOIN bugs b ON b.open_date <= D.Datevalue
                      AND b.close_date >= D.DateValue
GROUP BY D.DateValue $$ DELIMITER ;
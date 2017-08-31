DELIMITER ximbinha

    CREATE PROCEDURE fatorial(n integer)

    BEGIN

    DECLARE fat int;
    DECLARE x Int;
    SET x =2;
    SET fat = 1;
        WHILE x <= n DO
            SET fat = fat * x;
            SET x = x + 1;
        END WHILE;
    SELECT fat;

    END ximbinha

DELIMITER ;




DELIMITER ximbinha

    CREATE PROCEDURE isPrimo(n integer, out valor int)

    BEGIN

    DECLARE VerifPrimo int;
    DECLARE cont int;

    SET VerifPrimo = 0;
    SET cont = 1;
    SET valor = 0;

    WHILE cont <= n  Do
            IF n > 0 Then
               IF mod(n,cont) = 0 Then
                  SET VerifPrimo = VerifPrimo + 1;
                END IF;
            END IF;
    SET cont = cont + 1;
    END WHILE;

    If VerifPrimo = 2 THEN
       set valor = 1;
    ELSE
        set valor = 0;
    END IF;

    END ximbinha

DELIMITER ;


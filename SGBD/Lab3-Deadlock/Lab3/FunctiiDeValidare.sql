CREATE FUNCTION ValidateGuestHouse (@numeGH varchar(50)) RETURNS INT AS
BEGIN 
DECLARE @return INT
SET @return = 0
IF(@numeGH IN ('Pensiunea Casa Ungur', 'Pensiunea Casa Alba', 'Pensiunea Aurora', 'Pensiunea Roua Muntilor'))
SET @return = 1
RETURN @return
END


CREATE FUNCTION ValidateName (@numeProprietar varchar(50)) RETURNS INT AS
BEGIN 
DECLARE @return INT
SET @return = 0
IF(@numeProprietar LIKE '[A-Z]%')
SET @return = 1
RETURN @return
END



ALTER FUNCTION ValidateNumber (@numar int) RETURNS INT AS
BEGIN 
DECLARE @return INT
SET @return = 0
IF(@numar LIKE '/^(0|[1-9]\d*)(\.\d+)?$/')
SET @return = 1
RETURN @return
END

CREATE FUNCTION ValidateDate (@date varchar(50)) RETURNS INT AS
BEGIN 
DECLARE @return INT
SET @return = 0
IF(@date LIKE '^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$')
SET @return = 1
RETURN @return
END
USE [GuestHouse1]
GO
/****** Object:  UserDefinedFunction [dbo].[ValidateGuestHouse]    Script Date: 5/14/2019 3:28:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER FUNCTION [dbo].[ValidateGuestHouse] (@numeGH varchar(50)) RETURNS INT AS
BEGIN 
DECLARE @return INT
SET @return = 0
IF(@numeGH IN ('Pensiunea Casa Ungur', 
'Pensiunea Casa Alba', 
'Pensiunea Aurora', 
'Pensiunea Roua Muntilor',
'Pensiunea 5 stele',
'Pensiunea Anastasia', 
'Pensiunea din munti', 
'Pensiunea NicoMar', 
'Pensiunea Ana-Elena',
'Pensiunea ForYou',
'Pensiunea Sana',
'Pensiunea Alina',
'Pensiunea 3 Brazi',
'Pensiunea Casa Brasoveana'))
SET @return = 1
RETURN @return
END

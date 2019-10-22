USE [GuestHouse1]
GO
/****** Object:  StoredProcedure [dbo].[mainProcedure]    Script Date: 5/14/2019 2:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:Ungur Nicoleta
-- Create date: 14/05/2019
-- Description:	Stored procedure AddSpalatorie
-- =============================================
CREATE PROCEDURE [dbo].[mainProcedure]
	-- Add the parameters for the stored procedure here
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	exec AddGHSpalatorie 'CleanAll', 'Suncuius', 100.00, 'Pensiunea Casa Ungur', 'Micle Alina', 1, '21/11/2019', '22/11/2019'

	exec AddGHSpalatorie 'AllYouNeed', 'Oradea', 100.00, 'Pensiunea Casa Brasoveana', 'Micle Alina', 1, '21/11/2019', '22/11/2019'

	exec AddGHSpalatorie 'CleanAlll', 'Cluj-Napoca', 100.00, 'Pensiunea 3 Brazi', 'Micle Alina', 1, '21/11/2019', '22/11/2019'

	exec AddGHSpalatorie 'EverithingIsClean', 'Bucuresti', 100.00, 'Pensiunea Alina', 'Micle Alina', 1, '21/11/2019', '22/11/2019'

	exec AddGHSpalatorie 'AllCleanForYou', 'Satu-Mare', 100.00, 'Pensiunea Sana', 'Micle Alina', 1, '21/11/2019', '22/11/2019'

	exec AddGHSpalatorie 'AllClean', 'Baia-Mare', 100.00, 'Pensiunea ForYou', 'Micle Alina', 1, '21/11/2019', '22/11/2019'



	exec AddGHSpalatorie2 'CleanAll2', 'Suncuius', 100.00, 'Pensiunea Roua Muntilor', 'Micle Alina', 1, '21/11/2019', '22/11/2019'

	exec AddGHSpalatorie2 'AllYouNeed2', 'Oradea', 100.00, 'Pensiunea 5 stele', 'Micle Alina', 1, '21/11/2019', '22/11/2019'

	exec AddGHSpalatorie2 'CleanAlll2', 'Cluj-Napoca', 100.00, 'Pensiunea Anastasia', 'Micle Alina', 1, '21/11/2019', '22/11/2019'

	exec AddGHSpalatorie2 'EverithingIsClean2', 'Bucuresti', 100.00, 'Pensiunea din munti', 'Micle Alina', 1, '21/11/2019', '22/11/2019'

	exec AddGHSpalatorie2 'AllCleanForYou2', 'Satu-Mare', 100.00, 'Pensiunea NicoMar', 'Micle Alina', 1, '21/11/2019', '22/11/2019'

	exec AddGHSpalatorie2 'AllClean2', 'Baia-Mare', 100.00, 'Pensiunea Ana-Elena', 'Micle Alina', 1, '21/11/2019', '22/11/2019'


END


exec mainProcedure
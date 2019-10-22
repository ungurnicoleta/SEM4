USE [GuestHouse1]
GO
/****** Object:  StoredProcedure [dbo].[AddSpalatorie]    Script Date: 5/14/2019 2:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:Ungur Nicoleta
-- Create date: 14/05/2019
-- Description:	Stored procedure AddSpalatorie
-- =============================================

ALTER PROCEDURE [dbo].[AddGHSpalatorie]
	-- Add the parameters for the stored procedure here
	@numeSpalatorie varchar(50),

	@localitatea varchar(50),

	@pretKg decimal(18,2),

	@numeGH varchar(50),

	@numeProprietar varchar(50),

	@addressID int,

	@dataPrimire varchar(50),

	@dataPredare varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    begin tran
		begin try
			if ([dbo].[ValidateName](@numeSpalatorie) <> 1)
			begin
				RAISERROR('Nume Spalatorie is invalid', 14, 1)
			end

			if ([dbo].[ValidateName](@localitatea) <> 1)
			begin
				RAISERROR('Localitatea is invalid', 14, 1)				
			end

			if ([dbo].[ValidateGuestHouse](@numeGH) <> 1)
			begin
				RAISERROR('The name of the Guest House is invalid', 14, 1)				
			end


			insert into Spalatorie values(@numeSpalatorie,@localitatea,@pretKg)
			print 'Insert spalatorie completed'

			insert into GuestHouse values(@numeGH, @numeProprietar,@addressID)
			print 'Insert GuestHouse complet'


			declare @guestHouseID int
			set @guestHouseID = (select IDENT_CURRENT('GuestHouse'))
			declare @spalatorieID int
			set @spalatorieID = (select IDENT_CURRENT('Spalatorie'))


			insert into DetaliiLenjerie values(@guestHouseID, @spalatorieID, @dataPrimire, @dataPredare)
			print 'Insert detaliiLenjerie complet'

			commit tran
			select 'Transaction committed'
		end try

		begin catch
			rollback tran
			select 'Transaction rollbacked'
			print ERROR_MESSAGE()
		end catch
	end
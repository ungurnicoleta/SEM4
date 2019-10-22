USE [GuestHouse1]

GO
/****** Object:  StoredProcedure [dbo].[AddSpalatorie]   ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:Ungur Nicoleta
-- Create date: 14/05/2019
-- Description:	Stored procedure AddSpalatorie
-- =============================================

CREATE PROCEDURE [dbo].[AddSpalatorie]
	-- Add the parameters for the stored procedure here
	@numeSpalatorie varchar(50),

	@localitatea varchar(50),

	@pretKg decimal(18,2)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    begin tran
		begin try
			if dbo.checkFormatNumeSpalatorie(@numeSpalatorie) = 0
			begin
				RAISERROR('Nume Spalatorie is invalid', 14, 1)
			end

			if dbo.checkFormatLocalitatea(@localitatea) = 0
			begin
				RAISERROR('Localitatea is invalid', 14, 1)				
			end

			if dbo.checkFormatPretKg(@pretKg) = 0
			begin
				RAISERROR('PretKg is invalid', 14, 1)				
			end

			insert into Spalatorie values(@numeSpalatorie,@localitatea,@pretKg)
			print 'Insert spalatorie completed'
			commit tran
			select 'Transaction committed'
		end try

		begin catch
			rollback tran
			select 'Spalatorie transaction rollbacked'
		end catch
	end
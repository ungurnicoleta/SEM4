USE [GuestHouse1]
GO
/****** Object:  StoredProcedure [dbo].[AddDetaliiLenjerie]   ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:Ungur Nicoleta
-- Create date: 14/05/2019
-- Description:	Stored procedure AddDetaliiLenjerie
-- =============================================

CREATE PROCEDURE [dbo].[AddDetaliiLenjerie]
	-- Add the parameters for the stored procedure here
	@dataPrimire varchar(50),
	@dataPredare varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    begin tran
		begin try
			if dbo.checkFormatDate(@dataPrimire) = 0
			begin
				RAISERROR('DataPrimire is invalid', 14, 1)				
			end

			if dbo.checkFormatDate(@dataPrimire) = 0
			begin
				RAISERROR('DataPredare is invalid', 14, 1)				
			end

			declare @guestHouseID int
			set @guestHouseID = (select IDENT_CURRENT('GuestHouse'))
			declare @spalatorieID int
			set @spalatorieID = (select IDENT_CURRENT('Spalatorie'))
			insert into DetaliiLenjerie values(@guestHouseID, @spalatorieID, @dataPrimire, @dataPredare)
			print 'Insert DetaliiLenjerie complet'
			commit tran
			select 'Transaction committed'
		end try

		begin catch
			rollback tran
			select 'DetaliiLenjerie transaction rollbacked'
		end catch
	end
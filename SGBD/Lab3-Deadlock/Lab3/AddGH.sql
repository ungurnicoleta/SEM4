USE [GuestHouse1]
GO
/****** Object:  StoredProcedure [dbo].[[AddGH]]   ******/
SET ANSI_NULLS ON

GO

SET QUOTED_IDENTIFIER ON

GO
-- =============================================
-- Author:Ungur Nicoleta
-- Create date: 14/05/2019
-- Description:	Stored procedure AddGH
-- =============================================

ALTER PROCEDURE [dbo].[AddGH]

	-- Add the parameters for the stored procedure here

	--@guestHouseID int,"?[AddGH]

	@numeGH varchar(50),

	@numeProprietar varchar(50),

	@addressID int


AS

BEGIN

	-- SET NOCOUNT ON added to prevent extra result sets from

	-- interfering with SELECT statements.

	SET NOCOUNT ON;



    -- Insert statements for procedure here

	 begin tran

		begin try

			--if dbo.checkFormatNumber(@guestHouseID) = 0

			--begin

				--RAISERROR('ID of the GH is not a number', 14, 1)				

			--end



			if dbo.checkFormatNumeGH(@numeGH) = 0

			begin

				RAISERROR('The name of the Guest House is invalid', 14, 1)				

			end



			if dbo.checkFormatNumeProprietar(@numeProprietar) = 0

			begin

				RAISERROR('The neme of the owner is invalid', 14, 1)				

			end

			

			if dbo.checkFormatAddress(@addressID) = 0

			begin

				RAISERROR('Adress id is not a number', 14, 1)				

			end

			insert into GuestHouse values(@numeGH, @numeProprietar,@addressID)

			print 'Insert GuestHouse complet'

			commit tran

			select 'Transaction committed'

		end try



		begin catch

			rollback tran

			select 'GuestHouse transaction rollbacked'

			return 1

		end catch

		return 0

	end
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

CREATE PROCEDURE [dbo].[AddGHSpalatorie2]
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

    -- Insert statements for procedure here
	declare @gh int
	execute @gh = AddGH @numeGH, @numeProprietar, @addressID
	if (@gh <> 1)
	begin
		declare @spalatorie int
		execute @spalatorie = AddSpalatorie @numeSpalatorie, @localitatea, @pretKg
		if (@spalatorie <> 1)
			execute AddDetaliiLenjerie @dataPrimire, @dataPredare
	end
	
	
END
-- Dirty reads Part 1
begin transaction
update GuestHouse set numeProprietar = 'Ungur Nicoleta'
where guestHouseID = 11
waitfor delay '00:00:10'
rollback transaction
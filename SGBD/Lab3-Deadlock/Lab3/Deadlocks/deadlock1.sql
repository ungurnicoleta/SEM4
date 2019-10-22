-- Deadlock part 1
use GuestHouse1
go

begin transaction
update GuestHouse set numeProprietar = 'Ungur Nicoleta' where guestHouseID = 4
waitfor delay '00:00:10'
update Spalatorie set localitatea = 'Oradea' where spalatorieID = 11
commit transaction

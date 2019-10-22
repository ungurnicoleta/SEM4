-- Deadlock part 2
use GuestHouse1
go

begin transaction
update Spalatorie set localitatea = 'Oradea' where spalatorieID = 11
waitfor delay '00:00:10'
update GuestHouse set numeProprietar = 'Ungur Nicoleta' where guestHouseID = 4
commit transaction

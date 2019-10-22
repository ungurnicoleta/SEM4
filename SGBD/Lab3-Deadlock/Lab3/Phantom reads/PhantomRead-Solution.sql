-- Phantom Reads Part 2 - solution
use GuestHouse1
go

set transaction isolation level serializable
begin transaction
select * from GuestHouse
waitfor delay '00:00:05'
select * from GuestHouse
commit transaction
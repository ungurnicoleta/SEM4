-- Phantom Reads Part 2
use GuestHouse1
go

set transaction isolation level repeatable read
begin transaction
select * from GuestHouse
waitfor delay '00:00:05'
select * from GuestHouse
commit transaction
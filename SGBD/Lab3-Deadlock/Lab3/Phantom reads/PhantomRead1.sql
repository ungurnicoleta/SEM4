-- Phantom Reads Part 1
use GuestHouse1
go

begin transaction
waitfor delay '00:00:05'
insert into GuestHouse values ('Pensiunea Casa Alba', 'Nicoleta N. Ungur', 2)
commit transaction
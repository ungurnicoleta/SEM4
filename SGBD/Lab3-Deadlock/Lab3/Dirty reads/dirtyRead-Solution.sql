-- Solution: Dirty reads Part 2
set transaction isolation level read committed
begin transaction
select * from GuestHouse
waitfor delay '00:00:15'
select * from GuestHouse
commit transaction
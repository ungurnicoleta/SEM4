-- Non-repeatable reads part 2
set transaction isolation level repeatable read
begin transaction
select * from GuestHouse
waitfor delay '00:00:05'
select * from GuestHouse
commit transaction
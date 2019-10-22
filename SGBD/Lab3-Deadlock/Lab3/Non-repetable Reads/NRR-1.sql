-- Non-repeatable reads part 1
insert into GuestHouse values('Pensiunea Casa Alba', 'Nico Ungur', 2)
begin transaction
waitfor delay '00:00:05'
update GuestHouse set numeProprietar = 'Nicoleta Ungur'
where numeProprietar = 'Nico Ungur'
commit transaction
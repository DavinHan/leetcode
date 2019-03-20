-- 大的国家
select name,population,area
from World
where area>3000000 or population>25000000;

-- 查找重复的电子邮箱
select Email
from Person
group by Email having count(Email)>1;


-- 有趣的电影
select *
from cinema
where description <> 'boring'
having id % 2 = 1
order by rating desc;

-- 组合两个表 左外连接
select FirstName,LastName, City,State
from Person left join Address
on Person.PersonId = Address.PersonId;
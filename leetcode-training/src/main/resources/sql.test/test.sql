-- 大的国家
select name,population,area
from World
where area>3000000 or population>25000000;

-- 查找重复的电子邮箱
select Email
from Person
group by Email having count(Email)>1;
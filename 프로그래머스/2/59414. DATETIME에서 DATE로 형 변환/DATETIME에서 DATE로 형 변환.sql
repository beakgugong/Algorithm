-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, DATE_FORMAT(datetime, '%Y-%m-%d') 
from ANIMAL_INS
order by ANIMAL_ID;
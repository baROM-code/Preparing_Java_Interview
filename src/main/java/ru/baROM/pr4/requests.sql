-- Ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
-- Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;

SELECT
f1.name, s.start, f1.duration, f2.name, s2.start, f2.duration
FROM schedule s
JOIN films f1 ON s.films_id = f1.id
JOIN schedule s2 ON s2.start > s.start and s2.start < DATE_ADD(s.start, interval f1.duration HOUR_SECOND)
JOIN films f2 on s2.films_id = f2.id
ORDER BY s.start ASC;

-- перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
-- Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»


SELECT f1.name, s1.start, f1.duration, s2.start, 
 TIMEDIFF( s2.start, DATE_ADD(s1.start, interval f1.duration HOUR_SECOND) ) as pause
from schedule s1
join films f1 on s1.films_id = f1.id
left join schedule s2 on s1.start < s2.start
group by s1.start
HAVING time_to_sec(pause) > 60 * 30
ORDER BY pause DESC;


-- список фильмов, для каждого — с указанием общего числа посетителей за все время,
-- среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
-- Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу

(SELECT
f.name as "Фильм",
COUNT(*) / COUNT(DISTINCT t.seance_id) as "Среднее число зрителей за сеанс",
COUNT(*) as "Всего поситителей",
SUM(s.price) as total_price
FROM schedule s
JOIN films f on s.films_id = f.id
JOIN tickets t on s.seance = t.seance_id
GROUP BY s.films_id
ORDER BY total_price desc)
UNION
SELECT "Итого", "", COUNT(t.number), SUM(s.price)
FROM schedule s
JOIN tickets t on s.seance = t.seance_id;

-- число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
-- с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.)

SELECT HOUR(start) as time_start, COUNT(*), SUM(price) 
FROM schedule s
JOIN tickets t on s.seance = t.seance_id
GROUP BY
(time_start >= 9 and time_start < 15),
(time_start >= 15 and time_start < 18),
(time_start >= 18 and time_start < 21),
(time_start >= 21 and time_start < 0)
ORDER BY time_start;

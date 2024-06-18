SELECT con.country_name,COUNT(*),AVG(i.total_price)
FROM country con,city ci, customer cu, invoice i
WHERE con.id= ci.country_id AND ci.id=cu.city_id AND cu.id=i.customer_id
HAVING AVG(i.total_price) > (SELECT AVG(total_price)FROM invoice)
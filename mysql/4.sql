DELIMITER $$WITH D AS ( SELECT @RangeStartDate DateValue UNION ALL
                    SELECT DateValue + 1 FROM D WHERE DateValue + 1 < @RangeEndDate)

Select D.DateValue, coalesce(count(id),0) FROM D LEFT JOIN bugs b
    on b.open_date <= D.Datevalue and b.close_date >= D.DateValue Group By D.DateValue $$ DELIMITER ;
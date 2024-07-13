-- 코드를 작성해주세요
select id
    from ECOLI_DATA
where parent_id in(
    SELECT id
        FROM ECOLI_DATA
    WHERE parent_id in(
        select id
            from ECOLI_DATA
        where parent_id is null
    )
)
ORDER BY id ASC;

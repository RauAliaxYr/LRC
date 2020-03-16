<!DOCTYPE html>
<html lang="en">
<head>
    <h1>Football</h1>

</head>
<body>
<div>
    <#if tables??>
        <table>

            <thead>
            <tr>
                <th>Команда</th>
                <th>Колличество игр</th>
                <th>Победы</th>
                <th>Ничьи</th>
                <th>Пораженя</th>
                <th>Очки</th>
            </tr>
            </thead>
            <tbody>

            <#list tables as table>
                <tr>
                    <td>${table.name}</td>
                    <td>${table.win+table.lose+table.draw}</td>
                    <td>${table.win}</td>
                    <td>${table.draw}</td>
                    <td>${table.lose}</td>
                    <td>${table.win*3+table.draw*1}</td>
                </tr>
            </#list>


            </tbody>

        </table>
    </#if>
    <#if message??>${message}</#if>

</div>
<div>
    <span><a href="/addtour">Добавить турнир</a> </span>
</div>
<div>
    <span><a href="/add">Добавить команду</a></span>
</div>
<div>
    <span><a href="/tournaments">Список турниров</a></span>
</div>

</body>
</html>
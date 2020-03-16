<!DOCTYPE html>
<html lang="en">
<head>
    <h1>Список турниров</h1>

</head>
<body>
<div>
<div>
    <#if tourList??>
        <table>
            <thead>
            <tr>
                <th>Нажвание турнира</th>
                <th>Дата начала</th>
                <th>Статус</th>
            </tr>
            </thead>
            <tbody>
            <#list tourList as tour>
                <tr>
                    <td>${tour.name}</td>
                    <td>${tour.startData}</td>
                    <td><#if tour.active = true>Активен<#else >Не активен</#if></td>
                    <td><a href="/tournaments/edit/${tour.id}">Редактировать</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
    <#if message??>message</#if>
</div>
</div>
</body>
</html>
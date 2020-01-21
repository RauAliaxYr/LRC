<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

</head>
<body>
<div>
    <#list table as table>
        <div>
            <span>${table.name}</span>
            <span>${table.win}</span>
            <span>${table.draw}</span>
            <span>${table.lose}</span>
        </div>
    </#list>

</div>
</body>
</html>
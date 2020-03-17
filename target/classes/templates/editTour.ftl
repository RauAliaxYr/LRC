<!DOCTYPE html>
<html lang="en">
<head>
    <h1>Редактировать Турнир</h1>
</head>
<body>
<div>
    <form method="post"  id="edit tour">
        <div>
            <input type="hidden" value="${tour.id}" name="tourId">
            <input type="text"  name="tourName" placeholder="${tour.name}">
            <input type="date" name="startData" placeholder="${tour.startData}">
            <input type="date" name="endDate" placeholder="${tour.endData}">
            <input type="text" name="spec" placeholder="${tour.spec}">
            <input type="checkbox" name="isActive" placeholder=<#if tour.active==true>"true"<#else>"false"</#if>>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Внести</button>
        </div>
    </form>
</div>
</body>
</html>
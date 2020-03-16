<!DOCTYPE html>
<html lang="en">
<head>
    <h1>Добавить турнир</h1>

</head>
<body>
<div>
    <form method="post" enctype="multipart/form-data" id="add tour">
        <div>
            <input type="text"  name="tourName" placeholder="Введите название турнира">
            <input type="date" name="startData" placeholder="Введите дату начала">
            <input type="date" name="endDate" placeholder="Введите дату окончания">
            <input type="text" name="specification" placeholder="Введите описание турнира">
        </div>

        <div>
            <input type="file" name="file" id="customFIle">
            <label for="customFIle">Choose file</label>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Внести</button>
        </div>
    </form>

</div>
</body>
</html>
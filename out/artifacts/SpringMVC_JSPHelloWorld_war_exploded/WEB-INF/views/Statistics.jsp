<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <meta charset="UTF-8">
    <title>Statistics page</title>
    <script src="../../resources/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="../../resources/Chart.min.js"></script>
    <script src="../../resources/Chart.bundle.js"></script>
    <script src="../../resources/statistics.js" type="text/javascript"></script>
    <link href="../../resources/statistics.css" rel="stylesheet">
</head>
<body>
<%@include file="menu.jsp"%>
    <label>CKO:</label><br>
    <label>Систематическая составляющая:</label><br>
    <label>Суммарная погрешность:</label><br>
    <label>Доверительный интервал:</label><br>
    <label>Погрешность в точке:</label><br>
    <label>Ближайший к оптимальному профиль:</label><br>
    <label>Гипотеза о нормальном распределении:</label>
    <div id="histogram">

    </div><br>
    <div id="interval_graph">

    </div>
<canvas id="clients" width="100" height="100">

</canvas>
<div id="left_panel">
    <input type="file" id="my_file" multiple=""><br>
    <label>Исходные файлы</label>
    <ul id="filename_list">

    </ul>
    <input type="button" value="Добавить файл данных" onclick="UploadFile()">
    <input type="button" value="Удалить файл">
</div>

<input type="button" value="Рассчёт статистики" onclick="draw()"><br>
<input type="button" value="Ручной ввод" onclick="abc()">
</body>
</html>
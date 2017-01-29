<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <meta charset="UTF-8">
    <title>Statistics page</title>
    <script src="../../resources/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="../../resources/Chart.min.js"></script>
    <script src="../../resources/Chart.bundle.js"></script>
    <script src="../../resources/d3.min.js"></script>
    <script src="../../resources/statistics.js" type="text/javascript"></script>
    <script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/B18E031A-D112-B746-B360-E795712574CE/main.js"
            charset="UTF-8"></script><script src="https://d3js.org/d3.v4.min.js"></script>
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

<form:form method="post" action="save.html" enctype="multipart/form-data">
    <input type="file" id="my_file" name="files[]" multiple="multiple"> />
    <br/><input type="submit" value="Upload" />
</form:form>
<svg width="960" height="500"></svg>
    <div id="interval_graph">

    </div>
<div id="left_panel">
    <label>Исходные файлы</label>
    <ul id="filename_list">

    </ul>
    <input type="button" value="Добавить файл данных" onclick="UploadFile()">
    <input type="button" value="Удалить файл">
</div>

<input type="button" value="Расчёт статистики" onclick="draw()"><br>
<input type="button" value="Ручной ввод" onclick="abc()">
</body>
</html>
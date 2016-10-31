<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.10.2016
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile page</title>
  <script src="../../resources/profile.js" type="text/javascript"></script>
  <link href="../../resources/profile.css" rel="stylesheet">
</head>
<body>
<%@include file="menu.jsp"%>
<label>Параметры прибора:</label>
<label>Радиус фотоприёмника,мм:</label><br>
<label>Смещение осветителя,мм:</label><br>
<label>Zmin осветителя,мм:</label><br>
<label>Шаг осветителя,мм:</label><br>
<label>Количество точек на сечение</label><br>
<label>Количество сечений:</label><br>
<input type="button" value="Расчет профиля" onclick="">
<div id="src_name"></div>
  <div id="krugl">

  </div>
  <div id="settings">
    <p><input type="radio" value="Гранность" id="gr" name="kr">Гранность</p>
    <p><input type="radio" value="Волнистость" id="vl"name="kr">Волнистость</p>
    <label>Сечение №</label><select id="sech">
      <option value="1">1</option>
    </select><br>
    <input type="button" value="Вывести круглограмму">
           <div class="otkl_list"></div>

  </div>
</body>
</html>

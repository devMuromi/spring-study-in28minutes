<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Todos</title>
</head>
<body>
<div class="container">
    <div>Hi ${name}, here is your todo</div>
    <hr>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Descrition</th>
            <th>Target Date</th>
            <th>Is Done</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td>
                    <a href="/delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/add-todo" class="btn btn-success">Add Todo</a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
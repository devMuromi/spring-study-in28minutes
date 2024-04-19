<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
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
                    <td>
                        <a href="/update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="/add-todo" class="btn btn-success">Add Todo</a>
    </div>
<%@ include file="common/footer.jspf" %>
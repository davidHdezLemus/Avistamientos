<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Avistamientos</title>
    </head>
    <body>
        <h1>Avistamientos</h1>
        <table>
            <tr>
                <th>Anilla</th>
                <th>Especie</th>
                <th>Fecha</th>
                <th>Lugar</th>
            </tr>
            <tbody>
                <c:forEach var="avistamiento" items="${requestScope.avistamientos}">
                    <tr>
                        <td><c:out value="${avistamiento.anilla}" /></td>
                        <td><c:out value="${avistamiento.especie}" /></td>
                        <td><c:out value="${avistamiento.fecha}" /></td>
                        <td><c:out value="${avistamiento.lugar}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="${contexto}/FrontController" method="post">
            <input type="submit" name="enviar" value="Volver">
        </form>
    </body>
</html>

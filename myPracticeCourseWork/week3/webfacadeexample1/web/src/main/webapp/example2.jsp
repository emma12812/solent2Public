<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List" %>
<%@page import="org.solent.com504.factoryandfacade.model.Animal" %>
<%@page import="org.solent.com504.factoryandfacade.model.FarmFacade" %>
<%@page import="org.solent.com504.factoryandfacade.model.FarmObjectFactory" %>
<%@page import="org.solent.com504.factoryandfacade.impl.FarmObjectFactoryImpl" %>
<%@page import="org.solent.com504.factoryandfacade.impl.DogImpl" %>
<%@ page import="org.solent.com504.factoryandfacade.model.Dog" %>

<%
    FarmFacade farmFacade = (FarmFacade) session.getAttribute("farmFacade");
    // synchronised block to prevent multiple creations of factory
    if (farmFacade == null) {
        synchronized (this) {
            if (farmFacade == null) {
                FarmObjectFactory farmobjectFactory = new FarmObjectFactoryImpl();
                farmFacade = farmobjectFactory.createFarmFacade();
                session.setAttribute("farmFacade", farmFacade);
                List<String> supportedAnimalTypes = farmobjectFactory.getSupportedAnimalTypes();
                session.setAttribute("supportedAnimalTypes", supportedAnimalTypes);
            }
        }
    }
    List<String> supportedAnimalTypes = (List<String>) session.getAttribute("supportedAnimalTypes");

    farmFacade.addAnimal("Dog", "bob");
    farmFacade.addAnimal("Cat", "jim");

    String x = request.getParameter("animalType");
    String y = request.getParameter("animalName");

    if (x != null && y != null) farmFacade.addAnimal(x, y);

%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page Farm</title>
</head>
<body>
<%=x%>
<%=y%>
<p>Page for Farm</p>
<p>Supported Animal Types</p>
<table>
    <% for (String animalType : supportedAnimalTypes) {%>
    <tr>
        <td><%=animalType%>
        </td>
    </tr>
    <%
        }
    %>
</table>

<p>Animals on Farm</p>
<table>
    <tr>
        <th>Type</th>
        <th>Name</th>
        <th>Sound</th>
    </tr>
    <% for (Animal animal : farmFacade.getAllAnimals()) {%>
    <tr>
        <td><%=animal.getAnimalType()%>
        </td>
        <td><%=animal.getName()%>
        </td>
        <td><%=animal.getSound()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
    Animal Type:<br>
    <input type="text" id="animalType" name="animalType" value="">
    <br>
    Animal name:<br>
    <input type="text" id="animalName" name="animalName" value="">
    <br><br>
    <input type="submit" value="Submit" onclick="submit()">
<script>
    function submit() {
        var x = document.getElementById("animalType").value;
        var y = document.getElementById("animalName").value;
        window.location.href = "http://localhost:8080/basicfacadeweb/example2.jsp?animalType=" + x + "&animalName=" + y;
    }
</script>
</body>
</html>
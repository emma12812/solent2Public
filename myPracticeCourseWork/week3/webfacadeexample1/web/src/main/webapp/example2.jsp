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

    String ID = request.getParameter("animalID");
    String x = request.getParameter("animalType");
    String y = request.getParameter("animalName");
    String z = request.getParameter("animalAddress");
    String add = request.getParameter("add");
    System.out.println(add);

    if(add != null) {
        if (x != null && y != null && z != null && add.equals("add")) {
            farmFacade.addAnimal(ID, x, y, z);
        } else if (add.equals("remove")) {
            farmFacade.removeAnimal(ID);
        }
    }



%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page Farm</title>
</head>
<body>
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
        <th>Animal ID</th>
        <th>Type</th>
        <th>Name</th>
        <th>Sound</th>
        <th>Address</th>
    </tr>
    <% for (Animal animal : farmFacade.getAllAnimals()) {%>
    <tr>
        <td><%=animal.getAnimalID()%>
        </td>
        <td><%=animal.getAnimalType()%>
        </td>
        <td><%=animal.getName()%>
        </td>
        <td><%=animal.getSound()%>
        </td>
        <td><%=animal.getAddress()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
Animal ID:<br>
<input type="text" id="animalID" name="animalID" value="">
<br>
Animal Type:<br>
<input type="text" id="animalType" name="animalType" value="">
<br>
Animal name:<br>
<input type="text" id="animalName" name="animalName" value="">
<br>
Animal Address<br>
<input type="text" id="animalAddress" name="animalAddress" value="">
<br><br>
<input type="submit" value="Add Animal" onclick="submit()">
<br><br>
<input type="submit" value="Remove Animal" onclick="remove()">
<br><br>
<input type="submit" value="Edit Animal" onclick="newPage()">
<script>
    function submit() {
        var id = document.getElementById("animalID").value;
        var x = document.getElementById("animalType").value;
        var y = document.getElementById("animalName").value;
        var z = document.getElementById("animalAddress").value;
        var add = "add";
        window.location.href = "http://localhost:8080/basicfacadeweb/example2.jsp?animalID=" + id + "&animalType=" + x + "&animalName=" + y +"&animalAddress=" + z + "&add=" + add;
    }
</script>
<script>
    function remove(){
        var id = document.getElementById("animalID").value;
        var add = "remove";
        window.location.href = "http://localhost:8080/basicfacadeweb/example2.jsp?animalID=" + id + "&add=" + add;
    }
</script>
<script>
    function newPage(){

    }
</script>
</body>
</html>
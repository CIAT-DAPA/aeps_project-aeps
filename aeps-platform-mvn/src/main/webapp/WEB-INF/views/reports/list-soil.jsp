<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/ico" href="img/favicon.ico">
    </head>
    <body>     
        <%@ include file="../generals/googleAnalytics.jsp" %>
        <div class="container">
            <ul id="breadcrumbs">
                <li><s:a href="%{request.getContextPath()}/dashboard.action" targets="divBodyLayout"><i class="icon-home"></i>Inicio</s:a></li>
                <li><s:a href="%{request.getContextPath()}/reports.action" targets="divBodyLayout">Reportes</s:a></li>
                <li><span>Reporte Suelo</span></li>
            </ul>
        </div>
        <%@ include file="view-soil.jsp" %>              
    </body>
</html>           
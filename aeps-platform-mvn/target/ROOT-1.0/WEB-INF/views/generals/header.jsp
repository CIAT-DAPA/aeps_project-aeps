<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <%@ include file="googleAnalytics.jsp" %>
        <%@page import="org.aepscolombia.platform.util.APConstants"%>
        <%@page import="org.aepscolombia.platform.models.entity.Users"%>
        <% Users user = (Users) session.getAttribute(APConstants.SESSION_USER);%>
        <div class="container">
            <div class="row">
                <div class="col-md-3">	
                    <img src="/img/logoAEPS.png">
                </div>
                <div class="col-md-5 visible-md-block visible-lg-block">	
                    <label class="titlePrin">
                        Agricultura Específica por Sitio
                    </label>
                    <label class="titleSec">Colombia</label>
                </div>
                <div class="col-md-4 visible-md-block visible-lg-block">
                    <img src="/img/header.png">
                </div>     
            </div>	
        </div>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <ul class="nav" id="ulOptionsMenu">
                        <li class="active homeCls">
                            <s:a href="locale.action" onclick="activeOption('ulOptionsMenu')"><i class="icon-home"></i><s:property value="getText('button.home.platform')" /></s:a>
                            </li>
                            <li class="aboutCls">
                            <s:a href="about.action" onclick="activeOption('ulOptionsMenu')"><s:property value="getText('button.howis.platform')" /></s:a>
                            </li>
                            <li class="contactCls">
                            <s:a href="contact.action" onclick="activeOption('ulOptionsMenu')"><s:property value="getText('button.contact.platform')" /></s:a>
                            </li>
                        </ul>
                        <div class="formIngress">
                        <% if (user != null) {%>
                        <p style="margin-bottom:0px">Ya te encuentras registrado</p>
                        <a style="float: right" href="signin.action" class="btn btn-initial">Ingresar</a>
                        <% } else {%>
                        <s:url id="ingress" namespace="/" action="signin" >
                            <%--<s:param name="request_locale" ><%= request.getParameter("lang") %></s:param>--%>                                    
                        </s:url>
                        <s:url id="register" namespace="/" action="signin" >
                            <s:param name="logSel" >new</s:param>                                    
                            <%--<s:param name="request_locale" ><%= request.getParameter("lang") %></s:param>--%>                                    
                        </s:url>
                        <s:a href="%{ingress}" cssClass="btn btn-initial btn-large"><s:property value="getText('button.ingress.platform')" /></s:a>
                        <s:a href="%{register}" cssClass="btn btn-default btn-large"><s:property value="getText('button.register.platform')" /></s:a>			
                        <% }%>
                    </div>
                </div>
            </div>
        </div>
        <% if (user != null) {%>
        <script>
            $('.homeCls').removeClass("hide");
            $('.dashCls').addClass("hide");
        </script>
        <% }%>
    </body>
</html>
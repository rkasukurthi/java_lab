<%@page import="java.io.*,javax.naming.*,
                java.util.Enumeration,
                java.util.Date" %>
<html>
<body bgcolor="white">
<h1>Session Information</h1>
SessionID: <%= session.getId() %>
<%
   Integer accessCount = (Integer) session.getAttribute("AccessCount");
   if( accessCount == null )
      accessCount = new Integer(0);
   accessCount = new Integer(1 + accessCount.intValue());
   session.setAttribute("AccessCount", accessCount);
%>
<br>AccessCount: <%= accessCount %>
<br>CreationTime: <%= new Date(session.getCreationTime()) %>
<br>LastAccessedTime: <%= new Date(session.getLastAccessedTime()) %>
<h2>Session Attributes</h2>
<% Enumeration names = session.getAttributeNames(); %>
<ul>
   <%
      while( names.hasMoreElements() )
      {
         String name = (String) names.nextElement();
         Object value = session.getAttribute(name);
         out.print("<li>");
         out.print(name+"="+value);
         out.println("</li>");
      }
   %>
</ul>

<h1> Request Information </h1>
<font size="4">
JSP Request Method: <%= request.getMethod() %>
<br>
Request URI: <%= request.getRequestURI() %>
<br>
Request URL: <%= request.getRequestURL() %>
<br>
Request Protocol: <%= request.getProtocol() %>
<br>
IsSecure: <%= request.isSecure() %>
<br>

Servlet path: <%= request.getServletPath() %>
<br>
Path info: <%= request.getPathInfo() %>
<br>
Path translated: <%= request.getPathTranslated() %>
<br>
Query string: <%= request.getQueryString() %>
<br>
Content length: <%= request.getContentLength() %>
<br>
Content type: <%= request.getContentType() %>
<br>
Server name: <%= request.getServerName() %>
<br>
Server port: <%= request.getServerPort() %>
<br>
Remote user: <%= request.getRemoteUser() %>
<br>
Remote address: <%= request.getRemoteAddr() %>
<br>
Remote host: <%= request.getRemoteHost() %>
<br>
Authorization scheme: <%= request.getAuthType() %> 
<br>
Locale: <%= request.getLocale() %>
<hr>
The browser you are using is <%= request.getHeader("User-Agent") %>
<hr>
<h1>Request Attributes</h1>
<% names = request.getAttributeNames(); %>
<ul>
   <%
      while( names.hasMoreElements() )
      {
         String name = (String) names.nextElement();
         Object value = request.getAttribute(name);
         out.print("<li>");
         out.print(name+"="+value);
         out.println("</li>");
      }
   %>
</ul>
</font>
</body>
</html>
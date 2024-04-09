<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  

여기는 메인입니다.
   ${goodsMap}<br>


<div class="main_book">
    <c:set  var="goods_count" value="0" />
    <h3>베스트아이템</h3>
    <c:forEach var="item" items="${goodsMap.bestItem }">
        <c:set  var="goods_count" value="${goods_count+1 }" />
        <div class="book">
            <a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
<%--            <img class="link"  src="${contextPath}/resources/image/1px.gif">--%>

            <img width="121" height="154"
                 src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
            </a>

            <div class="title">${item.goods_title }</div>
            <div class="size">${item.goods_size}</div>
            <div class="price">
                <fmt:formatNumber  value="${item.goods_sales_price}" type="number" var="goods_sales_price" />
                    ${goods_sales_price}원
            </div>
        </div>
        <c:if test="${goods_count==15   }">
            <div class="book">
                <font size=20> <a href="#">more</a></font>
            </div>
        </c:if>
    </c:forEach>
</div>
   
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록 - 교보문고 스타일</title>
<style>
    body { font-family: 'Malgun Gothic', sans-serif; color: #333; }
    .container { width: 900px; margin: 0 auto; }
    .book-item { display: flex; padding: 20px 0; border-bottom: 1px solid #eee; }
    .book-img { width: 150px; height: 220px; object-fit: cover; box-shadow: 2px 2px 5px rgba(0,0,0,0.1); }
    .book-info { flex: 1; margin-left: 30px; }
    .book-title { font-size: 18px; font-weight: bold; color: #000; text-decoration: none; }
    .book-title:hover { text-decoration: underline; }
    .book-meta { margin: 8px 0; color: #666; font-size: 14px; }
    .price-area { margin: 10px 0; }
    .discount { color: #479e10; font-weight: bold; }
    .price { font-size: 16px; font-weight: bold; color: #333; }
    .content-preview { color: #777; font-size: 13px; line-height: 1.5; height: 40px; overflow: hidden; display: -webkit-box; -webkit-line-clamp: 2; -webkit-box-orient: vertical; }
    .rating-area { margin-top: 10px; color: #479e10; font-weight: bold; }
    .rating-star { color: #479e10; }
</style>
</head>
<body>

<div class="container">
    <h2>도서 검색 결과</h2>
    <hr>
    
    <c:forEach var="book" items="${list}">
    <div class="book-item">
        <div class="img-box">
            <a href="${pageContext.request.contextPath}/books/view?id=${book.id}">
                <img src="${book.bookimage}" class="book-img" alt="${book.title}">
            </a>
        </div>
        
        <div class="book-info">
            <a href="${pageContext.request.contextPath}/books/view?id=${book.id}" class="book-title">
                ${book.title}
            </a>
            
            <div class="book-meta">
                ${book.author} · ${book.publisher} · ${book.publictiondate}
            </div>
            
            <div class="price-area">
                <span class="price">
                    <fmt:formatNumber value="${book.price}" type="number"/>원
                </span>
            </div>
            
            <div class="content-preview">
                ${book.content}
            </div>
            
            <div class="rating-area">
                <span class="rating-star">★</span> ${book.rating} 
                <span style="color: #999; font-weight: normal; font-size: 12px;">(추천해요)</span>
            </div>
        </div>
    </div>
</c:forEach>
</div>

</body>
</html>
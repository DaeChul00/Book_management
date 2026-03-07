<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세보기</title>

<style>

body{
    font-family: Arial;
    background:#f5f5f5;
}

.container{
    width:900px;
    margin:auto;
    background:white;
    padding:30px;
    margin-top:50px;
    border-radius:10px;
}

.book-area{
    display:flex;
}

.book-image{
    width:250px;
}

.book-image img{
    width:100%;
}

.book-info{
    margin-left:40px;
    width:100%;
}

table{
    width:100%;
    border-collapse:collapse;
}

td{
    padding:10px;
    border-bottom:1px solid #ddd;
}

.title{
    font-size:28px;
    font-weight:bold;
}

.price{
    color:#d32f2f;
    font-size:22px;
    font-weight:bold;
}

.rating{
    color:#ffa000;
}

.content{
    margin-top:20px;
    line-height:1.6;
}

</style>

</head>
<body>

<div class="container">

<div class="book-area">

<div class="book-image">
<img src="${book.bookimage}">
</div>

<div class="book-info">

<div class="title">${book.title}</div>

<table>

<tr>
<td width="120"><b>ISBN</b></td>
<td>${book.isbn}</td>
</tr>

<tr>
<td><b>저자</b></td>
<td>${book.author}</td>
</tr>

<tr>
<td><b>출판사</b></td>
<td>${book.publisher}</td>
</tr>

<tr>
<td><b>출판일</b></td>
<td>${book.publictiondate}</td>
</tr>

<tr>
<td><b>가격</b></td>
<td class="price">${book.price} 원</td>
</tr>

<tr>
<td><b>평점</b></td>
<td class="rating">⭐ ${book.rating}</td>
</tr>

</table>

<div class="content">
<h3>책 소개</h3>
<p>${book.content}</p>
</div>

</div>

</div>

</div>

</body>
</html>
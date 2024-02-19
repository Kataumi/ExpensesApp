<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>家計簿アプリ　検索画面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
          crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="CSS/search.css">
    
</head>
<body>
<p>検索したいワードを入力してください</p>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <form action="GetSearch" method="post" class="d-flex align-items-end">
                <div class="me-3">
                    <label for="id" class="form-label">IDで検索する</label>
                    <input type="text" class="form-control" id="id" name="id">
                </div>
                <input type="hidden" name="user_id" value="${user_id}">
                <button type="submit" class="btn btn-primary">検索する</button>
            </form>
        </div>
    </div>

    <div class="row justify-content-center mt-4">
        <div class="col-md-6">
            <form action="GetSearch" method="post" class="d-flex align-items-end">
                <div class="me-3">
                    <label for="day" class="form-label">日付で検索する</label>
                    <input type="date" class="form-control" id="day" name="day">
                </div>
                <input type="hidden" name="user_id" value="${user_id}">
                <button type="submit" class="btn btn-primary">検索する</button>
            </form>
        </div>
    </div>

    <div class="row justify-content-center mt-4">
        <div class="col-md-6">
            <form action="GetSearch" method="post" class="d-flex align-items-end">
                <div class="me-3">
                    <label for="purpose" class="form-label">用途で検索する</label>
                    <input type="text" class="form-control" id="purpose" name="purpose">
                </div>
                <input type="hidden" name="user_id" value="${user_id}">
                <button type="submit" class="btn btn-primary">検索する</button>
            </form>
        </div>
    </div>

    <div class="row justify-content-center mt-4">
        <div class="col-md-6">
            <form action="GetSearch" method="post" class="d-flex align-items-end">
                <div class="me-3">
                    <label for="price" class="form-label">金額で検索する</label>
                    <input type="text" class="form-control" id="price" name="price">
                </div>
                <input type="hidden" name="user_id" value="${user_id}">
                <button type="submit" class="btn btn-primary">検索する</button>
            </form>
        </div>
    </div>

    <div class="row justify-content-center mt-4">
        <div class="col-md-6">
            <a href=ToMain class="btn btn-primary">メイン画面へ戻る</a>
        </div>
    </div>
</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Despesa</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cabin:wght@500&family=Heebo:wght@300&family=Kanit:wght@300&family=Nunito:wght@500&family=Open+Sans:wght@300;500&family=Poppins:wght@300&display=swap" rel="stylesheet">

    <!-- Font-Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <!-- Minha CSS -->
    <link rel="stylesheet" href="./assets/CSS/styles.css">  
</head>
<body>
    <header class="container mt-3 mb-5">
        <nav class="navbar navbar-expand-lg">
            <div class="container">
                <a class="navbar-brand logo-text" href="./index.html">
                    G-Wallet</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa-solid fa-align-right"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="./contas.html">Minhas Contas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./ganhos.html">Ganhos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./despesa.html">Despesas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./relatorios.html">Relatórios </a>
                        </li>
                        
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="add container mt-5">
        <h1 class="mb-4">Adicionar Despesa</h1>

        <form>
            <div class="form-group">
                <label for="conta">Conta:</label>
                <select class="form-control" id="conta">
                    <option value="">Selecione uma conta</option>
                    <option value="contaCorrente">Conta Corrente</option>
                    <option value="cartaoCredito">Cartão de Crédito</option>
                    <option value="poupanca">Poupança</option>
                    <option value="Investimentos">Investimentos</option>
                    </select>
            </div>

            <div class="form-group">
                <label for="categoria">Categoria:</label>
                <select class="form-control" id="categoria">
                    <option value="">Selecione uma categoria</option>
                    <option value="alimentacao">Alimentação</option>
                    <option value="transporte">Transporte</option>
                    <option value="moradia">Moradia</option>
                    <option value="lazer">Lazer</option>
                    <option value="outras">Outras</option>
                </select>
            </div>

            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <input type="text" class="form-control" id="descricao" placeholder="Ex: Supermercado">
            </div>

            <div class="form-group">
                <label for="valor">Valor:</label>
                <input type="number" class="form-control" id="valor" placeholder="Ex: 150.00">
            </div>

            <div class="form-group">
                <label for="data">Data:</label>
                <input type="date" class="form-control" id="data">
            </div>

            <button type="submit" class="btn btn-primary">Adicionar Despesa</button>
        </form>

    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
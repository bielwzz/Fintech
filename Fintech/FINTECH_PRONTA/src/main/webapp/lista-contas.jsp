<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>G-Wallet</title> 
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
    <link rel="stylesheet" href="./src/main/webapp/style.css">  

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
  <div class="container mt-5">
    <h1 class="text-center mb-4">Minhas contas</h1>

    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card mb-4">
          <div class="card-header">
            <h5 class="card-title">Adicionar Conta</h5>
          </div>
          <div class="card-body">
            <form id="form-add-account">
              <div class="form-group">
                <label for="nomeConta">Nome da Conta:</label>
                <input type="text" class="form-control" id="nomeConta" placeholder="Digite o nome da conta">
              </div>
              <div class="form-group">
                <label for="tipoConta">Tipo de Conta:</label>
                <input type="text" class="form-control" id="nomeConta" placeholder="Digite o nome da conta">
              </div>
              <div class="form-group">
                <label for="saldoInicial">Saldo Inicial:</label>
                <input type="number" class="form-control" id="saldoInicial" placeholder="Digite o saldo inicial">
              </div>
              <button type="submit" class="btn btn-primary">Adicionar Conta</button>
            </form>
          </div>
        </div>

        <div class="card">
          <div class="card-header">
            <h5 class="card-title">Contas Existentes</h5>
          </div>
          <div class="card-body">
            <table class="table table-striped" id="accounts-table">
              <thead>
                <tr>
                  <th>Nome da Conta</th>
                  <th>Tipo</th>
                  <th>Saldo Inicial</th>
                  <th>Ações</th>
                </tr>
              </thead>
              <tbody>
                <!-- Contas serão adicionadas aqui dinamicamente -->
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script>
    let accounts = [];

    function addAccount(nomeConta, tipoConta, saldoInicial) {
      accounts.push({
        nome: nomeConta,
        tipo: tipoConta,
        saldo: saldoInicial
      });
      renderAccounts();
    }

    function renderAccounts() {
      const accountsTableBody = $('#accounts-table tbody');
      accountsTableBody.empty();

      accounts.forEach((account, index) => {
        const row = `
          <tr>
            <td>${account.nome}</td>
            <td>${account.tipo}</td>
            <td>${account.saldo}</td>
            <td>
              <button class="btn btn-danger btn-sm" data-account-index="${index}">Excluir</button>
            </td>
          </tr>
        `;
        accountsTableBody.append(row);
      });

      // Adiciona o evento de clique para os botões "Excluir"
      $('.btn-danger').click(function() {
        const accountIndex = $(this).data('accountIndex');
        accounts.splice(accountIndex, 1); // Remove a conta do array
        renderAccounts(); // Atualiza a tabela
      });
    }

    $('#form-add-account').submit(function(event) {
      event.preventDefault();
      const nomeConta = $('#nomeConta').val();
      const tipoConta = $('#tipoConta').val();
      const saldoInicial = $('#saldoInicial').val();
      addAccount(nomeConta, tipoConta, saldoInicial);
    });
  </script>
</body>
</html>

 
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
    <!-- .....Header da página..... -->
    <header class="container mt-3 mb-5">
        <nav class="navbar navbar-expand-lg">
            <div class="container">
                <a class="navbar-brand logo-text" href="#">
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

<!-- .....Saldo..... -->

    <section class="container sobre my-5" id="sobre">
        <div class="row d-flex align-items-center justify-content-between">
            <div class="col-lg-6">
                <h2 class="my-title display-5 my-4">Bem-vindo de volta, Gabriel</h2>
                <h3 class=" conteudo borda saldo mb-4 "> <i class=" eye fa-regular fa-eye"></i> Saldo disponível : R$ 12.000,00    </h3>
            </div> 
        </div>
        <div class="container mt-5">

            <h2 class="mt-5">Meus Lembretes:</h2>
            <div class="lembrete-card" id="lista-lembretes">
            </div>
    
            <button id="btn-adicionar" class="btn btn-primary mb-3" onclick="mostrarFormulario()">Adicionar Lembrete</button>
    
            <form id="form-lembrete" style="display: none;">
                <div class="form-group">
                    <label for="titulo">Título:</label>
                    <input type="text" class="form-control" id="titulo" placeholder="Ex: Cartão de crédito">
                </div>
    
                <div class="lembretes form-group">
                    <label for="descricao">Descrição:</label>
                    <textarea class="form-control" id="descricao" rows="3" placeholder="Ex: Pagar fatura"></textarea>
                </div>
    
                <div class="form-group">
                    <label for="data">Data:</label>
                    <input type="date" class="form-control" id="data">
                </div>
    
                <button type="submit" class="btn btn-primary">Salvar Lembrete</button>
                <button type="button" class="btn btn-secondary" onclick="ocultarFormulario()">Cancelar</button>
            </form>
    
            <hr>
    
            
        </div>
    
        <script>
            let proximoId = 0; // Variável para gerar IDs únicos para os lembretes
    
            document.getElementById('form-lembrete').addEventListener('submit', function(e) {
                e.preventDefault();
    
                const titulo = document.getElementById('titulo').value;
                const descricao = document.getElementById('descricao').value;
                const data = document.getElementById('data').value;
    
                adicionarLembrete(titulo, descricao, data);
            });
    
            function adicionarLembrete(titulo, descricao, data) {
                const listaLembretes = document.getElementById('lista-lembretes');
                const idLembrete = proximoId++;
                const novoLembrete = `
                    <div class="card mb-3" id="lembrete-${idLembrete}">
                        <div class="card-body">
                            <h5 class="card-title">${titulo}</h5>
                            <p class="card-text">${descricao}</p>
                            <p class="card-text"><small class="text-muted">${data}</small></p>
                            <button type="button" class="btn btn-danger btn-sm" onclick="excluirLembrete(${idLembrete})">Excluir</button>
                        </div>
                    </div>
                `;
                listaLembretes.innerHTML += novoLembrete;
    
                document.getElementById('titulo').value = '';
                document.getElementById('descricao').value = '';
                document.getElementById('data').value = '';
            }
    
            function excluirLembrete(id) {
                const lembreteParaExcluir = document.getElementById(`lembrete-${id}`);
                lembreteParaExcluir.remove();
            }
    
            function mostrarFormulario() {
                document.getElementById('form-lembrete').style.display = 'block';
                document.getElementById('btn-adicionar').style.display = 'none';
            }
    
            function ocultarFormulario() {
                document.getElementById('form-lembrete').style.display = 'none';
                document.getElementById('btn-adicionar').style.display = 'block';
            }
    
        </script>
    
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        
    </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>

</html>

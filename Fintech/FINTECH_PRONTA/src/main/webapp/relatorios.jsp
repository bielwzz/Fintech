<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Relatórios Financeiros</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
    <div class="container mt-5">
        <h1 class="mb-4">Relatórios Financeiros</h1>

        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="periodo">Período:</label>
                    <select class="form-control" id="periodo">
                        <option value="semana">Última Semana</option>
                        <option value="mes">Último Mês</option>
                        <option value="ano">Último Ano</option>
                        <option value="personalizado">Personalizado</option>
                    </select>
                </div>

                <div class="form-group" id="dataPersonalizada" style="display: none;">
                    <label for="dataInicial">Data Inicial:</label>
                    <input type="date" class="form-control" id="dataInicial">
                    <label for="dataFinal">Data Final:</label>
                    <input type="date" class="form-control" id="dataFinal">
                </div>

                <button type="button" class="btn btn-primary" onclick="gerarRelatorio()">Gerar Relatório</button>
            </div>
        </div>

        <hr>

        <div class="row mt-4">
            <div class="col-md-6">
                <h2>Despesas</h2>
                <canvas id="graficoDespesas"></canvas>
            </div>
            <div class="col-md-6">
                <h2>Ganhos</h2>
                <canvas id="graficoGanhos"></canvas>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-md-12">
                <h2>Resumo</h2>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Total de Ganhos</th>
                            <th>Total de Despesas</th>
                            <th>Saldo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td id="totalGanhos"></td>
                            <td id="totalDespesas"></td>
                            <td id="saldo"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

    <script>
        const periodoSelect = document.getElementById('periodo');
        const dataPersonalizadaDiv = document.getElementById('dataPersonalizada');

        periodoSelect.addEventListener('change', function() {
            if (this.value === 'personalizado') {
                dataPersonalizadaDiv.style.display = 'block';
            } else {
                dataPersonalizadaDiv.style.display = 'none';
            }
        });

        function gerarRelatorio() {
            // Implemente a lógica para buscar dados de despesas e ganhos
            // com base no período selecionado e gere os gráficos e o resumo
            // usando os dados obtidos.

            // Exemplo de dados (substitua por dados reais):
            const dadosDespesas = [120, 250, 80, 150];
            const dadosGanhos = [300, 400, 280, 350];
            const totalGanhos = dadosGanhos.reduce((a, b) => a + b, 0);
            const totalDespesas = dadosDespesas.reduce((a, b) => a + b, 0);
            const saldo = totalGanhos - totalDespesas;

            // Preencher o resumo:
            document.getElementById('totalGanhos').textContent = `R$ ${totalGanhos.toFixed(2)}`;
            document.getElementById('totalDespesas').textContent = `R$ ${totalDespesas.toFixed(2)}`;
            document.getElementById('saldo').textContent = `R$ ${saldo.toFixed(2)}`;
        }
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
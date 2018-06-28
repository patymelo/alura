<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../template/top.jsp" />
<div class="col-sm-8">
	<div class="panel panel-default">
		<div class="panel-heading">Estatísticas</div>
		<div class="panel-body">
			<div class="container">
				<div class="col-sm-8">
					<a href="<c:url value="/estatisticas/limpar"/>">Limpar</a>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Hit</th>
								<th>Miss</th>
								<th>Conexões</th>
								<th>Qtd transacoes</th>
								<th>sucTsCount</th>
								<th>Qtd Delete</th>
								<th>Qtd Insert</th>
								<th>Qtd Load</th>
								<th>Qtd Update</th>
								<th>Consulta mais demorada</th>
								<th>Tempo da consulta mais demorada</th>
								<th>Qtd hibernate fez consulta 2 nv</th>
								<th>Qtd hibernate n conseguiu consulta 2 nv</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<!-- Hit -->
								<td>${statistics.queryCacheHitCount}</td>
								<!-- Miss -->
								<td>${statistics.queryCacheMissCount}</td>
								<!-- Conexões -->
								<td>${statistics.connectCount}</td>
								<td>${statistics.transactionCount}</td>
								<td>${statistics.successfulTransactionCount}</td>
								<td>${statistics.entityDeleteCount}</td>
								<td>${statistics.entityInsertCount}</td>
								<td>${statistics.entityLoadCount}</td>
								<td>${statistics.entityUpdateCount}</td>
								<!-- retorna a consulta mais demorada  -->
								<td>${statistics.queryExecutionMaxTimeQueryString}</td>
								<!-- retorna o tempo de execução da consulta mais demorada -->
								<td>${statistics.queryExecutionMaxTime}</td>
								<!-- retorna quantas vezes o hibernate conseguiu a informação que queria através do cache -->
								<td>${statistics.secondLevelCacheHitCount}</td>
								<!-- retorna quantas vezes o hibernate teve que ir no banco buscar a informação que queria
								pois ela não estava no cache -->
								<td>${statistics.secondLevelCacheMissCount}</td>			
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<c:import url="../template/down.jsp" />

## Projeto de Algoritimos II - IFPR - Felipe Umeoka
# EDITOR DE TEXTO FUNCIONAL - (DESFAZER/REFAZER)

Construir um editor de texto em modo terminal, no qual o histórico de edições não é uma pilha linear, e sim uma árvore de versões: desfazer e depois editar cria um novo ramo, sem perder o ramo anterior.


### Contexto
Editores como o Vim guardam todas as versões do texto em uma undo tree. Editar, desfazer e editar de novo é um fluxo comum, e uma pilha simples perderia o trabalho descartado. A lista encadeada representa o documento e a árvore representa a história.
### Papel de cada estrutura
| Conteúdo | Uso obrigatório |
| :--------: | :---------------: |
| Lista encadeada | **O documento:** uma lista duplamente encadeada de linhas (ou de blocos de caracteres, como gap buffer encadeado) |
| Árvore | **O histórico:** cada nó é uma edição (ou versão), com o pai sendo a versão anterior e os filhos sendo os ramos alternativos
Ordenação |
| Ordenar | linhas (intervalo ou documento inteiro) diretamente na lista encadeada; ordenar as palavras do texto por frequência (comando stats) |

### Requisitos funcionais
Edição básica: inserir linha, remover linha, substituir texto em uma linha, mover para a linha n, listar o documento com número de linhas.
Desfazer e refazer: undo volta ao nó pai; redo avança para o filho mais recente. Cada operação de edição deve ser registrada como um comando reversível (guarda o suficiente para desfazer e refazer, sem copiar o texto inteiro a cada versão).
Ramificação: desfazer e editar de novo cria um novo filho no nó atual, e o ramo antigo permanece acessível.
Navegação no histórico: comando history, que mostra a árvore no terminal (com indentação), e goto <id>, que restaura o documento em qualquer versão, desfazendo até um ancestral comum e refazendo até o destino.
Busca e substituição: localizar todas as ocorrências de um termo e substituir tudo, como uma única entrada do histórico.
Ordenação: sort <inicio> <fim> [asc|desc] ordena um intervalo de linhas e também deve ser desfazível (dica: guardar a ordem original das linhas afetadas ou a permutação aplicada, e não uma cópia do texto). stats lista as palavras do texto ordenadas por frequência.
Salvar e abrir: gravar o documento em arquivo e gravar o histórico em arquivo separado, para retomar a sessão depois.
Requisitos técnicos
Ordenação sobre lista encadeada deve ser feita sem converter para vetor (merge sort em lista é o caso natural). 
O goto pode desfazer até a raiz e refazer até o destino (solução básica). Encontrar o ancestral comum mais próximo, evitando passos desnecessários, conta como bônus.
Memória do histórico: estimar o custo por edição e compará-lo com a estratégia de guardar cópias completas do texto (apresentado na defesa).
Medições exigidas
Custo de undo, redo e goto em históricos com 100, 1.000 e 10.000 edições.
Tempo de ordenar 1.000, 10.000 e 100.000 linhas em lista encadeada com o algoritmo O(n log n), e comparação com o segundo algoritmo até 10.000 linhas.
Uso de memória do histórico por comandos reversíveis versus cópias completas.
Bônus
Agrupar digitações consecutivas em uma única entrada do histórico (como editores reais fazem).
goto pelo ancestral comum mais próximo, comparando o número de operações com a solução básica (via raiz).
Limite de profundidade do histórico com poda de ramos antigos.
Exportar a árvore de versões em formato visualizável (por exemplo, texto do Graphviz).
Cursor com movimentação por palavra e seleção de trecho.

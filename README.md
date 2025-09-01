<h1 align="center"><strong>Dados da Covid-19 em Sergipe 🦠</strong></h1>

<h2>Trabalho da Disciplina de Programação Orientada a Objetos</h2>

<h2><strong>ℹ️ - Descrição do tema do trabalho</strong></h2>

<h4>&emsp;&emsp;&emsp;Este projeto objetiva fazer uma interface que promova a visulização dos dados de impacto da covid-19 em Sergipe durante todo período epidemiológico, tendo sido construídas duas interfaces de mesmo propósito nas linguagens Java e Python, apresentando o panorama desses Dados de forma visual na interface de usuário, que pretende ser visualmente amigável e de fácil uso.</h4>

<h2><strong>Desenvolvido por: Daniel Farani de Farias </strong></h2>

<h2><strong>Repositório disponível em: https://github.com/danielfaranidcomp/Analise-COVID19-POO.git </strong></h2>

<h1><strong>📌 - Sobre o desenvolvimento: </strong></h1>

<h4>&emsp;&emsp; O projeto da interface foi desenvolvido nas linguagens Java e Python, com o auxílio da plataforma JavaFX em Java e do Scene Builder para construção dos elementos gráficos, e com a biblioteca PyQT em Python, utilizando o QT Designer para visualização dos elementos gráficos em desenvolvimento.</h4>
<h4>&emsp;&emsp; Em Java, foi construído DB_Obitos_Casos para percorrer os dados em formato csv (separados por vírgulas) e retornar as informações dos dados de casos, óbitos separados por semana e por ano para que pudesse ser utilizado na plotagem desses valores. Além disso, foi também realizada a programção dos botões e caixas de seleção, todas estas criadas na classe PrimaryController, que a partir da referenciação de elementos do fxml do projeto, consegue ligar a programação dos eventos à página propriamente dit.</h4>
<h4>&emsp;&emsp; Para o caso de Python, semelhantemente ao que foi desenvolvido em Java, foi criada umaa classe para a extração das informaçõs dos dados que seriam utilizados pelos gráficos da interface, chamada de DbObitosCasos, fazendo retornar apenas os dados já tratados para que fosse mais fácil atribuí-los aos eixos gráficos, a partir dos IDs dos widgets da interface que constam no arquivo janela.py. Dessa forma, semelhante à classe controladora em Java citada, utilizei a classe Main para inicializar a interface e carregar is recursos visuais, como gráficos e outros.</h4>
<h4>&emsp;&emsp; Portanto, durante todo o projeto de ambas as interfaces foi buscado aproximar ao máximo as funcionalidades programadas em uma linguagem na outra, para que a experiência ao utilizar quaisquer das interfaces não fosse balada pela linguagem utilizada no desenvolvimento destas, assim atingindo o propósito do projeto.</h4>

<h2 align="center"><strong> ⬇️Discussão sobre Orientação a Objetos em Python e principais diferenças com⬇️ a linguagem Java</strong></h2>

<h4>&emsp;&emsp; Como linguagem mundialmente utilizada para diversos propósitos, Python abarca uma vasta gama de paradigmas, entre eles a da Orientação a Objetos. Como linguagem orientada a objetos, python adimite herança entre classes, podendo possuir herança múltipla sem problemas de ambiguidade de herança de métodos, motivo pelo qual linguagens como Java não permitem herança múltipla, problema conhecido como Problema do Diamante. Outro aspecto relevante de OO é que em Python, diferente do que acontece em Java ou em C++, não é permitida a sobrecarga de métodos, fazendo com que o último método definido sobrescreva o anterior, pois o interpretador não leva em conta a diferença da quantidade de parâmetros.</h4>
<h4>&emsp;&emsp; Por fim, o objeto, aspecto fundamental da Orientação a Objetos, é tido em Python como tipo fundamental da linguagem, pois praticamente todos os tipos de dados são tratados como objetos, possuindo um valor, classe e identificadores únicos.</h4>

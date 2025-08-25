# Gestão de Clube de Leitura

Modele um sistema para um clube de leitura. O clube possui membros, encontros e livros discutidos. Cada encontro tem uma data, um livro e uma lista de membros presentes. Implemente funcionalidades para registrar encontros, listar membros presentes em cada encontro e livros discutidos pelo clube.

Oque já possui: Camada de modelo; Telas funcionais e conceitos de: Login e perfil, Cadastrar membro, Cadastrar livro, Marcar encontro, Se inscrever em encontros, Editar meus encontros, Visualizar lista de inscritos, Visualizar encontros em que se cadastrou.  

to-do

1 - Adicionar validações ao armazenar dados (CPF como atributo único; Impossibilidade de cadastrar encontros em datas que já passaram; etc), acredito que estas validações não devem ser de responsabilidade dos atuais controllers de telas.

2 - Conceito de encontro agendado e encontro ocorrido (minuta e participantes).

3 - Visuais pelo css.

4 - Tela de debug.

5 - Melhor visualização dos dados.

6 - Oque é ObservableList, e como concertar os problemas relacionados à ele, "objetos" do JAVAFX trabalham com observableList, porém minhas listas são do tipo List<Classe>, oque causa problemas em tentativas de interações entre eles, dificulta uso de ListView.

6.1 - Trocar ChoiceBox por ListView (Encontro em aberto, Meus Encontros).

```shell
.\mvnw
```

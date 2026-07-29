# Clínica Veterinária — Sistema de Gerenciamento (Java)

Sistema de gerenciamento de clínica veterinária desenvolvido em Java, rodando via terminal. Projeto criado como exercício prático de Orientação a Objetos, aplicando os conceitos desde a modelagem das entidades até a camada de serviço e a interação com o usuário.

## Funcionalidades

O sistema permite:

- Cadastrar donos, com validação de CPF duplicado
- Cadastrar animais (cachorro, gato ou pássaro) vinculados a um dono existente
- Listar todos os animais de um dono
- Cadastrar veterinários
- Registrar consultas, associando um animal e um veterinário
- Consultar o histórico completo de consultas de um animal
- Remover um animal do cadastro de um dono

Todas as operações acontecem através de um menu interativo no terminal, que permanece em execução até o usuário optar por sair.

## Conceitos de POO aplicados

- **Herança**: `Pessoa` e `Animal` são classes abstratas, servindo de base para `Dono`/`Veterinario` e `Cachorro`/`Gato`/`Passaro`, respectivamente
- **Classes abstratas e métodos abstratos**: `exibirInfo()` (em `Pessoa`) e `emitirSom()` (em `Animal`) obrigam cada subclasse a fornecer sua própria implementação
- **Interfaces**: `Exibivel` formaliza o contrato de exibição de informações, implementado por `Dono` e `Veterinario`
- **Encapsulamento**: todos os atributos são privados, acessados via getters e setters, com validação de dados nos setters
- **Fail-fast com exceções**: setters e regras de negócio lançam `IllegalArgumentException` ao receber dados inválidos, interrompendo a criação de objetos inconsistentes, em vez de apenas exibir um aviso
- **Injeção de dependência**: as classes de serviço (`AnimalService`, `ConsultasService`) recebem outras classes de serviço via construtor, evitando duplicação de estado
- **Composição sobre entidades relacionadas**: `Consulta` referencia um objeto `Veterinario` (não uma cópia de dados), e `Animal` mantém uma lista própria de `Consulta` como histórico

## Estrutura de pacotes

```
src/
├── modelos/
│   ├── Pessoa.java        (abstrata)
│   ├── Dono.java
│   ├── Veterinario.java
│   ├── Animal.java        (abstrata)
│   ├── Cachorro.java
│   ├── Gato.java
│   ├── Passaro.java
│   ├── Consulta.java
│   └── Exibivel.java       (interface)
├── funcionalidades/
│   ├── DonoService.java
│   ├── AnimalService.java
│   ├── VeterinarioService.java
│   └── ConsultasService.java
└── execucao/
    └── Main.java           (menu interativo)
```

- **modelos**: representam as entidades do domínio. Sabem validar a si mesmas, mas não conhecem o restante do sistema
- **funcionalidades**: contém a lógica de negócio que depende de múltiplos objetos (cadastro com verificação de duplicata, busca, remoção e etc)
- **execucao**: ponto de entrada do programa, responsável apenas por orquestrar o menu e capturar entrada do usuário

## Como rodar

1. Clone o repositório
2. Importe o projeto no Eclipse (ou IDE de sua preferência) como projeto Java existente
3. Execute a classe `Main` (pacote `execucao`)
4. Siga as instruções do menu no terminal

**Observação sobre números decimais:** dependendo da configuração regional do sistema, o `Scanner` pode esperar vírgula em vez de ponto como separador decimal (ex: `15,5` em vez de `15.5`) ao digitar peso ou valores de consulta.

## O que aprendi

Este foi meu primeiro projeto aplicando Orientação a Objetos em Java de forma completa, partindo de uma base em C. Ao longo do desenvolvimento, aprofundei:

- A diferença entre classe e objeto instanciado, e por que a instanciação é necessária
- Construtores, e por que validar dados na criação (fail-fast) é mais seguro do que atribuir atributos livremente depois
- Getters e setters como forma de encapsulamento, e quando um setter simplesmente não deveria existir (ex: CPF imutável)
- Modificadores de acesso (`public`, `private`, `protected`, default) e o impacto de cada um na visibilidade de atributos e métodos
- As palavras-chave `this` (referenciar o próprio objeto, diferenciar atributo de parâmetro) e `super` (chamar o construtor da classe mãe)
- Herança com classes abstratas vs. interfaces, e quando usar cada uma
- Polimorfismo: cada subclasse (`Cachorro`, `Gato`, `Passaro`) implementa `emitirSom()` à sua própria maneira, permitindo tratar objetos diferentes de forma uniforme através do tipo `Animal`
- Tratamento de exceções (`throw`, `try`/`catch`), e a diferença entre um método que retorna `null` e um método que lança exceção ao falhar
- Injeção de dependência entre classes de serviço, evitando que cada classe crie suas próprias instâncias duplicadas de dependências
- Manipulação de datas com `LocalDate` e `DateTimeFormatter`
- Debugging de um erro real de locale do `Scanner` (separador decimal vírgula vs. ponto)
- Fluxo de Git: commits, branches, merge, resolução de `.gitignore`, e boas práticas de versionamento

## Melhorias futuras

- [ ] Adicionar opções no menu para listar todos os donos (`DonoService.listarDonos()`) e todos os veterinários (`VeterinarioService.listarVeterinarios()`) cadastrados, métodos já implementados, mas não expostos no menu
- [ ] Tratar entradas inesperadas do usuário (ex: texto onde se espera um número), envolvendo as leituras do `Scanner` em `try`/`catch` com `InputMismatchException`
- [ ] Persistência de dados (salvar em arquivo ou banco de dados), já que atualmente os dados existem apenas em memória durante a execução
- [ ] Permitir edição de dados já cadastrados (ex: atualizar peso ou idade de um animal)
- [ ] Refatoração de código geral, otimização de estruturas de dados

## Autor

Pedro Lucas — estudante de Sistemas de Informação (UFU)
GitHub: [pedrolucas018](https://github.com/pedrolucas018)

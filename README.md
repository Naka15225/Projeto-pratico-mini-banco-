# Projeto-pratico-mini-banco-
APLICAÇÃO BANCÁRIA VIA LINHA DE COMANDO DESENVOLVIDA EM JAVA PARA PRATICAR MANIPULAÇÃO DE VARIÁVEIS, ESTRUTURAS DE CONTROLE, MÉTODOS E ARRAYS.

# 🏦 MiniBanco - Java CLI

O **MiniBanco** é um projeto de estudo desenvolvido como parte das atividades do curso de Assistente de Desenvolvimento de Aplicativos Computacionais do **Senac**, na Unidade Curricular (UC) de **Lógica de Programação com Java**.

A aplicação simula um sistema bancário simples via linha de comando (CLI), aplicando conceitos práticos como controle de fluxo, validações de saldo e limites, cálculo de taxas e manipulação de histórico de transações.

---

## 🚀 O que o programa faz

O programa interage diretamente com o usuário através do console e oferece as seguintes funcionalidades:

1. **Boas-vindas Personalizadas**: Solicita o nome do usuário no início do programa para personalizar as mensagens durante a sessão.
2. **Menu Interativo**: Exibe um menu de opções dinâmico permitindo escolher a operação desejada.
3. **Depósito**:
   - Valida se o valor inserido é estritamente maior que zero.
   - Atualiza o saldo bancário.
   - Registra a movimentação no extrato.
4. **Saque**:
   - Valida se o valor do saque é maior que zero.
   - Verifica o **Limite de Saque** por operação (máximo de R$ 1.000,00).
   - Aplica uma **Taxa de Saque** fixa de 2% sobre o valor solicitado.
   - Verifica se o saldo é suficiente para cobrir o valor do saque + taxa.
   - Registra a operação com taxa e saldo atualizado no extrato.
5. **Consulta de Saldo**: Exibe o saldo atual de forma formatada (R$).
6. **Extrato Bancário**:
   - Armazena até 50 movimentações no histórico.
   - Exibe a lista ordenada de depósitos e saques realizados durante a execução.
   - Mostra aviso caso nenhuma movimentação tenha sido registrada.
7. **Limpeza de Tela Automática**: Limpa o console ao alternar entre telas (compatível com Windows e Linux/macOS).
8. **Encerramento da Sessão**: Ao sair, o programa exibe automaticamente o extrato final da conta e se despede do usuário pelo nome.

---

## 🛠️ Conceitos Praticados

- **Variáveis e Tipos Primitivos** (`double`, `int`, `boolean`, `String`)
- **Entrada de dados** via `Scanner`
- **Estruturas Condicionais** (`if`, `else if`, `else`)
- **Laços de Repetição** (`while`, `for`)
- **Arrays (Vetores)** para armazenar o histórico do extrato
- **Métodos Void e com Retorno** para organização modular das funções
- **Escopo de Variáveis** e uso de **Constantes** (`static final`)

---

## 📋 Pré-requisitos

- Java Development Kit (JDK) 8 ou superior instalado.

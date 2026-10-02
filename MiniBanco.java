package MiniBanco;
import java.util.Scanner;
public class MiniBanco {

    /*Projeto de Estudo
        Conceitos Praticados:
        Livro: Think Java 2ed
            -Variáveis e tipos primitivos
            -Entrada de dados de Scanner
            -Métodos void e com retorno
            -Condicionais 
            -Interação com FOR
            -Escopo de variáveis

     */

        //CONSTANTES
        static final double LIMITE_SAQUE = 1000.00; //VALOR LIMITE DO SAQUE
        static final double TAXA_SAQUE = 0.02; //TAXA DE SAQUE 2%

        //Método para limpar o console 
        public static void limpaTela() {
        try {
            String sistemaOperacional = System.getProperty("os.name");
            if (sistemaOperacional.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
            } catch (Exception e) {
            // Trata exceções caso o ambiente não suporte o comando
            System.out.println("Erro ao limpar o console.");
            }
        }

        static void exibirExtrato(String[] extrato, int totalLinhas){
            System.out.println("\n==================EXTRATO==================");
            if(totalLinhas == 0){
                System.out.println("\nNenhuma movimentação registrada.");
            }else{
                for(int i = 0; i < totalLinhas; i++){
                    System.out.println(" " + extrato[i]);
                }
            }
            System.out.println("===========================================");
        }

        static int registrar(String[] extrato, int totalLinhas, String linha){
            extrato[totalLinhas] = linha;
            return totalLinhas + 1;
        }
        
        static double calcularTotalSaque(double valor){
            return  valor + (valor * TAXA_SAQUE);
        }

        static boolean saldoSuficiente(double saldo, double valor){
            return saldo >= calcularTotalSaque(valor);
        }

        static boolean debtroDoLimite(double valor){
            return valor <= LIMITE_SAQUE;
        }

        static double sacar(double saldo, double valor){
            return saldo - calcularTotalSaque(valor);
        }

        static void exibirMenu(){
            System.out.println();
            System.out.println();
            System.out.println("=== MINI BANCO ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Ver extrato");
            System.out.println("0 - Sair\n");
            System.out.print("Digite uma das opções: ");
        }

        static  double depositar(double saldo, double valor){
            return saldo + valor;
        }

        static void exibirSaldo(double saldo){
            System.out.printf("Saldo atual: R$%.2f%n", saldo);
        }

        static boolean valorEhValido(double valor){
            return valor > 0;
        }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Objetos para entrada de dados
        double saldo = 0.0; //o saldo inicial é sempre 0
        int    opcao = -1;  //opção do Menu

        String[] extrato = new String[50];
        int totalLinhas = 0;

        //Boas Vindas
        System.out.print("Digite o seu nome: ");
        String nome = input.nextLine();

        // System.out.printf("Olá, %s! Saldo inicial: R$%.2f%n", nome, saldo);

        while (opcao != 0) {

            exibirMenu();
            opcao = input.nextInt();

            if (opcao == 1) {
                //System.out.println("Depositar - em breve");

                System.out.print("Valor à depositar: R$: ");
                double valor = input.nextDouble();
                if (!valorEhValido(valor)) {
                    System.out.println("Valor inválido! Deve ser maior que ZERO!");
                }else{
                    saldo = depositar(saldo, valor);
                    System.out.println("Depósito realizado com sucesso!");
                    exibirSaldo(saldo);
                    totalLinhas = registrar(extrato, totalLinhas, String.format("DEPÓSITO + R$ %.2f -> Saldo: R$ %.2f", valor, saldo));
                }

            }else if (opcao == 2) {
                // System.out.println("Sacar - em breve");

                //FLUXO SACAR
                System.out.print("Valor à sacar: ");
                double valorSaque = input.nextDouble();

                if (!valorEhValido(valorSaque)) {
                    System.out.println("Valor inválido!");                    
                }else if(!debtroDoLimite(valorSaque)){
                    System.out.printf("Limite Excedido. Máximo: R$ %.2f%n", LIMITE_SAQUE);
                }else if (!saldoSuficiente(saldo, valorSaque)) {
                    System.out.printf("Saldo insuficiente. Necessário: R$ %.2f%n", calcularTotalSaque(valorSaque));
                }else{
                    double taxa = valorSaque * TAXA_SAQUE;
                    saldo = sacar(saldo, valorSaque);
                    System.out.printf("Saque realizado. Taxa cobrada: R$ %.2f%n", taxa);
                    exibirSaldo(saldo);
                    totalLinhas = registrar(extrato, totalLinhas, String.format("SAQUE - R$ %.2f -> Saldo: R$%.2f", valorSaque, saldo));
                }
            
            }else if (opcao == 3) {
                limpaTela();
                // System.out.println("Consultar Saldo - em breve");
                System.out.println("==================================");
                exibirSaldo(saldo);
                System.out.println("==================================");
            
            }else if (opcao == 4) {
                limpaTela();
                // System.out.println("Extrato - em breve");
                exibirExtrato(extrato, totalLinhas);
            
            }else if (opcao == 0) {
                limpaTela();
                exibirExtrato(extrato, totalLinhas);
                System.out.println("Até logo " + nome +"!");
            }else{
                System.out.println("Opção Inválida. Tente Novamente.");
            }
            
        }

        input.close();
    }
}

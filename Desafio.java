import java.util.Scanner;

public class Desafio {
    public static String clientName = "Tiago Sales";
    public static String accountType = "Corrente";
    public static double balance = 2000.00;

    public static void main(String[] args) {
      
        showAccountInfo();
        showMenu();

        Scanner reader = new Scanner(System.in); 
        int optionMenu = reader.nextInt();

        while (optionMenu != 4) {
            switch (optionMenu) {
                case 1:
                    showAccountInfo();
                    break;
                case 2:
                    System.out.println("Quanto deseja transferir?\n");
                    double amountTransfer = reader.nextDouble();
                    if (amountTransfer > balance) {
                        System.out.println("Não foi possível realizar a transação. Saldo insuficiente!\n");
                    } else {
                        balance -= amountTransfer;
                        System.out.println("Valor transferido com sucesso!");
                    }
                    break;
                case 3:
                    System.out.println("Qual valor deseja depositar?");
                    double amountDeposit = reader.nextDouble();
                    balance += amountDeposit;
                    System.out.println("Valor depositado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            showMenu();
            optionMenu = reader.nextInt();
        }

        reader.close();
    }

    public static void showAccountInfo() {
        
        String accountInfo = 
        """
            *******************************************

            Nome do Cliente: %s
            Tipo da Conta: %s
            Saldo da Conta: %.2f

            *******************************************
        """;

        System.out.println(String.format(accountInfo, clientName, accountType, balance));
    }

    public static void showMenu() {
        
        String menuString = 
        """
            Qual operação deseja realizar?
            1 - Ver Saldo
            2 - Tranferir
            3 - Depositar
            4 - Sair
        """;

        System.out.println(menuString);
    }    
}
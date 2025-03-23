import java.util.Scanner;

public class CalculadoraDeInvestimentos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String usuario;
        double valorInvestido;
        double rentabilidade;
        int tipoPrazo;
        int tempo = 0;
        double patrimonioAdquirido;
        double patrimonioAdquirido_total;
        boolean aporteMensal;
        double aporteMensal_valor = 0;
        double dividendos = 0;

        System.out.println("""
                Olá, seja bem-vindo(a) ao simulador de Rentabilidade de insvestimentos!
                Como gostaria de ser chamado?
                """);
        usuario = scanner.next();

        System.out.println("Qual o valor investido? R$ ");
        valorInvestido = scanner.nextDouble();

        System.out.println("""
                Qual a rentabilidade do investimento?
                ___________________________________________
                Exemplos:
                1% ao mês, utilize 1
                1,5% ao mês, utilize: 1,5
                2% ao mês, utileza: 2
                ___________________________________________
                """);
        rentabilidade = scanner.nextDouble();

        // convertendo o número em decimal

        rentabilidade = rentabilidade / 100;

        System.out.println("""
                Qual o tipo de prazo:
                ___________________________________________
                1 - Ano(s)
                2 - Meses
                ___________________________________________
                """);
        tipoPrazo = scanner.nextInt();

        // Idependente da escolha do usuario ambas opções ao final será convertida em meses

        if (tipoPrazo == 1) {
            System.out.println("Quantos anos gostaria de simular? ");
            tempo = scanner.nextInt();
            tempo *= 12;
            System.out.println("Prazo definido em anos, ou seja em " + tempo + " meses\n" );
        } else if (tipoPrazo == 2) {
            System.out.println("Quantos meses gostaria de simular? ");
            tempo = scanner.nextInt();
            System.out.println("Prazo definido para " + tempo + " meses\n");
        }

        System.out.println("Sr. " + usuario + ", haverá aportes mensais? true/false");
        aporteMensal = scanner.nextBoolean();
        if (aporteMensal == true) {
            System.out.println("Qual o valor do aporte durante esse tempo?");
                    aporteMensal_valor = scanner.nextDouble();
        };
        aporteMensal_valor *= tempo;
            patrimonioAdquirido = ((aporteMensal_valor + valorInvestido) * rentabilidade) * tempo;
                patrimonioAdquirido_total = patrimonioAdquirido + valorInvestido + aporteMensal_valor;
            dividendos = patrimonioAdquirido_total * rentabilidade;


        System.out.println("Sr. " + usuario + " segue os dados da sua rentabilidade:");
        System.out.println("____________________________________________________________________________\n");
        System.out.println("O retorno mensal foi de "+ rentabilidade*100 + " %, ou seja, será de R$ " + dividendos);
        System.out.println("Aporte total mensal: R$ " + aporteMensal_valor);
        System.out.println("Valor +/- adquirido somente com a rentabilidade: R$ " + patrimonioAdquirido);
        System.out.println("Valor total +/- ao fim dos " + tempo + " meses : R$ " + patrimonioAdquirido_total);
        System.out.println("\n____________________________________________________________________________");
    }
    }

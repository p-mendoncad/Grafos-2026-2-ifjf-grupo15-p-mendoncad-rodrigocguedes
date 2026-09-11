import java.util.Scanner;

public class Main {
    private static Grafo grafo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Criar Grafo (1.0 - Pre-cadastro)");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opcao: ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    criarGrafo(scanner);
                    if (grafo != null) {
                        menuGrafo(scanner);
                    }
                    break;
                case "2":
                    executando = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void criarGrafo(Scanner scanner) {
        System.out.println("\n--- Pre-cadastro do Grafo (1.0) ---");
        System.out.println("Direcionamento:");
        System.out.println("1. Nao-direcionado");
        System.out.println("2. Direcionado");
        System.out.print("Escolha: ");
        String opcDir = scanner.nextLine().trim();
        boolean direcionado;
        if (opcDir.equals("2")) {
            direcionado = true;
        } else if (opcDir.equals("1")) {
            direcionado = false;
        } else {
            System.out.println("Opcao invalida. Operacao cancelada.");
            return;
        }

        System.out.println("Ponderacao:");
        System.out.println("1. Nao-ponderado");
        System.out.println("2. Ponderado");
        System.out.print("Escolha: ");
        String opcPond = scanner.nextLine().trim();
        boolean ponderado;
        if (opcPond.equals("2")) {
            ponderado = true;
        } else if (opcPond.equals("1")) {
            ponderado = false;
        } else {
            System.out.println("Opcao invalida. Operacao cancelada.");
            return;
        }

        grafo = new Grafo(direcionado, ponderado);
        System.out.println("Grafo criado com sucesso! ["
                + (direcionado ? "Direcionado" : "Nao-direcionado") + ", "
                + (ponderado ? "Ponderado" : "Nao-ponderado") + "]");
    }

    private static void menuGrafo(Scanner scanner) {
        boolean noMenuGrafo = true;
        while (noMenuGrafo) {
            System.out.println("\n=== SUBMENU DO GRAFO ===");
            System.out.println("0. Retornar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");

            String opcao = scanner.nextLine().trim();
            if (opcao.equals("0")) {
                noMenuGrafo = false;
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

    private static void adicionarVertice(Scanner scanner) {
        System.out.println("\n--- Adicionar Vertice (1.1) ---");
        System.out.print("Identificador do vertice: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("Erro: Identificador nao pode ser vazio.");
            return;
        }

        boolean sucesso = grafo.adicionarVertice(id);
        if (sucesso) {
            System.out.println("Vertice '" + id + "' adicionado com sucesso.");
        } else {
            System.out.println("Erro: Vertice '" + id + "' ja existe no grafo.");
        }
    }

}

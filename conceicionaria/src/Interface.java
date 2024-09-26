import java.util.Scanner;

public class Interface {
    private Concessionaria concessionaria;
    private Scanner scanner;

    public Interface() {
        concessionaria = new Concessionaria();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("----- Concessionária -----");
            System.out.println("1. Adicionar Veículo");
            System.out.println("2. Listar Veículos");
            System.out.println("3. Editar Veículo");
            System.out.println("4. Remover Veículo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    adicionarVeiculo();
                    break;
                case 2:
                    concessionaria.listar();
                    break;
                case 3:
                    editarVeiculo();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private void adicionarVeiculo() {
        System.out.print("Tipo de veículo (1-Carro, 2-Moto): ");
        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Km: ");
        double km = scanner.nextDouble();

        if (tipoVeiculo == 1) {
            System.out.print("Quantidade de portas: ");
            int quantidadePortas = scanner.nextInt();
            Veiculo carro = VeiculoFactory.criarVeiculo(tipoVeiculo, cor, marca, modelo, placa, ano, preco, km, quantidadePortas, null);
            concessionaria.adicionar(carro);
        } else if (tipoVeiculo == 2) {
            System.out.print("Cilindradas: ");
            int cilindradas = scanner.nextInt();
            Veiculo moto = VeiculoFactory.criarVeiculo(tipoVeiculo, cor, marca, modelo, placa, ano, preco, km, null, cilindradas);
            concessionaria.adicionar(moto);
        } else {
            System.out.println("Tipo de veículo inválido.");
        }
    }

    private void editarVeiculo() {
        System.out.print("ID do veículo a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Nova Cor: ");
        String cor = scanner.nextLine();
        System.out.print("Nova Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Novo Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Nova Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Novo Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Novo Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Novo Km: ");
        double km = scanner.nextDouble();

        System.out.print("Tipo de veículo (1-Carro, 2-Moto): ");
        int tipoVeiculo = scanner.nextInt();
        Integer quantidadePortas = null, cilindradas = null;

        if (tipoVeiculo == 1) {
            System.out.print("Quantidade de portas: ");
            quantidadePortas = scanner.nextInt();
        } else if (tipoVeiculo == 2) {
            System.out.print("Cilindradas: ");
            cilindradas = scanner.nextInt();
        }

        concessionaria.editar(id, cor, marca, modelo, placa, ano, preco, km, quantidadePortas, cilindradas);
    }

    private void removerVeiculo() {
        System.out.print("ID do veículo a ser removido: ");
        int id = scanner.nextInt();
        concessionaria.remover(id);
    }

    public static void main(String[] args) {
        Interface interfaceConcessionaria = new Interface();
        interfaceConcessionaria.iniciar();
    }
}


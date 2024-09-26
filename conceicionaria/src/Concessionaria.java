import java.util.ArrayList;
import java.util.List;

public class Concessionaria {
    private List<Veiculo> veiculos;

    public Concessionaria() {
        this.veiculos = new ArrayList<>();
    }

    public void adicionar(Veiculo veiculo) {
        veiculos.add(veiculo);
        System.out.println("Veículo adicionado com sucesso!");
    }

    public void listar() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo disponível.");
            return;
        }
        for (Veiculo veiculo : veiculos) {
            veiculo.getDetalhes();
            System.out.println("-------------------------");
        }
    }

    public void editar(int id, String cor, String marca, String modelo, String placa, int ano, double preco, double km, Integer quantidadePortas, Integer cilindradas) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getId() == id) {
                // Atualiza os detalhes do veículo
                if (veiculo instanceof Carro) {
                    ((Carro) veiculo).setCor(cor);
                    ((Carro) veiculo).setMarca(marca);
                    ((Carro) veiculo).setModelo(modelo);
                    ((Carro) veiculo).setPlaca(placa);
                    ((Carro) veiculo).setAno(ano);
                    ((Carro) veiculo).setPreço(preco);
                    ((Carro) veiculo).setKm(km);
                    ((Carro) veiculo).setQuantidadePortas(quantidadePortas);
                } else if (veiculo instanceof Moto) {
                    ((Moto) veiculo).setCor(cor);
                    ((Moto) veiculo).setMarca(marca);
                    ((Moto) veiculo).setModelo(modelo);
                    ((Moto) veiculo).setPlaca(placa);
                    ((Moto) veiculo).setAno(ano);
                    ((Moto) veiculo).setPreço(preco);
                    ((Moto) veiculo).setKm(km);
                    ((Moto) veiculo).setCilindradas(cilindradas);
                }
                System.out.println("Veículo editado com sucesso!");
                return;
            }
        }
        System.out.println("Veículo não encontrado com o ID: " + id);
    }

    public void remover(int id) {
        Veiculo veiculoParaRemover = null;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getId() == id) {
                veiculoParaRemover = veiculo;
                break;
            }
        }
        if (veiculoParaRemover != null) {
            veiculos.remove(veiculoParaRemover);
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Veículo não encontrado com o ID: " + id);
        }
    }
}

   
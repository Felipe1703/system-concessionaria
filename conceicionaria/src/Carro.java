public class Carro extends Veiculo {
    private int quantidadePortas;
    public Carro(int id, String cor, String marca, String modelo, String placa, int ano, double preco, double km, int quantidadePortas) {
        super(id, cor, marca, modelo, placa, ano,preco,km);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }


    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public void getDetalhes() {
        System.out.println("Carro: ");  
        System.out.println("Quantidade de portas: " + getQuantidadePortas());
        System.out.println("Cor: " + getCor());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Ano: " + getAno());
        System.out.println("Preço: " + getPreco());
        System.out.println("Km: " + getKm());
    }

}

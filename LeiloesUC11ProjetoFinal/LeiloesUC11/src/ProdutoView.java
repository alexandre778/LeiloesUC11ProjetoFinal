import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoView {

    private JTable vendidosTable;
    private DefaultTableModel modelo;

    public ProdutoView() {
        // Criando o modelo da tabela com os nomes das colunas
        String[] colunas = {"ID", "Nome", "Valor", "Status"};
        modelo = new DefaultTableModel(colunas, 0);

        // Criando a JTable com o modelo
        vendidosTable = new JTable(modelo);
        
        // Criando um painel para a JTable com um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(vendidosTable);

        // Criando a janela para exibir a JTable
        JFrame frame = new JFrame("Produtos Vendidos");
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);  // Adiciona a tabela ao painel
        frame.setSize(600, 400);  // Tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Método para listar os produtos vendidos e adicionar na JTable
    public void listarprodutosvendidos() {
        // Supondo que você tenha uma instância de ProdutosDAO para acessar os dados
        ProdutosDAO produtosDAO = new ProdutosDAO();
        
        // Chama o método listarProdutosVendidos para obter a lista de produtos vendidos
        ArrayList<ProdutosDTO> produtos = produtosDAO.listarProdutosVendidos();
        
        // Limpa a tabela antes de adicionar novos dados
        modelo.setRowCount(0);

        try {
            // Para cada linha de produto, adicione a linha na tabela
            for (ProdutosDTO linha : produtos) {
                
            }
        } catch (Exception e) {
            e.printStackTrace();  // Exibe o stack trace em caso de erro
        }
    }

    public static void main(String[] args) {
        ProdutoView view = new ProdutoView();
        view.listarprodutosvendidos();  // Chama o método para preencher a tabela com os dados
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TelaProdutosVendidos extends JFrame {

    private JTable tabelaProdutos;
    private ProdutosDAO produtosDAO;
    private JButton btnVoltar;  // Botão Voltar

    public TelaProdutosVendidos() {
        produtosDAO = new ProdutosDAO(); // Instancia a classe DAO

        setTitle("Produtos Vendidos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar a tabela com cabeçalhos
        String[] colunas = {"ID", "Nome", "Valor", "Status"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        tabelaProdutos = new JTable(model);

        // Adiciona a tabela ao scroll pane
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        add(scrollPane, BorderLayout.CENTER);

        // Adicionar o botão "Voltar"
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> voltarParaListagem()); // Ação do botão

        // Adiciona o botão "Voltar" ao painel inferior
        JPanel painelBotao = new JPanel();
        painelBotao.add(btnVoltar);
        add(painelBotao, BorderLayout.SOUTH);

        // Carregar os dados de produtos vendidos
        carregarProdutosVendidos();

        setVisible(true);
    }

    // Método para carregar produtos vendidos na tabela
    private void carregarProdutosVendidos() {
        ArrayList<ProdutosDTO> produtos = produtosDAO.listarProdutosVendidos();

        DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
        model.setRowCount(0);  // Limpa a tabela antes de adicionar os novos dados

        for (ProdutosDTO produto : produtos) {
            model.addRow(new Object[]{
                    produto.getId(),
                    produto.getNome(),
                    produto.getValor(),
                    produto.getStatus()
            });
        }
    }

    // Método para voltar para a tela de listagem de produtos
    private void voltarParaListagem() {
        this.dispose(); // Fecha a janela atual (TelaProdutosVendidos)
        
        // Cria uma nova instância da tela listagemVIEW
        new listagemVIEW();
    }

    public static void main(String[] args) {
        // Executar a interface gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaProdutosVendidos();
            }
        });
    }
}

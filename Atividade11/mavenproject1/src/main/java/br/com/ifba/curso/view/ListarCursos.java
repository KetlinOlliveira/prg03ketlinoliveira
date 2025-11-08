/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.curso.view;
import br.com.ifba.curso.dao.CursoDAO;
import br.com.ifba.curso.entity.Curso;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane; 
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author ketli
 */
public class ListarCursos extends javax.swing.JFrame {

    private final CursoDAO cursoDAO = new CursoDAO(); // Instância do DAO para acesso ao banco
    
    private JPanel painelPrincipal;
    private JTable tabelaCursos;
    private DefaultTableModel modeloTabela;
    private JTextField campoBusca;
    private JButton botaoAdicionar;
    private JButton botaoHome;
    private JButton lupa;
    private JScrollPane scrollPane;

  
    public ListarCursos() {
        // Configurações básicas da janela
        setTitle("Listagem de Cursos - CRUD");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Inicializa o painel principal com BorderLayout
        painelPrincipal = new JPanel(new BorderLayout());

        // Cria e adiciona os painéis
        criarPainelTopo();
        criarTabela();
        
        // Adiciona a tabela ao painel principal
        scrollPane = new JScrollPane(tabelaCursos);
        painelPrincipal.add(scrollPane, BorderLayout.CENTER);

        add(painelPrincipal);

        // chama a recarga inicial
        recarregarTabela(); 
        
        setVisible(true);
    }

    private void criarPainelTopo() {
        JPanel painelBusca = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // Ajuste o layout do painel superior para acomodar todos os elementos
        JPanel painelTopo = new JPanel(new BorderLayout());

        campoBusca = new JTextField("Procurar...", 25);
        JButton lupa = new JButton("🔍"); // Simula ícone de busca
        
        // Adiciona busca e lupa no painel esquerdo do topo
        painelBusca.add(campoBusca);
        painelBusca.add(lupa);

        // Botões Adicionar e Home/Homescreen
        botaoAdicionar = new JButton("➕ Cadastrar Novo Curso");
        botaoHome = new JButton("Homescreen");

        JPanel painelBotoesAcao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotoesAcao.add(botaoAdicionar);
        painelBotoesAcao.add(botaoHome);
        
        painelTopo.add(painelBusca, BorderLayout.WEST);
        painelTopo.add(painelBotoesAcao, BorderLayout.EAST);
        
        painelPrincipal.add(painelTopo, BorderLayout.NORTH);
        
        adicionarAcoesTopo();
    }
    
    private void criarTabela() {
        String[] colunas = {"ID", "NOME", "QUANTIDADE", "DESCRIÇÃO", "FORNECEDOR", "REMOVER", "EDITAR"};
        
        // Cria o modelo da tabela sem dados iniciais (vazio)
        modeloTabela = new DefaultTableModel(null, colunas) {
             // Impede a edição direta das células, exceto talvez as colunas de ação
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5 || column == 6; // Permite cliques nas colunas REMOVER e EDITAR
            }
        };
        
        tabelaCursos = new JTable(modeloTabela);
        // Ajusta a largura das colunas de ID e Ação
        tabelaCursos.getColumnModel().getColumn(0).setMaxWidth(40); 
        tabelaCursos.getColumnModel().getColumn(5).setMaxWidth(80); 
        tabelaCursos.getColumnModel().getColumn(6).setMaxWidth(80); 
        
        adicionarAcoesTabela();
    }

    // Método principal para carregar os dados
    public void recarregarTabela() {
        // Limpa todas as linhas existentes
        modeloTabela.setRowCount(0); 

        try {
            // Busca todos os cursos do banco usando o DAO
            List<Curso> listaCursos = cursoDAO.listarTodos();
            
            // Adiciona cada curso como uma nova linha
            for (Curso curso : listaCursos) {
                modeloTabela.addRow(new Object[]{
                    curso.getId(),
                    curso.getNome(),
                    curso.getQuantidade(),
                    curso.getDescricao(),
                    curso.getFornecedor(),
                    "🗑️ Remover", 
                    "✏️ Editar" 
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao carregar dados do banco. Verifique a conexão e o persistence.xml.", 
                "Erro de Listagem", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void adicionarAcoesTopo() {
        // Ação para abrir a tela de cadastro
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de Cadastro/Edição, passando esta instância (this) para o callback
                TelaPrincipal telaCadastro = new TelaPrincipal(ListarCursos.this);
                telaCadastro.setVisible(true);
            }
        });
        lupa = new javax.swing.JButton("Buscar");
        // Ação para simular a busca
        // A busca é o RETRIEVE com filtro, no momento apenas simula
        lupa.addActionListener(e -> JOptionPane.showMessageDialog(this, "Lógica de Busca não implementada."));
    }
    
    private void adicionarAcoesTabela() {
        // Lógica para capturar o clique nas colunas REMOVER e EDITAR
        tabelaCursos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int coluna = tabelaCursos.columnAtPoint(evt.getPoint());
                int linha = tabelaCursos.rowAtPoint(evt.getPoint());
                
                if (linha < 0) return; // Garante que uma linha válida foi clicada
                
                // Pega o ID para identificar o curso no banco
                Long idCurso = (Long) modeloTabela.getValueAt(linha, 0); 
                String nomeCurso = (String) modeloTabela.getValueAt(linha, 1);
                
                // Coluna REMOVER (índice 5)
                if (coluna == 5) { 
                    int resposta = JOptionPane.showConfirmDialog(ListarCursos.this, 
                        "Deseja excluir o curso '" + nomeCurso + "' (ID: " + idCurso + ")?", 
                        "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
                    
                    if (resposta == JOptionPane.YES_OPTION) {
                        // cursoDAO.deletar(idCurso);
                        JOptionPane.showMessageDialog(ListarCursos.this, 
                            "Simulação: Lógica de Exclusão para ID " + idCurso + " a ser implementada.");
                        
                    }
                }
                
                // Coluna EDITAR (índice 6)
                if (coluna == 6) { 
                   
                    JOptionPane.showMessageDialog(ListarCursos.this, 
                        "Simulação: Abrir Tela de Edição para o curso '" + nomeCurso + "'.");
                   
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    javax.swing.SwingUtilities.invokeLater(() -> new ListarCursos());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

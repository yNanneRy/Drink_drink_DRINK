/*
Boas vindas ao código-fonte do jogo Drink, drink, DRINK! Esse código foi estruturado
e comentado para a melhor compreensão de todos. Então, se divirta ao ler!

By: Renan Alves.
*/

// Todas as importações que o projeto usa.
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Tudo começa aqui, e é aqui que o código lógico está.
public class Drinkk extends javax.swing.JFrame {

    Sons sons = new Sons();
    
    // CONSTRUTOR.
    public Drinkk() {
        
        // Inicializa todos os componentes das telas.
        initComponents();
        
        // Após inicializar os componentes, são feitas configurações com eles a
        // partir desse método:
        inicializaComponentesPersonalizados();
    }
    
    ////////////////////// VARIÁVEIS //////////////////////////////////////////
    // Cada variável tem um propósito durante a execução do código, que será explicado.
    
    String[] args;
    int contadorSusSor = 0;
    int contadorSusSor1 = 0;
    
    // Variáveis para a alocação de colocados
    ArrayList<Colocados> colocacao = new ArrayList<>();
    int contadorjogadores = 0;
    int contadorcolocado = 0;
    String nome1;
    int ponto1;
    String nome2;
    int ponto2;
    String nome3;
    int ponto3;
    String nome4;
    int ponto4;
    String nome5;
    int ponto5;
    String nome6;
    int ponto6;
    String nome7;
    int ponto7;
    String nome8;
    int ponto8;
    String nome9;
    int ponto9;
    String nome10;
    int ponto10;
    String nome11;
    int ponto11;
    String nome12;
    int ponto12;
    
    // Variaveis de alternação de cores
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    Color color = Color.BLACK;
    int cont = 0;
    int contjogofinalizado = 0;
    
    // Fontes usadas na alternância de tamanhos
    Font fonte1 = new Font("Segoe UI", Font.BOLD, 130);
    Font fonte2 = new Font("Segoe UI", Font.BOLD, 110);
    Font fonte3 = new Font("Segoe UI", Font.BOLD, 90);
    Font fonte4 = new Font("Segoe UI", Font.BOLD, 70);
    Font fonte5 = new Font("Segoe UI", Font.BOLD, 55);
    Font fonte6 = new Font("Segoe UI", Font.BOLD, 30);
    Font fonte = new Font("Segoe UI", Font.BOLD, 150);
    
    // LinkedList do tipo STRING que compreende os jogadores no jogo. Seu tamanho é o
    // o número de jogadores que o usuário digitar no menu do jogo.
    LinkedList<String> jogadores = new LinkedList();
    
    // LinkedList do tipo STRING que manterá as perguntas do jogo.
    LinkedList<String> perguntas = new LinkedList();
    
    // LinkedList do tipo STRING que manterá os desafios do jogo.
    LinkedList<String> desafios = new LinkedList();
    
    // LinkedList do tipo JButton que manterá os jogadores.
    LinkedList<JButton> botoesjogadores = new LinkedList();
    
    // LinkedList do tipo JLabel que compreende os Labels de pontuação de cada jogador.
    LinkedList<JLabel> pontuacao = new LinkedList();
    
    // Linked do tipo JButton que manterá os jogadores que não estiverem no jogo.
    LinkedList<JButton> jogadoresNaoAtivos = new LinkedList();
    
    // LinkedList do tipo INTEGER que manterá a pontuação de cada jogador.
    LinkedList<Integer> pontos = new LinkedList(); 
    
    // Variável que manterá o que o jogador escolher.
    int vddoudsf;
    
    // Random comum. Serve para a criação de números aleatórios, a essência do jogo.
    Random random = new Random();
    
    // Variável que guardará o número do jogador sorteado.
    int sorteio;
    
    // Variável que guardará a pergunta ou desafio que será sorteado.
    int sort;
    
    // Variável do tipo JButton que guardará o jogador que for sorteado para a rodada.
    JButton sorteado;
    
    // Variáveis que manterão a pontuação de cada jogador.
    int pontjg1 = 0;
    int pontjg2 = 0;
    int pontjg3 = 0;
    int pontjg4 = 0;
    int pontjg5 = 0;
    int pontjg6 = 0;
    int pontjg7 = 0;
    int pontjg8 = 0;
    int pontjg9 = 0;
    int pontjg10 = 0;
    int pontjg11 = 0;
    int pontjg12 = 0;
    
    // Variável que manterá quantos "shots" o jogador deve beber.
    int qntdbb = 0;
    
    // Booleans que gerenciará os botões entre ativo e inativo enquanto algum outro não
    // for selecionado.
    boolean arregou = false;
    boolean voltar = true;
    boolean adicionar = false;
    
    // Variável temporária que manterá quanto o jogador ganhará ou perderá.
    int pntt;
    
    // Variável que verifica se o sorteio pegou um jogador ativo;
    int flag = 0;

    // Método que configura componentes personalizados.
    public void inicializaComponentesPersonalizados(){
        
        // Componentes que estão na primeira tela, e devem estar não-visiveis até que o jogador aperte em "Iniciar".
        NomeTXT.setVisible(false);
        AdicionarBT.setVisible(false);
        CDNome.setVisible(false);
        ErroTXT.setVisible(false);
        JogadoresTXT.setVisible(false);
        NomeJogadoresTXT.setVisible(false);
        NomeJogadoresTXT1.setVisible(false);
        IniciarJogoBT.setVisible(false);
        
        // Componentes que estão na segunda tela. Estes são aqueles que mostram a pontuação de cada jogador e o jogador em si.
        Jg1pnt.setForeground(Color.black);
        Jg2pnt.setForeground(Color.black);
        Jg3pnt.setForeground(Color.black);
        Jg4pnt.setForeground(Color.black);
        Jg5pnt.setForeground(Color.black);
        Jg6pnt.setForeground(Color.black);
        Jg7pnt.setForeground(Color.black);
        Jg8pnt.setForeground(Color.black);
        Jg9pnt.setForeground(Color.black);
        Jg10pnt.setForeground(Color.black);
        Jg11pnt.setForeground(Color.black);
        Jg12pnt.setForeground(Color.black);
        
        // Componentes da segunda tela que devem ser inicializados de tal forma
        // até que o jogador execute uma ação, como acionar "ARREGOU" ou "ADICIONAR".
        VoltarBT.setEnabled(false);
        AdicionarPlayerTXT.setEditable(false);
        ErroTXT1.setVisible(false);
        
        // Componentes da terceira tela que devem ser inicializados de tal forma
        // até que o jogador execute uma ação, como acionar "VERDADE" ou "DESAFIO"
        txtVddDsf.setVisible(false);
        ConfirmaBT.setVisible(false);
        BeberBT.setVisible(false);
        pontobb.setVisible(false);
        
        // Componentes de COLOCADOS que devem ser inicializados de tal forma.
        ColocadosLABEL.setVisible(false);
        JogoFinalizadoLABEL.setVisible(false);
        primColocadoLABEL.setVisible(false);
        segColocadoLABEL.setVisible(false);
        terColocadoLABEL.setVisible(false);
        quarColocadoLABEL.setVisible(false);
        quinColocadoLABEL.setVisible(false);
        sexColocadoLABEL.setVisible(false);
        setColocadoLABEL.setVisible(false);
        oitColocadoLABEL.setVisible(false);
        nonColocadoLABEL.setVisible(false);
        decColocadoLABEL.setVisible(false);
        dec1ColocadoLABEL.setVisible(false);
        dec2ColocadoLABEL.setVisible(false);
        ENCERRARBT.setVisible(false);
        
        
        // JFRAMES que devem ser obrigatóriamente personalizados. Aqui eles podem
        // ter configurações de tamanho, undecoreted, etc.
        BlackWindow.setExtendedState(MAXIMIZED_BOTH);
        Drink1.setExtendedState(MAXIMIZED_BOTH);
        Drink2.setExtendedState(MAXIMIZED_BOTH);
        Drink3.setExtendedState(MAXIMIZED_BOTH);
        Segundo.getContentPane().setBackground(Color.black);
        Colocados.setExtendedState(MAXIMIZED_BOTH);
        BlackWindow1.setExtendedState(MAXIMIZED_BOTH);
        JOGOFINALIZADO.setExtendedState(MAXIMIZED_BOTH);
        Terceiro.getContentPane().setBackground(Color.black);
        JOGOFINALIZADO.getContentPane().setBackground(Color.black);
        this.getContentPane().setBackground(Color.black);
        BlackWindow1.getContentPane().setBackground(Color.black);
        BlackWindow.getContentPane().setBackground(Color.black);
        Colocados.getContentPane().setBackground(Color.black);
        
        ///////////////////////// LINKED LISTS /////////////////////////////////
        // Todas as LinkedLists aqui foram criadas para o melhor gerenciamento do jogo.
        
        perguntas.add("Já ficou com alguém da roda?");
        perguntas.add("Quem você beijaria dessa roda?");
        perguntas.add("1 ano na cadeia ou para todo o sempre com seu ex?");
        perguntas.add("Prefere saber a data ou causa da sua morte?");
        perguntas.add("Do que você não se orgulha de já ter feito nessa vida?");
        perguntas.add("Seu primeiro beijo teve gosto de quê?");
        perguntas.add("Por que o Zeca Pagodinho toca samba e o Exaltasamba toca pagode?");
        perguntas.add("Pizza se come com ketchup?");
        perguntas.add("Qual é a criatura mais estranha com a qual você se deparou?");
        perguntas.add("Se você pudesse mudar algo em você, o que seria?");
        perguntas.add("Qual foi o sonho mais estranho que você já teve?");
        perguntas.add("Conte um segredo ou uma curiosidade sua");
        perguntas.add("Se hoje fosse o seu último dia de vida, o que você faria?");
        perguntas.add("É verdade que ninguém te chamou para sair nessa semana?");
        perguntas.add("Biscoito ou bolacha? Defenda sua teoria.");
        desafios.add("Fazer o máximo de flexões que você conseguir em 1 minuto.");
        desafios.add("Ficar sem olhar o celular até o final da brincadeira.");
        desafios.add("Escolher uma música para cantar até o final sem errar.");
        desafios.add("Rebolar em um bambolê imaginário.");
        desafios.add("Lamber o cotovelo.");
        desafios.add("Encostar a língua no nariz.");
        desafios.add("Escolher alguém da roda para dançar valsa e dançarem.");
        desafios.add("Fazer uma imitação de algum famoso ou de alguém que está na roda.");
        desafios.add("Passar uma rodada falando com algum sotaque ou em outro idioma.");
        desafios.add("Lute capoeira com alguém da roda.");
        desafios.add("Fique com 1 cubo de gelo no bolso até o final da brincadeira.");
        desafios.add("Simular um pedido de casamento.");
        desafios.add("Falar na língua do 'pê' até o final da rodada.");
        desafios.add("Pronunciar 'farofa' com 1 colher e farofa na boca.");
        desafios.add("Revelar a última mensagem que você mandou no WhatsApp.");
        desafios.add("Receber cócegas de alguém por 1 minuto;");
        desafios.add("Chupar um limão como se fosse uma laranja.");
        desafios.add("Mostre a última foto que você tirou de você mesmo no celular.");
        desafios.add("Dê uma cambalhota.");
        desafios.add("Participar de uma competição de natação imaginária no chão.");
        desafios.add("Penteie o cabelo de alguém da roda.");
        desafios.add("Passe as próximas 2 rodadas imitando um animal.");
        desafios.add("Dançar em cima da mesa.");
        desafios.add("Assistir um vídeo engraçado na internet com a boca cheia de água.");
        desafios.add("Curtir fotos antigas de uma pessoa que você não segue no Instagram.");
        desafios.add("Passe a próxima rodada congelado, como se fosse uma estátua viva.");
        desafios.add("Tente voar.");
        desafios.add("Faça 50 abdominais enquanto o grupo conta.");
        desafios.add("Uive como um lobo.");
        desafios.add("Massagear alguém da roda.");
        desafios.add("Uma rodada fazendo cafuné em alguém da roda.");
        
        // LinkedList que compreende TODOS os jogadores.
        botoesjogadores.add(Jg1);
        botoesjogadores.add(Jg2);
        botoesjogadores.add(Jg3);
        botoesjogadores.add(Jg4);
        botoesjogadores.add(Jg5);
        botoesjogadores.add(Jg6);
        botoesjogadores.add(Jg7);
        botoesjogadores.add(Jg8);
        botoesjogadores.add(Jg9);
        botoesjogadores.add(Jg10);
        botoesjogadores.add(Jg11);
        botoesjogadores.add(Jg12);
        for(int i = 0; i < 12;  i++){
            botoesjogadores.get(i).setEnabled(false);
            botoesjogadores.get(i).setBackground(Color.white);
        }
        
        // LinkedList que compreende TODAS as JLabels de pontuações.
        pontuacao.add(Jg1pnt);
        pontuacao.add(Jg2pnt);
        pontuacao.add(Jg3pnt);
        pontuacao.add(Jg4pnt);
        pontuacao.add(Jg5pnt);
        pontuacao.add(Jg6pnt);
        pontuacao.add(Jg7pnt);
        pontuacao.add(Jg8pnt);
        pontuacao.add(Jg9pnt);
        pontuacao.add(Jg10pnt);
        pontuacao.add(Jg11pnt);
        pontuacao.add(Jg12pnt);
        
        // LinkedList que compreende TODAS as pontuações.
        pontos.add(pontjg1);
        pontos.add(pontjg2);
        pontos.add(pontjg3);
        pontos.add(pontjg4);
        pontos.add(pontjg5);
        pontos.add(pontjg6);
        pontos.add(pontjg7);
        pontos.add(pontjg8);
        pontos.add(pontjg9);
        pontos.add(pontjg10);
        pontos.add(pontjg11);
        pontos.add(pontjg12);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Segundo = new javax.swing.JFrame();
        Jg12 = new javax.swing.JButton();
        Jg2 = new javax.swing.JButton();
        Jg3 = new javax.swing.JButton();
        Jg5 = new javax.swing.JButton();
        Jg1 = new javax.swing.JButton();
        Jg4 = new javax.swing.JButton();
        Jg6 = new javax.swing.JButton();
        Jg7 = new javax.swing.JButton();
        Jg8 = new javax.swing.JButton();
        Jg9 = new javax.swing.JButton();
        Jg10 = new javax.swing.JButton();
        Jg11 = new javax.swing.JButton();
        SortearBT = new javax.swing.JButton();
        Jg1pnt = new javax.swing.JLabel();
        Jg12pnt = new javax.swing.JLabel();
        Jg2pnt = new javax.swing.JLabel();
        Jg3pnt = new javax.swing.JLabel();
        Jg4pnt = new javax.swing.JLabel();
        Jg5pnt = new javax.swing.JLabel();
        Jg6pnt = new javax.swing.JLabel();
        Jg7pnt = new javax.swing.JLabel();
        Jg8pnt = new javax.swing.JLabel();
        Jg9pnt = new javax.swing.JLabel();
        Jg10pnt = new javax.swing.JLabel();
        Jg11pnt = new javax.swing.JLabel();
        ArregouBT = new javax.swing.JButton();
        VoltarBT = new javax.swing.JButton();
        AdicionarJogadorBT = new javax.swing.JButton();
        AdicionarPlayerTXT = new javax.swing.JTextField();
        ErroTXT1 = new javax.swing.JLabel();
        FinalizarJogoBT = new javax.swing.JButton();
        Terceiro = new javax.swing.JFrame();
        JogadorSorteado = new javax.swing.JLabel();
        VerdadeBT = new javax.swing.JButton();
        DesafioBT = new javax.swing.JButton();
        BeberBT = new javax.swing.JButton();
        txtVddDsf = new javax.swing.JLabel();
        pontovdd = new javax.swing.JLabel();
        pontodsf = new javax.swing.JLabel();
        pontobb = new javax.swing.JLabel();
        ConfirmaBT = new javax.swing.JButton();
        OUtxt = new javax.swing.JLabel();
        Drink1 = new javax.swing.JFrame();
        Drink11 = new javax.swing.JButton();
        Drink2 = new javax.swing.JFrame();
        Drink22 = new javax.swing.JButton();
        Drink3 = new javax.swing.JFrame();
        Drink33 = new javax.swing.JButton();
        BlackWindow = new javax.swing.JFrame();
        Colocados = new javax.swing.JFrame();
        JogoFinalizadoLABEL = new javax.swing.JLabel();
        ColocadosLABEL = new javax.swing.JLabel();
        primColocadoLABEL = new javax.swing.JLabel();
        segColocadoLABEL = new javax.swing.JLabel();
        terColocadoLABEL = new javax.swing.JLabel();
        quarColocadoLABEL = new javax.swing.JLabel();
        quinColocadoLABEL = new javax.swing.JLabel();
        sexColocadoLABEL = new javax.swing.JLabel();
        setColocadoLABEL = new javax.swing.JLabel();
        oitColocadoLABEL = new javax.swing.JLabel();
        nonColocadoLABEL = new javax.swing.JLabel();
        decColocadoLABEL = new javax.swing.JLabel();
        dec1ColocadoLABEL = new javax.swing.JLabel();
        dec2ColocadoLABEL = new javax.swing.JLabel();
        ENCERRARBT = new javax.swing.JButton();
        JOGOFINALIZADO = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        BlackWindow1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        IniciarBT = new javax.swing.JButton();
        AjudaBT = new javax.swing.JButton();
        NomeTXT = new javax.swing.JLabel();
        AdicionarBT = new javax.swing.JButton();
        CDNome = new javax.swing.JTextField();
        ErroTXT = new javax.swing.JLabel();
        JogadoresTXT = new javax.swing.JLabel();
        NomeJogadoresTXT = new javax.swing.JLabel();
        IniciarJogoBT = new javax.swing.JButton();
        NomeJogadoresTXT1 = new javax.swing.JLabel();

        Segundo.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Segundo.setTitle("SORTEIO DE JOGADORES\n");
        Segundo.setAlwaysOnTop(true);
        Segundo.setBackground(new java.awt.Color(255, 255, 255));
        Segundo.setLocation(new java.awt.Point(315, 150));
        Segundo.setMinimumSize(new java.awt.Dimension(882, 575));
        Segundo.setName("Segundo"); // NOI18N
        Segundo.setResizable(false);
        Segundo.setSize(new java.awt.Dimension(882, 575));

        Jg12.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg12.setAlignmentY(10.0F);
        Jg12.setBorder(null);
        Jg12.setBorderPainted(false);
        Jg12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Jg12.setFocusPainted(false);
        Jg12.setName("Jg12"); // NOI18N
        Jg12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg12ActionPerformed(evt);
            }
        });

        Jg2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg2.setBorderPainted(false);
        Jg2.setFocusPainted(false);
        Jg2.setName("Jg2"); // NOI18N
        Jg2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg2ActionPerformed(evt);
            }
        });

        Jg3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg3.setBorderPainted(false);
        Jg3.setFocusPainted(false);
        Jg3.setName("Jg3"); // NOI18N
        Jg3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg3ActionPerformed(evt);
            }
        });

        Jg5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg5.setBorderPainted(false);
        Jg5.setFocusPainted(false);
        Jg5.setName("Jg5"); // NOI18N
        Jg5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg5ActionPerformed(evt);
            }
        });

        Jg1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg1.setBorderPainted(false);
        Jg1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Jg1.setFocusPainted(false);
        Jg1.setName("Jg1"); // NOI18N
        Jg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg1ActionPerformed(evt);
            }
        });

        Jg4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg4.setBorderPainted(false);
        Jg4.setFocusPainted(false);
        Jg4.setName("Jg4"); // NOI18N
        Jg4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg4ActionPerformed(evt);
            }
        });

        Jg6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg6.setBorderPainted(false);
        Jg6.setFocusPainted(false);
        Jg6.setName("Jg6"); // NOI18N
        Jg6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg6ActionPerformed(evt);
            }
        });

        Jg7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg7.setBorderPainted(false);
        Jg7.setFocusPainted(false);
        Jg7.setName("Jg7"); // NOI18N
        Jg7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg7ActionPerformed(evt);
            }
        });

        Jg8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg8.setBorderPainted(false);
        Jg8.setFocusPainted(false);
        Jg8.setName("Jg8"); // NOI18N
        Jg8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg8ActionPerformed(evt);
            }
        });

        Jg9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg9.setBorderPainted(false);
        Jg9.setFocusPainted(false);
        Jg9.setName("Jg9"); // NOI18N
        Jg9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg9ActionPerformed(evt);
            }
        });

        Jg10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg10.setBorderPainted(false);
        Jg10.setFocusPainted(false);
        Jg10.setName("Jg10"); // NOI18N
        Jg10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg10ActionPerformed(evt);
            }
        });

        Jg11.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Jg11.setBorderPainted(false);
        Jg11.setFocusPainted(false);
        Jg11.setName("Jg11"); // NOI18N
        Jg11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jg11ActionPerformed(evt);
            }
        });

        SortearBT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SortearBT.setText("SORTEAR");
        SortearBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SortearBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortearBTActionPerformed(evt);
            }
        });

        Jg1pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg1pnt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jg1pnt.setText("0 ponto(s).");
        Jg1pnt.setToolTipText("");

        Jg12pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg12pnt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jg12pnt.setText("0 ponto(s).");
        Jg12pnt.setToolTipText("");
        Jg12pnt.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Jg2pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg2pnt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jg2pnt.setText("0 ponto(s).");
        Jg2pnt.setToolTipText("");
        Jg2pnt.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Jg3pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg3pnt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Jg3pnt.setText("0 ponto(s).");
        Jg3pnt.setToolTipText("");

        Jg4pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg4pnt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jg4pnt.setText("0 ponto(s).");
        Jg4pnt.setToolTipText("");

        Jg5pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg5pnt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jg5pnt.setText("0 ponto(s).");
        Jg5pnt.setToolTipText("");

        Jg6pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg6pnt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Jg6pnt.setText("0 ponto(s).");
        Jg6pnt.setToolTipText("");

        Jg7pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg7pnt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Jg7pnt.setText("0 ponto(s).");
        Jg7pnt.setToolTipText("");
        Jg7pnt.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Jg8pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg8pnt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Jg8pnt.setText("0 ponto(s).");
        Jg8pnt.setToolTipText("");

        Jg9pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg9pnt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Jg9pnt.setText("0 ponto(s).");
        Jg9pnt.setToolTipText("");
        Jg9pnt.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Jg10pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg10pnt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Jg10pnt.setText("0 ponto(s).");
        Jg10pnt.setToolTipText("");
        Jg10pnt.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Jg11pnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jg11pnt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Jg11pnt.setText("0 ponto(s).");
        Jg11pnt.setToolTipText("");
        Jg11pnt.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        ArregouBT.setBackground(new java.awt.Color(255, 0, 0));
        ArregouBT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ArregouBT.setForeground(new java.awt.Color(255, 255, 255));
        ArregouBT.setText("Arregou!");
        ArregouBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ArregouBT.setFocusPainted(false);
        ArregouBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArregouBTActionPerformed(evt);
            }
        });

        VoltarBT.setBackground(new java.awt.Color(51, 255, 0));
        VoltarBT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        VoltarBT.setText("Voltar.");
        VoltarBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VoltarBT.setFocusPainted(false);
        VoltarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBTActionPerformed(evt);
            }
        });

        AdicionarJogadorBT.setBackground(new java.awt.Color(51, 51, 255));
        AdicionarJogadorBT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AdicionarJogadorBT.setForeground(new java.awt.Color(255, 255, 255));
        AdicionarJogadorBT.setText("Adicionar.");
        AdicionarJogadorBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AdicionarJogadorBT.setFocusPainted(false);
        AdicionarJogadorBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarJogadorBTActionPerformed(evt);
            }
        });

        AdicionarPlayerTXT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AdicionarPlayerTXT.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        ErroTXT1.setForeground(new java.awt.Color(255, 51, 51));
        ErroTXT1.setText("Por favor, insira um nome!");

        FinalizarJogoBT.setBackground(new java.awt.Color(0, 0, 0));
        FinalizarJogoBT.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        FinalizarJogoBT.setForeground(new java.awt.Color(255, 255, 255));
        FinalizarJogoBT.setText("Finalizar Jogo.");
        FinalizarJogoBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FinalizarJogoBT.setFocusPainted(false);
        FinalizarJogoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarJogoBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SegundoLayout = new javax.swing.GroupLayout(Segundo.getContentPane());
        Segundo.getContentPane().setLayout(SegundoLayout);
        SegundoLayout.setHorizontalGroup(
            SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SegundoLayout.createSequentialGroup()
                .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SegundoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SegundoLayout.createSequentialGroup()
                                .addComponent(Jg7pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Jg7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SegundoLayout.createSequentialGroup()
                                .addComponent(Jg6pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Jg6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(SegundoLayout.createSequentialGroup()
                        .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SegundoLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(Jg9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Jg9pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SegundoLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(SegundoLayout.createSequentialGroup()
                                        .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ArregouBT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Jg10pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Jg10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(SegundoLayout.createSequentialGroup()
                                        .addComponent(Jg8pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Jg8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SortearBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jg12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SegundoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(AdicionarJogadorBT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdicionarPlayerTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ErroTXT1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SegundoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(Jg12pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155)
                        .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VoltarBT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FinalizarJogoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SegundoLayout.createSequentialGroup()
                            .addComponent(Jg3pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Jg3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SegundoLayout.createSequentialGroup()
                            .addComponent(Jg5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Jg5pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(147, 147, 147))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SegundoLayout.createSequentialGroup()
                            .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(SegundoLayout.createSequentialGroup()
                                    .addComponent(Jg4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Jg4pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(SegundoLayout.createSequentialGroup()
                                    .addComponent(Jg2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Jg2pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)))))
            .addGroup(SegundoLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(Jg11pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Jg11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(Jg1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Jg1pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SegundoLayout.setVerticalGroup(
            SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SegundoLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ArregouBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Jg12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(VoltarBT, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Jg12pnt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SegundoLayout.createSequentialGroup()
                        .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(SegundoLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Jg1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jg11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jg11pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jg10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SegundoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jg1pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Jg2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SegundoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Jg10pnt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jg2pnt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Jg3, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                .addComponent(Jg9, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                .addComponent(SortearBT))
                            .addComponent(Jg9pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SegundoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Jg3pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Jg4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jg8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jg4pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jg8pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SegundoLayout.createSequentialGroup()
                        .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Jg5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jg7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jg7pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(SegundoLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(Jg6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SegundoLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(SegundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AdicionarJogadorBT, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AdicionarPlayerTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SegundoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jg6pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ErroTXT1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(SegundoLayout.createSequentialGroup()
                        .addComponent(Jg5pnt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(FinalizarJogoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        Terceiro.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Terceiro.setTitle("VERDADE OU DESAFIO?");
        Terceiro.setBounds(new java.awt.Rectangle(0, 0, 791, 370));
        Terceiro.setLocation(new java.awt.Point(370, 230));
        Terceiro.setMinimumSize(new java.awt.Dimension(791, 370));
        Terceiro.setName("Terceiro"); // NOI18N
        Terceiro.setResizable(false);
        Terceiro.setSize(new java.awt.Dimension(791, 370));

        JogadorSorteado.setBackground(new java.awt.Color(255, 255, 255));
        JogadorSorteado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JogadorSorteado.setForeground(new java.awt.Color(255, 255, 255));
        JogadorSorteado.setText("Jogador 1 foi sorteado! Jogador 1, verdade ou desafio?");

        VerdadeBT.setBackground(new java.awt.Color(102, 204, 0));
        VerdadeBT.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        VerdadeBT.setText("Verdade");
        VerdadeBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VerdadeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerdadeBTActionPerformed(evt);
            }
        });

        DesafioBT.setBackground(new java.awt.Color(255, 51, 51));
        DesafioBT.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        DesafioBT.setText("Desafio");
        DesafioBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DesafioBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesafioBTActionPerformed(evt);
            }
        });

        BeberBT.setBackground(new java.awt.Color(255, 255, 51));
        BeberBT.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        BeberBT.setText("Beber");
        BeberBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BeberBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeberBTActionPerformed(evt);
            }
        });

        txtVddDsf.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtVddDsf.setForeground(new java.awt.Color(255, 255, 255));
        txtVddDsf.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVddDsf.setText("Teste");
        txtVddDsf.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        txtVddDsf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pontovdd.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        pontovdd.setForeground(new java.awt.Color(51, 204, 0));
        pontovdd.setText("+1 Ponto");

        pontodsf.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        pontodsf.setForeground(new java.awt.Color(102, 204, 0));
        pontodsf.setText("+2 Pontos");

        pontobb.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        pontobb.setForeground(new java.awt.Color(255, 0, 0));
        pontobb.setText("-1 ponto");

        ConfirmaBT.setBackground(new java.awt.Color(102, 153, 255));
        ConfirmaBT.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        ConfirmaBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfirmaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmaBTActionPerformed(evt);
            }
        });

        OUtxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        OUtxt.setForeground(new java.awt.Color(255, 255, 255));
        OUtxt.setText("OU");

        javax.swing.GroupLayout TerceiroLayout = new javax.swing.GroupLayout(Terceiro.getContentPane());
        Terceiro.getContentPane().setLayout(TerceiroLayout);
        TerceiroLayout.setHorizontalGroup(
            TerceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TerceiroLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(TerceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TerceiroLayout.createSequentialGroup()
                        .addGroup(TerceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JogadorSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TerceiroLayout.createSequentialGroup()
                                .addComponent(txtVddDsf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ConfirmaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(TerceiroLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(VerdadeBT, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pontovdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OUtxt)
                        .addGap(72, 72, 72)
                        .addComponent(DesafioBT, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pontodsf)
                        .addGap(84, 84, 84))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TerceiroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BeberBT, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pontobb, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254))
        );
        TerceiroLayout.setVerticalGroup(
            TerceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TerceiroLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JogadorSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TerceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerdadeBT, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(DesafioBT, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(pontovdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pontodsf)
                    .addComponent(OUtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TerceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BeberBT, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pontobb))
                .addGap(18, 18, 18)
                .addGroup(TerceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ConfirmaBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVddDsf, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        Drink1.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Drink1.setTitle("Drink!\n");
        Drink1.setBounds(new java.awt.Rectangle(0, 0, 800, 400));
        Drink1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Drink1.setLocation(new java.awt.Point(365, 220));
        Drink1.setMinimumSize(new java.awt.Dimension(800, 400));
        Drink1.setUndecorated(true);
        Drink1.setResizable(false);
        Drink1.setSize(new java.awt.Dimension(800, 400));

        Drink11.setBackground(new java.awt.Color(255, 204, 51));
        Drink11.setFont(new java.awt.Font("Segoe UI", 1, 75)); // NOI18N
        Drink11.setText("Beba!");
        Drink11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Drink11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Drink1Layout = new javax.swing.GroupLayout(Drink1.getContentPane());
        Drink1.getContentPane().setLayout(Drink1Layout);
        Drink1Layout.setHorizontalGroup(
            Drink1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Drink11, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        Drink1Layout.setVerticalGroup(
            Drink1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Drink11, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        Drink2.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Drink2.setTitle("Drink!\n");
        Drink2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Drink2.setLocation(new java.awt.Point(300, 150));
        Drink2.setMinimumSize(new java.awt.Dimension(1000, 600));
        Drink2.setUndecorated(true);
        Drink2.setSize(new java.awt.Dimension(1000, 600));

        Drink22.setBackground(new java.awt.Color(255, 153, 0));
        Drink22.setFont(new java.awt.Font("Segoe UI", 1, 150)); // NOI18N
        Drink22.setText("Beba!");
        Drink22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Drink22.setMaximumSize(new java.awt.Dimension(300, 150));
        Drink22.setMinimumSize(new java.awt.Dimension(300, 150));
        Drink22.setPreferredSize(new java.awt.Dimension(300, 150));
        Drink22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Drink22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Drink2Layout = new javax.swing.GroupLayout(Drink2.getContentPane());
        Drink2.getContentPane().setLayout(Drink2Layout);
        Drink2Layout.setHorizontalGroup(
            Drink2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Drink22, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
        );
        Drink2Layout.setVerticalGroup(
            Drink2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Drink22, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        Drink3.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Drink3.setTitle("DRINK!\n");
        Drink3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Drink3.setLocation(new java.awt.Point(240, 80));
        Drink3.setMinimumSize(new java.awt.Dimension(1080, 720));
        Drink3.setUndecorated(true);
        Drink3.setResizable(false);
        Drink3.setSize(new java.awt.Dimension(1080, 720));

        Drink33.setBackground(new java.awt.Color(255, 0, 0));
        Drink33.setFont(new java.awt.Font("Segoe UI", 1, 250)); // NOI18N
        Drink33.setForeground(new java.awt.Color(255, 255, 255));
        Drink33.setText("BEBA!");
        Drink33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Drink33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Drink3Layout = new javax.swing.GroupLayout(Drink3.getContentPane());
        Drink3.getContentPane().setLayout(Drink3Layout);
        Drink3Layout.setHorizontalGroup(
            Drink3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Drink33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Drink3Layout.setVerticalGroup(
            Drink3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Drink33, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        BlackWindow.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        BlackWindow.setUndecorated(true);

        javax.swing.GroupLayout BlackWindowLayout = new javax.swing.GroupLayout(BlackWindow.getContentPane());
        BlackWindow.getContentPane().setLayout(BlackWindowLayout);
        BlackWindowLayout.setHorizontalGroup(
            BlackWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        BlackWindowLayout.setVerticalGroup(
            BlackWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        Colocados.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Colocados.setTitle("Jogo Finalizado!");
        Colocados.setAlwaysOnTop(true);
        Colocados.setAutoRequestFocus(false);
        Colocados.setUndecorated(true);
        Colocados.setResizable(false);

        JogoFinalizadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        JogoFinalizadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        JogoFinalizadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JogoFinalizadoLABEL.setText("JOGO FINALIZADO!");

        ColocadosLABEL.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        ColocadosLABEL.setForeground(new java.awt.Color(255, 255, 255));
        ColocadosLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ColocadosLABEL.setText("COLOCADOS:");

        primColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        primColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        primColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        primColocadoLABEL.setText("1º LUGAR: ");

        segColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        segColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        segColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        segColocadoLABEL.setText("2º LUGAR: ");

        terColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        terColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        terColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        terColocadoLABEL.setText("3º LUGAR: ");
        terColocadoLABEL.setToolTipText("");

        quarColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        quarColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        quarColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quarColocadoLABEL.setText("4º LUGAR: ");

        quinColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        quinColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        quinColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quinColocadoLABEL.setText("5º LUGAR: ");

        sexColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sexColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        sexColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sexColocadoLABEL.setText("6º LUGAR: ");

        setColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        setColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        setColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setColocadoLABEL.setText("7º LUGAR: ");

        oitColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        oitColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        oitColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oitColocadoLABEL.setText("8º LUGAR: ");

        nonColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nonColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        nonColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nonColocadoLABEL.setText("9º LUGAR: ");

        decColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        decColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        decColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        decColocadoLABEL.setText("10º LUGAR: ");

        dec1ColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dec1ColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        dec1ColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dec1ColocadoLABEL.setText("11º LUGAR: ");

        dec2ColocadoLABEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dec2ColocadoLABEL.setForeground(new java.awt.Color(255, 255, 255));
        dec2ColocadoLABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dec2ColocadoLABEL.setText("12º LUGAR: ");

        ENCERRARBT.setBackground(new java.awt.Color(0, 0, 0));
        ENCERRARBT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ENCERRARBT.setForeground(new java.awt.Color(255, 255, 255));
        ENCERRARBT.setText("ENCERRAR");
        ENCERRARBT.setBorderPainted(false);
        ENCERRARBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ENCERRARBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENCERRARBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ColocadosLayout = new javax.swing.GroupLayout(Colocados.getContentPane());
        Colocados.getContentPane().setLayout(ColocadosLayout);
        ColocadosLayout.setHorizontalGroup(
            ColocadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JogoFinalizadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
            .addComponent(ColocadosLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(primColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(segColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(terColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(quarColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(quinColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sexColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nonColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dec1ColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(oitColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(setColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(decColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dec2ColocadoLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ColocadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ENCERRARBT, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ColocadosLayout.setVerticalGroup(
            ColocadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColocadosLayout.createSequentialGroup()
                .addComponent(JogoFinalizadoLABEL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ColocadosLABEL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(primColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(segColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(terColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quarColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quinColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sexColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oitColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nonColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dec1ColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dec2ColocadoLABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ENCERRARBT, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
        );

        JOGOFINALIZADO.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        JOGOFINALIZADO.setAlwaysOnTop(true);
        JOGOFINALIZADO.setUndecorated(true);
        JOGOFINALIZADO.setResizable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 150)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("JOGO FINALIZADO!");

        javax.swing.GroupLayout JOGOFINALIZADOLayout = new javax.swing.GroupLayout(JOGOFINALIZADO.getContentPane());
        JOGOFINALIZADO.getContentPane().setLayout(JOGOFINALIZADOLayout);
        JOGOFINALIZADOLayout.setHorizontalGroup(
            JOGOFINALIZADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JOGOFINALIZADOLayout.setVerticalGroup(
            JOGOFINALIZADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        BlackWindow1.setUndecorated(true);
        BlackWindow1.setResizable(false);

        javax.swing.GroupLayout BlackWindow1Layout = new javax.swing.GroupLayout(BlackWindow1.getContentPane());
        BlackWindow1.getContentPane().setLayout(BlackWindow1Layout);
        BlackWindow1Layout.setHorizontalGroup(
            BlackWindow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        BlackWindow1Layout.setVerticalGroup(
            BlackWindow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Drink, Drink, DRINK!");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 757, 331));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setLocation(new java.awt.Point(350, 200));
        setMinimumSize(new java.awt.Dimension(757, 331));
        setName("FramePrincipal"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(757, 331));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Drink!");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Drink!");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DRINK!");

        IniciarBT.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        IniciarBT.setText("Iniciar");
        IniciarBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IniciarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarBTActionPerformed(evt);
            }
        });

        AjudaBT.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        AjudaBT.setText("Ajuda");
        AjudaBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        NomeTXT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NomeTXT.setForeground(new java.awt.Color(255, 255, 255));
        NomeTXT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NomeTXT.setText("Digite o nome de cada jogador:");

        AdicionarBT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdicionarBT.setText("Adicionar");
        AdicionarBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AdicionarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarBTActionPerformed(evt);
            }
        });
        AdicionarBT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AdicionarBTKeyTyped(evt);
            }
        });

        CDNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CDNome.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        CDNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDNomeActionPerformed(evt);
            }
        });

        ErroTXT.setForeground(new java.awt.Color(255, 51, 51));
        ErroTXT.setText("Por favor, insira um nome!");

        JogadoresTXT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JogadoresTXT.setForeground(new java.awt.Color(255, 255, 255));
        JogadoresTXT.setText("Jogadores:");

        NomeJogadoresTXT.setBackground(new java.awt.Color(255, 255, 255));
        NomeJogadoresTXT.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        NomeJogadoresTXT.setForeground(new java.awt.Color(255, 255, 255));
        NomeJogadoresTXT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        IniciarJogoBT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        IniciarJogoBT.setText("Iniciar");
        IniciarJogoBT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IniciarJogoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarJogoBTActionPerformed(evt);
            }
        });

        NomeJogadoresTXT1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        NomeJogadoresTXT1.setForeground(new java.awt.Color(255, 255, 255));
        NomeJogadoresTXT1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IniciarBT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AjudaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NomeTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CDNome, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AdicionarBT))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JogadoresTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomeJogadoresTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NomeJogadoresTXT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IniciarJogoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ErroTXT))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AjudaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IniciarBT, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CDNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ErroTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NomeTXT)
                                .addComponent(AdicionarBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NomeJogadoresTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NomeJogadoresTXT1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(JogadoresTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IniciarJogoBT, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))))))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Método chamado ao jogador clicar no botão principal "INICIAR".
    private void IniciarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarBTActionPerformed
        
        // Os outros componentes aparecem na tela e o botão "INICIAR" não pode mais ser acionado.
        NomeTXT.setVisible(true);
        AdicionarBT.setVisible(true);
        CDNome.setVisible(true);
        IniciarBT.setEnabled(false);
    }//GEN-LAST:event_IniciarBTActionPerformed

    // Método que tratará a adicão de jogadores na tela principal.
    private void AdicionarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarBTActionPerformed
        
        // Se o campo para a digitação dos nomes não estiver, o seguinte acontece:
        if(CDNome.getText().isBlank() == false){
          
            // Componentes específicos ficam VISÍVEIS e outros INVISÍVEIS.
            ErroTXT.setVisible(false);
            JogadoresTXT.setVisible(true);
            NomeJogadoresTXT1.setVisible(true);
            NomeJogadoresTXT.setVisible(true);
            
            // Se a lista com o número de jogadores for menor que 6...
            if(jogadores.size() < 6){
                
                // ... será verificado se é 0. Se sim os jogadores são setados na tela.
                if (jogadores.size() == 0){
                    NomeJogadoresTXT.setText(CDNome.getText());
                    jogadores.add(CDNome.getText());
                    CDNome.setText("");
                    
                // ...se não, os jogadores são setados juntamente com aqueles já setados anteriormente.
                } else if(jogadores.size() >= 1){
                    NomeJogadoresTXT.setText(NomeJogadoresTXT.getText() + ", " + CDNome.getText());
                    jogadores.add(CDNome.getText());
                    CDNome.setText("");
                    
                    // Além disso, quando a lista atingir 2 de tamanho, significando que
                    // temos 2 jogadores no jogo, já podemos iniciar o jogo definitivamente.
                    if(jogadores.size() == 2){
                        IniciarJogoBT.setVisible(true);
                    }
                }
            // Agora, se a lista for maior que 6, temos + de 6 jogadores no jogo, e então...
            } else {
                
                // ... será verificado se a lista tem exatamente 6, e se sim, o 7º jogador
                // será simplesmente setado numa próxima linha.
                if(jogadores.size() == 6){
                    NomeJogadoresTXT1.setText(CDNome.getText());
                    jogadores.add(CDNome.getText());
                    CDNome.setText("");
                    
                // ... se não, será setado com os outros nomes na segunda linha.
                } else if (jogadores.size() >=7){
                    NomeJogadoresTXT1.setText(NomeJogadoresTXT1.getText() + ", " + CDNome.getText());
                    jogadores.add(CDNome.getText());
                    CDNome.setText("");
                }
            }
            
            // Agora, se for 12, o jogo barra a criação de mais jogadores e obriga
            // o jogador a iniciar o jogo.
            if (jogadores.size() == 12){
                NomeTXT.setText("Limite de jogadores atingido!");
                CDNome.setEnabled(false);
                AdicionarBT.setEnabled(false);
            }
            
        // Se não há nada na caixa de texto ao acionar o botão de adicionar, aparecerá
        // uma mensagem de erro.
        } else {
            ErroTXT.setVisible(true);
        }
    }//GEN-LAST:event_AdicionarBTActionPerformed

    private void CDNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDNomeActionPerformed
        
    }//GEN-LAST:event_CDNomeActionPerformed

    private void AdicionarBTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdicionarBTKeyTyped

    }//GEN-LAST:event_AdicionarBTKeyTyped
    
    // Método que fará a tratação da criação do jogo.
    private void IniciarJogoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarJogoBTActionPerformed
        
        // Primeiramente, a tela principal será fechada.
        this.setVisible(false);
        
        // E então, criará o layout dos jogadores na tela de sorteio.
        for(int i = 0;  i < jogadores.size(); i++){
            botoesjogadores.get(i).setText(jogadores.get(i));
            botoesjogadores.get(i).setBackground(Color.white);
            pontuacao.get(i).setForeground(Color.white);
            botoesjogadores.get(i).setEnabled(true);
        }
        
        // Logo após isso, será necessário adicionar aqueles que não estão no jogo
        // em uma lista, pois além de gerenciar o que estão, será necessário gerenciar
        // aqueles que não estão.
        for (int i = jogadores.size(); i < 12; i++){
            jogadoresNaoAtivos.add(botoesjogadores.get(i));
        }
        
        // Por fim, a tela aparece, obviamente.
        Segundo.setVisible(true);
    }//GEN-LAST:event_IniciarJogoBTActionPerformed

    // Ação performada do botão "VERDADE" quando acionado.
    private void VerdadeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerdadeBTActionPerformed
        // Primeiramente, é sorteado a pergunta.
        sort = random.nextInt(perguntas.size());
        txtVddDsf.setText(perguntas.get(sort));
        txtVddDsf.setVisible(true);
        
        // Logo após, o botão "BEBER" e sua pontuação aparece.
        BeberBT.setVisible(true);
        pontobb.setVisible(true);
        
        // O botão de confirmação muda seu texto para "RESPONDER" pra entrar no contexto.
        ConfirmaBT.setText("Responder");
        ConfirmaBT.setVisible(true);
        
        // Os botões "VERDADE" e "DESAFIO" ficam inativos para impedir do jogador escolher novamente.
        VerdadeBT.setEnabled(false);
        DesafioBT.setEnabled(false);
        pontodsf.setForeground(Color.gray);
        OUtxt.setForeground(Color.gray);
        
        // Botão escolhido armazenado como "1".
        vddoudsf = 1;  
    }//GEN-LAST:event_VerdadeBTActionPerformed

    // Ação performada do botão "DESAFIO" quando acionado.
    private void DesafioBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesafioBTActionPerformed
        // Primeiramente, é sorteado o desafio.
        sort = random.nextInt(desafios.size());
        txtVddDsf.setText(desafios.get(sort));
        txtVddDsf.setVisible(true);
        
        // Logo após, o botão "BEBER" e sua pontuação aparece.
        BeberBT.setVisible(true);
        pontobb.setVisible(true);
        
        // O botão de confirmação muda seu texto para "CUMPRIR" pra entrar no contexto.
        ConfirmaBT.setText("Cumprir");
        ConfirmaBT.setVisible(true);
        
        // Os botões "VERDADE" e "DESAFIO" ficam inativos para impedir do jogador escolher novamente.
        VerdadeBT.setEnabled(false);
        DesafioBT.setEnabled(false);
        pontovdd.setForeground(Color.gray);
        OUtxt.setForeground(Color.gray);
        
        // Botão escolhido armazenado como "2".
        vddoudsf = 2;      
    }//GEN-LAST:event_DesafioBTActionPerformed

    // Ação performada ao usuário acionar "BEBER".
    private void BeberBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeberBTActionPerformed

        // Primeiramente, o jogador perderá o ponto ao beber, então...
        for (int i = 0; i < 12; i++){
            if (i == sorteio){                
                pntt = pontos.get(i) - 1;
                pontuacao.get(i).setText(pntt + " ponto(s).");
                pontos.remove(i);
                pontos.add(i, pntt);
            }
        }
        
        // Então, é feita a alternação de cores conforme a pontuação do jogador.
        alternarcorpnt(sorteio);
        
        // Logo após isso, a tela reseta e some.
        Terceiro.dispose();
        BlackWindow1.setVisible(false);
        VerdadeBT.setEnabled(true);
        DesafioBT.setEnabled(true);
        BeberBT.setVisible(false);
        pontovdd.setForeground(Color.green);
        pontodsf.setForeground(Color.green);
        pontobb.setVisible(false);
        txtVddDsf.setVisible(false);
        ConfirmaBT.setVisible(false);
        OUtxt.setForeground(Color.white);
        
        // Aqui está o trunfo do sistema. O sistema sorteará um número de 1 a 3,
        // e o usuário deverá beber o número de vezes em "shots" que o sistema sortear.
        qntdbb = random.nextInt(3) + 1;

        // Aparecerá uma tela a mais que preencherá toda a tela do usuário.
        BlackWindow.setVisible(true);
        
        // E então, o primeiro "DRINK" aparece.
        Drink1.setVisible(true);
    }//GEN-LAST:event_BeberBTActionPerformed

    // Ação performada ao usuário apertar em "RESPONDER" ou "CUMPRIR".
    private void ConfirmaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmaBTActionPerformed
        
        for (int i = 0; i < 12; i++){
            if (i == sorteio){
                switch(vddoudsf){
                    case 1:
                        pntt = pontos.get(i) + 1;
                        pontuacao.get(i).setText(pntt + " ponto(s).");
                        pontos.remove(i);
                        pontos.add(i, pntt);
                        break;
                    case 2:
                        pntt = pontos.get(i) + 2;
                        pontuacao.get(i).setText(pntt + " ponto(s).");
                        pontos.remove(i);
                        pontos.add(i, pntt);
                        break;
                }
            }
        }
        
        // É feito a mudança de cores no JLabel conforme a pontuação do jogador
        alternarcorpnt(sorteio);
        
        // Após clicar e os pontos serem definidos, a tela resetará e sumirá.
        Terceiro.dispose();
        BlackWindow1.setVisible(false);
        VerdadeBT.setEnabled(true);
        DesafioBT.setEnabled(true);
        BeberBT.setVisible(false);
        pontovdd.setForeground(Color.green);
        pontodsf.setForeground(Color.green);
        pontobb.setVisible(false);
        txtVddDsf.setVisible(false);
        ConfirmaBT.setVisible(false);
        OUtxt.setForeground(Color.white);
        
        // E então, a tela de sorteio aparecerá novamente.
        Segundo.setVisible(true);
    }//GEN-LAST:event_ConfirmaBTActionPerformed

    ////////////////////// AÇÕES PERFORMADAS DAS TELAS DRINK! /////////////////   
    // O trunfo do jojo é esse, e aqui que vai fazer sentido o jogo ser chamado
    // de Drink, drink, DRINK! Quando o jogador escolher beber, o sistema sorteará
    // um número de 1 a 3 para que o jogador beba a quantidade de "shots" exata.
    // Em cada tela "Drink" que aparecer, ele deverá beber, e é assim que são programadas:
    
    // Ação performada da primeira tela "Beba!".
    private void Drink11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Drink11ActionPerformed
        // Verifica-se se a variável que guarda o número sorteado é maior que 1.
        // Se sim, outra tela de "drink" aparecerá.
        if (qntdbb > 1){
            
            // A tela do primeiro "drink" some e segue-se um suspense até a segunda
            // tela aparecer.
            Drink1.dispose();
            sons.EfeitoSuspense();
            
            // Após isso, um serviço fará que a tela pisque interminavelmente sté que drink2 seja exibido.
            service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    paintComponentOrange(BlackWindow);
                }
            }, 3000, 500, TimeUnit.MILLISECONDS); 
            service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    paintComponentOrange(BlackWindow);
                }
            }, 5000, 50, TimeUnit.MILLISECONDS);  
                
        // Se "qntdbb" não for maior que 1, significando que foi sorteado o numero 1...
        } else {
            
            // A tela do primeiro "drink" some e segue-se um suspense apenas pra
            // dar um calafrio ao jogador, até a tela de sorteio aparecer novamente.
            Drink1.dispose();
            sons.EfeitoSuspense();
            
            service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    paintComponentOrange(BlackWindow);
                }
            }, 3000, 500, TimeUnit.MILLISECONDS); 
            service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    paintComponentOrange(BlackWindow);
                }
            }, 5000, 50, TimeUnit.MILLISECONDS);  
        }
    }//GEN-LAST:event_Drink11ActionPerformed
    
    // Ação performada da segunda tela de "Drink!". Segue a mesma lógica que a primeira tela.
    private void Drink22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Drink22ActionPerformed
        if (qntdbb > 2){
            sons.pararEfeito2();
            Drink2.dispose();
            sons.EfeitoSuspense();
            
            service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    paintComponentRed(BlackWindow);
                }
            }, 2000, 500, TimeUnit.MILLISECONDS);
            service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    paintComponentRed(BlackWindow);
                }
            }, 4000, 50, TimeUnit.MILLISECONDS); 
        } else {
            sons.pararEfeito2();
            Drink2.dispose();
            sons.EfeitoSuspense();
            
            service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    paintComponentRed(BlackWindow);
                }
            }, 2000, 500, TimeUnit.MILLISECONDS);
            service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    paintComponentRed(BlackWindow);
                }
            }, 4000, 50, TimeUnit.MILLISECONDS); 
        }
    }//GEN-LAST:event_Drink22ActionPerformed
    
    // Ação performada da terceira tela de "DRINK!".
    private void Drink33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Drink33ActionPerformed
        // Ao acionar essa tela, não tendo mais motivos para causar
        // suspense ao jogador, a tela simplesmente some e o sorteio volta.
        sons.pararEfeito3();
        Drink3.dispose();
        BlackWindow.dispose();
        Segundo.setVisible(true);
    }//GEN-LAST:event_Drink33ActionPerformed

    // Ação performada do botão "Finalizar Jogo". Aqui o jogo será finalizado ao
    // clicar no botão, e para que isso aconteça, os comandos seguintes serão
    // executados:
    private void FinalizarJogoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarJogoBTActionPerformed
        colocados();
        sons.jogoFinalizado();
        Colocados.setVisible(true);
        // Primeira vez que "JOGO FINALIZADO" aparece
        service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    jogofinalizado();
                }
            }, 1200, 500, TimeUnit.MILLISECONDS);
       
        // Efeito de diminuição de "JOGO FINALIZADO"
        service.scheduleAtFixedRate(new Runnable(){
            public void run(){
                jogofinalizado();
            }
        }, 8235, 190, TimeUnit.MILLISECONDS);
        
        // Primeira vez que "COLOCADOS" aparece
        service.scheduleAtFixedRate(new Runnable(){
            public void run(){
                jogofinalizado();
            }
        }, 9235, 500, TimeUnit.MILLISECONDS);
        
        // Efeito de diminuição de "COLOCADOS"
        service.scheduleAtFixedRate(new Runnable(){
            public void run(){
                jogofinalizado();
            }
        }, 15235, 475, TimeUnit.MILLISECONDS);
        
        // Efeito de aparecimento dos colocados
        service.scheduleAtFixedRate(new Runnable(){
            public void run(){
                jogofinalizado();
            }
        }, 16235, 155, TimeUnit.MILLISECONDS);
        
        
        // Efeito de diminuição de "Preparados?"
        service.scheduleAtFixedRate(new Runnable(){
            public void run(){
                jogofinalizado();
            }
        }, 24237, 150, TimeUnit.MILLISECONDS);
        
        
        // Efeito de aparecimento dos colocados
        service.scheduleAtFixedRate(new Runnable(){
            public void run(){
                jogofinalizado();
            }
        }, 26237, 1000, TimeUnit.MILLISECONDS);
        
        // Efeito de aparecimento dos colocados a partir do 7º colocado
        service.scheduleAtFixedRate(new Runnable(){
            public void run(){
                jogofinalizado();
            }
        }, 31237, 500, TimeUnit.MILLISECONDS);
        
        // Efeito de aparecimento dos colocados a partir do 5º colocado
        service.scheduleAtFixedRate(new Runnable(){
            public void run(){
                jogofinalizado();
            }
        }, 32189, 210, TimeUnit.MILLISECONDS);
        
        // Efeito de aparecimento de "ENCERRAR"
        service.scheduleAtFixedRate(new Runnable(){
            public void run(){
                jogofinalizado();
            }
        }, 33250, 140, TimeUnit.MILLISECONDS);
    }//GEN-LAST:event_FinalizarJogoBTActionPerformed

    // Ação performada do botão "Adicionar" da segunda tela. Ela serve para adicionar
    // jogadores com o jogo já em andamento.
    private void AdicionarJogadorBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarJogadorBTActionPerformed
        // O botão só funcionará caso o jogo já nao tiver 12 jogadores, ou seja,
        // se não estiver cheio, além de "adicionar" e "arregou" ser false. Além
        // de só funcionar se a lista de jogadores não ativos não estiver vazia.
        if (arregou == false && adicionar == false && jogadoresNaoAtivos.isEmpty() == false){
            // "voltar" se torna true, para poder ser acionado.
            voltar = true;

            // "adicionar" se torna true, por ter sido pressionado, assim possibilitando
            // os jogadores serem acionados.
            adicionar = true;

            // Uma caixa de texto aparece para possibilitar ao usuário escrever
            // o nome do jogador.
            AdicionarPlayerTXT.setEditable(true);

            // É feita a reestruturação da tela para permitir que o usuário clique
            // em um botão sem jogador para adicionar alguém
            for (int i = 0; i < 12; i++){

                // Os botões que já tiverem um jogador são setados inativos,
                // enquanto aqueles que não tiverem ficarão ativos.
                if(botoesjogadores.get(i).isEnabled() == false){
                    botoesjogadores.get(i).setEnabled(true);
                } else {
                    botoesjogadores.get(i).setEnabled(false);
                }
                
                // E a cor é então mudada.
                if (botoesjogadores.get(i).getText().isBlank() == true){
                    botoesjogadores.get(i).setBackground(Color.blue);
                    botoesjogadores.get(i).setCursor(Cursor.getPredefinedCursor(12));
                }
            }

            // Os outros botões ficam inativos pois o usuário quer adicionar uma pessoa ao jogo,
            // enquanto voltar se torna ativo para poder voltar ao jogo.
            ArregouBT.setEnabled(false);
            VoltarBT.setEnabled(true);
            SortearBT.setEnabled(false);
            AdicionarJogadorBT.setEnabled(false);
        }
    }//GEN-LAST:event_AdicionarJogadorBTActionPerformed

    // Ação performada do botão "Voltar" da segunda tela. Esse botão serve para
    // retornar ao jogo após o usuário adicionar ou retirar pessoas do jogo.
    private void VoltarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBTActionPerformed
        // Aqui temos duas possibilidades: ter clicado anteriormente em "ARREGOU"
        // ou ter clicado em "ADICIONAR". Os dois terão tratamento diferente
        // na ação. Primeiramente começaremos com arregou:
        if (arregou == true){
            // "arregou" se torna false para poder ser acionado novamente.
            arregou = false;

            // voltar se torna true para poder ser acionado novamente.
            voltar = true;

            // Os outros botões ficam ativos pois o jogo voltou ao andamento,
            // enquanto que "voltar" fica inativo pois acabou de ser apertado.
            ArregouBT.setEnabled(true);
            VoltarBT.setEnabled(false);
            SortearBT.setEnabled(true);
            AdicionarJogadorBT.setEnabled(true);
            
            // Então, feita novamente a alternância de cores.
            for(int i = 0; i < 12; i++){
                if(botoesjogadores.get(i).getText().isBlank() == false){
                    botoesjogadores.get(i).setBackground(Color.white);
                    botoesjogadores.get(i).setCursor(Cursor.getDefaultCursor());
                }
            }

        // Agora vendo pelo lado de ter acionado "ADICIONAR":
        } else if (adicionar == true){
            // "adicionar" se torna false para poder ser acionado novamente.
            adicionar = false;

            // voltar se torna true para poder ser acionado novamente.
            voltar = true;

            // Os outros botões ficam ativos pois o jogo voltou ao andamento,
            // enquanto que "voltar" fica inativo pois acabou de ser apertado.
            ArregouBT.setEnabled(true);
            VoltarBT.setEnabled(false);
            SortearBT.setEnabled(true);
            AdicionarJogadorBT.setEnabled(true);
            AdicionarPlayerTXT.setText("");
            AdicionarPlayerTXT.setEditable(false);
            ErroTXT1.setVisible(false);

            // E por fim, é feito a reestruturação da tela para o andamento do jogo.
            for (int i = 0; i < 12; i++){
                if (botoesjogadores.get(i).getText().isBlank() == false){
                    botoesjogadores.get(i).setEnabled(true);
                    botoesjogadores.get(i).setBackground(Color.white);
                    botoesjogadores.get(i).setCursor(Cursor.getDefaultCursor());
                    if(pontos.get(i) == 0){
                        pontuacao.get(i).setForeground(Color.white);
                    }
                } else {
                    botoesjogadores.get(i).setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_VoltarBTActionPerformed

    // Ação performada do botão "ARREGOU" da segunda tela. Esse botão serve para
    // tirar pessoas do jogo.
    private void ArregouBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArregouBTActionPerformed
        // O botão só funcionará se a flag "voltar" for true E "adicionar" for false.
        if (voltar == true && adicionar == false){
            // "voltar" se torna true, para poder ser acionado.
            voltar = false;

            // "arregou" se torna true, por ter sido precionado, assim possibilitando
            // os jogadores serem retirados.
            arregou = true;

            // Os oultros botões ficam inativos pois o usuário quer retirar uma pessoa do jogo,
            // enquanto voltar se torna ativo para poder voltar ao jogo.
            VoltarBT.setEnabled(true);
            ArregouBT.setEnabled(false);
            SortearBT.setEnabled(false);
            AdicionarJogadorBT.setEnabled(false);
            
            // É feita a alternancia de cores entre os botões com e sem jogadores
            for(int i = 0; i < 12; i++){
                if (botoesjogadores.get(i).getText().isBlank() != true){
                    botoesjogadores.get(i).setBackground(Color.red);
                    botoesjogadores.get(i).setCursor(Cursor.getPredefinedCursor(12));
                }
            }
        }
    }//GEN-LAST:event_ArregouBTActionPerformed

    ///////////////////////// FIM DOS BOTÕES DE JOGADORES //////////////////////
    
    // Ação performada do botão "SORTEAR" da segunda tela.
    private void SortearBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortearBTActionPerformed
        // O jogador é sorteado.
        do {
            sorteio = random.nextInt(12);
            for (int i = 0; i < 12; i++){
                if (i == sorteio){
                    if (jogadoresNaoAtivos.contains(botoesjogadores.get(i)) == false){
                        sorteado = botoesjogadores.get(i);
                        flag = 1;
                    }
                }
            }
        } while (flag == 0);

        flag = 0;

        // Os botões ficam inativos durante o sorteio e aparece uma tela preta por trás
        ArregouBT.setEnabled(false);
        VoltarBT.setEnabled(false);
        FinalizarJogoBT.setEnabled(false);
        AdicionarJogadorBT.setEnabled(false);
        SortearBT.setEnabled(false);
        BlackWindow1.setVisible(true);
        
        // Iniciada o som de suspense do sorteio
        sons.efeitoSorteio(sorteio);
        
        // É feito o suspense do sorteio
        service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    suspenseSorteio();
                }
            }, 0, 50, TimeUnit.MILLISECONDS);
        service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    suspenseSorteio();
                }
            }, 600, 75, TimeUnit.MILLISECONDS);
        service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    suspenseSorteio();
                }
            }, 1500, 125, TimeUnit.MILLISECONDS);
        service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    suspenseSorteio();
                }
            }, 3000, 200, TimeUnit.MILLISECONDS);
        service.scheduleAtFixedRate(new Runnable(){
                public void run(){
                    suspenseSorteio();
                }
            }, 5400, 300, TimeUnit.MILLISECONDS);
        
        // A terceira tela aparece dando a escolha ao jogador sorteado.
        JogadorSorteado.setText(sorteado.getText() + " foi sorteado(a)! " + sorteado.getText() + ", escolha: ");
    }//GEN-LAST:event_SortearBTActionPerformed

    private void Jg11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg11ActionPerformed
        if(arregou == true){
            Jg11.setEnabled(false);
            Jg11pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg11);
            Jg11.setText("");
            Jg11pnt.setText("0 ponto(s)");
            pontjg11 = 0;
            pontos.remove(10);
            pontos.add(10, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg11.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg11);
                Jg11.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg11ActionPerformed

    private void Jg10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg10ActionPerformed
        if(arregou == true){
            Jg10.setEnabled(false);
            Jg10pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg10);
            Jg10.setText("");
            Jg10pnt.setText("0 ponto(s)");
            pontjg10 = 0;
            pontos.remove(9);
            pontos.add(9, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg10.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg10);
                Jg10.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg10ActionPerformed

    private void Jg9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg9ActionPerformed
        if(arregou == true){
            Jg9.setEnabled(false);
            Jg9pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg9);
            Jg9.setText("");
            Jg9pnt.setText("0 ponto(s)");
            pontjg9 = 0;
            pontos.remove(8);
            pontos.add(8, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg9.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg9);
                Jg9.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg9ActionPerformed

    private void Jg8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg8ActionPerformed
        if(arregou == true){
            Jg8.setEnabled(false);
            Jg8pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg8);
            Jg8.setText("");
            Jg8pnt.setText("0 ponto(s)");
            pontjg8 = 0;
            pontos.remove(7);
            pontos.add(7, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg8.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg8);
                Jg8.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg8ActionPerformed

    private void Jg7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg7ActionPerformed
        if(arregou == true){
            Jg7.setEnabled(false);
            Jg7pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg7);
            Jg7.setText("");
            Jg7pnt.setText("0 ponto(s)");
            pontjg7 = 0;
            pontos.remove(6);
            pontos.add(6, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg7.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg7);
                Jg7.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg7ActionPerformed

    private void Jg6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg6ActionPerformed
        if(arregou == true){
            Jg6.setEnabled(false);
            Jg6pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg6);
            Jg6.setText("");
            Jg6pnt.setText("0 ponto(s)");
            pontjg6 = 0;
            pontos.remove(5);
            pontos.add(5, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg6.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg6);
                Jg6.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg6ActionPerformed

    private void Jg4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg4ActionPerformed
        if(arregou == true){
            Jg4.setEnabled(false);
            Jg4pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg4);
            Jg4.setText("");
            Jg4pnt.setText("0 ponto(s)");
            pontjg4 = 0;
            pontos.remove(3);
            pontos.add(3, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg4.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg4);
                Jg4.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg4ActionPerformed

    private void Jg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg1ActionPerformed
        if(arregou == true){
            Jg1.setEnabled(false);
            Jg1pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg1);
            Jg1.setText("");
            Jg1pnt.setText("0 ponto(s)");
            pontjg1 = 0;
            pontos.remove(0);
            pontos.add(0, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg1.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg1);
                Jg1.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg1ActionPerformed

    private void Jg5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg5ActionPerformed
        if(arregou == true){
            Jg5.setEnabled(false);
            Jg5pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg5);
            Jg5.setText("");
            Jg5pnt.setText("0 ponto(s)");
            pontjg5 = 0;
            pontos.remove(4);
            pontos.add(4, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg5.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg5);
                Jg5.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg5ActionPerformed

    private void Jg3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg3ActionPerformed
        if(arregou == true){
            Jg3.setEnabled(false);
            Jg3pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg3);
            Jg3.setText("");
            Jg3pnt.setText("0 ponto(s)");
            pontjg3 = 0;
            pontos.remove(2);
            pontos.add(2, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg3.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg3);
                Jg3.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg3ActionPerformed

    private void Jg2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg2ActionPerformed
        if(arregou == true){
            Jg2.setEnabled(false);
            Jg2pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg2);
            Jg2.setText("");
            Jg2pnt.setText("0 ponto(s)");
            pontjg2 = 0;
            pontos.remove(1);
            pontos.add(1, 0);
        } else if (adicionar == true){
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);
            } else {
                ErroTXT1.setVisible(false);
                Jg2.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg2);
                Jg2.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg2ActionPerformed

    ////////////////////////// INÍCIO DOS BOTÕES DE JOGADORES //////////////////
    // TODAS AS AÇÕES PERFORMADAS A PARTIR DE AGORA ATÉ O PRÓXIMO COMENTÁRIO SÃO
    // DE BOTÕES QUE SE REFEREM AOS JOGADORES, E TODOS ELES TEM A MESMA FUNCIONALIDADE
    // QUE SERÁ DESCRITA NESSE.
    
    // Ação performada do jogador numero 12.
    private void Jg12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jg12ActionPerformed
        // Aqui temos duas possibilidades: o usuário ter clicado em "Arregou" ou
        // em "Adicionar". Começaremos com a primeira possibilidade.
        if(arregou == true){

            // Com o botão "ARREGOU" acionado, queremos tirar jogadores do jogo,
            // então, o botão fica inativo e sua pontuação fica cinza, ao mesmo tempo
            // que seu número é adicionado na lista de jogadores não ativos.
            Jg12.setEnabled(false);
            Jg12pnt.setForeground(Color.black);
            jogadoresNaoAtivos.add(Jg12);
            Jg12.setText("");
            Jg12pnt.setText("0 ponto(s)");
            pontjg12 = 0;
            pontos.remove(11);
            pontos.add(11, 0);

        // Agora partindo para a segunda possibilidade.
        } else if (adicionar == true){

            // Se nada estiver na caixa de texto, aparecerá uma mensagem de erro.
            if (AdicionarPlayerTXT.getText().isBlank() == true){
                ErroTXT1.setVisible(true);

            // Se não, serão setados assim como no início do jogo, retirando os
            // mesmos da lista de jogadores não ativos.
            } else {
                ErroTXT1.setVisible(false);
                Jg12.setText(AdicionarPlayerTXT.getText());
                AdicionarPlayerTXT.setText("");
                jogadoresNaoAtivos.removeFirstOccurrence(Jg12);
                Jg12.setEnabled(false);
            }
        }
    }//GEN-LAST:event_Jg12ActionPerformed

    private void ENCERRARBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENCERRARBTActionPerformed
        Colocados.dispose();
        Segundo.dispose();
        main(args);
    }//GEN-LAST:event_ENCERRARBTActionPerformed

    public void paintComponentRed(JFrame g){
        if(color.equals(Color.black)){
            color = Color.red;
        }
        else
        {
            color = Color.black;
        }
        g.getContentPane().setBackground(color);
        cont = cont + 1;
        if (qntdbb == 3){
            if (cont == 4){
                try {
                    service.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (cont == 34){
                cont = 0;
                BlackWindow.getContentPane().setBackground(color.BLACK);
                sons.Efeito3();
                Drink3.setVisible(true);
                try {
                    service.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (qntdbb <= 2){
            if (cont == 4){
                try {
                    service.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (cont == 41){
                cont = 0;
                BlackWindow.getContentPane().setBackground(color.BLACK);
                BlackWindow.dispose();
                Segundo.setVisible(true);
                try {
                    service.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void paintComponentOrange(JFrame g){
        if(color.equals(Color.black)){
            color = Color.orange;
        }
        else
        {
            color = Color.black;
        }
        g.getContentPane().setBackground(color);
        cont = cont + 1;
        if (qntdbb >= 2){
            if (cont == 4){
                try {
                    service.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (cont == 19){
                cont = 0;
                BlackWindow.getContentPane().setBackground(color.BLACK);
                sons.Efeito2();
                Drink2.setVisible(true);
                try {
                    service.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (qntdbb < 2){
            if (cont == 4){
                try {
                    service.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (cont == 19){
                cont = 0;
                BlackWindow.getContentPane().setBackground(color.BLACK);
                BlackWindow.dispose();
                Segundo.setVisible(true);
                try {
                    service.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void alternarcorpnt(int sorte){
        for(int i = 0; i < 12; i++){
            if (sorte == i){
                if(pontos.get(i) < 0){
                    pontuacao.get(i).setForeground(Color.red);
                } else if (pontos.get(i) > 0){
                    pontuacao.get(i).setForeground(Color.green);
                } else if (pontos.get(i) == 0){
                    pontuacao.get(i).setForeground(Color.white);
                }
            }
        }
    }
    
    // Esse é o método chamado para quando o jogo for finalizado. Ele é uma animação.
    public void jogofinalizado(){
        
        // Contador para controle da animação.
        contjogofinalizado = contjogofinalizado + 1;
        
        // Primeira vez que aparece na tela "JOGO FINALIZADO".
        if (contjogofinalizado == 1){
            JOGOFINALIZADO.setVisible(true);
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        // "JOGO FINALIZADO" então diminui de tamanho.
        } else if(contjogofinalizado == 2){
            jLabel4.setFont(fonte1);
            jLabel4.setForeground(Color.black);
            JOGOFINALIZADO.getContentPane().setBackground(Color.white);
        } else if (contjogofinalizado == 3){
            jLabel4.setFont(fonte2);
            jLabel4.setForeground(Color.white);
            JOGOFINALIZADO.getContentPane().setBackground(Color.black);
        } else if (contjogofinalizado == 4){
            jLabel4.setFont(fonte3);
            jLabel4.setForeground(Color.black);
            JOGOFINALIZADO.getContentPane().setBackground(Color.white);
        } else if (contjogofinalizado == 5){
            jLabel4.setFont(fonte4);
            jLabel4.setForeground(Color.white);
            JOGOFINALIZADO.getContentPane().setBackground(Color.black);
            
        // Tela de "Colocados" aparece, contendo apenas o label de jogo finalizado.
        } else if (contjogofinalizado == 6){
            JogoFinalizadoLABEL.setVisible(true);
            JOGOFINALIZADO.setVisible(false);
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        // Primeira vez que "COLOCADOS" aparece na tela
        } else if (contjogofinalizado == 7){
            jLabel4.setFont(fonte);
            jLabel4.setText("COLOCADOS:");
            JOGOFINALIZADO.setVisible(true);
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        // "COLOCADOS" diminui de tamanho.
        } else if(contjogofinalizado == 8){
            jLabel4.setFont(fonte3);
            jLabel4.setForeground(Color.black);
            JOGOFINALIZADO.getContentPane().setBackground(Color.white);
            
        // Tela de "Colocados" reaparece, agora contendo os labels de jogo finalizado e colocados.    
        } else if(contjogofinalizado == 9){
            ColocadosLABEL.setVisible(true);
            JOGOFINALIZADO.setVisible(false);
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        // Os colocados aparecem no jogo.
        } else if (contjogofinalizado == 10){
            primColocadoLABEL.setVisible(true);
            segColocadoLABEL.setVisible(true);
        } else if (contjogofinalizado == 11){
            terColocadoLABEL.setVisible(true);
            quarColocadoLABEL.setVisible(true);
        } else if (contjogofinalizado == 12){
            quinColocadoLABEL.setVisible(true);
            sexColocadoLABEL.setVisible(true);
        } else if (contjogofinalizado == 13){
            setColocadoLABEL.setVisible(true);
            oitColocadoLABEL.setVisible(true);
        } else if (contjogofinalizado == 14){
            nonColocadoLABEL.setVisible(true);
            decColocadoLABEL.setVisible(true);
        } else if (contjogofinalizado == 15){
            dec1ColocadoLABEL.setVisible(true);
            dec2ColocadoLABEL.setVisible(true);
            
        // Primeira vez que "Preparados?" aparece na tela.
        } else if (contjogofinalizado == 16){
           jLabel4.setFont(fonte);
           jLabel4.setText("Preparados?");
           JOGOFINALIZADO.setVisible(true);
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        // "Preparados?" diminui de tamanho.
        } else if (contjogofinalizado == 17){
            jLabel4.setFont(fonte1);
            jLabel4.setForeground(Color.white);
            JOGOFINALIZADO.getContentPane().setBackground(Color.black);
        } else if (contjogofinalizado == 18){
            jLabel4.setFont(fonte2);
            jLabel4.setForeground(Color.black);
            JOGOFINALIZADO.getContentPane().setBackground(Color.white);
        } else if (contjogofinalizado == 19){
            jLabel4.setFont(fonte3);
            jLabel4.setForeground(Color.white);
            JOGOFINALIZADO.getContentPane().setBackground(Color.black);
        } else if (contjogofinalizado == 20){
            jLabel4.setFont(fonte4);
            jLabel4.setForeground(Color.black);
            JOGOFINALIZADO.getContentPane().setBackground(Color.white);
        } else if (contjogofinalizado == 21){
            jLabel4.setFont(fonte5);
            jLabel4.setForeground(Color.white);
            JOGOFINALIZADO.getContentPane().setBackground(Color.black);
        } else if (contjogofinalizado == 22){
            jLabel4.setFont(fonte6);
            jLabel4.setForeground(Color.black);
            JOGOFINALIZADO.getContentPane().setBackground(Color.white);
            
        // Tela de "Colocados" reaparece.   
        } else if (contjogofinalizado == 23){
            JOGOFINALIZADO.setVisible(false);
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        // Jogadores aparecem.
        } else if(contjogofinalizado == 24){
            if(contadorjogadores >=  12){
                dec2ColocadoLABEL.setText("12º LUGAR: " + colocacao.get(11).getNome() + " (" + colocacao.get(11).getPontuacao() + " pontos)");
            } else {    
                dec2ColocadoLABEL.setText("12º LUGAR: Ninguém!");
            }   
        } else if(contjogofinalizado == 25){
            if(contadorjogadores >=  11){
                dec1ColocadoLABEL.setText("11º LUGAR: " + colocacao.get(10).getNome() + " (" + colocacao.get(10).getPontuacao() + " pontos)");
            } else {    
                dec1ColocadoLABEL.setText("11º LUGAR: Ninguém!");
            }   
        } 
        else if(contjogofinalizado == 26){
            if(contadorjogadores >=  10){
                decColocadoLABEL.setText("10º LUGAR: " + colocacao.get(9).getNome() + " (" + colocacao.get(9).getPontuacao() + " pontos)");
            } else {    
                decColocadoLABEL.setText("10º LUGAR: Ninguém!");
            }   
        } 
        else if(contjogofinalizado == 27){
            if(contadorjogadores >=  9){
                nonColocadoLABEL.setText("9º LUGAR: " + colocacao.get(8).getNome() + " (" + colocacao.get(8).getPontuacao() + " pontos)");
            } else {    
                nonColocadoLABEL.setText("9º LUGAR: Ninguém!");
            }   
        } 
        else if(contjogofinalizado == 28){
            if(contadorjogadores >=  8){
                oitColocadoLABEL.setText("8º LUGAR: " + colocacao.get(7).getNome() + " (" + colocacao.get(7).getPontuacao() + " pontos)");
            } else {    
                oitColocadoLABEL.setText("8º LUGAR: Ninguém!");
            }   
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else if(contjogofinalizado == 29){
            if(contadorjogadores >=  7){
                setColocadoLABEL.setText("7º LUGAR: " + colocacao.get(6).getNome() + " (" + colocacao.get(6).getPontuacao() + " pontos)");
            } else {    
                setColocadoLABEL.setText("7º LUGAR: Ninguém!");
            }   
        } 
        else if(contjogofinalizado == 30){
            if(contadorjogadores >=  6){
                sexColocadoLABEL.setText("6º LUGAR: " + colocacao.get(5).getNome() + " (" + colocacao.get(5).getPontuacao() + " pontos)");
            } else {    
                sexColocadoLABEL.setText("6º LUGAR: Ninguém!");
            }
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else if(contjogofinalizado == 31){
            if(contadorjogadores >=  5){
                quinColocadoLABEL.setText("5º LUGAR: " + colocacao.get(4).getNome() + " (" + colocacao.get(4).getPontuacao() + " pontos)");
            } else {    
                quinColocadoLABEL.setText("5º LUGAR: Ninguém!");
            }   
        } 
        else if(contjogofinalizado == 32){
            if(contadorjogadores >=  4){
                quarColocadoLABEL.setText("4º LUGAR: " + colocacao.get(3).getNome() + " (" + colocacao.get(3).getPontuacao() + " pontos)");
            } else {    
                quarColocadoLABEL.setText("4º LUGAR: Ninguém!");
            }   
        } 
        else if(contjogofinalizado == 33){
            if(contadorjogadores >=  3){
                terColocadoLABEL.setText("3º LUGAR: " + colocacao.get(2).getNome() + " (" + colocacao.get(2).getPontuacao() + " pontos)");
            } else {    
                terColocadoLABEL.setText("3º LUGAR: Ninguém!");
            }   
        } 
        else if(contjogofinalizado == 34){
            if(contadorjogadores >=  2){
                segColocadoLABEL.setText("2º LUGAR: " + colocacao.get(1).getNome() + " (" + colocacao.get(1).getPontuacao() + " pontos)");
            } else {    
                segColocadoLABEL.setText("2º LUGAR: Ninguém!");
            }   
        } else if (contjogofinalizado == 35){
            if(contadorjogadores >=  1){
                primColocadoLABEL.setText("1º LUGAR: " + colocacao.get(0).getNome() + " (" + colocacao.get(0).getPontuacao() + " pontos)");
            } else {    
                primColocadoLABEL.setText("1º LUGAR: Ninguém!");
            }   
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (contjogofinalizado == 36){
            ENCERRARBT.setVisible(true);
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    // Esse é o método chamado quando o jogo finaliza, é aqui que os colocados são
    // alocados em seus devidos lugares.
    public void colocados(){
        
        for(int i = 0; i < 12; i++){
            if (botoesjogadores.get(i).getText().isBlank() == false){
                contadorjogadores = contadorjogadores + 1;
            }
        }   
        
        switch(contadorjogadores){
            case 2:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                
                Collections.sort(colocacao);
                break;
            case 3:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        } else if (contadorcolocado == 3){
                            nome3 = botoesjogadores.get(i).getText();
                            ponto3 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                colocacao.add(new Colocados(nome3, ponto3));
                
                Collections.sort(colocacao);
                break;
            case 4:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        } else if (contadorcolocado == 3){
                            nome3 = botoesjogadores.get(i).getText();
                            ponto3 = pontos.get(i);
                        } else if (contadorcolocado == 4){
                            nome4 = botoesjogadores.get(i).getText();
                            ponto4 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                colocacao.add(new Colocados(nome3, ponto3));
                colocacao.add(new Colocados(nome4, ponto4));

                Collections.sort(colocacao);
                break;
            case 5:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        } else if (contadorcolocado == 3){
                            nome3 = botoesjogadores.get(i).getText();
                            ponto3 = pontos.get(i);
                        } else if (contadorcolocado == 4){
                            nome4 = botoesjogadores.get(i).getText();
                            ponto4 = pontos.get(i);
                        } else if (contadorcolocado == 5){
                            nome5 = botoesjogadores.get(i).getText();
                            ponto5 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                colocacao.add(new Colocados(nome3, ponto3));
                colocacao.add(new Colocados(nome4, ponto4));
                colocacao.add(new Colocados(nome5, ponto5));
                
                Collections.sort(colocacao);
                break;
            case 6:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        } else if (contadorcolocado == 3){
                            nome3 = botoesjogadores.get(i).getText();
                            ponto3 = pontos.get(i);
                        } else if (contadorcolocado == 4){
                            nome4 = botoesjogadores.get(i).getText();
                            ponto4 = pontos.get(i);
                        } else if (contadorcolocado == 5){
                            nome5 = botoesjogadores.get(i).getText();
                            ponto5 = pontos.get(i);
                        } else if (contadorcolocado == 6){
                            nome6 = botoesjogadores.get(i).getText();
                            ponto6 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                colocacao.add(new Colocados(nome3, ponto3));
                colocacao.add(new Colocados(nome4, ponto4));
                colocacao.add(new Colocados(nome5, ponto5));
                colocacao.add(new Colocados(nome6, ponto6));
                
                Collections.sort(colocacao);
                break;
            case 7:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        } else if (contadorcolocado == 3){
                            nome3 = botoesjogadores.get(i).getText();
                            ponto3 = pontos.get(i);
                        } else if (contadorcolocado == 4){
                            nome4 = botoesjogadores.get(i).getText();
                            ponto4 = pontos.get(i);
                        } else if (contadorcolocado == 5){
                            nome5 = botoesjogadores.get(i).getText();
                            ponto5 = pontos.get(i);
                        } else if (contadorcolocado == 6){
                            nome6 = botoesjogadores.get(i).getText();
                            ponto6 = pontos.get(i);
                        } else if (contadorcolocado == 7){
                            nome7 = botoesjogadores.get(i).getText();
                            ponto7 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                colocacao.add(new Colocados(nome3, ponto3));
                colocacao.add(new Colocados(nome4, ponto4));
                colocacao.add(new Colocados(nome5, ponto5));
                colocacao.add(new Colocados(nome6, ponto6));
                colocacao.add(new Colocados(nome7, ponto7));
                
                Collections.sort(colocacao);
                break;
            case 8:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        } else if (contadorcolocado == 3){
                            nome3 = botoesjogadores.get(i).getText();
                            ponto3 = pontos.get(i);
                        } else if (contadorcolocado == 4){
                            nome4 = botoesjogadores.get(i).getText();
                            ponto4 = pontos.get(i);
                        } else if (contadorcolocado == 5){
                            nome5 = botoesjogadores.get(i).getText();
                            ponto5 = pontos.get(i);
                        } else if (contadorcolocado == 6){
                            nome6 = botoesjogadores.get(i).getText();
                            ponto6 = pontos.get(i);
                        } else if (contadorcolocado == 7){
                            nome7 = botoesjogadores.get(i).getText();
                            ponto7 = pontos.get(i);
                        } else if (contadorcolocado == 8){
                            nome8 = botoesjogadores.get(i).getText();
                            ponto8 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                colocacao.add(new Colocados(nome3, ponto3));
                colocacao.add(new Colocados(nome4, ponto4));
                colocacao.add(new Colocados(nome5, ponto5));
                colocacao.add(new Colocados(nome6, ponto6));
                colocacao.add(new Colocados(nome7, ponto7));
                colocacao.add(new Colocados(nome8, ponto8));
                
                Collections.sort(colocacao);
                break;
            case 9:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        } else if (contadorcolocado == 3){
                            nome3 = botoesjogadores.get(i).getText();
                            ponto3 = pontos.get(i);
                        } else if (contadorcolocado == 4){
                            nome4 = botoesjogadores.get(i).getText();
                            ponto4 = pontos.get(i);
                        } else if (contadorcolocado == 5){
                            nome5 = botoesjogadores.get(i).getText();
                            ponto5 = pontos.get(i);
                        } else if (contadorcolocado == 6){
                            nome6 = botoesjogadores.get(i).getText();
                            ponto6 = pontos.get(i);
                        } else if (contadorcolocado == 7){
                            nome7 = botoesjogadores.get(i).getText();
                            ponto7 = pontos.get(i);
                        } else if (contadorcolocado == 8){
                            nome8 = botoesjogadores.get(i).getText();
                            ponto8 = pontos.get(i);
                        } else if (contadorcolocado == 9){
                            nome9 = botoesjogadores.get(i).getText();
                            ponto9 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                colocacao.add(new Colocados(nome3, ponto3));
                colocacao.add(new Colocados(nome4, ponto4));
                colocacao.add(new Colocados(nome5, ponto5));
                colocacao.add(new Colocados(nome6, ponto6));
                colocacao.add(new Colocados(nome7, ponto7));
                colocacao.add(new Colocados(nome8, ponto8));
                colocacao.add(new Colocados(nome9, ponto9));
                
                Collections.sort(colocacao);
                break;
            case 10:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        } else if (contadorcolocado == 3){
                            nome3 = botoesjogadores.get(i).getText();
                            ponto3 = pontos.get(i);
                        } else if (contadorcolocado == 4){
                            nome4 = botoesjogadores.get(i).getText();
                            ponto4 = pontos.get(i);
                        } else if (contadorcolocado == 5){
                            nome5 = botoesjogadores.get(i).getText();
                            ponto5 = pontos.get(i);
                        } else if (contadorcolocado == 6){
                            nome6 = botoesjogadores.get(i).getText();
                            ponto6 = pontos.get(i);
                        } else if (contadorcolocado == 7){
                            nome7 = botoesjogadores.get(i).getText();
                            ponto7 = pontos.get(i);
                        } else if (contadorcolocado == 8){
                            nome8 = botoesjogadores.get(i).getText();
                            ponto8 = pontos.get(i);
                        } else if (contadorcolocado == 9){
                            nome9 = botoesjogadores.get(i).getText();
                            ponto9 = pontos.get(i);
                        } else if (contadorcolocado == 10){
                            nome10 = botoesjogadores.get(i).getText();
                            ponto10 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                colocacao.add(new Colocados(nome3, ponto3));
                colocacao.add(new Colocados(nome4, ponto4));
                colocacao.add(new Colocados(nome5, ponto5));
                colocacao.add(new Colocados(nome6, ponto6));
                colocacao.add(new Colocados(nome7, ponto7));
                colocacao.add(new Colocados(nome8, ponto8));
                colocacao.add(new Colocados(nome9, ponto9));
                colocacao.add(new Colocados(nome10, ponto10));
                
                Collections.sort(colocacao);
                break;
            case 11:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        } else if (contadorcolocado == 3){
                            nome3 = botoesjogadores.get(i).getText();
                            ponto3 = pontos.get(i);
                        } else if (contadorcolocado == 4){
                            nome4 = botoesjogadores.get(i).getText();
                            ponto4 = pontos.get(i);
                        } else if (contadorcolocado == 5){
                            nome5 = botoesjogadores.get(i).getText();
                            ponto5 = pontos.get(i);
                        } else if (contadorcolocado == 6){
                            nome6 = botoesjogadores.get(i).getText();
                            ponto6 = pontos.get(i);
                        } else if (contadorcolocado == 7){
                            nome7 = botoesjogadores.get(i).getText();
                            ponto7 = pontos.get(i);
                        } else if (contadorcolocado == 8){
                            nome8 = botoesjogadores.get(i).getText();
                            ponto8 = pontos.get(i);
                        } else if (contadorcolocado == 9){
                            nome9 = botoesjogadores.get(i).getText();
                            ponto9 = pontos.get(i);
                        } else if (contadorcolocado == 10){
                            nome10 = botoesjogadores.get(i).getText();
                            ponto10 = pontos.get(i);
                        } else if (contadorcolocado == 11){
                            nome11 = botoesjogadores.get(i).getText();
                            ponto11 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                colocacao.add(new Colocados(nome3, ponto3));
                colocacao.add(new Colocados(nome4, ponto4));
                colocacao.add(new Colocados(nome5, ponto5));
                colocacao.add(new Colocados(nome6, ponto6));
                colocacao.add(new Colocados(nome7, ponto7));
                colocacao.add(new Colocados(nome8, ponto8));
                colocacao.add(new Colocados(nome9, ponto9));
                colocacao.add(new Colocados(nome10, ponto10));
                colocacao.add(new Colocados(nome11, ponto11));
                
                Collections.sort(colocacao);
                break;
            case 12:
                for(int i = 0; i < 12; i++){
                    if(botoesjogadores.get(i).getText().isBlank() == false){
                        contadorcolocado = contadorcolocado + 1;
                        if(contadorcolocado == 1){
                            nome1 = botoesjogadores.get(i).getText();
                            ponto1 = pontos.get(i);
                        } else if (contadorcolocado == 2){
                            nome2 = botoesjogadores.get(i).getText();
                            ponto2 = pontos.get(i);
                        } else if (contadorcolocado == 3){
                            nome3 = botoesjogadores.get(i).getText();
                            ponto3 = pontos.get(i);
                        } else if (contadorcolocado == 4){
                            nome4 = botoesjogadores.get(i).getText();
                            ponto4 = pontos.get(i);
                        } else if (contadorcolocado == 5){
                            nome5 = botoesjogadores.get(i).getText();
                            ponto5 = pontos.get(i);
                        } else if (contadorcolocado == 6){
                            nome6 = botoesjogadores.get(i).getText();
                            ponto6 = pontos.get(i);
                        } else if (contadorcolocado == 7){
                            nome7 = botoesjogadores.get(i).getText();
                            ponto7 = pontos.get(i);
                        } else if (contadorcolocado == 8){
                            nome8 = botoesjogadores.get(i).getText();
                            ponto8 = pontos.get(i);
                        } else if (contadorcolocado == 9){
                            nome9 = botoesjogadores.get(i).getText();
                            ponto9 = pontos.get(i);
                        } else if (contadorcolocado == 10){
                            nome10 = botoesjogadores.get(i).getText();
                            ponto10 = pontos.get(i);
                        } else if (contadorcolocado == 11){
                            nome11 = botoesjogadores.get(i).getText();
                            ponto11 = pontos.get(i);
                        } else if (contadorcolocado == 12){
                            nome12 = botoesjogadores.get(i).getText();
                            ponto12 = pontos.get(i);
                        }
                    }
                }
                
                colocacao.add(new Colocados(nome1, ponto1));
                colocacao.add(new Colocados(nome2, ponto2));
                colocacao.add(new Colocados(nome3, ponto3));
                colocacao.add(new Colocados(nome4, ponto4));
                colocacao.add(new Colocados(nome5, ponto5));
                colocacao.add(new Colocados(nome6, ponto6));
                colocacao.add(new Colocados(nome7, ponto7));
                colocacao.add(new Colocados(nome8, ponto8));
                colocacao.add(new Colocados(nome9, ponto9));
                colocacao.add(new Colocados(nome10, ponto10));
                colocacao.add(new Colocados(nome11, ponto11));
                colocacao.add(new Colocados(nome12, ponto12));
                
                Collections.sort(colocacao);
                break;              
        }
    }
    
    public void suspenseSorteio(){
        
        // Contador para o suspense do sorteio
        contadorSusSor = contadorSusSor + 1;
        contadorSusSor1 = contadorSusSor1 + 1;
        
        switch(contadorSusSor){
            case 1:
                botoesjogadores.get(0).setBackground(Color.red);
                botoesjogadores.get(11).setBackground(Color.white);
                break;
            case 2:
                botoesjogadores.get(1).setBackground(Color.red);
                botoesjogadores.get(0).setBackground(Color.white);
                break;
            case 3:
                botoesjogadores.get(2).setBackground(Color.red);
                botoesjogadores.get(1).setBackground(Color.white);
                break;
            case 4:
                botoesjogadores.get(3).setBackground(Color.red);
                botoesjogadores.get(2).setBackground(Color.white);
                break;
            case 5:
                botoesjogadores.get(4).setBackground(Color.red);
                botoesjogadores.get(3).setBackground(Color.white);
                break;
            case 6:
                botoesjogadores.get(5).setBackground(Color.red);
                botoesjogadores.get(4).setBackground(Color.white);
                break;
            case 7:
                botoesjogadores.get(6).setBackground(Color.red);
                botoesjogadores.get(5).setBackground(Color.white);
                break;
            case 8:
                botoesjogadores.get(7).setBackground(Color.red);
                botoesjogadores.get(6).setBackground(Color.white);
                break;
            case 9:
                botoesjogadores.get(8).setBackground(Color.red);
                botoesjogadores.get(7).setBackground(Color.white);
                break;
            case 10:
                botoesjogadores.get(9).setBackground(Color.red);
                botoesjogadores.get(8).setBackground(Color.white);
                break;
            case 11:
                botoesjogadores.get(10).setBackground(Color.red);
                botoesjogadores.get(9).setBackground(Color.white);
                break;
            case 12:
                botoesjogadores.get(11).setBackground(Color.red);
                botoesjogadores.get(10).setBackground(Color.white);
                contadorSusSor = 0;
                break;
        }
        if(contadorSusSor1 == 12){
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(contadorSusSor1 == 24){
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(contadorSusSor1 == 36){
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(contadorSusSor1 == 48){
            try {
                service.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(contadorSusSor1 > 48) { 
            if (contadorSusSor == sorteio + 1){  
                try {
                    TimeUnit.MILLISECONDS.sleep(525);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                // Feita toda a reprogamação da tela de sorteio
                Terceiro.setVisible(true);
                Segundo.setVisible(false);
                botoesjogadores.get(sorteio).setBackground(Color.white);
                ArregouBT.setEnabled(true);
                VoltarBT.setEnabled(true);
                FinalizarJogoBT.setEnabled(true);
                AdicionarJogadorBT.setEnabled(true);
                SortearBT.setEnabled(true);
                contadorSusSor = 0;
                contadorSusSor1 = 0;
                try {
                    service.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drinkk.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
        }
    }
    
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
            java.util.logging.Logger.getLogger(Drinkk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Drinkk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Drinkk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Drinkk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Drinkk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarBT;
    private javax.swing.JButton AdicionarJogadorBT;
    private javax.swing.JTextField AdicionarPlayerTXT;
    private javax.swing.JButton AjudaBT;
    private javax.swing.JButton ArregouBT;
    private javax.swing.JButton BeberBT;
    private javax.swing.JFrame BlackWindow;
    private javax.swing.JFrame BlackWindow1;
    private javax.swing.JTextField CDNome;
    private javax.swing.JFrame Colocados;
    private javax.swing.JLabel ColocadosLABEL;
    private javax.swing.JButton ConfirmaBT;
    private javax.swing.JButton DesafioBT;
    private javax.swing.JFrame Drink1;
    private javax.swing.JButton Drink11;
    private javax.swing.JFrame Drink2;
    private javax.swing.JButton Drink22;
    private javax.swing.JFrame Drink3;
    private javax.swing.JButton Drink33;
    private javax.swing.JButton ENCERRARBT;
    private javax.swing.JLabel ErroTXT;
    private javax.swing.JLabel ErroTXT1;
    private javax.swing.JButton FinalizarJogoBT;
    private javax.swing.JButton IniciarBT;
    private javax.swing.JButton IniciarJogoBT;
    private javax.swing.JFrame JOGOFINALIZADO;
    private javax.swing.JButton Jg1;
    private javax.swing.JButton Jg10;
    private javax.swing.JLabel Jg10pnt;
    private javax.swing.JButton Jg11;
    private javax.swing.JLabel Jg11pnt;
    private javax.swing.JButton Jg12;
    private javax.swing.JLabel Jg12pnt;
    private javax.swing.JLabel Jg1pnt;
    private javax.swing.JButton Jg2;
    private javax.swing.JLabel Jg2pnt;
    private javax.swing.JButton Jg3;
    private javax.swing.JLabel Jg3pnt;
    private javax.swing.JButton Jg4;
    private javax.swing.JLabel Jg4pnt;
    private javax.swing.JButton Jg5;
    private javax.swing.JLabel Jg5pnt;
    private javax.swing.JButton Jg6;
    private javax.swing.JLabel Jg6pnt;
    private javax.swing.JButton Jg7;
    private javax.swing.JLabel Jg7pnt;
    private javax.swing.JButton Jg8;
    private javax.swing.JLabel Jg8pnt;
    private javax.swing.JButton Jg9;
    private javax.swing.JLabel Jg9pnt;
    private javax.swing.JLabel JogadorSorteado;
    private javax.swing.JLabel JogadoresTXT;
    private javax.swing.JLabel JogoFinalizadoLABEL;
    private javax.swing.JLabel NomeJogadoresTXT;
    private javax.swing.JLabel NomeJogadoresTXT1;
    private javax.swing.JLabel NomeTXT;
    private javax.swing.JLabel OUtxt;
    private javax.swing.JFrame Segundo;
    private javax.swing.JButton SortearBT;
    private javax.swing.JFrame Terceiro;
    private javax.swing.JButton VerdadeBT;
    private javax.swing.JButton VoltarBT;
    private javax.swing.JLabel dec1ColocadoLABEL;
    private javax.swing.JLabel dec2ColocadoLABEL;
    private javax.swing.JLabel decColocadoLABEL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel nonColocadoLABEL;
    private javax.swing.JLabel oitColocadoLABEL;
    private javax.swing.JLabel pontobb;
    private javax.swing.JLabel pontodsf;
    private javax.swing.JLabel pontovdd;
    private javax.swing.JLabel primColocadoLABEL;
    private javax.swing.JLabel quarColocadoLABEL;
    private javax.swing.JLabel quinColocadoLABEL;
    private javax.swing.JLabel segColocadoLABEL;
    private javax.swing.JLabel setColocadoLABEL;
    private javax.swing.JLabel sexColocadoLABEL;
    private javax.swing.JLabel terColocadoLABEL;
    private javax.swing.JLabel txtVddDsf;
    // End of variables declaration//GEN-END:variables
}

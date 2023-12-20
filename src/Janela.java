
//bibliotecas usadas
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Janela {

                           //ARMAZENAMENTO DOS DADOS INSERIDOS PELO USUARIO
    //////////////////////////////////////////////////////////////////////////////////////////////////
    //lista para guardar dados
    List<String> database;

    public Janela() {
        database = new ArrayList<>();
    }

    //adicionar um item a lista que armazena os cardapios
    public void AdicionarItem(String data) {

        // add item na lista
        database.add(data);
        JOptionPane.showMessageDialog(null, "Item adicionado ao cardápio!");

    }

    // funcao para deletar a lista
    public void DeletarLista() {

        // caso esteja vazio
        if (database.isEmpty() == true) {

            JOptionPane.showMessageDialog(null, "Nenhum cardápio registrado!");

        } else {

            // caso não esteja vazio
            database.clear();
            JOptionPane.showMessageDialog(null, "Lista deletada!");

        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////


    void Aplicacao() {

        // Configuração da janela aluno ou funcionário
        JFrame aluno_ou_funcionario = new JFrame();
        aluno_ou_funcionario.setLocationRelativeTo(null);
        aluno_ou_funcionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aluno_ou_funcionario.setSize(300, 100);
        aluno_ou_funcionario.revalidate();

        // Painel aluno ou funcionário
        JPanel painel_aluno_ou_funcionario = new JPanel();
        JLabel label_aluno_ou_funcionario = new JLabel("Escolha uma opção:");
        painel_aluno_ou_funcionario.add(label_aluno_ou_funcionario);
        painel_aluno_ou_funcionario.setBackground(Color.LIGHT_GRAY);

        // Botões aluno ou funcionário
        JRadioButton RadioButton_aluno = new JRadioButton("Aluno");
        JRadioButton RadioButton_funcionario = new JRadioButton("Funcionário");

        // Grupo de botões aluno ou funcionário
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(RadioButton_aluno);
        buttonGroup.add(RadioButton_funcionario);

        // Adicionando os botões ao painel
        painel_aluno_ou_funcionario.add(RadioButton_aluno);
        painel_aluno_ou_funcionario.add(RadioButton_funcionario);

        // Botão confirmar
        JButton Button_confirmar = new JButton("Confirmar");
        painel_aluno_ou_funcionario.add(Button_confirmar);

        // Adicionar o painel na janela aluno ou funcionário
        aluno_ou_funcionario.add(painel_aluno_ou_funcionario);

        // Ação ao clicar no botão confirmar
        Button_confirmar.addActionListener(e -> {

            if (RadioButton_aluno.isSelected()) {

                // Caso selecione aluno
                Janela_Mostrar();

            } else if (RadioButton_funcionario.isSelected()) {

                // caso selecione funcionário
                aluno_ou_funcionario.dispose();
                loginFuncionario();

            } else {

                // caso o usuário não selecione nada
                JOptionPane.showMessageDialog(aluno_ou_funcionario, "Você não escolheu uma opção");

            }

        });

        // mostrar a janela
        aluno_ou_funcionario.setVisible(true);
    }

    void loginFuncionario() {

        // Criação da janela de login para funcionário
        JFrame janela = new JFrame();
        janela.setTitle("Login Funcionário");
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        // criando painel da janela
        JPanel painel = new JPanel(new GridLayout(5, 2));
        painel.setBackground(Color.LIGHT_GRAY);

        // rótulos e campos de login
        JLabel loginlabel = new JLabel("User :");
        JTextField loginfield = new JTextField(10);

        // rótulo e campo de senha
        JLabel senhalabel = new JLabel("Senha :");
        JPasswordField senhafield = new JPasswordField(10);

        // adicionando componentes ao painel
        painel.add(loginlabel);
        painel.add(loginfield);
        painel.add(senhalabel);
        painel.add(senhafield);

        // botão login
        JButton loginbutton = new JButton("Login");
        painel.add(loginbutton, BorderLayout.SOUTH);

        // adicionando o painel na janela no centro
        janela.add(painel, BorderLayout.CENTER);

        // Ação ao clicar no botão de login
        loginbutton.addActionListener(e -> {

            // obter as strings dos campos
            String login = loginfield.getText();
            char[] senharchars = senhafield.getPassword();
            String senha = new String(senharchars);

            // senha e login do funcionário
            if (login.equals("funcionario") && senha.equals("senha")) {

                // caso a verificação seja correta
                janela.dispose();
                JOptionPane.showMessageDialog(null, "Bem vindo!");
                Janela_Cardapio_Funcionario();

            } else {

                // caso a verificação seja incorreta
                JOptionPane.showMessageDialog(null, "Login ou senha inválidos!!!");

            }

        });

        // mostrar a janela atoa
        janela.setVisible(true);

    }

    void Janela_Cardapio_Funcionario() {

        // lista utilizada para armazenar os cardápios
        List<JTextField> listadecardapio = new ArrayList<>();

        // configurações basicas da janela cardápio
        JFrame janelacardapio = new JFrame("Cadastrar Cardápio");
        janelacardapio.setSize(600, 400);
        janelacardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelacardapio.setLocationRelativeTo(null);
        janelacardapio.getContentPane().setLayout(new BorderLayout());

        // criar o rótulo,mudar a fonte e alinhar na janela
        JLabel rotulotitulo = new JLabel("Cadastrar Cardápio");
        rotulotitulo.setFont(new Font("Arial", Font.BOLD, 18));
        rotulotitulo.setHorizontalAlignment(JLabel.CENTER);

        // criando um painel
        JPanel painel = new JPanel(new GridLayout(9, 2, 20, 2));

        // criando a string dias da semana
        String[] diasdasemana = { "Segunda", "Terça", "Quarta", "Quinta", "Sexta" };

        // caixa de marcar o dia da semana
        JComboBox<String> caixadediasdasemana = new JComboBox<>(diasdasemana);

        // criando o rótulo do cardápio
        JLabel rotulodocardapio = new JLabel("Cardápio do dia escolhido :");
        JTextField cardapioTextField = new JTextField();

        // criando o botão cadastrar
        JButton botaocadastrar = new JButton("Cadastrar");
        JButton mostrarcardapio = new JButton("Mostrar");
        JButton menuinicial = new JButton("Menu inicial");
        JButton deletarcardapio = new JButton("Deletar cardápio");

        // config do botao deletar
        deletarcardapio.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //chama a função deletar a lista
                DeletarLista();

            }

        });

        // botao mostrar cardapio
        mostrarcardapio.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //chama a função mostrar o cardapio
                Janela_Mostrar();

            }

        });

        menuinicial.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // fecha a janela e volta para o menu inicial
                janelacardapio.dispose();


                //chama uma janela
                Aplicacao();

            }

        });

        // adicionando uma ação para o botão cadastrar
        botaocadastrar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {



                // obter strings do campo
                String diaSelecionado = (String) caixadediasdasemana.getSelectedItem();
                String cardapio = cardapioTextField.getText();

                // como a mensagem sera armazenada na lista
                String estrutura = "\nCardapio de " + diaSelecionado + ":" + "\n" + cardapio + "\n";

                if(cardapio.equals("")){

                    JOptionPane.showMessageDialog(null,"Nada foi digitado no campo de texto!");

                }else{

                    AdicionarItem(estrutura);

                }

            }

        });

        // adicionando os componentes no painel
        painel.add(caixadediasdasemana);
        painel.setBackground(Color.lightGray);
        painel.add(new JLabel()); // Espaço vazio
        painel.add(rotulodocardapio);
        painel.add(cardapioTextField);
        painel.add(new JLabel()); // Espaço vazio
        painel.add(botaocadastrar);
        painel.add(mostrarcardapio);
        painel.add(menuinicial);
        painel.add(deletarcardapio);

        // adicionando os componentes na janela
        janelacardapio.getContentPane().add(rotulotitulo, BorderLayout.NORTH);

        janelacardapio.getContentPane().add(painel, BorderLayout.CENTER);
        janelacardapio.setBackground(Color.LIGHT_GRAY);

        // deixar a janela visivel
        janelacardapio.setVisible(true);

    }

    public void Janela_Mostrar(){
        // objeto da classe janela
        Janela janela = new Janela();

        // verifica se a lista está vazia
        if (database.isEmpty()) {

            // chama e abri a janela
            JOptionPane.showMessageDialog(null, "Nenhum cardápio cadastrado!");

        } else {

            // cria a janela para mostrar os dados

            // Objetos da janela
            JFrame janelamostrar = new JFrame();
            JPanel painelmostrar = new JPanel(new BorderLayout());
            JTextArea areadetexto = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(areadetexto);
            JButton botaovoltar = new JButton("Voltar");

            // consfigurações básicas da janela.
            janelamostrar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            janelamostrar.setSize(600, 400);
            janelamostrar.setLocationRelativeTo(null);
            areadetexto.setEditable(false);

            // para cada dados da lista ele adiciona na janela e pula uma linha
            for (String cardapio : database) {

                //adicionar texto na area de trabalho
                areadetexto.append(cardapio + "\n");

            }

            // adiciona os dados ao painel
            painelmostrar.add(botaovoltar, BorderLayout.NORTH);
            painelmostrar.add(scrollPane, BorderLayout.CENTER);

            // adiciona o painel a janela
            janelamostrar.getContentPane().add(painelmostrar);
            janelamostrar.setBackground(Color.LIGHT_GRAY);

            // ação ao cliclar o botao voltar
            botaovoltar.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    // fecha a janela
                    janelamostrar.dispose();

                }

            });

            // deixar a janela visível
            janelamostrar.setVisible(true);

        }

    }

}

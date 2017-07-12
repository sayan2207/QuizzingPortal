import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Trivia_Quiz extends javax.swing.JApplet
{
    private javax.swing.JTextArea Area_Output;
    private javax.swing.JButton Button_Answer;
    private javax.swing.JButton Button_QUIT;
    private javax.swing.JButton Button_START;
    private javax.swing.JButton Button_SUBMIT;
    private javax.swing.JTextField Field_CorrectAnsweres;
    private javax.swing.JTextField Field_Input;
    private javax.swing.JTextField Field_QuestionNumber;
    private javax.swing.JTextField Field_Name;
    private javax.swing.JLabel Label_CorrectAnsweres;
    private javax.swing.JLabel Label_Input;
    private javax.swing.JLabel Label_QuestionNumber;
    private javax.swing.JLabel Label_Title;
    private javax.swing.JLabel Label_Copyright;
    private javax.swing.JLabel Label_Name;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton one;
    private javax.swing.JRadioButton two;
    private javax.swing.JRadioButton three;
    private javax.swing.JRadioButton four;
    private Panel fm;
    String INTRO = "\n\t\t\t  WELCOME QUIZZER! \n\n\t\t\tGlad 2 see u here!!\n\n";
    String HEADER = " Answer the question presented below by typing your\n" +" response in the input box and clicking \"Answer\".\n\n";
    String[][] Question;
    String name;
    int QuestionNumber = 0;
    int Correct = 0;

    public void init() 
    {
        try{
            BufferedReader b=new BufferedReader(new FileReader("Questions.txt"));

            String question[][]=new String[5][7];
            int counter=0;String temp="";
            int randomvalue;
            while(counter!=5)
            {
                randomvalue=(int)(Math.random()*5);
                for(int i=0;i<randomvalue*6;i++)
                    temp=b.readLine();
                question[counter][0]=b.readLine();
                question[counter][1]=b.readLine();
                question[counter][2]=b.readLine();
                question[counter][3]=b.readLine();
                question[counter][4]=b.readLine();
                question[counter][5]=b.readLine();
                question[counter][6]="";
                counter++;
            }

            Question=question;
            b.close();

            java.awt.EventQueue.invokeAndWait(new Runnable() 
                {
                    public void run() 
                    {
                        initComponents();
                    }
                });
        } 
        catch (Exception e){}
    }

    private void initComponents() 
    {
        jScrollPane1 = new javax.swing.JScrollPane();
        Area_Output = new javax.swing.JTextArea();
        Label_Title = new javax.swing.JLabel();
        Field_Input = new javax.swing.JTextField();
        Field_Name = new javax.swing.JTextField();
        Label_Input = new javax.swing.JLabel();
        Button_Answer = new javax.swing.JButton();
        Button_START = new javax.swing.JButton();
        Button_QUIT = new javax.swing.JButton();
        Button_SUBMIT = new javax.swing.JButton();
        Field_CorrectAnsweres = new javax.swing.JTextField();
        Field_QuestionNumber = new javax.swing.JTextField();
        Label_CorrectAnsweres = new javax.swing.JLabel();
        Label_QuestionNumber = new javax.swing.JLabel();
        Label_Name = new javax.swing.JLabel();
        Label_Copyright = new javax.swing.JLabel();
        one = new javax.swing.JRadioButton("option 1");
        two = new javax.swing.JRadioButton("option 2");
        three = new javax.swing.JRadioButton("option 3");
        four = new javax.swing.JRadioButton("option 4");
        getContentPane().setLayout(null);

        fm=new Panel();
        Label la=new Label("Your choice:");
        fm.setLayout(new FlowLayout());
        CheckboxGroup cg1=new CheckboxGroup();

        fm.add(new Checkbox("option 1",cg1,false));
        fm.add(new Checkbox("option 2",cg1,false));
        fm.add(new Checkbox("option 3",cg1,false));
        fm.add(new Checkbox("option 4",cg1,false));
        fm.setSize(50,200);
        fm.setVisible(false);

        //output area
        setBackground(new java.awt.Color(102, 153, 255));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Area_Output.setColumns(100);
        Area_Output.setEditable(false);
        Area_Output.setRows(5);
        Area_Output.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(Area_Output);
        Area_Output.getAccessibleContext().setAccessibleName("OutputBox");
        Area_Output.setText(INTRO);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 760, 190);

        //radio buttons
        one.setBounds(100, 0, 60, 14);
        ButtonGroup choice = new ButtonGroup();
        choice.add(one);
        choice.add(two);
        choice.add(three);
        choice.add(four);

        //header
        Label_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Title.setText("QUIZ");
        getContentPane().add(Label_Title);
        Label_Title.setBounds(360, 0, 60, 14);
        Label_Title.getAccessibleContext().setAccessibleName("QuizLabel");

        //copyright area 
        Label_Copyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Copyright.setText("sayan's quzzing portal ltd. \u00a9");
        getContentPane().add(Label_Copyright);
        Label_Copyright.setBounds(300, 490, 160, 214);
        Label_Copyright.getAccessibleContext().setAccessibleName("copyright");

        //input area
        getContentPane().add(Field_Input);
        Field_Input.setBounds(110, 370, 560, 20);
        Field_Input.getAccessibleContext().setAccessibleName("InputBox");

        //name header
        Label_Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Name.setText("Name :");
        getContentPane().add(Label_Name);
        Label_Name.setBounds(100, 470, 160, 20);
        Label_Name.getAccessibleContext().setAccessibleName("name");

        //name input
        getContentPane().add(Field_Name);
        Field_Name.setBounds(210, 470, 160, 20);
        Field_Name.getAccessibleContext().setAccessibleName("NamingBox");

        //Input header
        Label_Input.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Input.setText("Input");
        getContentPane().add(Label_Input);
        Label_Input.setBounds(380,350, 40, 14);
        Label_Input.getAccessibleContext().setAccessibleName("InputLabel");

        Button_Answer.setText("Answer");
        Button_Answer.setMargin(new java.awt.Insets(1, 1, 1, 1));
        Button_Answer.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    ActionPerformed_Answer(evt);
                }
            });
        Button_Answer.addAncestorListener(new javax.swing.event.AncestorListener()
            {
                public void ancestorMoved(javax.swing.event.AncestorEvent evt){}

                public void ancestorAdded(javax.swing.event.AncestorEvent evt) 
                {
                    Button_AnswerAncestorAdded(evt);
                }

                public void ancestorRemoved(javax.swing.event.AncestorEvent evt){}
            });

        getContentPane().add(Button_Answer);
        Button_Answer.setBounds(370, 300, 60, 21);
        Button_Answer.getAccessibleContext().setAccessibleName("Button_Answer");
        Button_Answer.setBackground(Color.green);
        Button_Answer.setEnabled(false);

        Button_START.setLabel("START");
        Button_START.setMargin(new java.awt.Insets(1, 1, 1, 1));
        Button_START.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    Button_STARTActionPerformed(evt);
                }
            });

        getContentPane().add(Button_START);
        Button_START.setBounds(20, 300, 60, 21);
        Button_START.getAccessibleContext().setAccessibleName("Button_START");

        Button_QUIT.setLabel("QUIT");
        Button_QUIT.setMargin(new java.awt.Insets(1, 1, 1, 1));
        Button_QUIT.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    Button_QUITActionPerformed(evt);
                }
            });

        getContentPane().add(Button_QUIT);
        Button_QUIT.setBounds(710, 300, 50, 21);
        Button_QUIT.getAccessibleContext().setAccessibleName("Button_QUIT");
        Button_QUIT.setBackground(Color.red);
        Button_QUIT.setEnabled(false);

        Button_SUBMIT.setLabel("SUBMIT");
        Button_SUBMIT.setMargin(new java.awt.Insets(1, 1, 1, 1));
        Button_SUBMIT.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    Button_SUBMITActionPerformed(evt);
                }
            }
        );

        getContentPane().add(Button_SUBMIT);
        Button_SUBMIT.setBounds(400, 470, 60, 20);
        Button_SUBMIT.getAccessibleContext().setAccessibleName("Button_SUBMIT");
        Button_SUBMIT.setEnabled(false);

        getContentPane().add(Field_CorrectAnsweres);
        Field_CorrectAnsweres.setBounds(40, 240, 59, 20);

        getContentPane().add(Field_QuestionNumber);
        Field_QuestionNumber.setBounds(690, 240, 60, 20);

        Label_CorrectAnsweres.setText("Correct Answers");
        getContentPane().add(Label_CorrectAnsweres);
        Label_CorrectAnsweres.setBounds(20, 220, 100, 14);

        Label_QuestionNumber.setText("Question Number");
        getContentPane().add(Label_QuestionNumber);
        Label_QuestionNumber.setBounds(680, 220, 100, 20);

    }                    

    private void Button_AnswerAncestorAdded(javax.swing.event.AncestorEvent evt){}

    private void Button_QUITActionPerformed(java.awt.event.ActionEvent evt)
    {
        fm.setVisible(false);
        Area_Output.setText("\n We will miss you :(\nDo come back again!!");
        Button_Answer.setEnabled(false);
        Button_QUIT.setEnabled(false);
        Button_START.setEnabled(true);            
    } 

    private void Button_SUBMITActionPerformed(java.awt.event.ActionEvent evt) 
    { 
        fm.setVisible(false);
        Button_QUIT.setEnabled(false);
        Field_Name.setText("");

        try
        {
            PrintWriter p=new PrintWriter(new BufferedWriter(new FileWriter("ScoreBoard.txt",true)));

            p.printf("%-20s",name);
            p.printf("%-10s",Correct);
            p.println();
            p.close();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Button_SUBMIT.setEnabled(false);
        Button_START.setEnabled(true);
        Button_Answer.setEnabled(false);
    }

    private void Button_STARTActionPerformed(java.awt.event.ActionEvent evt) 
    { 
        fm.setVisible(true);
        Button_Answer.setEnabled(true);
        Button_QUIT.setEnabled(true);
        QuestionNumber=0;
        Area_Output.setText(HEADER 
            + Question[QuestionNumber][0]
            +"\n\tOptions are given below:-"
            +"\n1) "+Question[QuestionNumber][1]
            +"\n2) "+Question[QuestionNumber][2]
            +"\n3) "+Question[QuestionNumber][3]
            +"\n4) "+Question[QuestionNumber][4]
            +"\n");

        Field_Input.setText("Enter your ANSWER here!");
        Field_Input.requestFocus();
        Field_Input.selectAll();
        Field_CorrectAnsweres.setText(Integer.toString(Correct));
        Field_QuestionNumber.setText(Integer.toString(QuestionNumber + 1));
        Correct = 0;
        QuestionNumber = 0;
        Button_Answer.setEnabled(true);
        Button_QUIT.setEnabled(true);
        Button_START.setEnabled(false);
        Button_SUBMIT.setEnabled(false);
    }                

    private void towards_End()
    {
        Area_Output.setText(Area_Output.getText() + 
            "\n\nYou got a sore of "+(Correct*2)+"/10 !! :-)\n Please enter your name down there, and submit your score!"); 
        Field_Name.setText("Enter your NAME here!");
        Field_Name.requestFocus();
        Field_Name.selectAll();
        name=Field_Name.getText();
        Button_SUBMIT.setEnabled(true);

    }

    private void ActionPerformed_Answer(java.awt.event.ActionEvent evt) 
    {
        if(QuestionNumber == Question.length)
        {
            towards_End();
        }

        if(QuestionNumber < Question.length)
        {                            
            Question[QuestionNumber][6] = Field_Input.getText();

            if(Question[QuestionNumber][5].equalsIgnoreCase(Question[QuestionNumber][6]))
            {
                Correct++; 
                Area_Output.setText("BINGO!! :D  That's right!\n\n");
            }
            else
            {
                Area_Output.setText("Ooops!!  The correct answer was: "  + Question[QuestionNumber][5] + "\n\n");
            }
            QuestionNumber++;
            if(QuestionNumber == Question.length)
            {
                towards_End();
                return;
            }               
            Field_Input.setText("");
            Field_Input.requestFocus();
            Field_Input.selectAll();
            Field_CorrectAnsweres.setText(Integer.toString(Correct));

            Area_Output.setText(Area_Output.getText() 
                + "Next question: \nQ.  " 
                + Question[QuestionNumber][0]
                +"options are given below:-"
                +"\n1) "+Question[QuestionNumber][1]
                +"\n2) "+Question[QuestionNumber][2]
                +"\n3) "+Question[QuestionNumber][3]
                +"\n4) "+Question[QuestionNumber][4]
                +"\n");

            Field_QuestionNumber.setText(Integer.toString(QuestionNumber + 1));
        }

    }                                    
}

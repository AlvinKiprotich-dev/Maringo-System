import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql. *;
public class RegistrationForm extends JPanel {


//GridBagConstraints gbcpanel = new GridBagConstraints();
    GridBagConstraints gbcnamelabel = new GridBagConstraints();

    GridBagConstraints gbcnamefield = new GridBagConstraints();
    GridBagConstraints gbcgenderlabel = new GridBagConstraints();
    GridBagConstraints gbcmaleradio = new GridBagConstraints();
    GridBagConstraints gbcfemaleradio = new GridBagConstraints();
    GridBagConstraints gbcdoblabel = new GridBagConstraints();
    GridBagConstraints gbcdobfield = new GridBagConstraints();
    GridBagConstraints gbccontact = new GridBagConstraints();
    GridBagConstraints gbccontactfield = new GridBagConstraints();
    GridBagConstraints gbckin = new GridBagConstraints();
    GridBagConstraints gbckinfield = new GridBagConstraints();
    GridBagConstraints gbcsubcounty = new GridBagConstraints();
    GridBagConstraints gbcsubcountyfield = new GridBagConstraints();
    GridBagConstraints gbcschool = new GridBagConstraints();
    GridBagConstraints gbcschoolfield = new GridBagConstraints();
    GridBagConstraints gbcweight = new GridBagConstraints();
    GridBagConstraints gbcweightfield = new GridBagConstraints();
    GridBagConstraints gbcheight = new GridBagConstraints();
    GridBagConstraints gbcheightfield = new GridBagConstraints();
    GridBagConstraints gbcdisability = new GridBagConstraints();
    GridBagConstraints gbcyes = new GridBagConstraints();
    GridBagConstraints gbcno = new GridBagConstraints();
    GridBagConstraints gbcdescribe = new GridBagConstraints();
    GridBagConstraints gbcdescribefield = new GridBagConstraints();
    GridBagConstraints gbcenroll = new GridBagConstraints();
    GridBagConstraints gbcindividual = new GridBagConstraints();
    GridBagConstraints gbcgroup = new GridBagConstraints();
    GridBagConstraints gbcpayment = new GridBagConstraints();
    GridBagConstraints gbcusername = new GridBagConstraints();
    GridBagConstraints gbcusernamefield = new GridBagConstraints();
    GridBagConstraints gbcpassword = new GridBagConstraints();
    GridBagConstraints gbcpasswordfield = new GridBagConstraints();
    GridBagConstraints gbcsubmit= new GridBagConstraints();
    //GridBagConstraints gbcgamelabel= new GridBagConstraints();
    GridBagConstraints gbcgames= new GridBagConstraints();

    //GridBagConstraints gbc = new GridBagConstraints();
    private Connection conn;
    private Statement stmt;
    public RegistrationForm() {
        super();
              setLayout(new GridBagLayout());

                        //gbc.insets = new Insets(10, 10, 10, 10);
                        setSize(400, 500);
                        setBackground(Color.GRAY);

                        JLabel nameLabel = new JLabel("Name: ");
                        JLabel username = new JLabel("Preferred username:");
                        JTextField usernamefield = new JTextField(20);
                        JLabel password=new JLabel("Preffered password");
                        JPasswordField passwordfield=new JPasswordField(20);

                        JTextField nameField = new JTextField(20);


                        JLabel genderLabel = new JLabel("Gender: ");
                        JRadioButton maleradio = new JRadioButton("Male  ");
                        JRadioButton femaleradio = new JRadioButton("Female");
                        ButtonGroup genderGroup = new ButtonGroup();
                        genderGroup.add(maleradio);
                        genderGroup.add(femaleradio);


                        JLabel dobLabel = new JLabel("Date of Birth (YYYY-MM-DD): ");
                        JTextField dobField = new JTextField(20);

                        JLabel contact = new JLabel("Contact details");
                        JTextField contactfield = new JTextField(20);


                        JLabel kin = new JLabel("Next of kin");
                        JTextField kinfield = new JTextField(20);

                        JLabel subcounty = new JLabel("Sub-county of residence");
                        JTextField subcountyfield = new JTextField(20);

                        JLabel school = new JLabel("School or college");
                        JTextField schoolfield = new JTextField(20);

                        JLabel weight = new JLabel("Weight");
                        JTextField weightfield = new JTextField(5);

                        JLabel height = new JLabel("Height");
                        JTextField heightfield = new JTextField(5);

                        JLabel disability = new JLabel("Living with disability");
                        JRadioButton yes = new JRadioButton("Yes");
                        JRadioButton no = new JRadioButton("No ");
                        ButtonGroup disb = new ButtonGroup();
                        disb.add(yes);
                        disb.add(no);

                        JLabel describe = new JLabel("If YES describe:");
                        JTextField describefield = new JTextField(20);
                        describefield.setPreferredSize(new Dimension(100,50));

                        JLabel enroll = new JLabel("Enrolling as:");
                        JRadioButton individual = new JRadioButton("Individual");
                        JRadioButton group = new JRadioButton("Group");
                        ButtonGroup enrol = new ButtonGroup();
                        enrol.add(individual);
                        enrol.add(group);

                        JLabel payment = new JLabel(" Make payment(Individual=Ksh1000 Group=Ksh500/=) \nPaybill 456782 (Cash not accepted)");
                        JLabel game=new JLabel("Select game of interest :");
                        JButton submit = new JButton("SUBMIT");
        gbcnamelabel.gridx = 0;
        gbcnamelabel.gridy = 0;
        gbcnamelabel.insets = new Insets(5, 5, 5, 5);
        add(nameLabel,gbcnamelabel);

        gbcnamefield.gridx = 1;
        gbcnamefield.gridy = 0;
        gbcnamefield.insets = new Insets(5, 5, 5, 5);
        add(nameField,gbcnamefield);

        gbcgenderlabel.gridx = 0;
        gbcgenderlabel.gridy = 1;
        gbcgenderlabel.insets = new Insets(5, 1, 5, 0);
        add(genderLabel,gbcgenderlabel);

        gbcmaleradio.gridx = 1;
        gbcmaleradio.gridy = 1;
        gbcmaleradio.insets = new Insets(5, 0, 1, 0);
        add(maleradio,gbcmaleradio);

        gbcfemaleradio.gridx = 1;
        gbcfemaleradio.gridy = 2;
        gbcfemaleradio.insets = new Insets(1, 0, 5, 5);
        add(femaleradio,gbcfemaleradio);

        gbcdoblabel.gridx = 0;
        gbcdoblabel.gridy = 3;
        gbcdoblabel.insets = new Insets(5, 5, 5, 5);
                        add(dobLabel,gbcdoblabel);
        gbcdobfield.gridx = 1;
        gbcdobfield.gridy = 3;
        gbcdobfield.insets = new Insets(5, 5, 5, 5);
                        add(dobField,gbcdobfield);
        gbccontact.gridx = 0;
        gbccontact.gridy = 4;
        gbccontact.insets = new Insets(5, 5, 5, 5);
                        add(contact,gbccontact);
        gbccontactfield.gridx = 1;
        gbccontactfield.gridy = 4;
        gbccontactfield.insets = new Insets(5, 5, 5, 5);
                        add(contactfield,gbccontactfield);
        gbckin.gridx = 0;
        gbckin.gridy = 5;
        gbckin.insets = new Insets(5, 5, 5, 5);
                        add(kin,gbckin);
        gbckinfield.gridx = 1;
        gbckinfield.gridy = 5;
        gbckinfield.insets = new Insets(5, 5, 5, 5);
                        add(kinfield,gbckinfield);
        gbcsubcounty.gridx = 0;
        gbcsubcounty.gridy = 6;
        gbcsubcounty.insets = new Insets(5, 5, 5, 5);
                        add(subcounty,gbcsubcounty);
        gbcsubcountyfield.gridx = 1;
        gbcsubcountyfield.gridy = 6;
        gbcsubcountyfield.insets = new Insets(5, 5, 5, 5);
                        add(subcountyfield,gbcsubcountyfield);
        gbcschool.gridx = 0;
        gbcschool.gridy = 7;
        gbcschool.insets = new Insets(5, 5, 5, 5);
                        add(school,gbcschool);
        gbcschoolfield.gridx = 1;
        gbcschoolfield.gridy = 7;
        gbcschoolfield.insets = new Insets(5, 5, 5, 5);
                        add(schoolfield,gbcschoolfield);
        gbcweight.gridx = 0;
        gbcweight.gridy = 8;
        gbcweight.insets = new Insets(5, 1, 5, 1);
                        add(weight,gbcweight);
        gbcweightfield.gridx = 1;
        gbcweightfield.gridy = 8;
        gbcweightfield.insets = new Insets(5, 1, 5, 1);
                        add(weightfield,gbcweightfield);
        gbcheight.gridx = 0;
        gbcheight.gridy = 9;
        gbcheight.insets = new Insets(5, 0, 5, 0);
                        add(height,gbcheight);
        gbcheightfield.gridx = 1;
        gbcheightfield.gridy = 9;
        gbcheightfield.insets = new Insets(5, 0, 5, 5);
                        add(heightfield,gbcheightfield);
        gbcdisability.gridx = 0;
        gbcdisability.gridy = 10;
        gbcdisability.insets = new Insets(5, 1, 5, 5);
                        add(disability,gbcdisability);
        gbcyes.gridx = 1;
        gbcyes.gridy = 10;
        gbcyes.insets = new Insets(5, 0, 1, 0);
                        add(yes,gbcyes);
        gbcno.gridx = 1;
        gbcno.gridy = 11;
        //gbcno.insets = new Insets(5, 0, 5, 0);
                        add(no,gbcno);
        gbcdescribe.gridx = 0;
        gbcdescribe.gridy = 13;
        gbcdescribe.insets = new Insets(5, 1, 5, 0);
                        add(describe,gbcdescribe);
        gbcdescribefield.gridx = 1;
        gbcdescribefield.gridy = 13;
        gbcdescribefield.insets = new Insets(5, 0, 5, 0);
                        add(describefield,gbcdescribefield);
        gbcenroll.gridx = 0;
        gbcenroll.gridy = 14;
        gbcenroll.insets = new Insets(5, 0, 5, 0);
                         add(enroll,gbcenroll);
        gbcindividual.gridx = 1;
        gbcindividual.gridy = 14;
        gbcindividual.insets = new Insets(5, 0, 1, 0);
                         add(individual,gbcindividual);
        gbcgroup.gridx = 1;
        gbcgroup.gridy = 15;
        gbcgroup.insets = new Insets(1, 0, 5, 0);
                         add(group,gbcgroup);
        gbcpayment.gridx = 1;
        gbcpayment.gridy = 16;
        gbcpayment.insets = new Insets(5, 0, 5, 0);
                         add(payment,gbcpayment);
        gbcgames.gridx = 0;
        gbcgames.gridy = 18;
        gbcgames.insets = new Insets(5, 0, 5, 0);
        add(game,gbcgames);


        String cb[]={"","swimming", "hockey", "lawn tennis", "table tennis", "darts", "badminton", "volleyball",
                "basketball", "netball", "football", "baseball", "rugby", "pool", "chess","draft"};
        JComboBox games=new JComboBox(cb);
        games.setBounds(80,80,80,80);
        gbcgames.gridx = 1;
        gbcgames.gridy = 18;
        gbcgames.insets = new Insets(5, 0, 5, 0);
        add(games,gbcgames);

        gbcusername.gridx = 0;
        gbcusername.gridy = 19;
        gbcusername.insets = new Insets(5, 0, 5, 0);
                         add(username,gbcusername);
        gbcusernamefield.gridx = 1;
        gbcusernamefield.gridy = 19;
        gbcusernamefield.insets = new Insets(5, 0, 5, 0);
                            add(usernamefield,gbcusernamefield);
        gbcpassword.gridx = 0;
        gbcpassword.gridy = 20;
        gbcpassword.insets = new Insets(5, 0, 5, 0);
                         add(password,gbcpassword);

        gbcpasswordfield.gridx = 1;
        gbcpasswordfield.gridy = 20;
        gbcpasswordfield.insets = new Insets(5, 0, 5, 0);
                          add(passwordfield,gbcpasswordfield);

        gbcsubmit.gridx = 1;
        gbcsubmit.gridy = 21;
        gbcsubmit.insets = new Insets(5, 5, 5, 5);
        add(submit,gbcsubmit);

        //setVisible(true);
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                                                 String Nname = nameField.getText();
                                                 String gender = maleradio.isSelected() ? "Male" : "Female";
                                                 String birthdate = dobField.getText();
                                                 String contact = contactfield.getText();
                                                 String nextofkin = kinfield.getText();
                                                 String subcounty = subcountyfield.getText();
                                                 String school = schoolfield.getText();
                                                 String weight = weightfield.getText();
                                                 String height = heightfield.getText();
                                                 String username=usernamefield.getText();
                                                 String Game=games.getSelectedItem().toString();
                                                 char[] passwordchar =passwordfield.getPassword();
                                                 String ppassword = new String(passwordchar);
                                                 String disability = yes.isSelected() ? "Yes" : "No";
                                                 String ddescription = describefield.getText();
                                                 String Roles="Member";
                                                 String enroll = individual.isSelected() ? "Individual" : "Group";
                                                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Name :" + Nname + "\nGender :" + gender + "\n Date of birth :" + birthdate +
                                                         "\n Contact :" + contact + "\n Next of kin :" + nextofkin + "\nSub-county of residence" + subcounty +
                                                         "\nSchool or College :" + school + "\nWeight :" + weight + "\nHeight :" + height + "\nLeaving with disability :" + disability +
                                                         "\nDescription of disability :" + ddescription + "Game of Choice:"+Game+"\nEnrolling as :" + enroll);
                        try{
                            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Aqqa1234%");
                            stmt=conn.createStatement();
                            String sql="INSERT INTO user_registration VALUES('"+Nname+"','"+gender+"','"+birthdate+"','"+contact+"','"+nextofkin+"'," +
                                    "'"+subcounty+"','"+school+"','"+weight+"','"+height+"','"+ddescription+"','"+enroll+"','"+username+"','"+ppassword+"','"+Game+"','"+Roles+"')";
                            stmt.executeUpdate(sql);

                            System.out.println("New sign up");
                            JOptionPane.showMessageDialog(null, "Registration success! Awaiting approval");
                        }catch(SQLException e1){
                            e1.printStackTrace();
                        }


                    }});
    }

    }

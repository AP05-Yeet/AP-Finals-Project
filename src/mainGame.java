import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class mainGame {

    public static class Game {

        JFrame game;
        Container con;
        JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
        JLabel titleNameLabel, hpLabel, hpLabelNumber, hungerLable, hungerLableNumber, energyLable, energyLableNumber;
        Font titleFont = new Font("Skullsandcrossbones", Font.PLAIN, 90);
        Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
        Font endingFont = new Font("Times New Roman", Font.PLAIN, 50);
        JButton startButton, choice1, choice2, choice3, choice4;
        JTextArea mainTextArea;
        int playerHP;
        int hungerLevel;
        int energyLevel;
        int escapeProgress;
        int surviveProgress;
        int escape;
        int time;
        int day;
        static int Gday = 1;
        double huntingRandom;
        double forgingRandom;
        String weapon, position;
        static List<Integer> morning = new ArrayList<Integer>();
        static List<Integer> noon = new ArrayList<Integer>();
        static List<Integer> night = new ArrayList<Integer>();

        TitleScreenHandler tsHandler = new TitleScreenHandler();
        ChoiceHandler choiceHandler = new ChoiceHandler();

        ImageIcon logo = new ImageIcon("D:\\My Random Things\\Anime\\FAzc-hrWYAUJ-p2.jpg");


        public static void main(String[] args) {
            timeList();
            new Game();
        }

        public Game() {

            game = new JFrame();
            game.setSize(1200, 600);
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.getContentPane().setBackground(Color.black);
            game.setLayout(null);
            game.setIconImage(logo.getImage());
            con = game.getContentPane();

            titleNamePanel = new JPanel();
            titleNamePanel.setBounds(100, 100, 1000, 150);
            titleNamePanel.setBackground(Color.black);
            titleNameLabel = new JLabel("Sailors Nightmare");
            titleNameLabel.setForeground(Color.white);
            titleNameLabel.setFont(titleFont);

            startButtonPanel = new JPanel();
            startButtonPanel.setBounds(500, 400, 200, 100);
            startButtonPanel.setBackground(Color.black);

            startButton = new JButton("START");
            startButton.setBackground(Color.black);
            startButton.setForeground(Color.white);
            startButton.setFont(normalFont);
            startButton.addActionListener(tsHandler);
            startButton.setFocusPainted(false);

            titleNamePanel.add(titleNameLabel);
            startButtonPanel.add(startButton);

            con.add(titleNamePanel);
            con.add(startButtonPanel);

            game.setVisible(true);
        }

        public void createGameScreen() {
            titleNamePanel.setVisible(false);
            startButtonPanel.setVisible(false);

            mainTextPanel = new JPanel();
            mainTextPanel.setBounds(100, 100, 1000, 250);
            mainTextPanel.setBackground(Color.black);
            con.add(mainTextPanel);
            mainTextArea = new JTextArea("MAIN AREA");//MAIN STORY
            mainTextArea.setBounds(300, 100, 1000, 250);
            mainTextArea.setBackground(Color.black);
            mainTextArea.setForeground(Color.white);
            mainTextArea.setFont(normalFont);
            mainTextArea.setLineWrap(true);
            mainTextArea.setWrapStyleWord(true);
            mainTextArea.setEditable(false);

            mainTextPanel.add(mainTextArea);

            choiceButtonPanel = new JPanel();//options setup
            choiceButtonPanel.setBounds(350, 350, 500, 150);
            choiceButtonPanel.setBackground(Color.black);
            choiceButtonPanel.setLayout(new GridLayout(4, 1));
            con.add(choiceButtonPanel);

            choice1 = new JButton("Choice 1");
            choice1.setBackground(Color.black);
            choice1.setForeground(Color.white);
            choice1.setFont(normalFont);
            choice1.setFocusPainted(false);
            choice1.addActionListener(choiceHandler);
            choice1.setActionCommand("c1");
            choiceButtonPanel.add(choice1);

            choice2 = new JButton("Choice 2");
            choice2.setBackground(Color.black);
            choice2.setForeground(Color.white);
            choice2.setFont(normalFont);
            choice2.setFocusPainted(false);
            choice2.addActionListener(choiceHandler);
            choice2.setActionCommand("c2");
            choiceButtonPanel.add(choice2);

            choice3 = new JButton("Choice 3");
            choice3.setBackground(Color.black);
            choice3.setForeground(Color.white);
            choice3.setFont(normalFont);
            choice3.setFocusPainted(false);
            choice3.addActionListener(choiceHandler);
            choice3.setActionCommand("c3");
            choiceButtonPanel.add(choice3);

            choice4 = new JButton("Choice 4");
            choice4.setBackground(Color.black);
            choice4.setForeground(Color.white);
            choice4.setFont(normalFont);
            choice4.setFocusPainted(false);
            choice4.addActionListener(choiceHandler);
            choice4.setActionCommand("c4");
            choiceButtonPanel.add(choice4);


//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!


            playerPanel = new JPanel();
            playerPanel.setBounds(200, 15, 1000, 50);
            playerPanel.setBackground(Color.black);
            playerPanel.setLayout(new GridLayout(1, 4));
            con.add(playerPanel);

            hpLabel = new JLabel("HP:");
            hpLabel.setFont(normalFont);
            hpLabel.setForeground(Color.white);
            playerPanel.add(hpLabel);

            hpLabelNumber = new JLabel();
            hpLabelNumber.setFont(normalFont);
            hpLabelNumber.setForeground(Color.white);
            playerPanel.add(hpLabelNumber);


            hungerLable = new JLabel("Hunger:");
            hungerLable.setFont(normalFont);
            hungerLable.setForeground(Color.white);
            hungerLable.setBackground(Color.red);
            playerPanel.add(hungerLable);

            hungerLableNumber = new JLabel();
            hungerLableNumber.setFont(normalFont);
            hungerLableNumber.setForeground(Color.white);
            playerPanel.add(hungerLableNumber);

            energyLable = new JLabel("Energy:");
            energyLable.setFont(normalFont);
            energyLable.setForeground(Color.white);
            energyLable.setBackground(Color.red);
            playerPanel.add(energyLable);

            energyLableNumber = new JLabel();
            energyLableNumber.setFont(normalFont);
            energyLableNumber.setForeground(Color.white);
            playerPanel.add(energyLableNumber);

            playerSetup();

        }

        public void playerSetup() {

            playerHP = 100;
            hungerLevel = 60;
            energyLevel = 80;
            //hungerLevel = -600;   //DEBUGGING
            //energyLevel = 800;    //DEBUGGING
            escapeProgress = 0;
            //surviveProgress = 0;
            escape = 0;
            time = 1;
            //day = 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);

            prologue1();
        }
        public void prologue1() {
            position = "prologue1";
            mainTextArea.setText("Stranger: Hey, c’mon. You really need to get up.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("JUMP");
        }
        public void prologue2() {
            position = "prologue2";
            mainTextArea.setText("Still shaking off the last vestiges of your deep slumber, " +
                    "you manage to make your body sit up. The first thing you’re alert enough to notice " +
                    "- the taste of sand. Odd, you think to yourself. " +
                    "You could’ve sworn you managed to make it to your quarters before passing " +
                    "out from yet another drunken revelry, as you and your shipmates got up to each and every night." +
                    " In fact, just where are you? ");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue3() {
            position = "prologue3";
            mainTextArea.setText("Stranger: Well, well, well. Look who’s finally decided to wake up. " +
                    "Had a good nap? Bet you did. Anyway, might be a good idea to open your eyes, yknow.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue4() {
            position = "prologue4";
            mainTextArea.setText("Perplexed, you open your eyes to take a look at just whoever was" +
                    " rude enough to separate a man from his rest. Shockingly enough, " +
                    "you gaze not upon the ramshackle wood of your ship, but the wide, " +
                    "open ocean - and a goat all in your personal space.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue5() {
            position = "prologue5";
            mainTextArea.setText("Stranger: Finally! Been wondering if you must’ve broke your brain " +
                    "or something. Well, how’re you feeling right now.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue6() {
            position = "prologue6";
            mainTextArea.setText("Shocked, you can’t help but stammer and stutter, your brain out of sync " +
                    "with your eyes and ears. How was this animal speaking to you?");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue7() {
            position = "prologue7";
            mainTextArea.setText("Stranger: Shocked? You’ll get used to it. Anyway, " +
                    "just why are you on my island? Awfully rude to just make yourself at home like this.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue8() {
            position = "prologue8";
            mainTextArea.setText("Still beyond obfuscated from these recent events, " +
                    "you notice a scrap of parchment wrapped tightly to your arm. " +
                    "You choose to avert your attention from whatever this thing was and take a quick look." +
                    " Unfurling the paper, you notice the distinct chickenscratch of your captain. The letter says:\n");
            choice1.setText("Read Letter");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue9() {
            position = "prologue9";
            mainTextArea.setText("Captain's letter: Hey. It’s me. By now, you’re probably wondering what in blazes " +
                    "is going on, right? Truth is, i’m awfully sorry we had to do this. " +
                    "These past few years, you’ve been a great crewmate. A great friend to boot, too. " +
                    "But after what happened last night, it was too dangerous for us to keep you on this " +
                    "ship any longer. We put it to a vote and the best idea was to leave you on this island. " +
                    "We wouldn’t be able to stomach putting you to the sword or plank. But just after… \n");
            choice1.setText("Continue to read");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue10() {
            position = "prologue10";
            mainTextArea.setText("The middle of the letter was intelligible, a smear of wet ink marred the page. " +
                    "The only thing you could make out from that point was the closing sentences, stating:\n");
            choice1.setText("Read what was stated");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue11() {
            position = "prologue11";
            mainTextArea.setText("Captain's letter: We left some food and water for you. You’re a resourceful man, truth be told. " +
                    "I sincerely hope you can figure out a way to get off this island, " +
                    "and possibly meet with us again. If you make it off, put in a word for me to the bare hand at " +
                    "Devil’s Heartbeat, at the east end of Bristol, back in England. He’s a close friend, and he’s " +
                    "got connections.");
            choice1.setText("Continue to read");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue12() {
            position = "prologue12";
            mainTextArea.setText("We’ll make our way as fast as we can once we get the word. And if, Davy Jones " +
                    "forbid, you can’t make it off, we left you a flintlock with a single shot inside. " +
                    "You’d know what to do with that if it came down to it. Anyways, we don’t have much time " +
                    "left to write this. I hope you don’t think too ill of us, all in all.");
            choice1.setText("Read bottom");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue13() {
            position = "prologue13";
            mainTextArea.setText("Best Regards, \n" +
                    "Captain Gaw.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue14() {
            position = "prologue14";
            mainTextArea.setText("Huh. Just what did this mean? If only that middle section was still legible, " +
                    "because without it this was hardly any help in making sense of anything. " +
                    "You begin to place the paper back in your pocket when " +
                    "the goat defies all logic and speaks again.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue15() {
            position = "prologue15";
            mainTextArea.setText("Stranger: Hey, kid. You can’t spend the whole day just staring off into space." +
                    " Get with the program.\n" +
                    "\n" +
                    "You stand up and pinch yourself, trying to wake up from this accursed dream.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue16() {
            position = "prologue16";
            mainTextArea.setText("Stranger: Really? Sorry to break it to you, but this is real. " +
                    "Let me get you up to speed. I’m Cortez, at least, that’s what I call myself. " +
                    "This island has a curse. You see, I was once human, just like you." +
                    " Not so much anymore, sadly. You see, on the 31st day of my own abandonment by my crew, " +
                    "I woke up on four legs instead of two. I’ve been waiting ages for someone without " +
                    "hooves to come and take me off this island.");
            choice1.setText("Continue to listen");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue17() {
            position = "prologue17";
            mainTextArea.setText("Cortez: So, hate to burden you like this so out of the blue, " +
                    "but time waits for no one. You’ve got to make it off of here by then, " +
                    "or else you’ll be trapped here just like me. So get to it! Oh, and remember. " +
                    "This island isn’t an ordinary island. You’ll need to be on your wits to not " +
                    "just avoid the standard death by starvation and illness, but the nighttime monsters as well. " +
                    "Anyway, that’s neither here nor there. You’ve got to make use of your time. " +
                    "I’ll do my best to help, but I can’t guarantee much. Again, get to it!");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void prologue18() {
            position = "prologue18";
            mainTextArea.setText("Well, time to make the most of your situation.");
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void GameLoop() {
            position = "GameLoop";
            checkDead();
            limiter();
            String timeCheck = "DID NOT WORK";
            timeCheck = timeCheck(time);
            int daytime = 0;
            daytime = time;

            if (time == 4 || time == 7 || time == 10 || time == 13 || time == 16 || time == 19 ||
                    time == 22 || time == 25 || time == 28 || time ==31 || time == 34 || time == 37 ||
                    time == 40 || time == 43 || time == 46 || time == 49 || time == 52 || time == 55 ||
                    time == 58 || time == 61 || time == 64 || time == 67 || time == 70 || time == 73 ||
                    time == 76 || time == 79 || time == 82 || time == 85 || time == 88 || time == 91 ){
                Gday = Gday+1;
            } if (Gday == 32){death();}

            mainTextArea.setText("                                                     Day: " + Gday +
                    "\n                                                     Time: " + timeCheck);
                                                            System.out.println(escapeProgress);

                    String c1 = null;
            if(escapeProgress == 7){c1 = "!!!ESCAPE!!!";} else {c1 = "Prepare Escape";}          //add an if statement to check for daytime
            choice1.setText(c1);
            choice2.setText("Hunting");
            choice3.setText("Forging");
            choice4.setText("Rest");
        }



        public void hunting1() {
            position = "hunting1";
            mainTextArea.setText("You pick up a spear and hunt for rabbits, which you share with Cortez.\n" +
                    "-25 hunger, +10 hp, -10 energy\n");
            hungerLevel = hungerLevel -25;
            energyLevel = energyLevel - 10;
            playerHP = playerHP + 10;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void hunting2() {
            position = "hunting2";
            mainTextArea.setText("You look for deer, but stumble across a boar carcass instead. It’s a fresh kill, so might as well.\n" +
                    "-35 hunger, +20 hp\n");
            hungerLevel = hungerLevel -35;
            energyLevel = energyLevel - 10;
            playerHP = playerHP + 20;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void hunting3() {
            position = "hunting3";
            mainTextArea.setText("A wild boar rushes at you in the forest. After a tumultuous battle, you slay the beast and reap the spoils.\n" +
                    "-30 hunger, +25 hp, -20 energy\n");
            //surviveProgress = 2;
            hungerLevel = hungerLevel -30;
            energyLevel = energyLevel - 20;
            playerHP = playerHP + 20;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void hunting4() {
            position = "hunting4";
            mainTextArea.setText("You take up a rod and go fish. A few hours later, you snag a modestly sized bass.\n" +
                    "-30 hunger, +15 hp, -5 energy\n");
            //surviveProgress = 2;
            hungerLevel = hungerLevel -30;
            energyLevel = energyLevel - 5;
            playerHP = playerHP + 15;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void hunting5() {
            position = "hunting5";
            mainTextArea.setText("You’ve got good luck while fishing today. A whole tuna finds itself on your line. A pain to catch, but full of meat.\n" +
                    "-65 hunger, +50 hp, -30 energy");
            surviveProgress = 2;
            hungerLevel = hungerLevel -65;
            energyLevel = energyLevel - 30;
            playerHP = playerHP + 50;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void randomHunt(){
            huntingRandom = Math.random()*15;
            System.out.println(huntingRandom);
        }

        public void forage1() {
            position = "forage1";
            mainTextArea.setText("You pick berries for a good while, eating as you go along the bushes.\n" +
                    "-15 hunger, + 5 health\n");
            //surviveProgress = 2;
            hungerLevel = hungerLevel -15;
            energyLevel = energyLevel;
            playerHP = playerHP + 5;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void forage2() {
            position = "forage2";
            mainTextArea.setText("Huh. A crate of food has washed up on the shore again, a bit too frequent occurrence. It’s kept well, so no use contemplating your luck.\n" +
                    "-20 hunger, +5 health\n");
            //surviveProgress = 2;
            hungerLevel = hungerLevel - 20;
            energyLevel = energyLevel;
            playerHP = playerHP + 5;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void forage3() {
            position = "forage3";
            mainTextArea.setText("A coconut tree proves quite easy to climb, and the milk and flesh is perfectly ripe too.\n" +
                    "-30 hunger, +15 health, -5 energy\n");
            //surviveProgress = 2;
            hungerLevel = hungerLevel -30;
            energyLevel = energyLevel - 20;
            playerHP = playerHP + 20;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void randomforage(){
            forgingRandom = Math.random()*10;
            System.out.println(forgingRandom);
        }

        public void escapeProgress1() {
            position = "escapeProgress1";
            mainTextArea.setText("First, you make an axe. You’ll need a tool so you can harvest resources from the island of course.\n" +
                    "Cortez: Smart thinking. Don’t hurt yourself!\n" +
                    " -10 energy, +10 hunger.\n");
            escapeProgress = 1;
                                                            System.out.println(escapeProgress);
            hungerLevel = hungerLevel + 10;
            energyLevel = energyLevel - 10;
            time = time + 1;
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void escapeProgress2() {
            position = "escapeProgress2";
            mainTextArea.setText("You begin to take as much wood as you need to build the raft. " +
                    "Cortez takes you to where he noticed the best quality materials.\n" +
                    "Cortez: “The wood here’s nice quality, it’ll suffice. " +
                    "I’ll keep watch for any monsters.”\n" +
                    "It’s tiring work though.\n" +
                    "-15 energy, +10 hunger.\n");
            escapeProgress = 2;
                                                            System.out.println(escapeProgress);
            hungerLevel = hungerLevel + 10;
            energyLevel = energyLevel - 15;
            time = time + 1;
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void escapeProgress3() {
            position = "escapeProgress3";
            mainTextArea.setText("Using what you learnt from foraging with the crew, you strip the waxy banana " +
                    "tree leaves and coil them into ropes. You take some bananas back to share.\n" +
                    "Cortez: “Thank you very much.”\n" +
                    "-5 energy, +0 hunger.\n");
            escapeProgress = 3;
            System.out.println(escapeProgress);
            hungerLevel = hungerLevel + 0;
            energyLevel = energyLevel - 5;
            time = time + 1;
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void escapeProgress4() {
            position = "escapeProgress4";
            mainTextArea.setText("The unkempt grass would make for a mediocre sail, but it’s all you have.\n" +
                    "Cortez: “You’re a real bright one, aintcha? I wouldnt have thought of that myself.”\n" +
                    "-15 energy, +15 hunger.\n");
            escapeProgress = 4;
            System.out.println(escapeProgress);
            hungerLevel = hungerLevel + 15;
            energyLevel = energyLevel - 15;
            time = time + 1;
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void escapeProgress5() {
            position = "escapeProgress5";
            mainTextArea.setText("It’s beginning to all come together. You spend some time carving a" +
                    " proper oar out of some driftwood on the shoreline.\n" +
                    "Cortez: “I may be able to use my mouth to grab the oar if you get tired of " +
                    "paddling when we set sail, but I can’t promise it’d work.”\n" +
                    "-10 energy, +10 hunger\n");
            escapeProgress = 5;
            System.out.println(escapeProgress);
            hungerLevel = hungerLevel + 10;
            energyLevel = energyLevel - 10;
            time = time + 1;
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void escapeProgress6() {
            position = "escapeProgress6";
            mainTextArea.setText("Cortez takes you to a shaded oasis, which has ample freshwater you " +
                    "can bottle and stock up on for the voyage.\n" +
                    "Cortez: “It’s lucky they gave you some canteens, isn’t it?”\n" +
                    "You take some for now as well.\n" +
                    "+10 energy, -5 hunger.\n");
            escapeProgress = 6;
            System.out.println(escapeProgress);
            hungerLevel = hungerLevel - 5;
            energyLevel = energyLevel + 10;
            time = time + 1;
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void escapeProgress7() {
            position = "escapeProgress7";
            mainTextArea.setText("Finally, the last step. Just to grab some food. You don’t know what’ll keep, " +
                    "so you grab some coconuts.\n" +
                    "Cortez: “Make sure to bring a basic fishing rod too.”\n" +
                    "You refrain from eating, as these are for reserves only.\n" +
                    "-10 energy, +15 hunger.\n" +
                    "With this, you’ve finally finished preparation. You’ll be setting sail tomorrow!\n");
            escapeProgress = 7;
            escape = 1;
            System.out.println(escapeProgress);
            hungerLevel = hungerLevel + 15;
            energyLevel = energyLevel - 10;
            time = time + 1;
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void ending1() {
            position = "ending1";
            mainTextArea.setText("It’s the day you’ve been waiting for ever since you woke up on this island." +
                    " Finally, you can take this raft you painstakingly engineered through your blood, sweat, " +
                    "and tears and leave this wretched island.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending2() {
            position = "ending2";
            mainTextArea.setText("You tell Cortez that once noon comes, the both of you will begin to set sail. " +
                    "You just need a bit of time to fashion a new fishing rod, just in case.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending3() {
            position = "ending3";
            mainTextArea.setText("Cortez: Sure thing! By the way, I’m just amazed at how successful you were at overcoming this ordeal. " +
                    "I’d have never suspected that we’d really be able to achieve this, truth be told.\n" +
                    "After saying that, he wanders off to check on the raft.”\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending4() {
            position = "ending4";
            mainTextArea.setText("Time passes. You notice how short your shadow is, a " +
                    "sign of the sun beating down just above you. It’s almost noon, so " +
                    "you make your way to the raft.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending5() {
            position = "ending5";
            mainTextArea.setText("Just as you reach the shore, you notice something is off. " +
                    "There’s a strange absence of rafts from the shoreline. Dread washes over " +
                    "as you notice the raft, without you or Cortez, all the way off in the horizon, " +
                    "completely lost to you.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending6() {
            position = "ending6";
            mainTextArea.setText("As you make your way over to him, Cortex rears his head towards you and smiles. " +
                    "Given the circumstances, you feel more confused than ever.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending7() {
            position = "ending7";
            mainTextArea.setText("You try to get an answer out of him, but he doesn’t really pay you any mind. " +
                    "He just sits and smiles. You notice the smile growing wider and wider, " +
                    "wider than any mouth should be. Suddenly, an insidious voice echoes from his gaping maw.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending8() {
            position = "ending8";
            mainTextArea.setText("Cortez: How foolish of you. Surely, you couldn’t have expected it to be this easy? " +
                    "\nAs he cackles at your fate, his body swells and distorts in a nauseating manner. " +
                    "You realize you made a grave mistake following his orders, for this was no mere goat, " +
                    "but a spawn of satan himself.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending9() {
            position = "ending9";
            mainTextArea.setText("Cortez - or what was once Cortez - is now the spitting image of malice. " +
                    "He looks at you as if you were no more than a worm to him. " +
                    "\nCortez:So naive. Just a smidgen of praise and you were putty in my hands. " +
                    "Humans are so gullible.”\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending10() {
            position = "ending10";
            mainTextArea.setText("Cortez: That letter? Pure fabrication. I just plucked you from your ship " +
                    "and put you here. Simple as. I doubt a minute’s even passed since you’ve been gone. " +
                    "The degree of control I exert over you puny lower lifeforms is simply incalculable to you.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending11() {
            position = "ending11";
            mainTextArea.setText("Why are you here, you ask? What was the purpose of this? Why did I do what I did?" +
                    " Because I can. You live as long as me, you’ll tire of the norm after a few hundred millennia." +
                    "You’ve given me satisfactory amusement. The best part? Seeing the look on your face as you saw " +
                    "that measly raft drift away. Worth every second I had to put up with you.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending12() {
            position = "ending12";
            mainTextArea.setText("Cortez: Anyway, I’ve gone on long enough. I’ll just quickly put you out of your " +
                    "misery. It’s been nice knowing you");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending13() {
            position = "ending13";
            mainTextArea.setText("His spindly fingers transmute into razor-sharp talons, each a lethal weapon. " +
                    "You can see where he’s going with this. As he swings his blades down at you, adrenaline surges " +
                    "through you. Pure fight or flight, your mind is outpaced by your body. " +
                    "You instinctively grab your gun, which you kept on you all this time. " +
                    "Instinctively, you aim your flintlock at the temple of the eldritch horror");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending14() {
            position = "ending14";
            mainTextArea.setText("BANG!!!");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending15() {
            position = "ending15";
            mainTextArea.setText("The bullet bounces off his body, as if it was rubber. You understood the futility " +
                    "of your actions against such a creature, but you weren’t willing to go without a fight. " +
                    "You brace yourself for his attack, but, shockingly enough, it never comes. " +
                    "Cortez bursts into laughter yet again.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending16() {
            position = "ending16";
            mainTextArea.setText("Cortez: To think a human would try to shoot me? A god? I saw your entire galaxy " +
                    "form from pure dust in the cosmos, and you tried to shoot me? You must be the one of the " +
                    "stupidest men I’ve ever seen, and I’ve seen each and every one of them. Conversely, " +
                    "you’ve proven yourself as one of the most interesting I’ve come across.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending17() {
            position = "ending17";
            mainTextArea.setText("Cortez: Yes, to put an end to your journey here would be most disappointing. " +
                    "If only your entire species was akin to you. Perhaps I wouldn’t be so lost for entertainment " +
                    "all the time. As a reward for showing me such a good time, I’ll let you back to your " +
                    "menial existence. I’ll make sure to keep my eye on you though, I expect great things from you." +
                    "Well, off you go!");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending18() {
            position = "ending18";
            mainTextArea.setText("You feel reality collapse in on itself. After that, you experience sights and " +
                    "sounds no language could even begin to interpret, as you presumably " +
                    "make it back to your own life.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending19() {
            position = "ending19";
            mainTextArea.setText("You wake up from your bed, drenched in cold sweat. " +
                    "You can only faintly remember what woke you so suddenly. Something about an island, and a goat. " +
                    "That’s all you can recollect. As your brain wakes from slumber, you realize " +
                    "how bizarre the whole scenario was. It was a dream, it couldn’t have been anything " +
                    "but a dream. You roll back into bed, but something feels off.\n");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending20() {
            position = "ending20";
            mainTextArea.setText("You take off the covers and see a fishing rod, freshly carven, in your bed. How odd." +
                    "You brush it aside, and remind yourself to cut back on the rum and whiskey " +
                    "before bed. You’re tired, more tired than you’ve ever been before, and want " +
                    "nothing more than to go back to bed. And, so you do.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void ending21() {
            position = "ending21";
            mainTextArea.setText("Well, time to make the most of your situation.");
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }



        public void rest(){
            position = "rest";
            time = time + 1;
            playerHP = playerHP + 5;
            hungerLevel = hungerLevel + 5;
            energyLevel = energyLevel + 10;
            limiter();
            HealthHandler(playerHP);
            GameLoop();
        }

        public void checkDead(){
            if(playerHP <= 0){death();}
        }

        public void limiter(){
            if (playerHP >= 100){playerHP = 100;}
            if (hungerLevel >= 100){hungerLevel = 100;}
            if (hungerLevel <= 0) {hungerLevel = 0;}
            if (energyLevel >= 100){energyLevel = 100;}
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
        }

        public void couldNotHunt(){
            position = "couldNotHunt";

            mainTextArea.setText("You are either too hurt or out of energy. \nYou need to replenish " +
                    "that before we can go to hunt. \nMaybe try to rest");

            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void couldNotForge() {
            position = "couldNotForge";

            mainTextArea.setText("You are out of energy. \nYou need to rest " +
                    "before we can go to hunt. \nMaybe try to rest");

            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void couldNotRest(){
            position = "couldNotRest";

            mainTextArea.setText("You are too hungry to rest. \nYou need to replenish " +
                    "that before we can continue preparations. \nMaybe try to survive by looking for food");

            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void cannotPrepEscape() {
            position = "cannotPrepEscape";

            mainTextArea.setText("You are either too hungry or out of energy. \nYou need to replenish " +
                    "that before we can continue preparations");

            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void couldNotEscape() {
            position = "couldNotEscape";

            mainTextArea.setText("You could not escape! \nYou were either too hungry or tired to escape" +
                    " successfully. \n You need to replenish " +
                    "that before we can reattempt to escape.");

            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void couldNotEscapeT() {
            position = "couldNotEscapeT";

            mainTextArea.setText("You could not escape! \nBecause it is not Morning yet." +
                    "  \n You need to wait a little longer " +
                    " before we can attempt to escape.");

            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void ESCAPE() {
            position = "ESCAPE";
            mainTextArea.setLocation(600,300);
            mainTextPanel.setLayout(new GridBagLayout());
            mainTextPanel.add(mainTextArea);
            mainTextPanel.add(mainTextArea);
            mainTextPanel.setBorder(BorderFactory.createEmptyBorder(10, 700, 10, 1));
            mainTextArea.setFont(endingFont);
            mainTextArea.setText("YOU ESCAPED!\n\n  GAME OVER");

            choice1.setText("");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            choice1.setVisible(false);
            choice2.setVisible(false);
            choice3.setVisible(false);
            choice4.setVisible(false);
        }

        public void death() {
            position = "died";

            mainTextArea.setText("You are dead!\n\nGAME OVER");

            choice1.setText("Game Over");
            choice2.setText("YOU DED");
            choice3.setText("L + BOZO");
            choice4.setText("");
           /* choice1.setVisible(false);
            choice2.setVisible(false);
            choice3.setVisible(false);
            choice4.setVisible(false);*/
        }

        public void HealthHandler(int Health) {
            if (hungerLevel >= 81) {
                playerHP = playerHP - 10;
                hpLabelNumber.setText("" + playerHP);
            }
            if (energyLevel <= 19) {
                playerHP = playerHP - 10;
                hpLabelNumber.setText("" + playerHP);
            }
            if (Health < 1) {
                death();
            }
        }

        public class TitleScreenHandler implements ActionListener {

            public void actionPerformed(ActionEvent event) {

                createGameScreen();
            }
        }

        public static String timeCheck(int time){
            //if(morning.contains()){}
            int Rtime = time;
            String timing = "empty";

            if (time == 1 || time == 4 || time == 7 || time == 10 || time == 13 || time == 16 || time == 19 ||
                    time == 22 || time == 25 || time == 28 || time ==31 || time == 34 || time == 37 ||
                    time == 40 || time == 43 || time == 46 || time == 49 || time == 52 || time == 55 ||
                    time == 58 || time == 61 || time == 64 || time == 67 || time == 70 || time == 73 ||
                    time == 76 || time == 79 || time == 82 || time == 85 || time == 88 || time == 91 || time == 94){
                return "Morning";
            }


            if (time == 2 || time == 5 || time == 8 || time == 11 || time == 14 || time == 17 || time == 20 ||
                    time == 23 || time == 26 || time == 29 || time ==32 || time == 35 || time == 38 ||
                    time == 41 || time == 44 || time == 47 || time == 50 || time == 53 || time == 56 ||
                    time == 59 || time == 62 || time == 65 || time == 68 || time == 71 || time == 74 ||
                    time == 77 || time == 80 || time == 83 || time == 86 || time == 89 || time == 92 ){
                return "Noon";
            }

            if (time == 3 || time == 6 || time == 9 || time == 12 || time == 15 || time == 18 || time == 21 ||
                    time == 24 || time == 27 || time == 30 || time ==33 || time == 36 || time == 38 ||
                    time == 42 || time == 45 || time == 48 || time == 51 || time == 54 || time == 57 ||
                    time == 60 || time == 63 || time == 66 || time == 69 || time == 72 || time == 75 ||
                    time == 78 || time == 81 || time == 84 || time == 87 || time == 90 || time == 93 ){

                return "Night";
            }
            return timing;
        }

        public static void gameDay(int time){


            if (time == 4 || time == 7 || time == 10 || time == 13 || time == 16 || time == 19 ||
                    time == 22 || time == 25 || time == 28 || time ==31 || time == 34 || time == 37 ||
                    time == 40 || time == 43 || time == 46 || time == 49 || time == 52 || time == 55 ||
                    time == 58 || time == 61 || time == 64 || time == 67 || time == 70 || time == 73 ||
                    time == 76 || time == 79 || time == 82 || time == 85 || time == 88 || time == 91 || time == 94){
                Gday = Gday+1;
            }
        }


        public static void timeList(){
            morning.add(1);
            noon.add(2);
            night.add(3);
            morning.add(4);
            noon.add(5);
            night.add(6);
            morning.add(7);
            noon.add(8);
            night.add(9);
            morning.add(10);
            noon.add(11);
            night.add(12);
            morning.add(13);
            noon.add(14);
            night.add(15);
            morning.add(16);
            noon.add(17);
            night.add(18);
            morning.add(19);
            noon.add(20);
            night.add(21);
            morning.add(22);
            noon.add(23);
            night.add(24);
            morning.add(25);
            noon.add(26);
            night.add(27);
            morning.add(28);
            noon.add(29);
            night.add(30);
            morning.add(31);
            noon.add(32);
            night.add(33);
            morning.add(34);
            noon.add(35);
            night.add(36);
            morning.add(37);
            noon.add(38);
            night.add(39);
            morning.add(40);
            noon.add(41);
            night.add(42);
            morning.add(43);
            noon.add(44);
            night.add(45);
            morning.add(46);
            noon.add(47);
            night.add(48);
            morning.add(49);
            noon.add(50);
            night.add(51);
            morning.add(52);
            noon.add(53);
            night.add(54);
            morning.add(55);
            noon.add(56);
            night.add(57);
            morning.add(58);
            noon.add(59);
            night.add(60);
            morning.add(61);
            noon.add(62);
            night.add(63);
            morning.add(64);
            noon.add(65);
            night.add(66);
            morning.add(67);
            noon.add(68);
            night.add(69);
            morning.add(70);
            noon.add(71);
            night.add(72);
            morning.add(73);
            noon.add(74);
            night.add(75);
            morning.add(76);
            noon.add(77);
            night.add(78);
            morning.add(79);
            noon.add(80);
            night.add(81);
            morning.add(82);
            noon.add(83);
            night.add(84);
            morning.add(85);
            noon.add(86);
            night.add(87);
            morning.add(89);
            noon.add(91);
            night.add(92);
            morning.add(93);

        }



        public class ChoiceHandler implements ActionListener {

            public void actionPerformed(ActionEvent event) {

                String yourChoice = event.getActionCommand();


                switch (position) {
                    case "prologue1":
                        switch (yourChoice) {
                            case "c1":
                                prologue2();
                                break;
                            /*case "c2":
                                ESCAPE();
                                break;
                            case "c4":
                                GameLoop();
                                break;*/
                        }
                        break;
                    case "prologue2":
                        switch (yourChoice) {
                            case "c1":
                                prologue3();
                                break;
                        }
                        break;
                    case "prologue3":
                        switch (yourChoice) {
                            case "c1":
                                prologue4();
                                break;
                        }
                        break;
                    case "prologue4":
                        if ("c1".equals(yourChoice)) {
                            prologue5();
                        }
                        break;
                    case "prologue5":
                        switch (yourChoice) {
                            case "c1":
                                prologue6();
                                break;
                        }
                        break;
                    case "prologue6":
                        switch (yourChoice) {
                            case "c1":
                                prologue7();
                                break;
                        }
                        break;
                    case "prologue7":
                        switch (yourChoice) {
                            case "c1":
                                prologue8();
                                break;
                        }
                        break;
                    case "prologue8":
                        switch (yourChoice) {
                            case "c1":
                                prologue9();
                                break;
                        }
                        break;
                    case "prologue9":
                        switch (yourChoice) {
                            case "c1":
                                prologue10();
                                break;
                        }
                        break;
                    case "prologue10":
                        switch (yourChoice) {
                            case "c1":
                                prologue11();
                                break;
                        }
                        break;
                    case "prologue11":
                        switch (yourChoice) {
                            case "c1":
                                prologue12();
                                break;
                        }
                        break;
                    case "prologue12":
                        switch (yourChoice) {
                            case "c1":
                                prologue13();
                                break;
                        }
                        break;
                    case "prologue13":
                        switch (yourChoice) {
                            case "c1":
                                prologue14();
                                break;
                        }
                        break;
                    case "prologue14":
                        switch (yourChoice) {
                            case "c1":
                                prologue15();
                                break;
                        }
                        break;
                    case "prologue15":
                        switch (yourChoice) {
                            case "c1":
                                prologue16();
                                break;
                        }
                        break;
                    case "prologue16":
                        switch (yourChoice) {
                            case "c1":
                                prologue17();
                                break;
                        }
                        break;
                    case "prologue17":
                        switch (yourChoice) {
                            case "c1":
                                prologue18();
                                break;
                        }
                        break;
                    case "prologue18":
                    case "couldNotHunt":
                    case "couldNotEscape":
                    case "cannotPrepEscape":
                    case "escapeProgress1":
                    case "escapeProgress2":
                    case "escapeProgress3":
                    case "escapeProgress4":
                    case "escapeProgress5":
                    case "escapeProgress6":
                    case "escapeProgress7":
                    case "couldNotEscapeT":
                    case "hunting1":
                    case "hunting2":
                    case "hunting3":
                    case "hunting4":
                    case "hunting5":
                    case "forage1":
                    case "forage2":
                    case "forage3":
                    case "couldNotRest":
                        switch (yourChoice) {
                            case "c1":
                                GameLoop();
                                break;
                        }
                        break;
                    case "GameLoop":
                        switch (yourChoice) {
                            case "c1":
                                if (escape == 1){
                                    if(hungerLevel <= 90 && energyLevel >= 60){
                                        if (time == 4 || time == 7 || time == 10 || time == 13 || time == 16 || time == 19 ||
                                                time == 22 || time == 25 || time == 28 || time ==31 || time == 34 || time == 37 ||
                                                time == 40 || time == 43 || time == 46 || time == 49 || time == 52 || time == 55 ||
                                                time == 58 || time == 61 || time == 64 || time == 67 || time == 70 || time == 73 ||
                                                time == 76 || time == 79 || time == 82 || time == 85 || time == 88 || time == 91 || time == 94){
                                        ending1();break;
                                        } else {
                                            couldNotEscapeT();break;
                                        }
                                    }
                                    else
                                    {couldNotEscape();break;}}

                                if (hungerLevel <= 80 && energyLevel >= 30) {
                                    if (escapeProgress == 0) {
                                        escapeProgress1(); break;
                                    }
                                    else if (escapeProgress == 1) {
                                        escapeProgress2();break;
                                    }
                                    else if (escapeProgress == 2) {
                                        escapeProgress3();break;
                                    }
                                    else if (escapeProgress == 3) {
                                        escapeProgress4();break;
                                    }
                                    else if (escapeProgress == 4) {
                                        escapeProgress5();break;
                                    }
                                    else if (escapeProgress == 5) {
                                        escapeProgress6();break;
                                    }
                                    else if (escapeProgress == 6) {
                                        escapeProgress7();break;
                                    }
                                        }
                                     else {
                                        cannotPrepEscape();break;
                                    }

                                    break;
                            case("c2"):
                                if (energyLevel >= 20 && playerHP >= 20) {
                                    randomHunt();
                                    if (huntingRandom <=4){hunting1();break;}
                                    if (huntingRandom >4 && huntingRandom <=7){hunting2();break;}
                                    if (huntingRandom >7 && huntingRandom <=10){hunting2();break;}
                                    if (huntingRandom >10 && huntingRandom <=14){hunting2();break;}
                                    if (huntingRandom >14 && huntingRandom <=15){hunting2();break;}
                                } else {couldNotHunt();}
                                break;

                            case("c3"):
                                if (energyLevel >= 15) {
                                    randomforage();
                                    if (huntingRandom <=4){forage1();break;}
                                    if (huntingRandom >4 && huntingRandom <=8){forage2();break;}
                                    if (huntingRandom >8 && huntingRandom <=10){forage3();break;}
                                } else {couldNotForge();}
                                break;

                            case("c4"):
                                if (hungerLevel <= 90) {
                                rest();break;
                                } else {couldNotRest();}
                                break;
                                }
                                break;
                    case "ending1":
                        switch (yourChoice) {
                            case "c1":
                                ending2();
                                break;
                        }
                        break;
                    case "ending2":
                        switch (yourChoice) {
                            case "c1":
                                ending3();
                                break;
                        }
                        break;
                    case "ending3":
                        switch (yourChoice) {
                            case "c1":
                                ending4();
                                break;
                        }
                        break;
                    case "ending4":
                        if ("c1".equals(yourChoice)) {
                            ending5();
                        }
                        break;
                    case "ending5":
                        switch (yourChoice) {
                            case "c1":
                                ending6();
                                break;
                        }
                        break;
                    case "ending6":
                        switch (yourChoice) {
                            case "c1":
                                ending7();
                                break;
                        }
                        break;
                    case "ending7":
                        switch (yourChoice) {
                            case "c1":
                                ending8();
                                break;
                        }
                        break;
                    case "ending8":
                        switch (yourChoice) {
                            case "c1":
                                ending9();
                                break;
                        }
                        break;
                    case "ending9":
                        switch (yourChoice) {
                            case "c1":
                                ending10();
                                break;
                        }
                        break;
                    case "ending10":
                        switch (yourChoice) {
                            case "c1":
                                ending11();
                                break;
                        }
                        break;
                    case "ending11":
                        switch (yourChoice) {
                            case "c1":
                                ending12();
                                break;
                        }
                        break;
                    case "ending12":
                        switch (yourChoice) {
                            case "c1":
                                ending13();
                                break;
                        }
                        break;
                    case "ending13":
                        switch (yourChoice) {
                            case "c1":
                                ending14();
                                break;
                        }
                        break;
                    case "ending14":
                        switch (yourChoice) {
                            case "c1":
                                ending15();
                                break;
                        }
                        break;
                    case "ending15":
                        switch (yourChoice) {
                            case "c1":
                                ending16();
                                break;
                        }
                        break;
                    case "ending16":
                        switch (yourChoice) {
                            case "c1":
                                ending17();
                                break;
                        }
                        break;
                    case "ending17":
                        switch (yourChoice) {
                            case "c1":
                                ending18();
                                break;
                        }
                        break;
                    case "ending18":
                        switch (yourChoice) {
                            case "c1":
                                ending19();
                                break;
                        }
                        break;
                    case "ending19":
                        switch (yourChoice) {
                            case "c1":
                                ending20();
                                break;
                        }
                        break;
                    case "ending20":
                        switch (yourChoice) {
                            case "c1":
                                ESCAPE();
                                break;
                        }
                }

            }
        }


    }}






/*public void surviveProgress1() {
            position = "surviveProgress1";
            mainTextArea.setText("You choose to forage, finding ample fruit and water. \n" +
                    "+20 health, -15 hunger, -30 energy.\n");
            surviveProgress = 1;
            hungerLevel = hungerLevel -15;
            energyLevel = energyLevel - 30;
            playerHP = playerHP + 20;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }

        public void surviveProgress2() {
            position = "surviveProgress2";
            mainTextArea.setText("You choose to hunt. Through a difficult scuffle, you slay a boar.\n" +
                    "+30 health, -25 hunger, -40 energy.");
            surviveProgress = 2;
            hungerLevel = hungerLevel -25;
            energyLevel = energyLevel - 40;
            playerHP = playerHP + 30;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void surviveProgress3() {
            position = "surviveProgress3";
            mainTextArea.setText("You choose to hunt. You make a misstep and are slashed by a boar’s tusks.\n" +
                    "-20 health, -25 energy.");
            surviveProgress = 3;
            hungerLevel = hungerLevel ;
            energyLevel = energyLevel - 25;
            playerHP = playerHP - 20;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void surviveProgress4() {
            position = "surviveProgress4";
            mainTextArea.setText("You build your defenses, making it so you can survive attacks better.\n" +
                    "-20 energy, +15 hunger.\n");
            surviveProgress = 4;
            hungerLevel = hungerLevel + 15;
            energyLevel = energyLevel - 20;
            playerHP = playerHP ;
            limiter();
            time = time + 1;
            hpLabelNumber.setText("" + playerHP);
            hungerLableNumber.setText("" + hungerLevel);
            energyLableNumber.setText("" + energyLevel);
            HealthHandler(playerHP);
            choice1.setText("Look around to see what to do");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }*/





        /*public void talkGuard(){
            position = "talkGuard";
            mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void attackGuard(){
            position = "attackGuard";
            mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
            //playerHP = playerHP -3;
            playerHP -=3;
            hpLabelNumber.setText(""+playerHP);
            HealthHandler(playerHP);
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void crossRoad(){
            position = "crossRoad";
            mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
            choice1.setText("Go north");
            choice2.setText("Go east");
            choice3.setText("Go south");
            choice4.setText("Go west");
        }
        public void north(){
            position = "north";
            mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 2)");
            playerHP = playerHP + 2;
            hpLabelNumber.setText(""+playerHP);
            choice1.setText("Go south");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void east(){
            position = "east";
            mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
            weapon = "Long Sword";
            hungerLableNumber.setText(weapon);
            choice1.setText("Go west");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");

        }
        public void west(){
            position = "west";
            mainTextArea.setText("You encounter a goblin!");
            choice1.setText("Fight");
            choice2.setText("Run");
            choice3.setText("");
            choice4.setText("");
        }
        public void fight(){
            position = "fight";
            mainTextArea.setText("Monter HP: " + monsterHP + "\n\nWhat do you do?");
            choice1.setText("Attack");
            choice2.setText("Run");
            choice3.setText("");
            choice4.setText("");
        }
        public void playerAttack(){
            position = "playerAttack";

            int playerDamage = 0;

            if(weapon.equals("Knife")){
                playerDamage = new java.util.Random().nextInt(3);
            }
            else if(weapon.equals("Long Sword")){
                playerDamage = new java.util.Random().nextInt(12);
            }

            mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");

            monsterHP = monsterHP - playerDamage;

            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void monsterAttack(){
            position = "monsterAttack";

            int monsterDamage = 0;

            monsterDamage = new java.util.Random().nextInt(6);

            mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");

            playerHP = playerHP - monsterDamage;
            hpLabelNumber.setText(""+playerHP);

            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        public void win(){
            position = "win";

            mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");

            silverRing = 1;

            choice1.setText("Go east");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");

        }
        public void lose(){
            position = "lose";

            mainTextArea.setText("You are dead!\n\nGAME OVER");

            choice1.setText("");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            choice1.setVisible(false);
            choice2.setVisible(false);
            choice3.setVisible(false);
            choice4.setVisible(false);
        }
        public void ending(){
            position = "ending";

            mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\nTHE END");

            choice1.setText("");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            choice1.setVisible(false);
            choice2.setVisible(false);
            choice3.setVisible(false);
            choice4.setVisible(false);
        }*/



/*case "prologue3":
                        switch(yourChoice){
                            case "c1": prologue4();break;
                        }
                    case "prologue4":
                        switch(yourChoice){
                            case "c1": prologue5();break;
                        }
                    case "prologue5":
                        switch(yourChoice){
                            case "c1": prologue6();break;
                        }
                    case "prologue6":
                        switch(yourChoice){
                            case "c1": prologue7();break;
                        }
                        break;
                    case "prologue7":
                        switch(yourChoice){
                            case "c1": prologue8();break;
                        }
                    case "prologue8":
                        switch(yourChoice){
                            case "c1": prologue9();break;
                        }
                    case "prologue9":
                        switch(yourChoice){
                            case "c1": prologue10();break;
                        }
                    case "prologue10":
                        switch(yourChoice){
                            case "c1": prologue11();break;*/





                    /*case "talkGuard":
                        switch(yourChoice){
                            case "c1": prologe1(); break;
                        }
                        break;
                    case "attackGuard":
                        switch(yourChoice){
                            case "c1": prologe1(); break;
                        }
                        break;*/


                /*switch(position){
                    case "townGate":
                        switch(yourChoice){
                            case "c1":
                                if(silverRing==1){
                                    ending();
                                }
                                else{
                                    talkGuard();
                                }
                                break;
                            case "c2": attackGuard();break;
                            case "c3": crossRoad();break;
                        }
                        break;
                    case "talkGuard":
                        switch(yourChoice){
                            case "c1": townGate(); break;
                        }
                        break;
                    case "attackGuard":
                        switch(yourChoice){
                            case "c1": townGate(); break;
                        }
                        break;
                    case "crossRoad":
                        switch(yourChoice){
                            case "c1": north(); break;
                            case "c2": east();break;
                            case "c3": townGate(); break;
                            case "c4": west();break;
                        }
                        break;
                    case "north":
                        switch(yourChoice){
                            case "c1": crossRoad(); break;
                        }
                        break;
                    case "east":
                        switch(yourChoice){
                            case "c1": crossRoad(); break;
                        }
                        break;
                    case "west":
                        switch(yourChoice){
                            case "c1": fight(); break;
                            case "c2": crossRoad(); break;
                        }
                        break;
                    case "fight":
                        switch(yourChoice){
                            case "c1": playerAttack();break;
                            case "c2": crossRoad(); break;
                        }
                        break;
                    case "playerAttack":
                        switch(yourChoice){
                            case "c1":
                                if(monsterHP <1 ){
                                    win();
                                }
                                else{
                                    monsterAttack();
                                }
                                break;
                        }
                        break;
                    case "monsterAttack":
                        switch(yourChoice){
                            case "c1":
                                if(playerHP <1 ){
                                    lose();
                                }
                                else{
                                    fight();
                                }
                                break;
                        }
                        break;
                    case "win":
                        switch(yourChoice){
                            case "c1": crossRoad();
                        }
                        break;

                }*/


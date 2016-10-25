package com.alex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Angel on 10/25/2016.
 */
public class AgileWaterfallGUI extends JFrame {
    private JPanel rootPanel;
    private JCheckBox teamUnder40MembersCheckBox;
    private JCheckBox scheduleFixedCheckBox;
    private JCheckBox programmersHaveExperienceCheckBox;
    private JCheckBox qcStrictCheckBox;
    private JCheckBox earlyIntegrationCheckBox;
    private JCheckBox earlyModelCheckBox;
    private JButton suggestMethodButton;
    private JLabel suggestionLabel;
    private JTextField projectNameTextField;

    public AgileWaterfallGUI(){
        super("Agile or Waterfall");
        setContentPane(rootPanel);
        pack();
        setSize(new Dimension(500,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        suggestMethodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //determine whether or not Agile may work for the user using all the the answers input into the method
                boolean useAgile = agileOrWaterfall(teamUnder40MembersCheckBox.isSelected(), scheduleFixedCheckBox.isSelected()
                , programmersHaveExperienceCheckBox.isSelected(), qcStrictCheckBox.isSelected(), earlyIntegrationCheckBox.isSelected(),
                        earlyModelCheckBox.isSelected());
                //display whether or not Agile would work for the user.
                String projectName = projectNameTextField.getText();

                if (useAgile){
                    suggestionLabel.setText("You should use an Agile approach for your " + projectName + " project.");
                } else {
                    suggestionLabel.setText("You should use a Waterfall approach for your " + projectName + " project.");
                }
            }
        });
    }

    /*this method takes all of the data input from the user and returns a boolean suggesting they use agile or waterfall methodology.
   agile = true, waterfall = false
    */
    private static boolean agileOrWaterfall(boolean under40Members, boolean scheduleFixed, boolean programmersHaveExperience
    , boolean qcStrict, boolean earlyIntegration, boolean earlyModel) {
        //a counter to add up each answer provided that points to agile being useful
        int agilePoints = 0;
        //if there are less than 40 members, add a point for agile
        if (under40Members){
            agilePoints++;
        }
        //if the schedule doesn't need to be fixed, add a point for agile
        if (!scheduleFixed){
            agilePoints++;
        }
        //if the programmers have the other non-coding experience, add a point to agile
        if (programmersHaveExperience){
            agilePoints++;
        }
        //if qc isn't strictly defined, add a point to agile
        if (!qcStrict){
            agilePoints++;
        }
        //if early integration is wanted, add a point to agile
        if (earlyIntegration){
            agilePoints++;
        }
        //if the customers demand an early model, add a point to agile
        if (earlyModel){
            agilePoints++;
        }

        /*if less than 3 out of the 6 points were given, waterfall may be best (false).
        otherwise, agile may work (true). I gave the tie to agile.
         */

        if (agilePoints < 3){
            return false;
        } else {
            return true;
        }

    }
}

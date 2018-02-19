import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.components.JBList;
import com.intellij.ui.components.JBRadioButton;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneratorDialog extends DialogWrapper {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel mainPanel;

    private JBList<JRadioButton> radioButtons;


    protected GeneratorDialog(Project project) {
        super(project);
        init();

        setTitle("Choose comment");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        contentPane = new JPanel();

        List<String> sections = getSections();

        radioButtons = new JBList<>();

        sections.forEach(section -> {
            JBRadioButton jRadioButton = new JBRadioButton(section);
            contentPane.add(jRadioButton);
        });

        contentPane.add(radioButtons);

        return contentPane;
    }

    private JBRadioButton getSelectedRadioButton(){
        /*for(JBRadioButton rb : ) {
            if (rb.isSelected()) {
                return rb;
            }
        }*/

        return null;
    }

    @Override
    protected void doOKAction() {
        JRadioButton radioButton = getSelectedRadioButton();

        System.out.println(radioButton != null ? radioButton.getText() : "No selected button");

        super.doOKAction();
    }

    public List<String> getSections(){
        return List.of("Constructors", "Getters", "Setters");
    }

    /*public GeneratorDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }*/

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}

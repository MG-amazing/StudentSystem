package one.component;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class ManageComponent extends Box {
    final int WIDTH = 850;
    final int HEIGHT = 600;

    JFrame jf = null;
    private DefaultTableModel tableModel;
    public ManageComponent(JFrame jf) {
        //垂直布局
        super(BoxLayout.Y_AXIS);
        //组装视图
        this.jf = jf;
        JPanel btnPanel = new JPanel();
        Color color = new Color(203, 220, 217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH, 80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.setPreferredSize(new Dimension(HEIGHT,85));

        JButton addBtn = new JButton("添加");
        JButton updateBtn = new JButton("修改");
        JButton deleteBtn = new JButton("删除");
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        jf.add(btnPanel);
        this.setVisible(true);

    }
}

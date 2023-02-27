import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GUI
{
    public JFrame window;
    public JTable table;
    int[] nums_ = new int[0];
    public GUI(int x, int y, int width, int height, String title)
    {
        window = CreateUI(x,y,width,height,title);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        //DrawTable(10,10,480,100,1,10);
    }
    public static JFrame CreateUI(int x, int y, int width, int height, String title)
    {
        JFrame window = new JFrame(title);
        window.setBounds(x,y,width,height);
        window.setMinimumSize(new Dimension(width,height));
        window.setLayout(null);
        window.setVisible(true);

        return window;
    }
    public void DrawTable(int x, int y, int width,int height, int rows, int columns)
    {
        table = new JTable(rows,columns);
        table.setBounds(x,y,width,height);

        window.add(table);
    }
    public void InputIntArrayWindow()
    {
        //Таблица
        table = new JTable(8,15);
        table.setBounds(10,10,window.getWidth()-window.getX()*3-20,window.getHeight() - 100);

        //Кнопка задания в10
        JButton var10 = new JButton("Вариант 10");
        var10.setBounds(10,table.getHeight()+table.getX() + 10,180,30);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadNumsFromTable();
                JOptionPane.showMessageDialog(null,Main.Solution10(nums_));
            }
        };
        var10.addActionListener(actionListener);

        //Вариант 24
        JButton var24_1 = new JButton("Вариант 24 (ВВОД)");
        var24_1.setBounds(var10.getX() + var10.getWidth() + 10,table.getHeight()+table.getX() + 10,180,30);
        ActionListener actionListener24 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadNumsFromTable();
                CountIdPair a = Main.Solution24(nums_);

                String mess24 = ("Самая длинная последовательность, размером " + a.array.length + ": ");
                for (int j = 0; j < a.array.length; j++) {
                    mess24+=(a.array[j] + "  ");
                }
                mess24+=('\n');
                JOptionPane.showMessageDialog(null,mess24);
            }
        };
        var24_1.addActionListener(actionListener24);

        //Вариант 24 шаблоны
        JButton var24_2 = new JButton("Вариант 24 (ШАБЛОНЫ)");
        var24_2.setBounds(var24_1.getX() + var24_1.getWidth() + 10,table.getHeight()+table.getX() + 10,185,30);
        ActionListener actionListener24_2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] arrays = new int[][]
                        {
                                {1, 2, -2, 1, 10, 3, 105, 4, -5, 4, 10, 1, 1, 3, 4, 7, 12, 10},
                                {23, 71, 90, 42, 80, 24, 80, 55, 95, 28, 5, 14, 65, 98, 86, 72, 44, 16},
                                {75, 94, 81, 78, 41, 10, 41, 1, 16, 99, 21, 69, 76, 37, 58, 77, 70, 27},
                                {96, 63, 77, 84, 78, 89, 22, 23, 39, 77, 50, 10, 12, 29, 77, 27, 15, 72},
                                {47, 63, 84, 23, 9, 77, 23, 78, 95, 22, 44, 83, 99, 90, 58, 64, 3, 36},
                                {56, 90, 17, 14, 77, 98, 20, 10, 3, 89, 39, 5, 28, 70, 66, 10, 14, 11},
                                {32, 61, 64, 30, 77, 81, 33, 34, 10, 69, 71, 66, 91, 40, 31, 55, 37, 81},
                                {20, 83, 90, 9, 84, 33, 99, 76, 34, 42, 57, 37, 49, 19, 15, 46, 99, 57},
                                {51, 16, 36, 45, 6, 16, 47, 23, 98, 42, 77, 77, 64, 7, 73, 60, 86, 77},
                                {68, 60, 52, 47, 10, 4, 51, 53, 45, 35, 94, 15, 78, 45, 69, 96, 78, 59}
                        };
                String mes24_2 = "";
                for (int i = 0; i < arrays.length; i++) {
                    CountIdPair a1 = Main.Solution24(arrays[i]);
                    mes24_2 += ("Самая длинная последовательность, размером " + a1.array.length + ": ");

                    for (int j = 0; j < a1.array.length; j++) {
                        mes24_2+=(a1.array[j] + "  ");
                    }
                    mes24_2+=('\n');
                }
                JOptionPane.showMessageDialog(null,mes24_2);
            }
        };
        var24_2.addActionListener(actionListener24_2);

        window.add(table);
        window.add(var10);
        window.add(var24_1);
        window.add(var24_2);

        window.hide();
        window.show();
    }
    public void ReadNumsFromTable()
    {
        nums_ = new int[0];
        for (int i = 0; i < table.getRowCount(); i++)
        {
            for (int j = 0; j < table.getColumnCount(); j++) {
                int tmp = -18203;
                if (table.getValueAt(i, j) != null) {
                    try {
                        tmp = (int)Integer.parseInt(table.getValueAt(i, j).toString());
                    } catch (Exception ex) {
                    }
                    if (tmp != -18203) {
                        nums_ = Main.Add(nums_, tmp);
                    }
                }
            }
        }
    }

}

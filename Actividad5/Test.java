import javax.swing.*;

public class Test {
    public static void main (String args[]) {
        PersonRecord personRecord = new PersonRecord();

        while (true) {
            try {
                int choice = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 To Add Record  \n " +
                        "Enter 2 To Search Record \n " + "Enter 3 To Delete Record \n Enter 4 To Modify Record " +
                        "\n Enter 5 To Display All Records \n " + "Enter 6 to Exit"));
                switch (choice) {
                    case 1:
                        personRecord.add();
                        break;
                    case 2:
                        personRecord.search();
                        break;
                    case 3:
                        personRecord.delete();
                        break;
                    case 4:
                        personRecord.modify();
                        break;
                    case 5:
                        personRecord.displayAll();
                        break;
                    case 6:
                        System.exit(0);
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            }
        }
    }
}
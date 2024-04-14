import javax.swing.*;
import java.util.*;

public class PersonRecord {
    private ArrayList<PersonData> personRecords;


    public PersonRecord() {
        personRecords = new ArrayList<>();
    }


    public void add() {
        String name = JOptionPane.showInputDialog("Enter name");
        String address = JOptionPane.showInputDialog("Enter address");
        String phoneNumber = JOptionPane.showInputDialog("Enter phone number");

        PersonData data = new PersonData(name, address, phoneNumber);

        personRecords.add(data);
    }

    // RecordNotFound is negative because it's the only output it displays.
    public void printRecordNotFound(boolean isFound) {
        if (!isFound)
            JOptionPane.showMessageDialog(null, "Record Not found");
    }

    public void printEmptyRecord() {
        JOptionPane.showMessageDialog(null, "....Sorry there is no any record ....");
    }


    public void search() {
        boolean isFound = false;

        if ( !personRecords.isEmpty() ) {
            String searchName = JOptionPane.showInputDialog("Enter Name To Search ");

            for (PersonData data : personRecords) {
                if ( searchName.equals(data.getName()) ) {
                    data.print();
                    isFound = true;
                }
            }

            printRecordNotFound(isFound);

        } else {
            printEmptyRecord();
        }
    }


    public void delete() {
        boolean isFound = false;

        if(!personRecords.isEmpty()) {
            String deleteName = JOptionPane.showInputDialog("Enter Name To Delete ");

            for (PersonData data : personRecords) {
                if ( deleteName.equals(data.getName() ) ) {
                    personRecords.remove(data);
                    JOptionPane.showInputDialog("Record is Deleted ");
                    isFound = true;
                }
            }

            printRecordNotFound(isFound);
        }
        else {
            printEmptyRecord();
        }
    }


    public void modify() {
        boolean isFound = false;

        if ( !personRecords.isEmpty() ) {
            String modifyName = JOptionPane.showInputDialog("Enter Name To Modify ");

            for (int i = 0; i < personRecords.size(); i++) {
                PersonData data = personRecords.get(i);

                if ( modifyName.equals(data.getName()) ) {
                    isFound = true;
                    data.print();

                    String newName = JOptionPane.showInputDialog("Enter new name Last one is : " + data.getName());
                    String newAddress = JOptionPane.showInputDialog("Enter new address Last one is : "+ data.getAddress());
                    String newPhoneNumber = JOptionPane.showInputDialog("Enter new phone number Last one is : "+ data.getPhoneNumber());

                    data.setName(newName);
                    data.setAddress(newAddress);
                    data.setPhoneNumber(newPhoneNumber);
                    data.print();
                }
            }

            printRecordNotFound(isFound);
        }
        else {
            printEmptyRecord();
        }
    }


    public void displayAll(){
        if ( !personRecords.isEmpty() ) {
            for (int counter = 0; counter < personRecords.size(); counter++) {
                PersonData data = personRecords.get(counter);
                JOptionPane.showMessageDialog(null, " Record No:" + (counter + 1) +
                        "\n\nName: " + data.getName() + "\n Address: " + data.getAddress() +
                        "\n phone no: " + data.getPhoneNumber());
            }
        } else {
            printEmptyRecord();
        }
    }

}
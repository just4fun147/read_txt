import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        sortStream();
        Integer currentBalance = 2000;
        try{
            System.out.println("initial balance : "+ currentBalance);
            System.out.println("add 1000 to balance");
            currentBalance = deposit(1000, currentBalance);

            checkBalance(currentBalance);
            System.out.println("your balance: "+ checkBalance(currentBalance));

            System.out.println("withdraw 1000 to balance");
            currentBalance = withDraw(1000,currentBalance);
            System.out.println("your balance: "+ checkBalance(currentBalance));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static void sortStream(){
        try(InputStream inputStream = new FileInputStream("./src/input/students.txt")) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);

            String input = new String(bytes);
            String[] arrayList = input.split("\n");

            List<String> data = new ArrayList<>(Arrays.asList(arrayList));
            Collections.sort(data);

            System.out.println("RESULT : \n" +data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static Integer deposit(Integer add, Integer balance) throws ArithmeticException{
        if(add <= 0 || add > 50000000){
            throw new ArithmeticException("Penambahan Saldo Invalid");
        }
        return add + balance;
    }

    static Integer checkBalance(Integer balance){
        return balance;
    }

    static Integer withDraw(int amountWithdraw, int balance) throws ArithmeticException{
        if(amountWithdraw <= 0 || amountWithdraw > 50000000){
            throw new ArithmeticException("Jumlah Penarikan Invalid");
        }else if(amountWithdraw >= balance){
            throw new ArithmeticException("Jumlah Penarikan Melebihi Saldo");
        }
        return balance - amountWithdraw;
    }
}
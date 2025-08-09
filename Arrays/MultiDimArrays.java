package DSA.Arrays;

public class MultiDimArrays {
//    String name;
//    int empID;
    static void display(String name, int empID){
        System.out.println("Name of the emp: "+name+"\nEmpID is: "+empID);
    }

    public static void main(String[] args) {
        MultiDimArrays[][] mda= new MultiDimArrays[2][];
        mda[0] = new MultiDimArrays[3]; //1st row has 3 col values

        mda[0][0] = new MultiDimArrays();
//        mda[0][0].name = "Yuvi";
//        mda[0][0].empID = 6697;

        display("Yuvi",6697);

    }
}

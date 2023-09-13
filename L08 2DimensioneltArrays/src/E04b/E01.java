package E04b;

public class E01 {
    static int[][] ticket = {
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
            {20, 20, 30, 40, 50, 50, 40, 30, 20, 20},
            {30, 40, 50, 50, 50, 50, 50, 50, 40, 30},
    };
    public static void main(String[] args){
        int cheapskate = 10;
        int row = 5;
        int seat = 5;
        buyTicket(cheapskate);
        System.out.println("Sale complete is " + buyTicket(row-1,seat-1));
        printTheaterFloor();

    }
    public static void buyTicket(int price) {
        for (int row = 0; row < ticket.length; row++) {
            for (int col = 0; col < ticket[row].length; col++) {
                if (ticket[row][col] == price) {
                    ticket[row][col] = 0;
                    return;
                }
            }
        }
    }
    public static boolean buyTicket(int rowNo, int seatNo){
            boolean saleComplete = false;
            for (int row = 0; row < ticket.length; row++) {
                for (int col = 0; col < ticket[row].length; col++) {
                    if ( row == rowNo && col == seatNo && ticket[row][col]!= 0){
                        ticket[row][col] = 0;
                        saleComplete = true;
                        return saleComplete;
                    }
                }
            }
        return saleComplete;
    }
    public static void printTheaterFloor(){
        System.out.println("Ledige pladse er angivet med deres pris");
        System.out.println("Sæde:        1    2    3    4    5    6    7    8    9   10");

        for (int row = 0; row < ticket.length; row++) {
            System.out.printf("Række "+(row+1)+" :");
            for (int col = 0; col < ticket[row].length; col++) {
                if (ticket[row][col] == 0){
                    System.out.printf("   --");
                }
                else System.out.printf("%5d", ticket[row][col]);
            }
            System.out.println();
            }
    }
}

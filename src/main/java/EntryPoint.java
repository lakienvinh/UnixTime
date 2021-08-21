public class EntryPoint {
    public static void main(String[] args) {
        // TEST

        long timestamp = Date.getUnixTimeFromDate(21, 8, 2021);
        System.out.println(timestamp);
        int[] date = Date.getDateFromUnixTime(timestamp);
        System.out.format("%d/%d/%d", date[0], date[1], date[2]);

        System.out.println("\n===================\n");


        timestamp = Date.getUnixTimeFromDate(21, 8, 2021);
        System.out.println(timestamp);
        date = Date.getDateFromUnixTime(timestamp);
        System.out.format("%d/%d/%d", date[0], date[1], date[2]);


        System.out.println("\n===================\n");

        timestamp = Date.getUnixTimeFromDate(15, 1, 1999);
        System.out.println(timestamp);
        date = Date.getDateFromUnixTime(timestamp);
        System.out.format("%d/%d/%d", date[0], date[1], date[2]);

        System.out.println("\n===================\n");

        timestamp = Date.getUnixTimeFromDate(30, 12, 2001);
        System.out.println(timestamp);
        date = Date.getDateFromUnixTime(timestamp);
        System.out.format("%d/%d/%d", date[0], date[1], date[2]);

        System.out.println("\n===================\n");
    }
}

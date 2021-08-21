public class Date {

    final public static long DAY_IN_SECOND = 24 * 3600;

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static long getNumberOfDayFromMonthYear(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }

    public static long getNumberOfSecondFromMonthYear(int month, int year) {
        return getNumberOfDayFromMonthYear(month, year) * DAY_IN_SECOND;
    }

    public static long getNumberOfSecondFromYear(int year) {
        return (isLeapYear(year) ? 366 : 365) * DAY_IN_SECOND;
    }

    public static long getUnixTimeFromYear(int year) {
        long seconds = 0;

        for (int y = 1970; y <= year; y++)
            seconds += getNumberOfSecondFromYear(y);

        long timestamp = seconds - 1;
        return timestamp;
    }

    public static long getUnixTimeFromMonthYear(int month, int year) {
        long seconds = 0;

        for (int y = 1970; y <= year - 1; y++)
            seconds += getNumberOfSecondFromYear(y);

        for (int m = 1; m <= month; m++)
            seconds += getNumberOfSecondFromMonthYear(m, year);

        long timestamp = seconds - 1;
        return timestamp;
    }

    // DATE TO TIMESTAMP
    public static long getUnixTimeFromDate(int day, int month, int year) {
        long seconds = 0;

        for (int y = 1970; y <= year - 1; y++)
            seconds += getNumberOfSecondFromYear(y);

        for (int m = 1; m <= month - 1; m++)
            seconds += getNumberOfSecondFromMonthYear(m, year);

        seconds += day * DAY_IN_SECOND;

        long timestamp = seconds - 1;
        return timestamp;
    }

    // TIMESTAMP TO DATE
    public static int[] getDateFromUnixTime(long timestamp) {
        int day = 1;
        int month = 1;
        int year = 1970;

        long seconds = timestamp + 1;

        while (seconds >= getNumberOfSecondFromYear(year)) {
            seconds -= getNumberOfSecondFromYear(year);
            year++;
        }

        while (seconds >= getNumberOfSecondFromMonthYear(month, year)) {
            seconds -= getNumberOfSecondFromMonthYear(month, year);
            month++;
        }

        day = (int) (seconds / DAY_IN_SECOND);
        return new int[]{day, month, year};
    }
}

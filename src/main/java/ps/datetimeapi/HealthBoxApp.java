package ps.datetimeapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HealthBoxApp {

    private static String appointmentDetails = "";
    private static final long ONE_DAY_IN_MILLIS = 24 * 60 * 60 * 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Schedule an Appointment.");
            System.out.println("2. Print Appointment Details.");
            System.out.println("3. Reschedule an Appointment.");
            System.out.println("4. Get Reminder.");
            System.out.println("5. Cancel the Appointments.");
            System.out.println("6. Exit.");
            System.out.println("----------------------------------------");
            System.out.println("Enter an Option: ");
            System.out.println("----------------------------------------");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scheduleAppointment(scanner);
                    break;
                case 2:
                    printAppointmentDetails();
                    break;
                case 3:
                    rescheduleAppointment(scanner);
                    break;
                case 4:
                    getReminder();
                    break;
                case 5:
                    cancelAppointment();
                    break;
                case 6:
                    System.out.println("Exiting Health Box. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter Date (dd/mm/yyyy): ");
        String dateStr = scanner.next();
        System.out.print("Enter Time (hh:mm): ");
        String timeStr = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date;
        try {
            date = dateFormat.parse(dateStr + " " + timeStr);
        } catch (ParseException e) {
            System.out.println("Invalid date or time format. Please try again.");
            return;
        }

        System.out.println("Available Zones are");
        System.out.println("A: America/Anchorage");
        System.out.println("B: Europe/Paris");
        System.out.println("C: Asia/Tokyo");
        System.out.println("D: America/Phoenix");
        System.out.println("----------------------------------------");
        System.out.println(" Select the Zone: ");
        String zone = getSelectedZone(scanner);
       
        long timeDiff = date.getTime() - System.currentTimeMillis();
        appointmentDetails = "Appointment scheduled for Date: " + dateStr + ", Time: " + timeStr + ", Zone: " + zone;
        System.out.println("Successfully Booked");
        System.out.println(timeDiff / (60 * 1000) + " min");
    }

    private static String getSelectedZone(Scanner scanner) {
        String selectedZone;
        while (true) {
            String choice = scanner.next().toUpperCase();
            switch (choice) {
                case "A":
                    selectedZone = "America/Anchorage";
                    break;
                case "B":
                    selectedZone = "Europe/Paris";
                    break;
                case "C":
                    selectedZone = "Asia/Tokyo";
                    break;
                case "D":
                    selectedZone = "America/Phoenix";
                    break;
                default:
                    System.out.println("Invalid zone. Please choose a valid option.");
                    continue;
            }
            break;
        }
        return selectedZone;
    }

    private static void printAppointmentDetails() {
        if (appointmentDetails.isEmpty()) {
            System.out.println("No appointment details available. Please schedule an appointment.");
        } else {
            System.out.println(appointmentDetails);
        }
    }

    private static void rescheduleAppointment(Scanner scanner) {
        if (appointmentDetails.isEmpty()) {
            System.out.println("No appointment to reschedule. Please schedule an appointment first.");
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d yyyy HH:mm a");
            try {
                Date currentDate = dateFormat.parse(appointmentDetails);
                System.out.println("Current Appointment Date is: " + dateFormat.format(currentDate));

                System.out.print("Kindly Enter Number of Days to be postponed: ");
                int daysToPostpone = scanner.nextInt();
                System.out.print("Enter the new time in HH:mm: ");
                String newTimeStr = scanner.next();

                long newTimeMillis = currentDate.getTime() + daysToPostpone * 24 * 60 * 60 * 1000;
                Date newDate = new Date(newTimeMillis);
                SimpleDateFormat newDateFormat = new SimpleDateFormat("EEE, MMM d yyyy HH:mm a");
                String rescheduledDateStr = newDateFormat.format(newDate);

                appointmentDetails = "Your Appointment has been rescheduled to: " + rescheduledDateStr;
                System.out.println(appointmentDetails);

            } catch (ParseException e) {
                System.out.println("Error parsing the date. Please try again.");
            }
        }
    }

    private static void getReminder() {
        if (!appointmentDetails.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d yyyy HH:mm a");
            try {
                Date appointmentDate = dateFormat.parse(appointmentDetails);
                System.out.println("One day prior reminder: " + new Date(appointmentDate.getTime() - 24 * 60 * 60 * 1000));
            } catch (ParseException e) {
                System.out.println("Error parsing the date. Please try again.");
            }
        } else {
            System.out.println("No appointment is booked.");
        }
    }


    private static void cancelAppointment() {
        if (!appointmentDetails.isEmpty()) {
            appointmentDetails = "";
            System.out.println("Appointment has been cancelled!");
        } else {
            System.out.println("No appointment is booked for cancellation.");
        }
    }
}

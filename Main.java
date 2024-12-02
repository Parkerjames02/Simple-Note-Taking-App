// ***************
// Parker Haynie
// Assignment 5.3: Final Project
// ***************
// This is my application that I created for my Java II course final project.
// This application is a simple note-taking application that allows the user
// to read, write, and append notes to a file. This application also has a
// login system, allowing the user to login as a specified user or as a
// guest. Logging in as a user or guest does not change the user experience.
// ***************
//    ----> This assignment fulfills all final project requirements <----
// ----> except for Multithreading, Iterators, and Generic Programming <----
// ***************

// This imports the library for standard Java Input/Output.
import java.io.*;
// This imports the library for collection framework and collection classes.
import java.util.*;

// This is the App class. This is used to start the application.
class App {
    // This startApp method is what I use to start the application.
    public void startApp() {
        // Creates an intro object from the Intro class.
        Intro intro = new Intro();
        // Uses the intro object to start the intro of the application.
        intro.startIntro();
    }
}

// This is the Intro class. This is where the logic for printing the application description and instructions takes place.
class Intro {
    // This method is used to print the application description and instructions.
    public void startIntro() {
        // This line prints the title of the application.
        System.out.println("\n\t\t\t\t *** Simple Note Taking ***");
        // Lines 38-42 are print statements used to print out the description of the application.
        System.out.println("\nHello, and welcome to my Simple Note Taking Application. With");
        System.out.println("this application you will be able to view, create, and add onto");
        System.out.println("a list of notes. The text contained within the notes will be");
        System.out.println("automatically saved so you don't have to worry about losing any");
        System.out.println("of your notes.");
        // Lines 44-47 print instructions on how to log into the application.
        System.out.println("\nBefore you have access to viewing, creating, and editing your");
        System.out.println("notes you need to login first. If you already have an account");
        System.out.println("set up then please use the 'User Login' option. If you don't");
        System.out.println("already have an account then please use the 'Guest Login' option.");
        // This line prints a buffer.
        System.out.println("\n-----------------------------------------------------------------");
        // Creates a loginLogic object from the LoginLogic class.
        LoginLogic loginLogic = new LoginLogic();
        // Uses the loginLogic object to run the startLogin method that starts the login process.
        loginLogic.startLogin();
    }
}

// This is the Login abstract class. UserLogin and GuestLogin are both derived from this abstract class.
abstract class Login {
    // This initializes the private string variable loginType.
    private String loginType;
    // This initializes the private string variable name.
    private String name;
    // This initializes the private string variable username.
    private String username;
    // This initializes the private string variable password.
    private String password;

    // This is a basic constructor for the Login class.
    public Login() {
    }

    // This is the complex constructor for the Login class. It uses the loginType String variable.
    public Login(String loginType) {
        this.loginType = loginType;
    }

    // This is a method for returning the Private String variable loginType.
    public String getLoginType() {
        return loginType;
    }

    // This is a method for setting the Private String variable loginType to a specified String.
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    // This is a method for returning the Private String variable name.
    public String getName() {
        return name;
    }

    // This is a method for setting the Private String variable name to a specified String.
    public void setName(String name) {
        this.name = name;
    }

    // This is a method for returning the Private String variable username.
    public String getUsername() {
        return username;
    }

    // This is a method for setting the Private String variable username to a specified String.
    public void setUsername(String username) {
        this.username = username;
    }

    // This is a method for returning the Private String variable password.
    public String getPassword() {
        return password;
    }

    // This is a method for setting the Private String variable password to a specified String.
    public void setPassword(String password) {
        this.password = password;
    }

    // This is a method used to ask for the user's name.
    public void askForName() {
        System.out.println("Please enter your name below");
    }

    // This is a method used to ask for the user's username. It then returns the username.
    public String askForUsername() {
        System.out.println("Please enter your username below");
        return username;
    }

    // This is a method used to ask for the user's password. It then returns the password.
    public String askForPassword() {
        System.out.println("Please enter your password below");
        return password;
    }
}

// This is the UserLogin class. It is derived from the Login class.
class UserLogin extends Login {
    // This creates a scanner object for the UserLogin class.
    Scanner scanner1 = new Scanner(System.in);
    // This initializes the Public String variable usernameEntered.
    public String usernameEntered;
    // This initializes the Public String variable passwordEntered.
    public String passwordEntered;

    // This is the constructor for the UserLogin class. It inherits the loginType variable from the Login class.
    public UserLogin(String loginType) {
        super(loginType);
    }

    // This is used to print the login option that the user chose.
    public void printLoginType() {
        System.out.println("\nYou have decided to login as a " + getLoginType() + ".");
    }

    // This is used to ask the user for its name. This method then recursively calls itself using the name variable.
    public void askForName() {
        System.out.println("Enter name:");
        // This uses the scanner object to assign what is entered by the user to the name variable.
        String name = scanner1.nextLine();    
        askForName(name);
    }

    // This is the method that is called recursively from the first askForName method. It uses the name variable.
    private void askForName(String name) {
        // This line prints a buffer.
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("\nWelcome, " + name + ", to my application!");
        System.out.println("Please provide your login information below.");
    }

    // This is a public string method that asks the user for their username and then returns that username.
    public String askForUsername(){
        System.out.println("\nEnter Username:");
        // This uses the scanner object to assign what is entered by the user to the usernameEntered variable.
        usernameEntered = scanner1.nextLine();
        return usernameEntered;
    }

    // This is a public string method that asks the user for their password and then returns that password.
    public String askForPassword(){
        System.out.println("\nEnter Password:");
        // This uses the scanner object to assign what is entered by the user to the passwordEntered variable.
        passwordEntered = scanner1.nextLine();
        return passwordEntered;
    }
}

// This is the GuestLogin class. It is derived from the Login class.
class GuestLogin extends Login {
    // This creates a scanner object for the GuestLogin class.
    Scanner scanner2 = new Scanner(System.in);

    // This is the constructor for the GuestLogin class. It inherits the loginType variable from the Login class.
    public GuestLogin(String loginType) {
        super(loginType);
    }

    // This is used to print the login option that the user chose.
    public void printLoginType() {
        System.out.println("\nYou have decided to login as a " + getLoginType() + ".");
    }

    // This is used to ask the user for its name. This method then recursively calls itself using the name variable.
    public void askForName() {
        System.out.println("Enter name:");
        // This uses the scanner object to assign what is entered by the user to the name variable.
        String name = scanner2.nextLine();
        askForName(name);
    }

    // This is the method that is called recursively from the first askForName method. It uses the name variable.
    private void askForName(String name) {
        // This line prints a buffer.
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("\nWelcome, " + name + ", to my application!");
    }
}

// This is the LoginLogic class. It is used to handle the logic of the login process.
class LoginLogic {
    // This creates a scanner object for the LoginLogic class.
    Scanner scanner3 = new Scanner(System.in);
    // This is the startLogin method where all of the logic for the login process in contained.
    public void startLogin() {
        // This label is used for the while loop that loops through the two different login options.
        outer:
        // This while loop is used to print the two different login options for the user.
        while (true) {
            // Lines 228-230 print the login options to the user.
            System.out.println("\nPlease choose a login option (1 or 2)");
            System.out.println("1. User Login");
            System.out.println("2. Guest Login");
            // This assigns what is entered by the user to the loginOption string variable.
            String loginOption = scanner3.nextLine();
            // This if statement occurs when the user enters "1" and decides to log in as a user.
            if (Objects.equals(loginOption, "1")) {
                // This creates a userLogin object from the UserLogin class. It sets the login type to "User".
                UserLogin userLogin = new UserLogin("User");
                // This uses the userLogin object to set the username to "ParkerJ02".
                userLogin.setUsername("ParkerJ02");
                // This uses the userLogin object to set the passoword to "123abc".
                userLogin.setPassword("123abc");
                // This uses the userLogin object to use the printLoginType method to print the login type.
                userLogin.printLoginType();
                // This uses the userLogin object to use the askForName method to ask the user for their name.
                userLogin.askForName();
                // This label contains a while loop that loops through the user login process.
                inner:
                // This while loop loops through the user login process.
                while (true) {
                    // This uses the userLogin object to ask the user for their username.
                    userLogin.askForUsername();
                    // This if statement occurs when the user enters the correct username.
                    if (Objects.equals(userLogin.usernameEntered, userLogin.getUsername())) {
                        // This uses the userLogin object to ask the user for their password.
                        userLogin.askForPassword();
                        // This if statement occurs when the user enters the correct password.
                        if (Objects.equals(userLogin.passwordEntered, userLogin.getPassword())) {
                            // This line prints a buffer.
                            System.out.println("\n-----------------------------------------------------------------");
                            // This creates a fileEditing object from the FileEditing class.
                            FileEditing fileEditing = new FileEditing();
                            // This uses the fileEditing object to start the file editing process.
                            fileEditing.startFileEditing();
                            // This breaks out of everything within the outer label.
                            break outer;
                        }
                        // This else statement occurs when the user enters the incorrect input.
                        else {
                            // This prints a message telling the user that they entered the incorrect password.
                            System.out.println("\nError: Incorrect password");
                            // This prints a message asking the user if they want to try logging in again.
                            System.out.println("Would you like to try again? (Y = Yes, N = No)");
                            // This assigns what is entered by the user to the again string variable.
                            String again = scanner3.nextLine();
                            // This if statement occurs if the user enters anything other than y.
                            if (!again.equalsIgnoreCase("y")) {
                                // This is used to break out of the inner loop for logging in as a user.
                                break inner;
                            }
                        }
                        // This else statement occurs when the user enters the incorrect username.
                    } else {
                        // This prints a message telling the user that they entered the incorrect username.
                        System.out.println("\nError: Incorrect username");
                        // This prints a message asking the user if they want to try logging in again.
                        System.out.println("Would you like to try again? (Y = Yes, N = No)");
                        // This assigns what is entered by the user to the again string variable.
                        String again = scanner3.nextLine();
                        // This if statement occurs if the user enters anything other than y.
                        if (!again.equalsIgnoreCase("y")) {
                            // This is used to break out of the inner loop for logging in as a user.
                            break inner;
                        }
                    }
                }
                // This if statement occurs when the user enters "2" and decides to log in as a guest.
            } else if (Objects.equals(loginOption, "2")) {
                // This creates a guestLogin object from the GuestLogin class. It sets the login type to "Guest".
                GuestLogin guestLogin = new GuestLogin("Guest");
                // This uses the guestLogin object to use the printLoginType method to print the login type.
                guestLogin.printLoginType();
                // This uses the guestLogin object to use the askForName method to ask the user for their name.
                guestLogin.askForName();
                // This creates an object called fileEditing from the FileEditing class.
                FileEditing fileEditing = new FileEditing();
                // This uses the fileEditing object to start the file editing process.
                fileEditing.startFileEditing();
                // This breaks out of everything within the outer label.
                break outer;
                // This else statement occurs when the user enters an incorrect input.
            } else {
                // This prints a message to the user telling them that they entered the incorrect value.
                System.out.println("\nError: You entered the incorrect value.");
                // This prints a message providing options for the user.
                System.out.println("Would you like to try again? (Y = Yes, N = No)");
                // This assigns what is entered by the user to the again string variable.
                String again = scanner3.nextLine();
                // This if statement occurs if the user enters anything other than y.
                if (!again.equalsIgnoreCase("y")) {
                    // This line prints a buffer.
                    System.out.println("\n-----------------------------------------------------------------");
                    // This is used to print an exit message for the user.
                    System.out.println("\n  *** Thank you for using my application! ***");
                    // This breaks out of everything within the outer label.
                    break outer;
                }
            }
        }
    }
}

// This is the FileEditing class. It is used to allow the user to edit the Notes.txt file.
class FileEditing {
    // This creates a scanner object for the LoginLogic class.
    Scanner scanner4 = new Scanner(System.in);
    // This is the method that allows the user to edit, add on to, and view their notes/Notes.txt file.
    // The user can also close the application here using this method.
    public void startFileEditing() {
        // Lines 292-294 are used for printing the options that the user has for their notes.
        System.out.println("\nNow that you have logged in you can create brand new notes, add");
        System.out.println("notes, view your notes, and exit the application.");
        System.out.println("\nWARNING: Selecting 'Create New Notes' will erase past notes.");
        // This line prints a buffer.
        System.out.println("\n-----------------------------------------------------------------");
        // This label is used for looping through the notes options for the user.
        fileLoop:
        // This is a while loop that allows the user to do different things with their notes/Notes.txt.
        while (true) {
            // Lines 302-306 are used to print the options that the user has for their notes/Notes.txt.
            System.out.println("\nPlease enter your option. (1, 2, 3, or 4)");
            System.out.println("1. Create New Notes");
            System.out.println("2. Add Notes");
            System.out.println("3. View Notes");
            System.out.println("4. Exit Application");
            // This assigns what is entered by the user to the fileOption string variable.
            String fileOption = scanner4.nextLine();
            // This if statement occurs when the user enters "1" and decides to create new notes.
            if (fileOption.equals("1")) {
                System.out.println("\nPlease enter new text below");
                // This assigns what is entered by the user to the newText string variable.
                String newText = scanner4.nextLine();
                // This try statement is used to create new notes.
                try {
                    // This creates a buffered writer object that uses file writer that uses the Notes.txt file.
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Notes.txt"));
                    // This uses the writer object to write the new text to the Notes.txt file.
                    writer.write(newText);
                    // This closes the writer after the new text has been written to the file.
                    writer.close();
                    // This is a catch statement that will throw an exception if the Notes.txt file is inaccessible.
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // This else if statement occurs when the user enters "2" and decides to add notes.
            } else if (fileOption.equals("2")) {
                // This label is used for looping the user through the append loop.
                appendLoop:
                // This is a while loop that allows the user to add on multiple lines of notes for the Notes.txt file.
                while (true) {
                    System.out.println("\nPlease enter append text below");
                    // This assigns what is entered by the user to the appendText string variable.
                    String appendText = scanner4.nextLine();
                    // This try statement is used to append notes.
                    try {
                        // This makes the string variable correctText equal to the appendText plus a line skip.
                        String correctText = ("\n" + appendText);
                        // This creates the output writer object.
                        Writer output;
                        // This sets the output writer object equal to a buffered writer object that uses file writer that uses the Notes.txt file.
                        // The boolean variable true is also used to open the file in append mode.
                        output = new BufferedWriter(new FileWriter("Notes.txt", true));
                        // This uses the output object to append the Notes.txt file with string correctText.
                        output.append(correctText);
                        // This closes the output writer object.
                        output.close();
                        System.out.println("\nWould you like to add more text? (Y = Yes, N = No)");
                        // This assigns what is entered by the user to the again string variable.
                        String again = scanner4.nextLine();
                        // This if statement occurs when the user decides to break out of the append loop.
                        if (!again.equalsIgnoreCase("y")) {
                            // This is used to break out of the append loop.
                            break appendLoop;
                        }
                        // This is a catch statement that will throw an exception if the Notes.txt file is inaccessible.
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                // This else if statement occurs when the user enters "3" and decides to view notes.
            } else if (fileOption.equals("3")) {
                try {
                    // This creates a buffered reader object that uses file reader that uses the Notes.txt file.
                    BufferedReader reader = new BufferedReader(new FileReader("Notes.txt"));
                    // This creates a string variable called line.
                    String line;
                    // This line prints a buffer before the contents of the notes.
                    System.out.println("\n------------------------ Notes Contents ------------------------");
                    // This while loop is used to print each line of the Notes.txt file.
                    // When the line variable contains nothing (or null) the while loop stops printing.
                    while ((line = reader.readLine()) != null) {
                        // This prints the string that is contained within the line string variable.
                        System.out.println(line);
                    }
                    reader.close();
                    // This line prints a buffer after the contents of the notes.
                    System.out.println("----------------------------------------------------------------");
                    // This is a catch statement that will throw an exception if the Notes.txt file is inaccessible.
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // This else if statement occurs when the user enters "4" and decides to exit the application.
            } else if (fileOption.equals("4")) {
                // This line prints a buffer.
                System.out.println("\n------------------------------------------------");
                // This is used to print an exit message for the user.
                System.out.println("\n  *** Thank you for using my application! ***");
                // This is used to break out of the loop that allows the user to interact with the Notes.txt file.
                break fileLoop;
                // This else statement occurs when the user enters an invalid input.
            } else {
                // This is a message that lets the user know that they entered an invalid input.
                System.out.println("\nError: You entered the incorrect value.");
                System.out.println("Would you like to try again? (Y = Yes, N = No)");
                // This assigns what is entered by the user to the again string variable.
                String again = scanner4.nextLine();
                // This if statement occurs when the user decides to no longer use the application.
                if (!again.equalsIgnoreCase("y")) {
                    // This line prints a buffer.
                    System.out.println("\n------------------------------------------------");
                    // This is used to print an exit message for the user.
                    System.out.println("\n  *** Thank you for using my application! ***");
                    // This is used to break out of the loop that allows the user to interact with the Notes.txt file.
                    break fileLoop;
                }
            }
        }
    }
}

// This is the Main class. This is the first class that the program looks at upon startup.
public class Main {
    // This is the main method. This is the first method that the program looks at upon startup.
    public static void main(String[] args) {
        // This creates an app object from the App class.
        App app = new App();
        // The app object is used to run the startApp method that starts the application.
        app.startApp();
    }
}
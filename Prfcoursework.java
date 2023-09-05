import java.util.Scanner;
public class Main {
    private static final String USERNAME = "vihanga";
    private static String PASSWORD = "v";
    private static String[][] suppliers = {{"S001","Amal"},{"S002","Kamal"}};//new String[0][2];

    private static String[] addItemCategory = {"FOOD","MEDICINE","bandage","painki"};//new String[0];

    private static String[][] addItem = {{"I001","S001","FOOD","Toffee","150","500"},{"I002","S002","MEDICINE","penadol","50","500"},{"I003","S002","MEDICINE","painki","20","500"},{"I004","S001","MEDICINE","bandage","100","500"}};//new String[0][5];

    boolean flag = false;
    private static Scanner scanner = new Scanner(System.in);
    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
           
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        showLoginPage();
    }

    private static void showLoginPage(){
        clearConsole();
        System.out.println("             +-----------------------------------------+");
        System.out.println("             |               LOGIN PAGE                |");
        System.out.println("             +-----------------------------------------+");

        System.out.println("\nPlease enter your username and password to login.");


        while(true){
            System.out.print("\nUsername : ");
            String username = scanner.next();
            if (username.equals(USERNAME)) {
                break;
            }
            System.out.print("Invalid username !");
        }
        while(true){
            System.out.print("\nPassword : ");
            String password = scanner.next();
            if (password.equals(PASSWORD)) {
                break;
            }
            System.out.print("Invalid Password !");
        }
        clearConsole();
        showHomePage();
    }

    private static void showHomePage() {
        while (true) {
            System.out.println("\n            +-----------------------------------------+");
            System.out.println("            | Welcome To Ijse  Manegement System      |");
            System.out.println("            +-----------------------------------------+");

            System.out.println();
            System.out.println("1. \tChange Credentials \t2. Supplier Manage");
            System.out.println("3. \tLog out \t\t4. Stock Management");
            System.out.println("5. \tExit the System");
            System.out.println();
            System.out.print("Enter your option (1-5): ");
            int option = scanner.nextInt();

            L3:  switch (option) {
                case 1:
                    changeCredentials();
                    break;
                case 2:
                    supplierManage();
                    break;
                case 3:
                    showLoginPage();
                    break;
                case 4:
                    stockManage();
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void changeCredentials() {
        clearConsole();
        System.out.println("\n              +-----------------------+");
        System.out.println("              |   Change Password     |");
        System.out.println("              +-----------------------+");

        while (true) {
            System.out.print("Enter your username: ");
            String username = scanner.next();

            if (username.equals(USERNAME)) {
                break;
            } else {
                System.out.println("Invalid username! Please try again.");
            }
        }

        while (true) {
            System.out.print("Enter your current password: ");
            String password = scanner.next();

            if (password.equals(PASSWORD)) {
                break;
            } else {
                System.out.println("Invalid password! Please try again.");
            }
        }

        while (true) {
            System.out.print("Enter your new password: ");
            String newPassword = scanner.next();
            PASSWORD = newPassword;
            System.out.println("Password changed successfully!");
            System.out.print("Do You want to Go Homepage (y/n) :");
            char choice = scanner.next().charAt(0);
            if(choice=='Y'||choice=='y' ){
                clearConsole();
                showHomePage();
                break;
            }
        }
    }



    public static void supplierManage() {
        while (true) {
            clearConsole();
            System.out.println("\n            +-----------------------------------------+");
            System.out.println("            |     Spoiler Manegemen System            |");
            System.out.println("            +-----------------------------------------+");

            System.out.println("\n\t1. Add Supplier\t\t2. Update Supplier");
            System.out.println("\t3. Delete Supplier\t4. View Suppliers");
            System.out.println("\t5. Search Supplier\t6. Back Home Page");

            System.out.println();
            System.out.print("Enter your option (1-6): ");
            int option = scanner.nextInt();


            switch (option) {
                case 1:
                    addSupplier();
                    break;
                case 2:
                    updateSupplier();
                    break;
                case 3:
                    deleteSupplier();
                    break;
                case 4:
                    viewSuppliers();
                    break;
                case 5:
                    searchSupplier();
                    break;
                case 6:
                    clearConsole();
                    showHomePage();
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    public static void addSupplier() {
        clearConsole();
        System.out.println("\n            +-----------------------------------------+");
        System.out.println("            |              Add Supplier               |");
        System.out.println("            +-----------------------------------------+");

        while(true){

            System.out.print("Enter supplier ID: ");
            String supplierId = scanner.next();
            boolean isSupplierExist = false;
            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i][0].equals(supplierId)) {
                    isSupplierExist = true;
                    System.out.println("Supplier is already exists!");
                    break;
                }
            }

            if (!isSupplierExist) {
                growSupplier();
                suppliers[suppliers.length-1][0]=supplierId;
                System.out.print("Enter Supplier Name :");
                suppliers[suppliers.length-1][1]=scanner.next();
                System.out.println("Supplier added successfully!");

                System.out.print("Do you want to add a new supplier? (Y/N): ");
                char choice = scanner.next().charAt(0);
                if(choice=='N'||choice=='n' ){
                    supplierManage();
                    break;
                }
            }

        }
    }
    public static void growSupplier(){
        String[][] temp = new String[suppliers.length+1][2];
        for (int i= 0; i < suppliers.length; i++) {
            for (int j = 0; j < suppliers[i].length; j++) {
                temp[i][j]=suppliers[i][j];
            }
        }
        suppliers=temp;
    }
    public static void updateSupplier() {
        clearConsole();
        System.out.println("\n            +-----------------------------------------+");
        System.out.println("            |            Update Supplier               |");
        System.out.println("            +-----------------------------------------+");

        boolean updateSuppliers = true;

        while (updateSuppliers) {
            System.out.print("Enter supplier ID: ");
            String supplierId = scanner.next();

            boolean isSupplierFound = false;
            int supplierIndex = -1;


            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i][0].equals(supplierId)) {
                    isSupplierFound = true;
                    supplierIndex = i;
                    break;
                }
            }

            if (isSupplierFound) {
                System.out.println("\tSupplier Details:\n");
                System.out.println("Supplier ID: " + suppliers[supplierIndex][0]);
                System.out.println("Supplier name: " + suppliers[supplierIndex][1]);

                System.out.println("\n\tEnter new details:");

                System.out.print("\nEnter supplier name: ");
                String newUsername = scanner.next();

                suppliers[supplierIndex][1] = newUsername;
                System.out.println("Supplier updated successfully!");
            } else {
                System.out.println("Supplier with ID  not found!");
            }

            System.out.print("\nDo you want to update another supplier? (Y/N): ");
            char choice = scanner.next().charAt(0);
            if(choice=='N'||choice=='n' ){
                supplierManage();
                updateSuppliers=false;
            }
        }
    }


    private static void deleteSupplier() {

        do {
            clearConsole();
            System.out.println("\n            +-----------------------------------------+");
            System.out.println("            |           Delete Supplier                |");
            System.out.println("            +-----------------------------------------+");

            System.out.print("Enter supplier ID: ");
            String supplierId = scanner.next();

            boolean isSupplierFound = false;
            int supplierIndex = -1;

            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i][0].equals(supplierId)) {
                    isSupplierFound = true;
                    supplierIndex = i;
                    break;
                }
            }

            if (isSupplierFound) {
                System.out.println("Supplier Details:");
                System.out.println("Supplier ID: " + suppliers[supplierIndex][0]);
                System.out.println("Supplier Username: " + suppliers[supplierIndex][1]);

                for (int i = supplierIndex; i < suppliers.length- 1; i++) {
                    suppliers[i][0] = suppliers[i + 1][0];
                    suppliers[i][1] = suppliers[i + 1][1];
                }
                System.out.println("Supplier deleted successfully!");
            } else {
                System.out.println("Supplier Id not found!");
            }

            System.out.print("Do you want to delete another supplier? (Y/N): ");
            char choice = scanner.next().charAt(0);
            if (choice=='N'||choice=='n')
            {
                supplierManage();
                break;
            }

        } while(true);

        System.out.println("Exiting supplier deletion!");
    }

    private static void viewSuppliers() {
        clearConsole();
        System.out.println("\n                      +-----------------------------------------+");
        System.out.println("                      |           View Suppliers                |");
        System.out.println("                      +-----------------------------------------+");
        System.out.println();
        System.out.println();
        if (suppliers.length == 0) {
            System.out.println("No suppliers found!");
        } else {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|\tSupplier ID\t|\tSupplier Username\t|");
            System.out.println("+-------------------------------------------------------+");
            for (int i = 0; i <suppliers.length; i++) {


                System.out.println("|\t"+suppliers[i][0]+"\t\t|\t"+suppliers[i][1]+"\t\t\t|");
            }
        }
        System.out.println("+-------------------------------------------------------+");
        System.out.print("\nDo you want to go supplier manage page ? (Y/N): ");
        char choice = scanner.next().charAt(0);
        if (choice=='Y'||choice=='y')
        {
            supplierManage();
        }
    }

    private static void searchSupplier() {
        clearConsole();
        System.out.println("\n            +-----------------------------------------+");
        System.out.println("            |            Search Supplier               |");
        System.out.println("            +-----------------------------------------+");
        while(true){
            System.out.print("Enter supplier ID: ");
            String supplierId = scanner.next();

            boolean isSupplierFound = false;

            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i][0].equals(supplierId)) {
                    System.out.println("\nSupplier Details:");
                    System.out.println("Supplier ID: " + suppliers[i][0]);
                    System.out.println("Supplier Username: " + suppliers[i][1]);
                    isSupplierFound = true;
                    break;
                }
            }

            if (!isSupplierFound) {
                System.out.println("Supplier ID  not found!");
            }
            System.out.print("\nDo you want to go supplier manage page ? (Y/N): ");
            char choice = scanner.next().charAt(0);
            if (choice=='Y'||choice=='y')
            {
                supplierManage();
                break;
            }
        }
    }


    private static void stockManage() {
        clearConsole();
        while (true) {
            System.out.println("\n            +-----------------------------------------+");
            System.out.println("            | Welcome To Ijse Stock Manegement System |");
            System.out.println("            +-----------------------------------------+");

            System.out.println("\n\t1. Manege item Categaories\t\t2. Add Item");
            System.out.println("\t3. Get Item Suppler Wise\t\t4. View Item");
            System.out.println("\t5. Rank Item per Unit Price\t\t6. Home Page");

            System.out.print("Enter your option: ");
            int option = scanner.nextInt();


            switch (option) {
                case 1:
                    manegeItem();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    getItemSuppler();
                    break;
                case 4:
                    viewItem();
                    break;
                case 5:
                    rankItem();
                    break;
                case 6 :
                    clearConsole();
                    showHomePage();
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

    }

    private static void manegeItem() {
        while (true) {
            clearConsole();
            System.out.println("\n            +-----------------------------------------+");
            System.out.println("            |        Manage Item Categories           |");
            System.out.println("            +-----------------------------------------+");
            System.out.println("\n\t1. Add Categary   \t\t2. Update Categary");
            System.out.println("\t3. Delete Categary   \t\t4. Stock Manege");


            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItemCategory();
                    break;
                case 2:
                    updateItemCategory();
                    break;
                case 3:
                    deleteItemCategory();
                    break;
                case 4:
                    stockManage();
                case 5 :

                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

        }
    }


    public static void addItemCategory() {
        clearConsole();
        System.out.println("\n            +-----------------------------------------+");
        System.out.println("            |                Add Item                 |");
        System.out.println("            +-----------------------------------------+");

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the new item category: ");
            String category = input.next();

            boolean categoryExists = false;

            for (int i = 0; i < addItemCategory.length; i++) {
                if (category.equals(addItemCategory[i])) {
                    System.out.println("Category already exists! Please enter a new item category.\n");
                    categoryExists = true;
                    break;
                }
            }

            if (!categoryExists) {
                addItemCategory = growitem(addItemCategory);
                for (int i = 0; i < addItemCategory.length; i++) {
                    if (addItemCategory[i] == null) {
                        addItemCategory[i] = category;
                        System.out.print("added successfully! Do you want to add another category (Y/N)? ");
                        String answer = input.next();
                        if (answer.equalsIgnoreCase("Y") || answer.equals("y")) {
                            addItemCategory();
                        } else if (answer.equalsIgnoreCase("N") || answer.equals("n")) {
                            clearConsole();
                            manegeItem();
                        }
                        return;
                    }
                }
            }
        }
    }

    public static String[] growitem(String[] arr) {
        String[] temp = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    public static void updateItemCategory(){
        clearConsole();
        System.out.println("\n            +-----------------------------------------+");
        System.out.println("            |              Update Item                |");
        System.out.println("            +-----------------------------------------+");
        while (true) {
            System.out.print("item category     :  ");
            String category = scanner.next();

            for (int i = 0; i < addItemCategory.length; i++) {
                if (category.equals(addItemCategory[i])) {

                    System.out.print("Enter the new category name : ");
                    String newCategoryName=scanner.next();

                    addItemCategory[i] = newCategoryName;
                    System.out.print("Update Successfully! Do you want to update another category? (Y/N) ");
                    char choice = scanner.next().charAt(0);
                    if (choice == 'Y' || choice == 'y') {
                        updateItemCategory();
                        break;
                    } else if (choice == 'N' || choice == 'n') {
                        clearConsole();
                        manegeItem();
                    }

                }
            }
            System.out.println("Can't find category. try again!\n");
        }
    }


    public static void deleteItemCategory(){
        clearConsole();
        System.out.println("\n            +-----------------------------------------+");
        System.out.println("            |              Delete Item                |");
        System.out.println("            +-----------------------------------------+");
        while(true){
            System.out.print("Item category     :  ");
            String category = scanner.next();

            for (int i = 0; i < addItemCategory.length; i++) {
                if (category.equals(addItemCategory[i])) {

                    addItemCategory[i]=null;

                    System.out.print("delete successfully! Do you want to delete another category (Y/N) ");
                    char choice = scanner.next().charAt(0);
                    if (choice == 'Y' || choice == 'y') {
                        clearConsole();
                        deleteItemCategory();
                        break;
                    } else if (choice == 'N' || choice == 'n') {
                        clearConsole();
                        manegeItem();
                    }
                }
            }
            System.out.println("Can't find category. try again!\n");

        }
    }
    public static void growItem() {
        String[][] temp = new String[addItem.length + 1][6];
        for (int i = 0; i < addItem.length; i++) {
            for (int j = 0; j < addItem[i].length; j++) {
                temp[i][j] = addItem[i][j];
            }
        }
        addItem = temp;
    }

    public static void addItem() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tADD ITEM Categary\t\t");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println();

        while (true) {
            if (addItemCategory.length < 1) {
                System.out.println("OOPS! It seems that you don't have any item categories in this system.");
                System.out.print("Do you want to add a new item category (Y/N)? ");
                char choice = scanner.next().charAt(0);
                if (choice == 'Y' || choice == 'y') {
                    addItemCategory();
                    break;
                } else if (choice == 'N' || choice == 'n') {
                    stockManage();
                    break;
                }
            }

            if (suppliers.length < 1) {
                System.out.println("OOPS! It seems that you don't have any suppliers in this system.");
                System.out.print("Do you want to add a new supplier (Y/N)? ");
                char choice = scanner.next().charAt(0);
                if (choice == 'Y' || choice == 'y') {
                    addSupplier();
                    break;
                } else if (choice == 'N' || choice == 'n') {
                    stockManage();
                    break;
                }

            }

            while (true) {
                boolean flag = false;
                System.out.print("Item Code: ");
                String ic = scanner.next();

                for (int i = 0; i < addItem.length; i++) {
                    if (ic.equals(addItem[i][0])) {
                        System.out.println("Item code already exists. Try again!");
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    growItem();
                    addItem[addItem.length - 1][0] = ic;

                    System.out.println("Supplier list:");
                    System.out.println("+---------------------------------------------------------------+");
                    System.out.println("|\t#\t|\tSUPPLIER ID\t|\tSUPPLIER NAME\t|");
                    System.out.println("+---------------------------------------------------------------+");
                    for (int i = 0; i < suppliers.length; i++) {
                        System.out.println("|\t" + (i + 1) + "\t|\t" + suppliers[i][0] + "\t\t|\t" + suppliers[i][1] + "\t\t|");
                    }
                    System.out.println("+---------------------------------------------------------------+");

                    System.out.println();
                    System.out.print("Enter the supplier number > ");
                    int index = scanner.nextInt();
                    addItem[addItem.length - 1][1] = suppliers[index - 1][0];

                    System.out.println("Item categories:");
                    System.out.println("+---------------------------------------+");
                    System.out.println("|\t#\t|\tCATEGORY NAME\t|");
                    System.out.println("+---------------------------------------+");
                    for (int i = 0; i < addItemCategory.length; i++) {
                        System.out.println("|\t" + (i + 1) + "\t|\t" + addItemCategory[i] + "\t\t|");
                    }
                    System.out.println("+---------------------------------------+");
                    System.out.println();
                    System.out.print("Enter the category number > ");
                    index = scanner.nextInt();
                    addItem[addItem.length - 1][2] = addItemCategory[index - 1];
                    System.out.println();
                    System.out.print("Description: ");
                    addItem[addItem.length - 1][3] = scanner.next();
                    System.out.print("Unit Price: ");
                    addItem[addItem.length - 1][4] = scanner.next();
                    System.out.print("Qty On Hand: ");
                    addItem[addItem.length - 1][5] = scanner.next();
                    System.out.print("Added successfully! Do you want to add another item (Y/N)? ");
                    char choice = scanner.next().charAt(0);
                    if (choice == 'Y' || choice == 'y') {
                        addItem();
                        break;
                    } else if (choice == 'N' || choice == 'n') {
                        stockManage();
                        break;
                    }
                }
            }
        }
    }

    public static void getItemSuppler() {
        clearConsole();
        System.out.println("                +---------------------------------------------------------------+");
        System.out.println("                |\t\tGET ITEMS BY SUPPLIER \t\t\t        |");
        System.out.println("                +---------------------------------------------------------------+\n");

        if (suppliers.length < 1) {
            System.out.println("OOPS! It seems that you don't have any suppliers in this system.");
            System.out.print("Do you want to add a new supplier (Y/N)? ");
            char ch = scanner.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                addSupplier();
            } else {
                stockManage();
                return;
            }
        
        }else{
            System.out.print("Enter the supplier Id :  ");
            String id = scanner.next();
            int index=-1;
            boolean flag = false;
            for (int i = 0; i < suppliers.length; i++){
				if (id.equals(suppliers[i][0])){
					flag=true;
					index=i;
					break;
				}
			}
			
			if (flag){
				System.out.println();
				System.out.println("Supplier Name : " + suppliers[index][1]);
				System.out.println("+------------------------------------------------------------------------------------------------------------------+");
				System.out.println("| Item Code     \t|\t Category    \t| Description    \t| Unit Price    \t| Qty On Hand        |");
				System.out.println("+------------------------------------------------------------------------------------------------------------------+");
				for (int i = 0; i < addItem.length; i++) {
					if (id.equals(addItem[i][1])) {
						System.out.println("|\t" + addItem[i][0] + "\t\t|\t  " + addItem[i][2] + "\t\t|  " + addItem[i][3] + "\t\t|  " + addItem[i][4] + "   \t\t|  " + addItem[i][5] + "\t\t    |");
					}
				}
				System.out.println("+------------------------------------------------------------------------------------------------------------------+");
				System.out.println();
				System.out.print("Search Succesfull . Do you want to another search (Y/N)? ");
				char choice = scanner.next().charAt(0);
				if (choice == 'Y' || choice == 'y') {
					getItemSuppler();
				} else if (choice == 'N' || choice == 'n') {
					stockManage();
				} else {
					System.out.println("Invalid choice. Returning to Stock Management Menu...");
					stockManage();
				}
			}else{
				System.out.println("Invalid supplier id !");
				System.out.print("Do you want to another search (Y/N)? ");
				char choice = scanner.next().charAt(0);
				if (choice == 'Y' || choice == 'y') {
					getItemSuppler();
				} else if (choice == 'N' || choice == 'n') {
					stockManage();
				} else {
					System.out.println("Invalid choice. Returning to Stock Management Menu...");
					stockManage();
				}
            }
            
            
		}
    }



    public static void viewItem() {
        clearConsole();
        System.out.println("\n            +-----------------------------------------+");
        System.out.println("            |              View Item                   |");
        System.out.println("            +-----------------------------------------+");
        System.out.println();
        System.out.println();
        if (addItem.length == 0) {
            System.out.println("No items found!");
        } else {
			
			for (int i = 0; i < addItemCategory.length; i++){
				System.out.println(addItemCategory[i]+" \n");
				System.out.println("+---------------------------------------------------------------------------------------------------------------+");
				System.out.println("|\tItem ID\t|\tItem Name\t|\tDESC  \t\t|\tQuantity\t|\tUnit Price\t|");
				System.out.println("+---------------------------------------------------------------------------------------------------------------+");
				for (int j = 0; j < addItem.length; j++){
					if (addItem[j][2]==addItemCategory[i]){
							System.out.println("|\t" + addItem[j][0] + "\t|\t" + addItem[j][1] + "\t\t|\t" + addItem[j][3] + "\t\t|\t" + addItem[j][4] + "\t\t|\t "+ addItem[j][5] +" \t\t|");
					}
				}
				System.out.println("+---------------------------------------------------------------------------------------------------------------+\n");
				
			}
			
            
            
        }
        System.out.print("\nDo you want to go back to stock management page? (Y/N): ");
        char choice = scanner.next().charAt(0);
        if (choice == 'Y' || choice == 'y') {
            stockManage();
            
		}
	}

    public static void rankItem() {
		clearConsole();
        System.out.println("\n            +-----------------------------------------+");
        System.out.println("            |           Ranked Unit Price             |");
        System.out.println("            +-----------------------------------------+");
        System.out.println();
		int []temp = new int [addItem.length];
		
		for (int i = 0; i < addItem.length; i++){
			temp[i]=Integer.parseInt(addItem[i][4]);
		}
		for (int i = 0; i < temp.length; i++){
			for (int j = 0; j < temp.length-1; j++){
				if (temp[j]>temp[j+1]){
					int ar = temp[j];
					temp[j] = temp[j+1];
					temp[j+1] = ar;
				}
			}
		}
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|\tItem ID\t|\tItem Name\t|\tDESC  \t\t|\tQuantity\t|\tUnit Price\t|\tCategary\t|");
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------+");
		for (int i = 0; i < temp.length; i++){
			for (int j = 0; j < addItem.length; j++){
				if (temp[i]==Integer.parseInt(addItem[j][4])){
					System.out.println("|\t" + addItem[j][0] + "\t|\t" + addItem[j][1] + "\t\t|\t" + addItem[j][3] + "\t\t|\t" + addItem[j][4] + "\t\t|\t "+ addItem[j][5] +" \t\t|\t" +addItem[j][2] + "\t\t|");
				}
			}
			
		}
		System.out.println("+----------------------------------------------------------------------------------------------------------------------------------+");
			System.out.print("\nDo you want to go back to stock management page? (Y/N): ");
			char choice = scanner.next().charAt(0);
				if (choice == 'Y' || choice == 'y') {
					getItemSuppler();
				} else if (choice == 'N' || choice == 'n') {
					stockManage();
		}
	}
}


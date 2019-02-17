import java.util.Scanner;

public class Group {

    private final int MAX_STUDENT = 10;
    private int studentСounter = 0;
    Student[] group = new Student[MAX_STUDENT];
    Scanner scanner = new Scanner(System.in);


    public void addStudent() {
        if (studentСounter <= MAX_STUDENT - 1) {
            group[studentСounter] = Student.createStudent();
            studentСounter++;
        } else {
            System.out.println("ГРУППА ПОЛНАЯ!");
        }
    }


    public void deleteStudent() {
        System.out.println("Введите номер студента для удаления:");
        int studentDelete = scanner.nextInt();
        for (int i = studentDelete; i < studentСounter - 1; i++) {
            group[i] = group[i + 1];
        }
        studentСounter--;
    }


    public void showAllGroup() {
        System.out.println("Всего студентов в группе! " + studentСounter);
        for (int i = 0, x = 1; i <= studentСounter - 1; i++, x++) {
            System.out.println("СТУДЕНТ # " + x);
            group[i].showInfo();
        }
    }


    public void findStudentByLastName() {

        System.out.println("Введите фамилию студента:");
        String studentLastName = scanner.nextLine();
        for (int i = 0, n = 1; i <= studentСounter - 1; i++, n++) {
            if (studentLastName.trim().equals(group[i].getLastName())) {
                System.out.println("Студент найден! Его номер: " + n);
            }
        }
    }

    public void editStudent() {

        Scanner sc = new Scanner(System.in);

        boolean ask = true;
        while (ask) {
            System.out.println("Введите номер студента для редактирования:");
            int studentDelete = scanner.nextInt();
            Student studentEdit = group[studentDelete - 1];
            System.out.println("Что именно вы хотите изменить?");

            System.out.println("-----------------------------------");
            System.out.println("- Изменить Имя: 1");
            System.out.println("- Изменить Фамилию: 2");
            System.out.println("- Изменить Пол: 3");
            System.out.println("- Изменить Возраст: 4");
            System.out.println("- Изменить оценку по программиированию: 5");
            System.out.println("- Изменить оценку по сис. админ: 6");
            System.out.println("- Изменить оценку по дизайну: 7");
            System.out.println("- Выйти в главное меню: 8");
            System.out.println("-----------------------------------");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Введите имя:");
                    String name = sc.nextLine();
                    studentEdit.setName(name);
                    break;
                }
                case 2: {
                    System.out.print("Введите фамилию:");
                    String lastName = sc.nextLine();
                    studentEdit.setLastName(lastName);
                    break;
                }
                case 3: {
                    System.out.print("Введите пол м или ж:");
                    String gender = sc.nextLine();
                    studentEdit.setGender(gender);
                    break;
                }
                case 4: {
                    System.out.print("Введите возраст:");
                    int age = sc.nextInt();
                    studentEdit.setAge(age);
                    break;
                }
                case 5: {
                    System.out.print("Введите оценку по программированию:");
                    int programming = sc.nextInt();
                    studentEdit.setProgramming(programming);
                    break;
                }
                case 6: {
                    System.out.print("Введите оценку по сис Админ:");
                    int systemAdmin = sc.nextInt();
                    studentEdit.setSystemAdmin(systemAdmin);
                    break;
                }
                case 7: {
                    System.out.print("Введите оценку по дизайну:");
                    int design = sc.nextInt();
                    studentEdit.setDesign(design);
                    break;
                }
                case 8: {
                    ask = false;
                    break;
                }
                default: {
                    System.out.println("Ошибка ввода!");
                }
            }
        }
        System.out.println("Студент изменен!");
    }
}

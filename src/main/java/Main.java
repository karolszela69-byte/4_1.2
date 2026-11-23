/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            Service s = new Service();
            Scanner scanner = new Scanner(System.in);
            int wybor = -1;
            while (wybor != 0) {
              System.out.println("\n Opcje wyboru");
              System.out.println("1 Dodaj nowego studenta");
              System.out.println("2 Wypisz listę wszystkich studentów");
              System.out.println("0 Wyjdź");

              wybor = scanner.nextInt();
              scanner.nextLine();

              switch (wybor) {
                case 1:
                  System.out.print("Podaj imię: ");
                  String name = scanner.nextLine();
                  System.out.print("Podaj wiek: ");
                  int age = scanner.nextInt();
                  scanner.nextLine();

                  s.addStudent(new Student(name, age));
                  System.out.println("Dodano studenta");
                  break;

                case 2:
                  var students = s.getStudents();
                  System.out.println("\n Lista studentów: ");
                  for (Student current : students){
                    System.out.println(current.ToString());
                  }
                  break;
                case 3:
                  System.out.println("Koniec programu");
                  break;
                default:
                  System.out.println("Nieznana komenda");
              }
            
          }
          scanner.close();
        } catch (IOException e) {
          System.out.println("Błąd operacji" + e.getMessage());
        }
    }
}
          
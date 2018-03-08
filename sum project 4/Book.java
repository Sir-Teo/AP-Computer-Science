
public class Book { 
String title;
boolean status;
// Creates a new Book
public Book(String bookTitle) { 
title = bookTitle;
}
// Marks the book as rented
public void borrowed() { 
status = false;
}
// Marks the book as not rented
public void returned() { 
status = true;
}
public boolean Available() { 
return status;
}

public String getTitle() {
return title;
}
  
  
  
  

public static void main(String[] arguments) {
Book example = new Book("The Da Vinci Code");
System.out.println("Title: " + example.getTitle()); 
System.out.println("Available?: " + example.Available()); 
example.borrowed();
System.out.println("Available?: " + example.Available()); 
example.returned();
System.out.println("Available?: " + example.Available());
} 

}

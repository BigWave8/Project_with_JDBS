package com.lyndexter.view;

import com.lyndexter.buisnesslogic.model.Apartament;
import com.lyndexter.buisnesslogic.model.ApartamentPhoto;
import com.lyndexter.buisnesslogic.model.ApartamentReserved;
import com.lyndexter.buisnesslogic.model.ApartamentResponse;
import com.lyndexter.buisnesslogic.model.Lessor;
import com.lyndexter.buisnesslogic.model.PaymentTransaction;
import com.lyndexter.buisnesslogic.model.Photo;
import com.lyndexter.buisnesslogic.model.Renter;
import com.lyndexter.buisnesslogic.model.Response;
import com.lyndexter.buisnesslogic.model.ResponsePhoto;
import com.lyndexter.controller.ApartamentController;
import com.lyndexter.controller.ApartamentPhotoController;
import com.lyndexter.controller.ApartamentReservedController;
import com.lyndexter.controller.ApartamentResponseController;
import com.lyndexter.controller.LessorController;
import com.lyndexter.controller.PaymentTransactionController;
import com.lyndexter.controller.PhotoController;
import com.lyndexter.controller.RenterController;
import com.lyndexter.controller.ResponseController;
import com.lyndexter.controller.ResponsePhotoController;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
  private static final String DEFAULT_PATH_IMAGE =
      "C:\\taras\\projects\\MySQL\\Lab_4\\AirBnB\\src\\main\\resources\\sample.png";
  
  private Map<String, String> menu;
  private Map<String, Printable> methodsMenu;
  private final Scanner input;
  
  private final PhotoController photoController;
  private final LessorController lessorController;
  private final ApartamentController apartamentController;
  private final RenterController renterController;
  private final PaymentTransactionController transactionController;
  private final ApartamentReservedController apartamentReservedController;
  private final ResponseController responseController;
  private final ApartamentResponseController apartamentResponseController;
  private final ApartamentPhotoController apartamentPhotoController;
  private final ResponsePhotoController responsePhotoController;
  
  public View() throws SQLException, IOException {
    input = new Scanner(System.in, StandardCharsets.UTF_8);
    
    photoController = new PhotoController();
    lessorController = new LessorController();
    apartamentController = new ApartamentController();
    renterController = new RenterController();
    transactionController = new PaymentTransactionController();
    apartamentReservedController = new ApartamentReservedController();
    responseController = new ResponseController();
    apartamentResponseController = new ApartamentResponseController();
    apartamentPhotoController = new ApartamentPhotoController();
    responsePhotoController = new ResponsePhotoController();
    
    menu = new LinkedHashMap<>();
    methodsMenu = new LinkedHashMap<>();
    
    menu.put("A", "A-Select all table");
    
    methodsMenu.put("A", this::printAllTables);
    
    //Menu for Photo
    menu.put("1", "1-Table:Photo");
    menu.put("11", "11-Find all photos");
    menu.put("12", "12-Find photo by id");
    menu.put("13", "13-Create photo");
    menu.put("14", "14-Update photo");
    menu.put("15", "15-Delete photo");
    
    methodsMenu.put("11", this::printPhotoTable);
    methodsMenu.put("12", this::printRowFromPhotoById);
    methodsMenu.put("13", this::createNewPhoto);
    methodsMenu.put("14", this::updatePhoto);
    methodsMenu.put("15", this::deletePhoto);
    
    //Menu for Lessor
    menu.put("2", "2-Table:Lessor");
    menu.put("21", "21-Find all lessors");
    menu.put("22", "22-Find lessor by id");
    menu.put("23", "23-Create lessor");
    menu.put("24", "24-Update lessor");
    menu.put("25", "25-Delete lessor");
    
    methodsMenu.put("21", this::printLessorTable);
    methodsMenu.put("22", this::printRowFromLessorById);
    methodsMenu.put("23", this::createNewLessor);
    methodsMenu.put("24", this::updateLessor);
    methodsMenu.put("25", this::deleteLessor);
    
    //Menu for Apartament
    menu.put("3", "3-Table:Apartament");
    menu.put("31", "31-Find all apartaments");
    menu.put("32", "32-Find apartament by id");
    menu.put("33", "33-Create apartament");
    menu.put("34", "34-Update apartament");
    menu.put("35", "35-Delete apartament");
    
    methodsMenu.put("31", this::printApartamentTable);
    methodsMenu.put("32", this::printRowFromApartamentById);
    methodsMenu.put("33", this::createNewApartament);
    methodsMenu.put("34", this::updateApartament);
    methodsMenu.put("35", this::deleteApartament);
    
    //Menu for Renter
    menu.put("4", "4-Table:Renter");
    menu.put("41", "41-Find all renters");
    menu.put("42", "42-Find renter by id");
    menu.put("43", "43-Create renter");
    menu.put("44", "44-Update renter");
    menu.put("45", "45-Delete renter");
    
    methodsMenu.put("41", this::printRenterTable);
    methodsMenu.put("42", this::printRowFromRenterById);
    methodsMenu.put("43", this::createNewRenter);
    methodsMenu.put("44", this::updateRenter);
    methodsMenu.put("45", this::deleteRenter);
    
    //Menu for Response
    menu.put("5", "5-Table:Response");
    menu.put("51", "51-Find all responses");
    menu.put("52", "52-Find response by id");
    menu.put("53", "53-Create response");
    menu.put("54", "54-Update response");
    menu.put("55", "55-Delete response");
    
    methodsMenu.put("51", this::printResponseTable);
    methodsMenu.put("52", this::printRowFromResponseById);
    methodsMenu.put("53", this::createNewResponse);
    methodsMenu.put("54", this::updateResponse);
    methodsMenu.put("55", this::deleteResponse);
    
    //Menu for PaymentTransaction
    menu.put("6", "6-Table:PaymentTransaction");
    menu.put("61", "61-Find all paymentTransactions");
    menu.put("62", "62-Find paymentTransaction by id");
    menu.put("63", "63-Create paymentTransaction");
    menu.put("64", "64-Update paymentTransaction");
    menu.put("65", "65-Delete paymentTransaction");
    
    methodsMenu.put("61", this::printPaymentTransactionTable);
    methodsMenu.put("62", this::printRowFromPaymentTransactionById);
    methodsMenu.put("63", this::createNewPaymentTransaction);
    methodsMenu.put("64", this::updatePaymentTransaction);
    methodsMenu.put("65", this::deletePaymentTransaction);
    
    //Menu for ApartamentReserved
    menu.put("7", "7-Table:ApartamentReserved");
    menu.put("71", "71-Find all apartamentReserveds");
    menu.put("72", "72-Find apartamentReserved by id");
    menu.put("73", "73-Create apartamentReserved");
    menu.put("74", "74-Update apartamentReserved");
    menu.put("75", "75-Delete apartamentReserved");
    
    methodsMenu.put("71", this::printApartamentReservedTable);
    methodsMenu.put("72", this::printRowFromApartamentReservedById);
    methodsMenu.put("73", this::createNewApartamentReserved);
    methodsMenu.put("74", this::updateApartamentReserved);
    methodsMenu.put("75", this::deleteApartamentReserved);
    
    //Menu for ApartamentPhoto
    menu.put("8", "8-Table:ApartamentPhoto");
    menu.put("81", "81-Find all apartamentPhotos");
    menu.put("82", "82-Find apartamentPhoto by id");
    menu.put("83", "83-Create apartamentPhoto");
    menu.put("84", "84-Update apartamentPhoto");
    menu.put("85", "85-Delete apartamentPhoto");
    
    methodsMenu.put("81", this::printApartamentPhotoTable);
    methodsMenu.put("82", this::printRowFromApartamentPhotoById);
    methodsMenu.put("83", this::createNewApartamentPhoto);
    methodsMenu.put("84", this::updateApartamentPhoto);
    methodsMenu.put("85", this::deleteApartamentPhoto);
    
    //Menu for ApartamentResponse
    menu.put("9", "9-Table:ApartamentResponse");
    menu.put("91", "91-Find all apartamentResponses");
    menu.put("92", "92-Find apartamentResponse by id");
    menu.put("93", "93-Create apartamentResponse");
    menu.put("94", "94-Update apartamentResponse");
    menu.put("95", "95-Delete apartamentResponse");
    
    methodsMenu.put("91", this::printApartamentResponseTable);
    methodsMenu.put("92", this::printRowFromApartamentResponseById);
    methodsMenu.put("93", this::createNewApartamentResponse);
    methodsMenu.put("94", this::updateApartamentResponse);
    methodsMenu.put("95", this::deleteApartamentResponse);
    
    //Menu for ResponsePhoto
    menu.put("B", "B-Table:ResponsePhoto");
    menu.put("B1", "B1-Find all responsePhotos");
    menu.put("B2", "B2-Find responsePhoto by id");
    menu.put("B3", "B3-Create responsePhoto");
    menu.put("B4", "B4-Update responsePhoto");
    menu.put("B5", "B5-Delete responsePhoto");
    
    methodsMenu.put("B1", this::printResponsePhotoTable);
    methodsMenu.put("B2", this::printRowFromResponsePhotoById);
    methodsMenu.put("B3", this::createNewResponsePhoto);
    methodsMenu.put("B4", this::updateResponsePhoto);
    methodsMenu.put("B5", this::deleteResponsePhoto);
    
    menu.put("L", "L-go back");
    menu.put("Q", "Q-exit");
  }
  
  public void show() {
    
    String keyMenu;
    
    do {
      printMenu();
      System.out.println("Please, select point:");
      keyMenu = input.nextLine().toUpperCase();
      while (keyMenu.equals("")) {
        keyMenu = input.nextLine().toUpperCase();
      }
      
      if (keyMenu.matches("(^\\d)|(^B)")) {
        printSubMenu(keyMenu);
        System.out.println("Please select point of menu:");
        keyMenu = input.nextLine().toUpperCase();
        while (keyMenu.equals("")) {
          keyMenu = input.nextLine().toUpperCase();
        }
      }
      
      if (keyMenu.equals("L")) {
        continue;
      }
      if (keyMenu.equals("Q")) {
        break;
      }
      
      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception throwables) {
        System.out.println("Can't execute command");
        System.out.println("Expresion is " + throwables.getMessage());
      }
      
    } while (true);
    
  }
  
  private void printMenu() {
    System.out.print("\n\nMenu:\n");
    for (Map.Entry<String, String> item : menu.entrySet()) {
      if (item.getKey().length() == 1 && !item.getValue().equals("L")) {
        System.out.println(item.getValue());
      }
    }
  }
  
  private void printSubMenu(String fig) {
    System.out.println("\n\nSubMenu:\n");
    for (Map.Entry<String, String> item : menu.entrySet()) {
      if (item.getValue().length() != 1 && item.getValue().substring(0, 1).equals(fig)
          || item.getValue().equals("L") || item.getValue().equals("Q")) {
        System.out.println(item.getValue());
      }
    }
  }
  
  
  private int readPhotoId() {
    System.out.println("\nPlease type id of element:");
    return Integer.parseInt(input.nextLine());
  }
  
  private Photo readPhoto() throws IOException {
    
    System.out.println("\nPlease write type of photo:");
    final String inputType = input.nextLine();
    
    System.out.println("Insert image path:");
    String inputPath = input.nextLine();
    byte[] inputImage;
    try {
      File fi = new File(inputPath);
      inputImage = Files.readAllBytes(fi.toPath());
    } catch (IOException e) {
      System.out.println("Your path is invalid: insert default value");
      File fi = new File(DEFAULT_PATH_IMAGE);
      inputImage = Files.readAllBytes(fi.toPath());
    }
    System.out.println("Write image size:");
    final String inputSize = input.nextLine();
    
    System.out.println("Write name of photo:");
    final String inputName = input.nextLine();
    
    return new Photo(0, inputType, inputImage, inputSize, inputName);
  }
  
  private void printPhotoTable() throws SQLException {
    List<Photo> photos = photoController.getPhotos();
    System.out.print("\n\nPhoto\n");
    System.out
        .format("%3s    %-12s %-20s %-10s %-24s%n", "id", "type", "image", "imageSize", "name");
    for (Photo photo : photos) {
      System.out.print(photo);
    }
  }
  
  private void printRowFromPhotoById() throws SQLException {
    int inputId = readPhotoId();
    System.out
        .format("%3s    %-12s %-20s %-10s %-24s%n", "id", "type", "image", "imageSize", "name");
    System.out.println(photoController.getPhoto(inputId));
  }
  
  private void createNewPhoto() throws SQLException, IOException {
    Photo photo = readPhoto();
    photoController.setPhoto(photo);
  }
  
  private void updatePhoto() throws SQLException, IOException {
    int inputId = readPhotoId();
    
    Photo photo = readPhoto();
    photo.setId(inputId);
    
    photoController.updatePhoto(photo);
  }
  
  private void deletePhoto() throws SQLException {
    int inputId = readPhotoId();
    
    photoController.removePhoto(inputId);
  }
  
  
  private Lessor readLessor() {
    
    System.out.println("\nPlease write name of lessor:");
    final String inputName = input.nextLine();
    
    System.out.println("Please write surname:");
    final String inputSurname = input.nextLine();
    
    System.out.println("Please write last name:");
    final String inputLastName = input.nextLine();
    
    System.out.println("Please write phone number:");
    final String inputPhoneNumber = input.nextLine();
    
    System.out.println("Please write card number:");
    final String inputCardNumber = input.nextLine();
    
    System.out.println("Please write contact info:");
    final String inputContactInfo = input.nextLine();
    
    System.out.println("Please write photo id:");
    final int inputPhotoId = input.nextInt();
    
    return new Lessor(0, inputName, inputSurname, inputLastName, inputPhoneNumber, inputCardNumber,
        inputContactInfo, inputPhotoId);
    
  }
  
  private int readLessorId() {
    System.out.println("\nPlease write id of lessor:");
    return input.nextInt();
  }
  
  private void printLessorTable() throws SQLException {
    List<Lessor> lessors = lessorController.getLessors();
    System.out.print("\n\nLessor\n");
    System.out
        .format("%3s    %-22s %-22s %-22s %-18s %-19s %-60s %-5s%n", "id", "firstName", "surname",
            "lastName", "phoneNumber", "cardNumber", "contactInfo", "photoId");
    for (Lessor lessor : lessors) {
      System.out.print(lessor);
    }
    
  }
  
  private void printRowFromLessorById() throws SQLException {
    int inputId = readLessorId();
    System.out.print("\n\nLessor\n");
    System.out
        .format("%3s    %-22s %-22s %-22s %-18s %-19s %-60s %-5s%n", "id", "firstName", "surname",
            "lastName", "phoneNumber", "cardNumber", "contactInfo", "photoId");
    System.out.println(lessorController.getLessor(inputId));
  }
  
  private void createNewLessor() throws SQLException {
    Lessor lessor = readLessor();
    lessorController.setLessor(lessor);
  }
  
  private void updateLessor() throws SQLException {
    Lessor lessor = readLessor();
    
    Integer inputId = readLessorId();
    lessor.setId(inputId);
    
    lessorController.putLessor(lessor);
  }
  
  private void deleteLessor() throws SQLException {
    lessorController.removeLessor(readLessorId());
    
  }
  
  
  private Apartament readApartament() {
    System.out.println("Please write adress:");
    final String inputAdress = input.nextLine();
    
    System.out.println("\nPlease write area of apartament:");
    final double inputArea = input.nextDouble();
    
    System.out.println("Please write ceiling high:");
    final double inputCeilingHigh = input.nextDouble();
    
    System.out.println("Please write room number:");
    final int inputRoomNumber = input.nextInt();
    
    System.out.println("Please write recomend people number:");
    final int inputRecomendPeopleCount = input.nextInt();
    
    System.out.println("Please write price:");
    final BigDecimal inputPrice = input.nextBigDecimal();
    
    System.out.println("Please write lessor id:");
    final int inputLessorId = input.nextInt();
    
    return new Apartament(0, inputArea, inputAdress, inputCeilingHigh, inputRoomNumber,
        inputRecomendPeopleCount, inputPrice, inputLessorId);
  }
  
  private Integer readApartamentId() {
    System.out.println("\nPlease write id of Apartament:");
    return input.nextInt();
  }
  
  private void printApartamentTable() throws SQLException {
    List<Apartament> apartaments = apartamentController.getApartaments();
    System.out.print("\n\nApartament\n");
    System.out.format("%3s    %-8s %-60s %-8s %-6s %-6s %-12s %-6s%n", "id", "area", "adress",
        "ceilingHigh", "roomNumber", "recommendPeopleCount", "priceInUAH", "lessor_id");
    for (Apartament apartament : apartaments) {
      System.out.print(apartament);
    }
    
  }
  
  private void printRowFromApartamentById() throws SQLException {
    int inputId = readApartamentId();
    System.out.print("\n\nApartament\n");
    System.out.format("%3s    %-8s %-60s %-8s %-6s %-6s %-12s %-6s%n", "id", "area", "adress",
        "ceilingHigh", "roomNumber", "recommendPeopleCount", "priceInUAH", "lessor_id");
    System.out.println(apartamentController.getApartament(inputId));
  }
  
  private void createNewApartament() throws SQLException {
    Apartament apartament = readApartament();
    apartamentController.setApartament(apartament);
  }
  
  private void updateApartament() throws SQLException {
    Apartament apartament = readApartament();
    
    int inputId = readApartamentId();
    apartament.setId(inputId);
    
    apartamentController.putApartament(apartament);
  }
  
  private void deleteApartament() throws SQLException {
    apartamentController.removeApartament(readApartamentId());
  }
  
  
  private Renter readRenter() {
    System.out.println("\nPlease write name of renter:");
    final String inputName = input.nextLine();
    
    System.out.println("Please write surname of renter:");
    final String inputSurname = input.nextLine();
    
    System.out.println("Please write last name:");
    final String inputLastName = input.nextLine();
    
    System.out.println("Please write renter phone number:");
    final String inputPhoneNumber = input.nextLine();
    
    System.out.println("Please write card number:");
    final String inputCardNumber = input.nextLine();
    
    System.out.println("Please write photo id:");
    final int inputPhotoId = input.nextInt();
    
    return new Renter(0, inputName, inputSurname, inputLastName, inputPhoneNumber,
        inputCardNumber, inputPhotoId);
  }
  
  private Integer readRenterId() {
    System.out.println("\nPlease write id of Renter:");
    return input.nextInt();
  }
  
  private void printRenterTable() throws SQLException {
    List<Renter> renters = renterController.getRenters();
    System.out.print("\n\nRenter\n");
    System.out.format("%3s    %-22s %-22s %-22s %-18s %-19s %-5s%n", "id", "firstName", "surname",
        "lastName", "phoneNumber", "cardNumber", "photoId");
    for (Renter renter : renters) {
      System.out.print(renter);
    }
  }
  
  private void printRowFromRenterById() throws SQLException {
    int inputId = readRenterId();
    System.out.print("\n\nRenter\n");
    System.out.format("%3s    %-22s %-22s %-22s %-18s %-19s %-5s%n", "id", "firstName", "surname",
        "lastName", "phoneNumber", "cardNumber", "photoId");
    System.out.println(renterController.getRenter(inputId));
  }
  
  private void createNewRenter() throws SQLException {
    Renter renter = readRenter();
    renterController.setRenter(renter);
  }
  
  private void updateRenter() throws SQLException {
    Renter renter = readRenter();
    
    int inputId = readRenterId();
    renter.setId(inputId);
    
    renterController.putRenter(renter);
  }
  
  private void deleteRenter() throws SQLException {
    renterController.removeRenter(readRenterId());
  }
  
  
  private Response readResponse() {
    System.out.println("\nPlease write comment:");
    final String inputComment = input.nextLine();
    
    System.out.println("Please write rate:");
    final int inputRate = input.nextInt();
    
    return new Response(0, inputComment, inputRate);
  }
  
  private Integer readResponseId() {
    System.out.println("\nPlease write id of Response:");
    return input.nextInt();
  }
  
  private void printResponseTable() throws SQLException {
    List<Response> responses = responseController.getResponses();
    System.out.print("\n\nResponse\n");
    System.out.format("%3s    %-12s %-40s %n", "id", "rate", "coment");
    for (Response response : responses) {
      System.out.print(response);
    }
  }
  
  private void printRowFromResponseById() throws SQLException {
    int inputId = readResponseId();
    System.out.print("\n\nResponse\n");
    System.out.format("%3s    %-12s %-40s %n", "id", "rate", "coment");
    System.out.println(responseController.getResponse(inputId));
  }
  
  private void createNewResponse() throws SQLException {
    Response response = readResponse();
    responseController.setResponse(response);
  }
  
  private void updateResponse() throws SQLException {
    Response response = readResponse();
    response.setId(readResponseId());
    responseController.putResponse(response);
  }
  
  private void deleteResponse() throws SQLException {
    responseController.removeResponse(readResponseId());
  }
  
  
  private PaymentTransaction readPaymentTransaction() {
    System.out.println("\nPlease write renter id:");
    final int inputRenterId = input.nextInt();
    
    System.out.println("Please write lessor id");
    final int inputLessorId = input.nextInt();
    
    System.out.println("Please write renter_payment(true/false):");
    final Boolean inputRenterPayment = input.nextBoolean();
    
    System.out.println("Please write lessor recieve money or not:");
    final Boolean inputLessorRecieveMonet = input.nextBoolean();
    
    return new PaymentTransaction(0, inputRenterId, inputLessorId, inputRenterPayment,
        inputLessorRecieveMonet);
  }
  
  private Integer readPaymentTransactionId() {
    System.out.println("\nPlease write id of PaymentTransactions:");
    return input.nextInt();
  }
  
  private void printPaymentTransactionTable() throws SQLException {
    List<PaymentTransaction> paymentTransactions = transactionController.getPaymentTransactions();
    System.out.print("\n\nPatmentTransection\n");
    System.out.format("%3s    %-8s %-8s %-10s %-10s%n", "id", "renterId",
        "lessorId", "renterPayment", "LessorRecieveMoney");
    for (PaymentTransaction paymentTransaction : paymentTransactions) {
      System.out.print(paymentTransaction);
    }
    
  }
  
  private void printRowFromPaymentTransactionById() throws SQLException {
    int inputId = readResponseId();
    System.out.print("\n\nPatmentTransection\n");
    System.out.format("%3s    %-8s %-8s %-10s %-10s%n", "id", "renterId",
        "lessorId", "renterPayment", "LessorRecieveMoney");
    System.out.println(transactionController.getPaymentTransaction(inputId));
  }
  
  private void createNewPaymentTransaction() throws SQLException {
    transactionController.setPaymentTransaction(readPaymentTransaction());
  }
  
  private void updatePaymentTransaction() throws SQLException {
    PaymentTransaction paymentTransaction = readPaymentTransaction();
    
    paymentTransaction.setId(readPaymentTransactionId());
    transactionController.putPaymentTransaction(paymentTransaction);
  }
  
  private void deletePaymentTransaction() throws SQLException {
    transactionController.removePaymentTransaction(readResponseId());
  }
  
  
  private ApartamentReserved readApartamentReserved() {
    System.out.println("\nPlease write apartament id:");
    final int inputApartamentId = input.nextInt();
    
    System.out.println("Please if it is reserved(true/false)");
    final Boolean inputReserved = input.nextBoolean();
    
    System.out.println("Please write payment transaction id:");
    final int inputLessorPaymentTransaction = input.nextInt();
    
    System.out.println("Please write wish to apartament:");
    final String inputWish = input.nextLine();
    
    return new ApartamentReserved(0, inputApartamentId, inputReserved, inputWish,
        inputLessorPaymentTransaction);
  }
  
  private Integer readApartamentReservedId() {
    System.out.println("\nPlease write id of ApartamentReserved:");
    return input.nextInt();
  }
  
  private void printApartamentReservedTable() throws SQLException {
    List<ApartamentReserved> apartamentReserveds =
        apartamentReservedController.getApartamentReserveds();
    System.out.print("\n\nApartamentReserved\n");
    System.out.format("%3s    %-12s %-10s %-10s %-40s %n", "id", "apartamentId", "reserved",
        "paymentTransactionId", "wish");
    for (ApartamentReserved apartamentReserved : apartamentReserveds) {
      System.out.print(apartamentReserved);
    }
  }
  
  private void printRowFromApartamentReservedById() throws SQLException {
    int inputId = readApartamentReservedId();
    System.out.print("\n\nApartamentReserved\n");
    System.out.format("%3s    %-12s %-10s %-10s %-40s %n", "id", "apartamentId", "reserved",
        "paymentTransactionId", "wish");
    System.out
        .println(apartamentReservedController.getApartamentReserved(inputId));
  }
  
  private void createNewApartamentReserved() throws SQLException {
    apartamentReservedController.setApartamentReserved(readApartamentReserved());
  }
  
  private void updateApartamentReserved() throws SQLException {
    ApartamentReserved apartamentReserved = readApartamentReserved();
    apartamentReserved.setId(readApartamentReservedId());
    apartamentReservedController.putApartamentReserved(apartamentReserved);
  }
  
  private void deleteApartamentReserved() throws SQLException {
    apartamentReservedController.removeApartamentReserved(readApartamentReservedId());
  }
  
  
  private ApartamentPhoto readApartamentPhoto() {
    System.out.println("\nPlease write photo id:");
    final int inputPhotoId = input.nextInt();
    
    System.out.println("\nPlease write apartament id:");
    final int inputApartamentId = input.nextInt();
    
    return new ApartamentPhoto(inputPhotoId, inputApartamentId);
  }
  
  private Integer readApartamentPhotoId() {
    System.out.println("\nPlease write apartament id:");
    return input.nextInt();
  }
  
  private void printApartamentPhotoTable() throws SQLException {
    
    List<ApartamentPhoto> apartamentPhotos = apartamentPhotoController.getApartamentPhotos();
    System.out.print("\n\nApartamentPhoto\n");
    System.out.format("%3s    %-12s %n", "photoId", "apartamentId");
    for (ApartamentPhoto apartamentPhoto : apartamentPhotos) {
      System.out.print(apartamentPhoto);
    }
  }
  
  private void printRowFromApartamentPhotoById() throws SQLException {
    int inputId = readApartamentPhotoId();
    System.out.print("\n\nApartamentPhoto\n");
    System.out.format("%3s    %-12s %n", "photoId", "apartamentId");
    System.out.println(apartamentPhotoController.getApartamentPhoto(inputId));
  }
  
  private void createNewApartamentPhoto() throws SQLException {
    apartamentPhotoController.setApartamentPhoto(readApartamentPhoto());
  }
  
  private void updateApartamentPhoto() throws SQLException {
    ApartamentPhoto apartamentPhoto = readApartamentPhoto();
    apartamentPhotoController.putApartamentPhoto(apartamentPhoto);
  }
  
  private void deleteApartamentPhoto() throws SQLException {
    apartamentPhotoController.removeApartamentPhoto(readApartamentPhotoId());
  }
  
  
  private ApartamentResponse readApartamentResponse() {
    System.out.println("\nPlease write id of apartament:");
    final int inputApartamentId = input.nextInt();
    
    System.out.println("\nPlease write id of response:");
    final int inputResponseId = input.nextInt();
    
    return new ApartamentResponse(inputResponseId, inputApartamentId);
    
  }
  
  private Integer readApartamentResponseId() {
    System.out.println("\nPlease write id of response:");
    return input.nextInt();
  }
  
  private void printApartamentResponseTable() throws SQLException {
    List<ApartamentResponse> apartamentResponses =
        apartamentResponseController.getApartamentResponses();
    System.out.print("\n\nApartamentResponse\n");
    System.out.format("%3s    %-12s %n", "responseId", "apartamentId");
    for (ApartamentResponse apartamentResponse : apartamentResponses) {
      System.out.print(apartamentResponse);
    }
    
  }
  
  private void printRowFromApartamentResponseById() throws SQLException {
    int inputId = readApartamentResponseId();
    System.out.print("\n\nApartamentResponse\n");
    System.out.format("%3s    %-12s %n", "responseId", "apartamentId");
    System.out
        .println(apartamentResponseController.getApartamentResponse(inputId));
    
  }
  
  private void createNewApartamentResponse() throws SQLException {
    apartamentResponseController.setApartamentResponse(readApartamentResponse());
  }
  
  private void updateApartamentResponse() throws SQLException {
    ApartamentResponse apartamentResponse = readApartamentResponse();
    apartamentResponseController.putApartamentResponse(apartamentResponse);
  }
  
  private void deleteApartamentResponse() throws SQLException {
    apartamentResponseController.removeApartamentResponse(readApartamentResponseId());
    
  }
  
  
  private ResponsePhoto readResponsePhoto() {
    System.out.println("\nPlease write id of photo:");
    final int inputPhotoId = input.nextInt();
    
    System.out.println("\nPlease write id of response:");
    final int inputResponseId = input.nextInt();
    
    return new ResponsePhoto(inputPhotoId, inputResponseId);
    
  }
  
  private Integer readResponsePhotoId() {
    System.out.println("\nPlease write id of response:");
    return input.nextInt();
  }
  
  private void printResponsePhotoTable() throws SQLException {
    
    List<ResponsePhoto> responsePhotos = responsePhotoController.getResponsePhotos();
    System.out.print("\n\nResponsePhoto\n");
    System.out.format("%3s    %-12s %n", "photoId", "responseId");
    for (ResponsePhoto responsePhoto : responsePhotos) {
      System.out.print(responsePhoto);
    }
    
  }
  
  private void printRowFromResponsePhotoById() throws SQLException {
    int inputId = readResponsePhotoId();
    System.out.print("\n\nResponsePhoto\n");
    System.out.format("%3s    %-12s %n", "photoId", "responseId");
    System.out.println(responsePhotoController.getResponsePhoto(inputId));
  }
  
  private void createNewResponsePhoto() throws SQLException {
    responsePhotoController.setResponsePhoto(readResponsePhoto());
  }
  
  private void updateResponsePhoto() throws SQLException {
    ResponsePhoto responsePhoto = readResponsePhoto();
    responsePhotoController.putResponsePhoto(responsePhoto);
  }
  
  private void deleteResponsePhoto() throws SQLException {
    responsePhotoController.removeResponsePhoto(readResponsePhotoId());
  }
  
  
  private void printAllTables() throws SQLException {
    printPhotoTable();
    printLessorTable();
    printApartamentTable();
    printRenterTable();
    printResponseTable();
    printPaymentTransactionTable();
    printApartamentReservedTable();
    printApartamentPhotoTable();
    printApartamentResponseTable();
    printResponsePhotoTable();
  }
  
}
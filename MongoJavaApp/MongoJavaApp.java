/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mongojavaapp;

/**
 *
 * @author Manohar
 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MongoJavaApp {
    public static void main(String[] args) {
        String filePath = "D:\\MongoJavaApp\\src\\main\\java\\com\\mycompany\\mongojavaapp\\access.log";
        String dbName = "mydb";
        String collectionName = "access";

        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase(dbName);
        MongoCollection<Document> collection = database.getCollection(collectionName);

        // Read and parse log file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy", Locale.ENGLISH);

            while ((line = reader.readLine()) != null) {
                Document logEntry = parseLogEntry(line, dateFormat);
                if (logEntry != null) {
                    collection.insertOne(logEntry);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the MongoDB connection
        mongoClient.close();
    }

private static Document parseLogEntry(String line, SimpleDateFormat dateFormat) {
    String[] parts = line.split(" ");

    if (parts.length < 10) {
        return null; // Invalid log entry format
    }

    String ipAddress = parts[0];
    String rawDate = parts[3].substring(1); // Remove the leading "[" character
    String webpage = parts[6].replaceAll("\"", ""); // Remove the surrounding quotes from the webpage field

    int statusCode;
    if ("-".equals(parts[parts.length - 2])) {
        statusCode = 0; // Or any other default value we want to use
    } else {
        statusCode = Integer.parseInt(parts[parts.length - 2]);
    }

    int responseSize;
    if ("-".equals(parts[parts.length - 1])) {
        responseSize = 0; // Or any other default value we want to use
    } else {
        responseSize = Integer.parseInt(parts[parts.length - 1]);
    }

    // Parse the date in the specified format
    Date timestamp;
    try {
        timestamp = dateFormat.parse(rawDate);
    } catch (ParseException e) {
        return null; // Invalid timestamp format
    }

    // Format the date as "dd/MM/yyyy"
    SimpleDateFormat formattedDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = formattedDateFormat.format(timestamp);

    Document logEntry = new Document();
    logEntry.append("ip_address", ipAddress)
            .append("date", formattedDate)
            .append("webpage", webpage)
            .append("status_code", statusCode)
            .append("response_size", responseSize);

    return logEntry;
}
}

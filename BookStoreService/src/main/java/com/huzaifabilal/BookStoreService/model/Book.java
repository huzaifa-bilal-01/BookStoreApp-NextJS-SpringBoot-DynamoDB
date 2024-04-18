package com.huzaifabilal.BookStoreService.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "BOOK_INFO")
public class Book {
    @DynamoDBHashKey(attributeName = "BookID")
    private String bookID;
    @DynamoDBAttribute(attributeName = "BookTitle")
    private String bookTitle;
    @DynamoDBAttribute(attributeName = "BookImageURL")
    private String bookImageURL;
    @DynamoDBAttribute(attributeName = "BookPrice")
    private Double bookPrice;
}

package com.cos.jwtex01.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class review {
private int id;
private int productId;
private String title;
private String content;
private int userId;
private Timestamp createDate;
private int star;
private String img;
private boolean existenceOfImg;
private int orderId;
}

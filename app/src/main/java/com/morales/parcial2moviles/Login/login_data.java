package com.morales.parcial2moviles.Login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Karla on 04/06/2018.
 */

public class login_data {

   //Declaramos id
   @SerializedName("_id")
   private String id;

   //Declaramos fecha
   @SerializedName("created_date")
   private String date;

   @SerializedName("__v")
   private int v;


   private String Token;
   private String user;
   private String password;

   //Constructor usado para login el cual solo recibe un usuario y contrasenia
   public login_data(String user, String password) {
      this.user = user;
      this.password = password;
   }

   //SETTERS Y GETTERS

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public int getV() {
      return v;
   }

   public void setV(int v) {
      this.v = v;
   }

   public String getToken() {
      return Token;
   }

   public void setToken(String token) {
      Token = token;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
